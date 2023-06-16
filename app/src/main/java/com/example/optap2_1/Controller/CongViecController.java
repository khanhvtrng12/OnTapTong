package com.example.optap2_1.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.optap2_1.Model.CongViec;
import com.example.optap2_1.Service.CongViec_DBHelper;

import java.util.ArrayList;
import java.util.List;


public class CongViecController {
    private final CongViec_DBHelper CongViec_DBHelper;
    private SQLiteDatabase database;
    public CongViecController(Context context) {
        CongViec_DBHelper = new CongViec_DBHelper(context);
    }

    public void open() {
        database = CongViec_DBHelper.getWritableDatabase();
    }

    public void close() {
        CongViec_DBHelper.close();
    }

    public void addCongViec(CongViec CongViec) {
        ContentValues values = new ContentValues();
        values.put(CongViec_DBHelper.COLUMN_TENCV, CongViec.getTenCV());
        values.put(CongViec_DBHelper.COLUMN_THOIGIANTHUCHIEN, CongViec.getThoiGianThucHien());

        // insert row
        long id = database.insert(CongViec_DBHelper.TABLE_NAME, null, values);
        CongViec.setId((int) id);
    }

    public ArrayList<CongViec> getAllCongViec() {
        ArrayList<CongViec> CongViecs = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + CongViec_DBHelper.TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                CongViec CongViec = new CongViec();
                CongViec.setId(cursor.getInt(0));
                CongViec.setTenCV(cursor.getString(1));
                CongViec.setThoiGianThucHien(cursor.getString(2));
                CongViecs.add(CongViec);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return CongViecs;
    }

    public void updateCongViec(CongViec CongViec) {
        ContentValues values = new ContentValues();
        values.put(CongViec_DBHelper.COLUMN_TENCV, CongViec.getTenCV());
        values.put(CongViec_DBHelper.COLUMN_THOIGIANTHUCHIEN, CongViec.getThoiGianThucHien());

        // update row
        database.update(CongViec_DBHelper.TABLE_NAME,
                values,
                CongViec_DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(CongViec.getId())});
    }

    public void deleteCongViec(CongViec CongViec) {
        // delete row
        database.delete(CongViec_DBHelper.TABLE_NAME,
                CongViec_DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(CongViec.getId())});
    }
}