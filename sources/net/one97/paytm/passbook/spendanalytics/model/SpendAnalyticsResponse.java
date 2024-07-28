package net.one97.paytm.passbook.spendanalytics.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SpendAnalyticsResponse extends IJRDataModel {
    @b(a = "orderId")
    private String orderId;
    @b(a = "requestGuid")
    private String requestGuid;
    private String selectedMonth;
    @b(a = "response")
    private ArrayList<Response> spendAnalyticsResponse;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public SpendAnalyticsResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, 127, (g) null);
    }

    public static /* synthetic */ SpendAnalyticsResponse copy$default(SpendAnalyticsResponse spendAnalyticsResponse2, String str, String str2, String str3, String str4, String str5, ArrayList<Response> arrayList, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = spendAnalyticsResponse2.requestGuid;
        }
        if ((i2 & 2) != 0) {
            str2 = spendAnalyticsResponse2.orderId;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = spendAnalyticsResponse2.status;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = spendAnalyticsResponse2.statusCode;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = spendAnalyticsResponse2.statusMessage;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            arrayList = spendAnalyticsResponse2.spendAnalyticsResponse;
        }
        ArrayList<Response> arrayList2 = arrayList;
        if ((i2 & 64) != 0) {
            str6 = spendAnalyticsResponse2.selectedMonth;
        }
        return spendAnalyticsResponse2.copy(str, str7, str8, str9, str10, arrayList2, str6);
    }

    public final String component1() {
        return this.requestGuid;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.statusCode;
    }

    public final String component5() {
        return this.statusMessage;
    }

    public final ArrayList<Response> component6() {
        return this.spendAnalyticsResponse;
    }

    public final String component7() {
        return this.selectedMonth;
    }

    public final SpendAnalyticsResponse copy(String str, String str2, String str3, String str4, String str5, ArrayList<Response> arrayList, String str6) {
        k.c(arrayList, "spendAnalyticsResponse");
        return new SpendAnalyticsResponse(str, str2, str3, str4, str5, arrayList, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpendAnalyticsResponse)) {
            return false;
        }
        SpendAnalyticsResponse spendAnalyticsResponse2 = (SpendAnalyticsResponse) obj;
        return k.a((Object) this.requestGuid, (Object) spendAnalyticsResponse2.requestGuid) && k.a((Object) this.orderId, (Object) spendAnalyticsResponse2.orderId) && k.a((Object) this.status, (Object) spendAnalyticsResponse2.status) && k.a((Object) this.statusCode, (Object) spendAnalyticsResponse2.statusCode) && k.a((Object) this.statusMessage, (Object) spendAnalyticsResponse2.statusMessage) && k.a((Object) this.spendAnalyticsResponse, (Object) spendAnalyticsResponse2.spendAnalyticsResponse) && k.a((Object) this.selectedMonth, (Object) spendAnalyticsResponse2.selectedMonth);
    }

    public final int hashCode() {
        String str = this.requestGuid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.statusCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.statusMessage;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        ArrayList<Response> arrayList = this.spendAnalyticsResponse;
        int hashCode6 = (hashCode5 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str6 = this.selectedMonth;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "SpendAnalyticsResponse(requestGuid=" + this.requestGuid + ", orderId=" + this.orderId + ", status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", spendAnalyticsResponse=" + this.spendAnalyticsResponse + ", selectedMonth=" + this.selectedMonth + ")";
    }

    public final String getRequestGuid() {
        return this.requestGuid;
    }

    public final void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpendAnalyticsResponse(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.util.ArrayList r12, java.lang.String r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002d
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x002d:
            r5 = r12
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0034
            r14 = r0
            goto L_0x0035
        L_0x0034:
            r14 = r13
        L_0x0035:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final ArrayList<Response> getSpendAnalyticsResponse() {
        return this.spendAnalyticsResponse;
    }

    public final void setSpendAnalyticsResponse(ArrayList<Response> arrayList) {
        k.c(arrayList, "<set-?>");
        this.spendAnalyticsResponse = arrayList;
    }

    public final String getSelectedMonth() {
        return this.selectedMonth;
    }

    public final void setSelectedMonth(String str) {
        this.selectedMonth = str;
    }

    public SpendAnalyticsResponse(String str, String str2, String str3, String str4, String str5, ArrayList<Response> arrayList, String str6) {
        k.c(arrayList, "spendAnalyticsResponse");
        this.requestGuid = str;
        this.orderId = str2;
        this.status = str3;
        this.statusCode = str4;
        this.statusMessage = str5;
        this.spendAnalyticsResponse = arrayList;
        this.selectedMonth = str6;
    }
}
