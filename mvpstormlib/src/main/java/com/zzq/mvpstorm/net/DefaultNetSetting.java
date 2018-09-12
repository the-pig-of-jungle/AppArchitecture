package com.zzq.mvpstorm.net;

public class DefaultNetSetting implements NetSetting {
    @Override
    public int connectTimeoutSeconds() {
        return 10;
    }

    @Override
    public int readTimeoutSeconds() {
        return 10;
    }

    @Override
    public int logPrintMode() {
        return LOG_PRINT_ONLY_DEBUG;
    }
}
