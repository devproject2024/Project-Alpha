package net.one97.paytm.nativesdk.common.model;

public class RiskConvenienceFeeItem implements BaseDataModel {
    private String feePercent;
    private String payMethod;
    private String reason;

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getFeePercent() {
        return this.feePercent;
    }

    public void setFeePercent(String str) {
        this.feePercent = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
