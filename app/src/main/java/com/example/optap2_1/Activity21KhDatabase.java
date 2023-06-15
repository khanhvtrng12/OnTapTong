package com.example.optap2_1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Activity21KhDatabase extends SQLiteOpenHelper {
    public Activity21KhDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public void QueryData(String sql)
    {
        SQLiteDatabase database= getWritableDatabase();
        database.execSQL(sql);


    }
    Cursor QueryGetData (String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS KHOAHOC(ID INTEGER PRIMARY KEY AUTOINCREMENT, TENKHOAHOC VARCHAR(200), HOCPHI VARCHAR(200))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
