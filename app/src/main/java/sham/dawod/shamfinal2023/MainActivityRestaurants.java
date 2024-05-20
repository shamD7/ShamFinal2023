package sham.dawod.shamfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import sham.dawod.shamfinal2023.data.resTable.MyRestaurantAdapter;

public class MainActivityRestaurants extends AppCompatActivity {
    public GridView GridRes;
    private MyRestaurantAdapter ResAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_restaurants);
        GridRes=findViewById(R.id.GridRes);
        ResAdapter=new MyRestaurantAdapter(this,R.layout.res_item_layout);
        GridRes.setAdapter(ResAdapter);


    }
}