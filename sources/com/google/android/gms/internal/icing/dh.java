package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class dh<T> implements dr<T> {

    /* renamed from: a  reason: collision with root package name */
    private final dd f10153a;

    /* renamed from: b  reason: collision with root package name */
    private final ei<?, ?> f10154b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10155c;

    /* renamed from: d  reason: collision with root package name */
    private final bl<?> f10156d;

    private dh(ei<?, ?> eiVar, bl<?> blVar, dd ddVar) {
        this.f10154b = eiVar;
        this.f10155c = blVar.a(ddVar);
        this.f10156d = blVar;
        this.f10153a = ddVar;
    }

    static <T> dh<T> a(ei<?, ?> eiVar, bl<?> blVar, dd ddVar) {
        return new dh<>(eiVar, blVar, ddVar);
    }

    public final boolean a(T t, T t2) {
        if (!this.f10154b.a(t).equals(this.f10154b.a(t2))) {
            return false;
        }
        if (this.f10155c) {
            return this.f10156d.a((Object) t).equals(this.f10156d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f10154b.a(t).hashCode();
        return this.f10155c ? (hashCode * 53) + this.f10156d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        dt.a(this.f10154b, t, t2);
        if (this.f10155c) {
            dt.a(this.f10156d, t, t2);
        }
    }

    public final void a(T t, fc fcVar) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.f10156d.a((Object) t).c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            bs bsVar = (bs) next.getKey();
            if (bsVar.c() != fd.MESSAGE || bsVar.d() || bsVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof ck) {
                fcVar.a(bsVar.a(), (Object) ((ck) next).f10128a.getValue().c());
            } else {
                fcVar.a(bsVar.a(), next.getValue());
            }
        }
        ei<?, ?> eiVar = this.f10154b;
        eiVar.b(eiVar.a(t), fcVar);
    }

    public final void b(T t) {
        this.f10154b.b(t);
        this.f10156d.c(t);
    }

    public final boolean c(T t) {
        return this.f10156d.a((Object) t).d();
    }

    public final int d(T t) {
        ei<?, ?> eiVar = this.f10154b;
        int c2 = eiVar.c(eiVar.a(t)) + 0;
        if (!this.f10155c) {
            return c2;
        }
        bq<?> a2 = this.f10156d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f10100a.b(); i3++) {
            i2 += bq.b(a2.f10100a.b(i3));
        }
        for (Map.Entry<FieldDescriptorType, Object> b2 : a2.f10100a.c()) {
            i2 += bq.b(b2);
        }
        return c2 + i2;
    }
}
