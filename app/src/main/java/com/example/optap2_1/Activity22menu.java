package com.example.optap2_1;

import static com.example.optap2_1.R.menu.menu_ot22;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.optap2_1.Controller.CongViecController;
import com.example.optap2_1.Model.CongViec;
import com.example.optap2_1.Service.CongViec_DBHelper;

public class Activity22menu extends AppCompatActivity
{
    Button btnSave, btnClose;

    EditText editName, editTime;
    CongViec_DBHelper dbCongViec;
    CongViecController congViecController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22_tcv);

        editName = (EditText) findViewById(R.id.editName);
        editTime = (EditText) findViewById(R.id.editTime);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnClose = (Button) findViewById(R.id.btnClose);

        dbCongViec = new CongViec_DBHelper(this);
        congViecController = new CongViecController(this);
        congViecController.open();
        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String time = editTime.getText().toString();
            CongViec congViec = new CongViec();
            congViec.setTenCV(name);
            congViec.setThoiGianThucHien(time);
            congViecController.addCongViec(congViec);
            Toast.makeText(Activity22menu.this, "Đã thêm thành công", Toast.LENGTH_SHORT).show();
        });

        btnClose.setOnClickListener(v -> {
            Intent intent = new Intent(Activity22menu.this, Activiy22.class);
            startActivity(intent);
        });




    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item)
    {
        int itemnumber=item.getItemId();
        if(itemnumber==R.id.tcv)
        {
            Intent intentOntap22menu=new Intent(this,Activity22menu.class);
            //Mở Trang Chủ
            startActivity(intentOntap22menu);
        }
        else
            Toast.makeText(Activity22menu.this,"loi64",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
