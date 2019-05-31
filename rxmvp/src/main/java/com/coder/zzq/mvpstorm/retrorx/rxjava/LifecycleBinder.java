package com.coder.zzq.mvpstorm.retrorx.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.BehaviorSubject;

public final class LifecycleBinder {
    private LifecycleBinder() {

    }

    public static <V> ObservableTransformer<V, V> bindLifecycle(final BehaviorSubject<String> lifecycleEmitter) {
        return new ObservableTransformer<V, V>() {
            @Override
            public ObservableSource<V> apply(Observable<V> upstream) {
                return upstream.takeUntil(lifecycleEmitter);
            }
        };
    }


}
