package com.xcs.xiaocaishen.ui.activity;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.ResetPwdPresenter;
import com.xcs.xiaocaishen.ui.AppContract;

/**
 * @author lwang
 * @date 2018/09/28
 * @description
 */
public class ResetPwdActivity extends BaseActivity<ResetPwdPresenter> implements AppContract.ResetPwdView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_pwd;
    }

    @Override
    protected String getActivityTitle() {
        return "重置密码";
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
