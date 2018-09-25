package com.xcs.xiaocaishen.model.api;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author lwang
 * @date 2018/8/2
 * @description 观察者Observer的具体实现类
 */

public class RequestCallback<T> implements Observer<T> {

    public RequestCallback() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
