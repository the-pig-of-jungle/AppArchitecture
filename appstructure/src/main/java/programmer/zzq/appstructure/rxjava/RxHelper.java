package programmer.zzq.appstructure.rxjava;


import com.trello.rxlifecycle2.android.ActivityEvent;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import programmer.zzq.appstructure.R;
import programmer.zzq.appstructure.http.IResponseData;
import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.mvp.model.biz.BizException;
import programmer.zzq.appstructure.mvp.model.biz.BizSuccResult;
import programmer.zzq.appstructure.utils.Utils;


/**
 * Created by 朱志强 on 2017/4/14.
 */
public class RxHelper {

    public static <T extends IResponseData<?>, B extends BaseContract.IBaseBiz> Observable<T> commonTransfer(Observable<T> observable, final B biz, final int bizTag, BaseContract.IBaseMvpView mvpView) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mvpView.<T>bindUntilEvent(ActivityEvent.STOP))
                .map(new Function<T, T>() {
                    @Override
                    public T apply(T t) throws Exception {
                        if (biz.isBizSuccessful(t.code())) {
                            return t;
                        }
                        throw new BizException(bizTag, biz.getBizErrorTip(t.code(),t.message()), t);
                    }
                });
    }

    public static <T> Observer<IResponseData<T>> commonObserver(final BaseContract.IBaseMvpView mvpView, final int bizTag) {

        return new Observer<IResponseData<T>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (!Utils.NetworkUtils.isNetworkConnected()){
                    mvpView.onNoNetwork();
                    d.dispose();
                    return;
                }

                mvpView.onLoading();
            }

            @Override
            public void onNext(IResponseData<T> value) {

                mvpView.<T>onBizSuccessful(new BizSuccResult(bizTag,value));
            }

            @Override
            public void onError(Throwable e) {
                Class ExType = e.getClass();
                if (ExType == BizException.class){
                    mvpView.onBizError((BizException) e);
                    return;
                }

                String errorTip = "";

                if (ExType == ConnectException.class){
                    errorTip = Utils.ResUtil.loadStringRes(R.string.connect_failed_tip);
                }else if (ExType == SocketTimeoutException.class){
                    errorTip = Utils.ResUtil.loadStringRes(R.string.timeout_tip);
                }else {
                    errorTip = Utils.ResUtil.loadStringRes(R.string.unknown_error_tip);
                }

                mvpView.onRequestFailed(errorTip);
            }

            @Override
            public void onComplete() {

            }
        };

    }

}
