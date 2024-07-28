package com.business.merchant_payments.model.requestpayment;

import com.business.common_module.f.a;
import kotlin.g.b.k;

public final class ShareLinkResponse extends a {
    public String status;
    public String statusMessage;

    public static /* synthetic */ ShareLinkResponse copy$default(ShareLinkResponse shareLinkResponse, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = shareLinkResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = shareLinkResponse.statusMessage;
        }
        return shareLinkResponse.copy(str, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusMessage;
    }

    public final ShareLinkResponse copy(String str, String str2) {
        k.d(str, "status");
        k.d(str2, "statusMessage");
        return new ShareLinkResponse(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareLinkResponse)) {
            return false;
        }
        ShareLinkResponse shareLinkResponse = (ShareLinkResponse) obj;
        return k.a((Object) this.status, (Object) shareLinkResponse.status) && k.a((Object) this.statusMessage, (Object) shareLinkResponse.statusMessage);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusMessage;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ShareLinkResponse(status=" + this.status + ", statusMessage=" + this.statusMessage + ")";
    }

    public ShareLinkResponse(String str, String str2) {
        k.d(str, "status");
        k.d(str2, "statusMessage");
        this.status = str;
        this.statusMessage = str2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatus(String str) {
        k.d(str, "<set-?>");
        this.status = str;
    }

    public final void setStatusMessage(String str) {
        k.d(str, "<set-?>");
        this.statusMessage = str;
    }
}
