package com.google.zxing.e.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f40349a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40350b;

    public b(int i2, int i3) {
        this.f40349a = i2;
        this.f40350b = i3;
    }

    public final String toString() {
        return this.f40349a + "(" + this.f40350b + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f40349a == bVar.f40349a && this.f40350b == bVar.f40350b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f40349a ^ this.f40350b;
    }
}
