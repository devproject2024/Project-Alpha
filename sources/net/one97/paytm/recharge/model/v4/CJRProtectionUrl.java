package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRProtectionUrl extends IJRPaytmDataModel {
    @b(a = "android")

    /* renamed from: android  reason: collision with root package name */
    private final String f63968android;

    public CJRProtectionUrl() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ CJRProtectionUrl copy$default(CJRProtectionUrl cJRProtectionUrl, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRProtectionUrl.f63968android;
        }
        return cJRProtectionUrl.copy(str);
    }

    public final String component1() {
        return this.f63968android;
    }

    public final CJRProtectionUrl copy(String str) {
        return new CJRProtectionUrl(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRProtectionUrl) && k.a((Object) this.f63968android, (Object) ((CJRProtectionUrl) obj).f63968android);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f63968android;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRProtectionUrl(android=" + this.f63968android + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRProtectionUrl(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getAndroid() {
        return this.f63968android;
    }

    public CJRProtectionUrl(String str) {
        this.f63968android = str;
    }
}
