package sham.dawod.shamfinal2023;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignIn extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSighIn;
    private Button btnSighUp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        etEmail= findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSighIn= findViewById(R.id.btnSignIn);
        btnSighUp=findViewById(R.id.btnSighUp);


    }

    /**
     * دالة لمعالجة حدث الضغط على كائن بمواجهة المستعمل.
     * على سبيل المثال ر للكائن الذي سبب الحدث
     */

    public void onClickSignUp(View v)
    {
        Intent i= new Intent(SignIn.this, SignUp.class);
        startActivity(i);


    }
    public void onClickSignIn (View v)
    {
        checkEmailPassw();

    }

    private  void checkEmailPassw()
    {
        boolean isALLOK=true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email=etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password =etPassword.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if(email.length()< 10 || email.contains("@")==false);
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if(password.length()<8 || password.contains("")==true);
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPassword.setError("Wrong Password");
        }
        if(isALLOK);
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();
        }





    }

}
