package coder.zzq.appstructurelib.mvp.model.biz;


import coder.zzq.appstructurelib.mvp.contract.BaseContract;
import coder.zzq.appstructurelib.tools.RetrofitTools;

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
