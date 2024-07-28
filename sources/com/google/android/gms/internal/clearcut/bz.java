package com.google.android.gms.internal.clearcut;

final class bz extends bw {
    private bz() {
        super((byte) 0);
    }

    /* synthetic */ bz(byte b2) {
        this();
    }

    private static <E> bm<E> b(Object obj, long j) {
        return (bm) eb.f(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        b(obj, j).b();
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        bm b2 = b(obj, j);
        bm b3 = b(obj2, j);
        int size = b2.size();
        int size2 = b3.size();
        if (size > 0 && size2 > 0) {
            if (!b2.a()) {
                b2 = b2.a(size2 + size);
            }
            b2.addAll(b3);
        }
        if (size > 0) {
            b3 = b2;
        }
        eb.a(obj, j, (Object) b3);
    }
}
