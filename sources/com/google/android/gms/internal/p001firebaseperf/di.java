package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.di  reason: invalid package */
final class di<FieldDescriptorType extends dk<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    private static final di f9554d = new di((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final fq<FieldDescriptorType, Object> f9555a = fq.a(16);

    /* renamed from: b  reason: collision with root package name */
    boolean f9556b;

    /* renamed from: c  reason: collision with root package name */
    boolean f9557c = false;

    private di() {
    }

    private di(byte b2) {
        b();
    }

    public static <T extends dk<T>> di<T> a() {
        return f9554d;
    }

    public final void b() {
        if (!this.f9556b) {
            this.f9555a.a();
            this.f9556b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof di)) {
            return false;
        }
        return this.f9555a.equals(((di) obj).f9555a);
    }

    public final int hashCode() {
        return this.f9555a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> c() {
        if (this.f9557c) {
            return new ee(this.f9555a.entrySet().iterator());
        }
        return this.f9555a.entrySet().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f9555a.get(fielddescriptortype);
        return obj instanceof ed ? ed.a() : obj;
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.d()) {
            a(fielddescriptortype.b(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                a(fielddescriptortype.b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof ed) {
            this.f9557c = true;
        }
        this.f9555a.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p001firebaseperf.ed) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p001firebaseperf.ds) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.gms.internal.p001firebaseperf.gu r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.p001firebaseperf.dt.a(r3)
            int[] r0 = com.google.android.gms.internal.p001firebaseperf.dl.f9560a
            com.google.android.gms.internal.firebase-perf.gx r2 = r2.zzju()
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
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p001firebaseperf.ex
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.p001firebaseperf.ed
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.p001firebaseperf.ds
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p001firebaseperf.co
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
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
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseperf.di.a(com.google.android.gms.internal.firebase-perf.gu, java.lang.Object):void");
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f9555a.b(); i2++) {
            if (!c(this.f9555a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> c2 : this.f9555a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(Map.Entry<FieldDescriptorType, Object> entry) {
        dk dkVar = (dk) entry.getKey();
        if (dkVar.c() == gx.MESSAGE) {
            if (dkVar.d()) {
                for (ex m : (List) entry.getValue()) {
                    if (!m.m()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof ex) {
                    if (!((ex) value).m()) {
                        return false;
                    }
                } else if (value instanceof ed) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (obj instanceof fe) {
            return ((fe) obj).a();
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
    public final void a(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        dk dkVar = (dk) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ed) {
            value = ed.a();
        }
        if (dkVar.d()) {
            Object a2 = a(dkVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f9555a.put(dkVar, a2);
        } else if (dkVar.c() == gx.MESSAGE) {
            Object a4 = a(dkVar);
            if (a4 == null) {
                this.f9555a.put(dkVar, a(value));
                return;
            }
            if (a4 instanceof fe) {
                obj = dkVar.g();
            } else {
                ((ex) a4).p();
                obj = dkVar.f().k();
            }
            this.f9555a.put(dkVar, obj);
        } else {
            this.f9555a.put(dkVar, a(value));
        }
    }

    static void a(da daVar, gu guVar, int i2, Object obj) throws IOException {
        if (guVar == gu.GROUP) {
            dt.a();
            daVar.a(i2, 3);
            ((ex) obj).a(daVar);
            daVar.a(i2, 4);
            return;
        }
        daVar.a(i2, guVar.zzjv());
        switch (dl.f9561b[guVar.ordinal()]) {
            case 1:
                daVar.a(((Double) obj).doubleValue());
                return;
            case 2:
                daVar.a(((Float) obj).floatValue());
                return;
            case 3:
                daVar.a(((Long) obj).longValue());
                return;
            case 4:
                daVar.a(((Long) obj).longValue());
                return;
            case 5:
                daVar.a(((Integer) obj).intValue());
                return;
            case 6:
                daVar.c(((Long) obj).longValue());
                return;
            case 7:
                daVar.d(((Integer) obj).intValue());
                return;
            case 8:
                daVar.a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((ex) obj).a(daVar);
                return;
            case 10:
                daVar.a((ex) obj);
                return;
            case 11:
                if (obj instanceof co) {
                    daVar.a((co) obj);
                    return;
                } else {
                    daVar.a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof co) {
                    daVar.a((co) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                daVar.a(bArr, bArr.length);
                return;
            case 13:
                daVar.b(((Integer) obj).intValue());
                return;
            case 14:
                daVar.d(((Integer) obj).intValue());
                return;
            case 15:
                daVar.c(((Long) obj).longValue());
                return;
            case 16:
                daVar.c(((Integer) obj).intValue());
                return;
            case 17:
                daVar.b(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof ds) {
                    daVar.a(((ds) obj).zzdp());
                    return;
                } else {
                    daVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<FieldDescriptorType, Object> entry) {
        dk dkVar = (dk) entry.getKey();
        Object value = entry.getValue();
        if (dkVar.c() != gx.MESSAGE || dkVar.d() || dkVar.e()) {
            return a((dk<?>) dkVar, value);
        }
        if (value instanceof ed) {
            return da.b(((dk) entry.getKey()).a(), (eh) (ed) value);
        }
        return da.b(((dk) entry.getKey()).a(), (ex) value);
    }

    static int a(gu guVar, int i2, Object obj) {
        int l = da.l(i2);
        if (guVar == gu.GROUP) {
            dt.a();
            l <<= 1;
        }
        return l + b(guVar, obj);
    }

    private static int b(gu guVar, Object obj) {
        switch (dl.f9561b[guVar.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return da.f();
            case 2:
                ((Float) obj).floatValue();
                return da.e();
            case 3:
                return da.d(((Long) obj).longValue());
            case 4:
                return da.e(((Long) obj).longValue());
            case 5:
                return da.m(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return da.c();
            case 7:
                ((Integer) obj).intValue();
                return da.a();
            case 8:
                ((Boolean) obj).booleanValue();
                return da.g();
            case 9:
                return da.c((ex) obj);
            case 10:
                if (obj instanceof ed) {
                    return da.a((eh) (ed) obj);
                }
                return da.b((ex) obj);
            case 11:
                if (obj instanceof co) {
                    return da.b((co) obj);
                }
                return da.b((String) obj);
            case 12:
                if (obj instanceof co) {
                    return da.b((co) obj);
                }
                return da.b((byte[]) obj);
            case 13:
                return da.n(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return da.b();
            case 15:
                ((Long) obj).longValue();
                return da.d();
            case 16:
                return da.o(((Integer) obj).intValue());
            case 17:
                return da.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof ds) {
                    return da.p(((ds) obj).zzdp());
                }
                return da.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(dk<?> dkVar, Object obj) {
        gu b2 = dkVar.b();
        int a2 = dkVar.a();
        if (!dkVar.d()) {
            return a(b2, a2, obj);
        }
        int i2 = 0;
        if (dkVar.e()) {
            for (Object b3 : (List) obj) {
                i2 += b(b2, b3);
            }
            return da.l(a2) + i2 + da.r(i2);
        }
        for (Object a3 : (List) obj) {
            i2 += a(b2, a2, a3);
        }
        return i2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        di diVar = new di();
        for (int i2 = 0; i2 < this.f9555a.b(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f9555a.b(i2);
            diVar.b((dk) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f9555a.c()) {
            diVar.b((dk) next.getKey(), next.getValue());
        }
        diVar.f9557c = this.f9557c;
        return diVar;
    }
}
