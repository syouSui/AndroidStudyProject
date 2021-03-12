package com.syousui.androidstudyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.syousui.androidstudyproject.ch03widget.custom.CustomViewMainActivity;
import com.syousui.androidstudyproject.ch03widget.dialog.DialogMainActivity;
import com.syousui.androidstudyproject.ch03widget.recycleview.RecycleViewMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, ActivityLifeCycle.class));
//        startActivity(new Intent(this, FoodMainActivity.class));
//        startActivity(new Intent(this, ListViewMainActivity.class));
//        startActivity(new Intent(this, RecycleViewMainActivity.class));
//        startActivity(new Intent(this, CustomViewMainActivity.class));
        startActivity(new Intent(this, DialogMainActivity.class));
    }
}