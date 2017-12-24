package com.coder.zzq.apparchiteturelib.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;

import com.coder.zzq.apparchiteturelib.manager.ActivityManager;
import com.coder.zzq.apparchiteturelib.mvp.contract.BaseContract;
import com.coder.zzq.apparchiteturelib.mvp.model.biz.BizException;
import com.coder.zzq.apparchiteturelib.mvp.model.biz.BizSuccResult;
import com.coder.zzq.apparchiteturelib.receiver.NetworkMonitorReceiver;


/**
 * Created by 朱志强 on 2017/4/14.
 */
public abstract class SimpleBaseActivity<P extends BaseContract.IBasePresenter> extends AppCompatActivity implements BaseContract.IBaseMvpView {

    protected P mPresenter;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ActivityManager.push(this);
//        processWindow();
//        if (baseLayout() != -1) {
//            ViewGroup baseLayout = (ViewGroup) getLayoutInflater().inflate(baseLayout(), (ViewGroup) findViewById(android.R.id.content), false);
//            getLayoutInflater().inflate(contentView(), baseLayout, true);
//            setContentView(baseLayout);
//        } else if (contentView() != -1) {
//            setContentView(contentView());
//        }
//        ButterKnife.bind(this);
//        mPresenter = createPresenter();
//        mPresenter.attachView(this);
//        initDataAndEvent();
//
//    }

    protected void processWindow() {

    }

    protected int baseLayout() {
        return -1;
    }

    protected abstract int contentView();

    protected void initDataAndEvent() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        NetworkMonitorReceiver.registerNetworkMonitor(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        NetworkMonitorReceiver.unregisterNetworkMonitor(this);
    }



    @Override
    public void onNetworkChanged(boolean connected) {

    }

    @Override
    public abstract void onNoNetwork();

    @Override
    public abstract void onBizSuccessful(BizSuccResult bizSuccResult);

    @Override
    public abstract void onBizError(BizException e);

    @Override
    public abstract void onRequestFailed(String s);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        ActivityManager.pop();
    }

    public abstract P createPresenter();

}
