package com.example.optap2_1;

import static com.example.optap2_1.R.menu.menu_ot22;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Activity22menu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22_tcv);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(menu_ot22,menu);
        return true;
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
