package com.zzq.mvpstorm.mvp.presenter;



import com.zzq.mvpstorm.mvp.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BaseMvpPresenter<V extends Contract.IMvpView, B extends Contract.IBiz> implements Contract.IPresenter<V, B> {
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
