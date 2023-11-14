package sham.dawod.shamfinal2023;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RestaurantMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_main);
    }
    public void onClickResMenu(View v)
    {
        Intent i= new Intent(RestaurantMain.this, ResMenu.class);
        startActivity(i);


    }

}