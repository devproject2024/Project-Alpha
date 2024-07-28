package com.google.android.gms.common.b;

import java.util.concurrent.ScheduledExecutorService;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static C0129a f8645a;

    /* renamed from: com.google.android.gms.common.b.a$a  reason: collision with other inner class name */
    public interface C0129a {
        ScheduledExecutorService a();
    }

    public static synchronized C0129a a() {
        C0129a aVar;
        synchronized (a.class) {
            if (f8645a == null) {
                f8645a = new b();
            }
            aVar = f8645a;
        }
        return aVar;
    }
}
