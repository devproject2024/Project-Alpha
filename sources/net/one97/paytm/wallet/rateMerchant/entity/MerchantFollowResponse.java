package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class MerchantFollowResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "statusCode")
    private final String statusCode;
    @b(a = "statusMessage")
    private final String statusMsg;

    public MerchantFollowResponse() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ MerchantFollowResponse copy$default(MerchantFollowResponse merchantFollowResponse, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantFollowResponse.statusMsg;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantFollowResponse.statusCode;
        }
        return merchantFollowResponse.copy(str, str2);
    }

    public final String component1() {
        return this.statusMsg;
    }

    public final String component2() {
        return this.statusCode;
    }

    public final MerchantFollowResponse copy(String str, String str2) {
        return new MerchantFollowResponse(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantFollowResponse)) {
            return false;
        }
        MerchantFollowResponse merchantFollowResponse = (MerchantFollowResponse) obj;
        return k.a((Object) this.statusMsg, (Object) merchantFollowResponse.statusMsg) && k.a((Object) this.statusCode, (Object) merchantFollowResponse.statusCode);
    }

    public final int hashCode() {
        String str = this.statusMsg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusCode;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MerchantFollowResponse(statusMsg=" + this.statusMsg + ", statusCode=" + this.statusCode + ")";
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public MerchantFollowResponse(String str, String str2) {
        this.statusMsg = str;
        this.statusCode = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantFollowResponse(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getStatusCode() {
        return this.statusCode;
    }
}
