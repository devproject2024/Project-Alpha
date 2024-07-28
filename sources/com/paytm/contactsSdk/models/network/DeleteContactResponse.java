package com.paytm.contactsSdk.models.network;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class DeleteContactResponse extends IJRPaytmDataModel {
    private final String requestId;
    private final DeleteStatusInfo statusInfo;

    public DeleteContactResponse() {
        this((DeleteStatusInfo) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ DeleteContactResponse copy$default(DeleteContactResponse deleteContactResponse, DeleteStatusInfo deleteStatusInfo, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deleteStatusInfo = deleteContactResponse.statusInfo;
        }
        if ((i2 & 2) != 0) {
            str = deleteContactResponse.requestId;
        }
        return deleteContactResponse.copy(deleteStatusInfo, str);
    }

    public final DeleteStatusInfo component1() {
        return this.statusInfo;
    }

    public final String component2() {
        return this.requestId;
    }

    public final DeleteContactResponse copy(DeleteStatusInfo deleteStatusInfo, String str) {
        k.c(str, "requestId");
        return new DeleteContactResponse(deleteStatusInfo, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteContactResponse)) {
            return false;
        }
        DeleteContactResponse deleteContactResponse = (DeleteContactResponse) obj;
        return k.a((Object) this.statusInfo, (Object) deleteContactResponse.statusInfo) && k.a((Object) this.requestId, (Object) deleteContactResponse.requestId);
    }

    public final int hashCode() {
        DeleteStatusInfo deleteStatusInfo = this.statusInfo;
        int i2 = 0;
        int hashCode = (deleteStatusInfo != null ? deleteStatusInfo.hashCode() : 0) * 31;
        String str = this.requestId;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "DeleteContactResponse(statusInfo=" + this.statusInfo + ", requestId=" + this.requestId + ")";
    }

    public DeleteContactResponse(DeleteStatusInfo deleteStatusInfo, String str) {
        k.c(str, "requestId");
        this.statusInfo = deleteStatusInfo;
        this.requestId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeleteContactResponse(DeleteStatusInfo deleteStatusInfo, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : deleteStatusInfo, (i2 & 2) != 0 ? "" : str);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final DeleteStatusInfo getStatusInfo() {
        return this.statusInfo;
    }
}
