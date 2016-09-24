package com.example.ossusum.hunter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Benny on 6/23/2015.
 */
public class ReminderService extends WakeReminderIntentService {

    Uri url;

    public ReminderService() {
        super("ReminderService");
    }

    @Override
    void doReminder(Intent intent) {
        // Notification stuff here
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW,getUrl());
        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification note = new Notification(android.R.drawable.stat_sys_warning, "New Hunt",System.currentTimeMillis());
        note.setLatestEventInfo(this,"New Hunt","New Hunt is on" ,pi);

        note.defaults |= Notification.DEFAULT_SOUND;
        note.flags |= Notification.FLAG_AUTO_CANCEL;
        //Keep eye out
        notificationManager.notify(0,note);
    }
    public Uri getUrl(){
      return url;
    }
    public void setUrl(Uri u){
        url = u;
    }
}
