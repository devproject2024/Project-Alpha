package net.one97.paytm.passbook.beans;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SAHistoryTransactionItems extends IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "dateLabel")
    private String dateLabel;
    @b(a = "dateTimeEpochMilli")
    private String dateTimeEpochMilli;
    @b(a = "merchantCategory")
    private String merchantCategory;
    @b(a = "narration")
    private String narration;
    @b(a = "secondPartyInfo")
    private SASecondPartyInfo secondPartyInfo;
    @b(a = "status")
    private String status;
    @b(a = "statusKey")
    private String statusKey;
    @b(a = "streamSource")
    private String streamSource;
    @b(a = "timeLabel")
    private String timeLabel;
    @b(a = "tranDateEpochMilli")
    private String tranDateEpochMilli;
    @b(a = "txnId")
    private String txnId;
    @b(a = "txnIndicator")
    private String txnIndicator;
    @b(a = "userInstrumentLogos")
    private ArrayList<SAUserInstrumentLogos> userInstrumentLogos;

    public SAHistoryTransactionItems() {
        this((String) null, (String) null, (String) null, (String) null, (ArrayList) null, (SASecondPartyInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16383, (g) null);
    }

    public static /* synthetic */ SAHistoryTransactionItems copy$default(SAHistoryTransactionItems sAHistoryTransactionItems, String str, String str2, String str3, String str4, ArrayList arrayList, SASecondPartyInfo sASecondPartyInfo, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i2, Object obj) {
        SAHistoryTransactionItems sAHistoryTransactionItems2 = sAHistoryTransactionItems;
        int i3 = i2;
        return sAHistoryTransactionItems.copy((i3 & 1) != 0 ? sAHistoryTransactionItems2.dateLabel : str, (i3 & 2) != 0 ? sAHistoryTransactionItems2.timeLabel : str2, (i3 & 4) != 0 ? sAHistoryTransactionItems2.amount : str3, (i3 & 8) != 0 ? sAHistoryTransactionItems2.txnIndicator : str4, (i3 & 16) != 0 ? sAHistoryTransactionItems2.userInstrumentLogos : arrayList, (i3 & 32) != 0 ? sAHistoryTransactionItems2.secondPartyInfo : sASecondPartyInfo, (i3 & 64) != 0 ? sAHistoryTransactionItems2.status : str5, (i3 & 128) != 0 ? sAHistoryTransactionItems2.statusKey : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? sAHistoryTransactionItems2.narration : str7, (i3 & 512) != 0 ? sAHistoryTransactionItems2.txnId : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? sAHistoryTransactionItems2.streamSource : str9, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? sAHistoryTransactionItems2.merchantCategory : str10, (i3 & 4096) != 0 ? sAHistoryTransactionItems2.dateTimeEpochMilli : str11, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? sAHistoryTransactionItems2.tranDateEpochMilli : str12);
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

    public final String component13() {
        return this.dateTimeEpochMilli;
    }

    public final String component14() {
        return this.tranDateEpochMilli;
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

    public final ArrayList<SAUserInstrumentLogos> component5() {
        return this.userInstrumentLogos;
    }

    public final SASecondPartyInfo component6() {
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

    public final SAHistoryTransactionItems copy(String str, String str2, String str3, String str4, ArrayList<SAUserInstrumentLogos> arrayList, SASecondPartyInfo sASecondPartyInfo, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return new SAHistoryTransactionItems(str, str2, str3, str4, arrayList, sASecondPartyInfo, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SAHistoryTransactionItems)) {
            return false;
        }
        SAHistoryTransactionItems sAHistoryTransactionItems = (SAHistoryTransactionItems) obj;
        return k.a((Object) this.dateLabel, (Object) sAHistoryTransactionItems.dateLabel) && k.a((Object) this.timeLabel, (Object) sAHistoryTransactionItems.timeLabel) && k.a((Object) this.amount, (Object) sAHistoryTransactionItems.amount) && k.a((Object) this.txnIndicator, (Object) sAHistoryTransactionItems.txnIndicator) && k.a((Object) this.userInstrumentLogos, (Object) sAHistoryTransactionItems.userInstrumentLogos) && k.a((Object) this.secondPartyInfo, (Object) sAHistoryTransactionItems.secondPartyInfo) && k.a((Object) this.status, (Object) sAHistoryTransactionItems.status) && k.a((Object) this.statusKey, (Object) sAHistoryTransactionItems.statusKey) && k.a((Object) this.narration, (Object) sAHistoryTransactionItems.narration) && k.a((Object) this.txnId, (Object) sAHistoryTransactionItems.txnId) && k.a((Object) this.streamSource, (Object) sAHistoryTransactionItems.streamSource) && k.a((Object) this.merchantCategory, (Object) sAHistoryTransactionItems.merchantCategory) && k.a((Object) this.dateTimeEpochMilli, (Object) sAHistoryTransactionItems.dateTimeEpochMilli) && k.a((Object) this.tranDateEpochMilli, (Object) sAHistoryTransactionItems.tranDateEpochMilli);
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
        ArrayList<SAUserInstrumentLogos> arrayList = this.userInstrumentLogos;
        int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        SASecondPartyInfo sASecondPartyInfo = this.secondPartyInfo;
        int hashCode6 = (hashCode5 + (sASecondPartyInfo != null ? sASecondPartyInfo.hashCode() : 0)) * 31;
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
        String str11 = this.dateTimeEpochMilli;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.tranDateEpochMilli;
        if (str12 != null) {
            i2 = str12.hashCode();
        }
        return hashCode13 + i2;
    }

    public final String toString() {
        return "SAHistoryTransactionItems(dateLabel=" + this.dateLabel + ", timeLabel=" + this.timeLabel + ", amount=" + this.amount + ", txnIndicator=" + this.txnIndicator + ", userInstrumentLogos=" + this.userInstrumentLogos + ", secondPartyInfo=" + this.secondPartyInfo + ", status=" + this.status + ", statusKey=" + this.statusKey + ", narration=" + this.narration + ", txnId=" + this.txnId + ", streamSource=" + this.streamSource + ", merchantCategory=" + this.merchantCategory + ", dateTimeEpochMilli=" + this.dateTimeEpochMilli + ", tranDateEpochMilli=" + this.tranDateEpochMilli + ")";
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

    public final ArrayList<SAUserInstrumentLogos> getUserInstrumentLogos() {
        return this.userInstrumentLogos;
    }

    public final void setUserInstrumentLogos(ArrayList<SAUserInstrumentLogos> arrayList) {
        this.userInstrumentLogos = arrayList;
    }

    public final SASecondPartyInfo getSecondPartyInfo() {
        return this.secondPartyInfo;
    }

    public final void setSecondPartyInfo(SASecondPartyInfo sASecondPartyInfo) {
        this.secondPartyInfo = sASecondPartyInfo;
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

    public final String getDateTimeEpochMilli() {
        return this.dateTimeEpochMilli;
    }

    public final void setDateTimeEpochMilli(String str) {
        this.dateTimeEpochMilli = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SAHistoryTransactionItems(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.ArrayList r20, net.one97.paytm.passbook.beans.SASecondPartyInfo r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, kotlin.g.b.g r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.SAHistoryTransactionItems.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, net.one97.paytm.passbook.beans.SASecondPartyInfo, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTranDateEpochMilli() {
        return this.tranDateEpochMilli;
    }

    public final void setTranDateEpochMilli(String str) {
        this.tranDateEpochMilli = str;
    }

    public SAHistoryTransactionItems(String str, String str2, String str3, String str4, ArrayList<SAUserInstrumentLogos> arrayList, SASecondPartyInfo sASecondPartyInfo, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.dateLabel = str;
        this.timeLabel = str2;
        this.amount = str3;
        this.txnIndicator = str4;
        this.userInstrumentLogos = arrayList;
        this.secondPartyInfo = sASecondPartyInfo;
        this.status = str5;
        this.statusKey = str6;
        this.narration = str7;
        this.txnId = str8;
        this.streamSource = str9;
        this.merchantCategory = str10;
        this.dateTimeEpochMilli = str11;
        this.tranDateEpochMilli = str12;
    }
}
