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

public final class PassbookTransactionHistoryResponse extends IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "closingBalance")
    private String closingBalance;
    @b(a = "cstorderItem")
    private Object cstorderItem;
    @b(a = "currency")
    private String currency;
    @b(a = "dateTime")
    private String dateTime;
    @b(a = "detailNarration")
    private String detailNarration;
    @b(a = "firstInstrument")
    private ArrayList<Instrument> firstInstrument;
    @b(a = "httpCode")
    private Integer httpCode;
    @b(a = "merchantType")
    private String merchantType;
    @b(a = "message")
    private String message;
    @b(a = "notes")
    private final String notes;
    @b(a = "referenceIds")
    private ArrayList<String> referenceIds;
    @b(a = "repeatPayment")
    private RepeatPayment repeatPayment;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "secondInstrument")
    private ArrayList<Instrument> secondInstrument;
    @b(a = "status")
    private String status;
    @b(a = "statusLogoUrl")
    private String statusLogoUrl;
    @b(a = "txnIndicator")
    private Integer txnIndicator;

    public PassbookTransactionHistoryResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, (Integer) null, (ArrayList) null, (ArrayList) null, (Object) null, (String) null, (String) null, (Integer) null, (String) null, (RepeatPayment) null, (String) null, 262143, (g) null);
    }

    public static /* synthetic */ PassbookTransactionHistoryResponse copy$default(PassbookTransactionHistoryResponse passbookTransactionHistoryResponse, String str, String str2, String str3, String str4, String str5, String str6, ArrayList arrayList, String str7, Integer num, ArrayList arrayList2, ArrayList arrayList3, Object obj, String str8, String str9, Integer num2, String str10, RepeatPayment repeatPayment2, String str11, int i2, Object obj2) {
        PassbookTransactionHistoryResponse passbookTransactionHistoryResponse2 = passbookTransactionHistoryResponse;
        int i3 = i2;
        return passbookTransactionHistoryResponse.copy((i3 & 1) != 0 ? passbookTransactionHistoryResponse2.dateTime : str, (i3 & 2) != 0 ? passbookTransactionHistoryResponse2.status : str2, (i3 & 4) != 0 ? passbookTransactionHistoryResponse2.statusLogoUrl : str3, (i3 & 8) != 0 ? passbookTransactionHistoryResponse2.amount : str4, (i3 & 16) != 0 ? passbookTransactionHistoryResponse2.currency : str5, (i3 & 32) != 0 ? passbookTransactionHistoryResponse2.closingBalance : str6, (i3 & 64) != 0 ? passbookTransactionHistoryResponse2.referenceIds : arrayList, (i3 & 128) != 0 ? passbookTransactionHistoryResponse2.detailNarration : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? passbookTransactionHistoryResponse2.txnIndicator : num, (i3 & 512) != 0 ? passbookTransactionHistoryResponse2.firstInstrument : arrayList2, (i3 & TarConstants.EOF_BLOCK) != 0 ? passbookTransactionHistoryResponse2.secondInstrument : arrayList3, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? passbookTransactionHistoryResponse2.cstorderItem : obj, (i3 & 4096) != 0 ? passbookTransactionHistoryResponse2.message : str8, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? passbookTransactionHistoryResponse2.responseCode : str9, (i3 & 16384) != 0 ? passbookTransactionHistoryResponse2.httpCode : num2, (i3 & 32768) != 0 ? passbookTransactionHistoryResponse2.merchantType : str10, (i3 & 65536) != 0 ? passbookTransactionHistoryResponse2.repeatPayment : repeatPayment2, (i3 & 131072) != 0 ? passbookTransactionHistoryResponse2.notes : str11);
    }

    public final String component1() {
        return this.dateTime;
    }

    public final ArrayList<Instrument> component10() {
        return this.firstInstrument;
    }

    public final ArrayList<Instrument> component11() {
        return this.secondInstrument;
    }

    public final Object component12() {
        return this.cstorderItem;
    }

    public final String component13() {
        return this.message;
    }

    public final String component14() {
        return this.responseCode;
    }

    public final Integer component15() {
        return this.httpCode;
    }

    public final String component16() {
        return this.merchantType;
    }

    public final RepeatPayment component17() {
        return this.repeatPayment;
    }

    public final String component18() {
        return this.notes;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.statusLogoUrl;
    }

    public final String component4() {
        return this.amount;
    }

    public final String component5() {
        return this.currency;
    }

    public final String component6() {
        return this.closingBalance;
    }

    public final ArrayList<String> component7() {
        return this.referenceIds;
    }

    public final String component8() {
        return this.detailNarration;
    }

    public final Integer component9() {
        return this.txnIndicator;
    }

    public final PassbookTransactionHistoryResponse copy(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<String> arrayList, String str7, Integer num, ArrayList<Instrument> arrayList2, ArrayList<Instrument> arrayList3, Object obj, String str8, String str9, Integer num2, String str10, RepeatPayment repeatPayment2, String str11) {
        return new PassbookTransactionHistoryResponse(str, str2, str3, str4, str5, str6, arrayList, str7, num, arrayList2, arrayList3, obj, str8, str9, num2, str10, repeatPayment2, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassbookTransactionHistoryResponse)) {
            return false;
        }
        PassbookTransactionHistoryResponse passbookTransactionHistoryResponse = (PassbookTransactionHistoryResponse) obj;
        return k.a((Object) this.dateTime, (Object) passbookTransactionHistoryResponse.dateTime) && k.a((Object) this.status, (Object) passbookTransactionHistoryResponse.status) && k.a((Object) this.statusLogoUrl, (Object) passbookTransactionHistoryResponse.statusLogoUrl) && k.a((Object) this.amount, (Object) passbookTransactionHistoryResponse.amount) && k.a((Object) this.currency, (Object) passbookTransactionHistoryResponse.currency) && k.a((Object) this.closingBalance, (Object) passbookTransactionHistoryResponse.closingBalance) && k.a((Object) this.referenceIds, (Object) passbookTransactionHistoryResponse.referenceIds) && k.a((Object) this.detailNarration, (Object) passbookTransactionHistoryResponse.detailNarration) && k.a((Object) this.txnIndicator, (Object) passbookTransactionHistoryResponse.txnIndicator) && k.a((Object) this.firstInstrument, (Object) passbookTransactionHistoryResponse.firstInstrument) && k.a((Object) this.secondInstrument, (Object) passbookTransactionHistoryResponse.secondInstrument) && k.a(this.cstorderItem, passbookTransactionHistoryResponse.cstorderItem) && k.a((Object) this.message, (Object) passbookTransactionHistoryResponse.message) && k.a((Object) this.responseCode, (Object) passbookTransactionHistoryResponse.responseCode) && k.a((Object) this.httpCode, (Object) passbookTransactionHistoryResponse.httpCode) && k.a((Object) this.merchantType, (Object) passbookTransactionHistoryResponse.merchantType) && k.a((Object) this.repeatPayment, (Object) passbookTransactionHistoryResponse.repeatPayment) && k.a((Object) this.notes, (Object) passbookTransactionHistoryResponse.notes);
    }

    public final int hashCode() {
        String str = this.dateTime;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusLogoUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.amount;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.currency;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.closingBalance;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.referenceIds;
        int hashCode7 = (hashCode6 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str7 = this.detailNarration;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num = this.txnIndicator;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        ArrayList<Instrument> arrayList2 = this.firstInstrument;
        int hashCode10 = (hashCode9 + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        ArrayList<Instrument> arrayList3 = this.secondInstrument;
        int hashCode11 = (hashCode10 + (arrayList3 != null ? arrayList3.hashCode() : 0)) * 31;
        Object obj = this.cstorderItem;
        int hashCode12 = (hashCode11 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str8 = this.message;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.responseCode;
        int hashCode14 = (hashCode13 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Integer num2 = this.httpCode;
        int hashCode15 = (hashCode14 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str10 = this.merchantType;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 31;
        RepeatPayment repeatPayment2 = this.repeatPayment;
        int hashCode17 = (hashCode16 + (repeatPayment2 != null ? repeatPayment2.hashCode() : 0)) * 31;
        String str11 = this.notes;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode17 + i2;
    }

    public final String toString() {
        return "PassbookTransactionHistoryResponse(dateTime=" + this.dateTime + ", status=" + this.status + ", statusLogoUrl=" + this.statusLogoUrl + ", amount=" + this.amount + ", currency=" + this.currency + ", closingBalance=" + this.closingBalance + ", referenceIds=" + this.referenceIds + ", detailNarration=" + this.detailNarration + ", txnIndicator=" + this.txnIndicator + ", firstInstrument=" + this.firstInstrument + ", secondInstrument=" + this.secondInstrument + ", cstorderItem=" + this.cstorderItem + ", message=" + this.message + ", responseCode=" + this.responseCode + ", httpCode=" + this.httpCode + ", merchantType=" + this.merchantType + ", repeatPayment=" + this.repeatPayment + ", notes=" + this.notes + ")";
    }

    public final String getDateTime() {
        return this.dateTime;
    }

    public final void setDateTime(String str) {
        this.dateTime = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusLogoUrl() {
        return this.statusLogoUrl;
    }

    public final void setStatusLogoUrl(String str) {
        this.statusLogoUrl = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final String getClosingBalance() {
        return this.closingBalance;
    }

    public final void setClosingBalance(String str) {
        this.closingBalance = str;
    }

    public final ArrayList<String> getReferenceIds() {
        return this.referenceIds;
    }

    public final void setReferenceIds(ArrayList<String> arrayList) {
        this.referenceIds = arrayList;
    }

    public final String getDetailNarration() {
        return this.detailNarration;
    }

    public final void setDetailNarration(String str) {
        this.detailNarration = str;
    }

    public final Integer getTxnIndicator() {
        return this.txnIndicator;
    }

    public final void setTxnIndicator(Integer num) {
        this.txnIndicator = num;
    }

    public final ArrayList<Instrument> getFirstInstrument() {
        return this.firstInstrument;
    }

    public final void setFirstInstrument(ArrayList<Instrument> arrayList) {
        this.firstInstrument = arrayList;
    }

    public final ArrayList<Instrument> getSecondInstrument() {
        return this.secondInstrument;
    }

    public final void setSecondInstrument(ArrayList<Instrument> arrayList) {
        this.secondInstrument = arrayList;
    }

    public final Object getCstorderItem() {
        return this.cstorderItem;
    }

    public final void setCstorderItem(Object obj) {
        this.cstorderItem = obj;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(String str) {
        this.responseCode = str;
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final void setHttpCode(Integer num) {
        this.httpCode = num;
    }

    public final String getMerchantType() {
        return this.merchantType;
    }

    public final void setMerchantType(String str) {
        this.merchantType = str;
    }

    public final RepeatPayment getRepeatPayment() {
        return this.repeatPayment;
    }

    public final void setRepeatPayment(RepeatPayment repeatPayment2) {
        this.repeatPayment = repeatPayment2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PassbookTransactionHistoryResponse(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.util.ArrayList r26, java.lang.String r27, java.lang.Integer r28, java.util.ArrayList r29, java.util.ArrayList r30, java.lang.Object r31, java.lang.String r32, java.lang.String r33, java.lang.Integer r34, java.lang.String r35, net.one97.paytm.passbook.beans.RepeatPayment r36, java.lang.String r37, int r38, kotlin.g.b.g r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r21
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r22
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r23
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r24
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r25
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r26
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r27
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r28
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r29
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r30
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r31
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r32
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r33
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r34
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r35
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r36
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x0099
            r0 = 0
            goto L_0x009b
        L_0x0099:
            r0 = r37
        L_0x009b:
            r20 = r19
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.Integer, java.util.ArrayList, java.util.ArrayList, java.lang.Object, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, net.one97.paytm.passbook.beans.RepeatPayment, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getNotes() {
        return this.notes;
    }

    public PassbookTransactionHistoryResponse(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<String> arrayList, String str7, Integer num, ArrayList<Instrument> arrayList2, ArrayList<Instrument> arrayList3, Object obj, String str8, String str9, Integer num2, String str10, RepeatPayment repeatPayment2, String str11) {
        this.dateTime = str;
        this.status = str2;
        this.statusLogoUrl = str3;
        this.amount = str4;
        this.currency = str5;
        this.closingBalance = str6;
        this.referenceIds = arrayList;
        this.detailNarration = str7;
        this.txnIndicator = num;
        this.firstInstrument = arrayList2;
        this.secondInstrument = arrayList3;
        this.cstorderItem = obj;
        this.message = str8;
        this.responseCode = str9;
        this.httpCode = num2;
        this.merchantType = str10;
        this.repeatPayment = repeatPayment2;
        this.notes = str11;
    }
}
