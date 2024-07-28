package net.one97.paytm.common.entity.quick_pay;

import net.one97.paytm.common.entity.IJRDataModel;

public class SupportingData implements IJRDataModel {
    private String beneficiaryAccountNumber;
    private String beneficiaryBankIconUrl;
    private String beneficiaryBankName;
    private String beneficiaryIfscCode;
    private String beneficiaryMobileNumber;
    private String beneficiaryName;
    private String beneficiaryUpiAddress;
    private String paymentType;
    private String quickPaymentUrl;
    private String storeFrontTitle;
    private String tagId;
    private String tagName;
    private String tagUrl;

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public String getTagUrl() {
        return this.tagUrl;
    }

    public void setTagUrl(String str) {
        this.tagUrl = str;
    }

    public String getTagId() {
        return this.tagId;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String str) {
        this.paymentType = str;
    }

    public String getBeneficiaryUpiAddress() {
        return this.beneficiaryUpiAddress;
    }

    public void setBeneficiaryUpiAddress(String str) {
        this.beneficiaryUpiAddress = str;
    }

    public String getBeneficiaryName() {
        return this.beneficiaryName;
    }

    public void setBeneficiaryName(String str) {
        this.beneficiaryName = str;
    }

    public String getBeneficiaryIfscCode() {
        return this.beneficiaryIfscCode;
    }

    public void setBeneficiaryIfscCode(String str) {
        this.beneficiaryIfscCode = str;
    }

    public String getBeneficiaryAccountNumber() {
        return this.beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String str) {
        this.beneficiaryAccountNumber = str;
    }

    public String getBeneficiaryMobileNumber() {
        return this.beneficiaryMobileNumber;
    }

    public void setBeneficiaryMobileNumber(String str) {
        this.beneficiaryMobileNumber = str;
    }

    public String getBeneficiaryBankIconUrl() {
        return this.beneficiaryBankIconUrl;
    }

    public void setBeneficiaryBankIconUrl(String str) {
        this.beneficiaryBankIconUrl = str;
    }

    public String getBeneficiaryBankName() {
        return this.beneficiaryBankName;
    }

    public void setBeneficiaryBankName(String str) {
        this.beneficiaryBankName = str;
    }

    public String getQuickPaymentUrl() {
        return this.quickPaymentUrl;
    }

    public void setQuickPaymentUrl(String str) {
        this.quickPaymentUrl = str;
    }

    public String getStoreFrontTitle() {
        return this.storeFrontTitle;
    }

    public void setStoreFrontTitle(String str) {
        this.storeFrontTitle = str;
    }
}
