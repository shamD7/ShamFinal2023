package sham.dawod.shamfinal2023;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        //start next activity (screen) automatically  after period of time

        Handler h=new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run()
            {
                //to open new activity from current to next
                Intent i= new Intent(splashScreen.this, SignIn.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        };
        h.postDelayed(r,3000);
    }

}
