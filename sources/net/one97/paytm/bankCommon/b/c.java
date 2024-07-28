package net.one97.paytm.bankCommon.b;

import kotlin.g.b.k;

public final class c<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f16215d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final d f16216a;

    /* renamed from: b  reason: collision with root package name */
    public final T f16217b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f16218c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a((Object) this.f16216a, (Object) cVar.f16216a) && k.a((Object) this.f16217b, (Object) cVar.f16217b) && k.a((Object) this.f16218c, (Object) cVar.f16218c);
    }

    public final int hashCode() {
        d dVar = this.f16216a;
        int i2 = 0;
        int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
        T t = this.f16217b;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        Throwable th = this.f16218c;
        if (th != null) {
            i2 = th.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Resource(status=" + this.f16216a + ", data=" + this.f16217b + ", error=" + this.f16218c + ")";
    }

    public c(d dVar, T t, Throwable th) {
        k.c(dVar, "status");
        this.f16216a = dVar;
        this.f16217b = t;
        this.f16218c = th;
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

        public static <T> c<T> a(Throwable th) {
            k.c(th, "error");
            return new c<>(d.ERROR, null, th);
        }
    }
}
