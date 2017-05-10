package programmer.zzq.appstructure.mvp.model.biz;

/**
 * Created by 朱志强 on 2017/4/29.
 */

public class BizSuccResult<T> {
    private int mBizTag;
    private T mResponseData;

    public BizSuccResult(int bizTag, T responseData) {
        mBizTag = bizTag;
        mResponseData = responseData;
    }


    public int getBizTag() {
        return mBizTag;
    }

    public void setBizTag(int bizTag) {
        mBizTag = bizTag;
    }

    public T getResponseData() {
        return mResponseData;
    }

    public void setResponseData(T responseData) {
        mResponseData = responseData;
    }
}
