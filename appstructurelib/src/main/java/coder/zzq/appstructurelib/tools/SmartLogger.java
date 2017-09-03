package coder.zzq.appstructurelib.tools;

import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 朱志强 on 2017/5/23.
 */

public class SmartLogger implements HttpLoggingInterceptor.Logger{

    @Override
    public void log(String message) {
        Logger.t("SmartLogger");
        try {
            new JSONObject(message);
            Logger.json(message);
        } catch (JSONException e) {
            Logger.d(message);
        }
    }
}
