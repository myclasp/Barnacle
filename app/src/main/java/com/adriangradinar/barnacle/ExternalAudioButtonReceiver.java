package com.adriangradinar.barnacle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class ExternalAudioButtonReceiver extends BroadcastReceiver {

    public static final String WAKE = "Wake up";
    private final static String TAG = ExternalAudioButtonReceiver.class.getSimpleName();
    private static int presses = 0;

    public ExternalAudioButtonReceiver() {}

    @Override
    public void onReceive(final Context context, Intent intent) {

        final Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if(event.getAction() == KeyEvent.ACTION_DOWN){
                presses++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (presses == 1) {
                            v.vibrate(250);
                            Toast.makeText(context, "single click!", Toast.LENGTH_SHORT).show();

                            //let's try and wake the device
                            context.startActivity(new Intent(context, HiddenPhoto.class).putExtra(WAKE, true).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                        }
                        if (presses == 2) {
                            v.vibrate(500);
                            Toast.makeText(context, "Double click!!", Toast.LENGTH_SHORT).show();
                        }
//                        if(presses > 2) {
//                            Toast.makeText(context, "Pattern not recognized!!", Toast.LENGTH_SHORT).show();
//                        }
                        presses = 0;
                    }
                };
                if(presses == 1) {
                    handler.postDelayed(r, 500);
                }
            }
        }
    }

//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
//        Log.e(TAG, "hmm...");
//
//        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
//            /* handle media button intent here by reading contents */
//            /* of EXTRA_KEY_EVENT to know which key was pressed    */
//            //this is a kew press
//            KeyEvent keyEvent = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
////            Log.w(TAG, keyEvent.toString());
////            //detect what kind of key press (up, down, multiple)
////            int action = keyEvent.getAction();
////            if(action == KeyEvent.ACTION_UP){
////                Log.e(TAG, "ACTION_UP");
////            }
//
//            if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
//                Log.e(TAG, "short press");
//                v.vibrate(500);
//            }
//
////            if(action == KeyEvent.ACTION_MULTIPLE){
////                Log.e(TAG, "ACTION_MULTIPLE");
////            }
////
////            KeyEvent k = intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
////            int i = k.getKeyCode();
////            int i1 = k.getAction();
////            Log.e(TAG, "event.getAction() " + i + " - " + i1);
//
//            //work around the long press issue
////            switch (keyEvent.getKeyCode()) {
////                case KeyEvent.KEYCODE_HEADSETHOOK:
////                    if (action == KeyEvent.ACTION_UP)
////                        if (SystemClock.uptimeMillis() - keyEvent.getDownTime() > 1200)
////                            Toast.makeText(context, "Long click!", Toast.LENGTH_SHORT).show();
////                    break;
////            }
//        }
//    }
}
