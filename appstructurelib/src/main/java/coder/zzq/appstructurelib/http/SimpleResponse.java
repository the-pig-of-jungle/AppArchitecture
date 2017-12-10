package coder.zzq.appstructurelib.http;

/**
 * Created by 喜欢、陪你看风景 on 2017/12/10.
 */

public interface SimpleResponse<DATA> {
    int code();
    String msg();
    DATA date();
}
