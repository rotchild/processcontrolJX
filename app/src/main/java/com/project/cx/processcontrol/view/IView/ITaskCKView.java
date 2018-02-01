package com.project.cx.processcontrol.view.IView;

import com.project.cx.processcontrol.base.IBaseView;
import com.project.cx.processcontrol.model.bean.TaskCK;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public interface ITaskCKView extends IBaseView{
    public void onTokenErr(String errMsg);
    public void onFetchFinishView(List<TaskCK> taskCKList);
    public void onSetProgressBarVisiblity(int visibilty);
}
