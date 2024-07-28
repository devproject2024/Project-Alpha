package androidx.work.impl.b;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f5159a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5160b;

    public g(String str, int i2) {
        this.f5159a = str;
        this.f5160b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f5160b != gVar.f5160b) {
            return false;
        }
        return this.f5159a.equals(gVar.f5159a);
    }

    public final int hashCode() {
        return (this.f5159a.hashCode() * 31) + this.f5160b;
    }
}
