package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class SettlementBankDetailModel {
    @c(a = "accountNumber")
    public String accountNumber;
    @c(a = "bankIconUrl")
    public String bankIconUrl;
    @c(a = "bankIfscCode")
    public String bankIfscCode;
    @c(a = "bankName")
    public String bankName;

    public static /* synthetic */ SettlementBankDetailModel copy$default(SettlementBankDetailModel settlementBankDetailModel, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = settlementBankDetailModel.bankName;
        }
        if ((i2 & 2) != 0) {
            str2 = settlementBankDetailModel.bankIfscCode;
        }
        if ((i2 & 4) != 0) {
            str3 = settlementBankDetailModel.accountNumber;
        }
        if ((i2 & 8) != 0) {
            str4 = settlementBankDetailModel.bankIconUrl;
        }
        return settlementBankDetailModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.bankName;
    }

    public final String component2() {
        return this.bankIfscCode;
    }

    public final String component3() {
        return this.accountNumber;
    }

    public final String component4() {
        return this.bankIconUrl;
    }

    public final SettlementBankDetailModel copy(String str, String str2, String str3, String str4) {
        return new SettlementBankDetailModel(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementBankDetailModel)) {
            return false;
        }
        SettlementBankDetailModel settlementBankDetailModel = (SettlementBankDetailModel) obj;
        return k.a((Object) this.bankName, (Object) settlementBankDetailModel.bankName) && k.a((Object) this.bankIfscCode, (Object) settlementBankDetailModel.bankIfscCode) && k.a((Object) this.accountNumber, (Object) settlementBankDetailModel.accountNumber) && k.a((Object) this.bankIconUrl, (Object) settlementBankDetailModel.bankIconUrl);
    }

    public final int hashCode() {
        String str = this.bankName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankIfscCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bankIconUrl;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SettlementBankDetailModel(bankName=" + this.bankName + ", bankIfscCode=" + this.bankIfscCode + ", accountNumber=" + this.accountNumber + ", bankIconUrl=" + this.bankIconUrl + ")";
    }

    public SettlementBankDetailModel(String str, String str2, String str3, String str4) {
        this.bankName = str;
        this.bankIfscCode = str2;
        this.accountNumber = str3;
        this.bankIconUrl = str4;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getBankIfscCode() {
        return this.bankIfscCode;
    }

    public final void setBankIfscCode(String str) {
        this.bankIfscCode = str;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public final String getBankIconUrl() {
        return this.bankIconUrl;
    }

    public final void setBankIconUrl(String str) {
        this.bankIconUrl = str;
    }
}
