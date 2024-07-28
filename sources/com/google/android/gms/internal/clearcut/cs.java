package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class cs<T> implements de<T> {

    /* renamed from: a  reason: collision with root package name */
    private final cm f9256a;

    /* renamed from: b  reason: collision with root package name */
    private final dv<?, ?> f9257b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9258c;

    /* renamed from: d  reason: collision with root package name */
    private final as<?> f9259d;

    private cs(dv<?, ?> dvVar, as<?> asVar, cm cmVar) {
        this.f9257b = dvVar;
        this.f9258c = asVar.a(cmVar);
        this.f9259d = asVar;
        this.f9256a = cmVar;
    }

    static <T> cs<T> a(dv<?, ?> dvVar, as<?> asVar, cm cmVar) {
        return new cs<>(dvVar, asVar, cmVar);
    }

    public final int a(T t) {
        int hashCode = this.f9257b.a(t).hashCode();
        return this.f9258c ? (hashCode * 53) + this.f9259d.a((Object) t).hashCode() : hashCode;
    }

    public final T a() {
        return this.f9256a.g().f();
    }

    public final void a(T t, byte[] bArr, int i2, int i3, x xVar) throws IOException {
        bf bfVar = (bf) t;
        dw dwVar = bfVar.zzjp;
        if (dwVar == dw.a()) {
            dwVar = dw.b();
            bfVar.zzjp = dwVar;
        }
        dw dwVar2 = dwVar;
        while (i2 < i3) {
            int a2 = w.a(bArr, i2, xVar);
            int i4 = xVar.f9432a;
            if (i4 != 11) {
                i2 = (i4 & 7) == 2 ? w.a(i4, bArr, a2, i3, dwVar2, xVar) : w.a(i4, bArr, a2, i3, xVar);
            } else {
                int i5 = 0;
                ab abVar = null;
                while (a2 < i3) {
                    a2 = w.a(bArr, a2, xVar);
                    int i6 = xVar.f9432a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3 && i8 == 2) {
                            a2 = w.e(bArr, a2, xVar);
                            abVar = (ab) xVar.f9434c;
                        }
                    } else if (i8 == 0) {
                        a2 = w.a(bArr, a2, xVar);
                        i5 = xVar.f9432a;
                    }
                    if (i6 == 12) {
                        break;
                    }
                    a2 = w.a(i6, bArr, a2, i3, xVar);
                }
                if (abVar != null) {
                    dwVar2.a((i5 << 3) | 2, (Object) abVar);
                }
                i2 = a2;
            }
        }
        if (i2 != i3) {
            throw bn.zzbo();
        }
    }

    public final boolean a(T t, T t2) {
        if (!this.f9257b.a(t).equals(this.f9257b.a(t2))) {
            return false;
        }
        if (this.f9258c) {
            return this.f9259d.a((Object) t).equals(this.f9259d.a((Object) t2));
        }
        return true;
    }

    public final void b(T t, T t2) {
        dg.a(this.f9257b, t, t2);
        if (this.f9258c) {
            dg.a(this.f9259d, t, t2);
        }
    }

    public final void c(T t) {
        this.f9257b.b(t);
        this.f9259d.c(t);
    }

    public final boolean d(T t) {
        return this.f9259d.a((Object) t).d();
    }

    public final void a(T t, ep epVar) throws IOException {
        int i2;
        Object obj;
        Iterator<Map.Entry<?, Object>> c2 = this.f9259d.a((Object) t).c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            az azVar = (az) next.getKey();
            if (azVar.c() == eo.MESSAGE) {
                if (next instanceof br) {
                    i2 = azVar.a();
                    obj = ((br) next).f9213a.getValue().c();
                } else {
                    i2 = azVar.a();
                    obj = next.getValue();
                }
                epVar.a(i2, obj);
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        dv<?, ?> dvVar = this.f9257b;
        dvVar.b(dvVar.a(t), epVar);
    }

    public final int b(T t) {
        dv<?, ?> dvVar = this.f9257b;
        int c2 = dvVar.c(dvVar.a(t)) + 0;
        if (!this.f9258c) {
            return c2;
        }
        aw<?> a2 = this.f9259d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f9169a.b(); i3++) {
            i2 += aw.b(a2.f9169a.b(i3));
        }
        for (Map.Entry<FieldDescriptorType, Object> b2 : a2.f9169a.c()) {
            i2 += aw.b(b2);
        }
        return c2 + i2;
    }
}
