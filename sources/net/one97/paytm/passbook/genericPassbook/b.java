package net.one97.paytm.passbook.genericPassbook;

import kotlin.g.b.k;

public final class b<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f57330d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final c f57331a;

    /* renamed from: b  reason: collision with root package name */
    public final T f57332b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f57333c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f57331a, (Object) bVar.f57331a) && k.a((Object) this.f57332b, (Object) bVar.f57332b) && k.a((Object) this.f57333c, (Object) bVar.f57333c);
    }

    public final int hashCode() {
        c cVar = this.f57331a;
        int i2 = 0;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        T t = this.f57332b;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        Throwable th = this.f57333c;
        if (th != null) {
            i2 = th.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Resource(status=" + this.f57331a + ", data=" + this.f57332b + ", error=" + this.f57333c + ")";
    }

    public b(c cVar, T t, Throwable th) {
        k.c(cVar, "status");
        this.f57331a = cVar;
        this.f57332b = t;
        this.f57333c = th;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
