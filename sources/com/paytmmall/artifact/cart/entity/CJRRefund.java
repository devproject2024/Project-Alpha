package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRefund extends IJRPaytmDataModel {
    @b(a = "refund_initiated")
    boolean refundInitiated = false;
    @b(a = "status_text")
    private String status_text;
    @b(a = "total")
    private double totalRefund;

    public String getStatus_text() {
        return this.status_text;
    }

    public double getTotalRefund() {
        return this.totalRefund;
    }

    public boolean isRefundInitiated() {
        return this.refundInitiated;
    }
}
