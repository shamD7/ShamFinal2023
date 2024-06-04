package sham.dawod.shamfinal2023;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class profile extends AppCompatActivity {
    private TextInputEditText etNameC;
    private TextInputEditText etPhNumC;
    private TextInputEditText etLocatoinC;
    private TextInputEditText etPhone;
    private TextInputEditText etLocation;
    private Button btnSAVE;
    private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);


    }


}