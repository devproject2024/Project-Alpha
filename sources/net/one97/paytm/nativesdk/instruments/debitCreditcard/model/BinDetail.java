package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class BinDetail implements BaseDataModel {
    @c(a = "bin")
    @a
    private String bin;
    @c(a = "cnMax")
    @a
    private String cardNumberMaxLength;
    @c(a = "cnMin")
    @a
    private String cardNumberMinLength;
    @c(a = "channelCode")
    @a
    private String channelCode;
    @c(a = "channelName")
    @a
    private String channelName;
    @c(a = "cvvL")
    @a
    private String cvvLength;
    @c(a = "cvvR")
    @a
    private String cvvRequired;
    @c(a = "expR")
    @a
    private String expiryRequired;
    @c(a = "iconUrl")
    @a
    private String iconUrl;
    @c(a = "isActive")
    @a
    private String isActive;
    private String isIndian;
    @c(a = "issuingBank")
    @a
    private String issuingBank;
    @c(a = "issuingBankCode")
    @a
    private String issuingBankCode;
    @c(a = "paymentMode")
    @a
    private String paymentMode;

    public String getBin() {
        return this.bin;
    }

    public void setBin(String str) {
        this.bin = str;
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

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String str) {
        this.isActive = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getCardNumberMinLength() {
        return this.cardNumberMinLength;
    }

    public void setCardNumberMinLength(String str) {
        this.cardNumberMinLength = str;
    }

    public String getCardNumberMaxLength() {
        return this.cardNumberMaxLength;
    }

    public void setCardNumberMaxLength(String str) {
        this.cardNumberMaxLength = str;
    }

    public String getCvvRequired() {
        return this.cvvRequired;
    }

    public void setCvvRequired(String str) {
        this.cvvRequired = str;
    }

    public String getCvvLength() {
        return this.cvvLength;
    }

    public void setCvvLength(String str) {
        this.cvvLength = str;
    }

    public String getExpiryRequired() {
        return this.expiryRequired;
    }

    public void setExpiryRequired(String str) {
        this.expiryRequired = str;
    }

    public String getIsIndian() {
        return this.isIndian;
    }

    public void setIsIndian(String str) {
        this.isIndian = str;
    }
}
