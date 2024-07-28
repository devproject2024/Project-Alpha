package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusReviewCancellationPolicyOnward implements IJRDataModel {
    @b(a = "cancellation_policy")
    private ArrayList<CJRBusCancellationPolicy> newOrderSummaryCancellationPolicy;
    @b(a = "cancellationPolicyJSON")
    private ArrayList<CJRBusSearchCancellationPolicy> oldOrderSummaryCancellationPolicy;

    public ArrayList<CJRBusCancellationPolicy> getNewOrderSummaryCancellationPolicy() {
        return this.newOrderSummaryCancellationPolicy;
    }

    public void setNewOrderSummaryCancellationPolicy(ArrayList<CJRBusCancellationPolicy> arrayList) {
        this.newOrderSummaryCancellationPolicy = arrayList;
    }

    public ArrayList<CJRBusSearchCancellationPolicy> getOldOrderSummaryCancellationPolicy() {
        return this.oldOrderSummaryCancellationPolicy;
    }

    public void setOldOrderSummaryCancellationPolicy(ArrayList<CJRBusSearchCancellationPolicy> arrayList) {
        this.oldOrderSummaryCancellationPolicy = arrayList;
    }
}
