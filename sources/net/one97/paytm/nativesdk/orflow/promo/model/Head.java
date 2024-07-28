package net.one97.paytm.nativesdk.orflow.promo.model;

import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Head implements Serializable {
    private String responseTimestamp;
    private String version;

    public Head() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ Head copy$default(Head head, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = head.responseTimestamp;
        }
        if ((i2 & 2) != 0) {
            str2 = head.version;
        }
        return head.copy(str, str2);
    }

    public final String component1() {
        return this.responseTimestamp;
    }

    public final String component2() {
        return this.version;
    }

    public final Head copy(String str, String str2) {
        return new Head(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Head)) {
            return false;
        }
        Head head = (Head) obj;
        return k.a((Object) this.responseTimestamp, (Object) head.responseTimestamp) && k.a((Object) this.version, (Object) head.version);
    }

    public final int hashCode() {
        String str = this.responseTimestamp;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Head(responseTimestamp=" + this.responseTimestamp + ", version=" + this.version + ")";
    }

    public Head(String str, String str2) {
        this.responseTimestamp = str;
        this.version = str2;
    }

    public final String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public final void setResponseTimestamp(String str) {
        this.responseTimestamp = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Head(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }
}
