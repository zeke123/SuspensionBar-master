package com.xiaopo.flying.suspensionbar.bean;

import java.util.List;

public class BackDatas {


    private String current_status;

    private String current_time;

    private List<StatusBean > statusBeanList;


    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public List<StatusBean> getStatusBeanList() {
        return statusBeanList;
    }

    public void setStatusBeanList(List<StatusBean> statusBeanList) {
        this.statusBeanList = statusBeanList;
    }

    @Override
    public String toString() {
        return "BackDatas{" +
                "current_status='" + current_status + '\'' +
                ", current_time='" + current_time + '\'' +
                ", statusBeanList=" + statusBeanList +
                '}';
    }
}
