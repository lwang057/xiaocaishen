package com.xcs.xiaocaishen.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxFragment;
import com.xcs.xiaocaishen.presenter.BasePresenter;
import com.xcs.xiaocaishen.ui.IBaseView;
import com.xcs.xiaocaishen.utils.PresenterFactory;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lwang
 * @date 2018/8/1
 * @description fragment的基类，在这里进行统一处理
 */

public abstract class BaseFragment<T extends BasePresenter> extends RxFragment implements IBaseView {

    public T mPresenter;

    protected Context mContext;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        mContext = getActivity();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = PresenterFactory.createPresenter(this);
        mPresenter.attachView(this);
        initView();
        initData();
        initListener();
    }


    /**
     * 设置Layout布局资源
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置listener
     */
    protected abstract void initListener();

    /**
     * 跳转activity
     *
     * @param activity
     */
    public void startActivity(Class<?> activity) {
        Intent i = new Intent(mContext, activity);
        mContext.startActivity(i);
    }

    /**
     * Toast提示
     *
     * @param txt
     */
    public void showToast(String txt) {
        try {
            Toast.makeText(mContext, txt, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
    }

}
