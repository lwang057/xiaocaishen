package com.xcs.xiaocaishen.ui;

/**
 * @author lwang
 * @date 2018/8/2
 * @description 对view回调的统一管理
 */

public interface AppContract {

    interface MainView extends IBaseView {
        void showResult();
    }

    interface HomeView extends IBaseView {
        void showResult();
    }

    interface OrderView extends IBaseView {
        void showResult();
    }

    interface MessageView extends IBaseView {
        void showResult();
    }

    interface MineView extends IBaseView {
        void showResult();
    }

    interface LauncherView extends IBaseView {
        void showResult();
    }

    interface LoginView extends IBaseView {
        void showResult();
    }

    interface RegisterView extends IBaseView {
        void showResult();
    }


}
