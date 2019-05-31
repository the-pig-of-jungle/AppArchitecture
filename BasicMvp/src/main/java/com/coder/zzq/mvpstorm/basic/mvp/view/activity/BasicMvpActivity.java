package com.coder.zzq.mvpstorm.basic.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.coder.zzq.mvpstorm.basic.mvp.contract.BasicMvpContract;

import butterknife.ButterKnife;


public abstract class BasicMvpActivity<P extends BasicMvpContract.BasicMvpPresenter> extends AppCompatActivity implements BasicMvpContract.BasicMvpView<P> {
    public static final int NO_CONTENT_LAYOUT = 0;
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractIntentExtra(getIntent());
        processBeforeSetContentView();
        if (provideContentView() != NO_CONTENT_LAYOUT) {
            setContentView(provideContentView());
        }
        ButterKnife.bind(this);
        if (getP() != null) {
            getP().attachView(this);
        }
        initView();
        initData();
    }

    protected void extractIntentExtra(Intent intent) {

    }


    protected void processBeforeSetContentView() {

    }


    @LayoutRes
    protected abstract int provideContentView();

    @Override
    public P getP() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        return mPresenter;
    }

    protected abstract void initView();

    protected abstract void initData();


    protected abstract P createPresenter();

    @Override
    public abstract void onLoading();

    @Override
    public abstract void onLoadFinish();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getP() != null) {
            getP().detachView();
            getP().onViewDestroyed();
        }
    }
}
