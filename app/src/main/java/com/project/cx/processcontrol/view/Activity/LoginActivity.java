package com.project.cx.processcontrol.view.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.cx.processcontrol.R;
import com.project.cx.processcontrol.base.BaseActivity;
import com.project.cx.processcontrol.model.event.MessageEvent;
import com.project.cx.processcontrol.presenter.LoginPresenterCompl;
import com.project.cx.processcontrol.util.EventUtil;
import com.project.cx.processcontrol.view.IView.ILoginView;
import com.squareup.otto.Subscribe;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class LoginActivity extends BaseActivity<ILoginView,LoginPresenterCompl> implements ILoginView,View.OnClickListener {
    Button loginbtn,settingbtn;
    EditText username,password;
    ProgressBar progressBar;
    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        skip();
//        intData();
//        initView();
//        getPresenter().setProcessBarVisibility(View.GONE);

    }

    private void skip() {
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventUtil.unregister(this);
    }

    @Override
    public LoginPresenterCompl createPresenter() {
        return new LoginPresenterCompl();
    }

    @Override
    public ILoginView createView() {
        return this;
    }

    private void intData() {
        EventUtil.register(this);
        mContext=this;
    }

    private void initView() {
        progressBar=findViewById(R.id.processbar);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        loginbtn=findViewById(R.id.login);
        settingbtn=findViewById(R.id.setting);

        loginbtn.setOnClickListener(this);
        settingbtn.setOnClickListener(this);
    }

    @Override
    public void onLoginResult(String userInfo) {
        getPresenter().setProcessBarVisibility(View.GONE);
        loginbtn.setEnabled(true);
        Toast.makeText(this,"userInfo:"+userInfo,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void onSetProgressBarVisiblity(int visibilty) {
        progressBar.setVisibility(visibilty);
    }

    @Subscribe
    public void onMessageEventChange(MessageEvent event){//ottoTest
        String message=event.getMessage();
        Log.e("loginAct","message:"+message);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                EventUtil.sendEvent(new MessageEvent("hello"));
                getPresenter().setProcessBarVisibility(View.VISIBLE);
                loginbtn.setEnabled(false);
                getPresenter().doLogin(username.getText().toString(),"e10adc3949ba59abbe56e057f20f883e");
                break;
        }
    }

}
