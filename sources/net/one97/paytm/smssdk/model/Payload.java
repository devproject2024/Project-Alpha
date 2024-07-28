package net.one97.paytm.smssdk.model;

import kotlin.g.b.k;

public final class Payload {
    private final String smsBody;
    private final long smsDateTime;
    private final String smsSenderID;

    public static /* synthetic */ Payload copy$default(Payload payload, String str, long j, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = payload.smsBody;
        }
        if ((i2 & 2) != 0) {
            j = payload.smsDateTime;
        }
        if ((i2 & 4) != 0) {
            str2 = payload.smsSenderID;
        }
        return payload.copy(str, j, str2);
    }

    public final String component1() {
        return this.smsBody;
    }

    public final long component2() {
        return this.smsDateTime;
    }

    public final String component3() {
        return this.smsSenderID;
    }

    public final Payload copy(String str, long j, String str2) {
        k.c(str, "smsBody");
        k.c(str2, "smsSenderID");
        return new Payload(str, j, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) obj;
        return k.a((Object) this.smsBody, (Object) payload.smsBody) && this.smsDateTime == payload.smsDateTime && k.a((Object) this.smsSenderID, (Object) payload.smsSenderID);
    }

    public final int hashCode() {
        String str = this.smsBody;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.smsDateTime;
        int i3 = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.smsSenderID;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "Payload(smsBody=" + this.smsBody + ", smsDateTime=" + this.smsDateTime + ", smsSenderID=" + this.smsSenderID + ")";
    }

    public Payload(String str, long j, String str2) {
        k.c(str, "smsBody");
        k.c(str2, "smsSenderID");
        this.smsBody = str;
        this.smsDateTime = j;
        this.smsSenderID = str2;
    }

    public final String getSmsBody() {
        return this.smsBody;
    }

    public final long getSmsDateTime() {
        return this.smsDateTime;
    }

    public final String getSmsSenderID() {
        return this.smsSenderID;
    }
}
