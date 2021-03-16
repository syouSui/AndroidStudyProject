package com.syousui.androidstudyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        public void onBindViewHolder(@NonNull final MyViewHolderV1 holder, int position) {
            try {
                JSONObject chapter_item = chapter.getJSONObject(position);
                holder.chapterNameTextView.setText(
                        chapter_item.getString("chapter_name")
                );
                holder.chapterNameTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.sectionRecycleView.setVisibility(
                                holder.sectionRecycleView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE
                        );
                    }
                });
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
                final JSONObject section_item = section.getJSONObject(position);
                holder.sectionNameTextView.setText(
                        section_item.getString("section_name")
                );
                holder.sectionNameTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Class clazz = Class.forName(section_item.getString("section_activity"));
                            startActivity(new Intent(MainActivity.this, clazz));
                        } catch (ClassNotFoundException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
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
/*
 * TODO:
 * 1. 自动更新
 * 2. 隐藏顶部状态栏
 */
