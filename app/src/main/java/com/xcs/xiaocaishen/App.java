package com.xcs.xiaocaishen;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;

import java.util.LinkedList;

/**
 * @author lwang
 * @date 2018/8/1
 * @description Application
 */

public class App extends Application {

    /**
     * activity的集合，对activity进行管理
     */
    private LinkedList<Activity> activitys = new LinkedList();
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initHawk();
        initLogger();
        initLeakCanary();
    }

    private void initHawk() {

    }

    private void initLogger() {
        // 1.显示线程信息  2.显示的方法行数（每一行代表一个方法） 3.隐藏内部方法调用到偏移量  4.LOG TAG
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(2)
                .methodOffset(5)
                .tag("wang")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    @NonNull
    public static App getInstance() {
        return mInstance;
    }

    /**
     * 添加activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activitys.add(activity);
    }

    /**
     * 移除某个activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    /**
     * 清除所有的activity
     */
    public void clearActivity() {
        for (Activity activity : activitys) {
            activity.finish();
        }
    }

    /**
     * 获取所有的activity
     *
     * @return
     */
    public LinkedList<Activity> getActivities() {
        return activitys;
    }

}
