package programmer.zzq.appstructurelib.mvp.model.biz;

import android.text.TextUtils;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import programmer.zzq.appstructure.mvp.model.biz.SimpleBaseBiz;
import programmer.zzq.appstructurelib.http.RequestService;
import programmer.zzq.appstructurelib.http.ResponseData;
import programmer.zzq.appstructurelib.mvp.contract.LoginContract;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;

/**
 * Created by 朱志强 on 2017/5/15.
 */

public class LoginBiz extends SimpleBaseBiz<RequestService> implements LoginContract.ILoginBiz {

    public static final int BIZ_TAG_LOGIN = 0x001;

    public static final int BIZ_CODE_SUCCESS = 1;

    @Override
    protected Class<RequestService> retrofitRequestInterface() {
        return RequestService.class;
    }

    @Override
    public boolean isBizSuccessful(int bizCode) {
        return bizCode == BIZ_CODE_SUCCESS;
    }

    @Override
    public String checkInput(String loginName,String loginPwd) {
        return (TextUtils.isEmpty(loginName.trim()) || TextUtils.isEmpty(loginPwd.trim())) ? "信息输入不完整！" : null;
    }

    @Override
    public Observable<ResponseData<UserInfo>> login(RequestBody jsonBody) {
        return mRetrofitRequestService.login(jsonBody);
    }


    @Override
    public String getBizErrorTip(int bizErrorCode, String defaultMsg) {
        return super.getBizErrorTip(bizErrorCode, defaultMsg);
    }
}
