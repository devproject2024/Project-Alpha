package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class DisplayField extends CJRWalletDataModel implements IJRDataModel {
    private String amount;
    private String bankLogo;
    private String bankName;
    private String cardScheme;
    private String cardType;
    private String cardTypeLogo;
    private String colourCode;
    private String descriptionText;
    private String expiryAlertTime;
    private String firstSixDigits;
    private String headerText;
    private String lastFourDigits;
    private String merchantLogoFlag;
    private String merchantLogoUrl;
    private String merchantName;
    private String merchantType;
    private String mid;
    private String orderId;
    private String pageExpiryTime;
    private String payOnBankMessage;
    private String payOnBankTime;
    private String redirectColourCode;
    private String resendOtpEnableTime;
    private String themeCode;

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setPageExpiryTime(String str) {
        this.pageExpiryTime = str;
    }

    public String getPageExpiryTime() {
        return this.pageExpiryTime;
    }

    public void setHeaderText(String str) {
        this.headerText = str;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public void setCardTypeLogo(String str) {
        this.cardTypeLogo = str;
    }

    public String getCardTypeLogo() {
        return this.cardTypeLogo;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public String getCardScheme() {
        return this.cardScheme;
    }

    public void setPayOnBankTime(String str) {
        this.payOnBankTime = str;
    }

    public String getPayOnBankTime() {
        return this.payOnBankTime;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setColourCode(String str) {
        this.colourCode = str;
    }

    public String getColourCode() {
        return this.colourCode;
    }

    public void setBankLogo(String str) {
        this.bankLogo = str;
    }

    public String getBankLogo() {
        return this.bankLogo;
    }

    public void setDescriptionText(String str) {
        this.descriptionText = str;
    }

    public String getDescriptionText() {
        return this.descriptionText;
    }

    public void setFirstSixDigits(String str) {
        this.firstSixDigits = str;
    }

    public String getFirstSixDigits() {
        return this.firstSixDigits;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantLogoFlag(String str) {
        this.merchantLogoFlag = str;
    }

    public String getMerchantLogoFlag() {
        return this.merchantLogoFlag;
    }

    public void setLastFourDigits(String str) {
        this.lastFourDigits = str;
    }

    public String getLastFourDigits() {
        return this.lastFourDigits;
    }

    public void setThemeCode(String str) {
        this.themeCode = str;
    }

    public String getThemeCode() {
        return this.themeCode;
    }

    public void setRedirectColourCode(String str) {
        this.redirectColourCode = str;
    }

    public String getRedirectColourCode() {
        return this.redirectColourCode;
    }

    public void setResendOtpEnableTime(String str) {
        this.resendOtpEnableTime = str;
    }

    public String getResendOtpEnableTime() {
        return this.resendOtpEnableTime;
    }

    public void setExpiryAlertTime(String str) {
        this.expiryAlertTime = str;
    }

    public String getExpiryAlertTime() {
        return this.expiryAlertTime;
    }

    public void setPayOnBankMessage(String str) {
        this.payOnBankMessage = str;
    }

    public String getPayOnBankMessage() {
        return this.payOnBankMessage;
    }

    public void setMerchantLogoUrl(String str) {
        this.merchantLogoUrl = str;
    }

    public String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    public void setMerchantType(String str) {
        this.merchantType = str;
    }

    public String getMerchantType() {
        return this.merchantType;
    }
}
