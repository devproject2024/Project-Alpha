package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SubscriptionResponse extends IJRDataModel {
    @b(a = "statusOfSubscription")
    private final String statusOfSubscription;

    public SubscriptionResponse() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ SubscriptionResponse copy$default(SubscriptionResponse subscriptionResponse, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subscriptionResponse.statusOfSubscription;
        }
        return subscriptionResponse.copy(str);
    }

    public final String component1() {
        return this.statusOfSubscription;
    }

    public final SubscriptionResponse copy(String str) {
        return new SubscriptionResponse(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SubscriptionResponse) && k.a((Object) this.statusOfSubscription, (Object) ((SubscriptionResponse) obj).statusOfSubscription);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.statusOfSubscription;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SubscriptionResponse(statusOfSubscription=" + this.statusOfSubscription + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionResponse(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getStatusOfSubscription() {
        return this.statusOfSubscription;
    }

    public SubscriptionResponse(String str) {
        this.statusOfSubscription = str;
    }
}
