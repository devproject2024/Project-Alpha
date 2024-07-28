package net.one97.paytm.oauth.fragment;

import kotlin.g.b.k;

public final class bq {

    /* renamed from: a  reason: collision with root package name */
    public String f56511a;

    /* renamed from: b  reason: collision with root package name */
    public String f56512b;

    /* renamed from: c  reason: collision with root package name */
    public int f56513c = 0;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof bq) {
                bq bqVar = (bq) obj;
                if (k.a((Object) this.f56511a, (Object) bqVar.f56511a) && k.a((Object) this.f56512b, (Object) bqVar.f56512b)) {
                    if (this.f56513c == bqVar.f56513c) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f56511a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f56512b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.f56513c;
    }

    public final String toString() {
        return "SignUpModel(imageUrl=" + this.f56511a + ", deepLink=" + this.f56512b + ", resId=" + this.f56513c + ")";
    }

    public bq(String str, String str2) {
        k.c(str, "imageUrl");
        k.c(str2, "deepLink");
        this.f56511a = str;
        this.f56512b = str2;
    }
}
