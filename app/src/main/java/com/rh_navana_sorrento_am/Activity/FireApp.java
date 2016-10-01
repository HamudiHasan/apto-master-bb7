package com.rh_navana_sorrento_am.Activity;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Proloy on 9/27/2016.
 */
public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
