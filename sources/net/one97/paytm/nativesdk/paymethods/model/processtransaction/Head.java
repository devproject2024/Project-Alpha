package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class Head implements Serializable {
    private String channelId;
    private String requestTimestamp;
    private String txnToken;
    private String version;

    public static /* synthetic */ Head copy$default(Head head, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = head.version;
        }
        if ((i2 & 2) != 0) {
            str2 = head.requestTimestamp;
        }
        if ((i2 & 4) != 0) {
            str3 = head.channelId;
        }
        if ((i2 & 8) != 0) {
            str4 = head.txnToken;
        }
        return head.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.requestTimestamp;
    }

    public final String component3() {
        return this.channelId;
    }

    public final String component4() {
        return this.txnToken;
    }

    public final Head copy(String str, String str2, String str3, String str4) {
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
        return k.a((Object) this.version, (Object) head.version) && k.a((Object) this.requestTimestamp, (Object) head.requestTimestamp) && k.a((Object) this.channelId, (Object) head.channelId) && k.a((Object) this.txnToken, (Object) head.txnToken);
    }

    public final int hashCode() {
        String str = this.version;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.requestTimestamp;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.txnToken;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Head(version=" + this.version + ", requestTimestamp=" + this.requestTimestamp + ", channelId=" + this.channelId + ", txnToken=" + this.txnToken + ")";
    }

    public Head(String str, String str2, String str3, String str4) {
        this.version = str;
        this.requestTimestamp = str2;
        this.channelId = str3;
        this.txnToken = str4;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getRequestTimestamp() {
        return this.requestTimestamp;
    }

    public final void setRequestTimestamp(String str) {
        this.requestTimestamp = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final String getTxnToken() {
        return this.txnToken;
    }

    public final void setTxnToken(String str) {
        this.txnToken = str;
    }
}
