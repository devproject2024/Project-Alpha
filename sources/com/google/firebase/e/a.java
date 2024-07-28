package com.google.firebase.e;

final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f38727a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38728b;

    a(String str, String str2) {
        if (str != null) {
            this.f38727a = str;
            if (str2 != null) {
                this.f38728b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public final String a() {
        return this.f38727a;
    }

    public final String b() {
        return this.f38728b;
    }

    public final String toString() {
        return "LibraryVersion{libraryName=" + this.f38727a + ", version=" + this.f38728b + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f38727a.equals(fVar.a()) && this.f38728b.equals(fVar.b());
        }
    }

    public final int hashCode() {
        return ((this.f38727a.hashCode() ^ 1000003) * 1000003) ^ this.f38728b.hashCode();
    }
}
