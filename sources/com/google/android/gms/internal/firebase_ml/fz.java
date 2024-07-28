package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class fz<T extends gb<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final fz f9907d = new fz((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final il<T, Object> f9908a;

    /* renamed from: b  reason: collision with root package name */
    boolean f9909b;

    /* renamed from: c  reason: collision with root package name */
    boolean f9910c;

    private fz() {
        this.f9908a = il.a(16);
    }

    private fz(byte b2) {
        this(il.a(0));
        b();
    }

    private fz(il<T, Object> ilVar) {
        this.f9908a = ilVar;
        b();
    }

    public static <T extends gb<T>> fz<T> a() {
        return f9907d;
    }

    public final void b() {
        if (!this.f9909b) {
            this.f9908a.a();
            this.f9909b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fz)) {
            return false;
        }
        return this.f9908a.equals(((fz) obj).f9908a);
    }

    public final int hashCode() {
        return this.f9908a.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> c() {
        if (this.f9910c) {
            return new gu(this.f9908a.entrySet().iterator());
        }
        return this.f9908a.entrySet().iterator();
    }

    private final Object a(T t) {
        Object obj = this.f9908a.get(t);
        return obj instanceof gt ? gt.a() : obj;
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
        if (obj instanceof gt) {
            this.f9910c = true;
        }
        this.f9908a.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_ml.gj) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_ml.gt) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.gms.internal.firebase_ml.n r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase_ml.gk.a(r3)
            int[] r0 = com.google.android.gms.internal.firebase_ml.gc.f9914a
            com.google.android.gms.internal.firebase_ml.q r2 = r2.zzxi()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.hn
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.gt
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.gj
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.fh
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.fz.a(com.google.android.gms.internal.firebase_ml.n, java.lang.Object):void");
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f9908a.b(); i2++) {
            if (!c(this.f9908a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> c2 : this.f9908a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends gb<T>> boolean c(Map.Entry<T, Object> entry) {
        gb gbVar = (gb) entry.getKey();
        if (gbVar.c() == q.MESSAGE) {
            if (gbVar.d()) {
                for (hn h2 : (List) entry.getValue()) {
                    if (!h2.h()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof hn) {
                    if (!((hn) value).h()) {
                        return false;
                    }
                } else if (value instanceof gt) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (obj instanceof hv) {
            return ((hv) obj).a();
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
        gb gbVar = (gb) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof gt) {
            value = gt.a();
        }
        if (gbVar.d()) {
            Object a2 = a(gbVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f9908a.put(gbVar, a2);
        } else if (gbVar.c() == q.MESSAGE) {
            Object a4 = a(gbVar);
            if (a4 == null) {
                this.f9908a.put(gbVar, a(value));
                return;
            }
            if (a4 instanceof hv) {
                obj = gbVar.g();
            } else {
                ((hn) a4).j();
                obj = gbVar.f().i();
            }
            this.f9908a.put(gbVar, obj);
        } else {
            this.f9908a.put(gbVar, a(value));
        }
    }

    static void a(ft ftVar, n nVar, int i2, Object obj) throws IOException {
        if (nVar == n.GROUP) {
            gk.a();
            ftVar.a(i2, 3);
            ((hn) obj).a(ftVar);
            ftVar.a(i2, 4);
            return;
        }
        ftVar.a(i2, nVar.zzxj());
        switch (nVar) {
            case DOUBLE:
                ftVar.a(((Double) obj).doubleValue());
                return;
            case FLOAT:
                ftVar.a(((Float) obj).floatValue());
                return;
            case INT64:
                ftVar.a(((Long) obj).longValue());
                return;
            case UINT64:
                ftVar.a(((Long) obj).longValue());
                return;
            case INT32:
                ftVar.a(((Integer) obj).intValue());
                return;
            case FIXED64:
                ftVar.c(((Long) obj).longValue());
                return;
            case FIXED32:
                ftVar.d(((Integer) obj).intValue());
                return;
            case BOOL:
                ftVar.a(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((hn) obj).a(ftVar);
                return;
            case MESSAGE:
                ftVar.a((hn) obj);
                return;
            case STRING:
                if (obj instanceof fh) {
                    ftVar.a((fh) obj);
                    return;
                } else {
                    ftVar.a((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof fh) {
                    ftVar.a((fh) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                ftVar.a(bArr, bArr.length);
                return;
            case UINT32:
                ftVar.b(((Integer) obj).intValue());
                return;
            case SFIXED32:
                ftVar.d(((Integer) obj).intValue());
                return;
            case SFIXED64:
                ftVar.c(((Long) obj).longValue());
                return;
            case SINT32:
                ftVar.c(((Integer) obj).intValue());
                return;
            case SINT64:
                ftVar.b(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof gj) {
                    ftVar.a(((gj) obj).zzd());
                    return;
                } else {
                    ftVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<T, Object> entry) {
        gb gbVar = (gb) entry.getKey();
        Object value = entry.getValue();
        if (gbVar.c() != q.MESSAGE || gbVar.d() || gbVar.e()) {
            return a((gb<?>) gbVar, value);
        }
        if (value instanceof gt) {
            return ft.b(((gb) entry.getKey()).a(), (gx) (gt) value);
        }
        return ft.b(((gb) entry.getKey()).a(), (hn) value);
    }

    static int a(n nVar, int i2, Object obj) {
        int l = ft.l(i2);
        if (nVar == n.GROUP) {
            gk.a();
            l <<= 1;
        }
        return l + b(nVar, obj);
    }

    private static int b(n nVar, Object obj) {
        switch (nVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return ft.f();
            case FLOAT:
                ((Float) obj).floatValue();
                return ft.e();
            case INT64:
                return ft.d(((Long) obj).longValue());
            case UINT64:
                return ft.e(((Long) obj).longValue());
            case INT32:
                return ft.m(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                return ft.c();
            case FIXED32:
                ((Integer) obj).intValue();
                return ft.a();
            case BOOL:
                ((Boolean) obj).booleanValue();
                return ft.g();
            case GROUP:
                return ft.c((hn) obj);
            case MESSAGE:
                if (obj instanceof gt) {
                    return ft.a((gx) (gt) obj);
                }
                return ft.b((hn) obj);
            case STRING:
                if (obj instanceof fh) {
                    return ft.b((fh) obj);
                }
                return ft.b((String) obj);
            case BYTES:
                if (obj instanceof fh) {
                    return ft.b((fh) obj);
                }
                return ft.b((byte[]) obj);
            case UINT32:
                return ft.n(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                return ft.b();
            case SFIXED64:
                ((Long) obj).longValue();
                return ft.d();
            case SINT32:
                return ft.o(((Integer) obj).intValue());
            case SINT64:
                return ft.f(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof gj) {
                    return ft.p(((gj) obj).zzd());
                }
                return ft.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(gb<?> gbVar, Object obj) {
        n b2 = gbVar.b();
        int a2 = gbVar.a();
        if (!gbVar.d()) {
            return a(b2, a2, obj);
        }
        int i2 = 0;
        if (gbVar.e()) {
            for (Object b3 : (List) obj) {
                i2 += b(b2, b3);
            }
            return ft.l(a2) + i2 + ft.r(i2);
        }
        for (Object a3 : (List) obj) {
            i2 += a(b2, a2, a3);
        }
        return i2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        fz fzVar = new fz();
        for (int i2 = 0; i2 < this.f9908a.b(); i2++) {
            Map.Entry<T, Object> b2 = this.f9908a.b(i2);
            fzVar.b((gb) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f9908a.c()) {
            fzVar.b((gb) next.getKey(), next.getValue());
        }
        fzVar.f9910c = this.f9910c;
        return fzVar;
    }
}
