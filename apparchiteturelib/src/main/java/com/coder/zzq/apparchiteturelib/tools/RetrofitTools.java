package com.coder.zzq.apparchiteturelib.tools;



import com.coder.zzq.apparchiteturelib.BuildConfig;
import com.coder.zzq.apparchiteturelib.R;
import com.coder.zzq.apparchiteturelib.utils.Utils;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 朱志强 on 2017/5/23.
 */

public class RetrofitTools {

    public static <T> T createRetrofitRequestService(Class<T> retrofitInterface) {

        if (retrofitInterface == null){
            return null;
        }

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new SmartLogger());
        HttpLoggingInterceptor.Level level = BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;
        loggingInterceptor.setLevel(level);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Utils.ResUtil.loadIntRes(0), TimeUnit.SECONDS)
                .readTimeout(Utils.ResUtil.loadIntRes(0), TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Utils.ResUtil.loadStringRes(R.string.app_name))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(retrofitInterface);
    }
}
