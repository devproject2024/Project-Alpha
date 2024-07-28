package net.one97.paytm.common.entity.wallet.chatintegration;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.upi.util.UpiConstants;

public final class MTSDKPostPaymentResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String amount;
    private String comment;
    private String errorMessage;
    private String flowType;
    private String paymentMode;
    private String referenceNumber;
    private ThemeData themeData;
    private String transactionStatus;
    private Long transactionTime;
    private String uniqueKey;

    public MTSDKPostPaymentResponse() {
        this((String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (ThemeData) null, (String) null, (String) null, (String) null, 1023, (g) null);
    }

    public static /* synthetic */ MTSDKPostPaymentResponse copy$default(MTSDKPostPaymentResponse mTSDKPostPaymentResponse, String str, String str2, String str3, String str4, Long l, String str5, ThemeData themeData2, String str6, String str7, String str8, int i2, Object obj) {
        MTSDKPostPaymentResponse mTSDKPostPaymentResponse2 = mTSDKPostPaymentResponse;
        int i3 = i2;
        return mTSDKPostPaymentResponse.copy((i3 & 1) != 0 ? mTSDKPostPaymentResponse2.paymentMode : str, (i3 & 2) != 0 ? mTSDKPostPaymentResponse2.flowType : str2, (i3 & 4) != 0 ? mTSDKPostPaymentResponse2.amount : str3, (i3 & 8) != 0 ? mTSDKPostPaymentResponse2.transactionStatus : str4, (i3 & 16) != 0 ? mTSDKPostPaymentResponse2.transactionTime : l, (i3 & 32) != 0 ? mTSDKPostPaymentResponse2.referenceNumber : str5, (i3 & 64) != 0 ? mTSDKPostPaymentResponse2.themeData : themeData2, (i3 & 128) != 0 ? mTSDKPostPaymentResponse2.errorMessage : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mTSDKPostPaymentResponse2.comment : str7, (i3 & 512) != 0 ? mTSDKPostPaymentResponse2.uniqueKey : str8);
    }

    public final String component1() {
        return this.paymentMode;
    }

    public final String component10() {
        return this.uniqueKey;
    }

    public final String component2() {
        return this.flowType;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.transactionStatus;
    }

    public final Long component5() {
        return this.transactionTime;
    }

    public final String component6() {
        return this.referenceNumber;
    }

    public final ThemeData component7() {
        return this.themeData;
    }

    public final String component8() {
        return this.errorMessage;
    }

    public final String component9() {
        return this.comment;
    }

    public final MTSDKPostPaymentResponse copy(String str, String str2, String str3, String str4, Long l, String str5, ThemeData themeData2, String str6, String str7, String str8) {
        return new MTSDKPostPaymentResponse(str, str2, str3, str4, l, str5, themeData2, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MTSDKPostPaymentResponse)) {
            return false;
        }
        MTSDKPostPaymentResponse mTSDKPostPaymentResponse = (MTSDKPostPaymentResponse) obj;
        return k.a((Object) this.paymentMode, (Object) mTSDKPostPaymentResponse.paymentMode) && k.a((Object) this.flowType, (Object) mTSDKPostPaymentResponse.flowType) && k.a((Object) this.amount, (Object) mTSDKPostPaymentResponse.amount) && k.a((Object) this.transactionStatus, (Object) mTSDKPostPaymentResponse.transactionStatus) && k.a((Object) this.transactionTime, (Object) mTSDKPostPaymentResponse.transactionTime) && k.a((Object) this.referenceNumber, (Object) mTSDKPostPaymentResponse.referenceNumber) && k.a((Object) this.themeData, (Object) mTSDKPostPaymentResponse.themeData) && k.a((Object) this.errorMessage, (Object) mTSDKPostPaymentResponse.errorMessage) && k.a((Object) this.comment, (Object) mTSDKPostPaymentResponse.comment) && k.a((Object) this.uniqueKey, (Object) mTSDKPostPaymentResponse.uniqueKey);
    }

    public final int hashCode() {
        String str = this.paymentMode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.flowType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.transactionStatus;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Long l = this.transactionTime;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        String str5 = this.referenceNumber;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        ThemeData themeData2 = this.themeData;
        int hashCode7 = (hashCode6 + (themeData2 != null ? themeData2.hashCode() : 0)) * 31;
        String str6 = this.errorMessage;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.comment;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.uniqueKey;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public final String getFlowType() {
        return this.flowType;
    }

    public final void setFlowType(String str) {
        this.flowType = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getTransactionStatus() {
        return this.transactionStatus;
    }

    public final void setTransactionStatus(String str) {
        this.transactionStatus = str;
    }

    public final Long getTransactionTime() {
        return this.transactionTime;
    }

    public final void setTransactionTime(Long l) {
        this.transactionTime = l;
    }

    public final String getReferenceNumber() {
        return this.referenceNumber;
    }

    public final void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public final ThemeData getThemeData() {
        return this.themeData;
    }

    public final void setThemeData(ThemeData themeData2) {
        this.themeData = themeData2;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MTSDKPostPaymentResponse(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Long r16, java.lang.String r17, net.one97.paytm.p2p.theme.ThemeData r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, net.one97.paytm.p2p.theme.ThemeData, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final void setUniqueKey(String str) {
        this.uniqueKey = str;
    }

    public MTSDKPostPaymentResponse(String str, String str2, String str3, String str4, Long l, String str5, ThemeData themeData2, String str6, String str7, String str8) {
        this.paymentMode = str;
        this.flowType = str2;
        this.amount = str3;
        this.transactionStatus = str4;
        this.transactionTime = l;
        this.referenceNumber = str5;
        this.themeData = themeData2;
        this.errorMessage = str6;
        this.comment = str7;
        this.uniqueKey = str8;
    }

    public final String toString() {
        return "MTSDKPostPaymentResponse(paymentMode=" + this.paymentMode + ", flowType=" + this.flowType + ", amount=" + this.amount + ", transactionStatus=" + this.transactionStatus + ", transactionTime=" + this.transactionTime + ", referenceNumber=" + this.referenceNumber + ", themeData=" + this.themeData + ", errorMessage=" + this.errorMessage + ", comment=" + this.comment + ", uniqueKey=" + this.uniqueKey + ')';
    }
}
