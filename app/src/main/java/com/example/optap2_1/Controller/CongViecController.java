package com.example.optap2_1.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.optap2_1.Model.CongViec;
import com.example.optap2_1.Service.OT2_2_DBHelper;

import java.util.ArrayList;
import java.util.List;


public class CongViecController {
    private final OT2_2_DBHelper OT2_2_DBHelper;
    private SQLiteDatabase database;
    public CongViecController(Context context) {
        OT2_2_DBHelper = new OT2_2_DBHelper(context);
    }

    public void open() {
        database = OT2_2_DBHelper.getWritableDatabase();
    }

    public void close() {
        OT2_2_DBHelper.close();
    }

    public void addCongViec(CongViec CongViec) {
        ContentValues values = new ContentValues();
        values.put(com.example.optap2_1.Service.OT2_2_DBHelper.COLUMN_TENCV, CongViec.getTenCV());
        values.put(com.example.optap2_1.Service.OT2_2_DBHelper.COLUMN_THOIGIANTHUCHIEN, CongViec.getThoiGianThucHien());

        // insert row
        long id = database.insert(com.example.optap2_1.Service.OT2_2_DBHelper.TABLE_NAME, null, values);
        CongViec.setId((int) id);
    }

    public List<CongViec> getAllCongViec() {
        List<CongViec> CongViecs = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + com.example.optap2_1.Service.OT2_2_DBHelper.TABLE_NAME;
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
        values.put(com.example.optap2_1.Service.OT2_2_DBHelper.COLUMN_TENCV, CongViec.getTenCV());
        values.put(com.example.optap2_1.Service.OT2_2_DBHelper.COLUMN_THOIGIANTHUCHIEN, CongViec.getThoiGianThucHien());

        // update row
        database.update(com.example.optap2_1.Service.OT2_2_DBHelper.TABLE_NAME,
                values,
                com.example.optap2_1.Service.OT2_2_DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(CongViec.getId())});
    }

    public void deleteCongViec(CongViec CongViec) {
        // delete row
        database.delete(com.example.optap2_1.Service.OT2_2_DBHelper.TABLE_NAME,
                com.example.optap2_1.Service.OT2_2_DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(CongViec.getId())});
    }
}