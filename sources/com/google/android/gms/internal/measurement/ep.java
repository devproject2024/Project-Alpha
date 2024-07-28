package com.google.android.gms.internal.measurement;

import java.util.List;

final class ep extends eo {
    private ep() {
        super((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> a(Object obj, long j) {
        ed c2 = c(obj, j);
        if (c2.a()) {
            return c2;
        }
        int size = c2.size();
        ed a2 = c2.a(size == 0 ? 10 : size << 1);
        gt.a(obj, j, (Object) a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj, long j) {
        c(obj, j).b();
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        ed c2 = c(obj, j);
        ed c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.a()) {
                c2 = c2.a(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        gt.a(obj, j, (Object) c3);
    }

    private static <E> ed<E> c(Object obj, long j) {
        return (ed) gt.f(obj, j);
    }

    /* synthetic */ ep(byte b2) {
        this();
    }
}
