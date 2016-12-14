package com.albb.www.text1;

import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWIMKit;


/**
 * Created by wb-qjl256634 on 2016/12/13.
 */

public class Kit {
    static private Kit mKit = null;
    static private YWIMKit mIMKit = null;
    private Kit() {
    }

    ;

    public synchronized static YWIMKit getKti() {
        if (mKit == null) {
            mKit = new Kit();
        }
        if (mIMKit == null)
            mIMKit = YWAPI.getIMKitInstance(Utils.userid, Utils.APP_KEY);
        return mIMKit;
    }


}
