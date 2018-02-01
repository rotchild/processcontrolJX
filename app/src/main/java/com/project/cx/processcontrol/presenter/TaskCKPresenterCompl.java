package com.project.cx.processcontrol.presenter;

import android.util.Log;

import com.project.cx.processcontrol.base.BasePresenter;
import com.project.cx.processcontrol.model.bean.TaskCK;
import com.project.cx.processcontrol.model.bean.TaskResponse;
import com.project.cx.processcontrol.net.RequestCallback;
import com.project.cx.processcontrol.net.RestApiClient;
import com.project.cx.processcontrol.view.IView.ITaskCKView;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public class TaskCKPresenterCompl extends BasePresenter<ITaskCKView> implements ITaskCKPresenter {
    RestApiClient mRestApiClient;
    public TaskCKPresenterCompl(){
        mRestApiClient=new RestApiClient();
    }

    @Override
    public void fetchCKData(Map<String, String> params) {
        mRestApiClient.businessService()
                .getTaskCK(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<TaskResponse<TaskCK>>(){
                    @Override
                    public void onResponse(TaskResponse<TaskCK> response) {
                        super.onResponse(response);
                        if(response.success.equals("success")){
                            getView().onFetchFinishView(response.data.dataList);
                        }else if(response.success.equals("false")){
                            getView().onTokenErr(response.err.message);
                        }

                    }

                    @Override
                    public void onFailure(String errMsg) {
                        super.onFailure(errMsg);
                        Log.e("taskckPresenter", errMsg);
                        getView().onTokenErr(errMsg);
                    }
                });
    }

    @Override
    public void setProcessBarVisibility(int visibility) {
        getView().onSetProgressBarVisiblity(visibility);
    }
}
