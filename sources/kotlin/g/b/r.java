package kotlin.g.b;

public final class r implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f47930a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47931b;

    public r(Class<?> cls, String str) {
        k.d(cls, "jClass");
        k.d(str, "moduleName");
        this.f47930a = cls;
        this.f47931b = str;
    }

    public final Class<?> a() {
        return this.f47930a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof r) && k.a((Object) this.f47930a, (Object) ((r) obj).f47930a);
    }

    public final String toString() {
        return this.f47930a.toString() + " (Kotlin reflection is not available)";
    }

    public final int hashCode() {
        return this.f47930a.hashCode();
    }
}
