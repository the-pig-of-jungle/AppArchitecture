package com.coder.zzq.apparchiteturelib.http;





import com.coder.zzq.apparchiteturelib.BuildConfig;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 喜欢、陪你看风景 on 2017/12/10.
 */

public final class ApiServiceCreator {



    private ApiServiceCreator() {

    }



    public static <ApiService> ApiService create(String baseUrl, int connectTimeoutSeconds, Class<ApiService> apiServiceInterface) {

                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
                        .build();

                return new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(okHttpClient)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(apiServiceInterface);

    }



}
