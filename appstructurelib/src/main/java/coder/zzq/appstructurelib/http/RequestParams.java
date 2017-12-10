package coder.zzq.appstructurelib.http;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱志强 on 2017/12/10.
 */

public final class RequestParams extends HashMap<String,String> {
    private RequestParams(){

    }

    public static RequestParams get(){
        return new RequestParams();
    }

    public RequestParams addParam(String paramName, String paramValue){
        put(paramName,paramValue);
        return this;
    }

    public RequestParams addParam(String paramName, int paramValue){
        return addParam(paramName, String.valueOf(paramName));
    }

    public RequestParams addParam(String paramName, long paramValue){
        return addParam(paramName, String.valueOf(paramName));
    }

    public RequestParams addParam(String paramName, float paramValue){
        return addParam(paramName, String.valueOf(paramName));
    }

    public RequestParams addParam(String paramName, double paramValue){
        return addParam(paramName, String.valueOf(paramName));
    }

    public RequestParams addParam(String paramName, boolean paramValue){
        return addParam(paramName, String.valueOf(paramName));
    }

    public String toJsonStr(){
        return new JSONObject(this).toString();
    }

    public Map<String,String> toMap(){
        return this;
    }

}
