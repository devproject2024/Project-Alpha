package androidx.core.graphics;

import android.graphics.Insets;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f2972a = new b(0, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final int f2973b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2974c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2975d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2976e;

    private b(int i2, int i3, int i4, int i5) {
        this.f2973b = i2;
        this.f2974c = i3;
        this.f2975d = i4;
        this.f2976e = i5;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return f2972a;
        }
        return new b(i2, i3, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2976e == bVar.f2976e && this.f2973b == bVar.f2973b && this.f2975d == bVar.f2975d && this.f2974c == bVar.f2974c;
    }

    public final int hashCode() {
        return (((((this.f2973b * 31) + this.f2974c) * 31) + this.f2975d) * 31) + this.f2976e;
    }

    public final String toString() {
        return "Insets{left=" + this.f2973b + ", top=" + this.f2974c + ", right=" + this.f2975d + ", bottom=" + this.f2976e + '}';
    }

    public static b a(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets a() {
        return Insets.of(this.f2973b, this.f2974c, this.f2975d, this.f2976e);
    }
}
