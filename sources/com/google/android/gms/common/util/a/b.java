package com.google.android.gms.common.util.a;

import com.google.android.gms.common.internal.s;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f8961a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8962b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f8963c;

    public b(String str) {
        this(str, (byte) 0);
    }

    private b(String str, byte b2) {
        this.f8963c = Executors.defaultThreadFactory();
        this.f8961a = (String) s.a(str, (Object) "Name must not be null");
        this.f8962b = 0;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f8963c.newThread(new d(runnable));
        newThread.setName(this.f8961a);
        return newThread;
    }
}
