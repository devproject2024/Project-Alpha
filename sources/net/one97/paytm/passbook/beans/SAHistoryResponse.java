package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class SAHistoryResponse extends IJRDataModel {
    @b(a = "currentPage")
    private String currentPage;
    @b(a = "entityId")
    private String entityId;
    @b(a = "fromDate")
    private String fromDate;
    @b(a = "message")
    private String message;
    @b(a = "paginationParams")
    private SAHistoryPagination paginationParams;
    @b(a = "response_code")
    private String responseCode;
    @b(a = "status")
    private String status;
    @b(a = "toDate")
    private String toDate;
    @b(a = "totalPages")
    private String totalPages;
    @b(a = "txns")
    private ArrayList<SAHistoryTransactionItems> txns;

    public SAHistoryResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (SAHistoryPagination) null, (String) null, (String) null, (String) null, 1023, (g) null);
    }

    public static /* synthetic */ SAHistoryResponse copy$default(SAHistoryResponse sAHistoryResponse, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, SAHistoryPagination sAHistoryPagination, String str6, String str7, String str8, int i2, Object obj) {
        SAHistoryResponse sAHistoryResponse2 = sAHistoryResponse;
        int i3 = i2;
        return sAHistoryResponse.copy((i3 & 1) != 0 ? sAHistoryResponse2.entityId : str, (i3 & 2) != 0 ? sAHistoryResponse2.totalPages : str2, (i3 & 4) != 0 ? sAHistoryResponse2.currentPage : str3, (i3 & 8) != 0 ? sAHistoryResponse2.fromDate : str4, (i3 & 16) != 0 ? sAHistoryResponse2.toDate : str5, (i3 & 32) != 0 ? sAHistoryResponse2.txns : arrayList, (i3 & 64) != 0 ? sAHistoryResponse2.paginationParams : sAHistoryPagination, (i3 & 128) != 0 ? sAHistoryResponse2.message : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? sAHistoryResponse2.responseCode : str7, (i3 & 512) != 0 ? sAHistoryResponse2.status : str8);
    }

    public final String component1() {
        return this.entityId;
    }

    public final String component10() {
        return this.status;
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

    public final ArrayList<SAHistoryTransactionItems> component6() {
        return this.txns;
    }

    public final SAHistoryPagination component7() {
        return this.paginationParams;
    }

    public final String component8() {
        return this.message;
    }

    public final String component9() {
        return this.responseCode;
    }

    public final SAHistoryResponse copy(String str, String str2, String str3, String str4, String str5, ArrayList<SAHistoryTransactionItems> arrayList, SAHistoryPagination sAHistoryPagination, String str6, String str7, String str8) {
        return new SAHistoryResponse(str, str2, str3, str4, str5, arrayList, sAHistoryPagination, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SAHistoryResponse)) {
            return false;
        }
        SAHistoryResponse sAHistoryResponse = (SAHistoryResponse) obj;
        return k.a((Object) this.entityId, (Object) sAHistoryResponse.entityId) && k.a((Object) this.totalPages, (Object) sAHistoryResponse.totalPages) && k.a((Object) this.currentPage, (Object) sAHistoryResponse.currentPage) && k.a((Object) this.fromDate, (Object) sAHistoryResponse.fromDate) && k.a((Object) this.toDate, (Object) sAHistoryResponse.toDate) && k.a((Object) this.txns, (Object) sAHistoryResponse.txns) && k.a((Object) this.paginationParams, (Object) sAHistoryResponse.paginationParams) && k.a((Object) this.message, (Object) sAHistoryResponse.message) && k.a((Object) this.responseCode, (Object) sAHistoryResponse.responseCode) && k.a((Object) this.status, (Object) sAHistoryResponse.status);
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
        ArrayList<SAHistoryTransactionItems> arrayList = this.txns;
        int hashCode6 = (hashCode5 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        SAHistoryPagination sAHistoryPagination = this.paginationParams;
        int hashCode7 = (hashCode6 + (sAHistoryPagination != null ? sAHistoryPagination.hashCode() : 0)) * 31;
        String str6 = this.message;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.responseCode;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.status;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "SAHistoryResponse(entityId=" + this.entityId + ", totalPages=" + this.totalPages + ", currentPage=" + this.currentPage + ", fromDate=" + this.fromDate + ", toDate=" + this.toDate + ", txns=" + this.txns + ", paginationParams=" + this.paginationParams + ", message=" + this.message + ", responseCode=" + this.responseCode + ", status=" + this.status + ")";
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

    public final ArrayList<SAHistoryTransactionItems> getTxns() {
        return this.txns;
    }

    public final void setTxns(ArrayList<SAHistoryTransactionItems> arrayList) {
        this.txns = arrayList;
    }

    public final SAHistoryPagination getPaginationParams() {
        return this.paginationParams;
    }

    public final void setPaginationParams(SAHistoryPagination sAHistoryPagination) {
        this.paginationParams = sAHistoryPagination;
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

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SAHistoryResponse(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.util.ArrayList r17, net.one97.paytm.passbook.beans.SAHistoryPagination r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.g.b.g r23) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.SAHistoryResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, net.one97.paytm.passbook.beans.SAHistoryPagination, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public SAHistoryResponse(String str, String str2, String str3, String str4, String str5, ArrayList<SAHistoryTransactionItems> arrayList, SAHistoryPagination sAHistoryPagination, String str6, String str7, String str8) {
        this.entityId = str;
        this.totalPages = str2;
        this.currentPage = str3;
        this.fromDate = str4;
        this.toDate = str5;
        this.txns = arrayList;
        this.paginationParams = sAHistoryPagination;
        this.message = str6;
        this.responseCode = str7;
        this.status = str8;
    }
}
