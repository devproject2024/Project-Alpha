package com.sendbird.android;

import com.sendbird.android.log.Logger;
import java.util.concurrent.Callable;

abstract class s<T> implements Callable<T> {
    Callable<T> r = new Callable<T>() {
        public final T call() {
            try {
                return s.this.call();
            } catch (Exception e2) {
                Logger.w((Throwable) e2);
                return null;
            }
        }
    };

    s() {
    }
}
