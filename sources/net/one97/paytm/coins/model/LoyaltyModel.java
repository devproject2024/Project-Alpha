package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public class LoyaltyModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountingAmount")
    private String accountingAmount;
    @b(a = "accountingTimestamp")
    private String accountingTimestamp;
    @b(a = "accountingType")
    private String accountingType;
    @b(a = "activeBalance")
    private String activeBalance;
    @b(a = "expiryTime")
    private String expiryTime;
    @b(a = "extendInfo")
    private ExtendedInfoModel extendInfo;
    @b(a = "formattedTxnTime")
    private String formattedTxnTime;
    @b(a = "merchantId")
    private String merchantId;
    @b(a = "orderId")
    private String orderId;
    @b(a = "successful")
    private Boolean successful;
    @b(a = "transactionType")
    private String transactionType;
    @b(a = "txnDate")
    private String txnDate;

    public LoyaltyModel() {
        this((String) null, (String) null, (String) null, (String) null, (ExtendedInfoModel) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (g) null);
    }

    public final String getAccountingAmount() {
        return this.accountingAmount;
    }

    public final void setAccountingAmount(String str) {
        this.accountingAmount = str;
    }

    public final String getAccountingTimestamp() {
        return this.accountingTimestamp;
    }

    public final void setAccountingTimestamp(String str) {
        this.accountingTimestamp = str;
    }

    public final String getAccountingType() {
        return this.accountingType;
    }

    public final void setAccountingType(String str) {
        this.accountingType = str;
    }

    public final String getActiveBalance() {
        return this.activeBalance;
    }

    public final void setActiveBalance(String str) {
        this.activeBalance = str;
    }

    public final ExtendedInfoModel getExtendInfo() {
        return this.extendInfo;
    }

    public final void setExtendInfo(ExtendedInfoModel extendedInfoModel) {
        this.extendInfo = extendedInfoModel;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final Boolean getSuccessful() {
        return this.successful;
    }

    public final void setSuccessful(Boolean bool) {
        this.successful = bool;
    }

    public final String getTransactionType() {
        return this.transactionType;
    }

    public final void setTransactionType(String str) {
        this.transactionType = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getExpiryTime() {
        return this.expiryTime;
    }

    public final void setExpiryTime(String str) {
        this.expiryTime = str;
    }

    public final String getFormattedTxnTime() {
        return this.formattedTxnTime;
    }

    public final void setFormattedTxnTime(String str) {
        this.formattedTxnTime = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoyaltyModel(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, net.one97.paytm.coins.model.ExtendedInfoModel r18, java.lang.String r19, java.lang.Boolean r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.g.b.g r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.model.LoyaltyModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.coins.model.ExtendedInfoModel, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public String getTxnDate() {
        return this.txnDate;
    }

    public void setTxnDate(String str) {
        this.txnDate = str;
    }

    public LoyaltyModel(String str, String str2, String str3, String str4, ExtendedInfoModel extendedInfoModel, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10) {
        this.accountingAmount = str;
        this.accountingTimestamp = str2;
        this.accountingType = str3;
        this.activeBalance = str4;
        this.extendInfo = extendedInfoModel;
        this.orderId = str5;
        this.successful = bool;
        this.transactionType = str6;
        this.merchantId = str7;
        this.expiryTime = str8;
        this.formattedTxnTime = str9;
        this.txnDate = str10;
    }
}
