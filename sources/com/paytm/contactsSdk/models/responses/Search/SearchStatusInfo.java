package com.paytm.contactsSdk.models.responses.Search;

import kotlin.g.b.k;

public final class SearchStatusInfo {
    private final String status;
    private final String statusCode;
    private final String statusMessage;

    public static /* synthetic */ SearchStatusInfo copy$default(SearchStatusInfo searchStatusInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchStatusInfo.status;
        }
        if ((i2 & 2) != 0) {
            str2 = searchStatusInfo.statusCode;
        }
        if ((i2 & 4) != 0) {
            str3 = searchStatusInfo.statusMessage;
        }
        return searchStatusInfo.copy(str, str2, str3);
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

    public final SearchStatusInfo copy(String str, String str2, String str3) {
        k.c(str, "status");
        k.c(str2, "statusCode");
        k.c(str3, "statusMessage");
        return new SearchStatusInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchStatusInfo)) {
            return false;
        }
        SearchStatusInfo searchStatusInfo = (SearchStatusInfo) obj;
        return k.a((Object) this.status, (Object) searchStatusInfo.status) && k.a((Object) this.statusCode, (Object) searchStatusInfo.statusCode) && k.a((Object) this.statusMessage, (Object) searchStatusInfo.statusMessage);
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
        return "SearchStatusInfo(status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ")";
    }

    public SearchStatusInfo(String str, String str2, String str3) {
        k.c(str, "status");
        k.c(str2, "statusCode");
        k.c(str3, "statusMessage");
        this.status = str;
        this.statusCode = str2;
        this.statusMessage = str3;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }
}
