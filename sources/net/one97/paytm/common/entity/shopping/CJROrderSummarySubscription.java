package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummarySubscription implements IJRDataModel {
    @b(a = "is_applicable")
    private boolean mIsApplicable;
    @b(a = "is_available")
    private boolean mIsAvailable;
    @b(a = "is_subscribed")
    private boolean mIsSubscribed;
    @b(a = "info")
    private CJROrderSummarySubscriptionInfo mSubscriptionInfo;

    public boolean getIsAvailable() {
        return this.mIsAvailable;
    }

    public boolean getIsSubscribed() {
        return this.mIsSubscribed;
    }

    public CJROrderSummarySubscriptionInfo getSubscriptionInfo() {
        return this.mSubscriptionInfo;
    }

    public boolean getIsApplicable() {
        return this.mIsApplicable;
    }
}
