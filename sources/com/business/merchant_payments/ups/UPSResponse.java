package com.business.merchant_payments.ups;

import kotlin.g.b.k;

public final class UPSResponse {
    public final String requestId;
    public Response response;
    public final StatusInfo statusInfo;

    public static /* synthetic */ UPSResponse copy$default(UPSResponse uPSResponse, StatusInfo statusInfo2, String str, Response response2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            statusInfo2 = uPSResponse.statusInfo;
        }
        if ((i2 & 2) != 0) {
            str = uPSResponse.requestId;
        }
        if ((i2 & 4) != 0) {
            response2 = uPSResponse.response;
        }
        return uPSResponse.copy(statusInfo2, str, response2);
    }

    public final StatusInfo component1() {
        return this.statusInfo;
    }

    public final String component2() {
        return this.requestId;
    }

    public final Response component3() {
        return this.response;
    }

    public final UPSResponse copy(StatusInfo statusInfo2, String str, Response response2) {
        return new UPSResponse(statusInfo2, str, response2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UPSResponse)) {
            return false;
        }
        UPSResponse uPSResponse = (UPSResponse) obj;
        return k.a((Object) this.statusInfo, (Object) uPSResponse.statusInfo) && k.a((Object) this.requestId, (Object) uPSResponse.requestId) && k.a((Object) this.response, (Object) uPSResponse.response);
    }

    public final int hashCode() {
        StatusInfo statusInfo2 = this.statusInfo;
        int i2 = 0;
        int hashCode = (statusInfo2 != null ? statusInfo2.hashCode() : 0) * 31;
        String str = this.requestId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Response response2 = this.response;
        if (response2 != null) {
            i2 = response2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UPSResponse(statusInfo=" + this.statusInfo + ", requestId=" + this.requestId + ", response=" + this.response + ")";
    }

    public UPSResponse(StatusInfo statusInfo2, String str, Response response2) {
        this.statusInfo = statusInfo2;
        this.requestId = str;
        this.response = response2;
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(Response response2) {
        this.response = response2;
    }
}
