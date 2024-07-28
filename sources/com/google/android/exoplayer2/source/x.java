package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.g.a;

public final class x extends ah {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f33403b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final long f33404c;

    /* renamed from: d  reason: collision with root package name */
    private final long f33405d;

    /* renamed from: e  reason: collision with root package name */
    private final long f33406e;

    /* renamed from: f  reason: collision with root package name */
    private final long f33407f;

    /* renamed from: g  reason: collision with root package name */
    private final long f33408g;

    /* renamed from: h  reason: collision with root package name */
    private final long f33409h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f33410i;
    private final boolean j;
    private final Object k;

    public final int b() {
        return 1;
    }

    public final int c() {
        return 1;
    }

    public x(long j2, boolean z, Object obj) {
        this(j2, j2, 0, 0, z, false, obj);
    }

    public x(long j2, long j3, long j4, long j5, boolean z, boolean z2, Object obj) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z, z2, obj);
    }

    public x(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, Object obj) {
        this.f33404c = j2;
        this.f33405d = j3;
        this.f33406e = j4;
        this.f33407f = j5;
        this.f33408g = j6;
        this.f33409h = j7;
        this.f33410i = z;
        this.j = z2;
        this.k = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r1 > r7) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.ah.b a(int r18, com.google.android.exoplayer2.ah.b r19, boolean r20, long r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = 1
            r2 = r18
            com.google.android.exoplayer2.g.a.a((int) r2, (int) r1)
            if (r20 == 0) goto L_0x000d
            java.lang.Object r1 = r0.k
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            r3 = r1
            long r1 = r0.f33409h
            boolean r4 = r0.j
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x002f
            r7 = 0
            int r4 = (r21 > r7 ? 1 : (r21 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x002f
            long r7 = r0.f33407f
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0028
        L_0x0026:
            r10 = r5
            goto L_0x0030
        L_0x0028:
            long r1 = r1 + r21
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x002f
            goto L_0x0026
        L_0x002f:
            r10 = r1
        L_0x0030:
            long r4 = r0.f33404c
            long r6 = r0.f33405d
            boolean r8 = r0.f33410i
            boolean r9 = r0.j
            long r12 = r0.f33407f
            r14 = 0
            long r1 = r0.f33408g
            r15 = r1
            r2 = r19
            com.google.android.exoplayer2.ah$b r1 = r2.a(r3, r4, r6, r8, r9, r10, r12, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.x.a(int, com.google.android.exoplayer2.ah$b, boolean, long):com.google.android.exoplayer2.ah$b");
    }

    public final ah.a a(int i2, ah.a aVar, boolean z) {
        a.a(i2, 1);
        return aVar.a((Object) null, z ? f33403b : null, this.f33406e, -this.f33408g);
    }

    public final int a(Object obj) {
        return f33403b.equals(obj) ? 0 : -1;
    }

    public final Object a(int i2) {
        a.a(i2, 1);
        return f33403b;
    }
}
