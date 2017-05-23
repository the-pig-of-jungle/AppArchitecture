package programmer.zzq.appstructurelib.http;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import programmer.zzq.appstructurelib.mvp.model.bean.UserInfo;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public interface RequestService {

    @POST("/api/StuffService/StuffLogin")
    Observable<ResponseData<UserInfo>> login(@Body RequestBody jsonBody);

}
