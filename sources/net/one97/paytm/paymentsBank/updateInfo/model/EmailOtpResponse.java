package net.one97.paytm.paymentsBank.updateInfo.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class EmailOtpResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error")
    private final String error;
    @b(a = "responseCode")
    private final String mResponseCode;
    @b(a = "message")
    private final String message;
    @b(a = "state")
    private final String state;
    @b(a = "status")
    private final String status;
    @b(a = "title")
    private final String title;

    public EmailOtpResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ EmailOtpResponse copy$default(EmailOtpResponse emailOtpResponse, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = emailOtpResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = emailOtpResponse.error;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = emailOtpResponse.title;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = emailOtpResponse.message;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = emailOtpResponse.mResponseCode;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = emailOtpResponse.state;
        }
        return emailOtpResponse.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.error;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.message;
    }

    public final String component5() {
        return this.mResponseCode;
    }

    public final String component6() {
        return this.state;
    }

    public final EmailOtpResponse copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new EmailOtpResponse(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmailOtpResponse)) {
            return false;
        }
        EmailOtpResponse emailOtpResponse = (EmailOtpResponse) obj;
        return k.a((Object) this.status, (Object) emailOtpResponse.status) && k.a((Object) this.error, (Object) emailOtpResponse.error) && k.a((Object) this.title, (Object) emailOtpResponse.title) && k.a((Object) this.message, (Object) emailOtpResponse.message) && k.a((Object) this.mResponseCode, (Object) emailOtpResponse.mResponseCode) && k.a((Object) this.state, (Object) emailOtpResponse.state);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.error;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.message;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mResponseCode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.state;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "EmailOtpResponse(status=" + this.status + ", error=" + this.error + ", title=" + this.title + ", message=" + this.message + ", mResponseCode=" + this.mResponseCode + ", state=" + this.state + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getError() {
        return this.error;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMResponseCode() {
        return this.mResponseCode;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EmailOtpResponse(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.updateInfo.model.EmailOtpResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getState() {
        return this.state;
    }

    public EmailOtpResponse(String str, String str2, String str3, String str4, String str5, String str6) {
        this.status = str;
        this.error = str2;
        this.title = str3;
        this.message = str4;
        this.mResponseCode = str5;
        this.state = str6;
    }
}
