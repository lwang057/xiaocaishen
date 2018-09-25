package com.xcs.xiaocaishen.model.api;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lwang
 * @date 2018/8/1
 * @description api工具类，通过RxLifecycle实现生命周期的同步，从而实现在当前组件生命周期结束时，自动取消对Observable订阅，防止内存泄漏的发生
 * compose(this.bindToLifecycle()) 绑定Activity的生命周期，在onStart()中绑定 onStop()中解绑
 * 并对线程切换进行统一处理
 */

public class ApiUtil {

    /**
     * 绑定activity
     *
     * @param lifecycleProvider
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> getTransformerActivity(LifecycleProvider<ActivityEvent> lifecycleProvider) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(lifecycleProvider.<T>bindToLifecycle());

            }
        };
    }

    /**
     * 绑定fragment
     *
     * @param lifecycleProvider
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> getTransformerFragment(LifecycleProvider<FragmentEvent> lifecycleProvider) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(lifecycleProvider.<T>bindToLifecycle());

            }
        };
    }

}