package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EditSubscriptionRequestHead extends IJRPaytmDataModel {
    @b(a = "clientId")
    private final String clientId;
    @b(a = "signature")
    private final String signature;
    @b(a = "timestamp")
    private final String timestamp;
    @b(a = "token")
    private final String token;
    @b(a = "tokenType")
    private final String tokenType;
    @b(a = "version")
    private final String version;

    public EditSubscriptionRequestHead() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ EditSubscriptionRequestHead copy$default(EditSubscriptionRequestHead editSubscriptionRequestHead, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = editSubscriptionRequestHead.clientId;
        }
        if ((i2 & 2) != 0) {
            str2 = editSubscriptionRequestHead.signature;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = editSubscriptionRequestHead.tokenType;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = editSubscriptionRequestHead.version;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = editSubscriptionRequestHead.timestamp;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = editSubscriptionRequestHead.token;
        }
        return editSubscriptionRequestHead.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.signature;
    }

    public final String component3() {
        return this.tokenType;
    }

    public final String component4() {
        return this.version;
    }

    public final String component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.token;
    }

    public final EditSubscriptionRequestHead copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new EditSubscriptionRequestHead(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditSubscriptionRequestHead)) {
            return false;
        }
        EditSubscriptionRequestHead editSubscriptionRequestHead = (EditSubscriptionRequestHead) obj;
        return k.a((Object) this.clientId, (Object) editSubscriptionRequestHead.clientId) && k.a((Object) this.signature, (Object) editSubscriptionRequestHead.signature) && k.a((Object) this.tokenType, (Object) editSubscriptionRequestHead.tokenType) && k.a((Object) this.version, (Object) editSubscriptionRequestHead.version) && k.a((Object) this.timestamp, (Object) editSubscriptionRequestHead.timestamp) && k.a((Object) this.token, (Object) editSubscriptionRequestHead.token);
    }

    public final int hashCode() {
        String str = this.clientId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.signature;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.tokenType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.version;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.timestamp;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.token;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "EditSubscriptionRequestHead(clientId=" + this.clientId + ", signature=" + this.signature + ", tokenType=" + this.tokenType + ", version=" + this.version + ", timestamp=" + this.timestamp + ", token=" + this.token + ")";
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EditSubscriptionRequestHead(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestHead.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getToken() {
        return this.token;
    }

    public EditSubscriptionRequestHead(String str, String str2, String str3, String str4, String str5, String str6) {
        this.clientId = str;
        this.signature = str2;
        this.tokenType = str3;
        this.version = str4;
        this.timestamp = str5;
        this.token = str6;
    }
}
