package com.paytm.contactsSdk.models.responses;

import kotlin.g.b.k;

public final class HealthContactDetail {
    private final int action;
    private final int contactCount;
    private final String contactType;
    private final int currentCount;
    private final long currentLastTimestamp;
    private final int enrichedContactCount;
    private final long lastTimestamp;

    public static /* synthetic */ HealthContactDetail copy$default(HealthContactDetail healthContactDetail, String str, int i2, int i3, long j, int i4, long j2, int i5, int i6, Object obj) {
        HealthContactDetail healthContactDetail2 = healthContactDetail;
        return healthContactDetail.copy((i6 & 1) != 0 ? healthContactDetail2.contactType : str, (i6 & 2) != 0 ? healthContactDetail2.contactCount : i2, (i6 & 4) != 0 ? healthContactDetail2.enrichedContactCount : i3, (i6 & 8) != 0 ? healthContactDetail2.lastTimestamp : j, (i6 & 16) != 0 ? healthContactDetail2.currentCount : i4, (i6 & 32) != 0 ? healthContactDetail2.currentLastTimestamp : j2, (i6 & 64) != 0 ? healthContactDetail2.action : i5);
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

    public final int component5() {
        return this.currentCount;
    }

    public final long component6() {
        return this.currentLastTimestamp;
    }

    public final int component7() {
        return this.action;
    }

    public final HealthContactDetail copy(String str, int i2, int i3, long j, int i4, long j2, int i5) {
        k.c(str, "contactType");
        return new HealthContactDetail(str, i2, i3, j, i4, j2, i5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthContactDetail)) {
            return false;
        }
        HealthContactDetail healthContactDetail = (HealthContactDetail) obj;
        return k.a((Object) this.contactType, (Object) healthContactDetail.contactType) && this.contactCount == healthContactDetail.contactCount && this.enrichedContactCount == healthContactDetail.enrichedContactCount && this.lastTimestamp == healthContactDetail.lastTimestamp && this.currentCount == healthContactDetail.currentCount && this.currentLastTimestamp == healthContactDetail.currentLastTimestamp && this.action == healthContactDetail.action;
    }

    public final int hashCode() {
        String str = this.contactType;
        return ((((((((((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.contactCount).hashCode()) * 31) + Integer.valueOf(this.enrichedContactCount).hashCode()) * 31) + Long.valueOf(this.lastTimestamp).hashCode()) * 31) + Integer.valueOf(this.currentCount).hashCode()) * 31) + Long.valueOf(this.currentLastTimestamp).hashCode()) * 31) + Integer.valueOf(this.action).hashCode();
    }

    public final String toString() {
        return "HealthContactDetail(contactType=" + this.contactType + ", contactCount=" + this.contactCount + ", enrichedContactCount=" + this.enrichedContactCount + ", lastTimestamp=" + this.lastTimestamp + ", currentCount=" + this.currentCount + ", currentLastTimestamp=" + this.currentLastTimestamp + ", action=" + this.action + ")";
    }

    public HealthContactDetail(String str, int i2, int i3, long j, int i4, long j2, int i5) {
        k.c(str, "contactType");
        this.contactType = str;
        this.contactCount = i2;
        this.enrichedContactCount = i3;
        this.lastTimestamp = j;
        this.currentCount = i4;
        this.currentLastTimestamp = j2;
        this.action = i5;
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

    public final int getCurrentCount() {
        return this.currentCount;
    }

    public final long getCurrentLastTimestamp() {
        return this.currentLastTimestamp;
    }

    public final int getAction() {
        return this.action;
    }
}
