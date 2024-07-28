package net.one97.paytm.paymentsBank.cifCreation.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CIFCreationResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error_code")
    private Integer errorCode;
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "message")
    private String message;
    @b(a = "response")
    private String response;
    @b(a = "response_code")
    private Integer responseCode;
    @b(a = "status")
    private String status;
    @b(a = "success")
    private Boolean success;

    public CIFCreationResponse() {
        this((String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, 127, (g) null);
    }

    public static /* synthetic */ CIFCreationResponse copy$default(CIFCreationResponse cIFCreationResponse, String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cIFCreationResponse.message;
        }
        if ((i2 & 2) != 0) {
            str2 = cIFCreationResponse.errorMessage;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = cIFCreationResponse.response;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            num = cIFCreationResponse.responseCode;
        }
        Integer num3 = num;
        if ((i2 & 16) != 0) {
            num2 = cIFCreationResponse.errorCode;
        }
        Integer num4 = num2;
        if ((i2 & 32) != 0) {
            str4 = cIFCreationResponse.status;
        }
        String str7 = str4;
        if ((i2 & 64) != 0) {
            bool = cIFCreationResponse.success;
        }
        return cIFCreationResponse.copy(str, str5, str6, num3, num4, str7, bool);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final String component3() {
        return this.response;
    }

    public final Integer component4() {
        return this.responseCode;
    }

    public final Integer component5() {
        return this.errorCode;
    }

    public final String component6() {
        return this.status;
    }

    public final Boolean component7() {
        return this.success;
    }

    public final CIFCreationResponse copy(String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool) {
        return new CIFCreationResponse(str, str2, str3, num, num2, str4, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CIFCreationResponse)) {
            return false;
        }
        CIFCreationResponse cIFCreationResponse = (CIFCreationResponse) obj;
        return k.a((Object) this.message, (Object) cIFCreationResponse.message) && k.a((Object) this.errorMessage, (Object) cIFCreationResponse.errorMessage) && k.a((Object) this.response, (Object) cIFCreationResponse.response) && k.a((Object) this.responseCode, (Object) cIFCreationResponse.responseCode) && k.a((Object) this.errorCode, (Object) cIFCreationResponse.errorCode) && k.a((Object) this.status, (Object) cIFCreationResponse.status) && k.a((Object) this.success, (Object) cIFCreationResponse.success);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.response;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.responseCode;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.errorCode;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str4 = this.status;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.success;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CIFCreationResponse(message=" + this.message + ", errorMessage=" + this.errorMessage + ", response=" + this.response + ", responseCode=" + this.responseCode + ", errorCode=" + this.errorCode + ", status=" + this.status + ", success=" + this.success + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(String str) {
        this.response = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CIFCreationResponse(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.String r11, java.lang.Boolean r12, int r13, kotlin.g.b.g r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            java.lang.String r0 = ""
            if (r14 == 0) goto L_0x0008
            r14 = r0
            goto L_0x0009
        L_0x0008:
            r14 = r6
        L_0x0009:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r7
        L_0x0010:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r6 = r13 & 8
            r7 = 0
            if (r6 == 0) goto L_0x0020
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
        L_0x0020:
            r3 = r9
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0029
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
        L_0x0029:
            r4 = r10
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = r11
        L_0x0030:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0036
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
        L_0x0036:
            r13 = r12
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public CIFCreationResponse(String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool) {
        this.message = str;
        this.errorMessage = str2;
        this.response = str3;
        this.responseCode = num;
        this.errorCode = num2;
        this.status = str4;
        this.success = bool;
    }
}
