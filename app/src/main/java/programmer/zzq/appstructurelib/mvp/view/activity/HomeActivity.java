package programmer.zzq.appstructurelib.mvp.view.activity;

import android.os.Bundle;

import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructurelib.R;
import programmer.zzq.appstructurelib.mvp.presenter.LoginPresenter;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public BaseContract.IBasePresenter createPresenter() {
        return new LoginPresenter();
    }
}
