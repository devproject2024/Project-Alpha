package net.one97.paytm.passbook.mapping.a;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class f<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f57885d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final j f57886a;

    /* renamed from: b  reason: collision with root package name */
    public final T f57887b;

    /* renamed from: c  reason: collision with root package name */
    public final d<? extends T> f57888c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.a((Object) this.f57886a, (Object) fVar.f57886a) && k.a((Object) this.f57887b, (Object) fVar.f57887b) && k.a((Object) this.f57888c, (Object) fVar.f57888c);
    }

    public final int hashCode() {
        j jVar = this.f57886a;
        int i2 = 0;
        int hashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
        T t = this.f57887b;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        d<? extends T> dVar = this.f57888c;
        if (dVar != null) {
            i2 = dVar.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "NetworkResource(status=" + this.f57886a + ", data=" + this.f57887b + ", error=" + this.f57888c + ")";
    }

    public f(j jVar, T t, d<? extends T> dVar) {
        k.c(jVar, "status");
        this.f57886a = jVar;
        this.f57887b = t;
        this.f57888c = dVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <T> f<T> a(T t) {
            return new f<>(j.SUCCESS, t, (d) null);
        }

        public static <T> f<T> a(int i2, T t, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkCustomError");
            return new f<>(j.ERROR, null, new d(i2, t, networkCustomError));
        }
    }
}
