package com.example.optap2_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class Activity21 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);
    }
   @Override
   public boolean onCreateOptionsMenu(Menu m) {
       getMenuInflater().inflate(R.menu.menu_ot21, m);
       return true;
   }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
               finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}