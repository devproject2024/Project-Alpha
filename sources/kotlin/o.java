package kotlin;

import java.io.Serializable;
import kotlin.g.b.k;

public final class o<A, B> implements Serializable {
    private final A first;
    private final B second;

    public static /* synthetic */ o copy$default(o oVar, A a2, B b2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            a2 = oVar.first;
        }
        if ((i2 & 2) != 0) {
            b2 = oVar.second;
        }
        return oVar.copy(a2, b2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final o<A, B> copy(A a2, B b2) {
        return new o<>(a2, b2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return k.a((Object) this.first, (Object) oVar.first) && k.a((Object) this.second, (Object) oVar.second);
    }

    public final int hashCode() {
        A a2 = this.first;
        int i2 = 0;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return hashCode + i2;
    }

    public o(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
