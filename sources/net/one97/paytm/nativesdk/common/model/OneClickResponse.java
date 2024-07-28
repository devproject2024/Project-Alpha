package net.one97.paytm.nativesdk.common.model;

import kotlin.g.b.k;

public final class OneClickResponse {
    private final String message;
    private final int statusCode;

    public static /* synthetic */ OneClickResponse copy$default(OneClickResponse oneClickResponse, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = oneClickResponse.statusCode;
        }
        if ((i3 & 2) != 0) {
            str = oneClickResponse.message;
        }
        return oneClickResponse.copy(i2, str);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.message;
    }

    public final OneClickResponse copy(int i2, String str) {
        return new OneClickResponse(i2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OneClickResponse)) {
            return false;
        }
        OneClickResponse oneClickResponse = (OneClickResponse) obj;
        return this.statusCode == oneClickResponse.statusCode && k.a((Object) this.message, (Object) oneClickResponse.message);
    }

    public final int hashCode() {
        int i2 = this.statusCode * 31;
        String str = this.message;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "OneClickResponse(statusCode=" + this.statusCode + ", message=" + this.message + ")";
    }

    public OneClickResponse(int i2, String str) {
        this.statusCode = i2;
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
