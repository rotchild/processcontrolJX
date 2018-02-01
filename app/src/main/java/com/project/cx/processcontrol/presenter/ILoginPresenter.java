package com.project.cx.processcontrol.presenter;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public interface ILoginPresenter {
    void doLogin(String name,String password);
    void setProcessBarVisibility(int visibility);
}
