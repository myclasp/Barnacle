package com.adriangradinar.barnacle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

public class HeadsetReceiver extends BroadcastReceiver {

    private static final String TAG = HeadsetReceiver.class.getSimpleName();
    public HeadsetReceiver() {}
    private static final String name = "h2w";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_HEADSET_PLUG.equals(intent.getAction())){
            int state = intent.getExtras().getInt("state");

//            if(name.equals(intent.getExtras().getString("name"))){
//                Log.e(TAG, "yup, seems to be my pressy button");
//            }
//            else{
//                Log.e(TAG, "jack used by other device");
//            }

            switch (state){
                case 0:
                    Log.e(TAG, "Barnacle not attached or removed!");
                    break;
                case 1:
                    Log.e(TAG, "Barnacle attached!");
                    break;
                default:
                    Log.e(TAG, "We don't cover this state");
            }
        }
    }
}
