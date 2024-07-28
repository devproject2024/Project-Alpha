package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.az;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class aw<FieldDescriptorType extends az<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    private static final aw f9168d = new aw((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final dh<FieldDescriptorType, Object> f9169a = dh.a(16);

    /* renamed from: b  reason: collision with root package name */
    boolean f9170b;

    /* renamed from: c  reason: collision with root package name */
    boolean f9171c = false;

    private aw() {
    }

    private aw(byte b2) {
        b();
    }

    static int a(az<?> azVar, Object obj) {
        return a(azVar.b(), azVar.a(), obj);
    }

    public static <T extends az<T>> aw<T> a() {
        return f9168d;
    }

    private static Object a(Object obj) {
        if (obj instanceof ct) {
            return ((ct) obj).a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static void a(am amVar, ej ejVar, int i2, Object obj) throws IOException {
        if (ejVar == ej.GROUP) {
            bh.a();
            amVar.a(i2, 3);
            ((cm) obj).a(amVar);
            amVar.a(i2, 4);
            return;
        }
        amVar.a(i2, ejVar.zzel());
        switch (ax.f9173b[ejVar.ordinal()]) {
            case 1:
                amVar.a(((Double) obj).doubleValue());
                return;
            case 2:
                amVar.a(((Float) obj).floatValue());
                return;
            case 3:
                amVar.a(((Long) obj).longValue());
                return;
            case 4:
                amVar.a(((Long) obj).longValue());
                return;
            case 5:
                amVar.a(((Integer) obj).intValue());
                return;
            case 6:
                amVar.c(((Long) obj).longValue());
                return;
            case 7:
                amVar.d(((Integer) obj).intValue());
                return;
            case 8:
                amVar.a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((cm) obj).a(amVar);
                return;
            case 10:
                amVar.a((cm) obj);
                return;
            case 11:
                if (obj instanceof ab) {
                    amVar.a((ab) obj);
                    return;
                } else {
                    amVar.a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ab) {
                    amVar.a((ab) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                amVar.a(bArr, bArr.length);
                return;
            case 13:
                amVar.b(((Integer) obj).intValue());
                return;
            case 14:
                amVar.d(((Integer) obj).intValue());
                return;
            case 15:
                amVar.c(((Long) obj).longValue());
                return;
            case 16:
                amVar.c(((Integer) obj).intValue());
                return;
            case 17:
                amVar.b(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof bi) {
                    amVar.a(((bi) obj).zzc());
                    return;
                } else {
                    amVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<FieldDescriptorType, Object> entry) {
        az azVar = (az) entry.getKey();
        Object value = entry.getValue();
        if (azVar.c() != eo.MESSAGE) {
            return a(azVar, value);
        }
        boolean z = value instanceof bq;
        int a2 = ((az) entry.getKey()).a();
        return z ? am.b(a2, (bt) (bq) value) : am.d(a2, (cm) value);
    }

    private static boolean c(Map.Entry<FieldDescriptorType, Object> entry) {
        if (((az) entry.getKey()).c() == eo.MESSAGE) {
            Object value = entry.getValue();
            if (value instanceof cm) {
                if (!((cm) value).d()) {
                    return false;
                }
            } else if (value instanceof bq) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public final void b() {
        if (!this.f9170b) {
            this.f9169a.a();
            this.f9170b = true;
        }
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> c() {
        return this.f9171c ? new bs(this.f9169a.entrySet().iterator()) : this.f9169a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        aw awVar = new aw();
        for (int i2 = 0; i2 < this.f9169a.b(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f9169a.b(i2);
            awVar.b((az) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f9169a.c()) {
            awVar.b((az) next.getKey(), next.getValue());
        }
        awVar.f9171c = this.f9171c;
        return awVar;
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f9169a.b(); i2++) {
            if (!c(this.f9169a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> c2 : this.f9169a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aw)) {
            return false;
        }
        return this.f9169a.equals(((aw) obj).f9169a);
    }

    public final int hashCode() {
        return this.f9169a.hashCode();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if ((r5 instanceof byte[]) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.bq) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.bi) == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(FieldDescriptorType r4, java.lang.Object r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.clearcut.ej r0 = r4.b()
            com.google.android.gms.internal.clearcut.bh.a(r5)
            int[] r1 = com.google.android.gms.internal.clearcut.ax.f9172a
            com.google.android.gms.internal.clearcut.eo r0 = r0.zzek()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x0044;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                case 4: goto L_0x003b;
                case 5: goto L_0x0038;
                case 6: goto L_0x0035;
                case 7: goto L_0x002c;
                case 8: goto L_0x0022;
                case 9: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0047
        L_0x0019:
            boolean r0 = r5 instanceof com.google.android.gms.internal.clearcut.cm
            if (r0 != 0) goto L_0x002a
            boolean r0 = r5 instanceof com.google.android.gms.internal.clearcut.bq
            if (r0 == 0) goto L_0x0047
            goto L_0x002a
        L_0x0022:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x002a
            boolean r0 = r5 instanceof com.google.android.gms.internal.clearcut.bi
            if (r0 == 0) goto L_0x0047
        L_0x002a:
            r2 = 1
            goto L_0x0047
        L_0x002c:
            boolean r0 = r5 instanceof com.google.android.gms.internal.clearcut.ab
            if (r0 != 0) goto L_0x002a
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L_0x0047
            goto L_0x002a
        L_0x0035:
            boolean r0 = r5 instanceof java.lang.String
            goto L_0x0046
        L_0x0038:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L_0x0046
        L_0x003b:
            boolean r0 = r5 instanceof java.lang.Double
            goto L_0x0046
        L_0x003e:
            boolean r0 = r5 instanceof java.lang.Float
            goto L_0x0046
        L_0x0041:
            boolean r0 = r5 instanceof java.lang.Long
            goto L_0x0046
        L_0x0044:
            boolean r0 = r5 instanceof java.lang.Integer
        L_0x0046:
            r2 = r0
        L_0x0047:
            if (r2 == 0) goto L_0x0055
            boolean r0 = r5 instanceof com.google.android.gms.internal.clearcut.bq
            if (r0 == 0) goto L_0x004f
            r3.f9171c = r1
        L_0x004f:
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r0 = r3.f9169a
            r0.put(r4, r5)
            return
        L_0x0055:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Wrong object type used with protocol message reflection."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.aw.b(com.google.android.gms.internal.clearcut.az, java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        dh<FieldDescriptorType, Object> dhVar;
        az azVar = (az) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof bq) {
            value = bq.a();
        }
        if (azVar.c() == eo.MESSAGE) {
            Object obj2 = this.f9169a.get(azVar);
            if (obj2 instanceof bq) {
                obj2 = bq.a();
            }
            if (obj2 != null) {
                obj = obj2 instanceof ct ? azVar.d() : azVar.a(((cm) obj2).f(), (cm) value).g();
                dhVar = this.f9169a;
                dhVar.put(azVar, obj);
            }
        }
        dhVar = this.f9169a;
        obj = a(value);
        dhVar.put(azVar, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
        r2 = com.google.android.gms.internal.clearcut.am.b((com.google.android.gms.internal.clearcut.ab) r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(com.google.android.gms.internal.clearcut.ej r2, int r3, java.lang.Object r4) {
        /*
            int r3 = com.google.android.gms.internal.clearcut.am.l(r3)
            com.google.android.gms.internal.clearcut.ej r0 = com.google.android.gms.internal.clearcut.ej.GROUP
            if (r2 != r0) goto L_0x000d
            com.google.android.gms.internal.clearcut.bh.a()
            int r3 = r3 << 1
        L_0x000d:
            int[] r0 = com.google.android.gms.internal.clearcut.ax.f9173b
            int r2 = r2.ordinal()
            r2 = r0[r2]
            switch(r2) {
                case 1: goto L_0x00f4;
                case 2: goto L_0x00ea;
                case 3: goto L_0x00df;
                case 4: goto L_0x00d4;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00bf;
                case 7: goto L_0x00b5;
                case 8: goto L_0x00ab;
                case 9: goto L_0x00a4;
                case 10: goto L_0x0092;
                case 11: goto L_0x007e;
                case 12: goto L_0x0071;
                case 13: goto L_0x0065;
                case 14: goto L_0x005a;
                case 15: goto L_0x004f;
                case 16: goto L_0x0043;
                case 17: goto L_0x0037;
                case 18: goto L_0x0020;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "There is no way to get here, but the compiler thinks otherwise."
            r2.<init>(r3)
            throw r2
        L_0x0020:
            boolean r2 = r4 instanceof com.google.android.gms.internal.clearcut.bi
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.clearcut.bi r4 = (com.google.android.gms.internal.clearcut.bi) r4
            int r2 = r4.zzc()
            goto L_0x0031
        L_0x002b:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
        L_0x0031:
            int r2 = com.google.android.gms.internal.clearcut.am.p(r2)
            goto L_0x00fd
        L_0x0037:
            java.lang.Long r4 = (java.lang.Long) r4
            long r0 = r4.longValue()
            int r2 = com.google.android.gms.internal.clearcut.am.f((long) r0)
            goto L_0x00fd
        L_0x0043:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
            int r2 = com.google.android.gms.internal.clearcut.am.o(r2)
            goto L_0x00fd
        L_0x004f:
            java.lang.Long r4 = (java.lang.Long) r4
            r4.longValue()
            int r2 = com.google.android.gms.internal.clearcut.am.d()
            goto L_0x00fd
        L_0x005a:
            java.lang.Integer r4 = (java.lang.Integer) r4
            r4.intValue()
            int r2 = com.google.android.gms.internal.clearcut.am.b()
            goto L_0x00fd
        L_0x0065:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
            int r2 = com.google.android.gms.internal.clearcut.am.n(r2)
            goto L_0x00fd
        L_0x0071:
            boolean r2 = r4 instanceof com.google.android.gms.internal.clearcut.ab
            if (r2 == 0) goto L_0x0076
            goto L_0x0082
        L_0x0076:
            byte[] r4 = (byte[]) r4
            int r2 = com.google.android.gms.internal.clearcut.am.b((byte[]) r4)
            goto L_0x00fd
        L_0x007e:
            boolean r2 = r4 instanceof com.google.android.gms.internal.clearcut.ab
            if (r2 == 0) goto L_0x008a
        L_0x0082:
            com.google.android.gms.internal.clearcut.ab r4 = (com.google.android.gms.internal.clearcut.ab) r4
            int r2 = com.google.android.gms.internal.clearcut.am.b((com.google.android.gms.internal.clearcut.ab) r4)
            goto L_0x00fd
        L_0x008a:
            java.lang.String r4 = (java.lang.String) r4
            int r2 = com.google.android.gms.internal.clearcut.am.b((java.lang.String) r4)
            goto L_0x00fd
        L_0x0092:
            boolean r2 = r4 instanceof com.google.android.gms.internal.clearcut.bq
            if (r2 == 0) goto L_0x009d
            com.google.android.gms.internal.clearcut.bq r4 = (com.google.android.gms.internal.clearcut.bq) r4
            int r2 = com.google.android.gms.internal.clearcut.am.a((com.google.android.gms.internal.clearcut.bt) r4)
            goto L_0x00fd
        L_0x009d:
            com.google.android.gms.internal.clearcut.cm r4 = (com.google.android.gms.internal.clearcut.cm) r4
            int r2 = com.google.android.gms.internal.clearcut.am.b((com.google.android.gms.internal.clearcut.cm) r4)
            goto L_0x00fd
        L_0x00a4:
            com.google.android.gms.internal.clearcut.cm r4 = (com.google.android.gms.internal.clearcut.cm) r4
            int r2 = com.google.android.gms.internal.clearcut.am.c((com.google.android.gms.internal.clearcut.cm) r4)
            goto L_0x00fd
        L_0x00ab:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            r4.booleanValue()
            int r2 = com.google.android.gms.internal.clearcut.am.g()
            goto L_0x00fd
        L_0x00b5:
            java.lang.Integer r4 = (java.lang.Integer) r4
            r4.intValue()
            int r2 = com.google.android.gms.internal.clearcut.am.a()
            goto L_0x00fd
        L_0x00bf:
            java.lang.Long r4 = (java.lang.Long) r4
            r4.longValue()
            int r2 = com.google.android.gms.internal.clearcut.am.c()
            goto L_0x00fd
        L_0x00c9:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
            int r2 = com.google.android.gms.internal.clearcut.am.m(r2)
            goto L_0x00fd
        L_0x00d4:
            java.lang.Long r4 = (java.lang.Long) r4
            long r0 = r4.longValue()
            int r2 = com.google.android.gms.internal.clearcut.am.e((long) r0)
            goto L_0x00fd
        L_0x00df:
            java.lang.Long r4 = (java.lang.Long) r4
            long r0 = r4.longValue()
            int r2 = com.google.android.gms.internal.clearcut.am.d((long) r0)
            goto L_0x00fd
        L_0x00ea:
            java.lang.Float r4 = (java.lang.Float) r4
            r4.floatValue()
            int r2 = com.google.android.gms.internal.clearcut.am.e()
            goto L_0x00fd
        L_0x00f4:
            java.lang.Double r4 = (java.lang.Double) r4
            r4.doubleValue()
            int r2 = com.google.android.gms.internal.clearcut.am.f()
        L_0x00fd:
            int r3 = r3 + r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.aw.a(com.google.android.gms.internal.clearcut.ej, int, java.lang.Object):int");
    }
}
