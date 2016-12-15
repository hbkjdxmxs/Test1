package com.albb.www.text1;

import android.app.Application;
import android.content.Context;
import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.aop.AdviceBinder;
import com.alibaba.mobileim.aop.PointCutEnum;
import com.alibaba.wxlib.util.SysUtil;
public class MyApplication extends Application {
    private static  Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * initYW的api
         */
        context = getApplicationContext();
        Application app=this;
        SysUtil.setApplication(this);//这个一定要解决！
        if (SysUtil.isMainProcess()){
            YWAPI.init(app,Utils.APP_KEY);
        }
        AdviceBinder.bindAdvice(PointCutEnum.CONVERSATION_FRAGMENT_UI_POINTCUT, ConversationListUICustomSample.class);

    }
    public static Context getContext(){
        return  context;
    }



}
