package com.coder.zzq.mvp.contract;

@SuppressWarnings("rawtypes")
public interface MvpContract {

    interface IView<P extends IPresenter> {
        P getP();

        void showLoadingIndicator(boolean show);
    }

    interface IPresenter<V extends IView, B extends IBusiness> {
        void attachView(V view);

        void detachView();

        V getV();

        B getB();
    }

    interface IBusiness {

    }
}
