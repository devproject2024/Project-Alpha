package net.one97.paytm.common.entity.trustlist;

public class TxnInfo {
    private String deviceId;
    private String eventAmount;
    private String eventAmountCurrency;
    private String eventLinkId;
    private String otpValue;
    private String txnDatetime;
    private String txnId;
    private String userId;

    public String getOtpValue() {
        return this.otpValue;
    }

    public void setOtpValue(String str) {
        this.otpValue = str;
    }

    public String getEventAmount() {
        return this.eventAmount;
    }

    public void setEventAmount(String str) {
        this.eventAmount = str;
    }

    public String getEventAmountCurrency() {
        return this.eventAmountCurrency;
    }

    public void setEventAmountCurrency(String str) {
        this.eventAmountCurrency = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getTxnDatetime() {
        return this.txnDatetime;
    }

    public void setTxnDatetime(String str) {
        this.txnDatetime = str;
    }

    public String getEventLinkId() {
        return this.eventLinkId;
    }

    public void setEventLinkId(String str) {
        this.eventLinkId = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }
}
