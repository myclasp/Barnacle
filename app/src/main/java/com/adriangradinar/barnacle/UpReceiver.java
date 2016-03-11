package com.adriangradinar.barnacle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
/**
 * Created by will on 10/03/16.
 */



public class UpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Log.i("hello", "onreceive called!");
        Toast.makeText(context, "Up reciever Intent Detected.", Toast.LENGTH_SHORT).show();

        Intent intentCam = new Intent(context, MatCamActivity.class);
        intentCam.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentCam);



    }
}