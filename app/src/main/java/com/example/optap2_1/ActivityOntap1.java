package com.example.optap2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityOntap1 extends AppCompatActivity {

    //khai báo imageview
    ImageView imgBao,imgGoogle,imgFb,imgCall,imgMess,imgGmail;
    Button btnQuayve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontap1);
        GetView();
        Event();
    }
    //Ánh Xạ View
    private void GetView()
    {
        btnQuayve=(Button)findViewById(R.id.quayvetrangchu);
        imgBao=(ImageView)findViewById(R.id.imageBongdaId);
        imgGoogle=(ImageView)findViewById(R.id.imageGGid);
        imgFb=(ImageView)findViewById(R.id.imageFbId);
        imgCall=(ImageView)findViewById(R.id.imageCallId);
        imgMess=(ImageView)findViewById(R.id.imageMessageid);
        imgGmail=(ImageView)findViewById(R.id.imageGGmailid);
    }
    //Thêm Sự Kiện Cho Các imageview
    private void Event()
    {
        imgBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageBao();
            }
        });

        imgGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageGoogle();
            }
        });

        imgFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageFb();
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneDia();
            }
        });

        imgMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendSms();
            }
        });

        imgGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendGmail();
            }
        });
        btnQuayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quayvetrangchu();
            }
        });

    }
    //Tạo Hàm Quayvetrangchu;
    private void quayvetrangchu()
    {
        //khởi tạo và thiết lập
        Intent intentTrangchu=new Intent(this,MainActivity.class);
        //Mở Trang Chủ
        startActivity(intentTrangchu);
    }
    //Tạo Hàm PageBao(Báo Bóng Đá)
    private void PageBao()
    {
        //khởi tạo và thiết lập
        Intent intentBongDa=new Intent();
        intentBongDa.setAction(Intent.ACTION_VIEW);
        //gán dữ liệu cho intent
        intentBongDa.setData(Uri.parse("http://bongdaplus.vn"));
        //Mở Cửa Sổ Trình Duyệt
        startActivity(intentBongDa);
    }
    //Tạo Hàm PageGoogle (Google)
    private void PageGoogle()
    {
        //khởi tạo và thiết lập
        Intent intentGoogle=new Intent();
        intentGoogle.setAction(Intent.ACTION_VIEW);
        //gán dữ liệu cho intent
        intentGoogle.setData(Uri.parse("http://Google.com"));
        //Mở Cửa Sổ Trình Duyệt
        startActivity(intentGoogle);
    }
    //Tạo Hàm PageFaceBook(FaceBook)
    private void PageFb()
    {
        //khởi tạo và thiết lập
        Intent intentFb=new Intent();
        intentFb.setAction(Intent.ACTION_VIEW);
        //gán dữ liệu cho intent
        intentFb.setData(Uri.parse("http://Fb.com"));
        //Mở Cửa Sổ Trình Duyệt
        startActivity(intentFb);
    }
    //Tạo Hàm SendGmail
    private void SendGmail()
    {
        //khởi tạo và thiết lập
        Intent intentGmail=new Intent();
        intentGmail.setAction(Intent.ACTION_SEND);
        //gán dữ liệu cho intent
        intentGmail.setData(Uri.parse("mailto:"));
        //gán dữ liệu cho mail
        intentGmail.setType("text/html");
        intentGmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"RicardoMilos@gmail.com"});
        intentGmail.putExtra(Intent.EXTRA_SUBJECT,"Đây là Tiêu Đề Của Email");
        intentGmail.putExtra(Intent.EXTRA_TEXT,"Đây là nội dung của email");
        //Mở Cửa Sổ Web mail
        startActivity(Intent.createChooser(intentGmail,"Gửi Email"));
    }
    //Tạo Hàm PhoneDia
    private void PhoneDia()
    {
        //khởi tạo và thiết lập
        Intent intentDia=new Intent();
        intentDia.setAction(Intent.ACTION_DIAL);
        //gán dữ liệu cho intent
        intentDia.setData(Uri.parse("tel:084933567479"));
        //Gọi
        startActivity(intentDia);
    }
    //Tạo Hàm SendSms
    private void SendSms()
    {
        //khởi tạo và thiết lập
        Intent intentSms=new Intent();
        intentSms.setAction(Intent.ACTION_SENDTO);
        //gán dữ liệu cho intent
        intentSms.putExtra("sms_body","Chào Bạn....");
        intentSms.setData(Uri.parse("sms:0933567679"));
        //Gọi
        startActivity(intentSms);
    }
}