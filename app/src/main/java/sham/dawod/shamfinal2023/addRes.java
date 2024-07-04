package sham.dawod.shamfinal2023;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import sham.dawod.shamfinal2023.data.AppDatabase;
import sham.dawod.shamfinal2023.data.resTable.Restaurants;

public class addRes extends AppCompatActivity
{
    private TextView etRName;
    private TextInputEditText etPhoneNum;
    private TextInputEditText etLocation;
    private TextInputEditText etWorkHours;
    private Button btnSaveR;
    private Button btnCancelR;
    private sham.dawod.shamfinal2023.data.resTable.Restaurants rest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_res);
        etRName=findViewById(R.id.etRName);
        etPhoneNum=findViewById(R.id.etRPhoneNum);
        etLocation=findViewById(R.id.etLocationR);
        etWorkHours=findViewById(R.id.etWorkHoursR);
        btnSaveR=findViewById(R.id.btnSaveR);
        btnCancelR=findViewById(R.id.btnCancelR);
        imgBtnl=findViewById(R.id.imgBtnl);
        imgBtnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();


            }
        });

    }
    public void onClickSave(View v) {
        checkAndSaveTask_FB();
    }

    public void onClickCancel(View v) {
        finish();
    }

    public void Save_Res()
    {
        boolean isAllOk = true;
        String Rname = etRName.getText().toString();
        String Rphonenum = etPhoneNum.getText().toString();
        String Rlocation = etLocation.getText().toString();
        String RworkHours = etWorkHours.getText().toString();
        String RLocation=etLocation.getText().toString();
        if (Rname.length() < 0) {
            isAllOk = false;
            etRName.setError("Wrong Name");
        }
        if (Rphonenum.length() < 0) {
            isAllOk = false;
            etPhoneNum.setError("Wrong Phone Number");
        }
        if (Rlocation.length() < 0) {
            isAllOk = false;
            etLocation.setError("Wrong location");
        }
        if (RworkHours.length() < 0) {
            isAllOk = false;
            etWorkHours.setError("Wrong WorkHours");
        }
        if (isAllOk) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();

                AppDatabase db = AppDatabase.getDB(getApplicationContext());
                //بناء مطعم جديد وتحديد صفاته
            rest=new Restaurants();
            rest.restName=Rname;
            rest.restPhonenum=Rphonenum;
            rest.restWorkHours=RworkHours;
            rest.restLocation=RLocation;
            finish();
        }



    }
    //upload: 1 add Xml image view or button and upload button
//upload: 2 add next fileds
    private final int IMAGE_PICK_CODE=100;// קוד מזהה לבקשת בחירת תמונה
    private final int PERMISSION_CODE=101;//קוד מזהה לבחירת הרשאת גישה לקבצים
    private ImageButton imgBtnl;//כפתור/ לחצן לבחירת תמונה והצגתה
    private Button btnUpload;// לחצן לביצוע העלאת התמונה
    private Uri toUploadimageUri;// כתוב הקובץ(תמונה) שרוצים להעלות
    private Uri downladuri;//כתובת הקוץ בענן אחרי ההעלאה

    private Restaurants Restaurants;//// עצם/נתון שרוצים לשמור
    private void pickImageFromGallery(){
        //implicit intent (מרומז) to pick image
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);//הפעלתה האינטנט עם קוד הבקשה
    }
    //upload: 5:handle result of picked images
    /**
     *
     * @param requestCode מספר הקשה
     * @param resultCode תוצאה הבקשה (אם נבחר משהו או בוטלה)
     * @param data הנתונים שנבחרו
     */
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //אם נבחר משהו ואם זה קוד בקשת התמונה
        if (resultCode==RESULT_OK && requestCode== IMAGE_PICK_CODE){
            //a עידכון תכונת כתובת התמונה
            toUploadimageUri = data.getData();//קבלת כתובת התמונה הנתונים שניבחרו
            imgBtnl.setImageURI(toUploadimageUri);// הצגת התמונה שנבחרה על רכיב התמונה
        }
    }
    //upload: 6
    /**
     * בדיקה האם יש הרשאה לגישה לקבצים בטלפון
     */
    private void checkPermission()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//בדיקת גרסאות
            //בדיקה אם ההשאה לא אושרה בעבר
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                //רשימת ההרשאות שרוצים לבקש אישור
                String[] permissions = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
                //בקשת אישור ההשאות (שולחים קוד הבקשה)
                //התשובה תתקבל בפעולה onRequestPermissionsResult
                requestPermissions(permissions, PERMISSION_CODE);
            } else {
                //permission already granted אם יש הרשאה מקודם אז מפעילים בחירת תמונה מהטלפון
                pickImageFromGallery();
            }
        }
        else {//אם גרסה ישנה ולא צריך קבלת אישור
            pickImageFromGallery();
        }
    }
    //upload: 7
    /**
     * @param requestCode The request code passed in מספר בקשת ההרשאה
     * @param permissions The requested permissions. Never null. רשימת ההרשאות לאישור
     * @param grantResults The grant results for the corresponding permissions תוצאה עבור כל הרשאה
     *   PERMISSION_GRANTED אושר or PERMISSION_DENIED נדחה . Never null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISSION_CODE) {//בדיקת קוד בקשת ההרשאה
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permission was granted אם יש אישור
                pickImageFromGallery();
            } else {
                //permission was denied אם אין אישור
                Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
            }
        }

    }
    private void saveRes() {
        //קבלת הפניה למסד הניתונים
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //קבלת מזהה המשתמש שנכנס לאפליקציה
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //קבלת קישור לאוסף המקצועות שנמצא במסמך המשתמש-לפי המזהה שלו-

        // קבלת מזהה למסמך החדש
        String restid = db.collection("MyRestaurants").document().getId();

        rest.setId(restid);
        rest.setUid(uid);
        //עידכון תכונת המזהה של המשימה
        // הוספת (מסמך) המשימה לאוסף המשימות
        //הוספת המאזין לבדיקת הצלחת ההוספה
        db.collection("MyRestaurants").document(restid).set(rest).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(addRes.this, "Adding Restaurant Succeeded", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(addRes.this, "Adding Restaurant  failed" + task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }




        private void uploadImage(Uri filePath)
    {
        if (filePath != null) {
            //יצירת דיאלוג התקדמות
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();//הצגת הדיאלוג
            //קבלת כתובת האחסון בענן
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReference();
            //יצירת תיקיה ושם גלובלי לקובץ
            final StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
            // יצירת ״תהליך מקביל״ להעלאת תמונה
            ref.putFile(filePath)
                    //הוספת מאזין למצב ההעלאה
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();// הסתרת הדיאלוג
                                //קבלת כתובת הקובץ שהועלה
                                ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Uri> task) {
                                        downladuri = task.getResult();
                                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                                        rest.setImage(downladuri.toString());//עדכון כתובת התמונה שהועלתה
                                        saveRes();
                                    }
                                });
                            } else {
                                progressDialog.dismiss();//הסתרת הדיאלוג
                                Toast.makeText(getApplicationContext(), "Failed " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    //הוספת מאזין שמציג מהו אחוז ההעלאה
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //חישוב מה הגודל שהועלה
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()/ taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }
        else
        {
            saveRes();
        }
    }
    private void checkAndSaveTask_FB() {
        boolean isAllOk = true;
        String Rname = etRName.getText().toString();
        String Rphonenum = etPhoneNum.getText().toString();
        String Rlocation = etLocation.getText().toString();
        String RworkHours = etWorkHours.getText().toString();
        String RLocation=etLocation.getText().toString();


        if (Rname.length() < 0) {
            isAllOk = false;
            etRName.setError("Wrong Name");
        }
        if (Rphonenum.length() < 0) {
            isAllOk = false;
            etPhoneNum.setError("Wrong Phone Number");
        }
        if (Rlocation.length() < 0) {
            isAllOk = false;
            etLocation.setError("Wrong location");
        }
        if (RworkHours.length() < 0) {
            isAllOk = false;
            etWorkHours.setError("Wrong WorkHours");
        }
        if (isAllOk) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();

            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            //بناء مطعم جديد وتحديد صفاته
            rest=new Restaurants();
            rest.restName=Rname;
            rest.restPhonenum=Rphonenum;
            rest.restWorkHours=RworkHours;
            rest.restLocation=RLocation;
            uploadImage(toUploadimageUri);

        }
            //ביצוע העלאת התמונה ואחרי שהתמונה עלתה שומרים את הכתובת שלה בעצם ושומרים אותו במסד הנתונים

        }










































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
            Intent i = new Intent(addRes.this, addRes.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemLogOut)
        {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
            showYesNoDialig();

        }

        return true;
    }
    public void showYesNoDialig()
    {
        //جهيز بناء شباك حوار بارمتر مؤشر للنشاط الحالي
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Log out");//تحديد العنوان
        builder.setMessage("Are you sure?");//تحدي فحوى شباك الحوار
        //النض على الزر ومعالج الحدث
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //معالجة حدث للموافقة
                Toast.makeText(addRes.this, "Signing out", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
        //النض على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(addRes.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();//بناء شباك الحوار
        dialog.show();//عرض الشباك
    }






}