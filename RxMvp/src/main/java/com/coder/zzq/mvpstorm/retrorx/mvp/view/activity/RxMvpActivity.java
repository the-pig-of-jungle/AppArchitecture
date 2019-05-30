package com.coder.zzq.mvpstorm.retrorx.mvp.view.activity;


import com.coder.zzq.mvpstorm.basic.mvp.view.activity.BasicMvpActivity;
import com.coder.zzq.mvpstorm.retrorx.mvp.contract.RxMvpContract;

import io.reactivex.subjects.BehaviorSubject;


public abstract class RxMvpActivity<P extends RxMvpContract.RxMvpPresenter> extends BasicMvpActivity<P> {
    private BehaviorSubject<String> mBehaviorSubject = BehaviorSubject.create();

    public BehaviorSubject<String> getBehaviorSubject() {
        return mBehaviorSubject;
    }
}
