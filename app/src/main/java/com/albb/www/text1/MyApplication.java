package com.albb.www.text1;

import android.app.Application;

import com.alibaba.mobileim.YWAPI;

import static com.alibaba.tcms.client.ClientRegInfo.APP_KEY;

/**
 * Created by wb-qjl256634 on 2016/12/13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * initYW的api
         */
       YWAPI.init(this,Utils.APP_KEY);
    }
}
