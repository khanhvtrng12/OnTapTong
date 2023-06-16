package com.example.optap2_1.Service;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.optap2_1.Model.CongViec;
import com.example.optap2_1.R;

import java.util.ArrayList;
import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private ArrayList<CongViec> listCongViec;

    public CongViecAdapter(Context context, int layout, ArrayList<CongViec> listCongViec) {
        this.context = context;
        Layout = layout;
        this.listCongViec = listCongViec;
    }
    @Override
    public int getCount() {
        return listCongViec.size();
    }

    @Override
    public Object getItem(int position) {
        return listCongViec.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCongViec.get(position).getId();
    }
    private class Viewholder {
        TextView txtVId;
        TextView txtVTen;
        TextView txtVThoiGian;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;

        if (convertView == null) {
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(Layout,null);
            holder.txtVId=(TextView) convertView.findViewById(R.id.txt_stt);
            holder.txtVTen=(TextView) convertView.findViewById(R.id.txtCongViec);
            holder.txtVThoiGian=(TextView) convertView.findViewById(R.id.txtThoiGian);
            convertView.setTag(holder);
        }else {
            holder = (Viewholder) convertView.getTag();
        }
        CongViec congViec = listCongViec.get(position);
        holder.txtVId.setText(congViec.getId()+"");
        holder.txtVTen.setText(congViec.getTenCV());
        holder.txtVThoiGian.setText(congViec.getThoiGianThucHien());
        return convertView;
    }

}
