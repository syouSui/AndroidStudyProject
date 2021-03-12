package com.syousui.androidstudyproject.ch03widget.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syousui.androidstudyproject.R;

public class CustomDialog extends AlertDialog {
    private TextView titleTv;
    private TextView messageTv;
    private Button negativeBn, positiveBn;

    private String messageStr;
    private String titleStr;
    private String positiveStr, negativeStr;

    public interface OnClickBottomListener {
        void onPositiveClick();

        void onNegativeClick();
    }

    public OnClickBottomListener onClickBottomListener;

    public CustomDialog(Context context) {
        super(context);
    }

//    public CustomDialog(Context context, String titleStr, String messageStr, String positiveStr, String negativeStr, OnClickBottomListener onClickBottomListener) {
//        super(context);
//        this.titleStr = titleStr;
//        this.messageStr = messageStr;
//        this.positiveStr = positiveStr;
//        this.negativeStr = negativeStr;
//        this.onClickBottomListener = onClickBottomListener;
//    }

    public CustomDialog setMessageStr(String messageStr) {
        this.messageStr = messageStr;
        return this;
    }

    public CustomDialog setTitleStr(String titleStr) {
        this.titleStr = titleStr;
        return this;
    }

    public CustomDialog setPositiveStr(String positiveStr) {
        this.positiveStr = positiveStr;
        return this;
    }

    public CustomDialog setNegativeStr(String negtive) {
        this.negativeStr = negtive;
        return this;
    }

    public CustomDialog setOnClickBottomListener(OnClickBottomListener onClickBottomListener) {
        this.onClickBottomListener = onClickBottomListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        // init view
        negativeBn = findViewById(R.id.negtive);
        positiveBn = findViewById(R.id.positive);
        titleTv = findViewById(R.id.title);
        messageTv = findViewById(R.id.message);
        // init event
        positiveBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener != null) {
                    onClickBottomListener.onPositiveClick();
                }
            }
        });
        negativeBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickBottomListener != null) {
                    onClickBottomListener.onNegativeClick();
                }
            }
        });
    }

    @Override
    public void show() {
        super.show();
        // If there NOT exists title, then hide title.
        if (!TextUtils.isEmpty(titleStr)) {
            titleTv.setText(titleStr);
            titleTv.setVisibility(View.VISIBLE);
        } else {
            titleTv.setVisibility(View.GONE);
        }
        messageTv.setText(messageStr);
        positiveBn.setText(!TextUtils.isEmpty(positiveStr) ? positiveStr : "Yeah");
        negativeBn.setText(!TextUtils.isEmpty(negativeStr) ? negativeStr : "Cancel");
    }
}
