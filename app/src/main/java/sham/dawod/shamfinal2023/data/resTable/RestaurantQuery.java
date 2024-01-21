package sham.dawod.shamfinal2023.data.resTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/** واجهة استعلامات على جدول المعطيات*/

@Dao
public interface RestaurantQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     *@return  قائمة من المطاعم
     */
    @Query("SELECT * FROM Restaurants")
    List<Restaurants> getAllRestaurants();
    /**
     * ادخال مطاعم
     * @param restaurants * مجموعة المطاعم
     */
    @Insert
    void insertAll (Restaurants...restaurants);

    /**
     * تعديل المطاعم
     * @param restaurants * مجموعة المطاعم للتعديل
     */
    @Update
    void update(Restaurants...restaurants);
    /**
     * حذف مطاعم
     * @param restaurants * حذف مطاعم (  حسب المفاتح الرئيسي)
     */

    @Delete
    void deleteRest(Restaurants ... restaurants);
    @Query("DELETE FROM Restaurants WHERE keyid=:id")
    void deleteTask(long id );















}
