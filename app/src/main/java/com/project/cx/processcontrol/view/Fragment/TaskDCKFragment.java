package com.project.cx.processcontrol.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.cx.processcontrol.model.bean.TaskCK;
import com.project.cx.processcontrol.presenter.TaskCKPresenterCompl;
import com.project.cx.processcontrol.view.IView.ITaskCKView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public class TaskDCKFragment extends BaseFragment<ITaskCKView,TaskCKPresenterCompl> implements ITaskCKView{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("taskDCK","onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
    }

    @Override
    public void onTokenErr(String errMsg) {

    }

    @Override
    public void onFetchFinishView(List<TaskCK> taskCKList) {

    }

    @Override
    public void onSetProgressBarVisiblity(int visibilty) {

    }
}
