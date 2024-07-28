package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import java.util.concurrent.ThreadFactory;

public final class g extends x {

    /* renamed from: c  reason: collision with root package name */
    private static final j f47688c = new j("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f47689b;

    public g() {
        this(f47688c);
    }

    private g(ThreadFactory threadFactory) {
        this.f47689b = threadFactory;
    }

    public final x.c a() {
        return new h(this.f47689b);
    }
}
