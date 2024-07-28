package com.google.c;

import com.google.c.bz;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

abstract class f implements bk {
    /* synthetic */ f(byte b2) {
        this();
    }

    private f() {
    }

    static final class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f37841a = true;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f37842b;

        /* renamed from: c  reason: collision with root package name */
        private int f37843c;

        /* renamed from: d  reason: collision with root package name */
        private final int f37844d;

        /* renamed from: e  reason: collision with root package name */
        private int f37845e;

        /* renamed from: f  reason: collision with root package name */
        private int f37846f;

        /* renamed from: g  reason: collision with root package name */
        private int f37847g;

        public a(ByteBuffer byteBuffer) {
            super((byte) 0);
            this.f37842b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f37843c = arrayOffset;
            this.f37844d = arrayOffset;
            this.f37845e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean u() {
            return this.f37843c == this.f37845e;
        }

        public final int a() throws IOException {
            if (u()) {
                return Integer.MAX_VALUE;
            }
            this.f37846f = v();
            int i2 = this.f37846f;
            if (i2 == this.f37847g) {
                return Integer.MAX_VALUE;
            }
            return bz.b(i2);
        }

        public final int b() {
            return this.f37846f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[LOOP:0: B:18:0x0039->B:21:0x0046, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean c() throws java.io.IOException {
            /*
                r7 = this;
                boolean r0 = r7.u()
                r1 = 0
                if (r0 != 0) goto L_0x0091
                int r0 = r7.f37846f
                int r2 = r7.f37847g
                if (r0 != r2) goto L_0x000f
                goto L_0x0091
            L_0x000f:
                int r0 = com.google.c.bz.a(r0)
                r2 = 1
                if (r0 == 0) goto L_0x0064
                if (r0 == r2) goto L_0x005e
                r1 = 2
                if (r0 == r1) goto L_0x0056
                r1 = 3
                r3 = 4
                if (r0 == r1) goto L_0x002b
                r1 = 5
                if (r0 != r1) goto L_0x0026
                r7.a((int) r3)
                return r2
            L_0x0026:
                com.google.c.ad$a r0 = com.google.c.ad.invalidWireType()
                throw r0
            L_0x002b:
                int r0 = r7.f37847g
                int r1 = r7.f37846f
                int r1 = com.google.c.bz.b(r1)
                int r1 = com.google.c.bz.a(r1, r3)
                r7.f37847g = r1
            L_0x0039:
                int r1 = r7.a()
                r3 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r3) goto L_0x0048
                boolean r1 = r7.c()
                if (r1 != 0) goto L_0x0039
            L_0x0048:
                int r1 = r7.f37846f
                int r3 = r7.f37847g
                if (r1 != r3) goto L_0x0051
                r7.f37847g = r0
                return r2
            L_0x0051:
                com.google.c.ad r0 = com.google.c.ad.parseFailure()
                throw r0
            L_0x0056:
                int r0 = r7.v()
                r7.a((int) r0)
                return r2
            L_0x005e:
                r0 = 8
                r7.a((int) r0)
                return r2
            L_0x0064:
                int r0 = r7.f37845e
                int r3 = r7.f37843c
                int r0 = r0 - r3
                r4 = 10
                if (r0 < r4) goto L_0x0080
                byte[] r0 = r7.f37842b
                r5 = r3
                r3 = 0
            L_0x0071:
                if (r3 >= r4) goto L_0x0080
                int r6 = r5 + 1
                byte r5 = r0[r5]
                if (r5 < 0) goto L_0x007c
                r7.f37843c = r6
                goto L_0x008b
            L_0x007c:
                int r3 = r3 + 1
                r5 = r6
                goto L_0x0071
            L_0x0080:
                if (r1 >= r4) goto L_0x008c
                byte r0 = r7.y()
                if (r0 >= 0) goto L_0x008b
                int r1 = r1 + 1
                goto L_0x0080
            L_0x008b:
                return r2
            L_0x008c:
                com.google.c.ad r0 = com.google.c.ad.malformedVarint()
                throw r0
            L_0x0091:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.f.a.c():boolean");
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

        private String a(boolean z) throws IOException {
            c(2);
            int v = v();
            if (v == 0) {
                return "";
            }
            b(v);
            if (z) {
                byte[] bArr = this.f37842b;
                int i2 = this.f37843c;
                if (!by.a(bArr, i2, i2 + v)) {
                    throw ad.invalidUtf8();
                }
            }
            String str = new String(this.f37842b, this.f37843c, v, ac.f37697a);
            this.f37843c += v;
            return str;
        }

        public final <T> T a(Class<T> cls, r rVar) throws IOException {
            c(2);
            return c(bg.a().a(cls), rVar);
        }

        public final <T> T a(bm<T> bmVar, r rVar) throws IOException {
            c(2);
            return c(bmVar, rVar);
        }

        private <T> T c(bm<T> bmVar, r rVar) throws IOException {
            int v = v();
            b(v);
            int i2 = this.f37845e;
            int i3 = this.f37843c + v;
            this.f37845e = i3;
            try {
                T a2 = bmVar.a();
                bmVar.a(a2, this, rVar);
                bmVar.d(a2);
                if (this.f37843c == i3) {
                    return a2;
                }
                throw ad.parseFailure();
            } finally {
                this.f37845e = i2;
            }
        }

        public final <T> T b(Class<T> cls, r rVar) throws IOException {
            c(3);
            return d(bg.a().a(cls), rVar);
        }

        public final <T> T b(bm<T> bmVar, r rVar) throws IOException {
            c(3);
            return d(bmVar, rVar);
        }

        private <T> T d(bm<T> bmVar, r rVar) throws IOException {
            int i2 = this.f37847g;
            this.f37847g = bz.a(bz.b(this.f37846f), 4);
            try {
                T a2 = bmVar.a();
                bmVar.a(a2, this, rVar);
                bmVar.d(a2);
                if (this.f37846f == this.f37847g) {
                    return a2;
                }
                throw ad.parseFailure();
            } finally {
                this.f37847g = i2;
            }
        }

        public final j n() throws IOException {
            j jVar;
            c(2);
            int v = v();
            if (v == 0) {
                return j.EMPTY;
            }
            b(v);
            if (this.f37841a) {
                jVar = j.wrap(this.f37842b, this.f37843c, v);
            } else {
                jVar = j.copyFrom(this.f37842b, this.f37843c, v);
            }
            this.f37843c += v;
            return jVar;
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
            return k.e(v());
        }

        public final long t() throws IOException {
            c(0);
            return k.a(w());
        }

        public final void a(List<Double> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof o) {
                o oVar = (o) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 1) {
                    do {
                        oVar.a(d());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = v();
                    d(v);
                    int i4 = this.f37843c + v;
                    while (this.f37843c < i4) {
                        oVar.a(Double.longBitsToDouble(C()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 1) {
                    do {
                        list.add(Double.valueOf(d()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = v();
                    d(v2);
                    int i5 = this.f37843c + v2;
                    while (this.f37843c < i5) {
                        list.add(Double.valueOf(Double.longBitsToDouble(C())));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void b(List<Float> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof y) {
                y yVar = (y) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 2) {
                    int v = v();
                    e(v);
                    int i4 = this.f37843c + v;
                    while (this.f37843c < i4) {
                        yVar.a(Float.intBitsToFloat(B()));
                    }
                } else if (a2 == 5) {
                    do {
                        yVar.a(e());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 2) {
                    int v2 = v();
                    e(v2);
                    int i5 = this.f37843c + v2;
                    while (this.f37843c < i5) {
                        list.add(Float.valueOf(Float.intBitsToFloat(B())));
                    }
                } else if (a3 == 5) {
                    do {
                        list.add(Float.valueOf(e()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void c(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ak) {
                ak akVar = (ak) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        akVar.a(f());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        akVar.a(w());
                    }
                    f(v);
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Long.valueOf(w()));
                    }
                    f(v2);
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void d(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ak) {
                ak akVar = (ak) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        akVar.a(g());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        akVar.a(w());
                    }
                    f(v);
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Long.valueOf(g()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Long.valueOf(w()));
                    }
                    f(v2);
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void e(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ab) {
                ab abVar = (ab) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        abVar.c(h());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        abVar.c(v());
                    }
                    f(v);
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Integer.valueOf(h()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Integer.valueOf(v()));
                    }
                    f(v2);
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void f(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ak) {
                ak akVar = (ak) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 1) {
                    do {
                        akVar.a(i());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = v();
                    d(v);
                    int i4 = this.f37843c + v;
                    while (this.f37843c < i4) {
                        akVar.a(C());
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 1) {
                    do {
                        list.add(Long.valueOf(i()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = v();
                    d(v2);
                    int i5 = this.f37843c + v2;
                    while (this.f37843c < i5) {
                        list.add(Long.valueOf(C()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void g(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ab) {
                ab abVar = (ab) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 2) {
                    int v = v();
                    e(v);
                    int i4 = this.f37843c + v;
                    while (this.f37843c < i4) {
                        abVar.c(B());
                    }
                } else if (a2 == 5) {
                    do {
                        abVar.c(j());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 2) {
                    int v2 = v();
                    e(v2);
                    int i5 = this.f37843c + v2;
                    while (this.f37843c < i5) {
                        list.add(Integer.valueOf(B()));
                    }
                } else if (a3 == 5) {
                    do {
                        list.add(Integer.valueOf(j()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void h(List<Boolean> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof g) {
                g gVar = (g) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        gVar.a(k());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        gVar.a(v() != 0);
                    }
                    f(v);
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Boolean.valueOf(k()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Boolean.valueOf(v() != 0));
                    }
                    f(v2);
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void i(List<String> list) throws IOException {
            a(list, false);
        }

        public final void j(List<String> list) throws IOException {
            a(list, true);
        }

        private void a(List<String> list, boolean z) throws IOException {
            int i2;
            int i3;
            if (bz.a(this.f37846f) != 2) {
                throw ad.invalidWireType();
            } else if (!(list instanceof ai) || z) {
                do {
                    list.add(a(z));
                    if (!u()) {
                        i2 = this.f37843c;
                    } else {
                        return;
                    }
                } while (v() == this.f37846f);
                this.f37843c = i2;
            } else {
                ai aiVar = (ai) list;
                do {
                    aiVar.a(n());
                    if (!u()) {
                        i3 = this.f37843c;
                    } else {
                        return;
                    }
                } while (v() == this.f37846f);
                this.f37843c = i3;
            }
        }

        public final <T> void a(List<T> list, bm<T> bmVar, r rVar) throws IOException {
            int i2;
            if (bz.a(this.f37846f) == 2) {
                int i3 = this.f37846f;
                do {
                    list.add(c(bmVar, rVar));
                    if (!u()) {
                        i2 = this.f37843c;
                    } else {
                        return;
                    }
                } while (v() == i3);
                this.f37843c = i2;
                return;
            }
            throw ad.invalidWireType();
        }

        public final <T> void b(List<T> list, bm<T> bmVar, r rVar) throws IOException {
            int i2;
            if (bz.a(this.f37846f) == 3) {
                int i3 = this.f37846f;
                do {
                    list.add(d(bmVar, rVar));
                    if (!u()) {
                        i2 = this.f37843c;
                    } else {
                        return;
                    }
                } while (v() == i3);
                this.f37843c = i2;
                return;
            }
            throw ad.invalidWireType();
        }

        public final void k(List<j> list) throws IOException {
            int i2;
            if (bz.a(this.f37846f) == 2) {
                do {
                    list.add(n());
                    if (!u()) {
                        i2 = this.f37843c;
                    } else {
                        return;
                    }
                } while (v() == this.f37846f);
                this.f37843c = i2;
                return;
            }
            throw ad.invalidWireType();
        }

        public final void l(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ab) {
                ab abVar = (ab) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        abVar.c(o());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        abVar.c(v());
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Integer.valueOf(o()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Integer.valueOf(v()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void m(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ab) {
                ab abVar = (ab) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        abVar.c(p());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        abVar.c(v());
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Integer.valueOf(p()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Integer.valueOf(v()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void n(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ab) {
                ab abVar = (ab) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 2) {
                    int v = v();
                    e(v);
                    int i4 = this.f37843c + v;
                    while (this.f37843c < i4) {
                        abVar.c(B());
                    }
                } else if (a2 == 5) {
                    do {
                        abVar.c(q());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 2) {
                    int v2 = v();
                    e(v2);
                    int i5 = this.f37843c + v2;
                    while (this.f37843c < i5) {
                        list.add(Integer.valueOf(B()));
                    }
                } else if (a3 == 5) {
                    do {
                        list.add(Integer.valueOf(q()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void o(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ak) {
                ak akVar = (ak) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 1) {
                    do {
                        akVar.a(r());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = v();
                    d(v);
                    int i4 = this.f37843c + v;
                    while (this.f37843c < i4) {
                        akVar.a(C());
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 1) {
                    do {
                        list.add(Long.valueOf(r()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = v();
                    d(v2);
                    int i5 = this.f37843c + v2;
                    while (this.f37843c < i5) {
                        list.add(Long.valueOf(C()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void p(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ab) {
                ab abVar = (ab) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        abVar.c(s());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        abVar.c(k.e(v()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Integer.valueOf(s()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Integer.valueOf(k.e(v())));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        public final void q(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof ak) {
                ak akVar = (ak) list;
                int a2 = bz.a(this.f37846f);
                if (a2 == 0) {
                    do {
                        akVar.a(t());
                        if (!u()) {
                            i3 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i3;
                } else if (a2 == 2) {
                    int v = this.f37843c + v();
                    while (this.f37843c < v) {
                        akVar.a(k.a(w()));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            } else {
                int a3 = bz.a(this.f37846f);
                if (a3 == 0) {
                    do {
                        list.add(Long.valueOf(t()));
                        if (!u()) {
                            i2 = this.f37843c;
                        } else {
                            return;
                        }
                    } while (v() == this.f37846f);
                    this.f37843c = i2;
                } else if (a3 == 2) {
                    int v2 = this.f37843c + v();
                    while (this.f37843c < v2) {
                        list.add(Long.valueOf(k.a(w())));
                    }
                } else {
                    throw ad.invalidWireType();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(2:20|36)(3:31|21|22)) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
            if (c() != false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            throw new com.google.c.ad("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <K, V> void a(java.util.Map<K, V> r8, com.google.c.am.a<K, V> r9, com.google.c.r r10) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 2
                r7.c((int) r0)
                int r1 = r7.v()
                r7.b((int) r1)
                int r2 = r7.f37845e
                int r3 = r7.f37843c
                int r3 = r3 + r1
                r7.f37845e = r3
                K r1 = r9.f37724b     // Catch:{ all -> 0x005b }
                V r3 = r9.f37726d     // Catch:{ all -> 0x005b }
            L_0x0016:
                int r4 = r7.a()     // Catch:{ all -> 0x005b }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 == r5) goto L_0x0055
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0040
                if (r4 == r0) goto L_0x0033
                boolean r4 = r7.c()     // Catch:{ a -> 0x0048 }
                if (r4 == 0) goto L_0x002d
                goto L_0x0016
            L_0x002d:
                com.google.c.ad r4 = new com.google.c.ad     // Catch:{ a -> 0x0048 }
                r4.<init>((java.lang.String) r6)     // Catch:{ a -> 0x0048 }
                throw r4     // Catch:{ a -> 0x0048 }
            L_0x0033:
                com.google.c.bz$a r4 = r9.f37725c     // Catch:{ a -> 0x0048 }
                V r5 = r9.f37726d     // Catch:{ a -> 0x0048 }
                java.lang.Class r5 = r5.getClass()     // Catch:{ a -> 0x0048 }
                java.lang.Object r3 = r7.a((com.google.c.bz.a) r4, (java.lang.Class<?>) r5, (com.google.c.r) r10)     // Catch:{ a -> 0x0048 }
                goto L_0x0016
            L_0x0040:
                com.google.c.bz$a r4 = r9.f37723a     // Catch:{ a -> 0x0048 }
                r5 = 0
                java.lang.Object r1 = r7.a((com.google.c.bz.a) r4, (java.lang.Class<?>) r5, (com.google.c.r) r5)     // Catch:{ a -> 0x0048 }
                goto L_0x0016
            L_0x0048:
                boolean r4 = r7.c()     // Catch:{ all -> 0x005b }
                if (r4 == 0) goto L_0x004f
                goto L_0x0016
            L_0x004f:
                com.google.c.ad r8 = new com.google.c.ad     // Catch:{ all -> 0x005b }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x005b }
                throw r8     // Catch:{ all -> 0x005b }
            L_0x0055:
                r8.put(r1, r3)     // Catch:{ all -> 0x005b }
                r7.f37845e = r2
                return
            L_0x005b:
                r8 = move-exception
                r7.f37845e = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.f.a.a(java.util.Map, com.google.c.am$a, com.google.c.r):void");
        }

        private Object a(bz.a aVar, Class<?> cls, r rVar) throws IOException {
            switch (aVar) {
                case BOOL:
                    return Boolean.valueOf(k());
                case BYTES:
                    return n();
                case DOUBLE:
                    return Double.valueOf(d());
                case ENUM:
                    return Integer.valueOf(p());
                case FIXED32:
                    return Integer.valueOf(j());
                case FIXED64:
                    return Long.valueOf(i());
                case FLOAT:
                    return Float.valueOf(e());
                case INT32:
                    return Integer.valueOf(h());
                case INT64:
                    return Long.valueOf(g());
                case MESSAGE:
                    return a(cls, rVar);
                case SFIXED32:
                    return Integer.valueOf(q());
                case SFIXED64:
                    return Long.valueOf(r());
                case SINT32:
                    return Integer.valueOf(s());
                case SINT64:
                    return Long.valueOf(t());
                case STRING:
                    return a(true);
                case UINT32:
                    return Integer.valueOf(o());
                case UINT64:
                    return Long.valueOf(f());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int v() throws IOException {
            byte b2;
            int i2 = this.f37843c;
            int i3 = this.f37845e;
            if (i3 != i2) {
                byte[] bArr = this.f37842b;
                int i4 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 >= 0) {
                    this.f37843c = i4;
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
                                                        throw ad.malformedVarint();
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
                    this.f37843c = i5;
                    return b2;
                }
            } else {
                throw ad.truncatedMessage();
            }
        }

        private long w() throws IOException {
            long j;
            int i2;
            long j2;
            long j3;
            byte b2;
            int i3 = this.f37843c;
            int i4 = this.f37845e;
            if (i4 != i3) {
                byte[] bArr = this.f37842b;
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 >= 0) {
                    this.f37843c = i5;
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
                                                        throw ad.malformedVarint();
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
                        this.f37843c = i2;
                        return j;
                    }
                    j = (long) b2;
                    this.f37843c = i2;
                    return j;
                }
            } else {
                throw ad.truncatedMessage();
            }
        }

        private long x() throws IOException {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte y = y();
                j |= ((long) (y & Byte.MAX_VALUE)) << i2;
                if ((y & 128) == 0) {
                    return j;
                }
            }
            throw ad.malformedVarint();
        }

        private byte y() throws IOException {
            int i2 = this.f37843c;
            if (i2 != this.f37845e) {
                byte[] bArr = this.f37842b;
                this.f37843c = i2 + 1;
                return bArr[i2];
            }
            throw ad.truncatedMessage();
        }

        private int z() throws IOException {
            b(4);
            return B();
        }

        private long A() throws IOException {
            b(8);
            return C();
        }

        private int B() {
            int i2 = this.f37843c;
            byte[] bArr = this.f37842b;
            this.f37843c = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        private long C() {
            int i2 = this.f37843c;
            byte[] bArr = this.f37842b;
            this.f37843c = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        private void a(int i2) throws IOException {
            b(i2);
            this.f37843c += i2;
        }

        private void b(int i2) throws IOException {
            if (i2 < 0 || i2 > this.f37845e - this.f37843c) {
                throw ad.truncatedMessage();
            }
        }

        private void c(int i2) throws IOException {
            if (bz.a(this.f37846f) != i2) {
                throw ad.invalidWireType();
            }
        }

        private void d(int i2) throws IOException {
            b(i2);
            if ((i2 & 7) != 0) {
                throw ad.parseFailure();
            }
        }

        private void e(int i2) throws IOException {
            b(i2);
            if ((i2 & 3) != 0) {
                throw ad.parseFailure();
            }
        }

        private void f(int i2) throws IOException {
            if (this.f37843c != i2) {
                throw ad.truncatedMessage();
            }
        }
    }
}
