package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.k;

public final class ReactivationStatusNetworkResponse {
    public final String displayMessage;
    public final String leadStatus;
    public final String statusCode;

    public static /* synthetic */ ReactivationStatusNetworkResponse copy$default(ReactivationStatusNetworkResponse reactivationStatusNetworkResponse, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reactivationStatusNetworkResponse.statusCode;
        }
        if ((i2 & 2) != 0) {
            str2 = reactivationStatusNetworkResponse.leadStatus;
        }
        if ((i2 & 4) != 0) {
            str3 = reactivationStatusNetworkResponse.displayMessage;
        }
        return reactivationStatusNetworkResponse.copy(str, str2, str3);
    }

    public final String component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.leadStatus;
    }

    public final String component3() {
        return this.displayMessage;
    }

    public final ReactivationStatusNetworkResponse copy(String str, String str2, String str3) {
        k.d(str, "statusCode");
        k.d(str2, "leadStatus");
        k.d(str3, "displayMessage");
        return new ReactivationStatusNetworkResponse(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactivationStatusNetworkResponse)) {
            return false;
        }
        ReactivationStatusNetworkResponse reactivationStatusNetworkResponse = (ReactivationStatusNetworkResponse) obj;
        return k.a((Object) this.statusCode, (Object) reactivationStatusNetworkResponse.statusCode) && k.a((Object) this.leadStatus, (Object) reactivationStatusNetworkResponse.leadStatus) && k.a((Object) this.displayMessage, (Object) reactivationStatusNetworkResponse.displayMessage);
    }

    public final int hashCode() {
        String str = this.statusCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.leadStatus;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayMessage;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ReactivationStatusNetworkResponse(statusCode=" + this.statusCode + ", leadStatus=" + this.leadStatus + ", displayMessage=" + this.displayMessage + ")";
    }

    public ReactivationStatusNetworkResponse(String str, String str2, String str3) {
        k.d(str, "statusCode");
        k.d(str2, "leadStatus");
        k.d(str3, "displayMessage");
        this.statusCode = str;
        this.leadStatus = str2;
        this.displayMessage = str3;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getLeadStatus() {
        return this.leadStatus;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }
}
