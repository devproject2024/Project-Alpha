package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class Payment extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "bank_transaction_id")
    private String bankTransactionId;
    @b(a = "created_at")
    private String createdAt;
    @b(a = "gateway")
    private String gateway;
    @b(a = "id")
    private String id;
    @b(a = "kind")
    private Integer kind;
    @b(a = "merchant_logo_url")
    private String merchantLogoUrl;
    @b(a = "merchant_name")
    private String merchantName;
    @b(a = "mid")
    private String mid;
    @b(a = "order_id")
    private String orderId;
    @b(a = "payment_bank")
    private String paymentBank;
    @b(a = "payment_method")
    private String paymentMethod;
    @b(a = "pg_amount")
    private Double pgAmount;
    @b(a = "pg_response_code")
    private String pgResponseCode;
    @b(a = "provider")
    private String provider;
    @b(a = "status")
    private Integer status;
    @b(a = "transaction_number")
    private String transactionNumber;
    @b(a = "txn_count")
    private Integer txnCount;

    public Payment() {
        this((Double) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 131071, (g) null);
    }

    public static /* synthetic */ Payment copy$default(Payment payment, Double d2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, Integer num2, String str7, String str8, String str9, String str10, String str11, Integer num3, String str12, String str13, int i2, Object obj) {
        Payment payment2 = payment;
        int i3 = i2;
        return payment.copy((i3 & 1) != 0 ? payment2.pgAmount : d2, (i3 & 2) != 0 ? payment2.transactionNumber : str, (i3 & 4) != 0 ? payment2.paymentMethod : str2, (i3 & 8) != 0 ? payment2.kind : num, (i3 & 16) != 0 ? payment2.bankTransactionId : str3, (i3 & 32) != 0 ? payment2.paymentBank : str4, (i3 & 64) != 0 ? payment2.gateway : str5, (i3 & 128) != 0 ? payment2.id : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? payment2.status : num2, (i3 & 512) != 0 ? payment2.createdAt : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? payment2.pgResponseCode : str8, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? payment2.orderId : str9, (i3 & 4096) != 0 ? payment2.provider : str10, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? payment2.mid : str11, (i3 & 16384) != 0 ? payment2.txnCount : num3, (i3 & 32768) != 0 ? payment2.merchantName : str12, (i3 & 65536) != 0 ? payment2.merchantLogoUrl : str13);
    }

    public final Double component1() {
        return this.pgAmount;
    }

    public final String component10() {
        return this.createdAt;
    }

    public final String component11() {
        return this.pgResponseCode;
    }

    public final String component12() {
        return this.orderId;
    }

    public final String component13() {
        return this.provider;
    }

    public final String component14() {
        return this.mid;
    }

    public final Integer component15() {
        return this.txnCount;
    }

    public final String component16() {
        return this.merchantName;
    }

    public final String component17() {
        return this.merchantLogoUrl;
    }

    public final String component2() {
        return this.transactionNumber;
    }

    public final String component3() {
        return this.paymentMethod;
    }

    public final Integer component4() {
        return this.kind;
    }

    public final String component5() {
        return this.bankTransactionId;
    }

    public final String component6() {
        return this.paymentBank;
    }

    public final String component7() {
        return this.gateway;
    }

    public final String component8() {
        return this.id;
    }

    public final Integer component9() {
        return this.status;
    }

    public final Payment copy(Double d2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, Integer num2, String str7, String str8, String str9, String str10, String str11, Integer num3, String str12, String str13) {
        return new Payment(d2, str, str2, num, str3, str4, str5, str6, num2, str7, str8, str9, str10, str11, num3, str12, str13);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Payment)) {
            return false;
        }
        Payment payment = (Payment) obj;
        return k.a((Object) this.pgAmount, (Object) payment.pgAmount) && k.a((Object) this.transactionNumber, (Object) payment.transactionNumber) && k.a((Object) this.paymentMethod, (Object) payment.paymentMethod) && k.a((Object) this.kind, (Object) payment.kind) && k.a((Object) this.bankTransactionId, (Object) payment.bankTransactionId) && k.a((Object) this.paymentBank, (Object) payment.paymentBank) && k.a((Object) this.gateway, (Object) payment.gateway) && k.a((Object) this.id, (Object) payment.id) && k.a((Object) this.status, (Object) payment.status) && k.a((Object) this.createdAt, (Object) payment.createdAt) && k.a((Object) this.pgResponseCode, (Object) payment.pgResponseCode) && k.a((Object) this.orderId, (Object) payment.orderId) && k.a((Object) this.provider, (Object) payment.provider) && k.a((Object) this.mid, (Object) payment.mid) && k.a((Object) this.txnCount, (Object) payment.txnCount) && k.a((Object) this.merchantName, (Object) payment.merchantName) && k.a((Object) this.merchantLogoUrl, (Object) payment.merchantLogoUrl);
    }

    public final int hashCode() {
        Double d2 = this.pgAmount;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.transactionNumber;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.paymentMethod;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.kind;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.bankTransactionId;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.paymentBank;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.gateway;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.id;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num2 = this.status;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str7 = this.createdAt;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.pgResponseCode;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.orderId;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.provider;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.mid;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Integer num3 = this.txnCount;
        int hashCode15 = (hashCode14 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str12 = this.merchantName;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.merchantLogoUrl;
        if (str13 != null) {
            i2 = str13.hashCode();
        }
        return hashCode16 + i2;
    }

    public final String toString() {
        return "Payment(pgAmount=" + this.pgAmount + ", transactionNumber=" + this.transactionNumber + ", paymentMethod=" + this.paymentMethod + ", kind=" + this.kind + ", bankTransactionId=" + this.bankTransactionId + ", paymentBank=" + this.paymentBank + ", gateway=" + this.gateway + ", id=" + this.id + ", status=" + this.status + ", createdAt=" + this.createdAt + ", pgResponseCode=" + this.pgResponseCode + ", orderId=" + this.orderId + ", provider=" + this.provider + ", mid=" + this.mid + ", txnCount=" + this.txnCount + ", merchantName=" + this.merchantName + ", merchantLogoUrl=" + this.merchantLogoUrl + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Double getPgAmount() {
        return this.pgAmount;
    }

    public final void setPgAmount(Double d2) {
        this.pgAmount = d2;
    }

    public final String getTransactionNumber() {
        return this.transactionNumber;
    }

    public final void setTransactionNumber(String str) {
        this.transactionNumber = str;
    }

    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    public final void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public final Integer getKind() {
        return this.kind;
    }

    public final void setKind(Integer num) {
        this.kind = num;
    }

    public final String getBankTransactionId() {
        return this.bankTransactionId;
    }

    public final void setBankTransactionId(String str) {
        this.bankTransactionId = str;
    }

    public final String getPaymentBank() {
        return this.paymentBank;
    }

    public final void setPaymentBank(String str) {
        this.paymentBank = str;
    }

    public final String getGateway() {
        return this.gateway;
    }

    public final void setGateway(String str) {
        this.gateway = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final String getPgResponseCode() {
        return this.pgResponseCode;
    }

    public final void setPgResponseCode(String str) {
        this.pgResponseCode = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final void setProvider(String str) {
        this.provider = str;
    }

    public final String getMid() {
        return this.mid;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final Integer getTxnCount() {
        return this.txnCount;
    }

    public final void setTxnCount(Integer num) {
        this.txnCount = num;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public Payment(Double d2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, Integer num2, String str7, String str8, String str9, String str10, String str11, Integer num3, String str12, String str13) {
        this.pgAmount = d2;
        this.transactionNumber = str;
        this.paymentMethod = str2;
        this.kind = num;
        this.bankTransactionId = str3;
        this.paymentBank = str4;
        this.gateway = str5;
        this.id = str6;
        this.status = num2;
        this.createdAt = str7;
        this.pgResponseCode = str8;
        this.orderId = str9;
        this.provider = str10;
        this.mid = str11;
        this.txnCount = num3;
        this.merchantName = str12;
        this.merchantLogoUrl = str13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Payment(java.lang.Double r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.Integer r33, java.lang.String r34, java.lang.String r35, int r36, kotlin.g.b.g r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r25
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r26
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r27
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r28
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r29
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r30
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r31
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r32
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r35
        L_0x0090:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r2
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Payment.<init>(java.lang.Double, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    public final void setMerchantLogoUrl(String str) {
        this.merchantLogoUrl = str;
    }
}
