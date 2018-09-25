package com.xcs.xiaocaishen.ui.activity;

import android.Manifest;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.LauncherPresenter;
import com.xcs.xiaocaishen.ui.AppContract;
import com.xcs.xiaocaishen.utils.MyLog;
import com.xcs.xiaocaishen.utils.Utils;

import io.reactivex.functions.Consumer;

/**
 * @author lwang
 * @date 2018/8/2
 * @description 闪屏界面
 */

public class LauncherActivity extends BaseActivity<LauncherPresenter> implements AppContract.LauncherView {

    private String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private final RxPermissions rxPermissions = new RxPermissions(this);

    @Override
    protected int getLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected String getActivityTitle() {
        return "启动页";
    }

    @Override
    protected void initView() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void initData() {
        requestPermissions();
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

    @Override
    protected void onRestart() {
        super.onRestart();
        requestPermissions();
    }

    /**
     * 动态申请权限
     */
    private void requestPermissions() {
        rxPermissions.request(permissions)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            new Handler().postDelayed(() -> {
                                startActivity(LoginActivity.class);
                                finish();
                            }, 1000);
                        } else {
                            showNegDialog();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //授权异常的情况下的处理
                        showNegDialog();
                    }
                });
    }

    /**
     * 显示Dialog提醒用户开启权限
     */
    private void showNegDialog() {
        new MaterialDialog.Builder(this)
                .content(R.string.permission_title)
                .canceledOnTouchOutside(false)
                .cancelable(false)
                .positiveColor(ContextCompat.getColor(this, R.color.colorAccent))
                .negativeColor(ContextCompat.getColor(this, R.color.colorAccent))
                .positiveText("确定")
                .negativeText("取消")
                .onPositive((dialog, which) -> {
                    dialog.dismiss();
                    finish();
                })
                .onNegative((dialog, which) -> {
                    dialog.dismiss();
                    Utils.ApplicationInfo(this);
                }).show();
    }

}
