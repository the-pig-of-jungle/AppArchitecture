package com.zzq.mvpstorm.mvp.contract;

import io.reactivex.subjects.BehaviorSubject;

public interface Contract {
    interface IMvpView<P extends IPresenter> {
        P getP();

        void onLoading();

        void onLoadFinish();

        BehaviorSubject<String> getLifecycleEmitter();
    }

    interface IPresenter<V extends IMvpView, B extends IBiz> {
        void attachView(V view);

        void detachView();

        V getV();

        boolean isViewAttached();

        void onViewDestroyed();

        B getB();
    }

    interface IBiz {

    }
}
