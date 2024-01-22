package sham.dawod.shamfinal2023.data.usersTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Entity=Table=جدول
@Entity //نضعها عندما نريد ان نتعامل مع هذه الفئة كجدول معطيات
public class MyUser {
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي ينتج بشكل تلقائي
    public long keyid;
    @ColumnInfo(name = "fullName") //اعطاء اسم جديد للعامود (الصفة في الجدول)
    /** اسم المستخدم */
    public String fullName;
    /** البريد الاكتروني للمستخدم*/
    public String email;// بحالة لم يتم اعطاء اسم للعامود يكون اسم الصفة هو اسم العامود
    /**رقم هاتف المستخدم */
    public String phone;
    /**كلمة مرور المستخدم*/
    public String passw;

    @Override
    public String toString() {
        return "MyUser{" +
                "keyid=" + keyid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }

}