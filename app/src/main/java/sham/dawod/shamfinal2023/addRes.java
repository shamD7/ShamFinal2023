package sham.dawod.shamfinal2023;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class addRes extends AppCompatActivity
{
    private TextView etRName;
    private TextInputEditText etPhoneNum;
    private TextInputEditText etLocation;
    private TextInputEditText etWorkHours;
    private Button btnRestMnue;
    private Button btnSaveR;
    private Button btnCancelR;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_res);
        etRName=findViewById(R.id.etRName);
        etPhoneNum=findViewById(R.id.etPhoneNum);
        etLocation=findViewById(R.id.etLocation);
        etWorkHours=findViewById(R.id.etWorkHours);
        btnRestMnue=findViewById(R.id.btnRestMnue);
        btnSaveR=findViewById(R.id.btnSaveR);
        btnCancelR=findViewById(R.id.btnCancelR);
    }
    public void checktask()
    {
        boolean isAllOk = true;
        String Rname = etRName.getText().toString();
        String Rphonenum = etPhoneNum.getText().toString();
        String Rlocation = etLocation.getText().toString();
        String RworkHours = etWorkHours.getText().toString();
        if (Rname.length() < 0) {
            isAllOk = false;
            etRName.setError("Wrong Name");
        }
        if (Rphonenum.length() < 0) {
            isAllOk = false;
            etPhoneNum.setError("Wrong shortTitle");
        }
        if (Rlocation.length() < 0) {
            isAllOk = false;
            etLocation.setError("Wrong shortTitle");
        }
        if (RworkHours.length() < 0) {
            isAllOk = false;
            etWorkHours.setError("Wrong shortTitle");
        }
        if (isAllOk)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }


    }














}