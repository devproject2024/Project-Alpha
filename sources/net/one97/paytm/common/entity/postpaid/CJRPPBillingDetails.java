package net.one97.paytm.common.entity.postpaid;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPPBillingDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "billDate")
    private String billDate;
    @b(a = "billDueInfo")
    private CJRPPBillingDueInfo billDueInfo;
    @b(a = "billEndDate")
    private String billEndDate;
    @b(a = "billStartDate")
    private String billStartDate;
    @b(a = "billTotalAmount")
    private Double billTotalAmount;
    @b(a = "billingMessage")
    private CJRPPBillingMessage billingMessage;
    @b(a = "cutOffDate")
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
