package com.coder.zzq.mvp.model.bean;

public interface ResponseDataWrapper<DATA> {
    int getCode();

    String getMessage();

    DATA getData();
}
