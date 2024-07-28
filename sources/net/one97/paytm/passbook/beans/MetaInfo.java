package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MetaInfo extends IJRDataModel {
    @b(a = "code")
    private String code;
    @b(a = "message")
    private String message;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseId")
    private String responseId;

    public MetaInfo() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ MetaInfo copy$default(MetaInfo metaInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = metaInfo.code;
        }
        if ((i2 & 2) != 0) {
            str2 = metaInfo.message;
        }
        if ((i2 & 4) != 0) {
            str3 = metaInfo.requestId;
        }
        if ((i2 & 8) != 0) {
            str4 = metaInfo.responseId;
        }
        return metaInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.requestId;
    }

    public final String component4() {
        return this.responseId;
    }

    public final MetaInfo copy(String str, String str2, String str3, String str4) {
        return new MetaInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaInfo)) {
            return false;
        }
        MetaInfo metaInfo = (MetaInfo) obj;
        return k.a((Object) this.code, (Object) metaInfo.code) && k.a((Object) this.message, (Object) metaInfo.message) && k.a((Object) this.requestId, (Object) metaInfo.requestId) && k.a((Object) this.responseId, (Object) metaInfo.responseId);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.requestId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.responseId;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MetaInfo(code=" + this.code + ", message=" + this.message + ", requestId=" + this.requestId + ", responseId=" + this.responseId + ")";
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetaInfo(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getResponseId() {
        return this.responseId;
    }

    public final void setResponseId(String str) {
        this.responseId = str;
    }

    public MetaInfo(String str, String str2, String str3, String str4) {
        this.code = str;
        this.message = str2;
        this.requestId = str3;
        this.responseId = str4;
    }
}
