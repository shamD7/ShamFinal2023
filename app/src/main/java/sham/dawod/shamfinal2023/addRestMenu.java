package sham.dawod.shamfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addRestMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_rest_menu);
    }



    public void onClickAdd(View v)
    {
        Intent i= new Intent(addRestMenu.this, addDish.class);
        startActivity(i);


    }
}