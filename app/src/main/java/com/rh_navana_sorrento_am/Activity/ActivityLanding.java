package com.rh_navana_sorrento_am.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.rh_navana_sorrento_am.ModelClass.Notices;
import com.rh_navana_sorrento_am.R;

public class ActivityLanding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.Builder config = new Configuration.Builder(this);
        config.addModelClasses(Notices.class);
        ActiveAndroid.initialize(config.create());

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_landing);


        new CountDownTimer(2000, 1000) {

            /** This method will be invoked on finishing or expiring the timer */
            @Override
            public void onFinish() {
                /** Creates an intent to start new activity */
                Intent intent = new Intent(getBaseContext(), login_page.class);

                //memulai activity baru ketika waktu timer habis
                startActivity(intent);

                //menutup layar activity
                finish();

            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();
    }
}
