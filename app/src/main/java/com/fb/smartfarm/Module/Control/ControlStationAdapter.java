package com.fb.smartfarm.Module.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fb.smartfarm.R;
import com.fb.smartfarm.ViewHolder;

import java.util.List;

/**
 * Created by echo on 2017/5/26.
 */

public class ControlStationAdapter extends BaseAdapter{
    private Context context;
    private List mlist;

    public ControlStationAdapter(Context ctx,List<String> list){
        this.context = ctx;
        this.mlist = list;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_control_station,null,true);
        }
        TextView textView = ViewHolder.get(convertView,R.id.tv_control_info);
        textView.setText(mlist.get(position).toString());
        return convertView;
    }
}
