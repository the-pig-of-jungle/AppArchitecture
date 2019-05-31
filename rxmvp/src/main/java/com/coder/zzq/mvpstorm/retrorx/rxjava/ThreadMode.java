package com.coder.zzq.mvpstorm.retrorx.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class ThreadMode {
    private ThreadMode() {

    }

    public static <V> ObservableTransformer<V, V> asyncIOAndUICallback() {
        return new ObservableTransformer<V, V>() {
            @Override
            public ObservableSource<V> apply(Observable<V> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <V> ObservableTransformer<V, V> asyncIOAndSameCallback() {
        return new ObservableTransformer<V, V>() {
            @Override
            public ObservableSource<V> apply(Observable<V> upstream) {
                return upstream.subscribeOn(Schedulers.io());
            }
        };
    }
}
