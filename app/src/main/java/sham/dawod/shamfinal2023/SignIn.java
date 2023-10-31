package sham.dawod.shamfinal2023;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        setContentView(R.layout.sign_up);
        setContentView(R.layout.sign_in);
        etEmail= findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSighIn=(Button) findViewById(R.id.btnSignIn);
        btnSighUp=(Button) findViewById(R.id.btnSighUp);

    }
}