package com.business.merchant_payments.model.initiaterefundmodel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;

public class InitiateRefundResponse extends BaseModel {
    @c(a = "refundTxnGuid")
    public String refundTxnGuid;
    @c(a = "refundTxnStatus")
    public String refundTxnStatus;

    public String getRefundTxnGuid() {
        return this.refundTxnGuid;
    }

    public void setRefundTxnGuid(String str) {
        this.refundTxnGuid = str;
    }

    public String getRefundTxnStatus() {
        return this.refundTxnStatus;
    }

    public void setRefundTxnStatus(String str) {
        this.refundTxnStatus = str;
    }
}
