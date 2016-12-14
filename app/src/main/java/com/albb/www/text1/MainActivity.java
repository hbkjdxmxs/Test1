package com.albb.www.text1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.constant.B2BConstant;
import com.alibaba.mobileim.channel.contact.AsyncGetMultiWWUserProfileByGroupTask;
import com.alibaba.mobileim.channel.event.IWxCallback;

public class MainActivity extends AppCompatActivity {

    //  private static final String APP_KEY = APP_KEY;
    private YWIMKit mIMKit;
    private Button mBtn;
    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn);
        mIMKit = Kit.getKti();

    }
    public void login(View view) {
        if (isLogin) {
            Intent intent = mIMKit.getConversationActivityIntent();
            startActivity(intent);
            finish();
        }else{
            ToastUtils.show(this,"还未登录");
        }
    }
    public void Zc(View view) {
        inioLogin();
    }

    private void inioLogin() {
        //开始登录
        IYWLoginService loginService = mIMKit.getLoginService();
        YWLoginParam loginParam = YWLoginParam.createLoginParam(Utils.userid, Utils.password);
        loginService.login(loginParam, new IWxCallback() {
            @Override
            public void onSuccess(Object... arg0) {
                System.out.println("onSuccess@@@" + arg0);
                isLogin = true;
            }

            @Override
            public void onProgress(int arg0) {
                // TODO Auto-generated method stub
                System.out.println("onProgress@@@" + arg0);
            }

            @Override
            public void onError(int errCode, String description) {
                //如果登录失败，errCode为错误码,description是错误的具体描述信息
                System.out.println("description@@@" + description + "errCode" + errCode);
            }
        });
    }
}
