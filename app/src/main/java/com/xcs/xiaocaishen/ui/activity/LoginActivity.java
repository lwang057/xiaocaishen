package com.xcs.xiaocaishen.ui.activity;

import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.LoginPresenter;
import com.xcs.xiaocaishen.ui.AppContract;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

/**
 * @author lwang
 * @date 2018/8/2
 * @description 登录界面
 */

public class LoginActivity extends BaseActivity<LoginPresenter>implements AppContract.LoginView{

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register_account)
    Button btnRegisterAccount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected String getActivityTitle() {
        return "登录";
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

        RxView.clicks(btnLogin)
                .throttleWithTimeout(1,TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        startActivity(MainActivity.class);
                        finish();
                    }
                });

        RxView.clicks(btnRegisterAccount)
                .throttleWithTimeout(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        startActivity(RegisterActivity.class);
                    }
                });
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
