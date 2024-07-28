package net.one97.paytm.wallet.rateMerchant.entity;

import kotlin.g.b.k;

public final class b {
    @com.google.gsonhtcfix.a.b(a = "status")

    /* renamed from: a  reason: collision with root package name */
    private String f71711a = null;
    @com.google.gsonhtcfix.a.b(a = "errorMsg")

    /* renamed from: b  reason: collision with root package name */
    private String f71712b = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f71711a, (Object) bVar.f71711a) && k.a((Object) this.f71712b, (Object) bVar.f71712b);
    }

    public final int hashCode() {
        String str = this.f71711a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f71712b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Meta(status=" + this.f71711a + ", errorMsg=" + this.f71712b + ")";
    }

    private b() {
    }
}
