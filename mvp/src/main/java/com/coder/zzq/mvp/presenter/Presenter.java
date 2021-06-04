package com.coder.zzq.mvp.presenter;


import com.coder.zzq.mvp.contract.MvpContract;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
        new OkHttpClient.Builder()
                .build()
                .newCall(new Request.Builder().url("").build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                });
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
