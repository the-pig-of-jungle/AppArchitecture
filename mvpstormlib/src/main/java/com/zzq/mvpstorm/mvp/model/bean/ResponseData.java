package com.zzq.mvpstorm.mvp.model.bean;

public class ResponseData<DATA> {

    private int mCode;
    private String mMessage;
    private DATA mData;

    public ResponseData() {

    }

    private String provideFieldNameCode() {
        return "";
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public DATA getData() {
        return mData;
    }

    public void setData(DATA data) {
        mData = data;
    }
}
