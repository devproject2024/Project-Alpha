package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class AdditionalInfoModel {
    @c(a = "bankIconUrl")
    public String bankIconUrl;
    @c(a = "maskedCardNo")
    public String maskedCardNo;
    @c(a = "payMethodIconUrl")
    public String payMethodIconUrl;
    @c(a = "receiverBankName")
    public String receiverBankName;
    @c(a = "receiverIfscCode")
    public String receiverIfscCode;
    @c(a = "txnAmount")
    public AmountModel txnAmount;

    public static /* synthetic */ AdditionalInfoModel copy$default(AdditionalInfoModel additionalInfoModel, String str, AmountModel amountModel, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = additionalInfoModel.maskedCardNo;
        }
        if ((i2 & 2) != 0) {
            amountModel = additionalInfoModel.txnAmount;
        }
        AmountModel amountModel2 = amountModel;
        if ((i2 & 4) != 0) {
            str2 = additionalInfoModel.payMethodIconUrl;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = additionalInfoModel.receiverBankName;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = additionalInfoModel.receiverIfscCode;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = additionalInfoModel.bankIconUrl;
        }
        return additionalInfoModel.copy(str, amountModel2, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.maskedCardNo;
    }

    public final AmountModel component2() {
        return this.txnAmount;
    }

    public final String component3() {
        return this.payMethodIconUrl;
    }

    public final String component4() {
        return this.receiverBankName;
    }

    public final String component5() {
        return this.receiverIfscCode;
    }

    public final String component6() {
        return this.bankIconUrl;
    }

    public final AdditionalInfoModel copy(String str, AmountModel amountModel, String str2, String str3, String str4, String str5) {
        return new AdditionalInfoModel(str, amountModel, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdditionalInfoModel)) {
            return false;
        }
        AdditionalInfoModel additionalInfoModel = (AdditionalInfoModel) obj;
        return k.a((Object) this.maskedCardNo, (Object) additionalInfoModel.maskedCardNo) && k.a((Object) this.txnAmount, (Object) additionalInfoModel.txnAmount) && k.a((Object) this.payMethodIconUrl, (Object) additionalInfoModel.payMethodIconUrl) && k.a((Object) this.receiverBankName, (Object) additionalInfoModel.receiverBankName) && k.a((Object) this.receiverIfscCode, (Object) additionalInfoModel.receiverIfscCode) && k.a((Object) this.bankIconUrl, (Object) additionalInfoModel.bankIconUrl);
    }

    public final int hashCode() {
        String str = this.maskedCardNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AmountModel amountModel = this.txnAmount;
        int hashCode2 = (hashCode + (amountModel != null ? amountModel.hashCode() : 0)) * 31;
        String str2 = this.payMethodIconUrl;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.receiverBankName;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.receiverIfscCode;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bankIconUrl;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "AdditionalInfoModel(maskedCardNo=" + this.maskedCardNo + ", txnAmount=" + this.txnAmount + ", payMethodIconUrl=" + this.payMethodIconUrl + ", receiverBankName=" + this.receiverBankName + ", receiverIfscCode=" + this.receiverIfscCode + ", bankIconUrl=" + this.bankIconUrl + ")";
    }

    public AdditionalInfoModel(String str, AmountModel amountModel, String str2, String str3, String str4, String str5) {
        this.maskedCardNo = str;
        this.txnAmount = amountModel;
        this.payMethodIconUrl = str2;
        this.receiverBankName = str3;
        this.receiverIfscCode = str4;
        this.bankIconUrl = str5;
    }

    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public final void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    public final AmountModel getTxnAmount() {
        return this.txnAmount;
    }

    public final void setTxnAmount(AmountModel amountModel) {
        this.txnAmount = amountModel;
    }

    public final String getPayMethodIconUrl() {
        return this.payMethodIconUrl;
    }

    public final void setPayMethodIconUrl(String str) {
        this.payMethodIconUrl = str;
    }

    public final String getReceiverBankName() {
        return this.receiverBankName;
    }

    public final void setReceiverBankName(String str) {
        this.receiverBankName = str;
    }

    public final String getReceiverIfscCode() {
        return this.receiverIfscCode;
    }

    public final void setReceiverIfscCode(String str) {
        this.receiverIfscCode = str;
    }

    public final String getBankIconUrl() {
        return this.bankIconUrl;
    }

    public final void setBankIconUrl(String str) {
        this.bankIconUrl = str;
    }
}
