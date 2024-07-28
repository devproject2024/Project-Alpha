package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.k;

public final class NetworkResponse<T> {
    public final T results;
    public final String status;
    public final String statusCode;

    public static /* synthetic */ NetworkResponse copy$default(NetworkResponse networkResponse, String str, String str2, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = networkResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = networkResponse.statusCode;
        }
        if ((i2 & 4) != 0) {
            t = networkResponse.results;
        }
        return networkResponse.copy(str, str2, t);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusCode;
    }

    public final T component3() {
        return this.results;
    }

    public final NetworkResponse<T> copy(String str, String str2, T t) {
        k.d(str, "status");
        k.d(str2, "statusCode");
        return new NetworkResponse<>(str, str2, t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        return k.a((Object) this.status, (Object) networkResponse.status) && k.a((Object) this.statusCode, (Object) networkResponse.statusCode) && k.a((Object) this.results, (Object) networkResponse.results);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        T t = this.results;
        if (t != null) {
            i2 = t.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "NetworkResponse(status=" + this.status + ", statusCode=" + this.statusCode + ", results=" + this.results + ")";
    }

    public NetworkResponse(String str, String str2, T t) {
        k.d(str, "status");
        k.d(str2, "statusCode");
        this.status = str;
        this.statusCode = str2;
        this.results = t;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final T getResults() {
        return this.results;
    }
}
