package sham.dawod.shamfinal2023.data;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import sham.dawod.shamfinal2023.data.usersTable.MyUser;
import sham.dawod.shamfinal2023.data.usersTable.MyUserQuery;

/*
تعريف الجداول ورقم الاصدار
version
عند تغيير اي شي يخص جدول او جداول علينا تغيير رقم الاصدار
ليتم بناء قاعدة البيانات من جديد
*/
@Database(entities = {MyUser.class},version = 1)
/**
 * الفئة المسؤولة عن بناء قاعدة البايانات بكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
public abstract class  AppDatabase extends RoomDatabase
{

    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDatabase db;

    /**
     * يعيد كائن لعمليات جدول المستعملين
     *
     * @return
     */
    public abstract MyUserQuery getMyUserQuery();

    /**
     * يعيد كائن لعمليات جدول الموضيع
     *
     * @return
     */
    public static AppDatabase getDB(Context context)
    {
        if (db == null)
        {
            db = Room.databaseBuilder(context,
                            AppDatabase.class,
                            "shamDataBase")//اسم قاعدة اليانات
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

}
