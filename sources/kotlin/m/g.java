package kotlin.m;

import kotlin.g.b.k;
import kotlin.j.d;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f47988a;

    /* renamed from: b  reason: collision with root package name */
    private final d f47989b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.a((Object) this.f47988a, (Object) gVar.f47988a) && k.a((Object) this.f47989b, (Object) gVar.f47989b);
    }

    public final int hashCode() {
        String str = this.f47988a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d dVar = this.f47989b;
        if (dVar != null) {
            i2 = dVar.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f47988a + ", range=" + this.f47989b + ")";
    }

    public g(String str, d dVar) {
        k.d(str, "value");
        k.d(dVar, "range");
        this.f47988a = str;
        this.f47989b = dVar;
    }
}
