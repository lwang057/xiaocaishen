package com.xcs.xiaocaishen.ui.fragment;

import android.widget.TextView;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.HomePresenter;
import com.xcs.xiaocaishen.ui.AppContract.HomeView;

import butterknife.BindView;

/**
 * @author lwang
 * @date 2018/8/1
 * @description 主页
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {

    @BindView(R.id.toolbar_title)
    TextView toobarTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        toobarTitle.setText("主页");
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
