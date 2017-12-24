package com.coder.zzq.apparchiteturelib.http;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by 朱志强 on 2017/4/17.
 */
public class HttpParams extends HashMap<String,String>{

    private HttpParams(int paramNum) {
        super(paramNum);
    }


    public static HttpParams getDefault(){
        return getDefault(8);
    }
    public static HttpParams getDefault(int paramNum){
        return new HttpParams(paramNum);
    }


    public HttpParams add(String paramName,int paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }

    public HttpParams add(String paramName,float paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }

    public HttpParams add(String paramName,double paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }

    public HttpParams add(String paramName,boolean paramValue){
        put(paramName,String.valueOf(paramValue));
        return this;
    }

    public HttpParams add(String paramName,String paramValue){
        put(paramName,paramValue);
        return this;
    }

    public String toJson(){
        return new JSONObject(this).toString();
    }

    public RequestBody toJsonBody(){
        return RequestBody.create(MediaType.parse("application/json;charset=utf-8"),toJson());
    }

    public Map<String,String> toMap(){
        return this;
    }

}
