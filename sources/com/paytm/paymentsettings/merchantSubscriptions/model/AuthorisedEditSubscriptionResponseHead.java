package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionResponseHead extends IJRPaytmDataModel {
    @b(a = "clientId")
    private final String clientId;
    @b(a = "timestamp")
    private final String timestamp;

    public AuthorisedEditSubscriptionResponseHead() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionResponseHead copy$default(AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authorisedEditSubscriptionResponseHead.clientId;
        }
        if ((i2 & 2) != 0) {
            str2 = authorisedEditSubscriptionResponseHead.timestamp;
        }
        return authorisedEditSubscriptionResponseHead.copy(str, str2);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.timestamp;
    }

    public final AuthorisedEditSubscriptionResponseHead copy(String str, String str2) {
        return new AuthorisedEditSubscriptionResponseHead(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionResponseHead)) {
            return false;
        }
        AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead = (AuthorisedEditSubscriptionResponseHead) obj;
        return k.a((Object) this.clientId, (Object) authorisedEditSubscriptionResponseHead.clientId) && k.a((Object) this.timestamp, (Object) authorisedEditSubscriptionResponseHead.timestamp);
    }

    public final int hashCode() {
        String str = this.clientId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.timestamp;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionResponseHead(clientId=" + this.clientId + ", timestamp=" + this.timestamp + ")";
    }

    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorisedEditSubscriptionResponseHead(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public AuthorisedEditSubscriptionResponseHead(String str, String str2) {
        this.clientId = str;
        this.timestamp = str2;
    }
}
