package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionRequest extends IJRPaytmDataModel {
    @b(a = "body")
    private final AuthorisedEditSubscriptionRequestBody body;
    @b(a = "head")
    private final AuthorisedEditSubscriptionRequestHead head;

    public AuthorisedEditSubscriptionRequest() {
        this((AuthorisedEditSubscriptionRequestHead) null, (AuthorisedEditSubscriptionRequestBody) null, 3, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionRequest copy$default(AuthorisedEditSubscriptionRequest authorisedEditSubscriptionRequest, AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            authorisedEditSubscriptionRequestHead = authorisedEditSubscriptionRequest.head;
        }
        if ((i2 & 2) != 0) {
            authorisedEditSubscriptionRequestBody = authorisedEditSubscriptionRequest.body;
        }
        return authorisedEditSubscriptionRequest.copy(authorisedEditSubscriptionRequestHead, authorisedEditSubscriptionRequestBody);
    }

    public final AuthorisedEditSubscriptionRequestHead component1() {
        return this.head;
    }

    public final AuthorisedEditSubscriptionRequestBody component2() {
        return this.body;
    }

    public final AuthorisedEditSubscriptionRequest copy(AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody) {
        return new AuthorisedEditSubscriptionRequest(authorisedEditSubscriptionRequestHead, authorisedEditSubscriptionRequestBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionRequest)) {
            return false;
        }
        AuthorisedEditSubscriptionRequest authorisedEditSubscriptionRequest = (AuthorisedEditSubscriptionRequest) obj;
        return k.a((Object) this.head, (Object) authorisedEditSubscriptionRequest.head) && k.a((Object) this.body, (Object) authorisedEditSubscriptionRequest.body);
    }

    public final int hashCode() {
        AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead = this.head;
        int i2 = 0;
        int hashCode = (authorisedEditSubscriptionRequestHead != null ? authorisedEditSubscriptionRequestHead.hashCode() : 0) * 31;
        AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody = this.body;
        if (authorisedEditSubscriptionRequestBody != null) {
            i2 = authorisedEditSubscriptionRequestBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionRequest(head=" + this.head + ", body=" + this.body + ")";
    }

    public final AuthorisedEditSubscriptionRequestHead getHead() {
        return this.head;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorisedEditSubscriptionRequest(AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : authorisedEditSubscriptionRequestHead, (i2 & 2) != 0 ? null : authorisedEditSubscriptionRequestBody);
    }

    public final AuthorisedEditSubscriptionRequestBody getBody() {
        return this.body;
    }

    public AuthorisedEditSubscriptionRequest(AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody) {
        this.head = authorisedEditSubscriptionRequestHead;
        this.body = authorisedEditSubscriptionRequestBody;
    }
}
