package com.project.cx.processcontrol.net;

import com.project.cx.processcontrol.context.AppConfig;
import com.project.cx.processcontrol.net.service.AccountService;
import com.project.cx.processcontrol.net.service.BusinessService;

import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class RestApiClient {
    //private Context mContext;
    private Retrofit mRetrofit;
    private File mCacheLocation;

    public RestApiClient() {
        //this.mContext = mContext;
    }

    private OkHttpClient newOkHttpClient(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        /*if(mCacheLocation!=null){
            File cacheDir=new File(mCacheLocation, UUID.randomUUID().toString());
            Cache cache=new Cache(cacheDir,1024);
        }*/
        builder.connectTimeout(AppConfig.CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        builder.readTimeout(AppConfig.READ_TIMEOUT_MILLIS,TimeUnit.MILLISECONDS);
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(AppConfig.DEBUG?HttpLoggingInterceptor.Level.BODY:HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(logging);
        return builder.build();
    }

    private Retrofit getRetrofit(){
        if(mRetrofit==null){
            Retrofit.Builder builder=new Retrofit.Builder();
            builder.client(newOkHttpClient());
            builder.baseUrl(AppConfig.SERVER_URL);
            builder.addConverterFactory(GsonConverterFactory.create());
            builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            mRetrofit=builder.build();

        }
        return mRetrofit;
    }

    public AccountService accountService(){
        return getRetrofit().create(AccountService.class);
    }
    public BusinessService businessService(){
        return getRetrofit().create(BusinessService.class);
    }
}
