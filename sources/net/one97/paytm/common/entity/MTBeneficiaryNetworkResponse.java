package net.one97.paytm.common.entity;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;

public final class MTBeneficiaryNetworkResponse {
    private final String code;
    private final String message;
    private final Response response;
    private final String status;
    private final boolean success;

    public static /* synthetic */ MTBeneficiaryNetworkResponse copy$default(MTBeneficiaryNetworkResponse mTBeneficiaryNetworkResponse, String str, String str2, Response response2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTBeneficiaryNetworkResponse.code;
        }
        if ((i2 & 2) != 0) {
            str2 = mTBeneficiaryNetworkResponse.message;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            response2 = mTBeneficiaryNetworkResponse.response;
        }
        Response response3 = response2;
        if ((i2 & 8) != 0) {
            str3 = mTBeneficiaryNetworkResponse.status;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            z = mTBeneficiaryNetworkResponse.success;
        }
        return mTBeneficiaryNetworkResponse.copy(str, str4, response3, str5, z);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Response component3() {
        return this.response;
    }

    public final String component4() {
        return this.status;
    }

    public final boolean component5() {
        return this.success;
    }

    public final MTBeneficiaryNetworkResponse copy(String str, String str2, Response response2, String str3, boolean z) {
        k.c(str, "code");
        k.c(response2, Payload.RESPONSE);
        k.c(str3, "status");
        return new MTBeneficiaryNetworkResponse(str, str2, response2, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MTBeneficiaryNetworkResponse)) {
            return false;
        }
        MTBeneficiaryNetworkResponse mTBeneficiaryNetworkResponse = (MTBeneficiaryNetworkResponse) obj;
        return k.a((Object) this.code, (Object) mTBeneficiaryNetworkResponse.code) && k.a((Object) this.message, (Object) mTBeneficiaryNetworkResponse.message) && k.a((Object) this.response, (Object) mTBeneficiaryNetworkResponse.response) && k.a((Object) this.status, (Object) mTBeneficiaryNetworkResponse.status) && this.success == mTBeneficiaryNetworkResponse.success;
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Response response2 = this.response;
        int hashCode3 = (hashCode2 + (response2 != null ? response2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.success;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "MTBeneficiaryNetworkResponse(code=" + this.code + ", message=" + this.message + ", response=" + this.response + ", status=" + this.status + ", success=" + this.success + ")";
    }

    public MTBeneficiaryNetworkResponse(String str, String str2, Response response2, String str3, boolean z) {
        k.c(str, "code");
        k.c(response2, Payload.RESPONSE);
        k.c(str3, "status");
        this.code = str;
        this.message = str2;
        this.response = response2;
        this.status = str3;
        this.success = z;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}
