package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class fz<T> implements gi<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ft f11154a;

    /* renamed from: b  reason: collision with root package name */
    private final ha<?, ?> f11155b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11156c;

    /* renamed from: d  reason: collision with root package name */
    private final dw<?> f11157d;

    private fz(ha<?, ?> haVar, dw<?> dwVar, ft ftVar) {
        this.f11155b = haVar;
        this.f11156c = dwVar.a(ftVar);
        this.f11157d = dwVar;
        this.f11154a = ftVar;
    }

    static <T> fz<T> a(ha<?, ?> haVar, dw<?> dwVar, ft ftVar) {
        return new fz<>(haVar, dwVar, ftVar);
    }

    public final T a() {
        return this.f11154a.j().c();
    }

    public final boolean a(T t, T t2) {
        if (!this.f11155b.b(t).equals(this.f11155b.b(t2))) {
            return false;
        }
        if (this.f11156c) {
            return this.f11157d.a((Object) t).equals(this.f11157d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f11155b.b(t).hashCode();
        return this.f11156c ? (hashCode * 53) + this.f11157d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        gk.a(this.f11155b, t, t2);
        if (this.f11156c) {
            gk.a(this.f11157d, t, t2);
        }
    }

    public final void a(T t, hx hxVar) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.f11157d.a((Object) t).c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            eb ebVar = (eb) next.getKey();
            if (ebVar.c() != hv.MESSAGE || ebVar.d() || ebVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof ex) {
                hxVar.a(ebVar.a(), (Object) ((ex) next).f11120a.getValue().c());
            } else {
                hxVar.a(ebVar.a(), next.getValue());
            }
        }
        ha<?, ?> haVar = this.f11155b;
        haVar.b(haVar.b(t), hxVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.android.gms.internal.vision.ej$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.vision.ct r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.vision.ej r0 = (com.google.android.gms.internal.vision.ej) r0
            com.google.android.gms.internal.vision.hd r1 = r0.zzwj
            com.google.android.gms.internal.vision.hd r2 = com.google.android.gms.internal.vision.hd.a()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.vision.hd r1 = com.google.android.gms.internal.vision.hd.b()
            r0.zzwj = r1
        L_0x0011:
            com.google.android.gms.internal.vision.ej$d r11 = (com.google.android.gms.internal.vision.ej.d) r11
            com.google.android.gms.internal.vision.dz r11 = r11.a()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00c9
            int r4 = com.google.android.gms.internal.vision.cr.a(r12, r13, r15)
            int r13 = r15.f11017a
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L_0x0065
            r3 = r13 & 7
            if (r3 != r5) goto L_0x0060
            com.google.android.gms.internal.vision.dw<?> r2 = r10.f11157d
            com.google.android.gms.internal.vision.du r3 = r15.f11020d
            com.google.android.gms.internal.vision.ft r5 = r10.f11154a
            int r6 = r13 >>> 3
            java.lang.Object r2 = r2.a(r3, r5, r6)
            r8 = r2
            com.google.android.gms.internal.vision.ej$f r8 = (com.google.android.gms.internal.vision.ej.f) r8
            if (r8 == 0) goto L_0x0055
            com.google.android.gms.internal.vision.ge r13 = com.google.android.gms.internal.vision.ge.a()
            com.google.android.gms.internal.vision.ft r2 = r8.f11109a
            java.lang.Class r2 = r2.getClass()
            com.google.android.gms.internal.vision.gi r13 = r13.a(r2)
            int r13 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r13, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.ct) r15)
            com.google.android.gms.internal.vision.ej$c r2 = r8.f11110b
            java.lang.Object r3 = r15.f11019c
            r11.a(r2, (java.lang.Object) r3)
            goto L_0x005e
        L_0x0055:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.vision.cr.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.hd) r6, (com.google.android.gms.internal.vision.ct) r7)
        L_0x005e:
            r2 = r8
            goto L_0x0019
        L_0x0060:
            int r13 = com.google.android.gms.internal.vision.cr.a((int) r13, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.ct) r15)
            goto L_0x0019
        L_0x0065:
            r13 = 0
            r3 = r0
        L_0x0067:
            if (r4 >= r14) goto L_0x00be
            int r4 = com.google.android.gms.internal.vision.cr.a(r12, r4, r15)
            int r6 = r15.f11017a
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto L_0x00a0
            r9 = 3
            if (r7 == r9) goto L_0x0079
            goto L_0x00b5
        L_0x0079:
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.vision.ge r6 = com.google.android.gms.internal.vision.ge.a()
            com.google.android.gms.internal.vision.ft r7 = r2.f11109a
            java.lang.Class r7 = r7.getClass()
            com.google.android.gms.internal.vision.gi r6 = r6.a(r7)
            int r4 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r6, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.ct) r15)
            com.google.android.gms.internal.vision.ej$c r6 = r2.f11110b
            java.lang.Object r7 = r15.f11019c
            r11.a(r6, (java.lang.Object) r7)
            goto L_0x0067
        L_0x0095:
            if (r8 != r5) goto L_0x00b5
            int r4 = com.google.android.gms.internal.vision.cr.e(r12, r4, r15)
            java.lang.Object r3 = r15.f11019c
            com.google.android.gms.internal.vision.cz r3 = (com.google.android.gms.internal.vision.cz) r3
            goto L_0x0067
        L_0x00a0:
            if (r8 != 0) goto L_0x00b5
            int r4 = com.google.android.gms.internal.vision.cr.a(r12, r4, r15)
            int r13 = r15.f11017a
            com.google.android.gms.internal.vision.dw<?> r2 = r10.f11157d
            com.google.android.gms.internal.vision.du r6 = r15.f11020d
            com.google.android.gms.internal.vision.ft r7 = r10.f11154a
            java.lang.Object r2 = r2.a(r6, r7, r13)
            com.google.android.gms.internal.vision.ej$f r2 = (com.google.android.gms.internal.vision.ej.f) r2
            goto L_0x0067
        L_0x00b5:
            r7 = 12
            if (r6 == r7) goto L_0x00be
            int r4 = com.google.android.gms.internal.vision.cr.a((int) r6, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.ct) r15)
            goto L_0x0067
        L_0x00be:
            if (r3 == 0) goto L_0x00c6
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.a((int) r13, (java.lang.Object) r3)
        L_0x00c6:
            r13 = r4
            goto L_0x0019
        L_0x00c9:
            if (r13 != r14) goto L_0x00cc
            return
        L_0x00cc:
            com.google.android.gms.internal.vision.eu r11 = com.google.android.gms.internal.vision.eu.zzgs()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fz.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.ct):void");
    }

    public final void a(T t, gj gjVar, du duVar) throws IOException {
        boolean z;
        ha<?, ?> haVar = this.f11155b;
        dw<?> dwVar = this.f11157d;
        Object c2 = haVar.c(t);
        dz<?> b2 = dwVar.b(t);
        do {
            try {
                if (gjVar.a() == Integer.MAX_VALUE) {
                    haVar.b((Object) t, c2);
                    return;
                }
                int b3 = gjVar.b();
                if (b3 == 11) {
                    int i2 = 0;
                    Object obj = null;
                    cz czVar = null;
                    while (gjVar.a() != Integer.MAX_VALUE) {
                        int b4 = gjVar.b();
                        if (b4 == 16) {
                            i2 = gjVar.o();
                            obj = dwVar.a(duVar, this.f11154a, i2);
                        } else if (b4 == 26) {
                            if (obj != null) {
                                dwVar.a(gjVar, obj, duVar, b2);
                            } else {
                                czVar = gjVar.n();
                            }
                        } else if (!gjVar.c()) {
                            break;
                        }
                    }
                    if (gjVar.b() != 12) {
                        throw eu.zzgq();
                    } else if (czVar != null) {
                        if (obj != null) {
                            dwVar.a(czVar, obj, duVar, b2);
                        } else {
                            haVar.a(c2, i2, czVar);
                        }
                    }
                } else if ((b3 & 7) == 2) {
                    Object a2 = dwVar.a(duVar, this.f11154a, b3 >>> 3);
                    if (a2 != null) {
                        dwVar.a(gjVar, a2, duVar, b2);
                    } else {
                        z = haVar.a(c2, gjVar);
                        continue;
                    }
                } else {
                    z = gjVar.c();
                    continue;
                }
                z = true;
                continue;
            } finally {
                haVar.b((Object) t, c2);
            }
        } while (z);
    }

    public final void c(T t) {
        this.f11155b.d(t);
        this.f11157d.c(t);
    }

    public final boolean d(T t) {
        return this.f11157d.a((Object) t).d();
    }

    public final int b(T t) {
        ha<?, ?> haVar = this.f11155b;
        int e2 = haVar.e(haVar.b(t)) + 0;
        if (!this.f11156c) {
            return e2;
        }
        dz<?> a2 = this.f11157d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f11075a.b(); i3++) {
            i2 += dz.b(a2.f11075a.b(i3));
        }
        for (Map.Entry<T, Object> b2 : a2.f11075a.c()) {
            i2 += dz.b(b2);
        }
        return e2 + i2;
    }
}
