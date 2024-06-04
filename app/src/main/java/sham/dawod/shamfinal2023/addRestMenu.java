package sham.dawod.shamfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        if (item.getItemId() == R.id.itmProfile)
        {
            Intent i = new Intent(addRestMenu.this, profile.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemLogOut)
        {

        }

        return true;
    }
}