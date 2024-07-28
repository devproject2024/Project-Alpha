package net.one97.paytm.nativesdk.paymethods.model;

import java.io.Serializable;

public class PaytmAssistParams implements Serializable {
    private String bankCode;
    private String cardType;
    private String payType;

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setPayType(String str) {
        this.payType = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }
}
