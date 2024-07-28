package com.google.android.gms.internal.firebase_ml;

final class hc extends gy {
    private hc() {
        super((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        b(obj, j).d();
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        gq b2 = b(obj, j);
        gq b3 = b(obj2, j);
        int size = b2.size();
        int size2 = b3.size();
        if (size > 0 && size2 > 0) {
            if (!b2.c()) {
                b2 = b2.d(size2 + size);
            }
            b2.addAll(b3);
        }
        if (size > 0) {
            b3 = b2;
        }
        d.a(obj, j, (Object) b3);
    }

    private static <E> gq<E> b(Object obj, long j) {
        return (gq) d.f(obj, j);
    }

    /* synthetic */ hc(byte b2) {
        this();
    }
}
