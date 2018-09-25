package com.xcs.xiaocaishen.ui.fragment;

import android.widget.TextView;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.OrderPresenter;
import com.xcs.xiaocaishen.ui.AppContract;

import butterknife.BindView;

/**
 * @author lwang
 * @date 2018/8/3
 * @description 订单页
 */

public class OrderFragment extends BaseFragment<OrderPresenter> implements AppContract.OrderView {

    @BindView(R.id.toolbar_title)
    TextView toobarTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        toobarTitle.setText("订单");

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
