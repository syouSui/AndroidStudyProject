package com.syousui.androidstudyproject.ch05DataStorage.saveqq;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.syousui.androidstudyproject.R;

import java.util.Map;

public class SaveQQMainActivity extends AppCompatActivity {
    private EditText et_account;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_saveqq);
        et_account = (EditText) findViewById(R.id.ds_sq_et_account);
        et_password = (EditText) findViewById(R.id.ds_sq_et_password);
        ((Button) findViewById(R.id.ds_sq_btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.ds_sq_btn_login:
                        String account = et_account.getText().toString().trim();
                        String password = et_password.getText().toString();
                        if (TextUtils.isEmpty(account)) {
                            Toast.makeText(SaveQQMainActivity.this, "Please input the account of QQ.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(password)) {
                            Toast.makeText(SaveQQMainActivity.this, "Please input the password of QQ.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        // Simulate successful login.
                        Toast.makeText(SaveQQMainActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                        boolean isSaveSuccess = FileSaveQQ.saveUser(account, password, SaveQQMainActivity.this);
                        Toast.makeText(
                                SaveQQMainActivity.this,
                                isSaveSuccess ? "Save successfully!" : "Save failed!",
                                Toast.LENGTH_SHORT
                        ).show();
//                        if (isSaveSuccess) {
//                            Toast.makeText(DataStorageMainActivity.this, "Save successfully!", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(DataStorageMainActivity.this, "Save failed!", Toast.LENGTH_SHORT).show();
//                        }
                        break;
                }
            }
        });
        Map<String, String> userInfo = FileSaveQQ.getUser(this);
        if (userInfo != null) {
            et_account.setText(userInfo.get("account"));
            et_password.setText(userInfo.get("password"));
        }
    }
}

