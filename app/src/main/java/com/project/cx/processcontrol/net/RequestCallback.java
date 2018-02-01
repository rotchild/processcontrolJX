package com.project.cx.processcontrol.net;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class RequestCallback<T> extends Subscriber<T> {
    private static final String TAG = "RequestCallback";

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
/*        onFailure();
    if(e instanceof ResponseError){
        onFailure((ResponseError) e);
    }else{
        Log.e(TAG, "throwable isn't instance of ResponseError");
    }*/
        onFailure(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        onResponse(t);
    }

    public void onResponse(T response) {}

    public void onFailure(String errMsg){}

}
