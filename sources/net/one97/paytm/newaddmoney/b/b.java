package net.one97.paytm.newaddmoney.b;

import kotlin.g.b.k;

public final class b {
    @com.google.gsonhtcfix.a.b(a = "title")

    /* renamed from: a  reason: collision with root package name */
    public final String f55827a;
    @com.google.gsonhtcfix.a.b(a = "image")

    /* renamed from: b  reason: collision with root package name */
    public int f55828b;
    @com.google.gsonhtcfix.a.b(a = "type")

    /* renamed from: c  reason: collision with root package name */
    public final String f55829c;
    @com.google.gsonhtcfix.a.b(a = "deeplink")

    /* renamed from: d  reason: collision with root package name */
    public final String f55830d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (k.a((Object) this.f55827a, (Object) bVar.f55827a)) {
                    if (!(this.f55828b == bVar.f55828b) || !k.a((Object) this.f55829c, (Object) bVar.f55829c) || !k.a((Object) this.f55830d, (Object) bVar.f55830d)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f55827a;
        int i2 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f55828b) * 31;
        String str2 = this.f55829c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f55830d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AmCta(title=" + this.f55827a + ", image=" + this.f55828b + ", type=" + this.f55829c + ", deeplink=" + this.f55830d + ")";
    }
}
