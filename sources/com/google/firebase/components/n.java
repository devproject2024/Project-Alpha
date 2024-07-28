package com.google.firebase.components;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    final Class<?> f38115a;

    /* renamed from: b  reason: collision with root package name */
    final int f38116b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38117c;

    private n(Class<?> cls, int i2, int i3) {
        this.f38115a = (Class) v.a(cls, "Null dependency anInterface.");
        this.f38116b = i2;
        this.f38117c = i3;
    }

    public static n a(Class<?> cls) {
        return new n(cls, 0, 0);
    }

    public static n b(Class<?> cls) {
        return new n(cls, 1, 0);
    }

    public static n c(Class<?> cls) {
        return new n(cls, 2, 0);
    }

    public static n d(Class<?> cls) {
        return new n(cls, 1, 1);
    }

    public final boolean a() {
        return this.f38116b == 2;
    }

    public final boolean b() {
        return this.f38117c == 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f38115a == nVar.f38115a && this.f38116b == nVar.f38116b && this.f38117c == nVar.f38117c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f38115a.hashCode() ^ 1000003) * 1000003) ^ this.f38116b) * 1000003) ^ this.f38117c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f38115a);
        sb.append(", type=");
        int i2 = this.f38116b;
        boolean z = true;
        sb.append(i2 == 1 ? "required" : i2 == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.f38117c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
