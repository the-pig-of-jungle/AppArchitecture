package com.coder.zzq.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coder.zzq.mvp.contract.MvpContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.subjects.BehaviorSubject;

@SuppressWarnings("rawtypes")
public abstract class MvpFragment<P extends MvpContract.IPresenter> extends Fragment
        implements MvpContract.IView<P> {
    protected Unbinder mUnbinder;
    protected P mPresenter;
    protected BehaviorSubject<String> mLifecycleEmitter = BehaviorSubject.create();

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
        mLifecycleEmitter.onComplete();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (getP() != null) {
            getP().detachView();
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
}
