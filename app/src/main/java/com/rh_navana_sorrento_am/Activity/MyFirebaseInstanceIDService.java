package com.rh_navana_sorrento_am.Activity;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Proloy on 9/18/2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseInsIDService";

    @Override
    public void onTokenRefresh() {
        String refreshtoken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token" + refreshtoken);

    }
}
