package programmer.zzq.appstructurelib.http;

import okhttp3.RequestBody;
import programmer.zzq.appstructure.http.HttpParams;

/**
 * Created by 朱志强 on 2017/5/18.
 */

public class HttpParamCreator {

    public static final String LOGIN_ACCOUNT = "LoginAccount";
    public static final String PASSWORD = "Password";
    public static final String USER_TYPE = "UserType";



    /*
    {
  "LoginAccount": "string",
  "Password": "string",
  "UserType": 0
}
     */
    public static final RequestBody loginParams(String account, String password) {
        return HttpParams.getDefault(3)
                .add(LOGIN_ACCOUNT,account)
                .add(PASSWORD,password)
                .add(USER_TYPE,3)
                .toJsonBody();
    }
}
