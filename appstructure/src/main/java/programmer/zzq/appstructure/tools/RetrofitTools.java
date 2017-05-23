package programmer.zzq.appstructure.tools;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import programmer.zzq.appstructure.R;
import programmer.zzq.appstructure.utils.Utils;
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
        HttpLoggingInterceptor.Level level = Utils.AppUtil.isDebugMode() ?
                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;
        loggingInterceptor.setLevel(level);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Utils.ResUtil.loadIntRes(R.integer.connect_timeout_seconds), TimeUnit.SECONDS)
                .readTimeout(Utils.ResUtil.loadIntRes(R.integer.read_timeout_seconds), TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Utils.ResUtil.loadStringRes(R.string.base_url))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(retrofitInterface);
    }
}
