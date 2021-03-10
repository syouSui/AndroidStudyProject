package com.syousui.androidstudyproject.ch04Activity.SichuanCuisine;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.syousui.androidstudyproject.R;

public class ContentFragment extends Fragment {
    private TextView foodDescription;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        if (view != null) {
            foodDescription = (TextView) view.findViewById(R.id.food_description);
        }
        // Show first the description of first food.
        setText(
                ((FoodMainActivity) getActivity()).getFoodDescription()[0]
        );
        return view;
    }

    public void setText(String text) {
        foodDescription.setText(text);
    }
}
