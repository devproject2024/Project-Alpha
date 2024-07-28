package com.sendbird.android.shadow.okio;

final class e {

    /* renamed from: a  reason: collision with root package name */
    static d f45280a;

    /* renamed from: b  reason: collision with root package name */
    static long f45281b;

    private e() {
    }

    static d a() {
        synchronized (e.class) {
            if (f45280a == null) {
                return new d();
            }
            d dVar = f45280a;
            f45280a = dVar.f45278f;
            dVar.f45278f = null;
            f45281b -= 8192;
            return dVar;
        }
    }

    static void a(d dVar) {
        if (dVar.f45278f != null || dVar.f45279g != null) {
            throw new IllegalArgumentException();
        } else if (!dVar.f45276d) {
            synchronized (e.class) {
                if (f45281b + 8192 <= 65536) {
                    f45281b += 8192;
                    dVar.f45278f = f45280a;
                    dVar.f45275c = 0;
                    dVar.f45274b = 0;
                    f45280a = dVar;
                }
            }
        }
    }
}
