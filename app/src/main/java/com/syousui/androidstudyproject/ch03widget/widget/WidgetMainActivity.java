package com.syousui.androidstudyproject.ch03widget.widget;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import com.syousui.androidstudyproject.R;

public class WidgetMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widget);

        // CheckBox
        class HobbyCheckBoxCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
            TextView hobbyTv = findViewById(R.id.w_hobby);
            String hobbyStr = "";

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String motion = buttonView.getText().toString() + " ";
                if (isChecked) {
                    if (!hobbyStr.contains(motion)) hobbyStr += motion;
                } else {
                    if (hobbyStr.contains(motion)) hobbyStr = hobbyStr.replace(motion, "");
                }
                hobbyTv.setText(hobbyStr);
            }
        }
        ;
        HobbyCheckBoxCheckedChangeListener hobbyCheckBoxCheckedChangeListener = new HobbyCheckBoxCheckedChangeListener();
        ((CheckBox) (findViewById(R.id.w_like_shuttlecock))).setOnCheckedChangeListener(hobbyCheckBoxCheckedChangeListener);
        ((CheckBox) findViewById(R.id.w_like_basketball)).setOnCheckedChangeListener(hobbyCheckBoxCheckedChangeListener);
        ((CheckBox) (findViewById(R.id.w_like_pingpong))).setOnCheckedChangeListener(hobbyCheckBoxCheckedChangeListener);

        // RadioGroup
        RadioGroup genderRg = findViewById(R.id.w_rdg);
        final TextView genderTv = findViewById(R.id.w_rdg_tv);
        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                genderTv.setText("Your gender is: " + ((AppCompatRadioButton) findViewById(checkedId)).getText());
            }
        });
    }
}
