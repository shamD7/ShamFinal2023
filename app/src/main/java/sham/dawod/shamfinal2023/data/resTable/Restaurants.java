package sham.dawod.shamfinal2023.data.resTable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import sham.dawod.shamfinal2023.R;
import sham.dawod.shamfinal2023.data.Location;
import sham.dawod.shamfinal2023.data.RestMenu;
import sham.dawod.shamfinal2023.favoriteRes;
import sham.dawod.shamfinal2023.profile;
@Entity
/**
 * فئة تمثل مطعم
 */
public class Restaurants
{
    @PrimaryKey(autoGenerate = true)
    /**رقم المطعم*/
    public long keyid;

    /**اسم المطعم*/
    public String restName;
    /**رقم هاتف المطعم */
    public int restPhonenum;
    /**موقع المطعم*/
    public Location restLocation;
    /**ساعات عمل المطعم */
    public String restWorkHours;
    /** منيو المطعم*/
    public RestMenu restMenu;

    @Override
    public String toString() {
        return "Restaurants{" +
                "restName='" + restName + '\'' +
                ", restPhonenum=" + restPhonenum +
                ", restLocation=" + restLocation +
                ", restWorkHours='" + restWorkHours + '\'' +
                ", restMenu=" + restMenu +
                '}';
    }
}



