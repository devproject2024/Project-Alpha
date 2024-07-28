package net.one97.paytm.upi.common.upi;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class CreateSignatureResponse implements UpiBaseDataModel {
    private final String respCode;
    private final String respMessage;
    private final String seqNo;
    private String signature;
    private final String status;

    public CreateSignatureResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ CreateSignatureResponse copy$default(CreateSignatureResponse createSignatureResponse, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createSignatureResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = createSignatureResponse.respCode;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = createSignatureResponse.respMessage;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = createSignatureResponse.seqNo;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = createSignatureResponse.signature;
        }
        return createSignatureResponse.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.status;
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
        return this.signature;
    }

    public final CreateSignatureResponse copy(String str, String str2, String str3, String str4, String str5) {
        return new CreateSignatureResponse(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateSignatureResponse)) {
            return false;
        }
        CreateSignatureResponse createSignatureResponse = (CreateSignatureResponse) obj;
        return k.a((Object) this.status, (Object) createSignatureResponse.status) && k.a((Object) this.respCode, (Object) createSignatureResponse.respCode) && k.a((Object) this.respMessage, (Object) createSignatureResponse.respMessage) && k.a((Object) this.seqNo, (Object) createSignatureResponse.seqNo) && k.a((Object) this.signature, (Object) createSignatureResponse.signature);
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
        String str5 = this.signature;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CreateSignatureResponse(status=" + this.status + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", seqNo=" + this.seqNo + ", signature=" + this.signature + ")";
    }

    public CreateSignatureResponse(String str, String str2, String str3, String str4, String str5) {
        this.status = str;
        this.respCode = str2;
        this.respMessage = str3;
        this.seqNo = str4;
        this.signature = str5;
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

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CreateSignatureResponse(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.common.upi.CreateSignatureResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final void setSignature(String str) {
        this.signature = str;
    }
}
