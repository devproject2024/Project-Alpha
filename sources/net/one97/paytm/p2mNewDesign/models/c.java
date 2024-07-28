package net.one97.paytm.p2mNewDesign.models;

import kotlin.g.b.k;

public final class c<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f56934d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final d f56935a;

    /* renamed from: b  reason: collision with root package name */
    public final T f56936b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f56937c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a((Object) this.f56935a, (Object) cVar.f56935a) && k.a((Object) this.f56936b, (Object) cVar.f56936b) && k.a((Object) this.f56937c, (Object) cVar.f56937c);
    }

    public final int hashCode() {
        d dVar = this.f56935a;
        int i2 = 0;
        int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
        T t = this.f56936b;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        Throwable th = this.f56937c;
        if (th != null) {
            i2 = th.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Resource(status=" + this.f56935a + ", data=" + this.f56936b + ", error=" + this.f56937c + ")";
    }

    public c(d dVar, T t, Throwable th) {
        k.c(dVar, "status");
        this.f56935a = dVar;
        this.f56936b = t;
        this.f56937c = th;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <T> c<T> a(T t) {
            return new c<>(d.SUCCESS, t, (Throwable) null);
        }
    }
}
