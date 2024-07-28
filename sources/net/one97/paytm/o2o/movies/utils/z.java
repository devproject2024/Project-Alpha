package net.one97.paytm.o2o.movies.utils;

final class z {

    /* renamed from: a  reason: collision with root package name */
    final int f76003a;

    /* renamed from: b  reason: collision with root package name */
    final int f76004b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f76003a == zVar.f76003a && this.f76004b == zVar.f76004b;
    }

    public final int hashCode() {
        return (Integer.valueOf(this.f76003a).hashCode() * 31) + Integer.valueOf(this.f76004b).hashCode();
    }

    public final String toString() {
        return "ScrollPositionHolder(x=" + this.f76003a + ", y=" + this.f76004b + ")";
    }

    public z(int i2, int i3) {
        this.f76003a = i2;
        this.f76004b = i3;
    }
}
