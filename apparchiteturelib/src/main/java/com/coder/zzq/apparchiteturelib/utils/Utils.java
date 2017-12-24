package com.coder.zzq.apparchiteturelib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.WindowManager;

import com.coder.zzq.apparchiteturelib.app.BaseApplication;
import com.google.gson.Gson;


/**
 * Created by 朱志强 on 2017/4/28.
 */

public class Utils {


    public static final class ResUtil {

        public static String loadStringRes(@StringRes int strRes) {
            return AppUtil.resources().getString(strRes);
        }

        public static int loadIntRes(@IntegerRes int intRes) {
            return AppUtil.resources().getInteger(intRes);
        }

    }


    public static final class AppUtil {

        public static Context context() {

            if (BaseApplication.sApplication == null) {
                throw new IllegalStateException("应用的Application没有继承programmer.zzq.appstructure.app.BaseApplication,"
                        + "或者已经继承，但忘记在manifest文件中显示配置。");
            }

            return BaseApplication.sApplication;
        }

        public static BaseApplication application() {
            return BaseApplication.sApplication;
        }

        public static Resources resources() {
            return BaseApplication.sApplication.getResources();
        }


    }


    public static final class SharePrefUtil {
        public static SharedPreferences.Editor editPref(String prefName) {
            return AppUtil.context().getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
        }

        public static SharedPreferences getPref(String prefName) {
            return AppUtil.context().getSharedPreferences(prefName, Context.MODE_PRIVATE);
        }
    }


    public static final class JsonUtil {
        private static Gson sGson = new Gson();

        public static <T> T json2obj(String json, Class<T> clazz) {
            return sGson.fromJson(json, clazz);
        }

        public static String obj2json(Object obj) {
            return sGson.toJson(obj);
        }
    }

    public static final class NetworkUtils {

        public static final int TYPE_NONE = -1;

        public static int activeNetworkType() {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return TYPE_NONE;
            }
            return networkInfo.getType();
        }

        private static NetworkInfo getNetworkInfo() {
            ConnectivityManager connectivityManager = (ConnectivityManager) AppUtil.context().getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getActiveNetworkInfo();
        }

        public static boolean isNetworkConnected() {
            NetworkInfo networkInfo = getNetworkInfo();
            return networkInfo != null
                    && networkInfo.getState() == NetworkInfo.State.CONNECTED;
        }
    }


    public static final class CastUtil {

        public static int dp2px(float dp) {
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, AppUtil.resources().getDisplayMetrics()));
        }

        public static int sp2px(float sp) {
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, AppUtil.resources().getDisplayMetrics()));
        }


        public static String toHexString(byte[] bytes,boolean uppercase) {
            StringBuilder sb = new StringBuilder(bytes.length * 2);

            for (int index = 0; index < bytes.length; index++) {
                sb.append(toHexString(bytes[index],uppercase));
            }

            return sb.toString();
        }

        public static String toHexString(byte num,boolean uppercase){
            int temp = (num + 256) % 256;

            String result = temp < 0x10 ? "0" + Integer.toHexString(temp) : Integer.toHexString(temp);

            return uppercase ? result.toUpperCase() : result.toLowerCase();
        }

    }

    public static final class IntentUtil {

        public static void startActivity(Context context, Class activityClass) {
            context.startActivity(buildIntent(context, activityClass));
        }


        public static Intent buildIntent() {
            return new Intent();
        }

        public static Intent buildIntent(Context context, Class componentClass) {
            return new Intent(context, componentClass);
        }

    }


    public static final class ScreenUtil {
        public static void fullScreen(AppCompatActivity activity) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

}
