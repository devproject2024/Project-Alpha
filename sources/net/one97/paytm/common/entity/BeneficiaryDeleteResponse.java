package net.one97.paytm.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class BeneficiaryDeleteResponse extends IJRPaytmDataModel {
    private final String code;
    private final String message;
    private final String status;
    private final boolean success;

    public BeneficiaryDeleteResponse() {
        this((String) null, (String) null, (String) null, false, 15, (g) null);
    }

    public static /* synthetic */ BeneficiaryDeleteResponse copy$default(BeneficiaryDeleteResponse beneficiaryDeleteResponse, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = beneficiaryDeleteResponse.code;
        }
        if ((i2 & 2) != 0) {
            str2 = beneficiaryDeleteResponse.message;
        }
        if ((i2 & 4) != 0) {
            str3 = beneficiaryDeleteResponse.status;
        }
        if ((i2 & 8) != 0) {
            z = beneficiaryDeleteResponse.success;
        }
        return beneficiaryDeleteResponse.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final boolean component4() {
        return this.success;
    }

    public final BeneficiaryDeleteResponse copy(String str, String str2, String str3, boolean z) {
        k.c(str, "code");
        k.c(str2, "message");
        k.c(str3, "status");
        return new BeneficiaryDeleteResponse(str, str2, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeneficiaryDeleteResponse)) {
            return false;
        }
        BeneficiaryDeleteResponse beneficiaryDeleteResponse = (BeneficiaryDeleteResponse) obj;
        return k.a((Object) this.code, (Object) beneficiaryDeleteResponse.code) && k.a((Object) this.message, (Object) beneficiaryDeleteResponse.message) && k.a((Object) this.status, (Object) beneficiaryDeleteResponse.status) && this.success == beneficiaryDeleteResponse.success;
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.success;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "BeneficiaryDeleteResponse(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ", success=" + this.success + ")";
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeneficiaryDeleteResponse(String str, String str2, String str3, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public BeneficiaryDeleteResponse(String str, String str2, String str3, boolean z) {
        k.c(str, "code");
        k.c(str2, "message");
        k.c(str3, "status");
        this.code = str;
        this.message = str2;
        this.status = str3;
        this.success = z;
    }
}
