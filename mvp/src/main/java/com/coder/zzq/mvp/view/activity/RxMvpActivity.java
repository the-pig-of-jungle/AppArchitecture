package com.coder.zzq.mvp.view.activity;


import com.coder.zzq.mvp.contract.MvpContract;

import io.reactivex.subjects.BehaviorSubject;


public abstract class RxMvpActivity<P extends MvpContract.MvpPresenter> extends MvpActivity<P> {
    private BehaviorSubject<String> mBehaviorSubject = BehaviorSubject.create();

    public BehaviorSubject<String> getBehaviorSubject() {
        return mBehaviorSubject;
    }
}
