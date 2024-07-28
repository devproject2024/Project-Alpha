package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class y extends w {

    /* renamed from: c  reason: collision with root package name */
    private final Callable<String> f9003c;

    private y(Callable<String> callable) {
        super(false, (String) null, (Throwable) null);
        this.f9003c = callable;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        try {
            return this.f9003c.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* synthetic */ y(Callable callable, byte b2) {
        this(callable);
    }
}
