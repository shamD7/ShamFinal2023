package sham.dawod.shamfinal2023.data.resTable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import sham.dawod.shamfinal2023.data.Location;
import sham.dawod.shamfinal2023.data.RestMenu;

@Entity
/**
 * فئة تمثل مطعم
 */
public class Restaurants
{
    @PrimaryKey(autoGenerate = true)
    /**رقم المطعم*/
    public long keyid;
    /**صورة المطعم*/

    public String image;

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

    public String getImage() {
        return image;
    }

    public String getRestName() {
        return restName;
    }

    public String getRestWorkHours() {
        return restWorkHours;
    }

    public void setRestPhonenum(int restPhonenum) {
        this.restPhonenum = restPhonenum;
    }

    public RestMenu getRestMenu() {
        return restMenu;
    }

    public int getRestPhonenum() {
        return restPhonenum;
    }

    public Location getRestLocation() {
        return restLocation;
    }
}



