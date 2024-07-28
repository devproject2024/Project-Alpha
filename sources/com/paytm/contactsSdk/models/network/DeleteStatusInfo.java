package com.paytm.contactsSdk.models.network;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class DeleteStatusInfo extends IJRPaytmDataModel {
    private final String message;
    private final String status;
    private final String statusCode;

    public static /* synthetic */ DeleteStatusInfo copy$default(DeleteStatusInfo deleteStatusInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deleteStatusInfo.status;
        }
        if ((i2 & 2) != 0) {
            str2 = deleteStatusInfo.statusCode;
        }
        if ((i2 & 4) != 0) {
            str3 = deleteStatusInfo.message;
        }
        return deleteStatusInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusCode;
    }

    public final String component3() {
        return this.message;
    }

    public final DeleteStatusInfo copy(String str, String str2, String str3) {
        k.c(str, "status");
        k.c(str2, "statusCode");
        k.c(str3, "message");
        return new DeleteStatusInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteStatusInfo)) {
            return false;
        }
        DeleteStatusInfo deleteStatusInfo = (DeleteStatusInfo) obj;
        return k.a((Object) this.status, (Object) deleteStatusInfo.status) && k.a((Object) this.statusCode, (Object) deleteStatusInfo.statusCode) && k.a((Object) this.message, (Object) deleteStatusInfo.message);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "DeleteStatusInfo(status=" + this.status + ", statusCode=" + this.statusCode + ", message=" + this.message + ")";
    }

    public DeleteStatusInfo(String str, String str2, String str3) {
        k.c(str, "status");
        k.c(str2, "statusCode");
        k.c(str3, "message");
        this.status = str;
        this.statusCode = str2;
        this.message = str3;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }
}
