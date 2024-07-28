package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ViewLifoFdResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "fd_list")
    private final List<LifoRedeemFd> lifoFdList;
    @b(a = "message")
    private final String message;
    @b(a = "response_code")
    private final int responseCode;
    @b(a = "status")
    private final String status;
    @b(a = "txn_id")
    private final String txnId;

    public ViewLifoFdResponse() {
        this((String) null, 0, (String) null, (String) null, (List) null, 31, (g) null);
    }

    public static /* synthetic */ ViewLifoFdResponse copy$default(ViewLifoFdResponse viewLifoFdResponse, String str, int i2, String str2, String str3, List<LifoRedeemFd> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = viewLifoFdResponse.message;
        }
        if ((i3 & 2) != 0) {
            i2 = viewLifoFdResponse.responseCode;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str2 = viewLifoFdResponse.status;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            str3 = viewLifoFdResponse.txnId;
        }
        String str5 = str3;
        if ((i3 & 16) != 0) {
            list = viewLifoFdResponse.lifoFdList;
        }
        return viewLifoFdResponse.copy(str, i4, str4, str5, list);
    }

    public final String component1() {
        return this.message;
    }

    public final int component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.txnId;
    }

    public final List<LifoRedeemFd> component5() {
        return this.lifoFdList;
    }

    public final ViewLifoFdResponse copy(String str, int i2, String str2, String str3, List<LifoRedeemFd> list) {
        k.c(str, "message");
        k.c(str2, "status");
        k.c(str3, "txnId");
        return new ViewLifoFdResponse(str, i2, str2, str3, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ViewLifoFdResponse) {
                ViewLifoFdResponse viewLifoFdResponse = (ViewLifoFdResponse) obj;
                if (k.a((Object) this.message, (Object) viewLifoFdResponse.message)) {
                    if (!(this.responseCode == viewLifoFdResponse.responseCode) || !k.a((Object) this.status, (Object) viewLifoFdResponse.status) || !k.a((Object) this.txnId, (Object) viewLifoFdResponse.txnId) || !k.a((Object) this.lifoFdList, (Object) viewLifoFdResponse.lifoFdList)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.responseCode) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.txnId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<LifoRedeemFd> list = this.lifoFdList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ViewLifoFdResponse(message=" + this.message + ", responseCode=" + this.responseCode + ", status=" + this.status + ", txnId=" + this.txnId + ", lifoFdList=" + this.lifoFdList + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public ViewLifoFdResponse(String str, int i2, String str2, String str3, List<LifoRedeemFd> list) {
        k.c(str, "message");
        k.c(str2, "status");
        k.c(str3, "txnId");
        this.message = str;
        this.responseCode = i2;
        this.status = str2;
        this.txnId = str3;
        this.lifoFdList = list;
    }

    public final List<LifoRedeemFd> getLifoFdList() {
        return this.lifoFdList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ViewLifoFdResponse(java.lang.String r4, int r5, java.lang.String r6, java.lang.String r7, java.util.List r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x0008
            r10 = r0
            goto L_0x0009
        L_0x0008:
            r10 = r4
        L_0x0009:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x0010
            r5 = 0
            r1 = 0
            goto L_0x0011
        L_0x0010:
            r1 = r5
        L_0x0011:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0017
            r2 = r0
            goto L_0x0018
        L_0x0017:
            r2 = r6
        L_0x0018:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r0 = r7
        L_0x001e:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0027
            kotlin.a.w r4 = kotlin.a.w.INSTANCE
            r8 = r4
            java.util.List r8 = (java.util.List) r8
        L_0x0027:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.util.List, int, kotlin.g.b.g):void");
    }
}
