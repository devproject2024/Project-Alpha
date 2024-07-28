package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Subscription extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "is_applicable")
    private Boolean isApplicable;
    @b(a = "is_subscribed")
    private Boolean isSubscribed;

    public Subscription() {
        this((Boolean) null, (Boolean) null, 3, (g) null);
    }

    public static /* synthetic */ Subscription copy$default(Subscription subscription, Boolean bool, Boolean bool2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = subscription.isApplicable;
        }
        if ((i2 & 2) != 0) {
            bool2 = subscription.isSubscribed;
        }
        return subscription.copy(bool, bool2);
    }

    public final Boolean component1() {
        return this.isApplicable;
    }

    public final Boolean component2() {
        return this.isSubscribed;
    }

    public final Subscription copy(Boolean bool, Boolean bool2) {
        return new Subscription(bool, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return k.a((Object) this.isApplicable, (Object) subscription.isApplicable) && k.a((Object) this.isSubscribed, (Object) subscription.isSubscribed);
    }

    public final int hashCode() {
        Boolean bool = this.isApplicable;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isSubscribed;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Subscription(isApplicable=" + this.isApplicable + ", isSubscribed=" + this.isSubscribed + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Boolean isApplicable() {
        return this.isApplicable;
    }

    public final void setApplicable(Boolean bool) {
        this.isApplicable = bool;
    }

    public Subscription(Boolean bool, Boolean bool2) {
        this.isApplicable = bool;
        this.isSubscribed = bool2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Subscription(Boolean bool, Boolean bool2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? null : bool2);
    }

    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setSubscribed(Boolean bool) {
        this.isSubscribed = bool;
    }
}
