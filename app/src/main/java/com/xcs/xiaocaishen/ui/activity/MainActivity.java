package com.xcs.xiaocaishen.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xcs.xiaocaishen.App;
import com.xcs.xiaocaishen.R;
import com.xcs.xiaocaishen.presenter.MainPresenter;
import com.xcs.xiaocaishen.ui.AppContract;
import com.xcs.xiaocaishen.ui.fragment.HomeFragment;
import com.xcs.xiaocaishen.ui.fragment.MessageFragment;
import com.xcs.xiaocaishen.ui.fragment.MineFragment;
import com.xcs.xiaocaishen.ui.fragment.OrderFragment;

import butterknife.BindView;

/**
 * @author lwang
 * @date 2018/8/1
 * @description 主界面
 */

public class MainActivity extends BaseActivity<MainPresenter> implements AppContract.MainView {

    @BindView(R.id.bottom_nav_bar)
    BottomNavigationBar bottomNarBar;

    private FragmentManager fm = getSupportFragmentManager();
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    public final String TAG_1 = "tag1";
    public final String TAG_2 = "tag2";
    public final String TAG_3 = "tag3";
    public final String TAG_4 = "tag4";
    private final int BACK_TIME = 2 * 1000;
    private long preTime = 0;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getActivityTitle() {
        return "";
    }

    @Override
    protected void initView() {
        bottomNarBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .addItem(new BottomNavigationItem(R.mipmap.icon_home_home, "首页").setInactiveIconResource(R.mipmap.icon_home_home2).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.gray_96))
                .addItem(new BottomNavigationItem(R.mipmap.icon_home_order, "任务").setInactiveIconResource(R.mipmap.icon_home_order2).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.gray_96))
                .addItem(new BottomNavigationItem(R.mipmap.icon_home_message, "消息").setInactiveIconResource(R.mipmap.icon_home_message2).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.gray_96))
                .addItem(new BottomNavigationItem(R.mipmap.icon_home_mine, "我的").setInactiveIconResource(R.mipmap.icon_home_mine2).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.gray_96))
                .setFirstSelectedPosition(0)
                .initialise();

        setDefaultFragment();
    }

    @Override
    protected void initData() {
        mPresenter.requestData();
    }

    @Override
    protected void initListener() {

        bottomNarBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction ft = fm.beginTransaction();
                homeFragment = (HomeFragment) fm.findFragmentByTag(TAG_1);
                orderFragment = (OrderFragment) fm.findFragmentByTag(TAG_2);
                messageFragment = (MessageFragment) fm.findFragmentByTag(TAG_3);
                mineFragment = (MineFragment) fm.findFragmentByTag(TAG_4);
                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            ft.add(R.id.content_fragment, homeFragment, TAG_1);
                        } else {
                            ft.show(homeFragment);
                        }
                        break;
                    case 1:
                        if (orderFragment == null) {
                            orderFragment = new OrderFragment();
                            ft.add(R.id.content_fragment, orderFragment, TAG_2);
                        } else {
                            ft.show(orderFragment);
                        }
                        break;
                    case 2:
                        if (messageFragment == null) {
                            messageFragment = new MessageFragment();
                            ft.add(R.id.content_fragment, messageFragment, TAG_3);
                        } else {
                            ft.show(messageFragment);
                        }
                        break;
                    case 3:
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            ft.add(R.id.content_fragment, mineFragment, TAG_4);
                        } else {
                            ft.show(mineFragment);
                        }
                        break;
                    default:
                        break;
                }
                ft.commit();
            }

            @Override
            public void onTabUnselected(int position) {
                FragmentTransaction ft = fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (homeFragment != null) {
                            ft.hide(homeFragment);
                        }
                        break;
                    case 1:
                        if (orderFragment != null) {
                            ft.hide(orderFragment);
                        }
                        break;
                    case 2:
                        if (messageFragment != null) {
                            ft.hide(messageFragment);
                        }
                        break;
                    case 3:
                        if (mineFragment != null) {
                            ft.hide(mineFragment);
                        }
                        break;
                    default:
                        break;
                }
                ft.commit();
            }

            @Override
            public void onTabReselected(int position) {
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

    /**
     * 设置默认的第一个fragment
     */
    private void setDefaultFragment() {

        FragmentTransaction ft = fm.beginTransaction();
        homeFragment = new HomeFragment();
        ft.add(R.id.content_fragment, homeFragment, TAG_1);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        long nowTime = System.currentTimeMillis();
        if (nowTime - preTime >= BACK_TIME) {
            showToast("再点一次退出程序");
            preTime = nowTime;
        } else {
            App.getInstance().clearActivity();
            finish();
        }
    }


}
