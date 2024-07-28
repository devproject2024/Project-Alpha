package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.j;
import com.google.gsonhtcfix.d.c;
import java.io.IOException;

final class x<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    private final u<T> f39826a;

    /* renamed from: b  reason: collision with root package name */
    private final k<T> f39827b;

    /* renamed from: c  reason: collision with root package name */
    private final f f39828c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gsonhtcfix.c.a<T> f39829d;

    /* renamed from: e  reason: collision with root package name */
    private final z f39830e;

    /* renamed from: f  reason: collision with root package name */
    private y<T> f39831f;

    /* synthetic */ x(u uVar, k kVar, f fVar, com.google.gsonhtcfix.c.a aVar, z zVar, byte b2) {
        this(uVar, kVar, fVar, aVar, zVar);
    }

    private x(u<T> uVar, k<T> kVar, f fVar, com.google.gsonhtcfix.c.a<T> aVar, z zVar) {
        this.f39826a = uVar;
        this.f39827b = kVar;
        this.f39828c = fVar;
        this.f39829d = aVar;
        this.f39830e = zVar;
    }

    public final T a(com.google.gsonhtcfix.d.a aVar) throws IOException {
        if (this.f39827b == null) {
            return a().a(aVar);
        }
        l a2 = j.a(aVar);
        if (a2 instanceof n) {
            return null;
        }
        return this.f39827b.a(a2, this.f39829d.getType());
    }

    public final void a(c cVar, T t) throws IOException {
        u<T> uVar = this.f39826a;
        if (uVar == null) {
            a().a(cVar, t);
        } else if (t == null) {
            cVar.e();
        } else {
            this.f39829d.getType();
            j.a(uVar.a(t), cVar);
        }
    }

    private y<T> a() {
        y<T> yVar = this.f39831f;
        if (yVar != null) {
            return yVar;
        }
        y<T> a2 = this.f39828c.a(this.f39830e, this.f39829d);
        this.f39831f = a2;
        return a2;
    }

    public static z a(com.google.gsonhtcfix.c.a<?> aVar, Object obj) {
        return new a(obj, aVar, (byte) 0);
    }

    static class a implements z {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.gsonhtcfix.c.a<?> f39832a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f39833b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f39834c;

        /* renamed from: d  reason: collision with root package name */
        private final u<?> f39835d;

        /* renamed from: e  reason: collision with root package name */
        private final k<?> f39836e;

        /* synthetic */ a(Object obj, com.google.gsonhtcfix.c.a aVar, byte b2) {
            this(obj, aVar);
        }

        private a(Object obj, com.google.gsonhtcfix.c.a<?> aVar) {
            this.f39835d = obj instanceof u ? (u) obj : null;
            this.f39836e = obj instanceof k ? (k) obj : null;
            com.google.gsonhtcfix.b.a.a((this.f39835d == null && this.f39836e == null) ? false : true);
            this.f39832a = aVar;
            this.f39833b = false;
            this.f39834c = null;
        }

        public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
            com.google.gsonhtcfix.c.a<?> aVar2 = this.f39832a;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f39833b && this.f39832a.getType() == aVar.getRawType()) : this.f39834c.isAssignableFrom(aVar.getRawType())) {
                return new x(this.f39835d, this.f39836e, fVar, aVar, this, (byte) 0);
            }
            return null;
        }
    }
}
