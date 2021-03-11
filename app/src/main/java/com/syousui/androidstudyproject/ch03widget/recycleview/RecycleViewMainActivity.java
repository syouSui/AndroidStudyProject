package com.syousui.androidstudyproject.ch03widget.recycleview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.syousui.androidstudyproject.R;

public class RecycleViewMainActivity extends AppCompatActivity {
    private String[] names = {
            "小猫", "哈士奇", "小黄鸭", "小鹿", "老虎", "小猫", "哈士奇", "小黄鸭", "小鹿", "老虎",
    };
    private int[] images = {
            R.drawable.cat, R.drawable.siberiankusky, R.drawable.yellowduck, R.drawable.fawn, R.drawable.tiger,
            R.drawable.cat, R.drawable.siberiankusky, R.drawable.yellowduck, R.drawable.fawn, R.drawable.tiger
    };
    private String[] introduces = {
            "猫，属于猫科动物，分家猫、野猫，是全世界家庭中较为广泛的宠物。",
            "西伯利亚雪橇犬，常见别名哈士奇，昵称为二哈。",
            "鸭的体型相对较小，颈短，一些属的嘴要大些。腿位于身体后方，因而步态蹒跚。",
            "鹿科是哺乳纲偶蹄目下的一科动物。体型大小不等，为有角的反刍类。",
            "虎，大型猫科动物；毛色浅黄或棕黄色，满有黑色横纹；头圆、耳短，耳背面黑色，中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。",
            "猫，属于猫科动物，分家猫、野猫，是全世界家庭中较为广泛的宠物。",
            "西伯利亚雪橇犬，常见别名哈士奇，昵称为二哈。",
            "鸭的体型相对较小，颈短，一些属的嘴要大些。腿位于身体后方，因而步态蹒跚。",
            "鹿科是哺乳纲偶蹄目下的一科动物。体型大小不等，为有角的反刍类。",
            "虎，大型猫科动物；毛色浅黄或棕黄色，满有黑色横纹；头圆、耳短，耳背面黑色，中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main_recycleview);
        RecyclerView mRecyclerView = findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new HomeAdapter());
    }


    /**
     * HomeAdapter
     */
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(
                    LayoutInflater
                            .from(RecycleViewMainActivity.this)
                            .inflate(R.layout.recycler_item, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nameView.setText(names[position]);
            holder.imageView.setImageResource(images[position]);
            holder.introduceView.setText(introduces[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        /**
         * ViewHolder
         */
        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView nameView;
            ImageView imageView;
            TextView introduceView;

            public MyViewHolder(View view) {
                super(view);
                this.nameView = view.findViewById(R.id.rv_name);
                this.imageView = view.findViewById(R.id.rv_image);
                this.introduceView = view.findViewById(R.id.rv_introduce);
            }
        }
    }
}
