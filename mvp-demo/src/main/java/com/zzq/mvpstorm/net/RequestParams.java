package com.zzq.mvpstorm.net;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public final class RequestParams {
    public static final String CONTENT_TYPE_JSON = "Content-Type: application/json";
    public static final String ACCEPT_TYPE_JSON = "Accept: application/json";
    public static final String ACCEPT_TYPE_HEML = "Accept:text/html";
    private Map<String, Object> mParams;

    private RequestParams() {
        mParams = new HashMap<>();
    }


    public static RequestParams get() {
        return new RequestParams();
    }

    public RequestParams putParam(String paramName, String paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }

    public RequestParams putParam(String paramName, int paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }

    public RequestParams putParam(String paramName, long paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }

    public RequestParams putParam(String paramName, float paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }


    public RequestParams putParam(String paramName, double paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }


    public RequestParams putParam(String paramName, byte paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }


    public RequestParams putParam(String paramName, boolean paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }


    public RequestParams putParam(String paramName, Map<String, Object> paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }


    public <E> RequestParams putParam(String paramName, E[] paramValue) {
        mParams.put(paramName, Arrays.asList(paramValue));
        return this;
    }

    public <E> RequestParams putParam(String paramName, List<E> paramValue) {
        mParams.put(paramName, paramValue);
        return this;
    }


    public Map<String, Object> toMap() {
        return mParams;
    }


    public RequestBody toJsonRequestBody() {
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type: application/json"), toJsonString());
        return requestBody;
    }

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject(mParams);
        return jsonObject.toString();
    }
}
