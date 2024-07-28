package com.google.zxing;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f40410a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40411b;

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f40410a == fVar.f40410a && this.f40411b == fVar.f40411b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f40410a * 32713) + this.f40411b;
    }

    public final String toString() {
        return this.f40410a + "x" + this.f40411b;
    }
}
