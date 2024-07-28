package net.one97.paytm.upi.mandate.data.model;

import com.appsflyer.internal.referrer.Payload;
import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class CheckMandateStatusResponseModel implements UpiBaseDataModel {
    @c(a = "success")
    private final boolean isSuccess;
    @c(a = "message")
    private final String message;
    @c(a = "MobileAppData")
    private final b mobileAppData;
    @c(a = "response")
    private final String response;
    @c(a = "BankRRN")
    private final String rrn;
    @c(a = "SeqNo")
    private final String seqNo;
    @c(a = "UpiTranlogId")
    private final String upiTranlogId;

    public CheckMandateStatusResponseModel() {
        this(false, (String) null, (String) null, (String) null, (String) null, (String) null, (b) null, 127, (g) null);
    }

    public static /* synthetic */ CheckMandateStatusResponseModel copy$default(CheckMandateStatusResponseModel checkMandateStatusResponseModel, boolean z, String str, String str2, String str3, String str4, String str5, b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = checkMandateStatusResponseModel.isSuccess;
        }
        if ((i2 & 2) != 0) {
            str = checkMandateStatusResponseModel.response;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = checkMandateStatusResponseModel.message;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = checkMandateStatusResponseModel.rrn;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = checkMandateStatusResponseModel.seqNo;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = checkMandateStatusResponseModel.upiTranlogId;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            bVar = checkMandateStatusResponseModel.mobileAppData;
        }
        return checkMandateStatusResponseModel.copy(z, str6, str7, str8, str9, str10, bVar);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final String component2() {
        return this.response;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.rrn;
    }

    public final String component5() {
        return this.seqNo;
    }

    public final String component6() {
        return this.upiTranlogId;
    }

    public final b component7() {
        return this.mobileAppData;
    }

    public final CheckMandateStatusResponseModel copy(boolean z, String str, String str2, String str3, String str4, String str5, b bVar) {
        k.c(str, Payload.RESPONSE);
        k.c(str3, UpiConstants.EXTRA_RRN);
        k.c(str4, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        return new CheckMandateStatusResponseModel(z, str, str2, str3, str4, str5, bVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckMandateStatusResponseModel)) {
            return false;
        }
        CheckMandateStatusResponseModel checkMandateStatusResponseModel = (CheckMandateStatusResponseModel) obj;
        return this.isSuccess == checkMandateStatusResponseModel.isSuccess && k.a((Object) this.response, (Object) checkMandateStatusResponseModel.response) && k.a((Object) this.message, (Object) checkMandateStatusResponseModel.message) && k.a((Object) this.rrn, (Object) checkMandateStatusResponseModel.rrn) && k.a((Object) this.seqNo, (Object) checkMandateStatusResponseModel.seqNo) && k.a((Object) this.upiTranlogId, (Object) checkMandateStatusResponseModel.upiTranlogId) && k.a((Object) this.mobileAppData, (Object) checkMandateStatusResponseModel.mobileAppData);
    }

    public final int hashCode() {
        boolean z = this.isSuccess;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.response;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rrn;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.seqNo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.upiTranlogId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        b bVar = this.mobileAppData;
        if (bVar != null) {
            i3 = bVar.hashCode();
        }
        return hashCode5 + i3;
    }

    public final String toString() {
        return "CheckMandateStatusResponseModel(isSuccess=" + this.isSuccess + ", response=" + this.response + ", message=" + this.message + ", rrn=" + this.rrn + ", seqNo=" + this.seqNo + ", upiTranlogId=" + this.upiTranlogId + ", mobileAppData=" + this.mobileAppData + ")";
    }

    public CheckMandateStatusResponseModel(boolean z, String str, String str2, String str3, String str4, String str5, b bVar) {
        k.c(str, Payload.RESPONSE);
        k.c(str3, UpiConstants.EXTRA_RRN);
        k.c(str4, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        this.isSuccess = z;
        this.response = str;
        this.message = str2;
        this.rrn = str3;
        this.seqNo = str4;
        this.upiTranlogId = str5;
        this.mobileAppData = bVar;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final String getResponse() {
        return this.response;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRrn() {
        return this.rrn;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getUpiTranlogId() {
        return this.upiTranlogId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CheckMandateStatusResponseModel(boolean r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, net.one97.paytm.upi.mandate.data.model.b r12, int r13, kotlin.g.b.g r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0005
            r6 = 0
        L_0x0005:
            r14 = r13 & 2
            java.lang.String r0 = ""
            if (r14 == 0) goto L_0x000d
            r14 = r0
            goto L_0x000e
        L_0x000d:
            r14 = r7
        L_0x000e:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r8
        L_0x0015:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r9
        L_0x001c:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0022
            r3 = r0
            goto L_0x0023
        L_0x0022:
            r3 = r10
        L_0x0023:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r11
        L_0x0029:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x002e
            r12 = 0
        L_0x002e:
            r4 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r0
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.data.model.CheckMandateStatusResponseModel.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.upi.mandate.data.model.b, int, kotlin.g.b.g):void");
    }

    public final b getMobileAppData() {
        return this.mobileAppData;
    }
}
