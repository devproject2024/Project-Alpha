package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionRequestBody extends IJRPaytmDataModel {
    @b(a = "mid")
    private final String mid;
    @b(a = "otp")
    private final String otp;
    @b(a = "state")
    private final String state;

    public AuthorisedEditSubscriptionRequestBody() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionRequestBody copy$default(AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authorisedEditSubscriptionRequestBody.mid;
        }
        if ((i2 & 2) != 0) {
            str2 = authorisedEditSubscriptionRequestBody.state;
        }
        if ((i2 & 4) != 0) {
            str3 = authorisedEditSubscriptionRequestBody.otp;
        }
        return authorisedEditSubscriptionRequestBody.copy(str, str2, str3);
    }

    public final String component1() {
        return this.mid;
    }

    public final String component2() {
        return this.state;
    }

    public final String component3() {
        return this.otp;
    }

    public final AuthorisedEditSubscriptionRequestBody copy(String str, String str2, String str3) {
        return new AuthorisedEditSubscriptionRequestBody(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionRequestBody)) {
            return false;
        }
        AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody = (AuthorisedEditSubscriptionRequestBody) obj;
        return k.a((Object) this.mid, (Object) authorisedEditSubscriptionRequestBody.mid) && k.a((Object) this.state, (Object) authorisedEditSubscriptionRequestBody.state) && k.a((Object) this.otp, (Object) authorisedEditSubscriptionRequestBody.otp);
    }

    public final int hashCode() {
        String str = this.mid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.state;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.otp;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionRequestBody(mid=" + this.mid + ", state=" + this.state + ", otp=" + this.otp + ")";
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getState() {
        return this.state;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorisedEditSubscriptionRequestBody(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getOtp() {
        return this.otp;
    }

    public AuthorisedEditSubscriptionRequestBody(String str, String str2, String str3) {
        this.mid = str;
        this.state = str2;
        this.otp = str3;
    }
}
