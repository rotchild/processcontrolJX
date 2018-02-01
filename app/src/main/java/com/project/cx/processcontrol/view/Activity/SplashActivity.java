package com.project.cx.processcontrol.view.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.project.cx.processcontrol.R;
import com.project.cx.processcontrol.base.BaseActivity;
import com.project.cx.processcontrol.model.bean.TaskCK;
import com.project.cx.processcontrol.presenter.TaskCKPresenterCompl;
import com.project.cx.processcontrol.view.IView.ITaskCKView;
import com.project.cx.processcontrol.view.adapter.MyAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class SplashActivity extends BaseActivity<ITaskCKView,TaskCKPresenterCompl> implements ITaskCKView{
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    List<TaskCK> datas;
    MyAdapter mAdapter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        Map<String,String> params=new HashMap<String, String>();
        params.put("token","91f72f123a4999822580bf882034f01f");
        params.put("frontrole","12");
        params.put("type","dck");
        params.put("lian_state","");
        params.put("riskstate","");
        params.put("risklevel","");
        params.put("keyword","");
        params.put("start","0");
        params.put("limit","10");
        getPresenter().fetchCKData(params);
    }

    @Override
    public TaskCKPresenterCompl createPresenter() {
        return new TaskCKPresenterCompl();
    }

    @Override
    public ITaskCKView createView() {
        return this;
    }

    private void initView() {
        progressBar=findViewById(R.id.processbar);
        mRecyclerView=findViewById(R.id.recycler);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onTokenErr(String errMsg) {

    }

    @Override
    public void onFetchFinishView(List<TaskCK> taskCKList) {
        datas=taskCKList;
        mAdapter=new MyAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        getPresenter().setProcessBarVisibility(View.GONE);

    }

    @Override
    public void onSetProgressBarVisiblity(int visibilty) {
        progressBar.setVisibility(visibilty);
    }
}
