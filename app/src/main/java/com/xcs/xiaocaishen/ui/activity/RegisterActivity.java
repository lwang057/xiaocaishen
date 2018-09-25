package com.xcs.xiaocaishen.ui.activity;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.RegisterPresenter;
import com.xcs.xiaocaishen.ui.AppContract;

/**
 * @author lwang
 * @date 2018/8/3
 * @description 注册界面
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements AppContract.RegisterView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected String getActivityTitle() {
        return "注册";
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult() {

    }

}
