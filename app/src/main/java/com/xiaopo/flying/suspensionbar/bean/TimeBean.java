package com.xiaopo.flying.suspensionbar.bean;

public class TimeBean {

    private String code;
    private String data_time;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    @Override
    public String toString() {
        return "TimeBean{" +
                "code=" + code +
                ", data_time='" + data_time + '\'' +
                '}';
    }
}
