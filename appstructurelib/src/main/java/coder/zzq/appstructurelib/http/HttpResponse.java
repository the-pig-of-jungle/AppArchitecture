package coder.zzq.appstructurelib.http;

/**
 * Created by 喜欢、陪你看风景 on 2017/12/10.
 */

public class HttpResponse<DATA> implements SimpleResponse<DATA> {
    private int ReturnCode;
    private String ReturnMsg;
    private DATA ReturnData;
    private int ReturnTotalRecords;

    public int getReturnCode() {
        return ReturnCode;
    }

    public void setReturnCode(int returnCode) {
        ReturnCode = returnCode;
    }

    public String getReturnMsg() {
        return ReturnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        ReturnMsg = returnMsg;
    }

    public DATA getReturnData() {
        return ReturnData;
    }

    public void setReturnData(DATA returnData) {
        ReturnData = returnData;
    }

    public int getReturnTotalRecords() {
        return ReturnTotalRecords;
    }

    public void setReturnTotalRecords(int returnTotalRecords) {
        ReturnTotalRecords = returnTotalRecords;
    }

    @Override
    public int code() {
        return getReturnCode();
    }

    @Override
    public String msg() {
        return getReturnMsg();
    }

    @Override
    public DATA date() {
        return getReturnData();
    }
}
