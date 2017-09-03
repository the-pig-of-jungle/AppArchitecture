package coder.zzq.appstructurelib.rxjava;


import java.net.ConnectException;
import java.net.SocketTimeoutException;

import coder.zzq.appstructurelib.R;
import coder.zzq.appstructurelib.http.IResponseData;
import coder.zzq.appstructurelib.mvp.contract.BaseContract;
import coder.zzq.appstructurelib.mvp.model.biz.BizException;
import coder.zzq.appstructurelib.mvp.model.biz.BizSuccResult;
import coder.zzq.appstructurelib.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by 朱志强 on 2017/4/14.
 */
public class RxHelper {

    public static <T extends IResponseData> ObservableTransformer<T,T> commonTransformer(final BaseContract.IBaseBiz biz, final int bizTag, final BaseContract.IBaseMvpView mvpView){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
//                        .compose(RxHelper.<T>bindToLifecycle(mvpView))
                        .map(new Function<T, T>() {
                            @Override
                            public T apply(T responseData) throws Exception {

                                if (biz.isBizSuccessful(responseData.code())){
                                    return responseData;
                                }

                                throw new BizException(bizTag,biz.getBizErrorTip(responseData.code(),responseData.message()),responseData);
                            }
                        });
            }
        };
    }


    public static <T extends IResponseData> Observer<T> commonObserver(final int bizTag,final BaseContract.IBaseMvpView mvpView) {

        return new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (!Utils.NetworkUtils.isNetworkConnected()) {
                    mvpView.onNoNetwork();
                    d.dispose();
                    return;
                }

                mvpView.onLoading();
            }

            @Override
            public void onNext(T value) {
                mvpView.<T>onBizSuccessful(new BizSuccResult(bizTag, value,null));
            }

            @Override
            public void onError(Throwable e) {

                Class ExType = e.getClass();

                if (ExType == BizException.class) {
                    mvpView.onBizError((BizException) e);
                    return;
                }

                String errorTip = "";

                if (ExType == ConnectException.class) {
                    errorTip = Utils.ResUtil.loadStringRes(R.string.connect_failed_tip);
                } else if (ExType == SocketTimeoutException.class) {
                    errorTip = Utils.ResUtil.loadStringRes(R.string.timeout_tip);
                } else {
                    errorTip = Utils.ResUtil.loadStringRes(R.string.unknown_error_tip);
                }

                mvpView.onRequestFailed(errorTip);
            }

            @Override
            public void onComplete() {

            }
        };

    }



//    public static <T extends IResponseData> LifecycleTransformer<T> bindToLifecycle(BaseContract.IBaseMvpView mvpView) {
//
//        if (mvpView instanceof RxAppCompatActivity) {
//
//            return ((RxAppCompatActivity) mvpView).bindUntilEvent(ActivityEvent.DESTROY);
//
//        } else if (mvpView instanceof RxFragment) {
//
//            return ((RxFragment) mvpView).bindUntilEvent(FragmentEvent.DESTROY_VIEW);
//
//        } else {
//            return null;
//        }

//    }



}
