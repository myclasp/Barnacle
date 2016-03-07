package com.adriangradinar.barnacle;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.renderscript.RenderScript;
import android.util.Log;

public class BarnacleService extends Service {

    private static final String TAG = BarnacleService.class.getSimpleName();

    public BarnacleService() {}

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "This should not be called!");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //this function is called all times when the service is started
        Log.e(TAG, "onStartCommand called");

        //this is for the detection/removal of the headset
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        HeadsetReceiver otherReceiver = new HeadsetReceiver();
        registerReceiver(otherReceiver, filter);

        //this is the actual press of the button
        ((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(new ComponentName(this, ExternalAudioButtonReceiver.class.getCanonicalName()));

//        Log.e(TAG, "OS version: " + android.os.Build.VERSION.SDK_INT);
//
//        if(android.os.Build.VERSION.SDK_INT < 19){
//            Log.e(TAG, "lower than 19");
//            ExternalAudioButtonReceiver mMediaButtonReceiver = new ExternalAudioButtonReceiver();
//            IntentFilter mediaFilter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
//            mediaFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
//            registerReceiver(mMediaButtonReceiver, mediaFilter);
//        }
//        else if(android.os.Build.VERSION.SDK_INT >= 19 && android.os.Build.VERSION.SDK_INT < 21){
//            Log.e(TAG, "use audio seems to be working");
//        }
//        else{
//            Log.e(TAG, "higher or equal to 21");
//        }

        //tell the listener to never close the service
        return START_STICKY;
    }
}
