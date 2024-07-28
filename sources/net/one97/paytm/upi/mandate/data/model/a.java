package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class a {
    @c(a = "status")

    /* renamed from: a  reason: collision with root package name */
    public final String f67147a;
    @c(a = "rrn")

    /* renamed from: b  reason: collision with root package name */
    public final String f67148b;
    @c(a = "rc")

    /* renamed from: c  reason: collision with root package name */
    public final String f67149c;
    @c(a = "message")

    /* renamed from: d  reason: collision with root package name */
    public final String f67150d;
    @c(a = "importantNote")

    /* renamed from: e  reason: collision with root package name */
    public final String f67151e;
    @c(a = "umn")

    /* renamed from: f  reason: collision with root package name */
    public final String f67152f;
    @c(a = "amount")

    /* renamed from: g  reason: collision with root package name */
    private final String f67153g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f67147a, (Object) aVar.f67147a) && k.a((Object) this.f67153g, (Object) aVar.f67153g) && k.a((Object) this.f67148b, (Object) aVar.f67148b) && k.a((Object) this.f67149c, (Object) aVar.f67149c) && k.a((Object) this.f67150d, (Object) aVar.f67150d) && k.a((Object) this.f67151e, (Object) aVar.f67151e) && k.a((Object) this.f67152f, (Object) aVar.f67152f);
    }

    public final int hashCode() {
        String str = this.f67147a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f67153g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67148b;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f67149c;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f67150d;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f67151e;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f67152f;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "Details(status=" + this.f67147a + ", amount=" + this.f67153g + ", rrn=" + this.f67148b + ", rc=" + this.f67149c + ", message=" + this.f67150d + ", importantNote=" + this.f67151e + ", umn=" + this.f67152f + ")";
    }
}
