package programmer.zzq.appstructure.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import programmer.zzq.appstructure.manager.ActivityManager;
import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;
import programmer.zzq.appstructure.receiver.NetworkMonitorReceiver;


/**
 * Created by 朱志强 on 2017/4/14.
 */
public abstract class SimpleBaseActivity<V extends BaseContract.IBaseMvpView,P extends BaseContract.IBasePresenter<V>> extends RxAppCompatActivity implements BaseContract.IBaseMvpView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.push(this);
        if (baseLayout() != -1){
            ViewGroup baseLayout = (ViewGroup) getLayoutInflater().inflate(baseLayout(), (ViewGroup) findViewById(android.R.id.content),false);
            getLayoutInflater().inflate(contentView(),baseLayout,true);
            setContentView(baseLayout);
        }else if (contentView() != -1){
            setContentView(contentView());
        }
        ButterKnife.bind(this);
        initDataAndEvent();
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);

    }

    protected int baseLayout(){
        return -1;
    }

    protected abstract int contentView();

    protected void initDataAndEvent(){

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
