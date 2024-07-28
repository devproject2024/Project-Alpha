package net.one97.paytm.recharge.coupons.e;

import kotlin.g.b.k;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f62293a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f62294b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a((Object) this.f62293a, (Object) cVar.f62293a) && k.a((Object) this.f62294b, (Object) cVar.f62294b);
    }

    public final int hashCode() {
        T t = this.f62293a;
        int i2 = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        Integer num = this.f62294b;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Data(model=" + this.f62293a + ", position=" + this.f62294b + ")";
    }

    public c(T t, Integer num) {
        this.f62293a = t;
        this.f62294b = num;
    }
}
