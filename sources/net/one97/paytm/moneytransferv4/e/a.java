package net.one97.paytm.moneytransferv4.e;

import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final net.one97.paytm.moneytransferv4.a f55401a;

    /* renamed from: b  reason: collision with root package name */
    public final int f55402b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55403c;

    /* renamed from: d  reason: collision with root package name */
    private final String f55404d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f55401a, (Object) aVar.f55401a) && k.a((Object) this.f55404d, (Object) aVar.f55404d) && this.f55402b == aVar.f55402b && this.f55403c == aVar.f55403c;
    }

    public final int hashCode() {
        net.one97.paytm.moneytransferv4.a aVar = this.f55401a;
        int i2 = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        String str = this.f55404d;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((hashCode + i2) * 31) + this.f55402b) * 31) + this.f55403c;
    }

    public final String toString() {
        return "OptionItemModel(option=" + this.f55401a + ", deeplink=" + this.f55404d + ", text=" + this.f55402b + ", drawable=" + this.f55403c + ")";
    }

    public a(net.one97.paytm.moneytransferv4.a aVar, String str, int i2, int i3) {
        k.c(aVar, "option");
        k.c(str, "deeplink");
        this.f55401a = aVar;
        this.f55404d = str;
        this.f55402b = i2;
        this.f55403c = i3;
    }
}
