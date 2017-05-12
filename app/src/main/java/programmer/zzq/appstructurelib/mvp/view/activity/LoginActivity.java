package programmer.zzq.appstructurelib.mvp.view.activity;

import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;
import programmer.zzq.appstructurelib.R;
import programmer.zzq.appstructurelib.mvp.presenter.WelcomePresenter;

public class LoginActivity extends BaseActivity {



    @Override
    protected int contentView() {
        return R.layout.activity_login;
    }



    @Override
    public void onBizSuccessful(BizSuccResult bizSuccResult) {

    }

    @Override
    public void onBizError(BizException e) {

    }

    @Override
    public void onRequestFailed(String s) {

    }

    @Override
    public BaseContract.IBasePresenter createPresenter() {
        return new WelcomePresenter();
    }



    @Override
    public void beforeLoading() {

    }

    @Override
    public void onLoading() {

    }
}
