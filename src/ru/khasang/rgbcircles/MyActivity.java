package ru.khasang.rgbcircles;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.TimerTask;

public class MyActivity extends Activity {
//    ImageButton mStartButton, mCancelButton;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
//
//        mStartButton = (ImageButton) findViewById(R.id.imageButtonPlay);
//        mCancelButton = (ImageButton) findViewById(R.id.imageButtonPause);
    }

//    @Override
//    public void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//
//        tvGetMsg = (TextView)getActivity().findViewById(R.id.tvGetMessage);
//        edit = (EditText)getActivity().findViewById(R.id.editText);
//        butGetMsg = (Button)getActivity().findViewById(R.id.butGetText);
//
//        butGetMsg.setOnClickListener(this);
//    }



//    class MyTimerTask extends TimerTask {
//
//        @Override
//        public void run() {
//
//            runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    moveCircles();
//                }
//            });
//        }
//    }

}
