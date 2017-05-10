package programmer.zzq.appstructure.mvp.model.biz;


import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.utils.Utils;

/**
 * Created by 朱志强 on 2017/4/29.
 */

public abstract class SimpleBaseBiz<T> implements BaseContract.IBaseBiz<T> {
    protected final T mRetrofitRequestService = Utils.HttpUtil.createRetrofitRequestService(retrofitInterface());

    public SimpleBaseBiz(){

    }

    protected abstract Class<T> retrofitInterface();

    public T httpRequest(){
        return mRetrofitRequestService;
    }

}
