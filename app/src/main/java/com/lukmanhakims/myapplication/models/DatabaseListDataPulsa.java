package com.lukmanhakims.myapplication.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lukmanhakims.myapplication.MainActivity;

public class DatabaseListDataPulsa extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notedatapulsa.db";
    private static final int DATABASE_VERSION = 1;
    private String sql;


    public DatabaseListDataPulsa(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "create table note(no integer primary key, nama text null, jumlah text null, deskripsi_status text null);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
