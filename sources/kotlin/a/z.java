package kotlin.a;

import kotlin.g.b.k;

public final class z<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f47893a;

    /* renamed from: b  reason: collision with root package name */
    public final T f47894b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f47893a == zVar.f47893a && k.a((Object) this.f47894b, (Object) zVar.f47894b);
    }

    public final int hashCode() {
        int i2 = this.f47893a * 31;
        T t = this.f47894b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f47893a + ", value=" + this.f47894b + ")";
    }

    public z(int i2, T t) {
        this.f47893a = i2;
        this.f47894b = t;
    }
}
