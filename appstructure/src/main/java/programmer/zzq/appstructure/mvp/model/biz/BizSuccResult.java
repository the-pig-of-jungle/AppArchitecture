package programmer.zzq.appstructure.mvp.model.biz;

/**
 * Created by 朱志强 on 2017/4/29.
 */

public class BizSuccResult{
    private int mBizTag;
    private Object mResponseData;

    public BizSuccResult(int bizTag, Object responseData) {
        mBizTag = bizTag;
        mResponseData = responseData;
    }


    public int getBizTag() {
        return mBizTag;
    }

    public void setBizTag(int bizTag) {
        mBizTag = bizTag;
    }

    public <T> T getResponseData() {
        return (T) mResponseData;
    }

    public void setResponseData(Object responseData) {
        mResponseData = responseData;
    }
}
