package com.xiaopo.flying.suspensionbar.bean;

import java.util.List;

public class StatusBean {

    private String day_time;
    private String week_time;
    private List<TimeBean> timeBeanList;

    public String getDay_time() {
        return day_time;
    }

    public void setDay_time(String day_time) {
        this.day_time = day_time;
    }

    public String getWeek_time() {
        return week_time;
    }

    public void setWeek_time(String week_time) {
        this.week_time = week_time;
    }

    public List<TimeBean> getTimeBeanList() {
        return timeBeanList;
    }

    public void setTimeBeanList(List<TimeBean> timeBeanList) {
        this.timeBeanList = timeBeanList;
    }

    @Override
    public String toString() {
        return "StatusBean{" +
                "day_time='" + day_time + '\'' +
                ", week_time='" + week_time + '\'' +
                ", timeBeanList=" + timeBeanList +
                '}';
    }
}
