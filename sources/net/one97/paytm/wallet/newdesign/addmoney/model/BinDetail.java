package net.one97.paytm.wallet.newdesign.addmoney.model;

import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;

public class BinDetail {
    String active;
    String bank;
    String bankCode;
    String bin;
    String cardName;
    String cardType;
    private String channelName;
    HasLowSuccess hasLowSuccess;
    String instId;
    String isDebitEnabled;
    String isIndian;
    String issuingBank;
    String issuingBankCode;
    String orderId;
    private String paymentMode;
    String wapLogo;
    String webLogo;

    public String getBin() {
        return this.bin;
    }

    public String getIsIndian() {
        return this.isIndian;
    }

    public String getBank() {
        return this.bank;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getInstId() {
        return this.instId;
    }

    public String getActive() {
        return this.active;
    }

    public String getIsDebitEnabled() {
        return this.isDebitEnabled;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getWebLogo() {
        return this.webLogo;
    }

    public String getWapLogo() {
        return this.wapLogo;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getIssuingBank() {
        return this.issuingBank;
    }

    public void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public String getIssuingBankCode() {
        return this.issuingBankCode;
    }

    public void setIssuingBankCode(String str) {
        this.issuingBankCode = str;
    }
}
