package com.example.fcmapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static  final String TAG ="MyFirebaseMsgService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {


        Log.v(TAG,"FROM"+message.getFrom());

        //check for  datapayload in the messaging

        if (message.getData().size()>0){
            Log.v(TAG,"Message data payload "+message.getData());

            if(true){
                scheduleJob();
            }else{
                handleNow();
            }
        }

        // check for notication payload
    if(message.getNotification()!=null){
        Log.v(TAG,"Message Notification Body "+message.getNotification().getBody());
        // Call sendNotification here to show it
        sendNotification(message.getNotification().getBody());
    }




    }


    @Override
    public void onNewToken(@NonNull String token) {

        Log.d(TAG,"onNewToken"+token);

        sendRegistrationToServer(token);
    }
    private  void sendNotification(String messageBody){
        Intent i =new Intent(this,MainActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,i, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE);

        String channelId =getString(R.string.default_notification_channel_id);
        Uri defaultSoungUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (defaultSoundUri == null) {
            // Provide a fallback URI or sound
         //   defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fallback_notification_sound);
        }

        NotificationCompat.Builder  notificationBuilder=new NotificationCompat.Builder(
                this,channelId)
                .setSmallIcon(R.drawable.ic_stat_ic_notification)
                .setContentTitle(getString(R.string.fcm_message))
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoungUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){


            NotificationChannel channel =new NotificationChannel(
                    channelId,"channel Human readable Tiltle",NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(0,notificationBuilder.build());
    }
    private  void scheduleJob(){
        OneTimeWorkRequest work=new OneTimeWorkRequest.Builder(MyWorker.class)
                .build();
        WorkManager.getInstance(this).beginWith(work).enqueue();

    }
    private void handleNow(){
        Log.v(TAG,"Short Live Task is done");

    }

    private void sendRegistrationToServer(String token) {
    }


}
