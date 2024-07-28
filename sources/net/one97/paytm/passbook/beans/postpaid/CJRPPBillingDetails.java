package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPBillingDetails extends IJRDataModel {
    @c(a = "billDate")
    private String billDate;
    @c(a = "billDueInfo")
    private CJRPPBillingDueInfo billDueInfo;
    @c(a = "billEndDate")
    private String billEndDate;
    @c(a = "billStartDate")
    private String billStartDate;
    @c(a = "billTotalAmount")
    private Double billTotalAmount;
    @c(a = "billingMessage")
    private CJRPPBillingMessage billingMessage;
    @c(a = "cutOffDate")
    private String cutOffDate;

    public final String getBillStartDate() {
        return this.billStartDate;
    }

    public final void setBillStartDate(String str) {
        this.billStartDate = str;
    }

    public final String getBillEndDate() {
        return this.billEndDate;
    }

    public final void setBillEndDate(String str) {
        this.billEndDate = str;
    }

    public final String getCutOffDate() {
        return this.cutOffDate;
    }

    public final void setCutOffDate(String str) {
        this.cutOffDate = str;
    }

    public final Double getBillTotalAmount() {
        return this.billTotalAmount;
    }

    public final void setBillTotalAmount(Double d2) {
        this.billTotalAmount = d2;
    }

    public final String getBillDate() {
        return this.billDate;
    }

    public final void setBillDate(String str) {
        this.billDate = str;
    }

    public final CJRPPBillingDueInfo getBillDueInfo() {
        return this.billDueInfo;
    }

    public final void setBillDueInfo(CJRPPBillingDueInfo cJRPPBillingDueInfo) {
        this.billDueInfo = cJRPPBillingDueInfo;
    }

    public final CJRPPBillingMessage getBillingMessage() {
        return this.billingMessage;
    }

    public final void setBillingMessage(CJRPPBillingMessage cJRPPBillingMessage) {
        this.billingMessage = cJRPPBillingMessage;
    }
}
