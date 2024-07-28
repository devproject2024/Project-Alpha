package com.sendbird.android;

import java.util.concurrent.Callable;

abstract class q<T> implements Callable<T> {
    Callable<T> r = new Callable<T>() {
        public final T call() {
            final T t = null;
            try {
                e = null;
                t = q.this.call();
            } catch (SendBirdException e2) {
                e = e2;
            } catch (Exception e3) {
                e = new SendBirdException(e3.getMessage(), SendBirdError.ERR_REQUEST_FAILED);
            }
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    q.this.a(t, e);
                }
            });
            return t;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract void a(T t, SendBirdException sendBirdException);

    q() {
    }
}
