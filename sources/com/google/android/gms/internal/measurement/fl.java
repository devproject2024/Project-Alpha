package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class fl<T> implements fv<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ff f10652a;

    /* renamed from: b  reason: collision with root package name */
    private final gm<?, ?> f10653b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10654c;

    /* renamed from: d  reason: collision with root package name */
    private final dj<?> f10655d;

    private fl(gm<?, ?> gmVar, dj<?> djVar, ff ffVar) {
        this.f10653b = gmVar;
        this.f10654c = djVar.a(ffVar);
        this.f10655d = djVar;
        this.f10652a = ffVar;
    }

    static <T> fl<T> a(gm<?, ?> gmVar, dj<?> djVar, ff ffVar) {
        return new fl<>(gmVar, djVar, ffVar);
    }

    public final T a() {
        return this.f10652a.p().v();
    }

    public final boolean a(T t, T t2) {
        if (!this.f10653b.b(t).equals(this.f10653b.b(t2))) {
            return false;
        }
        if (this.f10654c) {
            return this.f10655d.a((Object) t).equals(this.f10655d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f10653b.b(t).hashCode();
        return this.f10654c ? (hashCode * 53) + this.f10655d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        fx.a(this.f10653b, t, t2);
        if (this.f10654c) {
            fx.a(this.f10655d, t, t2);
        }
    }

    public final void a(T t, hk hkVar) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.f10655d.a((Object) t).c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            dp dpVar = (dp) next.getKey();
            if (dpVar.c() != hh.MESSAGE || dpVar.d() || dpVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof ej) {
                hkVar.a(dpVar.a(), (Object) ((ej) next).f10616a.getValue().c());
            } else {
                hkVar.a(dpVar.a(), next.getValue());
            }
        }
        gm<?, ?> gmVar = this.f10653b;
        gmVar.b(gmVar.b(t), hkVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.dv$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.cl r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.dv r0 = (com.google.android.gms.internal.measurement.dv) r0
            com.google.android.gms.internal.measurement.gp r1 = r0.zzb
            com.google.android.gms.internal.measurement.gp r2 = com.google.android.gms.internal.measurement.gp.a()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.gp r1 = com.google.android.gms.internal.measurement.gp.b()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.dv$c r10 = (com.google.android.gms.internal.measurement.dv.c) r10
            r10.a()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.ci.a(r11, r12, r14)
            int r2 = r14.f10529a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.dj<?> r12 = r9.f10655d
            com.google.android.gms.internal.measurement.dh r0 = r14.f10532d
            com.google.android.gms.internal.measurement.ff r3 = r9.f10652a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.a(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.dv$e r0 = (com.google.android.gms.internal.measurement.dv.e) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.ci.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.gp) r6, (com.google.android.gms.internal.measurement.cl) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.fq.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.ci.a((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.cl) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.ci.a(r11, r4, r14)
            int r5 = r14.f10529a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.ci.e(r11, r4, r14)
            java.lang.Object r2 = r14.f10531c
            com.google.android.gms.internal.measurement.cm r2 = (com.google.android.gms.internal.measurement.cm) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.fq.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.ci.a(r11, r4, r14)
            int r12 = r14.f10529a
            com.google.android.gms.internal.measurement.dj<?> r0 = r9.f10655d
            com.google.android.gms.internal.measurement.dh r5 = r14.f10532d
            com.google.android.gms.internal.measurement.ff r6 = r9.f10652a
            java.lang.Object r0 = r0.a(r5, r6, r12)
            com.google.android.gms.internal.measurement.dv$e r0 = (com.google.android.gms.internal.measurement.dv.e) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.ci.a((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.cl) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.a((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.eg r10 = com.google.android.gms.internal.measurement.eg.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.fl.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.cl):void");
    }

    public final void a(T t, fw fwVar, dh dhVar) throws IOException {
        boolean z;
        gm<?, ?> gmVar = this.f10653b;
        dj<?> djVar = this.f10655d;
        Object c2 = gmVar.c(t);
        djVar.b((Object) t);
        do {
            try {
                if (fwVar.a() == Integer.MAX_VALUE) {
                    gmVar.b((Object) t, c2);
                    return;
                }
                int b2 = fwVar.b();
                if (b2 == 11) {
                    int i2 = 0;
                    Object obj = null;
                    cm cmVar = null;
                    while (fwVar.a() != Integer.MAX_VALUE) {
                        int b3 = fwVar.b();
                        if (b3 == 16) {
                            i2 = fwVar.o();
                            obj = djVar.a(dhVar, this.f10652a, i2);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                djVar.b();
                            } else {
                                cmVar = fwVar.n();
                            }
                        } else if (!fwVar.c()) {
                            break;
                        }
                    }
                    if (fwVar.b() != 12) {
                        throw eg.zze();
                    } else if (cmVar != null) {
                        if (obj != null) {
                            djVar.c();
                        } else {
                            gmVar.a(c2, i2, cmVar);
                        }
                    }
                } else if ((b2 & 7) != 2) {
                    z = fwVar.c();
                    continue;
                } else if (djVar.a(dhVar, this.f10652a, b2 >>> 3) != null) {
                    djVar.b();
                } else {
                    z = gmVar.a(c2, fwVar);
                    continue;
                }
                z = true;
                continue;
            } finally {
                gmVar.b((Object) t, c2);
            }
        } while (z);
    }

    public final void c(T t) {
        this.f10653b.d(t);
        this.f10655d.c(t);
    }

    public final boolean d(T t) {
        return this.f10655d.a((Object) t).d();
    }

    public final int b(T t) {
        gm<?, ?> gmVar = this.f10653b;
        int e2 = gmVar.e(gmVar.b(t)) + 0;
        if (!this.f10654c) {
            return e2;
        }
        dn<?> a2 = this.f10655d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f10582a.b(); i3++) {
            i2 += dn.b(a2.f10582a.b(i3));
        }
        for (Map.Entry<T, Object> b2 : a2.f10582a.c()) {
            i2 += dn.b(b2);
        }
        return e2 + i2;
    }
}
