package com.syousui.androidstudyproject.ch04Activity.SichuanCuisine;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.syousui.androidstudyproject.R;

public class ContentFragment extends Fragment {
    private TextView mContent;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        if (view != null) {
            mContent = (TextView) view.findViewById(R.id.food_description);
        }
        setText(
                ((FoodMainActivity) getActivity()).getFoodDescription()[0]
        );
        return view;
    }

    public void setText(String text) {
        mContent.setText(text);
    }
}
