package com.project.cx.processcontrol.context;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class AppConfig {
    //public static final String SERVER_URL = "http://116.196.81.196:7091/";
    public static final String SERVER_URL = "http://192.168.1.13:7091/";
    /**
     * 连接超时时间
     */
    public static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s

    /**
     * 响应超时时间
     */
    public static final int READ_TIMEOUT_MILLIS = 20 * 1000; // 20s

    public static final boolean DEBUG = true;//是否打印log
}
