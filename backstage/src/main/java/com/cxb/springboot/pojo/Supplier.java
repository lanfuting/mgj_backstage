package com.cxb.springboot.pojo;

public class Supplier {
    private Integer gtid;

    private String slogname;

    private String spassword;

    private String ssalt;

    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public String getSlogname() {
        return slogname;
    }

    public void setSlogname(String slogname) {
        this.slogname = slogname == null ? null : slogname.trim();
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword == null ? null : spassword.trim();
    }

    public String getSsalt() {
        return ssalt;
    }

    public void setSsalt(String ssalt) {
        this.ssalt = ssalt == null ? null : ssalt.trim();
    }
}