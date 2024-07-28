package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.o;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    int[] f33292a;

    /* renamed from: b  reason: collision with root package name */
    public int f33293b;

    /* renamed from: c  reason: collision with root package name */
    int f33294c;

    /* renamed from: d  reason: collision with root package name */
    int f33295d;

    /* renamed from: e  reason: collision with root package name */
    private int f33296e = 1000;

    /* renamed from: f  reason: collision with root package name */
    private long[] f33297f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f33298g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f33299h;

    /* renamed from: i  reason: collision with root package name */
    private long[] f33300i;
    private q.a[] j;
    private Format[] k;
    private int l;
    private int m;
    private long n;
    private long o;
    private boolean p;
    private boolean q;
    private boolean r;
    private Format s;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f33301a;

        /* renamed from: b  reason: collision with root package name */
        public long f33302b;

        /* renamed from: c  reason: collision with root package name */
        public q.a f33303c;
    }

    public s() {
        int i2 = this.f33296e;
        this.f33292a = new int[i2];
        this.f33297f = new long[i2];
        this.f33300i = new long[i2];
        this.f33299h = new int[i2];
        this.f33298g = new int[i2];
        this.j = new q.a[i2];
        this.k = new Format[i2];
        this.n = Long.MIN_VALUE;
        this.o = Long.MIN_VALUE;
        this.r = true;
        this.q = true;
    }

    public final void a(boolean z) {
        this.l = 0;
        this.f33293b = 0;
        this.m = 0;
        this.f33294c = 0;
        this.q = true;
        this.n = Long.MIN_VALUE;
        this.o = Long.MIN_VALUE;
        this.p = false;
        if (z) {
            this.s = null;
            this.r = true;
        }
    }

    public final int a() {
        return this.f33293b + this.l;
    }

    public final long a(int i2) {
        int a2 = a() - i2;
        boolean z = false;
        com.google.android.exoplayer2.g.a.a(a2 >= 0 && a2 <= this.l - this.f33294c);
        this.l -= a2;
        this.o = Math.max(this.n, e(this.l));
        if (a2 == 0 && this.p) {
            z = true;
        }
        this.p = z;
        int i3 = this.l;
        if (i3 == 0) {
            return 0;
        }
        int c2 = c(i3 - 1);
        return this.f33297f[c2] + ((long) this.f33298g[c2]);
    }

    public final int b() {
        return this.f33293b + this.f33294c;
    }

    public final synchronized boolean c() {
        return this.f33294c != this.l;
    }

    public final synchronized Format d() {
        if (this.r) {
            return null;
        }
        return this.s;
    }

    public final synchronized long e() {
        return this.o;
    }

    public final synchronized boolean f() {
        return this.p;
    }

    public final synchronized long g() {
        if (this.l == 0) {
            return Long.MIN_VALUE;
        }
        return this.f33300i[this.m];
    }

    public final synchronized void h() {
        this.f33294c = 0;
    }

    public final synchronized int a(o oVar, e eVar, boolean z, boolean z2, Format format, a aVar) {
        if (!c()) {
            if (!z2) {
                if (!this.p) {
                    if (this.s == null || (!z && this.s == format)) {
                        return -3;
                    }
                    oVar.f32757a = this.s;
                    return -5;
                }
            }
            eVar.f31289a = 4;
            return -4;
        }
        int c2 = c(this.f33294c);
        if (!z) {
            if (this.k[c2] == format) {
                eVar.f31289a = this.f33299h[c2];
                eVar.f31312d = this.f33300i[c2];
                if (eVar.e()) {
                    return -4;
                }
                aVar.f33301a = this.f33298g[c2];
                aVar.f33302b = this.f33297f[c2];
                aVar.f33303c = this.j[c2];
                this.f33294c++;
                return -4;
            }
        }
        oVar.f32757a = this.k[c2];
        return -5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f33294c     // Catch:{ all -> 0x0039 }
            int r2 = r8.c(r0)     // Catch:{ all -> 0x0039 }
            boolean r0 = r8.c()     // Catch:{ all -> 0x0039 }
            r7 = -1
            if (r0 == 0) goto L_0x0037
            long[] r0 = r8.f33300i     // Catch:{ all -> 0x0039 }
            r3 = r0[r2]     // Catch:{ all -> 0x0039 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0037
            long r0 = r8.o     // Catch:{ all -> 0x0039 }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x001f
            if (r11 != 0) goto L_0x001f
            goto L_0x0037
        L_0x001f:
            int r11 = r8.l     // Catch:{ all -> 0x0039 }
            int r0 = r8.f33294c     // Catch:{ all -> 0x0039 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x0039 }
            if (r9 != r7) goto L_0x0030
            monitor-exit(r8)
            return r7
        L_0x0030:
            int r10 = r8.f33294c     // Catch:{ all -> 0x0039 }
            int r10 = r10 + r9
            r8.f33294c = r10     // Catch:{ all -> 0x0039 }
            monitor-exit(r8)
            return r9
        L_0x0037:
            monitor-exit(r8)
            return r7
        L_0x0039:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.s.a(long, boolean):int");
    }

    public final synchronized int i() {
        int i2;
        i2 = this.l - this.f33294c;
        this.f33294c = this.l;
        return i2;
    }

    public final synchronized boolean b(int i2) {
        if (this.f33293b > i2 || i2 > this.f33293b + this.l) {
            return false;
        }
        this.f33294c = i2 - this.f33293b;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(long r10, boolean r12, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r9.l     // Catch:{ all -> 0x0038 }
            r1 = -1
            if (r0 == 0) goto L_0x0036
            long[] r0 = r9.f33300i     // Catch:{ all -> 0x0038 }
            int r3 = r9.m     // Catch:{ all -> 0x0038 }
            r3 = r0[r3]     // Catch:{ all -> 0x0038 }
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            goto L_0x0036
        L_0x0012:
            if (r13 == 0) goto L_0x001f
            int r13 = r9.f33294c     // Catch:{ all -> 0x0038 }
            int r0 = r9.l     // Catch:{ all -> 0x0038 }
            if (r13 == r0) goto L_0x001f
            int r13 = r9.f33294c     // Catch:{ all -> 0x0038 }
            int r13 = r13 + 1
            goto L_0x0021
        L_0x001f:
            int r13 = r9.l     // Catch:{ all -> 0x0038 }
        L_0x0021:
            r5 = r13
            int r4 = r9.m     // Catch:{ all -> 0x0038 }
            r3 = r9
            r6 = r10
            r8 = r12
            int r10 = r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0038 }
            r11 = -1
            if (r10 != r11) goto L_0x0030
            monitor-exit(r9)
            return r1
        L_0x0030:
            long r10 = r9.d(r10)     // Catch:{ all -> 0x0038 }
            monitor-exit(r9)
            return r10
        L_0x0036:
            monitor-exit(r9)
            return r1
        L_0x0038:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.s.a(long, boolean, boolean):long");
    }

    public final synchronized long j() {
        if (this.f33294c == 0) {
            return -1;
        }
        return d(this.f33294c);
    }

    public final synchronized long k() {
        if (this.l == 0) {
            return -1;
        }
        return d(this.l);
    }

    public final synchronized boolean a(Format format) {
        if (format == null) {
            this.r = true;
            return false;
        }
        this.r = false;
        if (ae.a((Object) format, (Object) this.s)) {
            return false;
        }
        this.s = format;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(long r6, int r8, long r9, int r11, com.google.android.exoplayer2.extractor.q.a r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.q     // Catch:{ all -> 0x00e1 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.q = r1     // Catch:{ all -> 0x00e1 }
        L_0x000e:
            boolean r0 = r5.r     // Catch:{ all -> 0x00e1 }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.exoplayer2.g.a.b(r0)     // Catch:{ all -> 0x00e1 }
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r8
            if (r0 == 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r5.p = r0     // Catch:{ all -> 0x00e1 }
            long r3 = r5.o     // Catch:{ all -> 0x00e1 }
            long r3 = java.lang.Math.max(r3, r6)     // Catch:{ all -> 0x00e1 }
            r5.o = r3     // Catch:{ all -> 0x00e1 }
            int r0 = r5.l     // Catch:{ all -> 0x00e1 }
            int r0 = r5.c(r0)     // Catch:{ all -> 0x00e1 }
            long[] r3 = r5.f33300i     // Catch:{ all -> 0x00e1 }
            r3[r0] = r6     // Catch:{ all -> 0x00e1 }
            long[] r6 = r5.f33297f     // Catch:{ all -> 0x00e1 }
            r6[r0] = r9     // Catch:{ all -> 0x00e1 }
            int[] r6 = r5.f33298g     // Catch:{ all -> 0x00e1 }
            r6[r0] = r11     // Catch:{ all -> 0x00e1 }
            int[] r6 = r5.f33299h     // Catch:{ all -> 0x00e1 }
            r6[r0] = r8     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.extractor.q$a[] r6 = r5.j     // Catch:{ all -> 0x00e1 }
            r6[r0] = r12     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.Format[] r6 = r5.k     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.Format r7 = r5.s     // Catch:{ all -> 0x00e1 }
            r6[r0] = r7     // Catch:{ all -> 0x00e1 }
            int[] r6 = r5.f33292a     // Catch:{ all -> 0x00e1 }
            int r7 = r5.f33295d     // Catch:{ all -> 0x00e1 }
            r6[r0] = r7     // Catch:{ all -> 0x00e1 }
            int r6 = r5.l     // Catch:{ all -> 0x00e1 }
            int r6 = r6 + r2
            r5.l = r6     // Catch:{ all -> 0x00e1 }
            int r6 = r5.l     // Catch:{ all -> 0x00e1 }
            int r7 = r5.f33296e     // Catch:{ all -> 0x00e1 }
            if (r6 != r7) goto L_0x00df
            int r6 = r5.f33296e     // Catch:{ all -> 0x00e1 }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00e1 }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00e1 }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00e1 }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00e1 }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.extractor.q$a[] r12 = new com.google.android.exoplayer2.extractor.q.a[r6]     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.Format[] r0 = new com.google.android.exoplayer2.Format[r6]     // Catch:{ all -> 0x00e1 }
            int r2 = r5.f33296e     // Catch:{ all -> 0x00e1 }
            int r3 = r5.m     // Catch:{ all -> 0x00e1 }
            int r2 = r2 - r3
            long[] r3 = r5.f33297f     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00e1 }
            long[] r3 = r5.f33300i     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00e1 }
            int[] r3 = r5.f33299h     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00e1 }
            int[] r3 = r5.f33298g     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.extractor.q$a[] r3 = r5.j     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.Format[] r3 = r5.k     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00e1 }
            int[] r3 = r5.f33292a     // Catch:{ all -> 0x00e1 }
            int r4 = r5.m     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00e1 }
            int r3 = r5.m     // Catch:{ all -> 0x00e1 }
            long[] r4 = r5.f33297f     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00e1 }
            long[] r4 = r5.f33300i     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00e1 }
            int[] r4 = r5.f33299h     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00e1 }
            int[] r4 = r5.f33298g     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.extractor.q$a[] r4 = r5.j     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00e1 }
            com.google.android.exoplayer2.Format[] r4 = r5.k     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00e1 }
            int[] r4 = r5.f33292a     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00e1 }
            r5.f33297f = r8     // Catch:{ all -> 0x00e1 }
            r5.f33300i = r9     // Catch:{ all -> 0x00e1 }
            r5.f33299h = r10     // Catch:{ all -> 0x00e1 }
            r5.f33298g = r11     // Catch:{ all -> 0x00e1 }
            r5.j = r12     // Catch:{ all -> 0x00e1 }
            r5.k = r0     // Catch:{ all -> 0x00e1 }
            r5.f33292a = r7     // Catch:{ all -> 0x00e1 }
            r5.m = r1     // Catch:{ all -> 0x00e1 }
            int r7 = r5.f33296e     // Catch:{ all -> 0x00e1 }
            r5.l = r7     // Catch:{ all -> 0x00e1 }
            r5.f33296e = r6     // Catch:{ all -> 0x00e1 }
        L_0x00df:
            monitor-exit(r5)
            return
        L_0x00e1:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.s.a(long, int, long, int, com.google.android.exoplayer2.extractor.q$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r8 <= r7.n) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.l     // Catch:{ all -> 0x004a }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            long r3 = r7.n     // Catch:{ all -> 0x004a }
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            monitor-exit(r7)
            if (r0 <= 0) goto L_0x000f
            return r2
        L_0x000f:
            return r1
        L_0x0010:
            long r3 = r7.n     // Catch:{ all -> 0x004a }
            int r0 = r7.f33294c     // Catch:{ all -> 0x004a }
            long r5 = r7.e(r0)     // Catch:{ all -> 0x004a }
            long r3 = java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x004a }
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0022
            monitor-exit(r7)
            return r1
        L_0x0022:
            int r0 = r7.l     // Catch:{ all -> 0x004a }
            int r1 = r7.l     // Catch:{ all -> 0x004a }
            int r1 = r1 - r2
            int r1 = r7.c(r1)     // Catch:{ all -> 0x004a }
        L_0x002b:
            int r3 = r7.f33294c     // Catch:{ all -> 0x004a }
            if (r0 <= r3) goto L_0x0042
            long[] r3 = r7.f33300i     // Catch:{ all -> 0x004a }
            r4 = r3[r1]     // Catch:{ all -> 0x004a }
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0042
            int r0 = r0 + -1
            int r1 = r1 + -1
            r3 = -1
            if (r1 != r3) goto L_0x002b
            int r1 = r7.f33296e     // Catch:{ all -> 0x004a }
            int r1 = r1 - r2
            goto L_0x002b
        L_0x0042:
            int r8 = r7.f33293b     // Catch:{ all -> 0x004a }
            int r8 = r8 + r0
            r7.a((int) r8)     // Catch:{ all -> 0x004a }
            monitor-exit(r7)
            return r2
        L_0x004a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.s.a(long):boolean");
    }

    private int a(int i2, int i3, long j2, boolean z) {
        int i4 = i2;
        int i5 = -1;
        for (int i6 = 0; i6 < i3 && this.f33300i[i4] <= j2; i6++) {
            if (!z || (this.f33299h[i4] & 1) != 0) {
                i5 = i6;
            }
            i4++;
            if (i4 == this.f33296e) {
                i4 = 0;
            }
        }
        return i5;
    }

    private long d(int i2) {
        this.n = Math.max(this.n, e(i2));
        this.l -= i2;
        this.f33293b += i2;
        this.m += i2;
        int i3 = this.m;
        int i4 = this.f33296e;
        if (i3 >= i4) {
            this.m = i3 - i4;
        }
        this.f33294c -= i2;
        if (this.f33294c < 0) {
            this.f33294c = 0;
        }
        if (this.l != 0) {
            return this.f33297f[this.m];
        }
        int i5 = this.m;
        if (i5 == 0) {
            i5 = this.f33296e;
        }
        int i6 = i5 - 1;
        return this.f33297f[i6] + ((long) this.f33298g[i6]);
    }

    private long e(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int c2 = c(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.f33300i[c2]);
            if ((this.f33299h[c2] & 1) != 0) {
                break;
            }
            c2--;
            if (c2 == -1) {
                c2 = this.f33296e - 1;
            }
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final int c(int i2) {
        int i3 = this.m + i2;
        int i4 = this.f33296e;
        return i3 < i4 ? i3 : i3 - i4;
    }
}
