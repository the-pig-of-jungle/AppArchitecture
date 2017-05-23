package programmer.zzq.appstructure.mvp.model.biz;


import programmer.zzq.appstructure.http.IResponseData;

/**
 * Created by 朱志强 on 2017/4/29.
 */

public class BizException extends RuntimeException {

    private int mBizTag;
    private String mDesc;
    private IResponseData mResponseData;

    public BizException(int bizTag, String desc, IResponseData responseData) {
        mBizTag = bizTag;
        mDesc = desc;
        mResponseData = responseData;
    }

    public BizException() {

    }

    public int getBizTag() {
        return mBizTag;
    }

    public void setBizTag(int bizType) {
        mBizTag = bizType;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public <DATA> IResponseData<DATA> getResponseData() {
        return mResponseData;
    }

    public void setResponseData(IResponseData responseData) {
        mResponseData = responseData;
    }
}
