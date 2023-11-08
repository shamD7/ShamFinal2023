package sham.dawod.shamfinal2023;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        etEmail=(TextInputEditText) findViewById(R.id.etEmailO);
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

}