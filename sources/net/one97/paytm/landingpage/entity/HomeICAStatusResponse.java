package net.one97.paytm.landingpage.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.util.UpiConstants;

public final class HomeICAStatusResponse extends IJRPaytmDataModel {
    @b(a = "accountNumber")
    private final String accountNumber;
    @b(a = "agentKycStatus")
    private final boolean agentKycStatus;
    @b(a = "agentTncStatus")
    private final boolean agentTncStatus;
    @b(a = "caId")
    private final String caId;
    @b(a = "errorCode")
    private final int errorCode;
    @b(a = "leadExist")
    private final boolean leadExist;
    @b(a = "leadId")
    private final String leadId;
    @b(a = "leadStatus")
    private final String leadStatus;
    @b(a = "message")
    private final String message;

    public HomeICAStatusResponse() {
        this(false, false, 0, false, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (g) null);
    }

    public static /* synthetic */ HomeICAStatusResponse copy$default(HomeICAStatusResponse homeICAStatusResponse, boolean z, boolean z2, int i2, boolean z3, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        HomeICAStatusResponse homeICAStatusResponse2 = homeICAStatusResponse;
        int i4 = i3;
        return homeICAStatusResponse.copy((i4 & 1) != 0 ? homeICAStatusResponse2.agentKycStatus : z, (i4 & 2) != 0 ? homeICAStatusResponse2.agentTncStatus : z2, (i4 & 4) != 0 ? homeICAStatusResponse2.errorCode : i2, (i4 & 8) != 0 ? homeICAStatusResponse2.leadExist : z3, (i4 & 16) != 0 ? homeICAStatusResponse2.leadStatus : str, (i4 & 32) != 0 ? homeICAStatusResponse2.accountNumber : str2, (i4 & 64) != 0 ? homeICAStatusResponse2.leadId : str3, (i4 & 128) != 0 ? homeICAStatusResponse2.caId : str4, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? homeICAStatusResponse2.message : str5);
    }

    public final boolean component1() {
        return this.agentKycStatus;
    }

    public final boolean component2() {
        return this.agentTncStatus;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final boolean component4() {
        return this.leadExist;
    }

    public final String component5() {
        return this.leadStatus;
    }

    public final String component6() {
        return this.accountNumber;
    }

    public final String component7() {
        return this.leadId;
    }

    public final String component8() {
        return this.caId;
    }

    public final String component9() {
        return this.message;
    }

    public final HomeICAStatusResponse copy(boolean z, boolean z2, int i2, boolean z3, String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        k.c(str6, "leadStatus");
        String str7 = str2;
        k.c(str7, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        String str8 = str3;
        k.c(str8, "leadId");
        String str9 = str4;
        k.c(str9, "caId");
        String str10 = str5;
        k.c(str10, "message");
        return new HomeICAStatusResponse(z, z2, i2, z3, str6, str7, str8, str9, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeICAStatusResponse)) {
            return false;
        }
        HomeICAStatusResponse homeICAStatusResponse = (HomeICAStatusResponse) obj;
        return this.agentKycStatus == homeICAStatusResponse.agentKycStatus && this.agentTncStatus == homeICAStatusResponse.agentTncStatus && this.errorCode == homeICAStatusResponse.errorCode && this.leadExist == homeICAStatusResponse.leadExist && k.a((Object) this.leadStatus, (Object) homeICAStatusResponse.leadStatus) && k.a((Object) this.accountNumber, (Object) homeICAStatusResponse.accountNumber) && k.a((Object) this.leadId, (Object) homeICAStatusResponse.leadId) && k.a((Object) this.caId, (Object) homeICAStatusResponse.caId) && k.a((Object) this.message, (Object) homeICAStatusResponse.message);
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
        int hashCode = (((i2 + (z3 ? 1 : 0)) * 31) + Integer.valueOf(this.errorCode).hashCode()) * 31;
        boolean z4 = this.leadExist;
        if (!z4) {
            z2 = z4;
        }
        int i3 = (hashCode + (z2 ? 1 : 0)) * 31;
        String str = this.leadStatus;
        int i4 = 0;
        int hashCode2 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accountNumber;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.leadId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.caId;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.message;
        if (str5 != null) {
            i4 = str5.hashCode();
        }
        return hashCode5 + i4;
    }

    public final String toString() {
        return "HomeICAStatusResponse(agentKycStatus=" + this.agentKycStatus + ", agentTncStatus=" + this.agentTncStatus + ", errorCode=" + this.errorCode + ", leadExist=" + this.leadExist + ", leadStatus=" + this.leadStatus + ", accountNumber=" + this.accountNumber + ", leadId=" + this.leadId + ", caId=" + this.caId + ", message=" + this.message + ")";
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

    public final boolean getLeadExist() {
        return this.leadExist;
    }

    public final String getLeadStatus() {
        return this.leadStatus;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final String getLeadId() {
        return this.leadId;
    }

    public final String getCaId() {
        return this.caId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeICAStatusResponse(boolean r11, boolean r12, int r13, boolean r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.g.b.g r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = 0
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = r14
        L_0x001e:
            r5 = r0 & 16
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0026
            r5 = r6
            goto L_0x0027
        L_0x0026:
            r5 = r15
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r6
            goto L_0x002f
        L_0x002d:
            r7 = r16
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r6
            goto L_0x0037
        L_0x0035:
            r8 = r17
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r6
            goto L_0x003f
        L_0x003d:
            r9 = r18
        L_0x003f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r6 = r19
        L_0x0046:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r2
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.entity.HomeICAStatusResponse.<init>(boolean, boolean, int, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMessage() {
        return this.message;
    }

    public HomeICAStatusResponse(boolean z, boolean z2, int i2, boolean z3, String str, String str2, String str3, String str4, String str5) {
        k.c(str, "leadStatus");
        k.c(str2, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        k.c(str3, "leadId");
        k.c(str4, "caId");
        k.c(str5, "message");
        this.agentKycStatus = z;
        this.agentTncStatus = z2;
        this.errorCode = i2;
        this.leadExist = z3;
        this.leadStatus = str;
        this.accountNumber = str2;
        this.leadId = str3;
        this.caId = str4;
        this.message = str5;
    }
}
