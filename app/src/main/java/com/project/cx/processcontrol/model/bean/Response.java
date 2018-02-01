package com.project.cx.processcontrol.model.bean;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

import com.google.gson.annotations.SerializedName;

/**
 * 标准格式
 * @param <T>
 */
public class Response<T> {
    @SerializedName("err")
    public Err err;

    @SerializedName("success")
    public boolean success;

    @SerializedName("data")
    public T data;

    public class Err{
        @SerializedName("message")
        public String message;
    }
}
