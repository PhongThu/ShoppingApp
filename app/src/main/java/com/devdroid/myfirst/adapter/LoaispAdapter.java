package com.devdroid.myfirst.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.devdroid.myfirst.R;
import com.devdroid.myfirst.model.Loaisp;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayloaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayloaisp, Context context) {
        this.arrayloaisp = arrayloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayloaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayloaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.donglistview,null);
            viewHolder.txttenloaisp = view.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHolder);

            }else{
                viewHolder = (ViewHolder) view.getTag();
                Loaisp loaisp = (Loaisp) getItem(i);
                viewHolder.txttenloaisp.setText(loaisp.getTenloaisp());

        }
        return null;
    }
}
