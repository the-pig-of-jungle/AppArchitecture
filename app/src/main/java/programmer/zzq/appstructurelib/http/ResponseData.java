package programmer.zzq.appstructurelib.http;


import programmer.zzq.appstructure.http.IResponseData;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public class ResponseData<DATA> implements IResponseData<DATA> {

    private int ReturnCode;
    private String ReturnMsg;
    private DATA ReturnData;
    private int ReturnTotalRecords;


    public int getReturnCode() {
        return ReturnCode;
    }

    public void setReturnCode(int ReturnCode) {
        this.ReturnCode = ReturnCode;
    }

    public String getReturnMsg() {
        return ReturnMsg;
    }

    public void setReturnMsg(String ReturnMsg) {
        this.ReturnMsg = ReturnMsg;
    }

    public DATA getReturnData() {
        return ReturnData;
    }

    public void setReturnData(DATA ReturnData) {
        this.ReturnData = ReturnData;
    }

    public int getReturnTotalRecords() {
        return ReturnTotalRecords;
    }

    public void setReturnTotalRecords(int ReturnTotalRecords) {
        this.ReturnTotalRecords = ReturnTotalRecords;
    }



    @Override
    public int code() {
        return getReturnCode();
    }

    @Override
    public String message() {
        return getReturnMsg();
    }

    @Override
    public DATA data() {
        return getReturnData();
    }

}
