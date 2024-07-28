package com.paytm.contactsSdk.models.requests;

import kotlin.g.b.k;

public final class HealthRequest {
    private final HealthContactDetailReq contactDetail;
    private final String deviceId;

    public static /* synthetic */ HealthRequest copy$default(HealthRequest healthRequest, String str, HealthContactDetailReq healthContactDetailReq, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = healthRequest.deviceId;
        }
        if ((i2 & 2) != 0) {
            healthContactDetailReq = healthRequest.contactDetail;
        }
        return healthRequest.copy(str, healthContactDetailReq);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final HealthContactDetailReq component2() {
        return this.contactDetail;
    }

    public final HealthRequest copy(String str, HealthContactDetailReq healthContactDetailReq) {
        k.c(str, "deviceId");
        k.c(healthContactDetailReq, "contactDetail");
        return new HealthRequest(str, healthContactDetailReq);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthRequest)) {
            return false;
        }
        HealthRequest healthRequest = (HealthRequest) obj;
        return k.a((Object) this.deviceId, (Object) healthRequest.deviceId) && k.a((Object) this.contactDetail, (Object) healthRequest.contactDetail);
    }

    public final int hashCode() {
        String str = this.deviceId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        HealthContactDetailReq healthContactDetailReq = this.contactDetail;
        if (healthContactDetailReq != null) {
            i2 = healthContactDetailReq.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "HealthRequest(deviceId=" + this.deviceId + ", contactDetail=" + this.contactDetail + ")";
    }

    public HealthRequest(String str, HealthContactDetailReq healthContactDetailReq) {
        k.c(str, "deviceId");
        k.c(healthContactDetailReq, "contactDetail");
        this.deviceId = str;
        this.contactDetail = healthContactDetailReq;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final HealthContactDetailReq getContactDetail() {
        return this.contactDetail;
    }
}
