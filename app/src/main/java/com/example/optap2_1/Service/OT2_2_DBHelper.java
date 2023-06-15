package com.example.optap2_1.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class OT2_2_DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "congviec.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "CONGVIEC";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_TENCV = "TenCV";
    public static final String COLUMN_THOIGIANTHUCHIEN = "ThoiGianThucHien";

    public OT2_2_DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_TENCV + " NVARCHAR(80),"
                + COLUMN_THOIGIANTHUCHIEN + " NVARCHAR(80)"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // create table again
        onCreate(db);
    }
}
