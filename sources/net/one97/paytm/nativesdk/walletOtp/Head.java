package net.one97.paytm.nativesdk.walletOtp;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Head {
    @c(a = "requestId")
    private final Object requestId;
    @c(a = "responseTimestamp")
    private final String responseTimestamp;
    @c(a = "version")
    private final String version;

    public Head() {
        this((String) null, (Object) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ Head copy$default(Head head, String str, Object obj, String str2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = head.responseTimestamp;
        }
        if ((i2 & 2) != 0) {
            obj = head.requestId;
        }
        if ((i2 & 4) != 0) {
            str2 = head.version;
        }
        return head.copy(str, obj, str2);
    }

    public final String component1() {
        return this.responseTimestamp;
    }

    public final Object component2() {
        return this.requestId;
    }

    public final String component3() {
        return this.version;
    }

    public final Head copy(String str, Object obj, String str2) {
        return new Head(str, obj, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Head)) {
            return false;
        }
        Head head = (Head) obj;
        return k.a((Object) this.responseTimestamp, (Object) head.responseTimestamp) && k.a(this.requestId, head.requestId) && k.a((Object) this.version, (Object) head.version);
    }

    public final int hashCode() {
        String str = this.responseTimestamp;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.requestId;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Head(responseTimestamp=" + this.responseTimestamp + ", requestId=" + this.requestId + ", version=" + this.version + ")";
    }

    public Head(String str, Object obj, String str2) {
        this.responseTimestamp = str;
        this.requestId = obj;
        this.version = str2;
    }

    public final String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public final Object getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Head(String str, Object obj, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : str2);
    }

    public final String getVersion() {
        return this.version;
    }
}
