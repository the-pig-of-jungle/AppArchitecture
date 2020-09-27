package com.coder.zzq.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import com.coder.zzq.mvp.contract.MvpContract;

import butterknife.ButterKnife;

@SuppressWarnings("rawtypes")
public abstract class MvpActivity<P extends MvpContract.IPresenter> extends AppCompatActivity implements MvpContract.IView<P> {
    public static final int NO_CONTENT_LAYOUT = 0;
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractIntentExtra(getIntent());
        processBeforeSetLayout();
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


    protected void processBeforeSetLayout() {

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
    public void showLoadingIndicator(boolean show) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getP() != null) {
            getP().detachView();
        }
    }
}
