package com.project.cx.processcontrol.net.service;

import com.project.cx.processcontrol.model.bean.Response;
import com.project.cx.processcontrol.model.bean.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public interface AccountService {
    @FormUrlEncoded
    @POST("api/AuthSystem/Loginin")
    Observable<Response<User>> login(@Field("username") String username, @Field("password") String password);
}
