package com.coder.zzq.mvpstorm.basic.mvp.contract;

public interface BasicMvpContract {
    interface BasicMvpView<P extends BasicMvpPresenter> {
        P getP();

        void onLoading();

        void onLoadFinish();
    }

    interface BasicMvpPresenter<V extends BasicMvpView, B extends BasicMvpBiz> {
        void attachView(V view);

        void detachView();

        V getV();

        boolean isViewAttached();

        void onViewDestroyed();

        B getB();
    }

    interface BasicMvpBiz {

    }
}
