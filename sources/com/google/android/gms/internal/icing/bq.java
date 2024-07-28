package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class bq<FieldDescriptorType extends bs<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    private static final bq f10099d = new bq((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final dw<FieldDescriptorType, Object> f10100a = dw.a(16);

    /* renamed from: b  reason: collision with root package name */
    boolean f10101b;

    /* renamed from: c  reason: collision with root package name */
    boolean f10102c = false;

    private bq() {
    }

    private bq(byte b2) {
        b();
    }

    public static <T extends bs<T>> bq<T> a() {
        return f10099d;
    }

    public final void b() {
        if (!this.f10101b) {
            this.f10100a.a();
            this.f10101b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bq)) {
            return false;
        }
        return this.f10100a.equals(((bq) obj).f10100a);
    }

    public final int hashCode() {
        return this.f10100a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> c() {
        if (this.f10102c) {
            return new cj(this.f10100a.entrySet().iterator());
        }
        return this.f10100a.entrySet().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f10100a.get(fielddescriptortype);
        return obj instanceof ci ? ci.a() : obj;
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
        if (obj instanceof ci) {
            this.f10102c = true;
        }
        this.f10100a.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.icing.ci) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.icing.cc) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.gms.internal.icing.ew r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.icing.bx.a(r3)
            int[] r0 = com.google.android.gms.internal.icing.bp.f10097a
            com.google.android.gms.internal.icing.fd r2 = r2.zzdu()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.dd
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.ci
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.cc
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.at
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.bq.a(com.google.android.gms.internal.icing.ew, java.lang.Object):void");
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f10100a.b(); i2++) {
            if (!c(this.f10100a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> c2 : this.f10100a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(Map.Entry<FieldDescriptorType, Object> entry) {
        bs bsVar = (bs) entry.getKey();
        if (bsVar.c() == fd.MESSAGE) {
            if (bsVar.d()) {
                for (dd c2 : (List) entry.getValue()) {
                    if (!c2.c()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof dd) {
                    if (!((dd) value).c()) {
                        return false;
                    }
                } else if (value instanceof ci) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (obj instanceof dk) {
            return ((dk) obj).b();
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
        bs bsVar = (bs) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ci) {
            value = ci.a();
        }
        if (bsVar.d()) {
            Object a2 = a(bsVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f10100a.put(bsVar, a2);
        } else if (bsVar.c() == fd.MESSAGE) {
            Object a4 = a(bsVar);
            if (a4 == null) {
                this.f10100a.put(bsVar, a(value));
                return;
            }
            if (a4 instanceof dk) {
                obj = bsVar.g();
            } else {
                ((dd) a4).e();
                obj = bsVar.f().d();
            }
            this.f10100a.put(bsVar, obj);
        } else {
            this.f10100a.put(bsVar, a(value));
        }
    }

    static void a(bf bfVar, ew ewVar, int i2, Object obj) throws IOException {
        if (ewVar == ew.GROUP) {
            bx.a();
            bfVar.a(i2, 3);
            ((dd) obj).a(bfVar);
            bfVar.a(i2, 4);
            return;
        }
        bfVar.a(i2, ewVar.zzdv());
        switch (ewVar) {
            case DOUBLE:
                bfVar.a(((Double) obj).doubleValue());
                return;
            case FLOAT:
                bfVar.a(((Float) obj).floatValue());
                return;
            case INT64:
                bfVar.a(((Long) obj).longValue());
                return;
            case UINT64:
                bfVar.a(((Long) obj).longValue());
                return;
            case INT32:
                bfVar.a(((Integer) obj).intValue());
                return;
            case FIXED64:
                bfVar.c(((Long) obj).longValue());
                return;
            case FIXED32:
                bfVar.d(((Integer) obj).intValue());
                return;
            case BOOL:
                bfVar.a(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((dd) obj).a(bfVar);
                return;
            case MESSAGE:
                bfVar.a((dd) obj);
                return;
            case STRING:
                if (obj instanceof at) {
                    bfVar.a((at) obj);
                    return;
                } else {
                    bfVar.a((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof at) {
                    bfVar.a((at) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                bfVar.a(bArr, bArr.length);
                return;
            case UINT32:
                bfVar.b(((Integer) obj).intValue());
                return;
            case SFIXED32:
                bfVar.d(((Integer) obj).intValue());
                return;
            case SFIXED64:
                bfVar.c(((Long) obj).longValue());
                return;
            case SINT32:
                bfVar.c(((Integer) obj).intValue());
                return;
            case SINT64:
                bfVar.b(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof cc) {
                    bfVar.a(((cc) obj).a());
                    return;
                } else {
                    bfVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<FieldDescriptorType, Object> entry) {
        bs bsVar = (bs) entry.getKey();
        Object value = entry.getValue();
        if (bsVar.c() != fd.MESSAGE || bsVar.d() || bsVar.e()) {
            return a((bs<?>) bsVar, value);
        }
        if (value instanceof ci) {
            return bf.b(((bs) entry.getKey()).a(), (cm) (ci) value);
        }
        return bf.b(((bs) entry.getKey()).a(), (dd) value);
    }

    static int a(ew ewVar, int i2, Object obj) {
        int l = bf.l(i2);
        if (ewVar == ew.GROUP) {
            bx.a();
            l <<= 1;
        }
        return l + b(ewVar, obj);
    }

    private static int b(ew ewVar, Object obj) {
        switch (ewVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return bf.f();
            case FLOAT:
                ((Float) obj).floatValue();
                return bf.e();
            case INT64:
                return bf.d(((Long) obj).longValue());
            case UINT64:
                return bf.e(((Long) obj).longValue());
            case INT32:
                return bf.m(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                return bf.c();
            case FIXED32:
                ((Integer) obj).intValue();
                return bf.a();
            case BOOL:
                ((Boolean) obj).booleanValue();
                return bf.g();
            case GROUP:
                return bf.c((dd) obj);
            case MESSAGE:
                if (obj instanceof ci) {
                    return bf.a((cm) (ci) obj);
                }
                return bf.b((dd) obj);
            case STRING:
                if (obj instanceof at) {
                    return bf.b((at) obj);
                }
                return bf.b((String) obj);
            case BYTES:
                if (obj instanceof at) {
                    return bf.b((at) obj);
                }
                return bf.b((byte[]) obj);
            case UINT32:
                return bf.n(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                return bf.b();
            case SFIXED64:
                ((Long) obj).longValue();
                return bf.d();
            case SINT32:
                return bf.o(((Integer) obj).intValue());
            case SINT64:
                return bf.f(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof cc) {
                    return bf.p(((cc) obj).a());
                }
                return bf.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(bs<?> bsVar, Object obj) {
        ew b2 = bsVar.b();
        int a2 = bsVar.a();
        if (!bsVar.d()) {
            return a(b2, a2, obj);
        }
        int i2 = 0;
        if (bsVar.e()) {
            for (Object b3 : (List) obj) {
                i2 += b(b2, b3);
            }
            return bf.l(a2) + i2 + bf.q(i2);
        }
        for (Object a3 : (List) obj) {
            i2 += a(b2, a2, a3);
        }
        return i2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        bq bqVar = new bq();
        for (int i2 = 0; i2 < this.f10100a.b(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f10100a.b(i2);
            bqVar.b((bs) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f10100a.c()) {
            bqVar.b((bs) next.getKey(), next.getValue());
        }
        bqVar.f10102c = this.f10102c;
        return bqVar;
    }
}
