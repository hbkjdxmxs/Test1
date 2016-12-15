package com.albb.www.text1;

import android.content.Context;

import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWIMKit;



public class Kit {
    static private Kit mKit = null;
     private static YWIMKit mIMKit = null;
    private Kit() {
    }
    public synchronized static YWIMKit getKti() {
        if (mKit == null) {
            mKit = new Kit();
        }
        if (mIMKit == null)
            mIMKit = YWAPI.getIMKitInstance(MyApplication.getContext().getSharedPreferences("username",Context.MODE_PRIVATE).getString("name",""), Utils.APP_KEY);
        return mIMKit;
    }


}
