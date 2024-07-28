package net.one97.paytm.o2o.movies.common.movies.foodbeverage;

import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f75147a;

    /* renamed from: b  reason: collision with root package name */
    public final String f75148b;

    /* renamed from: c  reason: collision with root package name */
    public final String f75149c;

    /* renamed from: d  reason: collision with root package name */
    public String f75150d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f75151e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f75151e, (Object) aVar.f75151e) && k.a((Object) this.f75147a, (Object) aVar.f75147a) && k.a((Object) this.f75148b, (Object) aVar.f75148b) && k.a((Object) this.f75149c, (Object) aVar.f75149c) && k.a((Object) this.f75150d, (Object) aVar.f75150d);
    }

    public final int hashCode() {
        Long l = this.f75151e;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.f75147a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f75148b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f75149c;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f75150d;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CJRFoodVoucherCoupon(id=" + this.f75151e + ", name=" + this.f75147a + ", code=" + this.f75148b + ", expiry=" + this.f75149c + ", tncAndProcess=" + this.f75150d + ")";
    }

    public a(Long l, String str, String str2, String str3, String str4) {
        this.f75151e = l;
        this.f75147a = str;
        this.f75148b = str2;
        this.f75149c = str3;
        this.f75150d = str4;
    }
}
