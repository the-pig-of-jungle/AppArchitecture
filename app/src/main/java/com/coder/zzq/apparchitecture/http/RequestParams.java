package com.coder.zzq.apparchitecture.http;

import java.util.HashMap;

/**
 * Created by 喜欢、陪你看风景 on 2018/1/11.
 */

public class RequestParams extends HashMap<String,String> {

    private RequestParams(){

    }

    public static RequestParams get(){
        return new RequestParams();
    }

    public RequestParams addParam(String paramName,String paramValue){
        put(paramName,paramValue);
        return this;
    }

    public RequestParams addParam(String paramName,int paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }

    public RequestParams addParam(String paramName,float paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }

    public RequestParams addParam(String paramName,boolean paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }


}
