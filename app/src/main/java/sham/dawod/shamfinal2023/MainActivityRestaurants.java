package sham.dawod.shamfinal2023;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    /**
     * قراءة معطيات من مبنى المعطيات
     * تسجيل المعطيات التي قرأناها من مبنى المعطيات
     *
     * @return
     */
    public void readTaskFrom_FB() {
        //בניית רשימה ריקה
        ArrayList<Restaurants> arrayList = new ArrayList<>();
        //קבלת הפנייה למסד הנתונים
        FirebaseFirestore ffRef = FirebaseFirestore.getInstance();
        //קישור לקבוצה collection שרוצים לקרוא
        ffRef.collection("MyUsers").
                document(FirebaseAuth.getInstance().getUid()).
                collection("subjects").
                document(spnrRes.getSelectedItem().toString()).
                //הוספת מאזין לקריאת הנתונים
                        collection("Tasks").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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

        }
        return true;
    }

}






