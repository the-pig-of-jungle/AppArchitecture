package programmer.zzq.appstructurelib.mvp.view.activity;

import android.app.ProgressDialog;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;
import programmer.zzq.appstructure.mvp.view.activity.SimpleBaseActivity;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public abstract class BaseActivity<V extends BaseContract.IBaseMvpView,P extends BaseContract.IBasePresenter<V>> extends SimpleBaseActivity<V,P> {


    @Override
    protected void initDataAndEvent() {
        sDialog =
                new ProgressDialog(this);
    }

    @Override
    public void onNetworkChanged(boolean connected) {
        Logger.d("base处理广播");
        Toast.makeText(this,connected ? "网络已恢复！" : "网络已断开！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void beforeLoading() {

    }
    private ProgressDialog sDialog;
    @Override
    public void onLoading() {
        sDialog.show();
    }

    @Override
    protected int contentView() {
        return -1;
    }

    @Override
    public void onNoNetwork() {
        Toast.makeText(this,"检测不到网络，请开启网络后重试！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBizSuccessful(BizSuccResult bizSuccResult) {
        sDialog.dismiss();
    }

    @Override
    public void onBizError(BizException e) {
        sDialog.dismiss();
    }

    @Override
    public void onRequestFailed(String s) {
        sDialog.dismiss();
    }

    @Override
    public abstract P createPresenter();
}
