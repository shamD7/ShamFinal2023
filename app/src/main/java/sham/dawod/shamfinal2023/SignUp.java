package sham.dawod.shamfinal2023;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import sham.dawod.shamfinal2023.data.usersTable.MyUser;
public class SignUp extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    private TextInputEditText etLocation;
    private Button btnSAVE;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etPassword = (TextInputEditText) findViewById(R.id.etPassword);
        etName = (TextInputEditText) findViewById(R.id.etName);
        etPhone = (TextInputEditText) findViewById(R.id.etPhone);
        btnSAVE = (Button) findViewById(R.id.btnSAVE);
        btnCancel = (Button) findViewById(R.id.btnCancel);}


    public void onClickSave(View v) {
        checkAndSignUP_FB();
    }

    public void onClickCancel(View v) {
        finish();
    }

    /**
     *دالة لفحص البريد الاكتروني وكلمة المرور
     *
     * @return
     */
    private void checkEmailPassw() {
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email = etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password = etPassword.getText().toString();
        // استخراج نص رقم الهاتف
        String Phone = etPhone.getText().toString();
        // استخراج نص الاسم
        String name = etName.getText().toString();
        //استخراج الموقع
        String Location = etLocation.getText().toString();

        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ

        if (email.length() < 10 || email.contains("@") == false)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
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
        if (Phone.length() < 10 || Phone.length() > 10)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPhone.setError("Wrong Phone Number");
        }
        if (name.length() < 1) ;
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل الاسم
            etName.setError("Wrong Name");
        }

        if (isALLOK) ;
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();

        }
    }
    /**
     *دالة لفحص هل تسجيل الدخول صحيح وبناء حساب معfire base
     *
     * @return
     */
        private void checkAndSignUP_FB()
        {
            boolean isALLOK1 = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
            //استخراج النص من حقل الايميل
            String email1 = etEmail.getText().toString();
            // استخراج نص كلمة المرور
            String password1 = etPassword.getText().toString();

            // استخراج نص الاسم

            String name1 = etName.getText().toString();
            // استخراج نص رقم الهاتف

            String phone1 = etPhone.getText().toString();
            //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
            if (email1.length() < 6 || email1.contains("@") == false)
            // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            {
                isALLOK1 = false;
                //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
                etEmail.setError("Wrong Email");
            }
            if (password1.length() < 8 || password1.contains(" ") == true)
            // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            {
                isALLOK1 = false;
                //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
                etPassword.setError("Wrong Password");
            }

            if (phone1.length() < 10)
            // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            {
                isALLOK1 = false;
                //عرض ملاحظة خطأ على الشاشة داخل حقل قم الهاتف
                etPhone.setError("Wrong Phone Number");
            }
            if (name1.length() < 1)
            // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            {
                isALLOK1 = false;
                //عرض ملاحظة خطأ على الشاشة داخل حقل الاسم
                etName.setError("Wrong Name");
            }

            if (isALLOK1) {
                //كائن لعملية التسجيل
                FirebaseAuth auth = FirebaseAuth.getInstance();
                //انشاء حساب بمساعدة الايميل وكلمة المرور
                Task<AuthResult> authResultTask = auth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Signing up Succeeded ", Toast.LENGTH_SHORT).show();
                            saveUser_FB(email1,name1,phone1,password1);
                             //   finish();
                            }
                        else {
                            Toast.makeText(SignUp.this, "Signing up Failed", Toast.LENGTH_SHORT).show();
                            etEmail.setError(task.getException().getMessage());// عرض رسالة الغلط
                        }
                    }
                });


            }
        }
    /**
     *دالة لحفظ الحساب معfire base
     *
     * @return
     */

        private void saveUser_FB(String email ,String name, String phone ,String passw)
        {
            //مؤشر لقاعدة البيانات
            FirebaseFirestore db= FirebaseFirestore.getInstance();
            //استخراج الرقم المميز للمستعمل الذي سجل الدخول لاستعماله كاسم للدوكيومينت
            String uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
            //بناء الكائن الذي سيتم حفظه
            MyUser user = new MyUser();
            user.setEmail(email);
            user.setFullName(name);
            user.setPassw(passw);
            user.setPhone(phone);
            user.setId(uid);
            //اضافة كائن لمجموعة المستعملين ومعالج حدث لفحص نجاح المطلوب
            //معالج حدث لفحص هل تم المطلوب من قاعدة البيانات
            db.collection("MyUsers").document(uid).set(user).addOnCompleteListener(new OnCompleteListener<Void>()
            {
                //دالة معالج الحدث
                @Override
                public void onComplete(@NonNull Task<Void> task)
                {
                    //هل تم تنفيذ المطلوب بنجاح
                    if (task.isSuccessful()){
                        Toast.makeText(SignUp.this, "Succeeded to add User", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignUp.this, MainActivityRestaurants.class);
                        startActivity(i);

                    }
                    else {
                        Toast.makeText(SignUp.this, "Failed to add User", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }


    @Override //   معالجة حدث اختيار عنصر من القائمة
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itmSettings) {

        }
        if (item.getItemId() == R.id.itmAddRes) {
            Intent i = new Intent(SignUp.this, MainActivityRestaurants.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemLogOut) {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
            showYesNoDialig();

        }
        return true;
    }

    public void showYesNoDialig() {
        //جهيز بناء شباك حوار بارمتر مؤشر للنشاط الحالي
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out");//تحديد العنوان
        builder.setMessage("Are you sure?");//تحدي فحوى شباك الحوار
        //النض على الزر ومعالج الحدث
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(SignUp.this, "Signing out", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
        //النض على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(SignUp.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//بناء شباك الحوار
        dialog.show();//عرض الشباك
    }

}
