package com.xcs.xiaocaishen.ui.activity;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.FindPwdPresenter;
import com.xcs.xiaocaishen.ui.AppContract;

/**
 * @author lwang
 * @date 2018/09/28
 * @description 找回密码页面
 */
public class FindPwdActivity extends BaseActivity<FindPwdPresenter> implements AppContract.FindPwdView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_find_pwd;
    }

    @Override
    protected String getActivityTitle() {
        return "找回密码";
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
