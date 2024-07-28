package net.one97.paytm.passbook.beans.transactionsTag;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class UpdateTagsResponse extends IJRDataModel {
    @b(a = "orderId")
    private String orderId;
    @b(a = "requestGuid")
    private String requestGuid;
    @b(a = "response")
    private Response response;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public UpdateTagsResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Response) null, 63, (g) null);
    }

    public static /* synthetic */ UpdateTagsResponse copy$default(UpdateTagsResponse updateTagsResponse, String str, String str2, String str3, String str4, String str5, Response response2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = updateTagsResponse.requestGuid;
        }
        if ((i2 & 2) != 0) {
            str2 = updateTagsResponse.orderId;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = updateTagsResponse.status;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = updateTagsResponse.statusCode;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = updateTagsResponse.statusMessage;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            response2 = updateTagsResponse.response;
        }
        return updateTagsResponse.copy(str, str6, str7, str8, str9, response2);
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

    public final Response component6() {
        return this.response;
    }

    public final UpdateTagsResponse copy(String str, String str2, String str3, String str4, String str5, Response response2) {
        return new UpdateTagsResponse(str, str2, str3, str4, str5, response2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateTagsResponse)) {
            return false;
        }
        UpdateTagsResponse updateTagsResponse = (UpdateTagsResponse) obj;
        return k.a((Object) this.requestGuid, (Object) updateTagsResponse.requestGuid) && k.a((Object) this.orderId, (Object) updateTagsResponse.orderId) && k.a((Object) this.status, (Object) updateTagsResponse.status) && k.a((Object) this.statusCode, (Object) updateTagsResponse.statusCode) && k.a((Object) this.statusMessage, (Object) updateTagsResponse.statusMessage) && k.a((Object) this.response, (Object) updateTagsResponse.response);
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
        Response response2 = this.response;
        if (response2 != null) {
            i2 = response2.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "UpdateTagsResponse(requestGuid=" + this.requestGuid + ", orderId=" + this.orderId + ", status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", response=" + this.response + ")";
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

    public UpdateTagsResponse(String str, String str2, String str3, String str4, String str5, Response response2) {
        this.requestGuid = str;
        this.orderId = str2;
        this.status = str3;
        this.statusCode = str4;
        this.statusMessage = str5;
        this.response = response2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UpdateTagsResponse(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, net.one97.paytm.passbook.beans.transactionsTag.Response r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.transactionsTag.UpdateTagsResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.passbook.beans.transactionsTag.Response, int, kotlin.g.b.g):void");
    }

    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(Response response2) {
        this.response = response2;
    }
}
