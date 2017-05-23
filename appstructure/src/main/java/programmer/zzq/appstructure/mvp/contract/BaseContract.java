package programmer.zzq.appstructure.mvp.contract;


import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;


/**
 * Created by 朱志强 on 2017/4/14.
 */
public interface BaseContract {

    interface IBaseMvpView{

        void onNoNetwork();

        void onNetworkChanged(boolean connected);

        void beforeLoading();

        void onLoading();

        void onBizSuccessful(BizSuccResult bizSuccResult);

        void onBizError(BizException e);

        void onRequestFailed(String s);
    }

    interface IBaseBiz {
        boolean isBizSuccessful(int bizCode);
        String getBizErrorTip(int bizErrorCode, String defaultMsg);
    }


    interface IBasePresenter{

        void attachView(IBaseMvpView mvpView);

        void detachView();
    }

}
