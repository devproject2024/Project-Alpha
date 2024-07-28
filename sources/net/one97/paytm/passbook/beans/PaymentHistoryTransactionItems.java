package net.one97.paytm.passbook.beans;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentHistoryTransactionItems extends IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "dateLabel")
    private String dateLabel;
    @b(a = "maskAmount")
    private Boolean maskAmount;
    @b(a = "merchantCategory")
    private String merchantCategory;
    @b(a = "narration")
    private String narration;
    @b(a = "secondPartyInfo")
    private SecondPartyInfo secondPartyInfo;
    @b(a = "status")
    private String status;
    @b(a = "statusKey")
    private String statusKey;
    @b(a = "streamSource")
    private String streamSource;
    @b(a = "timeLabel")
    private String timeLabel;
    @b(a = "txnId")
    private String txnId;
    @b(a = "txnIndicator")
    private String txnIndicator;
    @b(a = "userInstrumentLogos")
    private ArrayList<UserInstrumentLogos> userInstrumentLogos;

    public PaymentHistoryTransactionItems() {
        this((String) null, (String) null, (String) null, (String) null, (ArrayList) null, (SecondPartyInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 8191, (g) null);
    }

    public static /* synthetic */ PaymentHistoryTransactionItems copy$default(PaymentHistoryTransactionItems paymentHistoryTransactionItems, String str, String str2, String str3, String str4, ArrayList arrayList, SecondPartyInfo secondPartyInfo2, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, int i2, Object obj) {
        PaymentHistoryTransactionItems paymentHistoryTransactionItems2 = paymentHistoryTransactionItems;
        int i3 = i2;
        return paymentHistoryTransactionItems.copy((i3 & 1) != 0 ? paymentHistoryTransactionItems2.dateLabel : str, (i3 & 2) != 0 ? paymentHistoryTransactionItems2.timeLabel : str2, (i3 & 4) != 0 ? paymentHistoryTransactionItems2.amount : str3, (i3 & 8) != 0 ? paymentHistoryTransactionItems2.txnIndicator : str4, (i3 & 16) != 0 ? paymentHistoryTransactionItems2.userInstrumentLogos : arrayList, (i3 & 32) != 0 ? paymentHistoryTransactionItems2.secondPartyInfo : secondPartyInfo2, (i3 & 64) != 0 ? paymentHistoryTransactionItems2.status : str5, (i3 & 128) != 0 ? paymentHistoryTransactionItems2.statusKey : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentHistoryTransactionItems2.narration : str7, (i3 & 512) != 0 ? paymentHistoryTransactionItems2.txnId : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentHistoryTransactionItems2.streamSource : str9, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentHistoryTransactionItems2.merchantCategory : str10, (i3 & 4096) != 0 ? paymentHistoryTransactionItems2.maskAmount : bool);
    }

    public final String component1() {
        return this.dateLabel;
    }

    public final String component10() {
        return this.txnId;
    }

    public final String component11() {
        return this.streamSource;
    }

    public final String component12() {
        return this.merchantCategory;
    }

    public final Boolean component13() {
        return this.maskAmount;
    }

    public final String component2() {
        return this.timeLabel;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.txnIndicator;
    }

    public final ArrayList<UserInstrumentLogos> component5() {
        return this.userInstrumentLogos;
    }

    public final SecondPartyInfo component6() {
        return this.secondPartyInfo;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.statusKey;
    }

    public final String component9() {
        return this.narration;
    }

    public final PaymentHistoryTransactionItems copy(String str, String str2, String str3, String str4, ArrayList<UserInstrumentLogos> arrayList, SecondPartyInfo secondPartyInfo2, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool) {
        return new PaymentHistoryTransactionItems(str, str2, str3, str4, arrayList, secondPartyInfo2, str5, str6, str7, str8, str9, str10, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentHistoryTransactionItems)) {
            return false;
        }
        PaymentHistoryTransactionItems paymentHistoryTransactionItems = (PaymentHistoryTransactionItems) obj;
        return k.a((Object) this.dateLabel, (Object) paymentHistoryTransactionItems.dateLabel) && k.a((Object) this.timeLabel, (Object) paymentHistoryTransactionItems.timeLabel) && k.a((Object) this.amount, (Object) paymentHistoryTransactionItems.amount) && k.a((Object) this.txnIndicator, (Object) paymentHistoryTransactionItems.txnIndicator) && k.a((Object) this.userInstrumentLogos, (Object) paymentHistoryTransactionItems.userInstrumentLogos) && k.a((Object) this.secondPartyInfo, (Object) paymentHistoryTransactionItems.secondPartyInfo) && k.a((Object) this.status, (Object) paymentHistoryTransactionItems.status) && k.a((Object) this.statusKey, (Object) paymentHistoryTransactionItems.statusKey) && k.a((Object) this.narration, (Object) paymentHistoryTransactionItems.narration) && k.a((Object) this.txnId, (Object) paymentHistoryTransactionItems.txnId) && k.a((Object) this.streamSource, (Object) paymentHistoryTransactionItems.streamSource) && k.a((Object) this.merchantCategory, (Object) paymentHistoryTransactionItems.merchantCategory) && k.a((Object) this.maskAmount, (Object) paymentHistoryTransactionItems.maskAmount);
    }

    public final int hashCode() {
        String str = this.dateLabel;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.timeLabel;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.txnIndicator;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ArrayList<UserInstrumentLogos> arrayList = this.userInstrumentLogos;
        int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        SecondPartyInfo secondPartyInfo2 = this.secondPartyInfo;
        int hashCode6 = (hashCode5 + (secondPartyInfo2 != null ? secondPartyInfo2.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.statusKey;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.narration;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.txnId;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.streamSource;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.merchantCategory;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Boolean bool = this.maskAmount;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "PaymentHistoryTransactionItems(dateLabel=" + this.dateLabel + ", timeLabel=" + this.timeLabel + ", amount=" + this.amount + ", txnIndicator=" + this.txnIndicator + ", userInstrumentLogos=" + this.userInstrumentLogos + ", secondPartyInfo=" + this.secondPartyInfo + ", status=" + this.status + ", statusKey=" + this.statusKey + ", narration=" + this.narration + ", txnId=" + this.txnId + ", streamSource=" + this.streamSource + ", merchantCategory=" + this.merchantCategory + ", maskAmount=" + this.maskAmount + ")";
    }

    public final String getDateLabel() {
        return this.dateLabel;
    }

    public final void setDateLabel(String str) {
        this.dateLabel = str;
    }

    public final String getTimeLabel() {
        return this.timeLabel;
    }

    public final void setTimeLabel(String str) {
        this.timeLabel = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getTxnIndicator() {
        return this.txnIndicator;
    }

    public final void setTxnIndicator(String str) {
        this.txnIndicator = str;
    }

    public final ArrayList<UserInstrumentLogos> getUserInstrumentLogos() {
        return this.userInstrumentLogos;
    }

    public final void setUserInstrumentLogos(ArrayList<UserInstrumentLogos> arrayList) {
        this.userInstrumentLogos = arrayList;
    }

    public final SecondPartyInfo getSecondPartyInfo() {
        return this.secondPartyInfo;
    }

    public final void setSecondPartyInfo(SecondPartyInfo secondPartyInfo2) {
        this.secondPartyInfo = secondPartyInfo2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusKey() {
        return this.statusKey;
    }

    public final void setStatusKey(String str) {
        this.statusKey = str;
    }

    public final String getNarration() {
        return this.narration;
    }

    public final void setNarration(String str) {
        this.narration = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final String getStreamSource() {
        return this.streamSource;
    }

    public final void setStreamSource(String str) {
        this.streamSource = str;
    }

    public final String getMerchantCategory() {
        return this.merchantCategory;
    }

    public final void setMerchantCategory(String str) {
        this.merchantCategory = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentHistoryTransactionItems(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.ArrayList r19, net.one97.paytm.passbook.beans.SecondPartyInfo r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Boolean r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.PaymentHistoryTransactionItems.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, net.one97.paytm.passbook.beans.SecondPartyInfo, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Boolean getMaskAmount() {
        return this.maskAmount;
    }

    public final void setMaskAmount(Boolean bool) {
        this.maskAmount = bool;
    }

    public PaymentHistoryTransactionItems(String str, String str2, String str3, String str4, ArrayList<UserInstrumentLogos> arrayList, SecondPartyInfo secondPartyInfo2, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool) {
        this.dateLabel = str;
        this.timeLabel = str2;
        this.amount = str3;
        this.txnIndicator = str4;
        this.userInstrumentLogos = arrayList;
        this.secondPartyInfo = secondPartyInfo2;
        this.status = str5;
        this.statusKey = str6;
        this.narration = str7;
        this.txnId = str8;
        this.streamSource = str9;
        this.merchantCategory = str10;
        this.maskAmount = bool;
    }
}
