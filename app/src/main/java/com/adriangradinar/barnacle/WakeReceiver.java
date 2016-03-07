package com.adriangradinar.barnacle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.view.WindowManager;

public class WakeReceiver extends BroadcastReceiver {

    public static final String WAKE = "Wake up";
    public WakeReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("ttt", "called");

        Intent myAct = new Intent(context, MainActivity.class);
        myAct.putExtra(WAKE, true);
        myAct.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myAct);

//        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//        PowerManager.WakeLock wakeLock = pm.newWakeLock(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                | PowerManager.ACQUIRE_CAUSES_WAKEUP
//                | PowerManager.ON_AFTER_RELEASE, "MyWakeLock");
//        wakeLock.acquire();

    }
}
