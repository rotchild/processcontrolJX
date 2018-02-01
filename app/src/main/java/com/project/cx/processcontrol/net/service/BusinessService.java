package com.project.cx.processcontrol.net.service;

import com.project.cx.processcontrol.model.bean.TaskCK;
import com.project.cx.processcontrol.model.bean.TaskResponse;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public interface BusinessService {
    //@FormUrlEncoded
    @POST("api/AuthSystem/GetTask_ck")
    Observable<TaskResponse<TaskCK>> getTaskCK(@QueryMap Map<String,String> map);

}
