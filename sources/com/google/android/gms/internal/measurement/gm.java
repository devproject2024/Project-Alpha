package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class gm<T, B> {
    gm() {
    }

    /* access modifiers changed from: package-private */
    public abstract B a();

    /* access modifiers changed from: package-private */
    public abstract T a(B b2);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, long j);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, cm cmVar);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, T t);

    /* access modifiers changed from: package-private */
    public abstract void a(T t, hk hkVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract T b(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void b(B b2, int i2, long j);

    /* access modifiers changed from: package-private */
    public abstract void b(T t, hk hkVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void b(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void d(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int e(T t);

    /* access modifiers changed from: package-private */
    public abstract int f(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:19:0x003c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(B r7, com.google.android.gms.internal.measurement.fw r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.b()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0061
            if (r0 == r2) goto L_0x0059
            r3 = 2
            if (r0 == r3) goto L_0x0051
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.j()
            r6.a(r7, (int) r1, (int) r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.measurement.ef r7 = com.google.android.gms.internal.measurement.eg.zzf()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.a()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.a()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.a(r0, (com.google.android.gms.internal.measurement.fw) r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.b()
            if (r3 != r8) goto L_0x004c
            java.lang.Object r8 = r6.a(r0)
            r6.a(r7, (int) r1, r8)
            return r2
        L_0x004c:
            com.google.android.gms.internal.measurement.eg r7 = com.google.android.gms.internal.measurement.eg.zze()
            throw r7
        L_0x0051:
            com.google.android.gms.internal.measurement.cm r8 = r8.n()
            r6.a(r7, (int) r1, (com.google.android.gms.internal.measurement.cm) r8)
            return r2
        L_0x0059:
            long r3 = r8.i()
            r6.b(r7, r1, r3)
            return r2
        L_0x0061:
            long r3 = r8.g()
            r6.a(r7, (int) r1, (long) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.gm.a(java.lang.Object, com.google.android.gms.internal.measurement.fw):boolean");
    }
}
