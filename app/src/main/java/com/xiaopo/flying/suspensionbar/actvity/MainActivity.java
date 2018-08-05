package com.xiaopo.flying.suspensionbar.actvity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.xiaopo.flying.suspensionbar.R;
import com.xiaopo.flying.suspensionbar.adapter.FeedAdapter;
import com.xiaopo.flying.suspensionbar.bean.BackDatas;
import com.xiaopo.flying.suspensionbar.bean.StatusBean;
import com.xiaopo.flying.suspensionbar.bean.TimeBean;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnLoadmoreListener {
    private RecyclerView mFeedList;
    private RelativeLayout mSuspensionBar;
    private SmartRefreshLayout mRefreshLayout;
    private TextView tv_day;
    private TextView tv_week;
    private int mCurrentPosition = 0;
    private int mSuspensionHeight;
    private BackDatas mBackDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
        updateTimes();
    }

    private void initViews() {


        mSuspensionBar = (RelativeLayout)findViewById(R.id.suspension_bar);
        tv_day = (TextView)findViewById(R.id.tv_day);
        tv_week = (TextView)findViewById(R.id.tv_week);


        mRefreshLayout = (SmartRefreshLayout)findViewById(R.id.refreshLayout);
        mRefreshLayout.setEnableRefresh(false);
        ClassicsFooter footer = new ClassicsFooter(this);
        footer.setTextSizeTitle(14);
        footer.setAccentColor(Color.parseColor("#ffffff"));
        mRefreshLayout.setRefreshFooter(footer);
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(false);//取消内容不满一页时开启上拉加载功能
        mRefreshLayout.setEnableAutoLoadmore(true);
        mRefreshLayout.setOnLoadmoreListener(this);


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mFeedList = (RecyclerView) findViewById(R.id.feed_list);
        mFeedList.setLayoutManager(linearLayoutManager);



        mFeedList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = mSuspensionBar.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view != null) {
                    if (view.getTop() <= mSuspensionHeight) {
                        mSuspensionBar.setY(-(mSuspensionHeight - view.getTop()));
                    } else {
                        mSuspensionBar.setY(0);
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    updateTimes();
                    mSuspensionBar.setY(0);
                }
            }
        });
    }

    private void initDatas() {
        mBackDatas = new BackDatas();
        mBackDatas.setCurrent_status("关闭");
        mBackDatas.setCurrent_time("今天 12:30");
        ArrayList<StatusBean> statusBeanList = new ArrayList<>();
        StatusBean mStatusBean = new StatusBean();
        mStatusBean.setDay_time("今天");
        mStatusBean.setWeek_time("周五");
        ArrayList<TimeBean> timeBeanList = new ArrayList<>();
        TimeBean timeBean0 = new TimeBean();
        timeBean0.setCode("0");
        timeBean0.setData_time("12:10 关闭");
        timeBeanList.add(timeBean0);
        TimeBean timeBean1 = new TimeBean();
        timeBean1.setCode("1");
        timeBean1.setData_time("12:10 关闭");
        timeBeanList.add(timeBean1);
        TimeBean timeBean2 = new TimeBean();
        timeBean2.setCode("2");
        timeBean2.setData_time("12:10 关闭");
        timeBeanList.add(timeBean2);
        mStatusBean.setTimeBeanList(timeBeanList);
        statusBeanList.add(mStatusBean);
        mBackDatas.setStatusBeanList(statusBeanList);
        final FeedAdapter adapter = new FeedAdapter(this);
        mFeedList.setAdapter(adapter);
        mFeedList.setHasFixedSize(true);

    }

    private void updateTimes() {
        tv_day.setText("今天");
        tv_week.setText("周五");
    }


    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        refreshlayout.finishLoadmore();
    }
}
