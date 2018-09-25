package com.xcs.xiaocaishen.presenter;

import com.xcs.xiaocaishen.model.api.ApiFactory;
import com.xcs.xiaocaishen.model.api.AppApi;
import com.xcs.xiaocaishen.ui.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author lwang
 * @date 2018/8/1
 * @description 处理业务逻辑presenter的基类
 */

public abstract class BasePresenter<View extends IBaseView> {

    public View mView;
    public Reference<View> reference;
    public AppApi appApi;

    /**
     * 当打开页面时，通过弱引用得到View的引用
     * @param view
     */
    public void attachView(View view) {
        reference = new WeakReference<>(view);
        mView = reference.get();
        appApi = ApiFactory.getAppApi();
    }

    /**
     * 当页面销毁时及时清理
     */
    public void detachView() {
        if (reference != null) {
            reference.clear();
        }
        reference = null;
    }

}
