package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.eb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class dz<T extends eb<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final dz f11074d = new dz((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final gn<T, Object> f11075a;

    /* renamed from: b  reason: collision with root package name */
    boolean f11076b;

    /* renamed from: c  reason: collision with root package name */
    boolean f11077c;

    private dz() {
        this.f11075a = gn.a(16);
    }

    private dz(byte b2) {
        this(gn.a(0));
        b();
    }

    private dz(gn<T, Object> gnVar) {
        this.f11075a = gnVar;
        b();
    }

    public static <T extends eb<T>> dz<T> a() {
        return f11074d;
    }

    public final void b() {
        if (!this.f11076b) {
            this.f11075a.a();
            this.f11076b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dz)) {
            return false;
        }
        return this.f11075a.equals(((dz) obj).f11075a);
    }

    public final int hashCode() {
        return this.f11075a.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> c() {
        if (this.f11077c) {
            return new ez(this.f11075a.entrySet().iterator());
        }
        return this.f11075a.entrySet().iterator();
    }

    public final Object a(T t) {
        Object obj = this.f11075a.get(t);
        return obj instanceof ev ? ev.a() : obj;
    }

    public final void a(T t, Object obj) {
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
        if (obj instanceof ev) {
            this.f11077c = true;
        }
        this.f11075a.put(t, obj);
    }

    public final void b(T t, Object obj) {
        List list;
        if (t.d()) {
            a(t.b(), obj);
            Object a2 = a(t);
            if (a2 == null) {
                list = new ArrayList();
                this.f11075a.put(t, list);
            } else {
                list = (List) a2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.en) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.ev) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.gms.internal.vision.hs r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.vision.ek.a(r3)
            int[] r0 = com.google.android.gms.internal.vision.ec.f11081a
            com.google.android.gms.internal.vision.hv r2 = r2.zzip()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.ft
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.ev
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.en
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.cz
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.dz.a(com.google.android.gms.internal.vision.hs, java.lang.Object):void");
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f11075a.b(); i2++) {
            if (!c(this.f11075a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> c2 : this.f11075a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends eb<T>> boolean c(Map.Entry<T, Object> entry) {
        eb ebVar = (eb) entry.getKey();
        if (ebVar.c() == hv.MESSAGE) {
            if (ebVar.d()) {
                for (ft g2 : (List) entry.getValue()) {
                    if (!g2.g()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof ft) {
                    if (!((ft) value).g()) {
                        return false;
                    }
                } else if (value instanceof ev) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (obj instanceof fy) {
            return ((fy) obj).a();
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
        eb ebVar = (eb) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ev) {
            value = ev.a();
        }
        if (ebVar.d()) {
            Object a2 = a(ebVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f11075a.put(ebVar, a2);
        } else if (ebVar.c() == hv.MESSAGE) {
            Object a4 = a(ebVar);
            if (a4 == null) {
                this.f11075a.put(ebVar, a(value));
                return;
            }
            if (a4 instanceof fy) {
                obj = ebVar.f();
            } else {
                obj = ebVar.a(((ft) a4).i(), (ft) value).d();
            }
            this.f11075a.put(ebVar, obj);
        } else {
            this.f11075a.put(ebVar, a(value));
        }
    }

    static void a(dr drVar, hs hsVar, int i2, Object obj) throws IOException {
        if (hsVar == hs.GROUP) {
            ek.a();
            drVar.a(i2, 3);
            ((ft) obj).a(drVar);
            drVar.a(i2, 4);
            return;
        }
        drVar.a(i2, hsVar.zziq());
        switch (ec.f11082b[hsVar.ordinal()]) {
            case 1:
                drVar.a(((Double) obj).doubleValue());
                return;
            case 2:
                drVar.a(((Float) obj).floatValue());
                return;
            case 3:
                drVar.a(((Long) obj).longValue());
                return;
            case 4:
                drVar.a(((Long) obj).longValue());
                return;
            case 5:
                drVar.a(((Integer) obj).intValue());
                return;
            case 6:
                drVar.c(((Long) obj).longValue());
                return;
            case 7:
                drVar.d(((Integer) obj).intValue());
                return;
            case 8:
                drVar.a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((ft) obj).a(drVar);
                return;
            case 10:
                drVar.a((ft) obj);
                return;
            case 11:
                if (obj instanceof cz) {
                    drVar.a((cz) obj);
                    return;
                } else {
                    drVar.a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof cz) {
                    drVar.a((cz) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                drVar.a(bArr, bArr.length);
                return;
            case 13:
                drVar.b(((Integer) obj).intValue());
                return;
            case 14:
                drVar.d(((Integer) obj).intValue());
                return;
            case 15:
                drVar.c(((Long) obj).longValue());
                return;
            case 16:
                drVar.c(((Integer) obj).intValue());
                return;
            case 17:
                drVar.b(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof en) {
                    drVar.a(((en) obj).zzag());
                    return;
                } else {
                    drVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<T, Object> entry) {
        eb ebVar = (eb) entry.getKey();
        Object value = entry.getValue();
        if (ebVar.c() != hv.MESSAGE || ebVar.d() || ebVar.e()) {
            return c(ebVar, value);
        }
        if (value instanceof ev) {
            return dr.b(((eb) entry.getKey()).a(), (ey) (ev) value);
        }
        return dr.b(((eb) entry.getKey()).a(), (ft) value);
    }

    static int a(hs hsVar, int i2, Object obj) {
        int l = dr.l(i2);
        if (hsVar == hs.GROUP) {
            ek.a();
            l <<= 1;
        }
        return l + b(hsVar, obj);
    }

    private static int b(hs hsVar, Object obj) {
        switch (ec.f11082b[hsVar.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return dr.f();
            case 2:
                ((Float) obj).floatValue();
                return dr.e();
            case 3:
                return dr.d(((Long) obj).longValue());
            case 4:
                return dr.e(((Long) obj).longValue());
            case 5:
                return dr.m(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return dr.c();
            case 7:
                ((Integer) obj).intValue();
                return dr.a();
            case 8:
                ((Boolean) obj).booleanValue();
                return dr.g();
            case 9:
                return dr.c((ft) obj);
            case 10:
                if (obj instanceof ev) {
                    return dr.a((ey) (ev) obj);
                }
                return dr.b((ft) obj);
            case 11:
                if (obj instanceof cz) {
                    return dr.b((cz) obj);
                }
                return dr.b((String) obj);
            case 12:
                if (obj instanceof cz) {
                    return dr.b((cz) obj);
                }
                return dr.b((byte[]) obj);
            case 13:
                return dr.n(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return dr.b();
            case 15:
                ((Long) obj).longValue();
                return dr.d();
            case 16:
                return dr.o(((Integer) obj).intValue());
            case 17:
                return dr.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof en) {
                    return dr.p(((en) obj).zzag());
                }
                return dr.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(eb<?> ebVar, Object obj) {
        hs b2 = ebVar.b();
        int a2 = ebVar.a();
        if (!ebVar.d()) {
            return a(b2, a2, obj);
        }
        int i2 = 0;
        if (ebVar.e()) {
            for (Object b3 : (List) obj) {
                i2 += b(b2, b3);
            }
            return dr.l(a2) + i2 + dr.q(i2);
        }
        for (Object a3 : (List) obj) {
            i2 += a(b2, a2, a3);
        }
        return i2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        dz dzVar = new dz();
        for (int i2 = 0; i2 < this.f11075a.b(); i2++) {
            Map.Entry<T, Object> b2 = this.f11075a.b(i2);
            dzVar.a((eb) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f11075a.c()) {
            dzVar.a((eb) next.getKey(), next.getValue());
        }
        dzVar.f11077c = this.f11077c;
        return dzVar;
    }
}
