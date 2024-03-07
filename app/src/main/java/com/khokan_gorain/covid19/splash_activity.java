package com.khokan_gorain.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.khokan_gorain.covid19.R;

import static java.lang.Thread.sleep;

public class splash_activity extends AppCompatActivity {
 ImageView splashScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splashScreen=(ImageView)findViewById(R.id.splashScreen);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.splashanim);
        splashScreen.setAnimation(myanim);


        Thread mythred=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(splash_activity.this,dasbode_Activity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        mythred.start();
    }
}
