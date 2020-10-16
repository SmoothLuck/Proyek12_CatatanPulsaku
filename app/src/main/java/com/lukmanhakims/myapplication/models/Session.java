package com.lukmanhakims.myapplication.models;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    public static final String SP_Tiens_APP = "spTiens";
    public static final String SP_Has_Login = "hasLogin";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public Session(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SP_Tiens_APP, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }
    public void saveString(String key, String val){
        editor.putString(key, val);
        editor.commit();
    }

    public void saveInt(String key, int val){
        editor.putInt(key, val);
        editor.commit();
    }
    public void saveBoolean(String key, boolean val){
        editor.putBoolean(key, val);
        editor.commit();
    }

    public boolean getHasLogin(){
        return sharedPreferences.getBoolean(SP_Has_Login, false);
    }

    public void doLogout(String key, boolean val) {

    }
}
