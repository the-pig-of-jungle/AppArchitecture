package programmer.zzq.appstructurelib.mvp.presenter;

import programmer.zzq.appstructure.mvp.presenter.SimpleBasePresenter;
import programmer.zzq.appstructure.rxjava.RxHelper;
import programmer.zzq.appstructure.tools.AESTool;
import programmer.zzq.appstructurelib.http.HttpParamCreator;
import programmer.zzq.appstructurelib.http.ResponseData;
import programmer.zzq.appstructurelib.mvp.contract.LoginContract;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;
import programmer.zzq.appstructurelib.mvp.model.biz.LoginBiz;

/**
 * Created by 朱志强 on 2017/5/15.
 */

public class LoginPresenter extends SimpleBasePresenter<LoginContract.ILoginView,LoginContract.ILoginBiz> implements LoginContract.ILoginPresenter {
    public static final String TEST_KEY_STR = "#WMMP@ssword!qazXSW@(~A)1&3m0_s%";
    @Override
    public void login() {
        String account = mMvpView.getLoginName();
        String password = mMvpView.getLoginPwd();
        String errorTip = mBiz.checkInput(account,password);

        if (errorTip == null){

            mBiz.login(HttpParamCreator.loginParams(account, AESTool.encrypt(password.getBytes(),TEST_KEY_STR.getBytes())))
                    .compose(RxHelper.<ResponseData<UserInfo>>commonTransformer(mBiz,LoginBiz.BIZ_TAG_LOGIN,mMvpView))
                    .subscribe(RxHelper.<ResponseData<UserInfo>>commonObserver(LoginBiz.BIZ_TAG_LOGIN,mMvpView));

        }else {
            mMvpView.showInputErrorTip(errorTip);
        }

    }

    @Override
    protected LoginContract.ILoginBiz createBiz() {
        return new LoginBiz();
    }


}
