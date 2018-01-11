package com.coder.zzq.apparchitecture.http;

import com.coder.zzq.apparchitecture.model.bean.UserInfo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 喜欢、陪你看风景 on 2018/1/10.
 */

public interface IApiService {
    @POST(ApiService.USER_LOGIN)
    Observable<BaseResponse<UserInfo>> userLogin(@QueryMap Map<String,String> params);
}
