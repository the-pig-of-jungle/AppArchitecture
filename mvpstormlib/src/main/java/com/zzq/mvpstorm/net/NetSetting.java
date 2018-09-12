package com.zzq.mvpstorm.net;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface NetSetting {
    int LOG_PRINT_ONLY_DEBUG = 0;
    int LOG_PRINT_ALL = 1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LOG_PRINT_ONLY_DEBUG,LOG_PRINT_ALL})
    @interface LogPrintMode{}

    int connectTimeoutSeconds();

    int readTimeoutSeconds();

    @LogPrintMode
    int logPrintMode();


}
