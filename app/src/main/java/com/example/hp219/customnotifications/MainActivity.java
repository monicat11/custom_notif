package com.example.hp219.customnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder notification;
    private static final int uniqueID=7326;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

    }
    public void onClickNotification(View view)
    {
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("Yo got a notif");
        notification.setContentTitle("This...Your damn notif");
        notification.setContentText("Easy to make");
        notification.setWhen(System.currentTimeMillis());
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());
    }

}
