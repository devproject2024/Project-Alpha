package net.one97.paytm.appsflyerModel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ReferalData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "deeplink")
    private String deeplink;

    public ReferalData() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ ReferalData copy$default(ReferalData referalData, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = referalData.deeplink;
        }
        return referalData.copy(str);
    }

    public final String component1() {
        return this.deeplink;
    }

    public final ReferalData copy(String str) {
        return new ReferalData(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ReferalData) && k.a((Object) this.deeplink, (Object) ((ReferalData) obj).deeplink);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.deeplink;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "ReferalData(deeplink=" + this.deeplink + ")";
    }

    public ReferalData(String str) {
        this.deeplink = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReferalData(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }
}
