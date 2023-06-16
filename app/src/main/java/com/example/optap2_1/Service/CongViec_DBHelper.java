package com.example.optap2_1.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CongViec_DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "congviec.db";
    public static final int DB_VERSION = 3;
    public static final String TABLE_NAME = "CONGVIEC";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_TENCV = "TenCV";
    public static final String COLUMN_THOIGIANTHUCHIEN = "ThoiGianThucHien";

    public CongViec_DBHelper(Context context) {
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
        // insert default CongViec
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(1,'Làm bài tập Android','Thứ 7, CN hàng tuần')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(2,'Viết báo công việc','Chiều thứ 2, 3, 4 hàng tuần')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(3,'Học tiếng Anh','Tối thứ 2, 4, 6 hàng tuần')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(4,'Đi học chính khóa','Sáng thứ 2, 3, 4, Chiều T5, 6 hàng tuần')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(5,'Tìm công việc làm thêm','Sáng thứ 5, 6 hàng tuần')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(6,'Sinh hoạt câu lạc bộ Kỹ Năng','Tối thứ 5 hàng tuần')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.d("CongViec", "onUpgrade: ");
        // create table again
        onCreate(db);
    }
}
