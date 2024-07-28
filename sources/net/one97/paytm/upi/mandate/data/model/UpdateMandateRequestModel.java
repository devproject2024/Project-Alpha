package net.one97.paytm.upi.mandate.data.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class UpdateMandateRequestModel implements UpiBaseDataModel {
    @c(a = "amount")
    private final String amount;
    @c(a = "deviceId")
    private final String deviceId;
    @c(a = "initiationMode")
    private final String initiationMode;
    @c(a = "mpin")
    private final String mpin;
    @c(a = "operation")
    private final String operation;
    @c(a = "refCategory")
    private final String refCategory;
    @c(a = "refId")
    private final String refId;
    @c(a = "refUrl")
    private final String refUrl;
    @c(a = "seqNo")
    private final String seqNo;
    @c(a = "umn")
    private final String umn;
    @c(a = "validityEndDate")
    private final String validityEndDate;

    public static /* synthetic */ UpdateMandateRequestModel copy$default(UpdateMandateRequestModel updateMandateRequestModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, Object obj) {
        UpdateMandateRequestModel updateMandateRequestModel2 = updateMandateRequestModel;
        int i3 = i2;
        return updateMandateRequestModel.copy((i3 & 1) != 0 ? updateMandateRequestModel2.seqNo : str, (i3 & 2) != 0 ? updateMandateRequestModel2.deviceId : str2, (i3 & 4) != 0 ? updateMandateRequestModel2.mpin : str3, (i3 & 8) != 0 ? updateMandateRequestModel2.umn : str4, (i3 & 16) != 0 ? updateMandateRequestModel2.operation : str5, (i3 & 32) != 0 ? updateMandateRequestModel2.validityEndDate : str6, (i3 & 64) != 0 ? updateMandateRequestModel2.amount : str7, (i3 & 128) != 0 ? updateMandateRequestModel2.refId : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? updateMandateRequestModel2.refUrl : str9, (i3 & 512) != 0 ? updateMandateRequestModel2.refCategory : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? updateMandateRequestModel2.initiationMode : str11);
    }

    public final String component1() {
        return this.seqNo;
    }

    public final String component10() {
        return this.refCategory;
    }

    public final String component11() {
        return this.initiationMode;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.mpin;
    }

    public final String component4() {
        return this.umn;
    }

    public final String component5() {
        return this.operation;
    }

    public final String component6() {
        return this.validityEndDate;
    }

    public final String component7() {
        return this.amount;
    }

    public final String component8() {
        return this.refId;
    }

    public final String component9() {
        return this.refUrl;
    }

    public final UpdateMandateRequestModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        String str12 = str3;
        k.c(str12, PayUtility.MPIN);
        String str13 = str4;
        k.c(str13, "umn");
        String str14 = str5;
        k.c(str14, "operation");
        String str15 = str7;
        k.c(str15, "amount");
        return new UpdateMandateRequestModel(str, str2, str12, str13, str14, str6, str15, str8, str9, str10, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateMandateRequestModel)) {
            return false;
        }
        UpdateMandateRequestModel updateMandateRequestModel = (UpdateMandateRequestModel) obj;
        return k.a((Object) this.seqNo, (Object) updateMandateRequestModel.seqNo) && k.a((Object) this.deviceId, (Object) updateMandateRequestModel.deviceId) && k.a((Object) this.mpin, (Object) updateMandateRequestModel.mpin) && k.a((Object) this.umn, (Object) updateMandateRequestModel.umn) && k.a((Object) this.operation, (Object) updateMandateRequestModel.operation) && k.a((Object) this.validityEndDate, (Object) updateMandateRequestModel.validityEndDate) && k.a((Object) this.amount, (Object) updateMandateRequestModel.amount) && k.a((Object) this.refId, (Object) updateMandateRequestModel.refId) && k.a((Object) this.refUrl, (Object) updateMandateRequestModel.refUrl) && k.a((Object) this.refCategory, (Object) updateMandateRequestModel.refCategory) && k.a((Object) this.initiationMode, (Object) updateMandateRequestModel.initiationMode);
    }

    public final int hashCode() {
        String str = this.seqNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mpin;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.umn;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.operation;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.validityEndDate;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.amount;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.refId;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.refUrl;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.refCategory;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.initiationMode;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "UpdateMandateRequestModel(seqNo=" + this.seqNo + ", deviceId=" + this.deviceId + ", mpin=" + this.mpin + ", umn=" + this.umn + ", operation=" + this.operation + ", validityEndDate=" + this.validityEndDate + ", amount=" + this.amount + ", refId=" + this.refId + ", refUrl=" + this.refUrl + ", refCategory=" + this.refCategory + ", initiationMode=" + this.initiationMode + ")";
    }

    public UpdateMandateRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, PayUtility.MPIN);
        k.c(str4, "umn");
        k.c(str5, "operation");
        k.c(str7, "amount");
        this.seqNo = str;
        this.deviceId = str2;
        this.mpin = str3;
        this.umn = str4;
        this.operation = str5;
        this.validityEndDate = str6;
        this.amount = str7;
        this.refId = str8;
        this.refUrl = str9;
        this.refCategory = str10;
        this.initiationMode = str11;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getMpin() {
        return this.mpin;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getValidityEndDate() {
        return this.validityEndDate;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getRefUrl() {
        return this.refUrl;
    }

    public final String getRefCategory() {
        return this.refCategory;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UpdateMandateRequestModel(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, kotlin.g.b.g r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 128(0x80, float:1.794E-43)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r11 = r2
            goto L_0x000c
        L_0x000a:
            r11 = r23
        L_0x000c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0012
            r12 = r2
            goto L_0x0014
        L_0x0012:
            r12 = r24
        L_0x0014:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x001a
            r13 = r2
            goto L_0x001c
        L_0x001a:
            r13 = r25
        L_0x001c:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0022
            r14 = r2
            goto L_0x0024
        L_0x0022:
            r14 = r26
        L_0x0024:
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.data.model.UpdateMandateRequestModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getInitiationMode() {
        return this.initiationMode;
    }
}
