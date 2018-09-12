package com.zzq.mvpstorm.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.zzq.mvpstorm.mvp.contract.Contract;
import com.zzq.mvpstorm.mvp.util.Utils;

import javax.inject.Inject;

public abstract class BaseActivity<P extends Contract.IPresenter> extends AppCompatActivity implements Contract.IView<P> {
    @Inject
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processWindowBeforeLoadLayout(getWindow(), getWindow().getDecorView());
        if (provideLayoutId() != null) {
            setContentView(provideLayoutId());
        }

    }


    protected void processWindowBeforeLoadLayout(Window window, View decorView) {

    }

    protected abstract Integer provideLayoutId();


    @Override
    public P getP() {
        return Utils.requireNotNull(mPresenter, "尚未创建Presenter！");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
