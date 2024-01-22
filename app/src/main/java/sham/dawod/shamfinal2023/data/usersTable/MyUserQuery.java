package sham.dawod.shamfinal2023.data.usersTable;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
 * واجهه تحوي عمليات /دوال/استعمالات على قاعدة البيانات
 */

@Dao //   لتحديد ان الواجهة تحتوي استعلامات على قاعدة بيانات
public interface MyUserQuery
{

    /**
     * اعادة جميع معطيات جدول المستعمل
     *@return * من قائمة المستعملين
     */
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAll();

    /**
     * اعادة جميع معطيات جدول المستعمل
     *@return * من قائمة المستعملين (  حسب مصفوفة المفاتح الرئيسي)
     */
    @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
    List<MyUser> loadAllByIds(int[] userIds);

    /**
     * اعادة جميع معطيات جدول المستعمل
     *@return * من قائمة المستعملين (  حسب الايميل وكلمة المرور)
     */
    @Query("SELECT * FROM MyUser WHERE email = :myEmail AND " +
            "passw = :myPassw LIMIT 1")
    MyUser checkEmailPassw(String myEmail, String myPassw);

    /**
     * ادخال مستعملين
     * @param users * مجموعة المستعملين
     */
    @Insert
    void insertAll(MyUser... users);
    /**
     * حذف مستعمل
     * @param user * المستعمل
     */
    @Delete
    void delete(MyUser user);
    /**
     * حذف  مستعملين
     * @param * حذف مستعملين (  حسب المفاتح الرئيسي)
     */
    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);
    /**
     * تعديل المستعملين
     * @param users * مجموعة المستعملين للتعديل
     */
    @Update
    void update(MyUser...users);
    /**
     * اعادة جميع معطيات جدول المستعمل
     *@return * من قائمة المستعملين (  حسب الايميل )
     */
    @Query("SELECT * FROM MyUser WHERE email = :myEmail ")
    MyUser checkEmail(String myEmail);
}

