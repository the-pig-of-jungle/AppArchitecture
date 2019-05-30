package com.coder.zzq.mvpstorm.basic.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coder.zzq.mvpstorm.basic.mvp.contract.BasicMvpContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BasicMvpFragment<P extends BasicMvpContract.BasicMvpPresenter> extends Fragment
        implements BasicMvpContract.BasicMvpView<P> {
    protected Unbinder mUnbinder;
    protected P mPresenter;
    protected OnUserVisibilityHintChangedListener mOnUserVisibilityHintChangedListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractArguments(getArguments());
    }

    protected void extractArguments(Bundle arguments) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(provideLayoutRes(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        if (getP() != null) {
            getP().attachView(this);
        }
        initView();
        initData();
        return view;
    }


    @LayoutRes
    protected abstract int provideLayoutRes();


    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (getP() != null) {
            getP().detachView();
            getP().onViewDestroyed();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public P getP() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        return mPresenter;
    }

    protected abstract P createPresenter();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser != getUserVisibleHint() && mOnUserVisibilityHintChangedListener != null) {
            mOnUserVisibilityHintChangedListener.onOnUserVisibilityHintChanged(isVisibleToUser);
        }
    }

    public void setOnUserVisibilityHintChangedListener(OnUserVisibilityHintChangedListener onUserVisibilityHintChangedListener) {
        mOnUserVisibilityHintChangedListener = onUserVisibilityHintChangedListener;
    }

    public interface OnUserVisibilityHintChangedListener {
        void onOnUserVisibilityHintChanged(boolean visible);
    }
}
