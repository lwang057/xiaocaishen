package com.xcs.xiaocaishen.ui.activity;

import com.xcs.xiaocaishen.presenter.OrderDetailPresenter;
import com.xcs.xiaocaishen.ui.AppContract;

/**
 * @author lwang
 * @date 2018/09/28
 * @description 订单详情页面
 */
public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements AppContract.OrderDetailView {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected String getActivityTitle() {
        return null;
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
