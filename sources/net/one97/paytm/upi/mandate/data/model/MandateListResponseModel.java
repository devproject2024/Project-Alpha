package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class MandateListResponseModel implements UpiBaseDataModel {
    @c(a = "mandates")
    private final List<MandateItem> mandateItemList;
    @c(a = "respCode")
    private final String respCode;
    @c(a = "respMessage")
    private final String respMessage;
    @c(a = "seqNo")
    private final String seqNo;
    @c(a = "status")
    private final String status;

    public MandateListResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (List) null, 31, (g) null);
    }

    public static /* synthetic */ MandateListResponseModel copy$default(MandateListResponseModel mandateListResponseModel, String str, String str2, String str3, String str4, List<MandateItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mandateListResponseModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = mandateListResponseModel.seqNo;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = mandateListResponseModel.respCode;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = mandateListResponseModel.respMessage;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            list = mandateListResponseModel.mandateItemList;
        }
        return mandateListResponseModel.copy(str, str5, str6, str7, list);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.seqNo;
    }

    public final String component3() {
        return this.respCode;
    }

    public final String component4() {
        return this.respMessage;
    }

    public final List<MandateItem> component5() {
        return this.mandateItemList;
    }

    public final MandateListResponseModel copy(String str, String str2, String str3, String str4, List<MandateItem> list) {
        k.c(str, "status");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "respCode");
        k.c(str4, "respMessage");
        return new MandateListResponseModel(str, str2, str3, str4, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateListResponseModel)) {
            return false;
        }
        MandateListResponseModel mandateListResponseModel = (MandateListResponseModel) obj;
        return k.a((Object) this.status, (Object) mandateListResponseModel.status) && k.a((Object) this.seqNo, (Object) mandateListResponseModel.seqNo) && k.a((Object) this.respCode, (Object) mandateListResponseModel.respCode) && k.a((Object) this.respMessage, (Object) mandateListResponseModel.respMessage) && k.a((Object) this.mandateItemList, (Object) mandateListResponseModel.mandateItemList);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.seqNo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.respCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.respMessage;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<MandateItem> list = this.mandateItemList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "MandateListResponseModel(status=" + this.status + ", seqNo=" + this.seqNo + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", mandateItemList=" + this.mandateItemList + ")";
    }

    public MandateListResponseModel(String str, String str2, String str3, String str4, List<MandateItem> list) {
        k.c(str, "status");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "respCode");
        k.c(str4, "respMessage");
        this.status = str;
        this.seqNo = str2;
        this.respCode = str3;
        this.respMessage = str4;
        this.mandateItemList = list;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MandateListResponseModel(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.List r8, int r9, kotlin.g.b.g r10) {
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
            if (r4 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r5
        L_0x0010:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r6
        L_0x0017:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r7
        L_0x001d:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0022
            r8 = 0
        L_0x0022:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.data.model.MandateListResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.g.b.g):void");
    }

    public final List<MandateItem> getMandateItemList() {
        return this.mandateItemList;
    }
}
