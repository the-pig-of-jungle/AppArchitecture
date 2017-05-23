package programmer.zzq.appstructurelib.mvp.contract;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructurelib.http.ResponseData;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;

/**
 * Created by 朱志强 on 2017/5/15.
 */

public interface LoginContract {

    interface ILoginView extends BaseContract.IBaseMvpView{
        void showInputErrorTip(String inputErrorTip);

        String getLoginName();

        String getLoginPwd();

        void toHomePaneActivity();
    }

    interface ILoginBiz extends BaseContract.IBaseBiz{

        String checkInput(String loginName,String loginPwd);

        Observable<ResponseData<UserInfo>> login(RequestBody jsonBody);
    }

    interface ILoginPresenter extends BaseContract.IBasePresenter{
        void login();
    }


}
