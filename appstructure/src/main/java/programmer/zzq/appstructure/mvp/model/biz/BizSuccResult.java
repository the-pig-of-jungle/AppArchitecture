package programmer.zzq.appstructure.mvp.model.biz;

import programmer.zzq.appstructure.http.IResponseData;

/**
 * Created by 朱志强 on 2017/4/29.
 */

public class BizSuccResult{
    private int mBizTag;
    private IResponseData mResponseData;

    public BizSuccResult(int bizTag, IResponseData responseData) {
        mBizTag = bizTag;
        mResponseData = responseData;
    }


    public int getBizTag() {
        return mBizTag;
    }

    public void setBizTag(int bizTag) {
        mBizTag = bizTag;
    }

    public <T> IResponseData<T> getResponseData(Class<T> dataType) {
        return mResponseData;
    }

    public void setResponseData(IResponseData responseData) {
        mResponseData = responseData;
    }
}
