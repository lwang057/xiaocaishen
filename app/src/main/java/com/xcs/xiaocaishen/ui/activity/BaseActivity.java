package com.xcs.xiaocaishen.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.xcs.xiaocaishen.App;
import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.BasePresenter;
import com.xcs.xiaocaishen.ui.IBaseView;
import com.xcs.xiaocaishen.utils.PresenterFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lwang
 * @date 2018/8/1
 * @description activity的基类，在这里进行统一处理
 */

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements IBaseView {

    public T mPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbarTitle.setText(getActivityTitle());

        mPresenter = PresenterFactory.createPresenter(this);
        mPresenter.attachView(this);

        App.getInstance().addActivity(this);
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
     * 设置页面标题
     *
     * @return
     */
    protected abstract String getActivityTitle();

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
        Intent i = new Intent(this, activity);
        startActivity(i);
    }

    /**
     * Toast提示
     *
     * @param txt
     */
    public void showToast(String txt) {
        try {
            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
    }

}
