package com.example.optap2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnOT1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetView();
        Event();
    }
    //Ánh Xạ View
    private void GetView()
    {
        BtnOT1=(Button)findViewById(R.id.btnOntap1);
    }
    //Tạo Event
    private void Event()
    {
        BtnOT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ontap1();
            }
        });
    }
    private void Ontap1()
    {
        //khởi tạo và thiết lập
        Intent intentOntap1=new Intent(this,ActivityOntap1.class);
        //Mở Trang Chủ
        startActivity(intentOntap1);
    }
}