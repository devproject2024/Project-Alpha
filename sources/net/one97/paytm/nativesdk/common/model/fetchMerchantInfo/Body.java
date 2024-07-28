package net.one97.paytm.nativesdk.common.model.fetchMerchantInfo;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Body {
    @c(a = "appInvokeAllowed")
    private final Boolean appInvokeAllowed;
    @c(a = "callbackUrl")
    private final String callbackUrl;
    @c(a = "merchantInfoResp")
    private final MerchantInfoResp merchantInfoResp;

    public Body() {
        this((Boolean) null, (String) null, (MerchantInfoResp) null, 7, (g) null);
    }

    public static /* synthetic */ Body copy$default(Body body, Boolean bool, String str, MerchantInfoResp merchantInfoResp2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = body.appInvokeAllowed;
        }
        if ((i2 & 2) != 0) {
            str = body.callbackUrl;
        }
        if ((i2 & 4) != 0) {
            merchantInfoResp2 = body.merchantInfoResp;
        }
        return body.copy(bool, str, merchantInfoResp2);
    }

    public final Boolean component1() {
        return this.appInvokeAllowed;
    }

    public final String component2() {
        return this.callbackUrl;
    }

    public final MerchantInfoResp component3() {
        return this.merchantInfoResp;
    }

    public final Body copy(Boolean bool, String str, MerchantInfoResp merchantInfoResp2) {
        return new Body(bool, str, merchantInfoResp2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return k.a((Object) this.appInvokeAllowed, (Object) body.appInvokeAllowed) && k.a((Object) this.callbackUrl, (Object) body.callbackUrl) && k.a((Object) this.merchantInfoResp, (Object) body.merchantInfoResp);
    }

    public final int hashCode() {
        Boolean bool = this.appInvokeAllowed;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.callbackUrl;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        MerchantInfoResp merchantInfoResp2 = this.merchantInfoResp;
        if (merchantInfoResp2 != null) {
            i2 = merchantInfoResp2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Body(appInvokeAllowed=" + this.appInvokeAllowed + ", callbackUrl=" + this.callbackUrl + ", merchantInfoResp=" + this.merchantInfoResp + ")";
    }

    public Body(Boolean bool, String str, MerchantInfoResp merchantInfoResp2) {
        this.appInvokeAllowed = bool;
        this.callbackUrl = str;
        this.merchantInfoResp = merchantInfoResp2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Body(Boolean bool, String str, MerchantInfoResp merchantInfoResp2, int i2, g gVar) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : merchantInfoResp2);
    }

    public final Boolean getAppInvokeAllowed() {
        return this.appInvokeAllowed;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    public final MerchantInfoResp getMerchantInfoResp() {
        return this.merchantInfoResp;
    }
}
