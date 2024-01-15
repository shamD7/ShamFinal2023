package sham.dawod.shamfinal2023;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class addRes extends AppCompatActivity
{
    private TextView tvEnter;
    private TextInputEditText etResName;
    private TextInputEditText etPhoneNumber;
    private TextInputEditText etLocatoin;
    private TextInputEditText etWorkingHours;
    private Button btnSaveRes;
    private Button btnCancelRes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_res);
        tvEnter =findViewById(R.id.tvEnter);
        etResName =findViewById(R.id.etResName);
        etPhoneNumber =findViewById(R.id.etPhoneNumber);
        etLocatoin =findViewById(R.id.etLocatoin);
        etWorkingHours =findViewById(R.id.etWorkingHours);
        btnSaveRes =findViewById(R.id.btnSaveRes);
        btnCancelRes=findViewById(R.id.btnCancelRes);

    }
    public void checkText()
    {
        boolean isAllOk=true;
        String ResName= etResName.getText().toString();
        String PhoneNumber= etPhoneNumber.getText().toString();
        String Locatoin= etLocatoin.getText().toString();
        String WorkingHours= etWorkingHours.getText().toString();





    }






}