package com.xcs.xiaocaishen.ui.fragment;

import android.widget.TextView;

import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.MessagePresenter;
import com.xcs.xiaocaishen.ui.AppContract;

import butterknife.BindView;

/**
 * @author lwang
 * @date 2018/8/3
 * @description 消息页面
 */

public class MessageFragment extends BaseFragment<MessagePresenter> implements AppContract.OrderView{

    @BindView(R.id.toolbar_title)
    TextView toobarTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        toobarTitle.setText("消息");

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
