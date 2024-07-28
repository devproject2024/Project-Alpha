package net.one97.paytm.autoaddmoney.b;

import kotlin.g.b.k;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final HasLowSuccess f49148a;

    /* renamed from: b  reason: collision with root package name */
    public final String f49149b;

    /* renamed from: c  reason: collision with root package name */
    public final String f49150c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f49148a, (Object) aVar.f49148a) && k.a((Object) this.f49149b, (Object) aVar.f49149b) && k.a((Object) this.f49150c, (Object) aVar.f49150c);
    }

    public final int hashCode() {
        HasLowSuccess hasLowSuccess = this.f49148a;
        int i2 = 0;
        int hashCode = (hasLowSuccess != null ? hasLowSuccess.hashCode() : 0) * 31;
        String str = this.f49149b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f49150c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CardIssuerWrapper(lowSuccess=" + this.f49148a + ", paymentmode=" + this.f49149b + ", chanel=" + this.f49150c + ")";
    }

    public a(HasLowSuccess hasLowSuccess, String str, String str2) {
        this.f49148a = hasLowSuccess;
        this.f49149b = str;
        this.f49150c = str2;
    }
}
