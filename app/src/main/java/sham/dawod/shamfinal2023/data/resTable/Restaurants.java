package sham.dawod.shamfinal2023.data.resTable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import sham.dawod.shamfinal2023.R;
import sham.dawod.shamfinal2023.favoriteRes;
import sham.dawod.shamfinal2023.profile;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
    }
    public void showPopUpMenu(View v)
    {
        //بناء قائمة popup menu
        PopupMenu popup=new PopupMenu(this,v);//لكائن الذي سبب فتح القائمة
        //ملف القائمة
        popup.inflate(R.menu.popup_menu);
        //اضافة معالج حدث لاختيار عنصر من القائمة
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.itemFavorite) {

                    Intent i = new Intent(Restaurants.this, favoriteRes.class);
                    startActivity(i);
                }
                if(menuItem.getItemId()==R.id.itemProfile) {

                    Intent i = new Intent(Restaurants.this, profile.class);
                    startActivity(i);
                }

                return true;
            }

        });
        popup.show();//فتح وعرض القائمة

    }

}