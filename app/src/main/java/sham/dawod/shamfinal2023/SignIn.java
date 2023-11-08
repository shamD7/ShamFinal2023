package sham.dawod.shamfinal2023;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        etEmail= findViewById(R.id.etEmailO);
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
}
