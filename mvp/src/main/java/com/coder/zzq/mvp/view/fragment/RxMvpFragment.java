package com.coder.zzq.mvp.view.fragment;

import com.coder.zzq.mvp.contract.MvpContract;

import io.reactivex.subjects.BehaviorSubject;


public abstract class RxMvpFragment<P extends MvpContract.MvpPresenter> extends MvpFragment<P>
        implements MvpContract.RxMvpView<P> {
    private BehaviorSubject<String> mBehaviorSubject = BehaviorSubject.create();

    public BehaviorSubject<String> getBehaviorSubject() {
        return mBehaviorSubject;
    }
}
