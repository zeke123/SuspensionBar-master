package com.xiaopo.flying.suspensionbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopo.flying.suspensionbar.bean.BackDatas;
import com.xiaopo.flying.suspensionbar.bean.TimeBean;
import com.xiaopo.flying.suspensionbar.view.MyListview;
import com.xiaopo.flying.suspensionbar.R;

import java.util.List;


/**
 * Created by 周建 on 16-11-4.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

    private static final String TAG = "FeedAdapter";
    private Context context;
//    private BackDatas mBackDatas;
    private List<TimeBean> timeBeanList;

    public FeedAdapter(Context context) {
        this.context = context;
//        this.mBackDatas = mBackDatas;
    }

    @Override
    public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedHolder holder, int position) {

//
//        holder.tv_day.setText(mBackDatas.getStatusBeanList().get(position).getDay_time());
//        holder.tv_week.setText(mBackDatas.getStatusBeanList().get(position).getWeek_time());

//        timeBeanList = mBackDatas.getStatusBeanList().get(position).getTimeBeanList();
//        ListViewAdapter adapter = new ListViewAdapter(context,timeBeanList);
//


        holder.tv_day.setText("今天");
        holder.tv_week.setText("周五");

        ListViewAdapter adapter = new ListViewAdapter(context);
//
        holder.listview.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public static class FeedHolder extends RecyclerView.ViewHolder {
        TextView tv_day;
        TextView tv_week;
        MyListview listview;

        public FeedHolder(View itemView) {
            super(itemView);
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_week = (TextView) itemView.findViewById(R.id.tv_week);
            listview = (MyListview) itemView.findViewById(R.id.listview);
        }
    }
}
