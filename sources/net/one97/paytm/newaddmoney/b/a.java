package net.one97.paytm.newaddmoney.b;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class a {
    @b(a = "id")

    /* renamed from: a  reason: collision with root package name */
    public final int f55818a;
    @b(a = "displayName")

    /* renamed from: b  reason: collision with root package name */
    public final String f55819b;
    @b(a = "balance")

    /* renamed from: c  reason: collision with root package name */
    public double f55820c;
    @b(a = "subWalletType")

    /* renamed from: d  reason: collision with root package name */
    public final int f55821d;
    @b(a = "issuerId")

    /* renamed from: e  reason: collision with root package name */
    public final String f55822e;
    @b(a = "issuerMetadata")

    /* renamed from: f  reason: collision with root package name */
    private final String f55823f;
    @b(a = "expiry")

    /* renamed from: g  reason: collision with root package name */
    private final String f55824g;
    @b(a = "imageUrl")

    /* renamed from: h  reason: collision with root package name */
    private final String f55825h;
    @b(a = "walletType")

    /* renamed from: i  reason: collision with root package name */
    private final String f55826i;
    @b(a = "status")
    private final int j;
    @b(a = "message")
    private final String k;
    @b(a = "ppiDetailsId")
    private final long l;
    @b(a = "isValid")
    private final boolean m;
    @b(a = "count")
    private final int n;
    @b(a = "issuedOn")
    private final String o;
    @b(a = "subWalletName")
    private final String p;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if ((this.f55818a == aVar.f55818a) && k.a((Object) this.f55819b, (Object) aVar.f55819b) && Double.compare(this.f55820c, aVar.f55820c) == 0 && k.a((Object) this.f55823f, (Object) aVar.f55823f) && k.a((Object) this.f55824g, (Object) aVar.f55824g) && k.a((Object) this.f55825h, (Object) aVar.f55825h) && k.a((Object) this.f55826i, (Object) aVar.f55826i)) {
                    if (this.f55821d == aVar.f55821d) {
                        if ((this.j == aVar.j) && k.a((Object) this.k, (Object) aVar.k) && k.a((Object) this.f55822e, (Object) aVar.f55822e)) {
                            if (this.l == aVar.l) {
                                if (this.m == aVar.m) {
                                    if (!(this.n == aVar.n) || !k.a((Object) this.o, (Object) aVar.o) || !k.a((Object) this.p, (Object) aVar.p)) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f55818a * 31;
        String str = this.f55819b;
        int i3 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.f55820c);
        int i4 = (((i2 + hashCode) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String str2 = this.f55823f;
        int hashCode2 = (i4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f55824g;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f55825h;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f55826i;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f55821d) * 31) + this.j) * 31;
        String str6 = this.k;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f55822e;
        int hashCode7 = str7 != null ? str7.hashCode() : 0;
        long j2 = this.l;
        int i5 = (((hashCode6 + hashCode7) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        boolean z = this.m;
        if (z) {
            z = true;
        }
        int i6 = (((i5 + (z ? 1 : 0)) * 31) + this.n) * 31;
        String str8 = this.o;
        int hashCode8 = (i6 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.p;
        if (str9 != null) {
            i3 = str9.hashCode();
        }
        return hashCode8 + i3;
    }

    public final String toString() {
        return "AMSubWallet(id=" + this.f55818a + ", displayName=" + this.f55819b + ", balance=" + this.f55820c + ", issuerMetadata=" + this.f55823f + ", expiry=" + this.f55824g + ", imageUrl=" + this.f55825h + ", walletType=" + this.f55826i + ", subWalletType=" + this.f55821d + ", status=" + this.j + ", message=" + this.k + ", issuerId=" + this.f55822e + ", ppiDetailsId=" + this.l + ", isValid=" + this.m + ", count=" + this.n + ", issuedOn=" + this.o + ", subWalletName=" + this.p + ")";
    }
}
