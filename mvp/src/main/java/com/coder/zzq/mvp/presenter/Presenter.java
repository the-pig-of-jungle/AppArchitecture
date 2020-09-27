package com.coder.zzq.mvp.presenter;



import com.coder.zzq.mvp.contract.MvpContract;

import java.lang.ref.WeakReference;

@SuppressWarnings("rawtypes")
public abstract class Presenter<V extends MvpContract.IView, B extends MvpContract.IBusiness> implements MvpContract.IPresenter<V, B> {
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
    public B getB() {
        if (mBiz == null) {
            mBiz = createBiz();
        }
        return mBiz;
    }

    protected abstract B createBiz();
}
