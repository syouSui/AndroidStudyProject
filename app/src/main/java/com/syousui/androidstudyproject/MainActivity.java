package com.syousui.androidstudyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.syousui.androidstudyproject.ch04Activity.SichuanCuisine.FoodMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, ActivityLifeCycle.class));
        startActivity(new Intent(this, FoodMainActivity.class));
    }
}