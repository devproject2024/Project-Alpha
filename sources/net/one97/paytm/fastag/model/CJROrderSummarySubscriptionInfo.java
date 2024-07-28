package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummarySubscriptionInfo extends IJRPaytmDataModel {
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
