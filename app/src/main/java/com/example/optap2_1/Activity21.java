package com.example.optap2_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity21 extends AppCompatActivity {
    Activity21KhDatabase khoahocdatabase;
    ListView lvkhoahoc;
    ArrayList<Activity21KH> arrayList;
    Activity21KhAdapter khoahocadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);
         lvkhoahoc = (ListView) findViewById(R.id.lvKhoaHoc);
        arrayList = new ArrayList<Activity21KH>();
        khoahocadapter= new Activity21KhAdapter(this,R.layout.activity_custom_lst_v21,arrayList);
        lvkhoahoc.setAdapter(khoahocadapter);
        //tạo Database
        khoahocdatabase=new Activity21KhDatabase(this,"QuanLyKhoaHoc.sqlite",null,1);
        //Xóa bảng
        String sqlDrop="DROP TABLE IF EXISTS KhoaHoc";
        khoahocdatabase.QueryData(sqlDrop);
        //Tạo bảng
        String sql="CREATE TABLE IF NOT EXISTS KhoaHoc(Id INTEGER PRIMARY KEY AUTOINCREMENT,Ten nvarchar(80),HocPhi nvarchar(20))";
        khoahocdatabase.QueryData(sql);

        InitDataKhoaHoc();
        LoadData();
    }
     void InitDataKhoaHoc()
    {
        String sqlinsert1="insert into KhoaHoc values(1,'Lập Trình Android','5000000')";
        String sqlinsert2="insert into KhoaHoc values(2,'Kỹ Thuật SEO Web','6500000')";
        String sqlinsert3="insert into KhoaHoc values(3,'Google Adwords','4500000')";
        khoahocdatabase.QueryData(sqlinsert1);
        khoahocdatabase.QueryData(sqlinsert2);
        khoahocdatabase.QueryData(sqlinsert3);
    }
    //load dữ liệu
    public void LoadData()
    {
        String sqlSeclect="SELECT * FROM KhoaHoc";
        Cursor dataKhoaHoc= khoahocdatabase.QueryGetData(sqlSeclect);

        arrayList.clear();;
        while (dataKhoaHoc.moveToNext())
        {
            int Id = dataKhoaHoc.getInt(0);
            String strTen=dataKhoaHoc.getString(1);
            String strHP=dataKhoaHoc.getString(2);
            //  Toast.makeText(this,strTen,Toast.LENGTH_LONG).show();
            arrayList.add(new Activity21KH(Id,strTen,strHP));
        }
        khoahocadapter.notifyDataSetChanged();
    }

   @Override
   public boolean onCreateOptionsMenu(Menu m) {
       getMenuInflater().inflate(R.menu.menu_ot21, m);
       return true;
   }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.CauHinh)
        {
            CustomToast.makeText(this, "Bạn Đã Chọn Cấu hình", Toast.LENGTH_LONG,CustomToast.SUCCESS,true).show();
        }else if (id == R.id.Thoat)
        {
            finish();
        }
                return super.onOptionsItemSelected(item);
        }
    }

