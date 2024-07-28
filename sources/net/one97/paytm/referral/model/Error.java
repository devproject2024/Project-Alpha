package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Error extends IJRPaytmDataModel {
    @b(a = "code")
    private String code;
    @b(a = "errorCode")
    private String errorCode;
    @b(a = "message")
    private String message;
    @b(a = "status")
    private String status;
    @b(a = "title")
    private String title;

    public Error() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = error.status;
        }
        if ((i2 & 2) != 0) {
            str2 = error.code;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = error.message;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = error.title;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = error.errorCode;
        }
        return error.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.errorCode;
    }

    public final Error copy(String str, String str2, String str3, String str4, String str5) {
        return new Error(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Error)) {
            return false;
        }
        Error error = (Error) obj;
        return k.a((Object) this.status, (Object) error.status) && k.a((Object) this.code, (Object) error.code) && k.a((Object) this.message, (Object) error.message) && k.a((Object) this.title, (Object) error.title) && k.a((Object) this.errorCode, (Object) error.errorCode);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.errorCode;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "Error(status=" + this.status + ", code=" + this.code + ", message=" + this.message + ", title=" + this.title + ", errorCode=" + this.errorCode + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
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

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Error(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.model.Error.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    public Error(String str, String str2, String str3, String str4, String str5) {
        this.status = str;
        this.code = str2;
        this.message = str3;
        this.title = str4;
        this.errorCode = str5;
    }
}
