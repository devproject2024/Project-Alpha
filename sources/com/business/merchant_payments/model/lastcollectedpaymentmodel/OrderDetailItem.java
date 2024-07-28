package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import com.business.merchant_payments.model.BaseModel;

public class OrderDetailItem extends BaseModel {
    public String commission;
    public boolean convFeeVO;
    public String extEmail;
    public String extPhone;
    public String mid;
    public String orderId;
    public String paymentMode;
    public boolean postConv;
    public String sTax;
    public String settledAmt;
    public String settledDate;
    public String txnAmt;
    public String utrNo;

    public String getsTax() {
        return this.sTax;
    }

    public String getSettledAmt() {
        return this.settledAmt;
    }

    public String getExtEmail() {
        return this.extEmail;
    }

    public String getExtPhone() {
        return this.extPhone;
    }

    public String getUtrNo() {
        return this.utrNo;
    }

    public String getSettledDate() {
        return this.settledDate;
    }

    public String getCommission() {
        return this.commission;
    }

    public String getTxnAmt() {
        return this.txnAmt;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public String getMid() {
        return this.mid;
    }

    public boolean isPostConv() {
        return this.postConv;
    }

    public boolean isConvFeeVO() {
        return this.convFeeVO;
    }
}
