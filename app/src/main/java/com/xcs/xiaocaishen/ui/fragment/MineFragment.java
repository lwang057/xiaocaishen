package com.xcs.xiaocaishen.ui.fragment;

import android.widget.TextView;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.MinePresenter;
import com.xcs.xiaocaishen.ui.AppContract;

import butterknife.BindView;

/**
 * @author lwang
 * @date 2018/8/3
 * @description 我的页面
 */

public class MineFragment extends BaseFragment<MinePresenter> implements AppContract.MineView {

    @BindView(R.id.toolbar_title)
    TextView toobarTitle;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        toobarTitle.setText("我的");

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
