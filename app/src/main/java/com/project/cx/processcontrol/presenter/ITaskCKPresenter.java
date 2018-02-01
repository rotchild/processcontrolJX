package com.project.cx.processcontrol.presenter;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public interface ITaskCKPresenter {
    void fetchCKData(Map<String,String> params);
    void setProcessBarVisibility(int visibility);
}
