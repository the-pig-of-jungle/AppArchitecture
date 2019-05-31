package com.coder.zzq.mvp.contract;

import io.reactivex.subjects.BehaviorSubject;

public interface MvpContract {
    interface MvpView<P extends MvpPresenter> {
        P getP();

        void onLoading();

        void onLoadComplete();
    }

    interface RxMvpView<P extends MvpPresenter> extends MvpView<P> {
        BehaviorSubject<String> getSubscribeCancelTool();
    }

    interface MvpPresenter<V extends MvpView, B extends MvpBiz> {
        void attachView(V view);

        void detachView();

        V getV();

        boolean isViewAttached();

        void onViewDestroyed();

        B getB();
    }

    interface MvpBiz {

    }
}
