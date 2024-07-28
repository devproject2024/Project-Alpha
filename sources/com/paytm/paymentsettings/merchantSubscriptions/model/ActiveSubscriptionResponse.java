package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private ActiveSubscriptionsBody body;
    @b(a = "head")
    private ActiveSubscriptionsHead head;

    public ActiveSubscriptionResponse() {
        this((ActiveSubscriptionsHead) null, (ActiveSubscriptionsBody) null, 3, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionResponse copy$default(ActiveSubscriptionResponse activeSubscriptionResponse, ActiveSubscriptionsHead activeSubscriptionsHead, ActiveSubscriptionsBody activeSubscriptionsBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activeSubscriptionsHead = activeSubscriptionResponse.head;
        }
        if ((i2 & 2) != 0) {
            activeSubscriptionsBody = activeSubscriptionResponse.body;
        }
        return activeSubscriptionResponse.copy(activeSubscriptionsHead, activeSubscriptionsBody);
    }

    public final ActiveSubscriptionsHead component1() {
        return this.head;
    }

    public final ActiveSubscriptionsBody component2() {
        return this.body;
    }

    public final ActiveSubscriptionResponse copy(ActiveSubscriptionsHead activeSubscriptionsHead, ActiveSubscriptionsBody activeSubscriptionsBody) {
        return new ActiveSubscriptionResponse(activeSubscriptionsHead, activeSubscriptionsBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionResponse)) {
            return false;
        }
        ActiveSubscriptionResponse activeSubscriptionResponse = (ActiveSubscriptionResponse) obj;
        return k.a((Object) this.head, (Object) activeSubscriptionResponse.head) && k.a((Object) this.body, (Object) activeSubscriptionResponse.body);
    }

    public final int hashCode() {
        ActiveSubscriptionsHead activeSubscriptionsHead = this.head;
        int i2 = 0;
        int hashCode = (activeSubscriptionsHead != null ? activeSubscriptionsHead.hashCode() : 0) * 31;
        ActiveSubscriptionsBody activeSubscriptionsBody = this.body;
        if (activeSubscriptionsBody != null) {
            i2 = activeSubscriptionsBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public final ActiveSubscriptionsHead getHead() {
        return this.head;
    }

    public final void setHead(ActiveSubscriptionsHead activeSubscriptionsHead) {
        this.head = activeSubscriptionsHead;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionResponse(ActiveSubscriptionsHead activeSubscriptionsHead, ActiveSubscriptionsBody activeSubscriptionsBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : activeSubscriptionsHead, (i2 & 2) != 0 ? null : activeSubscriptionsBody);
    }

    public final ActiveSubscriptionsBody getBody() {
        return this.body;
    }

    public final void setBody(ActiveSubscriptionsBody activeSubscriptionsBody) {
        this.body = activeSubscriptionsBody;
    }

    public ActiveSubscriptionResponse(ActiveSubscriptionsHead activeSubscriptionsHead, ActiveSubscriptionsBody activeSubscriptionsBody) {
        this.head = activeSubscriptionsHead;
        this.body = activeSubscriptionsBody;
    }
}
