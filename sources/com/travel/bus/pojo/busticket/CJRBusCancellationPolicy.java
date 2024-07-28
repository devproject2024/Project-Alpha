package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusCancellationPolicy implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cancellation_time")
    private String cancellationTime;
    @b(a = "policy_text")
    private String policyText;
    @b(a = "refund_amount")
    private String refundAmount;
    @b(a = "refund_percentage")
    private String refundPercentage;

    public String getRefundPercentage() {
        return this.refundPercentage;
    }

    public void setRefundPercentage(String str) {
        this.refundPercentage = str;
    }

    public String getPolicyText() {
        return this.policyText;
    }

    public void setPolicyText(String str) {
        this.policyText = str;
    }

    public String getRefundAmount() {
        return this.refundAmount;
    }

    public void setRefundAmount(String str) {
        this.refundAmount = str;
    }

    public String getCancellationTime() {
        return this.cancellationTime;
    }

    public void setCancellationTime(String str) {
        this.cancellationTime = str;
    }
}
