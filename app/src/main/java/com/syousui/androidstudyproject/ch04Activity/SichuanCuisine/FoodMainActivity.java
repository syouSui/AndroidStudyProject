package com.syousui.androidstudyproject.ch04Activity.SichuanCuisine;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.syousui.androidstudyproject.R;

public class FoodMainActivity extends AppCompatActivity {
    private int[] foodIcons = {R.drawable.boiledmeat, R.drawable.mapoytofu};
    private String[] foodNames = {"水煮肉片", "麻婆豆腐"};
    private String[] foodDescription = {"" +
            "1.将鸡蛋清和淀粉调料调匀成糊，涂抹在肉片上。\n" +
            "2.将花椒、干辣椒慢火炸，待辣椒呈金黄色捞出切成细末。\n" +
            "3.用锅中油爆炒豆瓣辣酱，然后将白菜叶，调料放入。\n" +
            "4.随即放入 肉片，再炖几分钟，肉片熟后，将肉片盛起，将辣椒、花椒末撒上。\n" +
            "5.用植物油烧开，淋在肉片上，即可使麻、辣、浓香四溢。",
            "1、豆腐切丁，香葱、生姜、大蒜、干辣椒切细末备用。\n" +
            "2、锅内放入油烧热， 先爆香葱末、生姜末、大蒜末、干辣椒末和豆瓣酱，再放入猪肉馅炒熟。\n" +
            "3、加入适量水，煮开后加入豆腐丁、酱油、白糖煮3分钟。\n" +
            "4、再用水淀粉勾芡后盛入盘中。\n" +
            "5、烧热香油，爆香花椒，将花椒油淋在豆腐上即可。\n"};

    public int[] getIcons() {
        return foodIcons;
    }

    public String[] getNames() {
        return foodNames;
    }

    public String[] getFoodDescription() {
        return foodDescription;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food);

        ContentFragment contentFragment = new ContentFragment();
        MenuFragment menuFragment = new MenuFragment();

        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.food_description, contentFragment);
        beginTransaction.replace(R.id.menu, menuFragment);
        beginTransaction.commit();
    }
}
