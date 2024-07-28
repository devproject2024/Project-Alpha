package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionResponseResultInfo extends IJRPaytmDataModel {
    @b(a = "code")
    private final String code;
    @b(a = "message")
    private final String message;
    @b(a = "status")
    private final String status;

    public AuthorisedEditSubscriptionResponseResultInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionResponseResultInfo copy$default(AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authorisedEditSubscriptionResponseResultInfo.code;
        }
        if ((i2 & 2) != 0) {
            str2 = authorisedEditSubscriptionResponseResultInfo.message;
        }
        if ((i2 & 4) != 0) {
            str3 = authorisedEditSubscriptionResponseResultInfo.status;
        }
        return authorisedEditSubscriptionResponseResultInfo.copy(str, str2, str3);
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

    public final AuthorisedEditSubscriptionResponseResultInfo copy(String str, String str2, String str3) {
        return new AuthorisedEditSubscriptionResponseResultInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionResponseResultInfo)) {
            return false;
        }
        AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo = (AuthorisedEditSubscriptionResponseResultInfo) obj;
        return k.a((Object) this.code, (Object) authorisedEditSubscriptionResponseResultInfo.code) && k.a((Object) this.message, (Object) authorisedEditSubscriptionResponseResultInfo.message) && k.a((Object) this.status, (Object) authorisedEditSubscriptionResponseResultInfo.status);
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
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionResponseResultInfo(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorisedEditSubscriptionResponseResultInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getStatus() {
        return this.status;
    }

    public AuthorisedEditSubscriptionResponseResultInfo(String str, String str2, String str3) {
        this.code = str;
        this.message = str2;
        this.status = str3;
    }
}
