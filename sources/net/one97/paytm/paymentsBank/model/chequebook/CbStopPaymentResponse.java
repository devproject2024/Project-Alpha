package net.one97.paytm.paymentsBank.model.chequebook;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CbStopPaymentResponse extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "errorCode")
    private String errorCode;
    @c(a = "errorMessage")
    private String errorMessage;
    @c(a = "message")
    private String message;
    @c(a = "responseCode")
    private String responseCode;
    @c(a = "status")
    private String status;

    public CbStopPaymentResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ CbStopPaymentResponse copy$default(CbStopPaymentResponse cbStopPaymentResponse, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbStopPaymentResponse.responseCode;
        }
        if ((i2 & 2) != 0) {
            str2 = cbStopPaymentResponse.message;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = cbStopPaymentResponse.status;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = cbStopPaymentResponse.errorMessage;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = cbStopPaymentResponse.errorCode;
        }
        return cbStopPaymentResponse.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.responseCode;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.errorMessage;
    }

    public final String component5() {
        return this.errorCode;
    }

    public final CbStopPaymentResponse copy(String str, String str2, String str3, String str4, String str5) {
        return new CbStopPaymentResponse(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbStopPaymentResponse)) {
            return false;
        }
        CbStopPaymentResponse cbStopPaymentResponse = (CbStopPaymentResponse) obj;
        return k.a((Object) this.responseCode, (Object) cbStopPaymentResponse.responseCode) && k.a((Object) this.message, (Object) cbStopPaymentResponse.message) && k.a((Object) this.status, (Object) cbStopPaymentResponse.status) && k.a((Object) this.errorMessage, (Object) cbStopPaymentResponse.errorMessage) && k.a((Object) this.errorCode, (Object) cbStopPaymentResponse.errorCode);
    }

    public final int hashCode() {
        String str = this.responseCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.errorMessage;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.errorCode;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CbStopPaymentResponse(responseCode=" + this.responseCode + ", message=" + this.message + ", status=" + this.status + ", errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ")";
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(String str) {
        this.responseCode = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CbStopPaymentResponse(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    public CbStopPaymentResponse(String str, String str2, String str3, String str4, String str5) {
        this.responseCode = str;
        this.message = str2;
        this.status = str3;
        this.errorMessage = str4;
        this.errorCode = str5;
    }
}
