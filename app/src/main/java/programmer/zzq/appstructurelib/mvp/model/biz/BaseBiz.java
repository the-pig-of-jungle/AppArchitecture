package programmer.zzq.appstructurelib.mvp.model.biz;

import programmer.zzq.appstructure.mvp.model.biz.SimpleBaseBiz;
import programmer.zzq.appstructurelib.http.RequestService;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public abstract class BaseBiz extends SimpleBaseBiz<RequestService> {

    @Override
    protected Class<RequestService> retrofitRequestInterface() {
        return RequestService.class;
    }

    @Override
    public abstract boolean isBizSuccessful(int bizCode);

}
