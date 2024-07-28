package com.google.android.gms.common.util.a;

import com.google.android.gms.common.internal.s;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f8964a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8965b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f8966c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadFactory f8967d;

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b2) {
        this.f8966c = new AtomicInteger();
        this.f8967d = Executors.defaultThreadFactory();
        this.f8964a = (String) s.a(str, (Object) "Name must not be null");
        this.f8965b = 0;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f8967d.newThread(new d(runnable));
        String str = this.f8964a;
        int andIncrement = this.f8966c.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
