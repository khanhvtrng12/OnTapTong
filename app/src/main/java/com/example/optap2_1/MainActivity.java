package com.example.optap2_1;

import static com.example.optap2_1.R.menu.menu_ot22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button BtnOT1,BtnOT21,BtnOT22;
    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetView();
        Event();

    }


    //Ánh Xạ View
    private void GetView()
    {
        BtnOT1=(Button)findViewById(R.id.btnOntap1);
        BtnOT21=(Button)findViewById(R.id.btnOntap21);
        BtnOT22=(Button) findViewById(R.id.btnOntap22);
    }
    //Tạo Event
    private void Event()
    {
        BtnOT1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Ontap1();
            }
        });
        BtnOT21.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Ontap21();
            }
        });
        BtnOT22.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Ontap22();
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
    private void Ontap21()
    {
        //khởi tạo và thiết lập
        Intent intentOntap21=new Intent(this,Activity21.class);
        //Mở Trang Chủ
        startActivity(intentOntap21);
    }
    private void Ontap22()
    {
        //khởi tạo và thiết lập
        Intent intentOntap22=new Intent(this,Activiy22.class);
        //Mở Trang Chủ
        startActivity(intentOntap22);
    }
}