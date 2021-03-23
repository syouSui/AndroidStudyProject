package com.syousui.androidstudyproject.ch05DataStorage.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.syousui.androidstudyproject.R;

public class ContactsMainActivity extends AppCompatActivity {
    MySQLiteOpenHelper myHelper;
    private EditText editTextName;
    private EditText editTextPhone;
    private TextView textViewShow;
    private Button buttonAdd;
    private Button buttonQuery;
    private Button buttonUpdate;
    private Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contacts);
        this.getSupportActionBar().hide();
        myHelper = new MySQLiteOpenHelper(this);
        initializeLayout();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.getSupportActionBar().show();
    }

    private void initializeLayout() {
        editTextName = (EditText) findViewById(R.id.ds_ct_et_name);
        editTextPhone = (EditText) findViewById(R.id.ds_ct_et_phone);
        textViewShow = (TextView) findViewById(R.id.tv_show);
        buttonAdd = (Button) findViewById(R.id.ds_ct_btn_add);
        buttonQuery = (Button) findViewById(R.id.ds_ct_btn_query);
        buttonUpdate = (Button) findViewById(R.id.ds_ct_btn_update);
        buttonDelete = (Button) findViewById(R.id.ds_ct_btn_delete);
        View.OnClickListener ButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, phone;
                SQLiteDatabase db;
                ContentValues values;
                switch (v.getId()) {
                    case R.id.ds_ct_btn_add:
                        name = editTextName.getText().toString().trim();
                        phone = editTextPhone.getText().toString().trim();
                        db = myHelper.getWritableDatabase();
                        values = new ContentValues();
                        values.put("name", name);
                        values.put("phone", phone);
                        db.insert("information", null, values);
                        Toast.makeText(ContactsMainActivity.this, "Information added.", Toast.LENGTH_SHORT).show();
                        db.close();
                        break;
                    case R.id.ds_ct_btn_query:
                        db = myHelper.getReadableDatabase();
                        Cursor cursor = db.query("information", null, null, null, null, null, null);
                        if (cursor.getCount() == 0) {
                            textViewShow.setText("");
                            Toast.makeText(ContactsMainActivity.this, "No data.", Toast.LENGTH_SHORT).show();
                        } else {
                            cursor.moveToFirst();
                            textViewShow.setText("Name :  " + cursor.getString(1) + "  ；Tel :  " + cursor.getString(2));
                        }
                        while (cursor.moveToNext()) {
                            textViewShow.append("\n" + "Name :  " + cursor.getString(1) + "  ；Tel :  " + cursor.getString(2));
                        }
                        cursor.close();
                        db.close();
                        break;
                    case R.id.ds_ct_btn_update:
                        db = myHelper.getWritableDatabase();
                        values = new ContentValues();
                        values.put("phone", phone = editTextPhone.getText().toString());
                        db.update("information", values, "name=?", new String[]{editTextName.getText().toString()});
                        Toast.makeText(ContactsMainActivity.this, "Information modified.", Toast.LENGTH_SHORT).show();
                        db.close();
                        break;
                    case R.id.ds_ct_btn_delete:
                        db = myHelper.getWritableDatabase();
                        db.delete("information", null, null);
                        Toast.makeText(ContactsMainActivity.this, "Information deleted.", Toast.LENGTH_SHORT).show();
                        textViewShow.setText("");
                        db.close();
                        break;
                }
            }
        };
        buttonAdd.setOnClickListener(ButtonListener);
        buttonQuery.setOnClickListener(ButtonListener);
        buttonUpdate.setOnClickListener(ButtonListener);
        buttonDelete.setOnClickListener(ButtonListener);
    }
}

class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context) {
        super(context, "MungBeanContacts.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20),  phone VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
