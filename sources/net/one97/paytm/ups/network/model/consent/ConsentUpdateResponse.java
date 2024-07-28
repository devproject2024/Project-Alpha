package net.one97.paytm.ups.network.model.consent;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentUpdateResponse extends IJRPaytmDataModel {
    private String requestId;
    private Response response;
    private StatusInfo statusInfo;

    public ConsentUpdateResponse() {
        this((String) null, (Response) null, (StatusInfo) null, 7, (g) null);
    }

    public static /* synthetic */ ConsentUpdateResponse copy$default(ConsentUpdateResponse consentUpdateResponse, String str, Response response2, StatusInfo statusInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consentUpdateResponse.requestId;
        }
        if ((i2 & 2) != 0) {
            response2 = consentUpdateResponse.response;
        }
        if ((i2 & 4) != 0) {
            statusInfo2 = consentUpdateResponse.statusInfo;
        }
        return consentUpdateResponse.copy(str, response2, statusInfo2);
    }

    public final String component1() {
        return this.requestId;
    }

    public final Response component2() {
        return this.response;
    }

    public final StatusInfo component3() {
        return this.statusInfo;
    }

    public final ConsentUpdateResponse copy(String str, Response response2, StatusInfo statusInfo2) {
        return new ConsentUpdateResponse(str, response2, statusInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentUpdateResponse)) {
            return false;
        }
        ConsentUpdateResponse consentUpdateResponse = (ConsentUpdateResponse) obj;
        return k.a((Object) this.requestId, (Object) consentUpdateResponse.requestId) && k.a((Object) this.response, (Object) consentUpdateResponse.response) && k.a((Object) this.statusInfo, (Object) consentUpdateResponse.statusInfo);
    }

    public final int hashCode() {
        String str = this.requestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Response response2 = this.response;
        int hashCode2 = (hashCode + (response2 != null ? response2.hashCode() : 0)) * 31;
        StatusInfo statusInfo2 = this.statusInfo;
        if (statusInfo2 != null) {
            i2 = statusInfo2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ConsentUpdateResponse(requestId=" + this.requestId + ", response=" + this.response + ", statusInfo=" + this.statusInfo + ")";
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(Response response2) {
        this.response = response2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentUpdateResponse(String str, Response response2, StatusInfo statusInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : response2, (i2 & 4) != 0 ? null : statusInfo2);
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final void setStatusInfo(StatusInfo statusInfo2) {
        this.statusInfo = statusInfo2;
    }

    public ConsentUpdateResponse(String str, Response response2, StatusInfo statusInfo2) {
        this.requestId = str;
        this.response = response2;
        this.statusInfo = statusInfo2;
    }
}
