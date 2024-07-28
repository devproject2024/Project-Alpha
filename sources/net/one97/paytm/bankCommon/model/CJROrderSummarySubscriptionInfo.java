package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummarySubscriptionInfo implements IJRDataModel {
    @b(a = "amount")
    private long mAmount;
    @b(a = "expiryDate")
    private String mExpiryDate;
    @b(a = "interval")
    private int mInterval;

    public int getInterval() {
        return this.mInterval;
    }

    public String getExpiryDate() {
        return this.mExpiryDate;
    }

    public long getSubscriptionAmount() {
        return this.mAmount;
    }
}
