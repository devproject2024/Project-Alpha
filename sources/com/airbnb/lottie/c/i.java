package com.airbnb.lottie.c;

import androidx.core.g.d;

public final class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f5972a;

    /* renamed from: b  reason: collision with root package name */
    public T f5973b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!a(dVar.f2964a, this.f5972a) || !a(dVar.f2965b, this.f5973b)) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public final int hashCode() {
        T t = this.f5972a;
        int i2 = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f5973b;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f5972a) + " " + String.valueOf(this.f5973b) + "}";
    }
}
