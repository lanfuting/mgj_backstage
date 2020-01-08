package com.cxb.springboot.pojo;

public class Scrollimgs {
    private Integer sid;

    private String simgurl;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSimgurl() {
        return simgurl;
    }

    public void setSimgurl(String simgurl) {
        this.simgurl = simgurl == null ? null : simgurl.trim();
    }
}