package com.example.pushnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.nio.channels.Channels;

public class MainActivity extends AppCompatActivity {
    private Button button;
    int imp = NotificationManager.IMPORTANCE_DEFAULT;
    private final static int ID = 1;
    private final static String TAG = MainActivity.class.getName();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RemoteViews remoteViews = new RemoteViews("com.example.pushnotification", R.layout.plague);
        remoteViews.setTextViewText(R.id.textview, "salam farzad");
        remoteViews.setViewPadding(R.id.textview, 0,2 , 150,5 );
//        Log.i(TAG, "FUNCTION : onCreate => value of text=>" + remoteViews());
        button =(Button)findViewById(R.id.Buttton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "FUNCTION : onClick =>");
                 NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "default")
                         .setSmallIcon(R.drawable.pin)
                         .setContentText("rannandel be shoma reside ast")
                         .setContentTitle("New Notification")
                         .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                         .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                         .setCustomContentView(remoteViews);
                Log.i(TAG, "FUNCTION : onClick => Create a builder for notification => "+builder.toString());
                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(  ID , builder.build());

            }
        });

    }
}
