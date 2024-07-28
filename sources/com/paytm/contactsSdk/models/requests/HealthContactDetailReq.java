package com.paytm.contactsSdk.models.requests;

import kotlin.g.b.k;

public final class HealthContactDetailReq {
    private final int contactCount;
    private final String contactType;
    private final int enrichedContactCount;
    private final long lastTimestamp;

    public static /* synthetic */ HealthContactDetailReq copy$default(HealthContactDetailReq healthContactDetailReq, String str, int i2, int i3, long j, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = healthContactDetailReq.contactType;
        }
        if ((i4 & 2) != 0) {
            i2 = healthContactDetailReq.contactCount;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = healthContactDetailReq.enrichedContactCount;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            j = healthContactDetailReq.lastTimestamp;
        }
        return healthContactDetailReq.copy(str, i5, i6, j);
    }

    public final String component1() {
        return this.contactType;
    }

    public final int component2() {
        return this.contactCount;
    }

    public final int component3() {
        return this.enrichedContactCount;
    }

    public final long component4() {
        return this.lastTimestamp;
    }

    public final HealthContactDetailReq copy(String str, int i2, int i3, long j) {
        k.c(str, "contactType");
        return new HealthContactDetailReq(str, i2, i3, j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthContactDetailReq)) {
            return false;
        }
        HealthContactDetailReq healthContactDetailReq = (HealthContactDetailReq) obj;
        return k.a((Object) this.contactType, (Object) healthContactDetailReq.contactType) && this.contactCount == healthContactDetailReq.contactCount && this.enrichedContactCount == healthContactDetailReq.enrichedContactCount && this.lastTimestamp == healthContactDetailReq.lastTimestamp;
    }

    public final int hashCode() {
        String str = this.contactType;
        return ((((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.contactCount).hashCode()) * 31) + Integer.valueOf(this.enrichedContactCount).hashCode()) * 31) + Long.valueOf(this.lastTimestamp).hashCode();
    }

    public final String toString() {
        return "HealthContactDetailReq(contactType=" + this.contactType + ", contactCount=" + this.contactCount + ", enrichedContactCount=" + this.enrichedContactCount + ", lastTimestamp=" + this.lastTimestamp + ")";
    }

    public HealthContactDetailReq(String str, int i2, int i3, long j) {
        k.c(str, "contactType");
        this.contactType = str;
        this.contactCount = i2;
        this.enrichedContactCount = i3;
        this.lastTimestamp = j;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final int getContactCount() {
        return this.contactCount;
    }

    public final int getEnrichedContactCount() {
        return this.enrichedContactCount;
    }

    public final long getLastTimestamp() {
        return this.lastTimestamp;
    }
}
