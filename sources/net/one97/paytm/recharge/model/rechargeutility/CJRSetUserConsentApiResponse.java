package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSetUserConsentApiResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private final String data;
    @b(a = "error")
    private final String error;
    @b(a = "error_message")
    private final String error_message;
    @b(a = "status")
    private final Integer status;

    public CJRSetUserConsentApiResponse() {
        this((Integer) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ CJRSetUserConsentApiResponse copy$default(CJRSetUserConsentApiResponse cJRSetUserConsentApiResponse, Integer num, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cJRSetUserConsentApiResponse.status;
        }
        if ((i2 & 2) != 0) {
            str = cJRSetUserConsentApiResponse.data;
        }
        if ((i2 & 4) != 0) {
            str2 = cJRSetUserConsentApiResponse.error_message;
        }
        if ((i2 & 8) != 0) {
            str3 = cJRSetUserConsentApiResponse.error;
        }
        return cJRSetUserConsentApiResponse.copy(num, str, str2, str3);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.data;
    }

    public final String component3() {
        return this.error_message;
    }

    public final String component4() {
        return this.error;
    }

    public final CJRSetUserConsentApiResponse copy(Integer num, String str, String str2, String str3) {
        return new CJRSetUserConsentApiResponse(num, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRSetUserConsentApiResponse)) {
            return false;
        }
        CJRSetUserConsentApiResponse cJRSetUserConsentApiResponse = (CJRSetUserConsentApiResponse) obj;
        return k.a((Object) this.status, (Object) cJRSetUserConsentApiResponse.status) && k.a((Object) this.data, (Object) cJRSetUserConsentApiResponse.data) && k.a((Object) this.error_message, (Object) cJRSetUserConsentApiResponse.error_message) && k.a((Object) this.error, (Object) cJRSetUserConsentApiResponse.error);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.data;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.error_message;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.error;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRSetUserConsentApiResponse(status=" + this.status + ", data=" + this.data + ", error_message=" + this.error_message + ", error=" + this.error + ")";
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getData() {
        return this.data;
    }

    public final String getError_message() {
        return this.error_message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRSetUserConsentApiResponse(Integer num, String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }

    public final String getError() {
        return this.error;
    }

    public CJRSetUserConsentApiResponse(Integer num, String str, String str2, String str3) {
        this.status = num;
        this.data = str;
        this.error_message = str2;
        this.error = str3;
    }
}
