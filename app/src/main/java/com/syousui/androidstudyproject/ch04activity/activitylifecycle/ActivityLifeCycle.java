package com.syousui.androidstudyproject.ch04activity.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.syousui.androidstudyproject.R;


public class ActivityLifeCycle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_life_cycle);
        Log.e("ActivityLifeCycle","调用onCreate()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ActivityLifeCycle", "调用onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ActivityLifeCycle", "调用onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ActivityLifeCycle", "调用onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ActivityLifeCycle", "调用onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ActivityLifeCycle", "调用onDestroy()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityLifeCycle", "调用onRestart()");
    }
}
