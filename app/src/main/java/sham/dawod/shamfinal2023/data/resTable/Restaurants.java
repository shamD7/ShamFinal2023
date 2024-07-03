package sham.dawod.shamfinal2023.data.resTable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
    public String restPhonenum;
    /**ساعات عمل المطعم */
    public String restWorkHours;
    /**منيو  المطعم */
    public String restMenu;

    @Override
    public String toString() {
        return "Restaurants{" +
                "keyid=" + keyid +
                ", image='" + image + '\'' +
                ", restName='" + restName + '\'' +
                ", restPhonenum=" + restPhonenum +
                ", restWorkHours='" + restWorkHours + '\'' +
                ", restMenu='" + restMenu + '\'' +
                '}';
    }
    public String getImage() {
        return image;
    }

    public String getRestName() {
        return restName;
    }

    public String getRestWorkHours() {return restWorkHours;}

    public String getRestMenu() {return restMenu;}

    public void setRestPhonenum(int restPhonenum) {
        this.restPhonenum = restPhonenum;
    }

    public int getRestPhonenum() {
        return restPhonenum;
    }

}



