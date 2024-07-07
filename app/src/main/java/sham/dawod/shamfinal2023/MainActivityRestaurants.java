package sham.dawod.shamfinal2023;
import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

import sham.dawod.shamfinal2023.data.resTable.MyRestaurantAdapter;
import sham.dawod.shamfinal2023.data.resTable.Restaurants;
public class MainActivityRestaurants extends AppCompatActivity {
    private GridView GridRes;
    private MyRestaurantAdapter ResAdapter;
    private Spinner spnrRes;
    private FloatingActionButton fabAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_restaurants);//
        GridRes = findViewById(R.id.GridRes);
        ResAdapter = new MyRestaurantAdapter(this, R.layout.res_item_layout);
        GridRes.setAdapter(ResAdapter);// ربط الوسيط بمركب مرئي لعرض مجموعة معطيات
    }

    @Override
    protected void onResume() {
        super.onResume();
        readTaskFrom_FB();
    }

    /**
     * قراءة معطيات من مبنى المعطيات
     * تسجيل المعطيات التي قرأناها من مبنى المعطيات
     *
     * @return
     */
    public  void onAddRes(View v) {
        Intent i = new Intent(      MainActivityRestaurants.this, addRes.class);
        startActivity(i);
    }


    public void readTaskFrom_FB() {
        //בניית רשימה ריקה
        ArrayList<Restaurants> arrayList = new ArrayList<>();
        //קבלת הפנייה למסד הנתונים
        FirebaseFirestore ffRef = FirebaseFirestore.getInstance();
        ffRef.collection("MyRestaurants")
                //הוספת מאזין לקריאת הנתונים
                       .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    /**
                     * תגובה לאירוע השלמת קריאת הנתונים
                     * @param task הנתונים שהתקבלו מענן מסד הנתונים
                     */
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {// אם בקשת הנתונים התקבלה בהצלחה
                            //מעבר על כל ה״מסמכים״= עצמים והוספתם למבנה הנתונים
                            for (DocumentSnapshot document : task.getResult().getDocuments()) {
                                //המרת העצם לטיפוס שלו// הוספת העצם למבנה הנתונים
                                arrayList.add(document.toObject(Restaurants.class));
                            }
                            ResAdapter.clear();//ניקוי המתאם מכל הנתונים
                            ResAdapter.addAll(arrayList);//הוספת כל הנתונים למתאם
                        } else {
                            Toast.makeText(MainActivityRestaurants.this, "Error Reading data" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }





    @Override// بناء قائمة

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
        if (item.getItemId() == R.id.itmAddRes)
        {
            Intent i = new Intent(MainActivityRestaurants.this, MainActivityRestaurants.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemLogOut)

        {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
            showYesNoDialig();

        }
        return true;
    }
    public void showYesNoDialig() {
        //جهيز بناء شباك حوار بارمتر مؤشر للنشاط الحالي
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out");//تحديد العنوان
        builder.setMessage("Are you sure?");//تحدي فحوى شباك الحوار
        //النض على الزر ومعالج الحدث
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(MainActivityRestaurants.this, "Signing out", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
        //النض على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(MainActivityRestaurants.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//بناء شباك الحوار
        dialog.show();//عرض الشباك
    }





}






