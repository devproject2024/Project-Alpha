package net.one97.paytm.upi.mandate.utils;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final String f67386a;

    /* renamed from: b  reason: collision with root package name */
    final String f67387b;

    /* renamed from: c  reason: collision with root package name */
    final String f67388c;

    /* renamed from: d  reason: collision with root package name */
    final String f67389d;

    /* renamed from: e  reason: collision with root package name */
    final String f67390e;

    /* renamed from: f  reason: collision with root package name */
    final String f67391f;

    /* renamed from: g  reason: collision with root package name */
    final String f67392g;

    /* renamed from: h  reason: collision with root package name */
    final String f67393h;

    /* renamed from: i  reason: collision with root package name */
    final String f67394i;
    final String j;
    final List<BankAccountDetails.BankAccountCredentials> k;
    final String l;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f67386a, (Object) aVar.f67386a) && k.a((Object) this.f67387b, (Object) aVar.f67387b) && k.a((Object) this.f67388c, (Object) aVar.f67388c) && k.a((Object) this.f67389d, (Object) aVar.f67389d) && k.a((Object) this.f67390e, (Object) aVar.f67390e) && k.a((Object) this.f67391f, (Object) aVar.f67391f) && k.a((Object) this.f67392g, (Object) aVar.f67392g) && k.a((Object) this.f67393h, (Object) aVar.f67393h) && k.a((Object) this.f67394i, (Object) aVar.f67394i) && k.a((Object) this.j, (Object) aVar.j) && k.a((Object) this.k, (Object) aVar.k) && k.a((Object) this.l, (Object) aVar.l);
    }

    public final int hashCode() {
        String str = this.f67386a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f67387b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67388c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f67389d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f67390e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f67391f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f67392g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f67393h;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f67394i;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.j;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        List<BankAccountDetails.BankAccountCredentials> list = this.k;
        int hashCode11 = (hashCode10 + (list != null ? list.hashCode() : 0)) * 31;
        String str11 = this.l;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "CommonLibInput(formattedAmount=" + this.f67386a + ", payeeVpa=" + this.f67387b + ", payerVpa=" + this.f67388c + ", payeeName=" + this.f67389d + ", comments=" + this.f67390e + ", maskedAccountNum=" + this.f67391f + ", txnId=" + this.f67392g + ", mcc=" + this.f67393h + ", refId=" + this.f67394i + ", refUrl=" + this.j + ", bankCreds=" + this.k + ", bankName=" + this.l + ")";
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<? extends BankAccountDetails.BankAccountCredentials> list, String str11) {
        k.c(str7, "txnId");
        k.c(str8, "mcc");
        this.f67386a = str;
        this.f67387b = str2;
        this.f67388c = str3;
        this.f67389d = str4;
        this.f67390e = str5;
        this.f67391f = str6;
        this.f67392g = str7;
        this.f67393h = str8;
        this.f67394i = str9;
        this.j = str10;
        this.k = list;
        this.l = str11;
    }
}
