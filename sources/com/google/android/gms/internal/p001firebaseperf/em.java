package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.em  reason: invalid package */
final class em extends ei {
    private em() {
        super((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        b(obj, j).b();
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        dz b2 = b(obj, j);
        dz b3 = b(obj2, j);
        int size = b2.size();
        int size2 = b3.size();
        if (size > 0 && size2 > 0) {
            if (!b2.a()) {
                b2 = b2.d(size2 + size);
            }
            b2.addAll(b3);
        }
        if (size > 0) {
            b3 = b2;
        }
        gm.a(obj, j, (Object) b3);
    }

    private static <E> dz<E> b(Object obj, long j) {
        return (dz) gm.f(obj, j);
    }

    /* synthetic */ em(byte b2) {
        this();
    }
}
