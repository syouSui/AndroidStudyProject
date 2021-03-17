package com.syousui.androidstudyproject.ch04activity.sichuancuisine;

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

public class MenuFragment extends Fragment {
    private int[] foodIcons;
    private String[] foodNames;
    private String[] foodDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        FoodMainActivity activity = (FoodMainActivity) this.getActivity();
        foodIcons = activity.getIcons();
        foodNames = activity.getNames();
        foodDescription = activity.getFoodDescription();

        ListView menuListView = view.findViewById(R.id.menulist);
        /**
         * Data Adapter for ListView
         */
        class MyListViewAdapter extends BaseAdapter {
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
                convertView = View.inflate(MenuFragment.this.getActivity(), R.layout.fragment_menu_item_list, null);
                ((ImageView) convertView.findViewById(R.id.food_icon)).setBackgroundResource(foodIcons[position]);
                ((TextView) convertView.findViewById(R.id.food_name)).setText(foodNames[position]);
                return convertView;
            }
        }
        menuListView.setAdapter(new MyListViewAdapter());
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((ContentFragment)
                        (MenuFragment.this.getActivity())
                                .getSupportFragmentManager()
                                .findFragmentById(R.id.food_description)
                ).setText(foodDescription[i]);
            }
        });
        return view;
    }

}
