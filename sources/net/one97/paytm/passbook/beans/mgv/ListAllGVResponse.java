package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class ListAllGVResponse extends IJRDataModel {
    @b(a = "count")
    private Integer count;
    @b(a = "mgvListPGResponseVO")
    private GVListData data;
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "status")
    private String status;

    public ListAllGVResponse() {
        this((GVListData) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ ListAllGVResponse copy$default(ListAllGVResponse listAllGVResponse, GVListData gVListData, String str, Integer num, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gVListData = listAllGVResponse.data;
        }
        if ((i2 & 2) != 0) {
            str = listAllGVResponse.status;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            num = listAllGVResponse.count;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str2 = listAllGVResponse.resultCode;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = listAllGVResponse.errorMessage;
        }
        return listAllGVResponse.copy(gVListData, str4, num2, str5, str3);
    }

    public final GVListData component1() {
        return this.data;
    }

    public final String component2() {
        return this.status;
    }

    public final Integer component3() {
        return this.count;
    }

    public final String component4() {
        return this.resultCode;
    }

    public final String component5() {
        return this.errorMessage;
    }

    public final ListAllGVResponse copy(GVListData gVListData, String str, Integer num, String str2, String str3) {
        return new ListAllGVResponse(gVListData, str, num, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListAllGVResponse)) {
            return false;
        }
        ListAllGVResponse listAllGVResponse = (ListAllGVResponse) obj;
        return k.a((Object) this.data, (Object) listAllGVResponse.data) && k.a((Object) this.status, (Object) listAllGVResponse.status) && k.a((Object) this.count, (Object) listAllGVResponse.count) && k.a((Object) this.resultCode, (Object) listAllGVResponse.resultCode) && k.a((Object) this.errorMessage, (Object) listAllGVResponse.errorMessage);
    }

    public final int hashCode() {
        GVListData gVListData = this.data;
        int i2 = 0;
        int hashCode = (gVListData != null ? gVListData.hashCode() : 0) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.count;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.resultCode;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.errorMessage;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ListAllGVResponse(data=" + this.data + ", status=" + this.status + ", count=" + this.count + ", resultCode=" + this.resultCode + ", errorMessage=" + this.errorMessage + ")";
    }

    public final GVListData getData() {
        return this.data;
    }

    public final void setData(GVListData gVListData) {
        this.data = gVListData;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final void setCount(Integer num) {
        this.count = num;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public ListAllGVResponse(GVListData gVListData, String str, Integer num, String str2, String str3) {
        this.data = gVListData;
        this.status = str;
        this.count = num;
        this.resultCode = str2;
        this.errorMessage = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ListAllGVResponse(net.one97.paytm.passbook.beans.mgv.GVListData r5, java.lang.String r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.mgv.ListAllGVResponse.<init>(net.one97.paytm.passbook.beans.mgv.GVListData, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
