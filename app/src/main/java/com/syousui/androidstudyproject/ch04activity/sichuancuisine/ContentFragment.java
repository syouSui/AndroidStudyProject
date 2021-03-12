package com.syousui.androidstudyproject.ch04activity.sichuancuisine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.syousui.androidstudyproject.R;

public class ContentFragment extends Fragment {
    private TextView foodDescriptionTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        foodDescriptionTv = view.findViewById(R.id.food_description);
        // Show first the description of first food.
        setText(((FoodMainActivity) getActivity()).getFoodDescription()[0]);
        return view;
    }

    public void setText(String text) {
        foodDescriptionTv.setText(text);
    }
}
