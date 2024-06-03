package sham.dawod.shamfinal2023;
import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import sham.dawod.shamfinal2023.data.AppDatabase;
import sham.dawod.shamfinal2023.data.usersTable.MyUser;
import sham.dawod.shamfinal2023.data.usersTable.MyUserQuery;
public class SignIn extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSighIn;
    private Button btnSighUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSighIn = findViewById(R.id.btnSignIn);
        btnSighUp = findViewById(R.id.btnSignUp);
    }

    /**
     * دالة لمعالجة حدث الضغط على كائن بمواجهة المستعمل.
     * على سبيل المثال ر للكائن الذي سبب الحدث
     */

    public void onClickSignUp(View v) {
        Intent i = new Intent(SignIn.this, SignUp.class);
        startActivity(i);
    }

    public void onClickSignIn(View v) {

    }

    private void checkEmailPassw() {
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email = etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password = etPassword.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 10 || email.contains("@") == false) ;
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains("") == true) ;
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPassword.setError("Wrong Password");
        }
        if (isALLOK) ;
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();

            //بناء قاعدة بيانات وارجاع المؤشر عليها
            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول
            MyUserQuery userQuery = db.getMyUserQuery();

            // ان لم يكن موجود استدعاء العملبة التي تنفذ الاستعلام الذي يفحص البريد و كلمة المرور ويعيد كائنا ان كان موجود
            MyUser myUse = userQuery.checkEmailPassw(email, password);
            if (myUse == null) //هل لا يوجد كائن حسب الايمل والباسورد
                Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_LONG).show();
            else {
                // ان كان هنالك حساب حساب الايميل والباسورد ننتقل الى الشاشة الرئيسية
                Intent i = new Intent(SignIn.this, MainActivityRestaurants.class);
                startActivity(i);
                //to close current activity
                finish();
            }


        }

    }
    private void checkEmailPassw_FB (){
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email = etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password = etPassword.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 6 || email.contains("@") == false)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK= false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains(" ") == true)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPassword.setError("Wrong Password");
        }
        if (isALLOK) {
            //كائن لعملية التسجيل
            FirebaseAuth auth = FirebaseAuth.getInstance();
            //لدخول للحساب بمساعدة الايميل وكلمة المرور
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override//התגובה שמתקבל מהענן הכניסה בענן
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {//אם הפעולה הצליחה
                        Toast.makeText(SignIn.this, "Signing in", Toast.LENGTH_SHORT).show();
                        //מעבר למסך הראשי
                        //todo change the taget screen to main activty
                        Intent i = new Intent(SignIn.this, profile.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(SignIn.this, "Signing in Failed", Toast.LENGTH_SHORT).show();
                        etEmail.setError(task.getException().getMessage());//הצגת הודעת השגיה שהקבלה מהענן
                    }
                }
            });
        }
    }
}







