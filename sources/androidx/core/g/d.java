package androidx.core.g;

public final class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f2964a;

    /* renamed from: b  reason: collision with root package name */
    public final S f2965b;

    public d(F f2, S s) {
        this.f2964a = f2;
        this.f2965b = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.f2964a, this.f2964a) || !c.a(dVar.f2965b, this.f2965b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        F f2 = this.f2964a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f2965b;
        if (s != null) {
            i2 = s.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f2964a) + " " + String.valueOf(this.f2965b) + "}";
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<>(a2, b2);
    }
}
