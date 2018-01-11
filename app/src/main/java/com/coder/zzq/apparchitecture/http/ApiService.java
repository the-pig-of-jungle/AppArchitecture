package com.coder.zzq.apparchitecture.http;

import com.coder.zzq.apparchitecture.BuildConfig;
import com.coder.zzq.apparchitecture.model.bean.UserInfo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 喜欢、陪你看风景 on 2018/1/10.
 */

public class ApiService {


    private static IApiService sIApiService;


    private ApiService() {

    }

    private static IApiService getApi() {
        if (sIApiService == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();

            sIApiService = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IApiService.class);

        }

        return sIApiService;
    }


    /*
    {
  "LoginAccount": "test3",
  "Password": "string",
  "UserType": 3
}
     */


    public static final String USER_LOGIN = "/api/StuffService/StuffLogin";
    public static final String LOGIN_ACCOUNT = "LoginAccount";
    public static final String PASSWORD = "Password";
    public static final String USER_TYPE = "UserType";

    public static Observable<BaseResponse<UserInfo>> userLogin(String accountName, String password) {

        return getApi().userLogin(
                RequestParams.get()
                        .addParam(LOGIN_ACCOUNT, accountName)
                        .addParam(PASSWORD, password)
                        .addParam(USER_TYPE, 3));
    }
}
