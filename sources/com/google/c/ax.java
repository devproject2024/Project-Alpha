package com.google.c;

import com.google.c.af;
import com.google.c.bz;
import com.google.c.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class ax<T> implements bm<T> {

    /* renamed from: a  reason: collision with root package name */
    private final at f37739a;

    /* renamed from: b  reason: collision with root package name */
    private final bt<?, ?> f37740b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37741c;

    /* renamed from: d  reason: collision with root package name */
    private final s<?> f37742d;

    private ax(bt<?, ?> btVar, s<?> sVar, at atVar) {
        this.f37740b = btVar;
        this.f37741c = sVar.a(atVar);
        this.f37742d = sVar;
        this.f37739a = atVar;
    }

    static <T> ax<T> a(bt<?, ?> btVar, s<?> sVar, at atVar) {
        return new ax<>(btVar, sVar, atVar);
    }

    public final T a() {
        return this.f37739a.n().b();
    }

    public final boolean a(T t, T t2) {
        if (!this.f37740b.b(t).equals(this.f37740b.b(t2))) {
            return false;
        }
        if (this.f37741c) {
            return this.f37742d.a((Object) t).equals(this.f37742d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f37740b.b(t).hashCode();
        return this.f37741c ? (hashCode * 53) + this.f37742d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        bo.a(this.f37740b, t, t2);
        if (this.f37741c) {
            bo.a(this.f37742d, t, t2);
        }
    }

    public final void a(T t, ca caVar) throws IOException {
        Iterator<Map.Entry<?, Object>> d2 = this.f37742d.a((Object) t).d();
        while (d2.hasNext()) {
            Map.Entry next = d2.next();
            w.a aVar = (w.a) next.getKey();
            if (aVar.c() != bz.b.MESSAGE || aVar.d() || aVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof af.a) {
                caVar.a(aVar.a(), (Object) ((af.a) next).f37703a.getValue().c());
            } else {
                caVar.a(aVar.a(), next.getValue());
            }
        }
        bt<?, ?> btVar = this.f37740b;
        btVar.b(btVar.b(t), caVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.c.aa$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r11, byte[] r12, int r13, int r14, com.google.c.e.a r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.c.aa r0 = (com.google.c.aa) r0
            com.google.c.bu r1 = r0.f37680e
            com.google.c.bu r2 = com.google.c.bu.a()
            if (r1 != r2) goto L_0x0011
            com.google.c.bu r1 = com.google.c.bu.b()
            r0.f37680e = r1
        L_0x0011:
            com.google.c.aa$c r11 = (com.google.c.aa.c) r11
            com.google.c.w r11 = r11.a()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d2
            int r4 = com.google.c.e.a(r12, r13, r15)
            int r13 = r15.f37836a
            int r3 = com.google.c.bz.f37827a
            r5 = 2
            if (r13 == r3) goto L_0x0069
            int r3 = com.google.c.bz.a(r13)
            if (r3 != r5) goto L_0x0064
            com.google.c.s<?> r2 = r10.f37742d
            com.google.c.r r3 = r15.f37839d
            com.google.c.at r5 = r10.f37739a
            int r6 = com.google.c.bz.b(r13)
            java.lang.Object r2 = r2.a(r3, r5, r6)
            r8 = r2
            com.google.c.aa$f r8 = (com.google.c.aa.f) r8
            if (r8 == 0) goto L_0x0059
            com.google.c.bg r13 = com.google.c.bg.a()
            com.google.c.at r2 = r8.f37692a
            java.lang.Class r2 = r2.getClass()
            com.google.c.bm r13 = r13.a(r2)
            int r13 = com.google.c.e.a((com.google.c.bm) r13, (byte[]) r12, (int) r4, (int) r14, (com.google.c.e.a) r15)
            com.google.c.aa$e r2 = r8.f37693b
            java.lang.Object r3 = r15.f37838c
            r11.a(r2, (java.lang.Object) r3)
            goto L_0x0062
        L_0x0059:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.c.e.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.c.bu) r6, (com.google.c.e.a) r7)
        L_0x0062:
            r2 = r8
            goto L_0x0019
        L_0x0064:
            int r13 = com.google.c.e.a((int) r13, (byte[]) r12, (int) r4, (int) r14, (com.google.c.e.a) r15)
            goto L_0x0019
        L_0x0069:
            r13 = 0
            r3 = r0
        L_0x006b:
            if (r4 >= r14) goto L_0x00c6
            int r4 = com.google.c.e.a(r12, r4, r15)
            int r6 = r15.f37836a
            int r7 = com.google.c.bz.b(r6)
            int r8 = com.google.c.bz.a(r6)
            if (r7 == r5) goto L_0x00a8
            r9 = 3
            if (r7 == r9) goto L_0x0081
            goto L_0x00bd
        L_0x0081:
            if (r2 == 0) goto L_0x009d
            com.google.c.bg r6 = com.google.c.bg.a()
            com.google.c.at r7 = r2.f37692a
            java.lang.Class r7 = r7.getClass()
            com.google.c.bm r6 = r6.a(r7)
            int r4 = com.google.c.e.a((com.google.c.bm) r6, (byte[]) r12, (int) r4, (int) r14, (com.google.c.e.a) r15)
            com.google.c.aa$e r6 = r2.f37693b
            java.lang.Object r7 = r15.f37838c
            r11.a(r6, (java.lang.Object) r7)
            goto L_0x006b
        L_0x009d:
            if (r8 != r5) goto L_0x00bd
            int r4 = com.google.c.e.e(r12, r4, r15)
            java.lang.Object r3 = r15.f37838c
            com.google.c.j r3 = (com.google.c.j) r3
            goto L_0x006b
        L_0x00a8:
            if (r8 != 0) goto L_0x00bd
            int r4 = com.google.c.e.a(r12, r4, r15)
            int r13 = r15.f37836a
            com.google.c.s<?> r2 = r10.f37742d
            com.google.c.r r6 = r15.f37839d
            com.google.c.at r7 = r10.f37739a
            java.lang.Object r2 = r2.a(r6, r7, r13)
            com.google.c.aa$f r2 = (com.google.c.aa.f) r2
            goto L_0x006b
        L_0x00bd:
            int r7 = com.google.c.bz.f37828b
            if (r6 == r7) goto L_0x00c6
            int r4 = com.google.c.e.a((int) r6, (byte[]) r12, (int) r4, (int) r14, (com.google.c.e.a) r15)
            goto L_0x006b
        L_0x00c6:
            if (r3 == 0) goto L_0x00cf
            int r13 = com.google.c.bz.a(r13, r5)
            r1.a((int) r13, (java.lang.Object) r3)
        L_0x00cf:
            r13 = r4
            goto L_0x0019
        L_0x00d2:
            if (r13 != r14) goto L_0x00d5
            return
        L_0x00d5:
            com.google.c.ad r11 = com.google.c.ad.parseFailure()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.ax.a(java.lang.Object, byte[], int, int, com.google.c.e$a):void");
    }

    public final void a(T t, bk bkVar, r rVar) throws IOException {
        boolean z;
        bt<?, ?> btVar = this.f37740b;
        s<?> sVar = this.f37742d;
        Object c2 = btVar.c(t);
        w<?> b2 = sVar.b(t);
        do {
            try {
                if (bkVar.a() == Integer.MAX_VALUE) {
                    btVar.b((Object) t, c2);
                    return;
                }
                int b3 = bkVar.b();
                if (b3 == bz.f37827a) {
                    int i2 = 0;
                    Object obj = null;
                    j jVar = null;
                    while (bkVar.a() != Integer.MAX_VALUE) {
                        int b4 = bkVar.b();
                        if (b4 == bz.f37829c) {
                            i2 = bkVar.o();
                            obj = sVar.a(rVar, this.f37739a, i2);
                        } else if (b4 == bz.f37830d) {
                            if (obj != null) {
                                sVar.a(bkVar, obj, rVar, b2);
                            } else {
                                jVar = bkVar.n();
                            }
                        } else if (!bkVar.c()) {
                            break;
                        }
                    }
                    if (bkVar.b() != bz.f37828b) {
                        throw ad.invalidEndTag();
                    } else if (jVar != null) {
                        if (obj != null) {
                            sVar.a(jVar, obj, rVar, b2);
                        } else {
                            btVar.a(c2, i2, jVar);
                        }
                    }
                } else if (bz.a(b3) == 2) {
                    Object a2 = sVar.a(rVar, this.f37739a, bz.b(b3));
                    if (a2 != null) {
                        sVar.a(bkVar, a2, rVar, b2);
                    } else {
                        z = btVar.a(c2, bkVar);
                        continue;
                    }
                } else {
                    z = bkVar.c();
                    continue;
                }
                z = true;
                continue;
            } finally {
                btVar.b((Object) t, c2);
            }
        } while (z);
    }

    public final void d(T t) {
        this.f37740b.d(t);
        this.f37742d.c(t);
    }

    public final boolean e(T t) {
        return this.f37742d.a((Object) t).e();
    }

    public final int b(T t) {
        bt<?, ?> btVar = this.f37740b;
        int e2 = btVar.e(btVar.b(t)) + 0;
        if (!this.f37741c) {
            return e2;
        }
        w<?> a2 = this.f37742d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f37925a.b(); i3++) {
            i2 += w.b(a2.f37925a.b(i3));
        }
        for (Map.Entry<T, Object> b2 : a2.f37925a.c()) {
            i2 += w.b(b2);
        }
        return e2 + i2;
    }
}
