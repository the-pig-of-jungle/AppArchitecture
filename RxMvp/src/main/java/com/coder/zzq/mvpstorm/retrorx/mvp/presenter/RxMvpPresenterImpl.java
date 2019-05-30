package com.coder.zzq.mvpstorm.retrorx.mvp.presenter;

import com.coder.zzq.mvpstorm.retrorx.mvp.contract.RxMvpContract;

import java.lang.ref.WeakReference;

public abstract class RxMvpPresenterImpl<V extends RxMvpContract.RxMvpView, B extends RxMvpContract.RxMvpBiz> implements RxMvpContract.RxMvpPresenter<V, B> {
    protected WeakReference<V> mView;
    protected B mBiz;

    @Override
    public void attachView(V view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        mView.clear();
        mView = null;
    }


    @Override
    public V getV() {
        return mView != null ? mView.get() : null;
    }

    @Override
    public boolean isViewAttached() {
        return (mView != null) && (mView.get() != null);
    }

    @Override
    public void onViewDestroyed() {

    }

    @Override
    public B getB() {
        if (mBiz == null) {
            mBiz = createBiz();
        }
        return mBiz;
    }

    protected abstract B createBiz();
}
