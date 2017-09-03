package coder.zzq.appstructurelib.http;

/**
 * Created by 朱志强 on 2017/4/25.
 */

public interface IResponseData<DATA> {

    int code();

    String message();

    DATA data();
}
