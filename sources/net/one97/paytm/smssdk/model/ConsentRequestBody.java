package net.one97.paytm.smssdk.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentRequestBody {
    private final Request request;
    private final String requestId;

    public ConsentRequestBody() {
        this((Request) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ ConsentRequestBody copy$default(ConsentRequestBody consentRequestBody, Request request2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            request2 = consentRequestBody.request;
        }
        if ((i2 & 2) != 0) {
            str = consentRequestBody.requestId;
        }
        return consentRequestBody.copy(request2, str);
    }

    public final Request component1() {
        return this.request;
    }

    public final String component2() {
        return this.requestId;
    }

    public final ConsentRequestBody copy(Request request2, String str) {
        return new ConsentRequestBody(request2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentRequestBody)) {
            return false;
        }
        ConsentRequestBody consentRequestBody = (ConsentRequestBody) obj;
        return k.a((Object) this.request, (Object) consentRequestBody.request) && k.a((Object) this.requestId, (Object) consentRequestBody.requestId);
    }

    public final int hashCode() {
        Request request2 = this.request;
        int i2 = 0;
        int hashCode = (request2 != null ? request2.hashCode() : 0) * 31;
        String str = this.requestId;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ConsentRequestBody(request=" + this.request + ", requestId=" + this.requestId + ")";
    }

    public ConsentRequestBody(Request request2, String str) {
        this.request = request2;
        this.requestId = str;
    }

    public final Request getRequest() {
        return this.request;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentRequestBody(Request request2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : request2, (i2 & 2) != 0 ? null : str);
    }

    public final String getRequestId() {
        return this.requestId;
    }
}
