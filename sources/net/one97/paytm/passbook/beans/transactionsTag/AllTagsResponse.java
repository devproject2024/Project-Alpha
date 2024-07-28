package net.one97.paytm.passbook.beans.transactionsTag;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class AllTagsResponse extends IJRDataModel {
    @b(a = "orderId")
    private String orderId;
    @b(a = "requestGuid")
    private String requestGuid;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;
    @b(a = "response")
    private ArrayList<String> tagList;

    public AllTagsResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 63, (g) null);
    }

    public static /* synthetic */ AllTagsResponse copy$default(AllTagsResponse allTagsResponse, String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = allTagsResponse.requestGuid;
        }
        if ((i2 & 2) != 0) {
            str2 = allTagsResponse.orderId;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = allTagsResponse.status;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = allTagsResponse.statusCode;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = allTagsResponse.statusMessage;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            arrayList = allTagsResponse.tagList;
        }
        return allTagsResponse.copy(str, str6, str7, str8, str9, arrayList);
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

    public final ArrayList<String> component6() {
        return this.tagList;
    }

    public final AllTagsResponse copy(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList) {
        k.c(arrayList, "tagList");
        return new AllTagsResponse(str, str2, str3, str4, str5, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AllTagsResponse)) {
            return false;
        }
        AllTagsResponse allTagsResponse = (AllTagsResponse) obj;
        return k.a((Object) this.requestGuid, (Object) allTagsResponse.requestGuid) && k.a((Object) this.orderId, (Object) allTagsResponse.orderId) && k.a((Object) this.status, (Object) allTagsResponse.status) && k.a((Object) this.statusCode, (Object) allTagsResponse.statusCode) && k.a((Object) this.statusMessage, (Object) allTagsResponse.statusMessage) && k.a((Object) this.tagList, (Object) allTagsResponse.tagList);
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
        ArrayList<String> arrayList = this.tagList;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "AllTagsResponse(requestGuid=" + this.requestGuid + ", orderId=" + this.orderId + ", status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", tagList=" + this.tagList + ")";
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

    public AllTagsResponse(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList) {
        k.c(arrayList, "tagList");
        this.requestGuid = str;
        this.orderId = str2;
        this.status = str3;
        this.statusCode = str4;
        this.statusMessage = str5;
        this.tagList = arrayList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AllTagsResponse(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.ArrayList r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r0 = r9
        L_0x0023:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002c
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x002c:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r3
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.transactionsTag.AllTagsResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, int, kotlin.g.b.g):void");
    }

    public final ArrayList<String> getTagList() {
        return this.tagList;
    }

    public final void setTagList(ArrayList<String> arrayList) {
        k.c(arrayList, "<set-?>");
        this.tagList = arrayList;
    }
}
