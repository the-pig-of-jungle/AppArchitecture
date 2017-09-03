package coder.zzq.appstructurelib.mvp.contract;

import coder.zzq.appstructurelib.mvp.model.biz.BizException;
import coder.zzq.appstructurelib.mvp.model.biz.BizSuccResult;

/**
 * Created by 朱志强 on 2017/4/14.
 */
public interface BaseContract {

    interface IBaseMvpView {

        //当前无网络时回调
        void onNoNetwork();

        //当网络状况发生变化时回调,新的网络状态（连接或断开）作为参数传入
        void onNetworkChanged(boolean connected);

        //加载数据前回调
        void beforeLoading();

        //加载数据时回调
        void onLoading();

        //业务逻辑成功时回调
        void onBizSuccessful(BizSuccResult bizSuccResult);


        void onBizError(BizException e);

        void onRequestFailed(String s);
    }

    interface IBaseBiz {

        boolean isBizSuccessful(int bizCode);

        String getBizErrorTip(int bizErrorCode, String defaultMsg);

    }


    interface IBasePresenter {

        void attachView(IBaseMvpView mvpView);

        void detachView();

    }

}
