package com.example.ossusum.hunter;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;

/**
 * Created by Benny on 6/22/2015.
 * Purpose: Stops the phone from locking the app in the background
 */
public abstract class WakeReminderIntentService extends IntentService{

    public static final String
        LOCK_NAME_STATIC = "com.example.ossusum.hunter.Static";
    private  static PowerManager.WakeLock lockStatic = null;

    @Override
    protected void onHandleIntent(Intent intent) {
        try{
            doReminder(intent);
        }finally {
            getLock(this).release();
        }
    }

    abstract void doReminder(Intent intent);

    synchronized private static PowerManager.WakeLock getLock(Context context){
        if(lockStatic == null){
            PowerManager mgr =
                    (PowerManager)  context.getSystemService(Context.POWER_SERVICE);
            lockStatic = mgr.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,LOCK_NAME_STATIC);
        }
        return (lockStatic);
    }
    public WakeReminderIntentService(String name){
        super(name);
    }
}
