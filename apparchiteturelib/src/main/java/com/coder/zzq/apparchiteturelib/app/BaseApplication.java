package com.coder.zzq.apparchiteturelib.app;

import android.app.Application;

/**
 * Created by 朱志强 on 2017/4/25.
 */

public abstract class BaseApplication extends Application {

    public static BaseApplication sApplication;



    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }


}
