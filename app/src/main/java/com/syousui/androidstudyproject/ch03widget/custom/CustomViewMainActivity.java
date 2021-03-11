package com.syousui.androidstudyproject.ch03widget.custom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.syousui.androidstudyproject.R;

public class CustomViewMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_circleview);
    }
}
