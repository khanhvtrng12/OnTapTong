package com.example.optap2_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Activity21KhAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<Activity21KH> khoaHocList;

    public Activity21KhAdapter(Context context, int layout, List<Activity21KH> khoaHocList) {
        this.context = context;
        Layout = layout;
        this.khoaHocList = khoaHocList;
    }
    @Override
    public int getCount() {
        return khoaHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return khoaHocList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return khoaHocList.get(position).getID();
    }
    private class Viewholder
    {
        TextView txtViewId;
        TextView txtViewten;
        TextView txtViewHP;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;

        if (convertView == null) {
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(Layout,null);
            holder.txtViewId=(TextView) convertView.findViewById(R.id.txt_stt);
            holder.txtViewten=(TextView) convertView.findViewById(R.id.txt_khoahoc);
            holder.txtViewHP=(TextView) convertView.findViewById(R.id.txt_hocphi);
            convertView.setTag(holder);
        }else {
            holder = (Viewholder) convertView.getTag();
        }
        Activity21KH khoahoc = khoaHocList.get(position);
        holder.txtViewId.setText(khoahoc.toString());
        holder.txtViewten.setText(khoahoc.getTen());
        holder.txtViewHP.setText(String.valueOf(khoahoc.getHocPhi()));
        return convertView;
    }

}
