package programmer.zzq.appstructure.mvp.model.biz;


import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.tools.RetrofitTools;

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

}
