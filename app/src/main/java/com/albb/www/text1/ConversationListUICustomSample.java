package com.albb.www.text1;

import android.support.v4.app.Fragment;
import android.view.View;

import com.alibaba.mobileim.aop.Pointcut;
import com.alibaba.mobileim.aop.custom.IMConversationListUI;

/**
 * Created by wb-qjl256634 on 2016/12/15.
 */

public class ConversationListUICustomSample extends IMConversationListUI {
    public ConversationListUICustomSample(Pointcut pointcut) {
        super(pointcut);
    }

    @Override
    public boolean needHideTitleView(Fragment fragment) {
        return false;
    }

    @Override
    public void setCustomTitleProgressBar(Fragment fragment, View mCustomTitleView, boolean isVisible) {
        super.setCustomTitleProgressBar(fragment, mCustomTitleView, true);

    }
}

