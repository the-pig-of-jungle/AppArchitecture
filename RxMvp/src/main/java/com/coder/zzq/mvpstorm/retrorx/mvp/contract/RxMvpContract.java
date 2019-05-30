package com.coder.zzq.mvpstorm.retrorx.mvp.contract;

import com.coder.zzq.mvpstorm.basic.mvp.contract.BasicMvpContract;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

public interface RxMvpContract {
    interface RxMvpView<P extends RxMvpPresenter> extends BasicMvpContract.BasicMvpView<P> {
        BehaviorSubject<String> getSubscribeCancelTool();
    }

    interface RxMvpPresenter<V extends RxMvpView, B extends RxMvpBiz> extends BasicMvpContract.BasicMvpPresenter<V,B> {

    }

    interface RxMvpBiz extends BasicMvpContract.BasicMvpBiz {

    }
}
