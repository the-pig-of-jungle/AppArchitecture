package com.zzq.mvpstorm.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzq.mvpstorm.mvp.contract.Contract;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpFragment<P extends Contract.IPresenter> extends Fragment implements Contract.IView<P> {
    private Unbinder mUnbinder;
    @Inject
    private P mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrieveArguments(getArguments());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        initData(savedInstanceState);
        return view;
    }


    protected void retrieveArguments(Bundle arguments) {

    }

    protected abstract Integer getLayoutId();

    protected void initView(View view, Bundle savedInstanceState) {

    }


    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public P getP() {
        return mPresenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
