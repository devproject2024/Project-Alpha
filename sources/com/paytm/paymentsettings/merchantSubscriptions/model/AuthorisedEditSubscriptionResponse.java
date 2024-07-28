package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private final AuthorisedEditSubscriptionResponseBody body;
    @b(a = "head")
    private final AuthorisedEditSubscriptionResponseHead head;

    public AuthorisedEditSubscriptionResponse() {
        this((AuthorisedEditSubscriptionResponseHead) null, (AuthorisedEditSubscriptionResponseBody) null, 3, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionResponse copy$default(AuthorisedEditSubscriptionResponse authorisedEditSubscriptionResponse, AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead, AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            authorisedEditSubscriptionResponseHead = authorisedEditSubscriptionResponse.head;
        }
        if ((i2 & 2) != 0) {
            authorisedEditSubscriptionResponseBody = authorisedEditSubscriptionResponse.body;
        }
        return authorisedEditSubscriptionResponse.copy(authorisedEditSubscriptionResponseHead, authorisedEditSubscriptionResponseBody);
    }

    public final AuthorisedEditSubscriptionResponseHead component1() {
        return this.head;
    }

    public final AuthorisedEditSubscriptionResponseBody component2() {
        return this.body;
    }

    public final AuthorisedEditSubscriptionResponse copy(AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead, AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody) {
        return new AuthorisedEditSubscriptionResponse(authorisedEditSubscriptionResponseHead, authorisedEditSubscriptionResponseBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionResponse)) {
            return false;
        }
        AuthorisedEditSubscriptionResponse authorisedEditSubscriptionResponse = (AuthorisedEditSubscriptionResponse) obj;
        return k.a((Object) this.head, (Object) authorisedEditSubscriptionResponse.head) && k.a((Object) this.body, (Object) authorisedEditSubscriptionResponse.body);
    }

    public final int hashCode() {
        AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead = this.head;
        int i2 = 0;
        int hashCode = (authorisedEditSubscriptionResponseHead != null ? authorisedEditSubscriptionResponseHead.hashCode() : 0) * 31;
        AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody = this.body;
        if (authorisedEditSubscriptionResponseBody != null) {
            i2 = authorisedEditSubscriptionResponseBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public final AuthorisedEditSubscriptionResponseHead getHead() {
        return this.head;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorisedEditSubscriptionResponse(AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead, AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : authorisedEditSubscriptionResponseHead, (i2 & 2) != 0 ? null : authorisedEditSubscriptionResponseBody);
    }

    public final AuthorisedEditSubscriptionResponseBody getBody() {
        return this.body;
    }

    public AuthorisedEditSubscriptionResponse(AuthorisedEditSubscriptionResponseHead authorisedEditSubscriptionResponseHead, AuthorisedEditSubscriptionResponseBody authorisedEditSubscriptionResponseBody) {
        this.head = authorisedEditSubscriptionResponseHead;
        this.body = authorisedEditSubscriptionResponseBody;
    }
}
