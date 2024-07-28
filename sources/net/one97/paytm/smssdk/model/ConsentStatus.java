package net.one97.paytm.smssdk.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentStatus extends IJRPaytmDataModel {
    private String requestId;
    private ConsentStatusResponse response;
    private StatusInfo statusInfo;

    public ConsentStatus() {
        this((String) null, (ConsentStatusResponse) null, (StatusInfo) null, 7, (g) null);
    }

    public static /* synthetic */ ConsentStatus copy$default(ConsentStatus consentStatus, String str, ConsentStatusResponse consentStatusResponse, StatusInfo statusInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consentStatus.requestId;
        }
        if ((i2 & 2) != 0) {
            consentStatusResponse = consentStatus.response;
        }
        if ((i2 & 4) != 0) {
            statusInfo2 = consentStatus.statusInfo;
        }
        return consentStatus.copy(str, consentStatusResponse, statusInfo2);
    }

    public final String component1() {
        return this.requestId;
    }

    public final ConsentStatusResponse component2() {
        return this.response;
    }

    public final StatusInfo component3() {
        return this.statusInfo;
    }

    public final ConsentStatus copy(String str, ConsentStatusResponse consentStatusResponse, StatusInfo statusInfo2) {
        return new ConsentStatus(str, consentStatusResponse, statusInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentStatus)) {
            return false;
        }
        ConsentStatus consentStatus = (ConsentStatus) obj;
        return k.a((Object) this.requestId, (Object) consentStatus.requestId) && k.a((Object) this.response, (Object) consentStatus.response) && k.a((Object) this.statusInfo, (Object) consentStatus.statusInfo);
    }

    public final int hashCode() {
        String str = this.requestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ConsentStatusResponse consentStatusResponse = this.response;
        int hashCode2 = (hashCode + (consentStatusResponse != null ? consentStatusResponse.hashCode() : 0)) * 31;
        StatusInfo statusInfo2 = this.statusInfo;
        if (statusInfo2 != null) {
            i2 = statusInfo2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ConsentStatus(requestId=" + this.requestId + ", response=" + this.response + ", statusInfo=" + this.statusInfo + ")";
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final ConsentStatusResponse getResponse() {
        return this.response;
    }

    public final void setResponse(ConsentStatusResponse consentStatusResponse) {
        this.response = consentStatusResponse;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentStatus(String str, ConsentStatusResponse consentStatusResponse, StatusInfo statusInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : consentStatusResponse, (i2 & 4) != 0 ? null : statusInfo2);
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final void setStatusInfo(StatusInfo statusInfo2) {
        this.statusInfo = statusInfo2;
    }

    public ConsentStatus(String str, ConsentStatusResponse consentStatusResponse, StatusInfo statusInfo2) {
        this.requestId = str;
        this.response = consentStatusResponse;
        this.statusInfo = statusInfo2;
    }
}
