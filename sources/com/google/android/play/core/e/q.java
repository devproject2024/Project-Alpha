package com.google.android.play.core.e;

public abstract class q extends RuntimeException {
    public q(String str) {
        super(str);
    }

    public q(Throwable th) {
        super(th);
    }

    public abstract int getErrorCode();
}
