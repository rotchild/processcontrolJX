package com.project.cx.processcontrol.presenter;

import com.project.cx.processcontrol.base.BasePresenter;
import com.project.cx.processcontrol.model.bean.Response;
import com.project.cx.processcontrol.model.bean.User;
import com.project.cx.processcontrol.net.RequestCallback;
import com.project.cx.processcontrol.net.RestApiClient;
import com.project.cx.processcontrol.view.IView.ILoginView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class LoginPresenterCompl extends BasePresenter<ILoginView> implements ILoginPresenter{
    RestApiClient mRestApiClient;

    public LoginPresenterCompl() {
        mRestApiClient=new RestApiClient();

    }

    @Override
    public void doLogin(String name, String password) {
        mRestApiClient.accountService()
                .login(name,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<Response<User>>(){
                    @Override
                    public void onFailure(String error) {
                        super.onFailure(error);
                        getView().onLoginResult(error);
                    }

                    @Override
                    public void onResponse(Response<User> response) {
                        super.onResponse(response);
                        if(response.success){
                            getView().onLoginResult(response.data.toString());
                        }else{
                            getView().onLoginResult(response.err.message);
                        }

                    }
                });
    }

    @Override
    public void setProcessBarVisibility(int visibility) {
        getView().onSetProgressBarVisiblity(visibility);
    }
}
