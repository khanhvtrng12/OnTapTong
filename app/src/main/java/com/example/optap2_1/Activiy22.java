package com.example.optap2_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.optap2_1.Controller.CongViecController;
import com.example.optap2_1.Model.CongViec;
import com.example.optap2_1.Service.CongViecAdapter;
import com.example.optap2_1.Service.CongViec_DBHelper;

import java.util.ArrayList;

public class Activiy22 extends AppCompatActivity {

    ListView listCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViec_DBHelper dbCongViec;
    CongViecController congViecController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22);
        Log.i("arrayCongViec", "arrayCongViec");
        listCongViec = (ListView) findViewById(R.id.listCongViec);
        dbCongViec = new CongViec_DBHelper(this);
        congViecController = new CongViecController(this);
        congViecController.open();
        arrayCongViec = congViecController.getAllCongViec();

        // print arraylist

        congViecController.close();
        CongViecAdapter adapter = new CongViecAdapter(this, R.layout.activity_custom_lst_v22, arrayCongViec);
        listCongViec.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ot22, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tcv:
                Intent intentOntap22menu = new Intent(this, Activity22menu.class);
                //Mở Trang Chủ
                startActivity(intentOntap22menu);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
