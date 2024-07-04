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
    /**موقع المطعم */

    public String restLocation;

    public String id ;
    public String uid;

    @Override
    public String toString() {
        return "Restaurants{" +
                "keyid=" + keyid +
                ", image='" + image + '\'' +
                ", restName='" + restName + '\'' +
                ", restPhonenum='" + restPhonenum + '\'' +
                ", restWorkHours='" + restWorkHours + '\'' +
                ", Location='" + restLocation + '\'' +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }


    public String getImage() {
        return image;
    }

    public String getRestName() {
        return restName;
    }

    public String getRestWorkHours() {return restWorkHours;}

    public String getRestPhonenum() {
        return restPhonenum;
    }

    public String getRestLocation() {
        return restLocation;
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRestLocation(String restLocation) {
        this.restLocation = restLocation;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public void setRestPhonenum(String restPhonenum) {
        this.restPhonenum = restPhonenum;
    }

    public void setRestWorkHours(String restWorkHours) {
        this.restWorkHours = restWorkHours;
    }
}



