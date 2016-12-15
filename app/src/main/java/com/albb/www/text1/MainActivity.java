package com.albb.www.text1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.event.IWxCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends /*AppCompat*/Activity {


    @BindView(R.id.username)
    EditText userName;
    @BindView(R.id.password)
    EditText password;
    private YWIMKit mIMKit;
    private String name = "";
    private boolean isLogin = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       /* ActionBar bar = getActionBar();
        bar.setDisplayShowCustomEnabled(true);
        bar.setCustomView(View.inflate(this,R.layout.action_bar,null));*/

    }


    private void inioLogin() {
        //开始登录
        name = (userName.getText().toString());
        SharedPreferences username = getSharedPreferences("username", MODE_PRIVATE);
        if (username.getString("name", "").isEmpty()) {
            SharedPreferences.Editor edit = username.edit();
            edit.putString("name", name);
            edit.commit();
        }else if (!username.getString("name", "").equals(name)) {
            SharedPreferences.Editor edit = username.edit();
            edit.putString("name", name);
            edit.commit();
        }
        System.out.println(username.getString("name", "")+"@@@@@@@");
        mIMKit = Kit.getKti();

    IYWLoginService loginService = mIMKit.getLoginService();
    YWLoginParam loginParam = YWLoginParam.createLoginParam(name, password.getText().toString());
    loginService.login(loginParam,new

    IWxCallback() {
        @Override
        public void onSuccess (Object...arg0){
            System.out.println("onSuccess@@@" + arg0[0].toString());
            isLogin = true;
        }

        @Override
        public void onProgress ( int arg0){
            // TODO Auto-generated method stub
            System.out.println("onProgress@@@" + arg0);
        }

        @Override
        public void onError ( int errCode, String description){
            //如果登录失败，errCode为错误码,description是错误的具体描述信息
            System.out.println("description@@@" + description + "errCode" + errCode);
            if("用户不存在".equals(description)){
                ToastUtils.show(getApplicationContext(),"用户不存在");
            }
            if("密码错误".equals(description)){
                ToastUtils.show(getApplicationContext(),"密码错误");
            }
        }
    }

    );
}


    public void login(View view) {
        inioLogin();
        logining();
    }

    private void logining() {
        if (isLogin) {
            Intent intent = mIMKit.getConversationActivityIntent();
            startActivity(intent);
            finish();
        }
    }
}
