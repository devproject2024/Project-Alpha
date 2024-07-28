package net.one97.paytm.paymentsBank.updateInfo.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ValidateEmailOtpResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error")
    private String mError;
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "state")
    private String mState;
    @b(a = "status")
    private String mStatus;
    @b(a = "title")
    private String mTitle;

    public ValidateEmailOtpResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ ValidateEmailOtpResponse copy$default(ValidateEmailOtpResponse validateEmailOtpResponse, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = validateEmailOtpResponse.mStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = validateEmailOtpResponse.mError;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = validateEmailOtpResponse.mTitle;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = validateEmailOtpResponse.mMessage;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = validateEmailOtpResponse.mResponseCode;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = validateEmailOtpResponse.mState;
        }
        return validateEmailOtpResponse.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.mStatus;
    }

    public final String component2() {
        return this.mError;
    }

    public final String component3() {
        return this.mTitle;
    }

    public final String component4() {
        return this.mMessage;
    }

    public final String component5() {
        return this.mResponseCode;
    }

    public final String component6() {
        return this.mState;
    }

    public final ValidateEmailOtpResponse copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new ValidateEmailOtpResponse(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidateEmailOtpResponse)) {
            return false;
        }
        ValidateEmailOtpResponse validateEmailOtpResponse = (ValidateEmailOtpResponse) obj;
        return k.a((Object) this.mStatus, (Object) validateEmailOtpResponse.mStatus) && k.a((Object) this.mError, (Object) validateEmailOtpResponse.mError) && k.a((Object) this.mTitle, (Object) validateEmailOtpResponse.mTitle) && k.a((Object) this.mMessage, (Object) validateEmailOtpResponse.mMessage) && k.a((Object) this.mResponseCode, (Object) validateEmailOtpResponse.mResponseCode) && k.a((Object) this.mState, (Object) validateEmailOtpResponse.mState);
    }

    public final int hashCode() {
        String str = this.mStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mError;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mTitle;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mMessage;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mResponseCode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mState;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "ValidateEmailOtpResponse(mStatus=" + this.mStatus + ", mError=" + this.mError + ", mTitle=" + this.mTitle + ", mMessage=" + this.mMessage + ", mResponseCode=" + this.mResponseCode + ", mState=" + this.mState + ")";
    }

    public final String getMStatus() {
        return this.mStatus;
    }

    public final void setMStatus(String str) {
        this.mStatus = str;
    }

    public final String getMError() {
        return this.mError;
    }

    public final void setMError(String str) {
        this.mError = str;
    }

    public final String getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(String str) {
        this.mTitle = str;
    }

    public final String getMMessage() {
        return this.mMessage;
    }

    public final void setMMessage(String str) {
        this.mMessage = str;
    }

    public final String getMResponseCode() {
        return this.mResponseCode;
    }

    public final void setMResponseCode(String str) {
        this.mResponseCode = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ValidateEmailOtpResponse(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.updateInfo.model.ValidateEmailOtpResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMState() {
        return this.mState;
    }

    public final void setMState(String str) {
        this.mState = str;
    }

    public ValidateEmailOtpResponse(String str, String str2, String str3, String str4, String str5, String str6) {
        this.mStatus = str;
        this.mError = str2;
        this.mTitle = str3;
        this.mMessage = str4;
        this.mResponseCode = str5;
        this.mState = str6;
    }
}
