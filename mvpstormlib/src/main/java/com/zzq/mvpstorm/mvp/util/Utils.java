package com.zzq.mvpstorm.mvp.util;

public class Utils {
    public static <T> T requireNotNull(T obj, String errorTip) {
        if (obj == null) {
            throw new NullPointerException(errorTip);
        }

        return obj;
    }
}
