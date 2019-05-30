package com.coder.zzq.mvpstorm.retrorx.mvp.view.fragment;

import com.coder.zzq.mvpstorm.basic.mvp.view.fragment.BasicMvpFragment;
import com.coder.zzq.mvpstorm.retrorx.mvp.contract.RxMvpContract;

import io.reactivex.subjects.BehaviorSubject;


public abstract class RxMvpFragment<P extends RxMvpContract.RxMvpPresenter> extends BasicMvpFragment<P>
        implements RxMvpContract.RxMvpView<P> {
    private BehaviorSubject<String> mBehaviorSubject = BehaviorSubject.create();

    public BehaviorSubject<String> getBehaviorSubject() {
        return mBehaviorSubject;
    }
}
