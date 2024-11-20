package com.example.fcmapp;

import static android.content.ContentValues.TAG;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    private static final int NOTIFICATION_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    NOTIFICATION_PERMISSION_CODE);
        } else {
            // Permission is already granted
            postNotification();
        }

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String channerId=getString(R.string.default_notification_channel_id);
            String channelName=getString(R.string.default_notification_channel_name);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channerId,channelName,NotificationManager.IMPORTANCE_LOW));
        }

       if (getIntent().getExtras()!=null){
           for (String key:getIntent().getExtras().keySet()){
               Object value=getIntent().getExtras().get(key);
               Log.d(TAG,"Key "+key+"Value :"+value);
           }
       }



       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirebaseMessaging.getInstance().subscribeToTopic("weather")
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               String msg="Subscribed";
                               if(!task.isSuccessful()){
                                   msg="Failled";
                               }
                               Log.d(TAG,msg);
                               Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                           }
                       });
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                   @Override
                   public void onComplete(@NonNull Task<String> task) {
                       if(!task.isSuccessful()){
                           Log.v(TAG,"Failled to read",task.getException());
                           return;
                       }
                       String token =task.getResult();
                       String msg=getString(R.string.msg_token_fmt,token);
                       Log.v(TAG,msg);
                       Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                   }
               });
           }
       });

    }


    private void postNotification() {
        // Code to post notifications if permission is granted
        Toast.makeText(this, "Permission granted! You can post notifications.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == NOTIFICATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                postNotification();
            } else {
                Toast.makeText(this, "Permission denied to post notifications.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}