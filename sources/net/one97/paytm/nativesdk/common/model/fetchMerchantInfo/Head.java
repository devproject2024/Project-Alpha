package net.one97.paytm.nativesdk.common.model.fetchMerchantInfo;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Head {
    @c(a = "requestId")
    private final Object requestId;
    @c(a = "responseTimestamp")
    private final String responseTimestamp;
    @c(a = "version")
    private final String version;

    public static /* synthetic */ Head copy$default(Head head, Object obj, String str, String str2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = head.requestId;
        }
        if ((i2 & 2) != 0) {
            str = head.responseTimestamp;
        }
        if ((i2 & 4) != 0) {
            str2 = head.version;
        }
        return head.copy(obj, str, str2);
    }

    public final Object component1() {
        return this.requestId;
    }

    public final String component2() {
        return this.responseTimestamp;
    }

    public final String component3() {
        return this.version;
    }

    public final Head copy(Object obj, String str, String str2) {
        return new Head(obj, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Head)) {
            return false;
        }
        Head head = (Head) obj;
        return k.a(this.requestId, head.requestId) && k.a((Object) this.responseTimestamp, (Object) head.responseTimestamp) && k.a((Object) this.version, (Object) head.version);
    }

    public final int hashCode() {
        Object obj = this.requestId;
        int i2 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        String str = this.responseTimestamp;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Head(requestId=" + this.requestId + ", responseTimestamp=" + this.responseTimestamp + ", version=" + this.version + ")";
    }

    public Head(Object obj, String str, String str2) {
        this.requestId = obj;
        this.responseTimestamp = str;
        this.version = str2;
    }

    public final Object getRequestId() {
        return this.requestId;
    }

    public final String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public final String getVersion() {
        return this.version;
    }
}
