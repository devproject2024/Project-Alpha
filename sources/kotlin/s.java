package kotlin;

import java.io.Serializable;
import kotlin.g.b.k;

public final class s<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public static /* synthetic */ s copy$default(s sVar, A a2, B b2, C c2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            a2 = sVar.first;
        }
        if ((i2 & 2) != 0) {
            b2 = sVar.second;
        }
        if ((i2 & 4) != 0) {
            c2 = sVar.third;
        }
        return sVar.copy(a2, b2, c2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final s<A, B, C> copy(A a2, B b2, C c2) {
        return new s<>(a2, b2, c2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return k.a((Object) this.first, (Object) sVar.first) && k.a((Object) this.second, (Object) sVar.second) && k.a((Object) this.third, (Object) sVar.third);
    }

    public final int hashCode() {
        A a2 = this.first;
        int i2 = 0;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.third;
        if (c2 != null) {
            i2 = c2.hashCode();
        }
        return hashCode2 + i2;
    }

    public s(A a2, B b2, C c2) {
        this.first = a2;
        this.second = b2;
        this.third = c2;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public final String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
