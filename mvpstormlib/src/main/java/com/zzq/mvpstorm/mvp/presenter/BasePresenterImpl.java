package com.zzq.mvpstorm.mvp.presenter;

import com.zzq.mvpstorm.mvp.contract.Contract;
import com.zzq.mvpstorm.mvp.util.Utils;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class BasePresenterImpl<V extends Contract.IView, B extends Contract.IBiz> implements Contract.IPresenter<V, B> {
    private WeakReference<V> mView;
    @Inject
    private B mBiz;

    @Override
    public void attachView(V v) {

        mView = new WeakReference<>(Utils.requireNotNull(v, "绑定的View层不可为null！"));
    }

    @Override
    public void detachView() {
        if (mView.get() != null) {
            mView.clear();
        }
        mView = null;
    }

    @Override
    public V getV() {
        Utils.requireNotNull(mView, "尚未绑定View层！");
        return mView.get();
    }

    @Override
    public B getB() {
        return Utils.requireNotNull(mBiz, "尚未创建业务对象!");
    }
}
