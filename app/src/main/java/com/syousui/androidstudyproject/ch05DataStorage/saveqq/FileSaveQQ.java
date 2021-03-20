package com.syousui.androidstudyproject.ch05DataStorage.saveqq;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSaveQQ {
    public static boolean saveUser(String account, String password, Context context) {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("data.txt", Context.MODE_PRIVATE);
            fos.write((account + ":" + password).getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> getUser(Context context) {
        FileInputStream fis = null;
        Map<String, String> userMap = null;
        try {
            // get file input stream.
            fis = context.openFileInput("data.txt");
            // declare a byte array whose size is equal to FileInputStream to receive data.
            byte[] buffer = new byte[fis.available()];
            // write data from FileInputStream to byte array.
            fis.read(buffer);
            // use String to restore byte data, and split string to get two items(account & password).
            String[] userInfos = new String(buffer).split(":");
            userMap = new HashMap<String, String>();
            userMap.put("account", userInfos[0]);
            userMap.put("password", userInfos[1]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userMap;
    }
}
