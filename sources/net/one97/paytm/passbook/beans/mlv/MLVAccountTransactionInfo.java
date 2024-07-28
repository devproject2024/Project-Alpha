package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.beans.mgv.MGVAmount;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class MLVAccountTransactionInfo extends IJRDataModel {
    @b(a = "accountingTimestamp")
    private String accountingTimestamp;
    @b(a = "accountingType")
    private String accountingType;
    @b(a = "balance")
    private MGVAmount balance;
    @b(a = "bizOrderId")
    private String bizOrderId;
    @b(a = "changeAmount")
    private MGVAmount changeAmount;
    @b(a = "merchantId")
    private String merchantId;
    @b(a = "payeeIssuerBankName")
    private String payeeIssuerBankName;
    @b(a = "templateId")
    private String templateId;
    @b(a = "transactionType")
    private String transactionType;

    public static /* synthetic */ MLVAccountTransactionInfo copy$default(MLVAccountTransactionInfo mLVAccountTransactionInfo, String str, MGVAmount mGVAmount, String str2, String str3, String str4, String str5, String str6, String str7, MGVAmount mGVAmount2, int i2, Object obj) {
        MLVAccountTransactionInfo mLVAccountTransactionInfo2 = mLVAccountTransactionInfo;
        int i3 = i2;
        return mLVAccountTransactionInfo.copy((i3 & 1) != 0 ? mLVAccountTransactionInfo2.transactionType : str, (i3 & 2) != 0 ? mLVAccountTransactionInfo2.balance : mGVAmount, (i3 & 4) != 0 ? mLVAccountTransactionInfo2.bizOrderId : str2, (i3 & 8) != 0 ? mLVAccountTransactionInfo2.merchantId : str3, (i3 & 16) != 0 ? mLVAccountTransactionInfo2.accountingTimestamp : str4, (i3 & 32) != 0 ? mLVAccountTransactionInfo2.accountingType : str5, (i3 & 64) != 0 ? mLVAccountTransactionInfo2.payeeIssuerBankName : str6, (i3 & 128) != 0 ? mLVAccountTransactionInfo2.templateId : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mLVAccountTransactionInfo2.changeAmount : mGVAmount2);
    }

    public final String component1() {
        return this.transactionType;
    }

    public final MGVAmount component2() {
        return this.balance;
    }

    public final String component3() {
        return this.bizOrderId;
    }

    public final String component4() {
        return this.merchantId;
    }

    public final String component5() {
        return this.accountingTimestamp;
    }

    public final String component6() {
        return this.accountingType;
    }

    public final String component7() {
        return this.payeeIssuerBankName;
    }

    public final String component8() {
        return this.templateId;
    }

    public final MGVAmount component9() {
        return this.changeAmount;
    }

    public final MLVAccountTransactionInfo copy(String str, MGVAmount mGVAmount, String str2, String str3, String str4, String str5, String str6, String str7, MGVAmount mGVAmount2) {
        k.c(str, "transactionType");
        k.c(mGVAmount, "balance");
        k.c(str2, "bizOrderId");
        k.c(str3, SDKConstants.KEY_MERCHANT_ID);
        String str8 = str4;
        k.c(str8, "accountingTimestamp");
        String str9 = str5;
        k.c(str9, "accountingType");
        String str10 = str6;
        k.c(str10, "payeeIssuerBankName");
        String str11 = str7;
        k.c(str11, PayUtility.TEMPLATE_ID);
        MGVAmount mGVAmount3 = mGVAmount2;
        k.c(mGVAmount3, "changeAmount");
        return new MLVAccountTransactionInfo(str, mGVAmount, str2, str3, str8, str9, str10, str11, mGVAmount3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLVAccountTransactionInfo)) {
            return false;
        }
        MLVAccountTransactionInfo mLVAccountTransactionInfo = (MLVAccountTransactionInfo) obj;
        return k.a((Object) this.transactionType, (Object) mLVAccountTransactionInfo.transactionType) && k.a((Object) this.balance, (Object) mLVAccountTransactionInfo.balance) && k.a((Object) this.bizOrderId, (Object) mLVAccountTransactionInfo.bizOrderId) && k.a((Object) this.merchantId, (Object) mLVAccountTransactionInfo.merchantId) && k.a((Object) this.accountingTimestamp, (Object) mLVAccountTransactionInfo.accountingTimestamp) && k.a((Object) this.accountingType, (Object) mLVAccountTransactionInfo.accountingType) && k.a((Object) this.payeeIssuerBankName, (Object) mLVAccountTransactionInfo.payeeIssuerBankName) && k.a((Object) this.templateId, (Object) mLVAccountTransactionInfo.templateId) && k.a((Object) this.changeAmount, (Object) mLVAccountTransactionInfo.changeAmount);
    }

    public final int hashCode() {
        String str = this.transactionType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MGVAmount mGVAmount = this.balance;
        int hashCode2 = (hashCode + (mGVAmount != null ? mGVAmount.hashCode() : 0)) * 31;
        String str2 = this.bizOrderId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merchantId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.accountingTimestamp;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.accountingType;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payeeIssuerBankName;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.templateId;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        MGVAmount mGVAmount2 = this.changeAmount;
        if (mGVAmount2 != null) {
            i2 = mGVAmount2.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "MLVAccountTransactionInfo(transactionType=" + this.transactionType + ", balance=" + this.balance + ", bizOrderId=" + this.bizOrderId + ", merchantId=" + this.merchantId + ", accountingTimestamp=" + this.accountingTimestamp + ", accountingType=" + this.accountingType + ", payeeIssuerBankName=" + this.payeeIssuerBankName + ", templateId=" + this.templateId + ", changeAmount=" + this.changeAmount + ")";
    }

    public final String getTransactionType() {
        return this.transactionType;
    }

    public final void setTransactionType(String str) {
        k.c(str, "<set-?>");
        this.transactionType = str;
    }

    public final MGVAmount getBalance() {
        return this.balance;
    }

    public final void setBalance(MGVAmount mGVAmount) {
        k.c(mGVAmount, "<set-?>");
        this.balance = mGVAmount;
    }

    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    public final void setBizOrderId(String str) {
        k.c(str, "<set-?>");
        this.bizOrderId = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        k.c(str, "<set-?>");
        this.merchantId = str;
    }

    public final String getAccountingTimestamp() {
        return this.accountingTimestamp;
    }

    public final void setAccountingTimestamp(String str) {
        k.c(str, "<set-?>");
        this.accountingTimestamp = str;
    }

    public final String getAccountingType() {
        return this.accountingType;
    }

    public final void setAccountingType(String str) {
        k.c(str, "<set-?>");
        this.accountingType = str;
    }

    public final String getPayeeIssuerBankName() {
        return this.payeeIssuerBankName;
    }

    public final void setPayeeIssuerBankName(String str) {
        k.c(str, "<set-?>");
        this.payeeIssuerBankName = str;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        k.c(str, "<set-?>");
        this.templateId = str;
    }

    public final MGVAmount getChangeAmount() {
        return this.changeAmount;
    }

    public final void setChangeAmount(MGVAmount mGVAmount) {
        k.c(mGVAmount, "<set-?>");
        this.changeAmount = mGVAmount;
    }

    public MLVAccountTransactionInfo(String str, MGVAmount mGVAmount, String str2, String str3, String str4, String str5, String str6, String str7, MGVAmount mGVAmount2) {
        k.c(str, "transactionType");
        k.c(mGVAmount, "balance");
        k.c(str2, "bizOrderId");
        k.c(str3, SDKConstants.KEY_MERCHANT_ID);
        k.c(str4, "accountingTimestamp");
        k.c(str5, "accountingType");
        k.c(str6, "payeeIssuerBankName");
        k.c(str7, PayUtility.TEMPLATE_ID);
        k.c(mGVAmount2, "changeAmount");
        this.transactionType = str;
        this.balance = mGVAmount;
        this.bizOrderId = str2;
        this.merchantId = str3;
        this.accountingTimestamp = str4;
        this.accountingType = str5;
        this.payeeIssuerBankName = str6;
        this.templateId = str7;
        this.changeAmount = mGVAmount2;
    }
}
