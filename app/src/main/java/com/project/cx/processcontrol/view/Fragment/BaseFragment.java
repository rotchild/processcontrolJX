package com.project.cx.processcontrol.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.cx.processcontrol.R;
import com.project.cx.processcontrol.base.BasePresenter;
import com.project.cx.processcontrol.base.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public abstract class BaseFragment<V extends IBaseView,P extends BasePresenter<V>> extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> datas=new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list,null);
        mRecyclerView=view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeViews(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected void initializeViews(Bundle savedInstanceState) {

    }

    protected void setAdapter(RecyclerView.Adapter adapter){
        mRecyclerView.setAdapter(adapter);
    }
}
