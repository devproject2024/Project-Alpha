package net.one97.paytm.passbook.caching.db;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    Integer f57111a;

    /* renamed from: b  reason: collision with root package name */
    String f57112b;

    /* renamed from: c  reason: collision with root package name */
    String f57113c;

    /* renamed from: d  reason: collision with root package name */
    String f57114d;

    /* renamed from: e  reason: collision with root package name */
    String f57115e;

    /* renamed from: f  reason: collision with root package name */
    String f57116f;

    /* renamed from: g  reason: collision with root package name */
    public String f57117g;

    /* renamed from: h  reason: collision with root package name */
    long f57118h;

    /* renamed from: i  reason: collision with root package name */
    public long f57119i;
    public int j;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (k.a((Object) this.f57111a, (Object) aVar.f57111a) && k.a((Object) this.f57112b, (Object) aVar.f57112b) && k.a((Object) this.f57113c, (Object) aVar.f57113c) && k.a((Object) this.f57114d, (Object) aVar.f57114d) && k.a((Object) this.f57115e, (Object) aVar.f57115e) && k.a((Object) this.f57116f, (Object) aVar.f57116f) && k.a((Object) this.f57117g, (Object) aVar.f57117g)) {
                    if (this.f57118h == aVar.f57118h) {
                        if (this.f57119i == aVar.f57119i) {
                            if (this.j == aVar.j) {
                                return true;
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
        Integer num = this.f57111a;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.f57112b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f57113c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f57114d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f57115e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f57116f;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f57117g;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        long j2 = this.f57118h;
        long j3 = this.f57119i;
        return ((((((hashCode6 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.j;
    }

    public final String toString() {
        return "PassbookCache(id=" + this.f57111a + ", requestType=" + this.f57112b + ", requestUrl=" + this.f57113c + ", queryParams=" + this.f57114d + ", header=" + this.f57115e + ", bodyData=" + this.f57116f + ", response=" + this.f57117g + ", lastRequestTime=" + this.f57118h + ", maxAge=" + this.f57119i + ", hitCount=" + this.j + ")";
    }

    public a(Integer num, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3, int i2) {
        k.c(str, "requestType");
        k.c(str2, "requestUrl");
        k.c(str6, Payload.RESPONSE);
        this.f57111a = num;
        this.f57112b = str;
        this.f57113c = str2;
        this.f57114d = str3;
        this.f57115e = str4;
        this.f57116f = str5;
        this.f57117g = str6;
        this.f57118h = j2;
        this.f57119i = j3;
        this.j = i2;
    }
}
