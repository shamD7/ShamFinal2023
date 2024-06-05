package sham.dawod.shamfinal2023;

import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sham.dawod.shamfinal2023.data.AppDatabase;

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
        setContentView(R.layout.add_res);
        etRName=findViewById(R.id.etRName);
        etPhoneNum=findViewById(R.id.etRPhoneNum);
        etLocation=findViewById(R.id.etLocationR);
        etWorkHours=findViewById(R.id.etWorkHoursR);
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
        if (isAllOk) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();



                AppDatabase db = AppDatabase.getDB(getApplicationContext());
                //بناء مهمة جديد وتحديد صفاتها
                //Restaurants task=new Restaurants();
                //Restaurants
                //Restaurants.text=textTask;
                //Restaurants.shortTitle=subjText;
                //Restaurants.subjId=subject.key_id; //تحديد رقم الموضوع للمهمة
                //db.RestaurantQuery().insertAll(task);//اضافة مهمة للجدول
                //finish();


        }


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override //   معالجة حدث اختيار عنصر من القائمة
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.itmSettings)
        {

        }
        if (item.getItemId() == R.id.itmAddRes)
        {
            Intent i = new Intent(addRes.this, addRes.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemLogOut)
        {

        }

        return true;
    }






}