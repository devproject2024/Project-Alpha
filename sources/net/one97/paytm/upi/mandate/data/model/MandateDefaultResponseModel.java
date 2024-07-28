package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class MandateDefaultResponseModel implements UpiBaseDataModel {
    @c(a = "payeeAccount")
    private final String payeeAccount;
    @c(a = "payeeBankName")
    private final String payeeBankName;
    @c(a = "qrData")
    private final String qrData;
    @c(a = "respCode")
    private final String respCode;
    @c(a = "respMessage")
    private final String respMessage;
    @c(a = "seqNo")
    private final String seqNo;
    @c(a = "status")
    private final String status;

    public MandateDefaultResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (g) null);
    }

    public static /* synthetic */ MandateDefaultResponseModel copy$default(MandateDefaultResponseModel mandateDefaultResponseModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mandateDefaultResponseModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = mandateDefaultResponseModel.seqNo;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = mandateDefaultResponseModel.respCode;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = mandateDefaultResponseModel.respMessage;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = mandateDefaultResponseModel.qrData;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = mandateDefaultResponseModel.payeeAccount;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = mandateDefaultResponseModel.payeeBankName;
        }
        return mandateDefaultResponseModel.copy(str, str8, str9, str10, str11, str12, str7);
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

    public final String component5() {
        return this.qrData;
    }

    public final String component6() {
        return this.payeeAccount;
    }

    public final String component7() {
        return this.payeeBankName;
    }

    public final MandateDefaultResponseModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str, "status");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "respCode");
        k.c(str4, "respMessage");
        return new MandateDefaultResponseModel(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateDefaultResponseModel)) {
            return false;
        }
        MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) obj;
        return k.a((Object) this.status, (Object) mandateDefaultResponseModel.status) && k.a((Object) this.seqNo, (Object) mandateDefaultResponseModel.seqNo) && k.a((Object) this.respCode, (Object) mandateDefaultResponseModel.respCode) && k.a((Object) this.respMessage, (Object) mandateDefaultResponseModel.respMessage) && k.a((Object) this.qrData, (Object) mandateDefaultResponseModel.qrData) && k.a((Object) this.payeeAccount, (Object) mandateDefaultResponseModel.payeeAccount) && k.a((Object) this.payeeBankName, (Object) mandateDefaultResponseModel.payeeBankName);
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
        String str5 = this.qrData;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payeeAccount;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.payeeBankName;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "MandateDefaultResponseModel(status=" + this.status + ", seqNo=" + this.seqNo + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", qrData=" + this.qrData + ", payeeAccount=" + this.payeeAccount + ", payeeBankName=" + this.payeeBankName + ")";
    }

    public MandateDefaultResponseModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str, "status");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "respCode");
        k.c(str4, "respMessage");
        this.status = str;
        this.seqNo = str2;
        this.respCode = str3;
        this.respMessage = str4;
        this.qrData = str5;
        this.payeeAccount = str6;
        this.payeeBankName = str7;
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

    public final String getQrData() {
        return this.qrData;
    }

    public final String getPayeeAccount() {
        return this.payeeAccount;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MandateDefaultResponseModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            java.lang.String r0 = ""
            if (r15 == 0) goto L_0x0008
            r15 = r0
            goto L_0x0009
        L_0x0008:
            r15 = r7
        L_0x0009:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r8
        L_0x0010:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r9
        L_0x0017:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r10
        L_0x001e:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r11
        L_0x0025:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002b
            r5 = r0
            goto L_0x002c
        L_0x002b:
            r5 = r12
        L_0x002c:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0032
            r14 = r0
            goto L_0x0033
        L_0x0032:
            r14 = r13
        L_0x0033:
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getPayeeBankName() {
        return this.payeeBankName;
    }
}
