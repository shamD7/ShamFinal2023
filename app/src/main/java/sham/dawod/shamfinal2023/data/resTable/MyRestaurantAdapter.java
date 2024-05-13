package sham.dawod.shamfinal2023.data.resTable;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

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

}

