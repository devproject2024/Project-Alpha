package net.one97.paytm.upi.common.upi;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class ValidateVpaResponse implements UpiBaseDataModel {
    private String accountType;
    private String code;
    private String ifsc;
    private String name;
    private final String respCode;
    private final String respMessage;
    private final String seqNo;
    private String signStatus;
    private final String status;
    private String type;

    public ValidateVpaResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (g) null);
    }

    public static /* synthetic */ ValidateVpaResponse copy$default(ValidateVpaResponse validateVpaResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, Object obj) {
        ValidateVpaResponse validateVpaResponse2 = validateVpaResponse;
        int i3 = i2;
        return validateVpaResponse.copy((i3 & 1) != 0 ? validateVpaResponse2.status : str, (i3 & 2) != 0 ? validateVpaResponse2.respCode : str2, (i3 & 4) != 0 ? validateVpaResponse2.respMessage : str3, (i3 & 8) != 0 ? validateVpaResponse2.seqNo : str4, (i3 & 16) != 0 ? validateVpaResponse2.signStatus : str5, (i3 & 32) != 0 ? validateVpaResponse2.name : str6, (i3 & 64) != 0 ? validateVpaResponse2.code : str7, (i3 & 128) != 0 ? validateVpaResponse2.type : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? validateVpaResponse2.ifsc : str9, (i3 & 512) != 0 ? validateVpaResponse2.accountType : str10);
    }

    public final String component1() {
        return this.status;
    }

    public final String component10() {
        return this.accountType;
    }

    public final String component2() {
        return this.respCode;
    }

    public final String component3() {
        return this.respMessage;
    }

    public final String component4() {
        return this.seqNo;
    }

    public final String component5() {
        return this.signStatus;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.code;
    }

    public final String component8() {
        return this.type;
    }

    public final String component9() {
        return this.ifsc;
    }

    public final ValidateVpaResponse copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return new ValidateVpaResponse(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidateVpaResponse)) {
            return false;
        }
        ValidateVpaResponse validateVpaResponse = (ValidateVpaResponse) obj;
        return k.a((Object) this.status, (Object) validateVpaResponse.status) && k.a((Object) this.respCode, (Object) validateVpaResponse.respCode) && k.a((Object) this.respMessage, (Object) validateVpaResponse.respMessage) && k.a((Object) this.seqNo, (Object) validateVpaResponse.seqNo) && k.a((Object) this.signStatus, (Object) validateVpaResponse.signStatus) && k.a((Object) this.name, (Object) validateVpaResponse.name) && k.a((Object) this.code, (Object) validateVpaResponse.code) && k.a((Object) this.type, (Object) validateVpaResponse.type) && k.a((Object) this.ifsc, (Object) validateVpaResponse.ifsc) && k.a((Object) this.accountType, (Object) validateVpaResponse.accountType);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.respCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.respMessage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.seqNo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.signStatus;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.name;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.code;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.type;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ifsc;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.accountType;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "ValidateVpaResponse(status=" + this.status + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", seqNo=" + this.seqNo + ", signStatus=" + this.signStatus + ", name=" + this.name + ", code=" + this.code + ", type=" + this.type + ", ifsc=" + this.ifsc + ", accountType=" + this.accountType + ")";
    }

    public ValidateVpaResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.status = str;
        this.respCode = str2;
        this.respMessage = str3;
        this.seqNo = str4;
        this.signStatus = str5;
        this.name = str6;
        this.code = str7;
        this.type = str8;
        this.ifsc = str9;
        this.accountType = str10;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getSignStatus() {
        return this.signStatus;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSignStatus(String str) {
        this.signStatus = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ValidateVpaResponse(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.g.b.g r23) {
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
            if (r7 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r2 = r17
        L_0x002e:
            r7 = r0 & 64
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x0036
            r7 = r8
            goto L_0x0038
        L_0x0036:
            r7 = r18
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r8
            goto L_0x0040
        L_0x003e:
            r9 = r19
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r8
            goto L_0x0048
        L_0x0046:
            r10 = r20
        L_0x0048:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r8 = r21
        L_0x004f:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r2
            r19 = r7
            r20 = r9
            r21 = r10
            r22 = r8
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.common.upi.ValidateVpaResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAccountType(String str) {
        this.accountType = str;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
