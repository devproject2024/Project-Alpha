package com.google.android.gms.flags;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f9029a;

    /* renamed from: b  reason: collision with root package name */
    private final b f9030b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final d f9031c = new d();

    private c() {
    }

    private static c b() {
        c cVar;
        synchronized (c.class) {
            cVar = f9029a;
        }
        return cVar;
    }

    public static b a() {
        return b().f9030b;
    }

    static {
        c cVar = new c();
        synchronized (c.class) {
            f9029a = cVar;
        }
    }
}
