package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import rx.Observable;
import rx.functions.Func0;

class RxUtils {
    RxUtils() {
    }

    static <T> Observable<T> fromCallable(final Callable<T> callable) {
        return Observable.defer(new Func0<Observable<T>>() {
            public final Observable<T> call() {
                try {
                    return Observable.just(callable.call());
                } catch (Exception e2) {
                    return Observable.error(e2);
                }
            }
        });
    }
}
