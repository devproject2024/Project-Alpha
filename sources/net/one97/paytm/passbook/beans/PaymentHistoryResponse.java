package net.one97.paytm.passbook.beans;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentHistoryResponse extends IJRDataModel {
    @b(a = "currentPage")
    private String currentPage;
    @b(a = "entityId")
    private String entityId;
    @b(a = "fromDate")
    private String fromDate;
    @b(a = "httpCode")
    private Integer httpCode;
    @b(a = "message")
    private String message;
    @b(a = "paginationParams")
    private PaymentHistoryPagination paginationParams;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;
    @b(a = "toDate")
    private String toDate;
    @b(a = "totalPages")
    private String totalPages;
    @b(a = "txns")
    private ArrayList<PaymentHistoryTransactionItems> txns;

    public PaymentHistoryResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (PaymentHistoryPagination) null, (String) null, (String) null, (String) null, (Integer) null, 2047, (g) null);
    }

    public static /* synthetic */ PaymentHistoryResponse copy$default(PaymentHistoryResponse paymentHistoryResponse, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, PaymentHistoryPagination paymentHistoryPagination, String str6, String str7, String str8, Integer num, int i2, Object obj) {
        PaymentHistoryResponse paymentHistoryResponse2 = paymentHistoryResponse;
        int i3 = i2;
        return paymentHistoryResponse.copy((i3 & 1) != 0 ? paymentHistoryResponse2.entityId : str, (i3 & 2) != 0 ? paymentHistoryResponse2.totalPages : str2, (i3 & 4) != 0 ? paymentHistoryResponse2.currentPage : str3, (i3 & 8) != 0 ? paymentHistoryResponse2.fromDate : str4, (i3 & 16) != 0 ? paymentHistoryResponse2.toDate : str5, (i3 & 32) != 0 ? paymentHistoryResponse2.txns : arrayList, (i3 & 64) != 0 ? paymentHistoryResponse2.paginationParams : paymentHistoryPagination, (i3 & 128) != 0 ? paymentHistoryResponse2.message : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentHistoryResponse2.responseCode : str7, (i3 & 512) != 0 ? paymentHistoryResponse2.status : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentHistoryResponse2.httpCode : num);
    }

    public final String component1() {
        return this.entityId;
    }

    public final String component10() {
        return this.status;
    }

    public final Integer component11() {
        return this.httpCode;
    }

    public final String component2() {
        return this.totalPages;
    }

    public final String component3() {
        return this.currentPage;
    }

    public final String component4() {
        return this.fromDate;
    }

    public final String component5() {
        return this.toDate;
    }

    public final ArrayList<PaymentHistoryTransactionItems> component6() {
        return this.txns;
    }

    public final PaymentHistoryPagination component7() {
        return this.paginationParams;
    }

    public final String component8() {
        return this.message;
    }

    public final String component9() {
        return this.responseCode;
    }

    public final PaymentHistoryResponse copy(String str, String str2, String str3, String str4, String str5, ArrayList<PaymentHistoryTransactionItems> arrayList, PaymentHistoryPagination paymentHistoryPagination, String str6, String str7, String str8, Integer num) {
        return new PaymentHistoryResponse(str, str2, str3, str4, str5, arrayList, paymentHistoryPagination, str6, str7, str8, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentHistoryResponse)) {
            return false;
        }
        PaymentHistoryResponse paymentHistoryResponse = (PaymentHistoryResponse) obj;
        return k.a((Object) this.entityId, (Object) paymentHistoryResponse.entityId) && k.a((Object) this.totalPages, (Object) paymentHistoryResponse.totalPages) && k.a((Object) this.currentPage, (Object) paymentHistoryResponse.currentPage) && k.a((Object) this.fromDate, (Object) paymentHistoryResponse.fromDate) && k.a((Object) this.toDate, (Object) paymentHistoryResponse.toDate) && k.a((Object) this.txns, (Object) paymentHistoryResponse.txns) && k.a((Object) this.paginationParams, (Object) paymentHistoryResponse.paginationParams) && k.a((Object) this.message, (Object) paymentHistoryResponse.message) && k.a((Object) this.responseCode, (Object) paymentHistoryResponse.responseCode) && k.a((Object) this.status, (Object) paymentHistoryResponse.status) && k.a((Object) this.httpCode, (Object) paymentHistoryResponse.httpCode);
    }

    public final int hashCode() {
        String str = this.entityId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.totalPages;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.currentPage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fromDate;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.toDate;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        ArrayList<PaymentHistoryTransactionItems> arrayList = this.txns;
        int hashCode6 = (hashCode5 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        PaymentHistoryPagination paymentHistoryPagination = this.paginationParams;
        int hashCode7 = (hashCode6 + (paymentHistoryPagination != null ? paymentHistoryPagination.hashCode() : 0)) * 31;
        String str6 = this.message;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.responseCode;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.status;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num = this.httpCode;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "PaymentHistoryResponse(entityId=" + this.entityId + ", totalPages=" + this.totalPages + ", currentPage=" + this.currentPage + ", fromDate=" + this.fromDate + ", toDate=" + this.toDate + ", txns=" + this.txns + ", paginationParams=" + this.paginationParams + ", message=" + this.message + ", responseCode=" + this.responseCode + ", status=" + this.status + ", httpCode=" + this.httpCode + ")";
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final void setEntityId(String str) {
        this.entityId = str;
    }

    public final String getTotalPages() {
        return this.totalPages;
    }

    public final void setTotalPages(String str) {
        this.totalPages = str;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final void setCurrentPage(String str) {
        this.currentPage = str;
    }

    public final String getFromDate() {
        return this.fromDate;
    }

    public final void setFromDate(String str) {
        this.fromDate = str;
    }

    public final String getToDate() {
        return this.toDate;
    }

    public final void setToDate(String str) {
        this.toDate = str;
    }

    public final ArrayList<PaymentHistoryTransactionItems> getTxns() {
        return this.txns;
    }

    public final void setTxns(ArrayList<PaymentHistoryTransactionItems> arrayList) {
        this.txns = arrayList;
    }

    public final PaymentHistoryPagination getPaginationParams() {
        return this.paginationParams;
    }

    public final void setPaginationParams(PaymentHistoryPagination paymentHistoryPagination) {
        this.paginationParams = paymentHistoryPagination;
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

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentHistoryResponse(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.util.ArrayList r18, net.one97.paytm.passbook.beans.PaymentHistoryPagination r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.Integer r23, int r24, kotlin.g.b.g r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r2
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.PaymentHistoryResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, net.one97.paytm.passbook.beans.PaymentHistoryPagination, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.g.b.g):void");
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final void setHttpCode(Integer num) {
        this.httpCode = num;
    }

    public PaymentHistoryResponse(String str, String str2, String str3, String str4, String str5, ArrayList<PaymentHistoryTransactionItems> arrayList, PaymentHistoryPagination paymentHistoryPagination, String str6, String str7, String str8, Integer num) {
        this.entityId = str;
        this.totalPages = str2;
        this.currentPage = str3;
        this.fromDate = str4;
        this.toDate = str5;
        this.txns = arrayList;
        this.paginationParams = paymentHistoryPagination;
        this.message = str6;
        this.responseCode = str7;
        this.status = str8;
        this.httpCode = num;
    }
}
