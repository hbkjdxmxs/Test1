package com.albb.www.text1;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wb-qjl256634 on 2016/12/13.
 */

public class ToastUtils {

    private static Toast toastUtils = null;

    public static void show(Context context, String str) {
        if (toastUtils == null) {
            toastUtils = Toast.makeText(context, str, Toast.LENGTH_LONG);

        } else
            toastUtils.setText(str);
        toastUtils.show();

    }
}
