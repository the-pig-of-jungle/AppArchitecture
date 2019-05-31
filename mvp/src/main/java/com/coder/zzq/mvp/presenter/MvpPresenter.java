package com.coder.zzq.mvp.presenter;



import com.coder.zzq.mvp.contract.MvpContract;

import java.lang.ref.WeakReference;

public abstract class MvpPresenter<V extends MvpContract.MvpView, B extends MvpContract.MvpBiz> implements MvpContract.MvpPresenter<V, B> {
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
