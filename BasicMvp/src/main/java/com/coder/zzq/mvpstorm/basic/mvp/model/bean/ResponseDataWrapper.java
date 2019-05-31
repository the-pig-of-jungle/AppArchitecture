package com.coder.zzq.mvpstorm.basic.mvp.model.bean;

public interface ResponseDataWrapper<DATA> {
    int code();
    String msg();
    DATA data();
}
