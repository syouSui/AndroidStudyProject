package com.syousui.androidstudyproject.ch06notepad.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.syousui.androidstudyproject.ch06notepad.bean.NotepadBean;
import com.syousui.androidstudyproject.ch06notepad.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;
    //创建数据库
    public SQLiteHelper(Context context){
        super(context, DBUtil.DATABASE_NAME, null, DBUtil.DATABASE_VERION);
        sqLiteDatabase = this.getWritableDatabase();
    }
    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ DBUtil.DATABASE_TABLE+"("+ DBUtil.NOTEPAD_ID+
                " integer primary key autoincrement,"+ DBUtil.NOTEPAD_CONTENT +
                " text," + DBUtil.NOTEPAD_TIME+ " text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    //添加数据
    public boolean insertData(String userContent, String userTime){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBUtil.NOTEPAD_CONTENT,userContent);
        contentValues.put(DBUtil.NOTEPAD_TIME,userTime);
        return
                sqLiteDatabase.insert(DBUtil.DATABASE_TABLE,null,contentValues)>0;
    }
    //删除数据
    public boolean deleteData(String id){
        String sql= DBUtil.NOTEPAD_ID+"=?";
        String[] contentValuesArray=new String[]{String.valueOf(id)};
        return
                sqLiteDatabase.delete(DBUtil.DATABASE_TABLE,sql,contentValuesArray)>0;
    }
    //修改数据
    public boolean updateData(String id, String content, String userYear){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBUtil.NOTEPAD_CONTENT,content);
        contentValues.put(DBUtil.NOTEPAD_TIME,userYear);
        String sql= DBUtil.NOTEPAD_ID+"=?";
        String[] strings=new String[]{id};
        return
                sqLiteDatabase.update(DBUtil.DATABASE_TABLE,contentValues,sql,strings)>0;
    }
    //查询数据
    public List<NotepadBean> query(){
        List<NotepadBean> list=new ArrayList<NotepadBean>();
        Cursor cursor=sqLiteDatabase.query(DBUtil.DATABASE_TABLE,null,null,null,
                null,null, DBUtil.NOTEPAD_ID+" desc");
        if (cursor!=null){
            while (cursor.moveToNext()){
                NotepadBean noteInfo=new NotepadBean();
                String id = String.valueOf(cursor.getInt
                        (cursor.getColumnIndex(DBUtil.NOTEPAD_ID)));
                String content = cursor.getString(cursor.getColumnIndex
                        (DBUtil.NOTEPAD_CONTENT));
                String time = cursor.getString(cursor.getColumnIndex
                        (DBUtil.NOTEPAD_TIME));
                noteInfo.setId(id);
                noteInfo.setNotepadContent(content);
                noteInfo.setNotepadTime(time);
                list.add(noteInfo);
            }
            cursor.close();
        }
        return list;
    }
}
