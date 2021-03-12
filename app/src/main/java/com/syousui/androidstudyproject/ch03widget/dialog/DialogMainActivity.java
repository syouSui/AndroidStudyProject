package com.syousui.androidstudyproject.ch03widget.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.syousui.androidstudyproject.MainActivity;
import com.syousui.androidstudyproject.R;

public class DialogMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialog);
        findViewById(R.id.d_sd_bt).setOnClickListener(new View.OnClickListener() {
            int textSizeIndex = 1; // It means the size of font is 20.
            int[] textSize = new int[]{10, 20, 25, 30, 40};

            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DialogMainActivity.this)
                        .setTitle("Set Font Size")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(new String[]{"small", "default", "middle", "large", "extra large"}, textSizeIndex,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        textSizeIndex = which;
                                    }
                                })
                        .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((TextView) findViewById(R.id.d_sd_tv)).setTextSize(textSize[textSizeIndex]);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
        findViewById(R.id.d_md_bt).setOnClickListener(new View.OnClickListener() {
            CharSequence[] items = new CharSequence[]{"Travel", "Delicious Food", "Watch a movie", "Sports"};
            boolean[] checkedItems = new boolean[]{false, true, false, false};

            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DialogMainActivity.this)
                        .setTitle("Please choice your hobby:")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkedItems[which] = isChecked;
                            }
                        })
                        .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < checkedItems.length; ++i) {
                                    if (checkedItems[i]) {
                                        stringBuilder.append(items[i]).append("\t");
                                    }
                                }
                                Toast.makeText(DialogMainActivity.this, " " + stringBuilder + " ", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
        findViewById(R.id.cd_btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomDialog dialog = new CustomDialog(DialogMainActivity.this)
                .setTitleStr("NOTICE!")
                .setMessageStr("Are you sure to delete the message?")
                .setPositiveStr("Sure!")
                .setNegativeStr("Later...");
                dialog.setOnClickBottomListener(
                        new CustomDialog.OnClickBottomListener() {
                            @Override
                            public void onPositiveClick() {
                                dialog.dismiss();
                            }

                            @Override
                            public void onNegativeClick() {
                                dialog.dismiss();
                            }
                        }
                ).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("CommonDialog")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Are you sure to exit?")
                .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        DialogMainActivity.this.finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
