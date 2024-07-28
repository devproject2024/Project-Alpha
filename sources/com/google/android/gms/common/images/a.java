package com.google.android.gms.common.images;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f8720a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8721b;

    public a(int i2, int i3) {
        this.f8720a = i2;
        this.f8721b = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f8720a == aVar.f8720a && this.f8721b == aVar.f8721b;
        }
    }

    public final String toString() {
        int i2 = this.f8720a;
        int i3 = this.f8721b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        return sb.toString();
    }

    public final int hashCode() {
        int i2 = this.f8721b;
        int i3 = this.f8720a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }
}
