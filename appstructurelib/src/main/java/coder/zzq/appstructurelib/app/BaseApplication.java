package coder.zzq.appstructurelib.app;

import android.app.Application;

/**
 * Created by 朱志强 on 2017/4/25.
 */

public abstract class BaseApplication extends Application {

    public static BaseApplication sApplication;
    public static boolean sDebugMode = true;


    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

    }


    protected void setDebugMode(boolean debugMode) {
        sDebugMode = debugMode;
    }

}
