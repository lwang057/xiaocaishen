package com.xcs.xiaocaishen.utils;

import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * @author lwang
 * @date 2018/8/5
 * @description 打印Log工具类
 */

public class MyLog {

    public static void showLog(String s) {
        Log.i("wang", s);
    }

    public static void showLogger(String s) {
        Logger.i(s);
    }

}
