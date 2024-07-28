package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionRequest extends IJRPaytmDataModel {
    @b(a = "body")
    private final ActiveSubscriptionRequestBody body;
    @b(a = "head")
    private final ActiveSubscriptionRequestHead head;

    public ActiveSubscriptionRequest() {
        this((ActiveSubscriptionRequestHead) null, (ActiveSubscriptionRequestBody) null, 3, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionRequest copy$default(ActiveSubscriptionRequest activeSubscriptionRequest, ActiveSubscriptionRequestHead activeSubscriptionRequestHead, ActiveSubscriptionRequestBody activeSubscriptionRequestBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activeSubscriptionRequestHead = activeSubscriptionRequest.head;
        }
        if ((i2 & 2) != 0) {
            activeSubscriptionRequestBody = activeSubscriptionRequest.body;
        }
        return activeSubscriptionRequest.copy(activeSubscriptionRequestHead, activeSubscriptionRequestBody);
    }

    public final ActiveSubscriptionRequestHead component1() {
        return this.head;
    }

    public final ActiveSubscriptionRequestBody component2() {
        return this.body;
    }

    public final ActiveSubscriptionRequest copy(ActiveSubscriptionRequestHead activeSubscriptionRequestHead, ActiveSubscriptionRequestBody activeSubscriptionRequestBody) {
        return new ActiveSubscriptionRequest(activeSubscriptionRequestHead, activeSubscriptionRequestBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionRequest)) {
            return false;
        }
        ActiveSubscriptionRequest activeSubscriptionRequest = (ActiveSubscriptionRequest) obj;
        return k.a((Object) this.head, (Object) activeSubscriptionRequest.head) && k.a((Object) this.body, (Object) activeSubscriptionRequest.body);
    }

    public final int hashCode() {
        ActiveSubscriptionRequestHead activeSubscriptionRequestHead = this.head;
        int i2 = 0;
        int hashCode = (activeSubscriptionRequestHead != null ? activeSubscriptionRequestHead.hashCode() : 0) * 31;
        ActiveSubscriptionRequestBody activeSubscriptionRequestBody = this.body;
        if (activeSubscriptionRequestBody != null) {
            i2 = activeSubscriptionRequestBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionRequest(head=" + this.head + ", body=" + this.body + ")";
    }

    public final ActiveSubscriptionRequestHead getHead() {
        return this.head;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionRequest(ActiveSubscriptionRequestHead activeSubscriptionRequestHead, ActiveSubscriptionRequestBody activeSubscriptionRequestBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : activeSubscriptionRequestHead, (i2 & 2) != 0 ? null : activeSubscriptionRequestBody);
    }

    public final ActiveSubscriptionRequestBody getBody() {
        return this.body;
    }

    public ActiveSubscriptionRequest(ActiveSubscriptionRequestHead activeSubscriptionRequestHead, ActiveSubscriptionRequestBody activeSubscriptionRequestBody) {
        this.head = activeSubscriptionRequestHead;
        this.body = activeSubscriptionRequestBody;
    }
}
