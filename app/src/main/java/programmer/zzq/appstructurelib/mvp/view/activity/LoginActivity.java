package programmer.zzq.appstructurelib.mvp.view.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import programmer.zzq.appstructure.manager.UserInfoManager;
import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;
import programmer.zzq.appstructure.utils.Utils;
import programmer.zzq.appstructurelib.R;
import programmer.zzq.appstructurelib.mvp.contract.LoginContract;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;
import programmer.zzq.appstructurelib.mvp.model.biz.LoginBiz;
import programmer.zzq.appstructurelib.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginContract.ILoginPresenter> implements LoginContract.ILoginView {

    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.error_tip)
    TextView mErrorTip;
    @BindView(R.id.pwd_edt)
    EditText pwdEdt;
    @BindView(R.id.account_edt)
    EditText accountEdt;

    @Override
    protected int contentView() {
        return R.layout.activity_login;
    }


    @Override
    public void showInputErrorTip(String inputErrorTip) {
        mErrorTip.setText(inputErrorTip);
    }

    @Override
    public String getLoginName() {
        return accountEdt.getText().toString().trim();
    }



    @Override
    public String getLoginPwd() {
        return pwdEdt.getText().toString().trim();
    }

    @Override
    public void toHomePaneActivity() {
        Utils.IntentUtil.startActivity(this,HomeActivity.class);
    }


    @Override
    public LoginContract.ILoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @OnClick(R.id.login_btn)
    public void onViewClicked() {
      mPresenter.login();
    }

    @Override
    public void onBizError(BizException e) {
        super.onBizError(e);
        showInputErrorTip(e.getDesc());
    }

    @Override
    public void onBizSuccessful(BizSuccResult bizSuccResult) {
        super.onBizSuccessful(bizSuccResult);
        if (bizSuccResult.getBizTag() == LoginBiz.BIZ_TAG_LOGIN){
            UserInfoManager.storeUserInfo(bizSuccResult.getResponseData(UserInfo.class).data());
            toHomePaneActivity();
        }
    }
}
