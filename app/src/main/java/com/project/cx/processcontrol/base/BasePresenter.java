package com.project.cx.processcontrol.base;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public abstract class BasePresenter<V extends IBaseView> {
    private V view;
    public void attachView(V view){
        this.view=view;
    }

    public void detachView(){
        if(view!=null){
            view=null;
        }
    }

    public V getView(){
        if(view!=null){
            return view;
        }
        return null;
    }
}
