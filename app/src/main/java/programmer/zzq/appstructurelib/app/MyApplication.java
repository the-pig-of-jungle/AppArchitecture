package programmer.zzq.appstructurelib.app;

import programmer.zzq.appstructure.app.BaseApplication;
import programmer.zzq.appstructure.manager.UserInfoManager;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        UserInfoManager.initUserInfo(UserInfo.class);
    }
}
