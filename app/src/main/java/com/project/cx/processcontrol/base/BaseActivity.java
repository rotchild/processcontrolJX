package com.project.cx.processcontrol.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter<V>> extends AppCompatActivity {

    private P presenter;
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.presenter==null){
            this.presenter=createPresenter();
        }

        if(this.view==null){
            this.view=createView();
        }

        if(this.presenter!=null && this.view!=null){
            this.presenter.attachView(this.view);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(this.presenter!=null && this.view!=null){
            this.presenter.detachView();
        }
    }

    public abstract P createPresenter();

    public abstract V createView();

    public P getPresenter(){
        return this.presenter;
    }
}
