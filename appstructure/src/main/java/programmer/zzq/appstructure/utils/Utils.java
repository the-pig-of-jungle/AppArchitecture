package programmer.zzq.appstructure.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;
import android.util.TypedValue;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import programmer.zzq.appstructure.R;
import programmer.zzq.appstructure.app.BaseApplication;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 朱志强 on 2017/4/28.
 */

public class Utils {


    public static final class ResUtil{

        public static String loadStringRes(@StringRes int strRes){
            return AppUtil.resources().getString(strRes);
        }

        public static int loadIntRes(@IntegerRes int intRes){
           return AppUtil.resources().getInteger(intRes);
        }

    }



    public static final class AppUtil{

        public static Context context(){
            return BaseApplication.sApplication;
        }

        public static BaseApplication application(){
            return BaseApplication.sApplication;
        }

        public static Resources resources(){
            return BaseApplication.sApplication.getResources();
        }

        public static boolean isDebugMode(){
            return BaseApplication.sDebugMode;
        }
    }


    public static final class HttpUtil{
        public static <T> T createRetrofitRequestService(Class<T> retrofitInterface){

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            HttpLoggingInterceptor.Level level = AppUtil.isDebugMode() ?
                    HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;
            loggingInterceptor.setLevel(level);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(ResUtil.loadIntRes(R.integer.connect_timeout_seconds), TimeUnit.SECONDS)
                    .readTimeout(ResUtil.loadIntRes(R.integer.read_timeout_seconds),TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();

            return new Retrofit.Builder()
                    .baseUrl(ResUtil.loadStringRes(R.string.base_url))
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(retrofitInterface);
        }
    }


    public static final class SharePrefUtil{
        public static SharedPreferences.Editor editPref(String prefName){
            return AppUtil.context().getSharedPreferences(prefName,Context.MODE_PRIVATE).edit();
        }

        public static SharedPreferences getPref(String prefName){
            return AppUtil.context().getSharedPreferences(prefName,Context.MODE_PRIVATE);
        }
    }




    public static final class JsonUtil{
        private static Gson sGson = new Gson();

        public static <T> T json2obj(String json,Class<T> clazz){
            return sGson.fromJson(json,clazz);
        }

        public static String obj2json(Object obj){
            return sGson.toJson(obj);
        }
    }

    public static final class NetworkUtils {

        public static final int TYPE_NONE = -1;

        public static int activeNetworkType(){
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null){
                return TYPE_NONE;
            }
            return networkInfo.getType();
        }

        private static NetworkInfo getNetworkInfo() {
            ConnectivityManager connectivityManager = (ConnectivityManager) AppUtil.context().getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getActiveNetworkInfo();
        }

        public static boolean isNetworkConnected(){
            NetworkInfo networkInfo = getNetworkInfo();
            return networkInfo != null
                    && networkInfo.getState() == NetworkInfo.State.CONNECTED;
        }
    }


    public static final class DimenUtil{

        public static int dp2px(float dp){
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,AppUtil.resources().getDisplayMetrics()));
        }

        public static int sp2px(float sp){
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,sp,AppUtil.resources().getDisplayMetrics()));
        }

    }





}
