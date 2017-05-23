package programmer.zzq.appstructurelib.mvp.presenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;
import programmer.zzq.appstructure.mvp.presenter.SimpleBasePresenter;
import programmer.zzq.appstructurelib.mvp.contract.WelcomeContract;
import programmer.zzq.appstructurelib.mvp.model.biz.WelcomeBiz;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public class WelcomePresenter extends SimpleBasePresenter<WelcomeContract.IWelcomeView,WelcomeContract.IWelcomeBiz> implements WelcomeContract.IWelcomePresenter {


    @Override
    protected WelcomeContract.IWelcomeBiz createBiz() {
        return new WelcomeBiz();
    }

    @Override
    public void toNextActivity() {
        mBiz.hasLogined()
                .delay(1500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean){
                            mMvpView.toHomePaneActivity();
                        }else {
                            mMvpView.toLoginActivity();
                        }
                    }
                });
    }
}
