package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AuthorisedEditSubscriptionRequestHead extends IJRPaytmDataModel {
    @b(a = "clientId")
    private final String clientId;
    @b(a = "timestamp")
    private final String timestamp;
    @b(a = "token")
    private final String token;
    @b(a = "tokenType")
    private final String tokenType;
    @b(a = "version")
    private final String version;

    public AuthorisedEditSubscriptionRequestHead() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ AuthorisedEditSubscriptionRequestHead copy$default(AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = authorisedEditSubscriptionRequestHead.version;
        }
        if ((i2 & 2) != 0) {
            str2 = authorisedEditSubscriptionRequestHead.timestamp;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = authorisedEditSubscriptionRequestHead.clientId;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = authorisedEditSubscriptionRequestHead.tokenType;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = authorisedEditSubscriptionRequestHead.token;
        }
        return authorisedEditSubscriptionRequestHead.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.clientId;
    }

    public final String component4() {
        return this.tokenType;
    }

    public final String component5() {
        return this.token;
    }

    public final AuthorisedEditSubscriptionRequestHead copy(String str, String str2, String str3, String str4, String str5) {
        return new AuthorisedEditSubscriptionRequestHead(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorisedEditSubscriptionRequestHead)) {
            return false;
        }
        AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead = (AuthorisedEditSubscriptionRequestHead) obj;
        return k.a((Object) this.version, (Object) authorisedEditSubscriptionRequestHead.version) && k.a((Object) this.timestamp, (Object) authorisedEditSubscriptionRequestHead.timestamp) && k.a((Object) this.clientId, (Object) authorisedEditSubscriptionRequestHead.clientId) && k.a((Object) this.tokenType, (Object) authorisedEditSubscriptionRequestHead.tokenType) && k.a((Object) this.token, (Object) authorisedEditSubscriptionRequestHead.token);
    }

    public final int hashCode() {
        String str = this.version;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.timestamp;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clientId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.tokenType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.token;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "AuthorisedEditSubscriptionRequestHead(version=" + this.version + ", timestamp=" + this.timestamp + ", clientId=" + this.clientId + ", tokenType=" + this.tokenType + ", token=" + this.token + ")";
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthorisedEditSubscriptionRequestHead(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestHead.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getToken() {
        return this.token;
    }

    public AuthorisedEditSubscriptionRequestHead(String str, String str2, String str3, String str4, String str5) {
        this.version = str;
        this.timestamp = str2;
        this.clientId = str3;
        this.tokenType = str4;
        this.token = str5;
    }
}
