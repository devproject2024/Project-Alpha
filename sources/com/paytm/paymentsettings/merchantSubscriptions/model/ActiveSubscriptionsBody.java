package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionsBody extends IJRPaytmDataModel {
    @b(a = "resultInfo")
    private ActiveSubscriptionsResultInfo resultInfo;
    @b(a = "subscriptionDetails")
    private List<ActiveSubscriptionDetailsItem> subscriptionDetails;

    public ActiveSubscriptionsBody() {
        this((List) null, (ActiveSubscriptionsResultInfo) null, 3, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionsBody copy$default(ActiveSubscriptionsBody activeSubscriptionsBody, List<ActiveSubscriptionDetailsItem> list, ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = activeSubscriptionsBody.subscriptionDetails;
        }
        if ((i2 & 2) != 0) {
            activeSubscriptionsResultInfo = activeSubscriptionsBody.resultInfo;
        }
        return activeSubscriptionsBody.copy(list, activeSubscriptionsResultInfo);
    }

    public final List<ActiveSubscriptionDetailsItem> component1() {
        return this.subscriptionDetails;
    }

    public final ActiveSubscriptionsResultInfo component2() {
        return this.resultInfo;
    }

    public final ActiveSubscriptionsBody copy(List<ActiveSubscriptionDetailsItem> list, ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo) {
        return new ActiveSubscriptionsBody(list, activeSubscriptionsResultInfo);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionsBody)) {
            return false;
        }
        ActiveSubscriptionsBody activeSubscriptionsBody = (ActiveSubscriptionsBody) obj;
        return k.a((Object) this.subscriptionDetails, (Object) activeSubscriptionsBody.subscriptionDetails) && k.a((Object) this.resultInfo, (Object) activeSubscriptionsBody.resultInfo);
    }

    public final int hashCode() {
        List<ActiveSubscriptionDetailsItem> list = this.subscriptionDetails;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo = this.resultInfo;
        if (activeSubscriptionsResultInfo != null) {
            i2 = activeSubscriptionsResultInfo.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionsBody(subscriptionDetails=" + this.subscriptionDetails + ", resultInfo=" + this.resultInfo + ")";
    }

    public final List<ActiveSubscriptionDetailsItem> getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final void setSubscriptionDetails(List<ActiveSubscriptionDetailsItem> list) {
        this.subscriptionDetails = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionsBody(List list, ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : activeSubscriptionsResultInfo);
    }

    public final ActiveSubscriptionsResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo) {
        this.resultInfo = activeSubscriptionsResultInfo;
    }

    public ActiveSubscriptionsBody(List<ActiveSubscriptionDetailsItem> list, ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo) {
        this.subscriptionDetails = list;
        this.resultInfo = activeSubscriptionsResultInfo;
    }
}
