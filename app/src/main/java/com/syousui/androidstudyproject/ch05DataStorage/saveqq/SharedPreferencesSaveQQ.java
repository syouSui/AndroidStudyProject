package com.syousui.androidstudyproject.ch05DataStorage.saveqq;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SharedPreferencesSaveQQ {
    public static boolean saveUser(Context context, String account, String password) {
        SharedPreferences.Editor edit = context.getSharedPreferences(
                "data", Context.MODE_PRIVATE
        ).edit();
        edit.putString("userName", account);
        edit.putString("pwd", password);
        edit.apply();
        return true;
    }

    public static Map<String, String> getUser(Context context) {
        SharedPreferences sp = context.getSharedPreferences(
                "data", Context.MODE_PRIVATE
        );
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("account", sp.getString("userName", null));
        userMap.put("password", sp.getString("pwd", null));
        return userMap;
    }
}
