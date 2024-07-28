package com.paytm.contactsSdk.models.responses;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ContactNetworkResponse extends IJRPaytmDataModel {
    private String requestId;
    private StatusInfo statusInfo;

    public ContactNetworkResponse() {
        this((String) null, (StatusInfo) null, 3, (g) null);
    }

    public static /* synthetic */ ContactNetworkResponse copy$default(ContactNetworkResponse contactNetworkResponse, String str, StatusInfo statusInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = contactNetworkResponse.requestId;
        }
        if ((i2 & 2) != 0) {
            statusInfo2 = contactNetworkResponse.statusInfo;
        }
        return contactNetworkResponse.copy(str, statusInfo2);
    }

    public final String component1() {
        return this.requestId;
    }

    public final StatusInfo component2() {
        return this.statusInfo;
    }

    public final ContactNetworkResponse copy(String str, StatusInfo statusInfo2) {
        return new ContactNetworkResponse(str, statusInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactNetworkResponse)) {
            return false;
        }
        ContactNetworkResponse contactNetworkResponse = (ContactNetworkResponse) obj;
        return k.a((Object) this.requestId, (Object) contactNetworkResponse.requestId) && k.a((Object) this.statusInfo, (Object) contactNetworkResponse.statusInfo);
    }

    public final int hashCode() {
        String str = this.requestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        StatusInfo statusInfo2 = this.statusInfo;
        if (statusInfo2 != null) {
            i2 = statusInfo2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ContactNetworkResponse(requestId=" + this.requestId + ", statusInfo=" + this.statusInfo + ")";
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactNetworkResponse(String str, StatusInfo statusInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : statusInfo2);
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final void setStatusInfo(StatusInfo statusInfo2) {
        this.statusInfo = statusInfo2;
    }

    public ContactNetworkResponse(String str, StatusInfo statusInfo2) {
        this.requestId = str;
        this.statusInfo = statusInfo2;
    }
}
