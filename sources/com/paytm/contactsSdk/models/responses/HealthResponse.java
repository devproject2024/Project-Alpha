package com.paytm.contactsSdk.models.responses;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class HealthResponse extends IJRPaytmDataModel {
    private final Response response;
    private final StatusInfo statusInfo;

    public HealthResponse() {
        this((StatusInfo) null, (Response) null, 3, (g) null);
    }

    public static /* synthetic */ HealthResponse copy$default(HealthResponse healthResponse, StatusInfo statusInfo2, Response response2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            statusInfo2 = healthResponse.statusInfo;
        }
        if ((i2 & 2) != 0) {
            response2 = healthResponse.response;
        }
        return healthResponse.copy(statusInfo2, response2);
    }

    public final StatusInfo component1() {
        return this.statusInfo;
    }

    public final Response component2() {
        return this.response;
    }

    public final HealthResponse copy(StatusInfo statusInfo2, Response response2) {
        return new HealthResponse(statusInfo2, response2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthResponse)) {
            return false;
        }
        HealthResponse healthResponse = (HealthResponse) obj;
        return k.a((Object) this.statusInfo, (Object) healthResponse.statusInfo) && k.a((Object) this.response, (Object) healthResponse.response);
    }

    public final int hashCode() {
        StatusInfo statusInfo2 = this.statusInfo;
        int i2 = 0;
        int hashCode = (statusInfo2 != null ? statusInfo2.hashCode() : 0) * 31;
        Response response2 = this.response;
        if (response2 != null) {
            i2 = response2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "HealthResponse(statusInfo=" + this.statusInfo + ", response=" + this.response + ")";
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HealthResponse(StatusInfo statusInfo2, Response response2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : statusInfo2, (i2 & 2) != 0 ? null : response2);
    }

    public final Response getResponse() {
        return this.response;
    }

    public HealthResponse(StatusInfo statusInfo2, Response response2) {
        this.statusInfo = statusInfo2;
        this.response = response2;
    }
}
