package com.business.merchant_payments.ups;

import kotlin.g.b.k;

public final class StatusInfo {
    public final String status;
    public final String statusCode;
    public final String statusMessage;

    public static /* synthetic */ StatusInfo copy$default(StatusInfo statusInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = statusInfo.statusCode;
        }
        if ((i2 & 2) != 0) {
            str2 = statusInfo.statusMessage;
        }
        if ((i2 & 4) != 0) {
            str3 = statusInfo.status;
        }
        return statusInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.statusMessage;
    }

    public final String component3() {
        return this.status;
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
        return k.a((Object) this.statusCode, (Object) statusInfo.statusCode) && k.a((Object) this.statusMessage, (Object) statusInfo.statusMessage) && k.a((Object) this.status, (Object) statusInfo.status);
    }

    public final int hashCode() {
        String str = this.statusCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "StatusInfo(statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", status=" + this.status + ")";
    }

    public StatusInfo(String str, String str2, String str3) {
        this.statusCode = str;
        this.statusMessage = str2;
        this.status = str3;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final String getStatus() {
        return this.status;
    }
}
