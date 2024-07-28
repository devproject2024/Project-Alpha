package net.one97.paytm.bankOpen.ica.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class ICATrackLeadResponse extends IJRPaytmDataModel {
    @b(a = "agentKycStatus")
    private final boolean agentKycStatus;
    @b(a = "agentTncStatus")
    private final boolean agentTncStatus;
    @b(a = "errorCode")
    private final int errorCode;
    @b(a = "kycStatus")
    private final boolean kycStatus;
    @b(a = "message")
    private final String message;
    @b(a = "nocStatus")
    private final String nocStatus;
    @b(a = "nomineeStatus")
    private final boolean nomineeStatus;
    @b(a = "passcodeStatus")
    private final boolean passcodeStatus;
    @b(a = "refresh")
    private final boolean refresh;
    @b(a = "requestUUID")
    private final String requestUUID;
    @b(a = "tncStatus")
    private final String tncStatus;

    public ICATrackLeadResponse() {
        this(false, false, 0, (String) null, (String) null, (String) null, false, (String) null, false, false, false, 2047, (g) null);
    }

    public static /* synthetic */ ICATrackLeadResponse copy$default(ICATrackLeadResponse iCATrackLeadResponse, boolean z, boolean z2, int i2, String str, String str2, String str3, boolean z3, String str4, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        ICATrackLeadResponse iCATrackLeadResponse2 = iCATrackLeadResponse;
        int i4 = i3;
        return iCATrackLeadResponse.copy((i4 & 1) != 0 ? iCATrackLeadResponse2.agentKycStatus : z, (i4 & 2) != 0 ? iCATrackLeadResponse2.agentTncStatus : z2, (i4 & 4) != 0 ? iCATrackLeadResponse2.errorCode : i2, (i4 & 8) != 0 ? iCATrackLeadResponse2.message : str, (i4 & 16) != 0 ? iCATrackLeadResponse2.requestUUID : str2, (i4 & 32) != 0 ? iCATrackLeadResponse2.tncStatus : str3, (i4 & 64) != 0 ? iCATrackLeadResponse2.passcodeStatus : z3, (i4 & 128) != 0 ? iCATrackLeadResponse2.nocStatus : str4, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? iCATrackLeadResponse2.nomineeStatus : z4, (i4 & 512) != 0 ? iCATrackLeadResponse2.refresh : z5, (i4 & TarConstants.EOF_BLOCK) != 0 ? iCATrackLeadResponse2.kycStatus : z6);
    }

    public final boolean component1() {
        return this.agentKycStatus;
    }

    public final boolean component10() {
        return this.refresh;
    }

    public final boolean component11() {
        return this.kycStatus;
    }

    public final boolean component2() {
        return this.agentTncStatus;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.message;
    }

    public final String component5() {
        return this.requestUUID;
    }

    public final String component6() {
        return this.tncStatus;
    }

    public final boolean component7() {
        return this.passcodeStatus;
    }

    public final String component8() {
        return this.nocStatus;
    }

    public final boolean component9() {
        return this.nomineeStatus;
    }

    public final ICATrackLeadResponse copy(boolean z, boolean z2, int i2, String str, String str2, String str3, boolean z3, String str4, boolean z4, boolean z5, boolean z6) {
        String str5 = str;
        k.c(str5, "message");
        String str6 = str2;
        k.c(str6, "requestUUID");
        String str7 = str3;
        k.c(str7, "tncStatus");
        String str8 = str4;
        k.c(str8, "nocStatus");
        return new ICATrackLeadResponse(z, z2, i2, str5, str6, str7, z3, str8, z4, z5, z6);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ICATrackLeadResponse) {
                ICATrackLeadResponse iCATrackLeadResponse = (ICATrackLeadResponse) obj;
                if (this.agentKycStatus == iCATrackLeadResponse.agentKycStatus) {
                    if (this.agentTncStatus == iCATrackLeadResponse.agentTncStatus) {
                        if ((this.errorCode == iCATrackLeadResponse.errorCode) && k.a((Object) this.message, (Object) iCATrackLeadResponse.message) && k.a((Object) this.requestUUID, (Object) iCATrackLeadResponse.requestUUID) && k.a((Object) this.tncStatus, (Object) iCATrackLeadResponse.tncStatus)) {
                            if ((this.passcodeStatus == iCATrackLeadResponse.passcodeStatus) && k.a((Object) this.nocStatus, (Object) iCATrackLeadResponse.nocStatus)) {
                                if (this.nomineeStatus == iCATrackLeadResponse.nomineeStatus) {
                                    if (this.refresh == iCATrackLeadResponse.refresh) {
                                        if (this.kycStatus == iCATrackLeadResponse.kycStatus) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.agentKycStatus;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.agentTncStatus;
        if (z3) {
            z3 = true;
        }
        int i3 = (((i2 + (z3 ? 1 : 0)) * 31) + this.errorCode) * 31;
        String str = this.message;
        int i4 = 0;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.requestUUID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.tncStatus;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z4 = this.passcodeStatus;
        if (z4) {
            z4 = true;
        }
        int i5 = (hashCode3 + (z4 ? 1 : 0)) * 31;
        String str4 = this.nocStatus;
        if (str4 != null) {
            i4 = str4.hashCode();
        }
        int i6 = (i5 + i4) * 31;
        boolean z5 = this.nomineeStatus;
        if (z5) {
            z5 = true;
        }
        int i7 = (i6 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.refresh;
        if (z6) {
            z6 = true;
        }
        int i8 = (i7 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.kycStatus;
        if (!z7) {
            z2 = z7;
        }
        return i8 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "ICATrackLeadResponse(agentKycStatus=" + this.agentKycStatus + ", agentTncStatus=" + this.agentTncStatus + ", errorCode=" + this.errorCode + ", message=" + this.message + ", requestUUID=" + this.requestUUID + ", tncStatus=" + this.tncStatus + ", passcodeStatus=" + this.passcodeStatus + ", nocStatus=" + this.nocStatus + ", nomineeStatus=" + this.nomineeStatus + ", refresh=" + this.refresh + ", kycStatus=" + this.kycStatus + ")";
    }

    public final boolean getAgentKycStatus() {
        return this.agentKycStatus;
    }

    public final boolean getAgentTncStatus() {
        return this.agentTncStatus;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRequestUUID() {
        return this.requestUUID;
    }

    public final String getTncStatus() {
        return this.tncStatus;
    }

    public final boolean getPasscodeStatus() {
        return this.passcodeStatus;
    }

    public final String getNocStatus() {
        return this.nocStatus;
    }

    public final boolean getNomineeStatus() {
        return this.nomineeStatus;
    }

    public final boolean getRefresh() {
        return this.refresh;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ICATrackLeadResponse(boolean r13, boolean r14, int r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19, java.lang.String r20, boolean r21, boolean r22, boolean r23, int r24, kotlin.g.b.g r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = 0
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0020
            r5 = r6
            goto L_0x0022
        L_0x0020:
            r5 = r16
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = r6
            goto L_0x002a
        L_0x0028:
            r7 = r17
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = r6
            goto L_0x0032
        L_0x0030:
            r8 = r18
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r19
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r6 = r20
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = 0
            goto L_0x0049
        L_0x0047:
            r10 = r21
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = 0
            goto L_0x0051
        L_0x004f:
            r11 = r22
        L_0x0051:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r2 = r23
        L_0x0058:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r6
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.ica.model.ICATrackLeadResponse.<init>(boolean, boolean, int, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, boolean, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean getKycStatus() {
        return this.kycStatus;
    }

    public ICATrackLeadResponse(boolean z, boolean z2, int i2, String str, String str2, String str3, boolean z3, String str4, boolean z4, boolean z5, boolean z6) {
        k.c(str, "message");
        k.c(str2, "requestUUID");
        k.c(str3, "tncStatus");
        k.c(str4, "nocStatus");
        this.agentKycStatus = z;
        this.agentTncStatus = z2;
        this.errorCode = i2;
        this.message = str;
        this.requestUUID = str2;
        this.tncStatus = str3;
        this.passcodeStatus = z3;
        this.nocStatus = str4;
        this.nomineeStatus = z4;
        this.refresh = z5;
        this.kycStatus = z6;
    }
}
