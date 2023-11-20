package sham.dawod.shamfinal2023;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUp extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputEditText etRepassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    private TextInputEditText etLocation;
    private Button btnSAVE;
    private Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        etEmail=(TextInputEditText) findViewById(R.id.etEmail);
        etPassword=(TextInputEditText)findViewById(R.id.etPassword);
        etName=(TextInputEditText)findViewById(R.id.etName);
        etPhone=(TextInputEditText)findViewById(R.id.etPhone);
        btnSAVE=(Button) findViewById(R.id.btnSAVE);
        btnCancel=(Button) findViewById(R.id.btnCancel);



    }
    public void onClickCancel(View v)
    {

        finish();
    }
    private  void checkEmailPassw()
    {
        boolean isALLOK=true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email=etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password =etPassword.getText().toString();
        // استخراج نص رقم الهاتف
        String Phone =etPhone.getText().toString();
        // استخراج نص الاسم
        String name = etName.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ

        if(email.length()<10 || email.contains("@")==false)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if(password.length()<8 || password.contains(" ")==true)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPassword.setError("Wrong Password");
        }
        if(Phone.length()<10 || Phone.length()>10 )
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPhone.setError("Wrong Phone Number");
        }
        if (name.length() < 1 ) ;
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل الاسم
            etName.setError("Wrong Name");
        }


        if(isALLOK);
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();
        }






    }


}