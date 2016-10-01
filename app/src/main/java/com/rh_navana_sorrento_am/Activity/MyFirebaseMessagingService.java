package com.rh_navana_sorrento_am.Activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.rh_navana_sorrento_am.ModelClass.Notices;
import com.rh_navana_sorrento_am.R;

/**
 * Created by Proloy on 9/18/2016.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "Firebasemsgservice";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"FROM" +remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0)
        {
            Log.d(TAG,"Message Data: " +remoteMessage.getData());
        }

        if(remoteMessage.getNotification() !=null)
        {
            Notices notices = new Notices("The",remoteMessage.getNotification().getBody()+"","pp");
            notices.save();

            Log.d(TAG,"Message Body:" + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }

    }

    private void sendNotification(String body)
    {
        Intent intent = new Intent(this,ActivityNotice.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notifibuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification From Admin")
                .setContentText(body)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifibuilder.build());

    }


}
