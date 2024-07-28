package com.paytm.contactsSdk.models.responses;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class StatusInfo {
    private String status;
    private String statusCode;
    private String statusMessage;

    public StatusInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ StatusInfo copy$default(StatusInfo statusInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = statusInfo.status;
        }
        if ((i2 & 2) != 0) {
            str2 = statusInfo.statusCode;
        }
        if ((i2 & 4) != 0) {
            str3 = statusInfo.statusMessage;
        }
        return statusInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusCode;
    }

    public final String component3() {
        return this.statusMessage;
    }

    public final StatusInfo copy(String str, String str2, String str3) {
        return new StatusInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusInfo)) {
            return false;
        }
        StatusInfo statusInfo = (StatusInfo) obj;
        return k.a((Object) this.status, (Object) statusInfo.status) && k.a((Object) this.statusCode, (Object) statusInfo.statusCode) && k.a((Object) this.statusMessage, (Object) statusInfo.statusMessage);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusMessage;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "StatusInfo(status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ")";
    }

    public StatusInfo(String str, String str2, String str3) {
        this.status = str;
        this.statusCode = str2;
        this.statusMessage = str3;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatusInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(String str) {
        this.statusMessage = str;
    }
}
