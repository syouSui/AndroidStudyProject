package com.syousui.androidstudyproject.ch03widget.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.syousui.androidstudyproject.R;


public class ListViewMainActivity extends Activity {
    private String[] titles = {"桌子", "苹果", "蛋糕", "线衣", "猕猴桃", "围巾", "desk", "apple", "cake", "clothes", "monkey peach", "neck"};
    private String[] prices = {"1800元", "10元/kg", "300元", "350元", "10元/kg", "280元", "1$", "1$", "2$", "2$", "3$", "4$"};
    private int[] icons = {R.drawable.table, R.drawable.apple, R.drawable.cake, R.drawable.wireclothes, R.drawable.kiwifruit, R.drawable.scarf,
            R.drawable.table, R.drawable.apple, R.drawable.cake, R.drawable.wireclothes, R.drawable.kiwifruit, R.drawable.scarf
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        ListView mListView =  findViewById(R.id.lv_lv);
        mListView.setAdapter(new MyBaseAdapter());
    }

    /**
     * Data Adapter Class
     */
    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            View view = View.inflate(MainActivity.this, R.layout.list_item, null);
//            TextView title = (TextView) view.findViewById(R.id.title);
//            TextView price = (TextView) view.findViewById(R.id.price);
//            ImageView iv = (ImageView) view.findViewById(R.id.iv);
//            title.setText(titles[position]);
//            price.setText(prices[position]);
//            iv.setBackgroundResource(icons[position]);
//            return view;

            ViewHolder holder = new ViewHolder();
            if (convertView == null) {
                convertView = View.inflate(ListViewMainActivity.this, R.layout.list_item, null);
                holder.title = convertView.findViewById(R.id.lv_title);
                holder.price = convertView.findViewById(R.id.lv_price);
                holder.iv = convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }

    }

    /**
     * View Holder Class
     */
    static class ViewHolder {
        TextView title;
        TextView price;
        ImageView iv;
    }
}
