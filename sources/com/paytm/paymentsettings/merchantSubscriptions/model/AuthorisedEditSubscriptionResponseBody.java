package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionResponseBody extends IJRPaytmDataModel {
    @b(a = "resultInfo")
    private final AuthorisedEditSubscriptionResponseResultInfo resultInfo;
    @b(a = "subscriptionStatus")
    private final String subscriptionStatus;

    public AuthorisedEditSubscriptionResponseBody() {
        this((String) null, (AuthorisedEditSubscriptionResponseResultInfo) null, 3, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionResponseBody copy$default(AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody, String str, AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authorisedEditSubscriptionResponseBody.subscriptionStatus;
        }
        if ((i2 & 2) != 0) {
            authorisedEditSubscriptionResponseResultInfo = authorisedEditSubscriptionResponseBody.resultInfo;
        }
        return authorisedEditSubscriptionResponseBody.copy(str, authorisedEditSubscriptionResponseResultInfo);
    }

    public final String component1() {
        return this.subscriptionStatus;
    }

    public final AuthorisedEditSubscriptionResponseResultInfo component2() {
        return this.resultInfo;
    }

    public final AuthorisedEditSubscriptionResponseBody copy(String str, AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo) {
        return new AuthorisedEditSubscriptionResponseBody(str, authorisedEditSubscriptionResponseResultInfo);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionResponseBody)) {
            return false;
        }
        AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody = (AuthorisedEditSubscriptionResponseBody) obj;
        return k.a((Object) this.subscriptionStatus, (Object) authorisedEditSubscriptionResponseBody.subscriptionStatus) && k.a((Object) this.resultInfo, (Object) authorisedEditSubscriptionResponseBody.resultInfo);
    }

    public final int hashCode() {
        String str = this.subscriptionStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo = this.resultInfo;
        if (authorisedEditSubscriptionResponseResultInfo != null) {
            i2 = authorisedEditSubscriptionResponseResultInfo.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionResponseBody(subscriptionStatus=" + this.subscriptionStatus + ", resultInfo=" + this.resultInfo + ")";
    }

    public final String getSubscriptionStatus() {
        return this.subscriptionStatus;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorisedEditSubscriptionResponseBody(String str, AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : authorisedEditSubscriptionResponseResultInfo);
    }

    public final AuthorisedEditSubscriptionResponseResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public AuthorisedEditSubscriptionResponseBody(String str, AuthorisedEditSubscriptionResponseResultInfo authorisedEditSubscriptionResponseResultInfo) {
        this.subscriptionStatus = str;
        this.resultInfo = authorisedEditSubscriptionResponseResultInfo;
    }
}
