package sham.dawod.shamfinal2023.data.resTable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        TextView tvResMenu =vitem.findViewById(R.id.tvResMenu);
        ImageButton imgBtnGo=vitem.findViewById(R.id.imgBtnGo);
        ImageButton imgBtnCall=vitem.findViewById(R.id.imgBtnCallitm);
        ImageButton imgBtnFav=vitem.findViewById(R.id.imgBtnFavorite);

        return vitem ;

    }
}

