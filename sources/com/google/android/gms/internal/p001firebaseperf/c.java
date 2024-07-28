package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.c  reason: invalid package */
final class c extends hm<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzy;

    c(Object[] objArr, int i2, int i3) {
        this.zzy = objArr;
        this.offset = i2;
        this.size = i3;
    }

    public final Object get(int i2) {
        cc.a(i2, this.size);
        return this.zzy[(i2 * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
