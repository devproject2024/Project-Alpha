package net.one97.paytm.nativesdk.transactionsummary.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public final class Head implements IJRDataModel {
    private final String clientId;
    private final String signature;
    private final String timestamp;
    private final String tokenType;

    public static /* synthetic */ Head copy$default(Head head, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = head.clientId;
        }
        if ((i2 & 2) != 0) {
            str2 = head.signature;
        }
        if ((i2 & 4) != 0) {
            str3 = head.timestamp;
        }
        if ((i2 & 8) != 0) {
            str4 = head.tokenType;
        }
        return head.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.signature;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final String component4() {
        return this.tokenType;
    }

    public final Head copy(String str, String str2, String str3, String str4) {
        k.c(str, "clientId");
        k.c(str2, "signature");
        k.c(str3, "timestamp");
        k.c(str4, "tokenType");
        return new Head(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Head)) {
            return false;
        }
        Head head = (Head) obj;
        return k.a((Object) this.clientId, (Object) head.clientId) && k.a((Object) this.signature, (Object) head.signature) && k.a((Object) this.timestamp, (Object) head.timestamp) && k.a((Object) this.tokenType, (Object) head.tokenType);
    }

    public final int hashCode() {
        String str = this.clientId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.signature;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.timestamp;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.tokenType;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Head(clientId=" + this.clientId + ", signature=" + this.signature + ", timestamp=" + this.timestamp + ", tokenType=" + this.tokenType + ")";
    }

    public Head(String str, String str2, String str3, String str4) {
        k.c(str, "clientId");
        k.c(str2, "signature");
        k.c(str3, "timestamp");
        k.c(str4, "tokenType");
        this.clientId = str;
        this.signature = str2;
        this.timestamp = str3;
        this.tokenType = str4;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getTokenType() {
        return this.tokenType;
    }
}
