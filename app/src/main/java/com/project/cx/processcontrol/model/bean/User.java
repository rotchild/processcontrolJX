package com.project.cx.processcontrol.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class User {
    @SerializedName("userid")
    String userid;

    @SerializedName("username")
    String username;

    @SerializedName("token")
    String token;

    @SerializedName("frontrole")
    String frontrole;

    @SerializedName("realname")
    String realname;

    @SerializedName("mobile")
    String mobile;

    @SerializedName("jobNo")
    String jobNo;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFrontrole() {
        return frontrole;
    }

    public void setFrontrole(String frontrole) {
        this.frontrole = frontrole;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    @Override
    public String toString() {
        return "User{"+"userid='"+userid+'\''+
                ",username='"+username+'\''+
                ",token='"+token+'\''+
                ",frontrole='"+frontrole+'\''+
                ",realname='"+realname+'\''+
                ",mobile='"+mobile+'\''+
                ",jobNo='"+jobNo+'\''+
                "}";
    }
}
