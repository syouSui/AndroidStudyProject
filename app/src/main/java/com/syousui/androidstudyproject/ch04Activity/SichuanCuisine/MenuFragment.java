package com.syousui.androidstudyproject.ch04Activity.SichuanCuisine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.syousui.androidstudyproject.R;

@SuppressLint("NewApi")
public class MenuFragment extends Fragment {
    private int[] foodIcons;
    private String[] foodNames;
    private String[] foodDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FoodMainActivity activity = (FoodMainActivity) getActivity();
        foodIcons = activity.getIcons();
        foodNames = activity.getNames();
        foodDescription = activity.getFoodDescription();

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView menuListView = (ListView) view.findViewById(R.id.menulist);
        menuListView.setAdapter(new MyAdapter());
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                (
                        (ContentFragment) ((FoodMainActivity) getActivity())
                                .getSupportFragmentManager()
                                .findFragmentById(R.id.food_description)
                ).setText(foodDescription[i]);
            }
        });
        return view;
    }

    /**
     * Data Adapter for ListView
     */
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foodIcons.length;
        }

        @Override
        public Object getItem(int position) {
            return foodIcons[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getActivity(), R.layout.item_list, null);
            ((ImageView) convertView.findViewById(R.id.food_icon))
                    .setBackgroundResource(foodIcons[position]);
            ((TextView) convertView.findViewById(R.id.food_name))
                    .setText(foodNames[position]);
            return convertView;
        }
    }
}
