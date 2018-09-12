package com.zzq.mvpstorm.mvp.contract;

public interface Contract {

    interface IPresenter<V extends IView, B extends IBiz> {
        void attachView(V v);
        void detachView();
        V getV();
        B getB();
    }

    interface IView<P extends IPresenter> {
        P getP();
        void showLoading();
        void hideLoading();
    }

    interface IBiz {

    }
}
