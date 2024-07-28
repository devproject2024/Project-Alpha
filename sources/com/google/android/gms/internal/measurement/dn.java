package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class dn<T extends dp<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final dn f10581d = new dn((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final ga<T, Object> f10582a;

    /* renamed from: b  reason: collision with root package name */
    boolean f10583b;

    /* renamed from: c  reason: collision with root package name */
    boolean f10584c;

    private dn() {
        this.f10582a = ga.a(16);
    }

    private dn(byte b2) {
        this(ga.a(0));
        b();
    }

    private dn(ga<T, Object> gaVar) {
        this.f10582a = gaVar;
        b();
    }

    public static <T extends dp<T>> dn<T> a() {
        return f10581d;
    }

    public final void b() {
        if (!this.f10583b) {
            this.f10582a.a();
            this.f10583b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dn)) {
            return false;
        }
        return this.f10582a.equals(((dn) obj).f10582a);
    }

    public final int hashCode() {
        return this.f10582a.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> c() {
        if (this.f10584c) {
            return new el(this.f10582a.entrySet().iterator());
        }
        return this.f10582a.entrySet().iterator();
    }

    private final Object a(T t) {
        Object obj = this.f10582a.get(t);
        return obj instanceof eh ? eh.a() : obj;
    }

    private final void b(T t, Object obj) {
        if (!t.d()) {
            a(t.b(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                a(t.b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof eh) {
            this.f10584c = true;
        }
        this.f10582a.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.ea) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.eh) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.gms.internal.measurement.he r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.dx.a(r3)
            int[] r0 = com.google.android.gms.internal.measurement.dm.f10579a
            com.google.android.gms.internal.measurement.hh r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.ff
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.eh
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.ea
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.cm
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dn.a(com.google.android.gms.internal.measurement.he, java.lang.Object):void");
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f10582a.b(); i2++) {
            if (!c(this.f10582a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> c2 : this.f10582a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends dp<T>> boolean c(Map.Entry<T, Object> entry) {
        dp dpVar = (dp) entry.getKey();
        if (dpVar.c() == hh.MESSAGE) {
            if (dpVar.d()) {
                for (ff l : (List) entry.getValue()) {
                    if (!l.l()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof ff) {
                    if (!((ff) value).l()) {
                        return false;
                    }
                } else if (value instanceof eh) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (obj instanceof fk) {
            return ((fk) obj).a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void a(Map.Entry<T, Object> entry) {
        Object obj;
        dp dpVar = (dp) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof eh) {
            value = eh.a();
        }
        if (dpVar.d()) {
            Object a2 = a(dpVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f10582a.put(dpVar, a2);
        } else if (dpVar.c() == hh.MESSAGE) {
            Object a4 = a(dpVar);
            if (a4 == null) {
                this.f10582a.put(dpVar, a(value));
                return;
            }
            if (a4 instanceof fk) {
                obj = dpVar.g();
            } else {
                ((ff) a4).o();
                obj = dpVar.f().w();
            }
            this.f10582a.put(dpVar, obj);
        } else {
            this.f10582a.put(dpVar, a(value));
        }
    }

    static void a(de deVar, he heVar, int i2, Object obj) throws IOException {
        if (heVar == he.GROUP) {
            dx.a();
            deVar.a(i2, 3);
            ((ff) obj).a(deVar);
            deVar.a(i2, 4);
            return;
        }
        deVar.a(i2, heVar.zzb());
        switch (dm.f10580b[heVar.ordinal()]) {
            case 1:
                deVar.a(((Double) obj).doubleValue());
                return;
            case 2:
                deVar.a(((Float) obj).floatValue());
                return;
            case 3:
                deVar.a(((Long) obj).longValue());
                return;
            case 4:
                deVar.a(((Long) obj).longValue());
                return;
            case 5:
                deVar.a(((Integer) obj).intValue());
                return;
            case 6:
                deVar.c(((Long) obj).longValue());
                return;
            case 7:
                deVar.d(((Integer) obj).intValue());
                return;
            case 8:
                deVar.a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((ff) obj).a(deVar);
                return;
            case 10:
                deVar.a((ff) obj);
                return;
            case 11:
                if (obj instanceof cm) {
                    deVar.a((cm) obj);
                    return;
                } else {
                    deVar.a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof cm) {
                    deVar.a((cm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                deVar.a(bArr, bArr.length);
                return;
            case 13:
                deVar.b(((Integer) obj).intValue());
                return;
            case 14:
                deVar.d(((Integer) obj).intValue());
                return;
            case 15:
                deVar.c(((Long) obj).longValue());
                return;
            case 16:
                deVar.c(((Integer) obj).intValue());
                return;
            case 17:
                deVar.b(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof ea) {
                    deVar.a(((ea) obj).zza());
                    return;
                } else {
                    deVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<T, Object> entry) {
        dp dpVar = (dp) entry.getKey();
        Object value = entry.getValue();
        if (dpVar.c() != hh.MESSAGE || dpVar.d() || dpVar.e()) {
            return a((dp<?>) dpVar, value);
        }
        if (value instanceof eh) {
            return de.b(((dp) entry.getKey()).a(), (ek) (eh) value);
        }
        return de.b(((dp) entry.getKey()).a(), (ff) value);
    }

    static int a(he heVar, int i2, Object obj) {
        int l = de.l(i2);
        if (heVar == he.GROUP) {
            dx.a();
            l <<= 1;
        }
        return l + b(heVar, obj);
    }

    private static int b(he heVar, Object obj) {
        switch (dm.f10580b[heVar.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return de.f();
            case 2:
                ((Float) obj).floatValue();
                return de.e();
            case 3:
                return de.d(((Long) obj).longValue());
            case 4:
                return de.e(((Long) obj).longValue());
            case 5:
                return de.m(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return de.c();
            case 7:
                ((Integer) obj).intValue();
                return de.a();
            case 8:
                ((Boolean) obj).booleanValue();
                return de.g();
            case 9:
                return de.c((ff) obj);
            case 10:
                if (obj instanceof eh) {
                    return de.a((ek) (eh) obj);
                }
                return de.b((ff) obj);
            case 11:
                if (obj instanceof cm) {
                    return de.b((cm) obj);
                }
                return de.b((String) obj);
            case 12:
                if (obj instanceof cm) {
                    return de.b((cm) obj);
                }
                return de.b((byte[]) obj);
            case 13:
                return de.n(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return de.b();
            case 15:
                ((Long) obj).longValue();
                return de.d();
            case 16:
                return de.o(((Integer) obj).intValue());
            case 17:
                return de.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof ea) {
                    return de.p(((ea) obj).zza());
                }
                return de.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(dp<?> dpVar, Object obj) {
        he b2 = dpVar.b();
        int a2 = dpVar.a();
        if (!dpVar.d()) {
            return a(b2, a2, obj);
        }
        int i2 = 0;
        if (dpVar.e()) {
            for (Object b3 : (List) obj) {
                i2 += b(b2, b3);
            }
            return de.l(a2) + i2 + de.q(i2);
        }
        for (Object a3 : (List) obj) {
            i2 += a(b2, a2, a3);
        }
        return i2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        dn dnVar = new dn();
        for (int i2 = 0; i2 < this.f10582a.b(); i2++) {
            Map.Entry<T, Object> b2 = this.f10582a.b(i2);
            dnVar.b((dp) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f10582a.c()) {
            dnVar.b((dp) next.getKey(), next.getValue());
        }
        dnVar.f10584c = this.f10584c;
        return dnVar;
    }
}
