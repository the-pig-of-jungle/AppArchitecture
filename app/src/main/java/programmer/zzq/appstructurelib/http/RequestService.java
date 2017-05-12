package programmer.zzq.appstructurelib.http;

import java.util.Map;

import io.reactivex.Observable;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public interface RequestService {

    @GET("/api/StuffService/StuffLogin")
    Observable<ResponseData<UserInfo>> login(@QueryMap Map<String,String> loginParam);

}
