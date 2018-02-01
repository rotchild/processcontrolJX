package com.project.cx.processcontrol.view.IView;

import com.project.cx.processcontrol.base.IBaseView;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public interface ILoginView extends IBaseView{
    public void onLoginResult(String userInfo);
    public void onSetProgressBarVisiblity(int visibilty);
}
