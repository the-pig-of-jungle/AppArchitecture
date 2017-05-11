package programmer.zzq.appstructure.mvp.contract;


import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;


/**
 * Created by 朱志强 on 2017/4/14.
 */
public interface BaseContract {

    interface IBaseMvpView extends LifecycleProvider<ActivityEvent>{

        void onNoNetwork();

        void onNetworkChanged();

        void beforeLoading();

        void onLoading();

        <T> void onBizSuccessful(BizSuccResult<T> bizSuccResult);

        void onBizError(BizException e);

        void onRequestFailed(String s);
    }

    interface IBasePresenter<V extends IBaseMvpView> {

        void attachView(V mvpView);

        void detachView();

        V getMvpView();

    }

    interface IBaseBiz {

        boolean isBizSuccessful(int bizCode);
        String getBizErrorTip(int bizErrorCode, String defaultMsg);

    }

}
