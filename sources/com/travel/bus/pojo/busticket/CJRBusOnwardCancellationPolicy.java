package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusOnwardCancellationPolicy implements IJRDataModel {
    @b(a = "cancellation_policy_note_text")
    private ArrayList<String> cjrBusCancellationPolicyNoteTexts;
    @b(a = "is_non_refundable")
    private boolean isNonRefundable;
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

    public boolean isNonRefundable() {
        return this.isNonRefundable;
    }

    public void setNonRefundable(boolean z) {
        this.isNonRefundable = z;
    }

    public ArrayList<String> getCjrBusCancellationPolicyNoteTexts() {
        return this.cjrBusCancellationPolicyNoteTexts;
    }

    public void setCjrBusCancellationPolicyNoteTexts(ArrayList<String> arrayList) {
        this.cjrBusCancellationPolicyNoteTexts = arrayList;
    }
}
