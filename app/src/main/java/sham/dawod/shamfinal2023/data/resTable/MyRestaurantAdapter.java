package sham.dawod.shamfinal2023.data.resTable;

import static android.Manifest.permission.CALL_PHONE;
import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.content.ContextCompat.checkSelfPermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;

import com.squareup.picasso.Picasso;

import sham.dawod.shamfinal2023.R;

public class MyRestaurantAdapter extends ArrayAdapter<Restaurants> {

    private final int itemLayout;
    /**
     * פעולה בונה מתאם
     * @param context קישור להקשר (מסך- אקטיביטי)
     * @param resource עיצוב של פריט שיציג הנתונים של העצם
     */

    public MyRestaurantAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.itemLayout =resource;


    }
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent )

    {
        View vitem = convertView;
        if(vitem==null)
            vitem= LayoutInflater.from(getContext()).inflate(itemLayout,parent,false);

        ImageView imageView =vitem.findViewById(R.id.imgVRes);
        TextView tvName =vitem.findViewById(R.id.tvResName);
        TextView tvResHours =vitem.findViewById(R.id.tvResHours);
        TextView tvResPhNum =vitem.findViewById(R.id.tvResPhNum);
        ImageButton imgBtnGo=vitem.findViewById(R.id.imgBtnGo);
        ImageButton imgBtnCall=vitem.findViewById(R.id.imgBtnCallitm);
        ImageButton imgBtnFav=vitem.findViewById(R.id.imgBtnFavorite);
        //
        Restaurants current=getItem(position);
        //
        tvName.setText((current.getRestName()));
        tvResHours.setText((current.getRestWorkHours()));
        tvResPhNum.setText((current.getRestPhonenum()));
        //
        downloadImageUsingPicasso(current.getImage(),imageView);



        return vitem ;

    }
    /**
     * הצגת תמונה ישירות מהענן בעזרת המחלקה ״פיקאסו״
     * @param imageUrL כתובת התמונה בענן/שרת
     * @param toView רכיב תמונה המיועד להצגת התמונה אחרי ההורדה
     */
    private void downloadImageUsingPicasso(String imageUrL, ImageView toView)
    {
        // אם אין תמונה= כתובת ריקה אז לא עושים כלום מפסיקים את הפעולה
        if(imageUrL==null) return;
        //todo: add dependency to module gradle:
        //    implementation 'com.squareup.picasso:picasso:2.5.2'
        Picasso.with(getContext())
                .load(imageUrL)//הורדת התמונה לפי כתובת
                .centerCrop()
                .error(R.drawable.ic_launcher_background)//התמונה שמוצגת אם יש בעיה בהורדת התמונה
                .resize(90,90)//שינוי גודל התמונה
                .into(toView);// להציג בריכיב התמונה המיועד לתמונה זו
    }
    /**
     * ביצוע שיחה למפסר טלפון
     * todo הוספת הרשאה בקובץ המניפיסט
     * <uses-permission android:name="android.permission.CALL_PHONE" />
     * @param phone מספר טלפון שרוצים להתקשר אליו
     */
    private void callAPhoneNymber(String phone){
        //בדיקה אם יש הרשאה לביצוע שיחה
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//בדיקת גרסאות
            //בדיקה אם ההרשאה לא אושרה בעבר
            if (checkSelfPermission(getContext(),CALL_PHONE) == PermissionChecker.PERMISSION_DENIED) {
                //רשימת ההרשאות שרוצים לבקש אישור
                String[] permissions = {CALL_PHONE};
                //בקשת אישור הרשאות (שולחים קוד הבקשה)
                //התשובה תתקבל בפעולה onRequestPermissionsResult
                requestPermissions((Activity) getContext(),permissions, 100);
            }
            else{
                //אינטנט מרומז לפתיחת אפליקצית ההודות סמס
                Intent phone_intent = new Intent(Intent.ACTION_CALL);
                phone_intent.setData(Uri.parse("tel:" + phone));
                getContext().startActivity(phone_intent);
            }
        }
    }



}

