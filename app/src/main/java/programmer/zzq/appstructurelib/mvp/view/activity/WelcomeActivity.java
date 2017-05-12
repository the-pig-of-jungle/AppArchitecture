package programmer.zzq.appstructurelib.mvp.view.activity;

import android.os.Bundle;

import programmer.zzq.appstructure.utils.Utils;
import programmer.zzq.appstructurelib.R;
import programmer.zzq.appstructurelib.mvp.contract.WelcomeContract;
import programmer.zzq.appstructurelib.mvp.presenter.WelcomePresenter;

public class WelcomeActivity extends BaseActivity<WelcomeContract.IWelcomeView,WelcomeContract.IWelcomePresenter> implements WelcomeContract.IWelcomeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.toNextActivity();
    }

    @Override
    public WelcomeContract.IWelcomePresenter createPresenter() {
        return new WelcomePresenter();
    }

    @Override
    public void showWelcomeImage() {
        getWindow().setBackgroundDrawableResource(R.drawable.welcome);
    }

    @Override
    public void toHomePaneActivity() {
        Utils.IntentUtil.startActivity(this,HomeActivity.class);
    }

    @Override
    public void toLoginActivity() {
        Utils.IntentUtil.startActivity(this,LoginActivity.class);
    }

    @Override
    public void endShow() {
        finish();
    }

    @Override
    protected int contentView() {
        return -1;
    }
}
