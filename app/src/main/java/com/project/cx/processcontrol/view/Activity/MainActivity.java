package com.project.cx.processcontrol.view.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.cx.processcontrol.R;
import com.project.cx.processcontrol.base.BaseActivity;
import com.project.cx.processcontrol.model.bean.TaskCK;
import com.project.cx.processcontrol.presenter.TaskCKPresenterCompl;
import com.project.cx.processcontrol.view.Fragment.TaskDCKFragment;
import com.project.cx.processcontrol.view.Fragment.TaskYCKFragment;
import com.project.cx.processcontrol.view.IView.ITaskCKView;
import com.project.cx.processcontrol.view.adapter.MFragmentAdapter;
import com.project.cx.processcontrol.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity<ITaskCKView,TaskCKPresenterCompl> implements ITaskCKView,View.OnClickListener {
    ProgressBar progressBar;
    ViewPager mViewPager;
    MFragmentAdapter mfpa;
    private List<Fragment> fragmentList;
    List<TaskCK> datas;
    MyAdapter mAdapter;
    TaskDCKFragment taskDCKFragment;
    TaskYCKFragment taskYCKFragment;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        initData();
        initView();
        getPresenter().setProcessBarVisibility(View.VISIBLE);
        Map<String,String> params=new HashMap<String, String>();
        params.put("token","e133b95023a1da24b9bafc5203a0572f");
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public TaskCKPresenterCompl createPresenter() {
        return new TaskCKPresenterCompl();
    }

    @Override
    public ITaskCKView createView() {
        return this;
    }

    private void initData() {
        fragmentList=new ArrayList<Fragment>();
        taskDCKFragment=new TaskDCKFragment();
        taskYCKFragment=new TaskYCKFragment();
        fragmentList.add(taskDCKFragment);
        fragmentList.add(taskYCKFragment);
    }

    private void initView() {
        progressBar=findViewById(R.id.processbar);
        mViewPager=findViewById(R.id.viewpager);
        mfpa=new MFragmentAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(mfpa);
    }

    @Override
    public void onFetchFinishView(List<TaskCK> taskCKList) {
        datas=taskCKList;
        mAdapter=new MyAdapter(datas);
        taskDCKFragment.setAdapter(mAdapter);
        getPresenter().setProcessBarVisibility(View.GONE);
    }

    @Override
    public void onSetProgressBarVisiblity(int visibilty) {
        progressBar.setVisibility(visibilty);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    @Override
    public void onTokenErr(String errMsg) {
        Toast.makeText(mContext,errMsg,Toast.LENGTH_SHORT).show();
        getPresenter().setProcessBarVisibility(View.GONE);
    }
}
