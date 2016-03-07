package com.adriangradinar.barnacle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class LongPress extends AppCompatActivity {

    private static final String TAG = LongPress.class.getSimpleName();
    private static int longPresses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        if(getIntent().hasExtra(WakeReceiver.WAKE) && getIntent().getExtras().getBoolean(WakeReceiver.WAKE)){
//            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
//                            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
//                            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
//                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
//                            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
//                            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
//        }

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        Log.e(TAG, "I am being called!");

        if (getIntent() != null && getIntent().getAction() != null){
            if(getIntent().getAction().equals("android.speech.action.WEB_SEARCH")){
                Log.e(TAG, "Counting: " + ++longPresses);
            }
        }

        //close down the activity
        finish();
    }

    @Override
    protected void onStart() {

        if(getIntent().hasExtra(WakeReceiver.WAKE) && getIntent().getExtras().getBoolean(WakeReceiver.WAKE)){
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
//            finish();
        }

        super.onStart();
    }
}
