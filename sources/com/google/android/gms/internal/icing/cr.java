package com.google.android.gms.internal.icing;

final class cr extends cn {
    private cr() {
        super((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        b(obj, j).b();
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        ce b2 = b(obj, j);
        ce b3 = b(obj2, j);
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
        eo.a(obj, j, (Object) b3);
    }

    private static <E> ce<E> b(Object obj, long j) {
        return (ce) eo.f(obj, j);
    }

    /* synthetic */ cr(byte b2) {
        this();
    }
}
