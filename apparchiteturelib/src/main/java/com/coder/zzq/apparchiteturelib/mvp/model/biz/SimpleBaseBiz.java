package com.coder.zzq.apparchiteturelib.mvp.model.biz;


import com.coder.zzq.apparchiteturelib.mvp.contract.BaseContract;
import com.coder.zzq.apparchiteturelib.tools.RetrofitTools;

/**
 * Created by 朱志强 on 2017/4/29.
 */

public abstract  class SimpleBaseBiz<T> implements BaseContract.IBaseBiz{

    protected final T mRetrofitRequestService = RetrofitTools.createRetrofitRequestService(retrofitRequestInterface());

    protected abstract Class<T> retrofitRequestInterface();

    @Override
    public abstract boolean isBizSuccessful(int bizCode);

    @Override
    public String getBizErrorTip(int bizErrorCode, String defaultMsg) {
        return defaultMsg;
    }

    @Override
    public String getRequestFailedTip(Exception ex, String defaultMsg) {
        return defaultMsg;
    }
}
