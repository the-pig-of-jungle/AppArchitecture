package programmer.zzq.appstructurelib.mvp.contract;

import io.reactivex.Observable;
import programmer.zzq.appstructure.mvp.contract.BaseContract;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public interface WelcomeContract {
    interface IWelcomeView extends BaseContract.IBaseMvpView{

        void showWelcomeImage();

        void toHomePaneActivity();

        void toLoginActivity();
    }

    interface IWelcomeBiz extends BaseContract.IBaseBiz{

        Observable<Boolean> hasLogined();
    }

    interface IWelcomePresenter extends BaseContract.IBasePresenter {
        void toNextActivity();
    }
}
