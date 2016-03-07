package com.adriangradinar.barnacle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HiddenPhoto extends Activity {

    private File saveFolder = new File(Environment.getExternalStorageDirectory(), "Clasp/Pictures");

//    //Camera variables
//    //a surface holder
//    private SurfaceHolder sHolder;
//    //a variable to control the camera
//    private Camera mCamera;
//    //the camera parameters
//    private Camera.Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mCamera = Camera.open();
//        SurfaceView sv = new SurfaceView(getApplicationContext());
//
//        if (!saveFolder.exists()) {
//            saveFolder.mkdirs();
//        }
//
//        Camera.PictureCallback mCall = new Camera.PictureCallback() {
//
//            public void onPictureTaken(byte[] data, Camera camera) {
//                //decode the data obtained by the camera into a Bitmap
//
//                FileOutputStream outStream = null;
//                try {
//                    outStream = new FileOutputStream(saveFolder);
//                    outStream.write(data);
//                    outStream.close();
//                } catch (FileNotFoundException e) {
//                    Log.d("CAMERA", e.getMessage());
//                } catch (IOException e) {
//                    Log.d("CAMERA", e.getMessage());
//                }
//            }
//        };
//
//        try {
//            mCamera.setPreviewDisplay(sv.getHolder());
//            parameters = mCamera.getParameters();
//
//            //set camera parameters
//            mCamera.setParameters(parameters);
//            mCamera.startPreview();
//            mCamera.takePicture(null, null, mCall);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        //Get a surface
//        sHolder = sv.getHolder();
//        //tells Android that this surface will have its data constantly replaced
//        sHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
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
