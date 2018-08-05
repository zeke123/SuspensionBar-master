package com.xiaopo.flying.suspensionbar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaopo.flying.suspensionbar.R;
import com.xiaopo.flying.suspensionbar.bean.TimeBean;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    //    private List<TimeBean> timeBeanList;
    private LayoutInflater inflator;

    public ListViewAdapter(Context context) {
        super();
        this.context = context;
//        this.timeBeanList = timeBeanList;
        inflator = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflator.inflate(R.layout.list_item, null);
            viewHolder.text = (TextView) view.findViewById(R.id.text);
            viewHolder.image = (ImageView) view.findViewById(R.id.image);
            viewHolder.two = (View) view.findViewById(R.id.two);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
//        viewHolder.text.setText(timeBeanList.get(position).getData_time());
//        if ("0".equals(timeBeanList.get(position).getCode())) {
//            viewHolder.image.setBackgroundResource(R.drawable.sharp_red);
//        } else {
//            viewHolder.image.setBackgroundResource(R.drawable.sharp);
//        }
//
//        if (position == timeBeanList.size() - 1) {
//            viewHolder.two.setVisibility(View.GONE);
//        } else {
//
//            viewHolder.two.setVisibility(View.VISIBLE);
//        }

        viewHolder.text.setText("12:10  关闭");
        if (position == 0) {
            viewHolder.image.setBackgroundResource(R.drawable.sharp_red);
        } else {
            viewHolder.image.setBackgroundResource(R.drawable.sharp);
        }

        if (position == 2) {
            viewHolder.two.setVisibility(View.GONE);
        } else {

            viewHolder.two.setVisibility(View.VISIBLE);
        }


        return view;
    }

    public static class ViewHolder {
        TextView text;
        ImageView image;
        View two;
    }
}
