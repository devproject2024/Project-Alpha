package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

final class cy extends cw {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11026a = true;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f11027b;

    /* renamed from: c  reason: collision with root package name */
    private int f11028c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11029d;

    /* renamed from: e  reason: collision with root package name */
    private int f11030e;

    /* renamed from: f  reason: collision with root package name */
    private int f11031f;

    /* renamed from: g  reason: collision with root package name */
    private int f11032g;

    public cy(ByteBuffer byteBuffer) {
        super((byte) 0);
        this.f11027b = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.f11028c = arrayOffset;
        this.f11029d = arrayOffset;
        this.f11030e = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean u() {
        return this.f11028c == this.f11030e;
    }

    public final int a() throws IOException {
        if (u()) {
            return Integer.MAX_VALUE;
        }
        this.f11031f = v();
        int i2 = this.f11031f;
        if (i2 == this.f11032g) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int b() {
        return this.f11031f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[LOOP:0: B:18:0x002e->B:21:0x003b, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.u()
            r1 = 0
            if (r0 != 0) goto L_0x0086
            int r0 = r7.f11031f
            int r2 = r7.f11032g
            if (r0 != r2) goto L_0x000f
            goto L_0x0086
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.a((int) r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.vision.et r0 = com.google.android.gms.internal.vision.eu.zzgr()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.f11032g = r0
        L_0x002e:
            int r0 = r7.a()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.c()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.f11031f
            int r1 = r7.f11032g
            if (r0 != r1) goto L_0x0046
            r7.f11032g = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.vision.eu r0 = com.google.android.gms.internal.vision.eu.zzgs()
            throw r0
        L_0x004b:
            int r0 = r7.v()
            r7.a((int) r0)
            return r4
        L_0x0053:
            r0 = 8
            r7.a((int) r0)
            return r4
        L_0x0059:
            int r0 = r7.f11030e
            int r2 = r7.f11028c
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0075
            byte[] r0 = r7.f11027b
            r5 = r2
            r2 = 0
        L_0x0066:
            if (r2 >= r3) goto L_0x0075
            int r6 = r5 + 1
            byte r5 = r0[r5]
            if (r5 < 0) goto L_0x0071
            r7.f11028c = r6
            goto L_0x0080
        L_0x0071:
            int r2 = r2 + 1
            r5 = r6
            goto L_0x0066
        L_0x0075:
            if (r1 >= r3) goto L_0x0081
            byte r0 = r7.y()
            if (r0 >= 0) goto L_0x0080
            int r1 = r1 + 1
            goto L_0x0075
        L_0x0080:
            return r4
        L_0x0081:
            com.google.android.gms.internal.vision.eu r0 = com.google.android.gms.internal.vision.eu.zzgo()
            throw r0
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.cy.c():boolean");
    }

    public final double d() throws IOException {
        c(1);
        return Double.longBitsToDouble(A());
    }

    public final float e() throws IOException {
        c(5);
        return Float.intBitsToFloat(z());
    }

    public final long f() throws IOException {
        c(0);
        return w();
    }

    public final long g() throws IOException {
        c(0);
        return w();
    }

    public final int h() throws IOException {
        c(0);
        return v();
    }

    public final long i() throws IOException {
        c(1);
        return A();
    }

    public final int j() throws IOException {
        c(5);
        return z();
    }

    public final boolean k() throws IOException {
        c(0);
        if (v() != 0) {
            return true;
        }
        return false;
    }

    public final String l() throws IOException {
        return a(false);
    }

    public final String m() throws IOException {
        return a(true);
    }

    private final String a(boolean z) throws IOException {
        c(2);
        int v = v();
        if (v == 0) {
            return "";
        }
        b(v);
        if (z) {
            byte[] bArr = this.f11027b;
            int i2 = this.f11028c;
            if (!hj.a(bArr, i2, i2 + v)) {
                throw eu.zzgt();
            }
        }
        String str = new String(this.f11027b, this.f11028c, v, ek.f11111a);
        this.f11028c += v;
        return str;
    }

    public final <T> T a(Class<T> cls, du duVar) throws IOException {
        c(2);
        return c(ge.a().a(cls), duVar);
    }

    public final <T> T a(gi<T> giVar, du duVar) throws IOException {
        c(2);
        return c(giVar, duVar);
    }

    private final <T> T c(gi<T> giVar, du duVar) throws IOException {
        int v = v();
        b(v);
        int i2 = this.f11030e;
        int i3 = this.f11028c + v;
        this.f11030e = i3;
        try {
            T a2 = giVar.a();
            giVar.a(a2, this, duVar);
            giVar.c(a2);
            if (this.f11028c == i3) {
                return a2;
            }
            throw eu.zzgs();
        } finally {
            this.f11030e = i2;
        }
    }

    public final <T> T b(Class<T> cls, du duVar) throws IOException {
        c(3);
        return d(ge.a().a(cls), duVar);
    }

    public final <T> T b(gi<T> giVar, du duVar) throws IOException {
        c(3);
        return d(giVar, duVar);
    }

    private final <T> T d(gi<T> giVar, du duVar) throws IOException {
        int i2 = this.f11032g;
        this.f11032g = ((this.f11031f >>> 3) << 3) | 4;
        try {
            T a2 = giVar.a();
            giVar.a(a2, this, duVar);
            giVar.c(a2);
            if (this.f11031f == this.f11032g) {
                return a2;
            }
            throw eu.zzgs();
        } finally {
            this.f11032g = i2;
        }
    }

    public final cz n() throws IOException {
        cz czVar;
        c(2);
        int v = v();
        if (v == 0) {
            return cz.zzsd;
        }
        b(v);
        if (this.f11026a) {
            czVar = cz.zzb(this.f11027b, this.f11028c, v);
        } else {
            czVar = cz.zza(this.f11027b, this.f11028c, v);
        }
        this.f11028c += v;
        return czVar;
    }

    public final int o() throws IOException {
        c(0);
        return v();
    }

    public final int p() throws IOException {
        c(0);
        return v();
    }

    public final int q() throws IOException {
        c(5);
        return z();
    }

    public final long r() throws IOException {
        c(1);
        return A();
    }

    public final int s() throws IOException {
        c(0);
        return dl.e(v());
    }

    public final long t() throws IOException {
        c(0);
        return dl.a(w());
    }

    public final void a(List<Double> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof ds) {
            ds dsVar = (ds) list;
            int i4 = this.f11031f & 7;
            if (i4 == 1) {
                do {
                    dsVar.a(d());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = v();
                d(v);
                int i5 = this.f11028c + v;
                while (this.f11028c < i5) {
                    dsVar.a(Double.longBitsToDouble(C()));
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i6 = this.f11031f & 7;
            if (i6 == 1) {
                do {
                    list.add(Double.valueOf(d()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i6 == 2) {
                int v2 = v();
                d(v2);
                int i7 = this.f11028c + v2;
                while (this.f11028c < i7) {
                    list.add(Double.valueOf(Double.longBitsToDouble(C())));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void b(List<Float> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof ef) {
            ef efVar = (ef) list;
            int i4 = this.f11031f & 7;
            if (i4 == 2) {
                int v = v();
                e(v);
                int i5 = this.f11028c + v;
                while (this.f11028c < i5) {
                    efVar.a(Float.intBitsToFloat(B()));
                }
            } else if (i4 == 5) {
                do {
                    efVar.a(e());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else {
                throw eu.zzgr();
            }
        } else {
            int i6 = this.f11031f & 7;
            if (i6 == 2) {
                int v2 = v();
                e(v2);
                int i7 = this.f11028c + v2;
                while (this.f11028c < i7) {
                    list.add(Float.valueOf(Float.intBitsToFloat(B())));
                }
            } else if (i6 == 5) {
                do {
                    list.add(Float.valueOf(e()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void c(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    fgVar.a(f());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    fgVar.a(w());
                }
                f(v);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(f()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Long.valueOf(w()));
                }
                f(v2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void d(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    fgVar.a(g());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    fgVar.a(w());
                }
                f(v);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(g()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Long.valueOf(w()));
                }
                f(v2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void e(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    elVar.c(h());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    elVar.c(v());
                }
                f(v);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(h()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Integer.valueOf(v()));
                }
                f(v2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void f(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i4 = this.f11031f & 7;
            if (i4 == 1) {
                do {
                    fgVar.a(i());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = v();
                d(v);
                int i5 = this.f11028c + v;
                while (this.f11028c < i5) {
                    fgVar.a(C());
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i6 = this.f11031f & 7;
            if (i6 == 1) {
                do {
                    list.add(Long.valueOf(i()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i6 == 2) {
                int v2 = v();
                d(v2);
                int i7 = this.f11028c + v2;
                while (this.f11028c < i7) {
                    list.add(Long.valueOf(C()));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void g(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i4 = this.f11031f & 7;
            if (i4 == 2) {
                int v = v();
                e(v);
                int i5 = this.f11028c + v;
                while (this.f11028c < i5) {
                    elVar.c(B());
                }
            } else if (i4 == 5) {
                do {
                    elVar.c(j());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else {
                throw eu.zzgr();
            }
        } else {
            int i6 = this.f11031f & 7;
            if (i6 == 2) {
                int v2 = v();
                e(v2);
                int i7 = this.f11028c + v2;
                while (this.f11028c < i7) {
                    list.add(Integer.valueOf(B()));
                }
            } else if (i6 == 5) {
                do {
                    list.add(Integer.valueOf(j()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void h(List<Boolean> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof cx) {
            cx cxVar = (cx) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    cxVar.a(k());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    cxVar.a(v() != 0);
                }
                f(v);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Boolean.valueOf(k()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Boolean.valueOf(v() != 0));
                }
                f(v2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int i2;
        int i3;
        if ((this.f11031f & 7) != 2) {
            throw eu.zzgr();
        } else if (!(list instanceof fa) || z) {
            do {
                list.add(a(z));
                if (!u()) {
                    i2 = this.f11028c;
                } else {
                    return;
                }
            } while (v() == this.f11031f);
            this.f11028c = i2;
        } else {
            fa faVar = (fa) list;
            do {
                faVar.a(n());
                if (!u()) {
                    i3 = this.f11028c;
                } else {
                    return;
                }
            } while (v() == this.f11031f);
            this.f11028c = i3;
        }
    }

    public final <T> void a(List<T> list, gi<T> giVar, du duVar) throws IOException {
        int i2;
        int i3 = this.f11031f;
        if ((i3 & 7) == 2) {
            do {
                list.add(c(giVar, duVar));
                if (!u()) {
                    i2 = this.f11028c;
                } else {
                    return;
                }
            } while (v() == i3);
            this.f11028c = i2;
            return;
        }
        throw eu.zzgr();
    }

    public final <T> void b(List<T> list, gi<T> giVar, du duVar) throws IOException {
        int i2;
        int i3 = this.f11031f;
        if ((i3 & 7) == 3) {
            do {
                list.add(d(giVar, duVar));
                if (!u()) {
                    i2 = this.f11028c;
                } else {
                    return;
                }
            } while (v() == i3);
            this.f11028c = i2;
            return;
        }
        throw eu.zzgr();
    }

    public final void k(List<cz> list) throws IOException {
        int i2;
        if ((this.f11031f & 7) == 2) {
            do {
                list.add(n());
                if (!u()) {
                    i2 = this.f11028c;
                } else {
                    return;
                }
            } while (v() == this.f11031f);
            this.f11028c = i2;
            return;
        }
        throw eu.zzgr();
    }

    public final void l(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    elVar.c(o());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    elVar.c(v());
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(o()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Integer.valueOf(v()));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void m(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    elVar.c(p());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    elVar.c(v());
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(p()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Integer.valueOf(v()));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void n(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i4 = this.f11031f & 7;
            if (i4 == 2) {
                int v = v();
                e(v);
                int i5 = this.f11028c + v;
                while (this.f11028c < i5) {
                    elVar.c(B());
                }
            } else if (i4 == 5) {
                do {
                    elVar.c(q());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else {
                throw eu.zzgr();
            }
        } else {
            int i6 = this.f11031f & 7;
            if (i6 == 2) {
                int v2 = v();
                e(v2);
                int i7 = this.f11028c + v2;
                while (this.f11028c < i7) {
                    list.add(Integer.valueOf(B()));
                }
            } else if (i6 == 5) {
                do {
                    list.add(Integer.valueOf(q()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void o(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i4 = this.f11031f & 7;
            if (i4 == 1) {
                do {
                    fgVar.a(r());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = v();
                d(v);
                int i5 = this.f11028c + v;
                while (this.f11028c < i5) {
                    fgVar.a(C());
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i6 = this.f11031f & 7;
            if (i6 == 1) {
                do {
                    list.add(Long.valueOf(r()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i6 == 2) {
                int v2 = v();
                d(v2);
                int i7 = this.f11028c + v2;
                while (this.f11028c < i7) {
                    list.add(Long.valueOf(C()));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void p(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    elVar.c(s());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    elVar.c(dl.e(v()));
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(s()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Integer.valueOf(dl.e(v())));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void q(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i4 = this.f11031f & 7;
            if (i4 == 0) {
                do {
                    fgVar.a(t());
                    if (!u()) {
                        i3 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i3;
            } else if (i4 == 2) {
                int v = this.f11028c + v();
                while (this.f11028c < v) {
                    fgVar.a(dl.a(w()));
                }
            } else {
                throw eu.zzgr();
            }
        } else {
            int i5 = this.f11031f & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(t()));
                    if (!u()) {
                        i2 = this.f11028c;
                    } else {
                        return;
                    }
                } while (v() == this.f11031f);
                this.f11028c = i2;
            } else if (i5 == 2) {
                int v2 = this.f11028c + v();
                while (this.f11028c < v2) {
                    list.add(Long.valueOf(dl.a(w())));
                }
            } else {
                throw eu.zzgr();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(2:20|36)(3:31|21|22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (c() != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        throw new com.google.android.gms.internal.vision.eu("Unable to parse map entry.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void a(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.fj<K, V> r9, com.google.android.gms.internal.vision.du r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.c((int) r0)
            int r1 = r7.v()
            r7.b((int) r1)
            int r2 = r7.f11030e
            int r3 = r7.f11028c
            int r3 = r3 + r1
            r7.f11030e = r3
            K r1 = r9.f11139b     // Catch:{ all -> 0x005b }
            V r3 = r9.f11141d     // Catch:{ all -> 0x005b }
        L_0x0016:
            int r4 = r7.a()     // Catch:{ all -> 0x005b }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0055
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0040
            if (r4 == r0) goto L_0x0033
            boolean r4 = r7.c()     // Catch:{ et -> 0x0048 }
            if (r4 == 0) goto L_0x002d
            goto L_0x0016
        L_0x002d:
            com.google.android.gms.internal.vision.eu r4 = new com.google.android.gms.internal.vision.eu     // Catch:{ et -> 0x0048 }
            r4.<init>(r6)     // Catch:{ et -> 0x0048 }
            throw r4     // Catch:{ et -> 0x0048 }
        L_0x0033:
            com.google.android.gms.internal.vision.hs r4 = r9.f11140c     // Catch:{ et -> 0x0048 }
            V r5 = r9.f11141d     // Catch:{ et -> 0x0048 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ et -> 0x0048 }
            java.lang.Object r3 = r7.a((com.google.android.gms.internal.vision.hs) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.du) r10)     // Catch:{ et -> 0x0048 }
            goto L_0x0016
        L_0x0040:
            com.google.android.gms.internal.vision.hs r4 = r9.f11138a     // Catch:{ et -> 0x0048 }
            r5 = 0
            java.lang.Object r1 = r7.a((com.google.android.gms.internal.vision.hs) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.du) r5)     // Catch:{ et -> 0x0048 }
            goto L_0x0016
        L_0x0048:
            boolean r4 = r7.c()     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x004f
            goto L_0x0016
        L_0x004f:
            com.google.android.gms.internal.vision.eu r8 = new com.google.android.gms.internal.vision.eu     // Catch:{ all -> 0x005b }
            r8.<init>(r6)     // Catch:{ all -> 0x005b }
            throw r8     // Catch:{ all -> 0x005b }
        L_0x0055:
            r8.put(r1, r3)     // Catch:{ all -> 0x005b }
            r7.f11030e = r2
            return
        L_0x005b:
            r8 = move-exception
            r7.f11030e = r2
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.cy.a(java.util.Map, com.google.android.gms.internal.vision.fj, com.google.android.gms.internal.vision.du):void");
    }

    private final Object a(hs hsVar, Class<?> cls, du duVar) throws IOException {
        switch (cv.f11022a[hsVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return n();
            case 3:
                return Double.valueOf(d());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Float.valueOf(e());
            case 8:
                return Integer.valueOf(h());
            case 9:
                return Long.valueOf(g());
            case 10:
                return a(cls, duVar);
            case 11:
                return Integer.valueOf(q());
            case 12:
                return Long.valueOf(r());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return a(true);
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int v() throws IOException {
        byte b2;
        int i2 = this.f11028c;
        int i3 = this.f11030e;
        if (i3 != i2) {
            byte[] bArr = this.f11027b;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.f11028c = i4;
                return b3;
            } else if (i3 - i4 < 9) {
                return (int) x();
            } else {
                int i5 = i4 + 1;
                byte b4 = b3 ^ (bArr[i4] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b5 = b4 ^ (bArr[i5] << 14);
                    if (b5 >= 0) {
                        b2 = b5 ^ 16256;
                    } else {
                        i5 = i6 + 1;
                        byte b6 = b5 ^ (bArr[i6] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ -2080896;
                        } else {
                            i6 = i5 + 1;
                            byte b7 = bArr[i5];
                            b2 = (b6 ^ (b7 << 28)) ^ 266354560;
                            if (b7 < 0) {
                                i5 = i6 + 1;
                                if (bArr[i6] < 0) {
                                    i6 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i6 + 1;
                                        if (bArr[i6] < 0) {
                                            i6 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i6 + 1;
                                                if (bArr[i6] < 0) {
                                                    throw eu.zzgo();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i6;
                }
                this.f11028c = i5;
                return b2;
            }
        } else {
            throw eu.zzgm();
        }
    }

    private final long w() throws IOException {
        long j;
        int i2;
        long j2;
        long j3;
        byte b2;
        int i3 = this.f11028c;
        int i4 = this.f11030e;
        if (i4 != i3) {
            byte[] bArr = this.f11027b;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.f11028c = i5;
                return (long) b3;
            } else if (i4 - i5 < 9) {
                return x();
            } else {
                int i6 = i5 + 1;
                byte b4 = b3 ^ (bArr[i5] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i7 = i6 + 1;
                    byte b5 = b4 ^ (bArr[i6] << 14);
                    if (b5 >= 0) {
                        i2 = i7;
                        j = (long) (b5 ^ 16256);
                    } else {
                        i6 = i7 + 1;
                        byte b6 = b5 ^ (bArr[i7] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ -2080896;
                        } else {
                            long j4 = (long) b6;
                            int i8 = i6 + 1;
                            long j5 = j4 ^ (((long) bArr[i6]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i9 = i8 + 1;
                                long j6 = j5 ^ (((long) bArr[i8]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i8 = i9 + 1;
                                    j5 = j6 ^ (((long) bArr[i9]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i9 = i8 + 1;
                                        j6 = j5 ^ (((long) bArr[i8]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i10 = i9 + 1;
                                            long j7 = (j6 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i2 = i10 + 1;
                                                if (((long) bArr[i10]) < 0) {
                                                    throw eu.zzgo();
                                                }
                                            } else {
                                                i2 = i10;
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i2 = i8;
                        }
                    }
                    this.f11028c = i2;
                    return j;
                }
                j = (long) b2;
                this.f11028c = i2;
                return j;
            }
        } else {
            throw eu.zzgm();
        }
    }

    private final long x() throws IOException {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte y = y();
            j |= ((long) (y & Byte.MAX_VALUE)) << i2;
            if ((y & 128) == 0) {
                return j;
            }
        }
        throw eu.zzgo();
    }

    private final byte y() throws IOException {
        int i2 = this.f11028c;
        if (i2 != this.f11030e) {
            byte[] bArr = this.f11027b;
            this.f11028c = i2 + 1;
            return bArr[i2];
        }
        throw eu.zzgm();
    }

    private final int z() throws IOException {
        b(4);
        return B();
    }

    private final long A() throws IOException {
        b(8);
        return C();
    }

    private final int B() {
        int i2 = this.f11028c;
        byte[] bArr = this.f11027b;
        this.f11028c = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private final long C() {
        int i2 = this.f11028c;
        byte[] bArr = this.f11027b;
        this.f11028c = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private final void a(int i2) throws IOException {
        b(i2);
        this.f11028c += i2;
    }

    private final void b(int i2) throws IOException {
        if (i2 < 0 || i2 > this.f11030e - this.f11028c) {
            throw eu.zzgm();
        }
    }

    private final void c(int i2) throws IOException {
        if ((this.f11031f & 7) != i2) {
            throw eu.zzgr();
        }
    }

    private final void d(int i2) throws IOException {
        b(i2);
        if ((i2 & 7) != 0) {
            throw eu.zzgs();
        }
    }

    private final void e(int i2) throws IOException {
        b(i2);
        if ((i2 & 3) != 0) {
            throw eu.zzgs();
        }
    }

    private final void f(int i2) throws IOException {
        if (this.f11028c != i2) {
            throw eu.zzgm();
        }
    }
}
