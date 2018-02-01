package com.project.cx.processcontrol.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.cx.processcontrol.presenter.TaskCKPresenterCompl;
import com.project.cx.processcontrol.view.IView.ITaskCKView;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public class TaskYCKFragment extends BaseFragment<ITaskCKView,TaskCKPresenterCompl>{
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
}
