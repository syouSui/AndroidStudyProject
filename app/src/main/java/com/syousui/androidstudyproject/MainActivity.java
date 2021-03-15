package com.syousui.androidstudyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syousui.androidstudyproject.util.JSONUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, ActivityLifeCycle.class));
//        startActivity(new Intent(this, FoodMainActivity.class));
//        startActivity(new Intent(this, ListViewMainActivity.class));
//        startActivity(new Intent(this, RecycleViewMainActivity.class));
//        startActivity(new Intent(this, CustomViewMainActivity.class));
//        startActivity(new Intent(this, DialogMainActivity.class));
//        startActivity(new Intent(this, WidgetMainActivity.class));
        RecyclerView contentView = findViewById(R.id.chapter);
        contentView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        contentView.setAdapter(new MyAdapterV1(
                JSONUtil.getJsonAsJSONObject("catalog.json", this))
        );
    }

    /**
     * Adapter For Level1 RecycleView.
     */
    class MyAdapterV1 extends RecyclerView.Adapter<MyAdapterV1.MyViewHolderV1> {
        private JSONArray chapter;

        public MyAdapterV1(JSONObject catalog) {
            try {
                this.chapter = catalog.getJSONArray("chapter");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public MyAdapterV1() {
        }

        class MyViewHolderV1 extends RecyclerView.ViewHolder {
            TextView chapterNameTextView;
            RecyclerView sectionRecycleView;

            public MyViewHolderV1(@NonNull View itemView) {
                super(itemView);
                chapterNameTextView = itemView.findViewById(R.id.chapter_name);
                sectionRecycleView = itemView.findViewById(R.id.section);
            }
        }

        @NonNull
        @Override
        public MyViewHolderV1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainActivity.MyAdapterV1.MyViewHolderV1(
                    LayoutInflater.from(MainActivity.this)
                            .inflate(R.layout.chapter_item, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolderV1 holder, int position) {
            try {
                JSONObject chapter_item = chapter.getJSONObject(position);
                holder.chapterNameTextView.setText(
                        chapter_item.getString("chapter_name")
                );
                holder.sectionRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                holder.sectionRecycleView.setAdapter(new MyAdapterV2(
                                chapter_item.getJSONArray("section")
                        )
                );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return chapter.length();
        }
    }

    /**
     * Adapter for level2 RecycleView.
     */
    class MyAdapterV2 extends RecyclerView.Adapter<MyAdapterV2.MyViewHolderV2> {
        private JSONArray section;

        public MyAdapterV2() {
        }

        public MyAdapterV2(JSONArray section) {
            this.section = section;
        }

        class MyViewHolderV2 extends RecyclerView.ViewHolder {
            TextView sectionNameTextView;

            public MyViewHolderV2(@NonNull View itemView) {
                super(itemView);
                sectionNameTextView = itemView.findViewById(R.id.section_name);
            }
        }

        @NonNull
        @Override
        public MyAdapterV2.MyViewHolderV2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainActivity.MyAdapterV2.MyViewHolderV2(
                    LayoutInflater.from(MainActivity.this)
                            .inflate(R.layout.section_item, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapterV2.MyViewHolderV2 holder, int position) {
            try {
                JSONObject section_item = section.getJSONObject(position);
                holder.sectionNameTextView.setText(
                        section_item.getString("section_name")
                );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return section.length();
        }
    }
}

//            JSONArray chapter = temp.getJSONArray("chapter");
//            JSONObject chapter_item = chapter.getJSONObject(0);
//            String chapter_name = chapter_item.getString("chapter_name");
//            JSONArray section = chapter_item.getJSONArray("section");
//            JSONObject section_item = section.getJSONObject(0);
//            String section_name = section_item.getString("section_name");
//            String section_activity = section_item.getString("section_activity");
//            System.out.println(chapter_name);
//            System.out.println(section_name);
//            System.out.println(section_activity);
