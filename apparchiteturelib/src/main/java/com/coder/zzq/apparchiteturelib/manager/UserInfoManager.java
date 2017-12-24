package com.coder.zzq.apparchiteturelib.manager;


import com.coder.zzq.apparchiteturelib.utils.Utils;

/**
 * Created by 朱志强 on 2017/4/11.
 */
public abstract class UserInfoManager{

    private static final String USER_INFO_PREF = "user_info";
    private static final String USER_INFO_JSON = "user_info_json";

    private static Object sUserInfo;

    public static <T> void initUserInfo(Class<T> userInfoClass) {
        String jsonStr = Utils.SharePrefUtil.getPref(USER_INFO_PREF).getString(USER_INFO_JSON,null);
        sUserInfo = jsonStr == null ? null : Utils.JsonUtil.json2obj(jsonStr,userInfoClass);
    }

    public static <T> T fetchUserInfo(Class<T> userInfoClass) {
        return userInfoClass.cast(sUserInfo);
    }

    public static void storeUserInfo(Object userInfo) {
        sUserInfo = userInfo;
        String jsonStr = userInfo == null ? null : Utils.JsonUtil.obj2json(userInfo);
        Utils.SharePrefUtil.editPref(USER_INFO_PREF).putString(USER_INFO_JSON, jsonStr).commit();
    }

    public static void clearUserInfo() {
        storeUserInfo(null);
    }

    public static boolean isUserInfoEmpty(){
        return Utils.SharePrefUtil.getPref(USER_INFO_PREF).getString(USER_INFO_JSON,null) == null;
    }

}
