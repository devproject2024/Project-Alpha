package net.one97.paytm.nativesdk.instruments.upicollect.models;

import java.io.Serializable;
import kotlin.g.b.k;

public final class VerifyVpaResponse implements Serializable {
    private ResponseBody body;
    private Head head;

    public static /* synthetic */ VerifyVpaResponse copy$default(VerifyVpaResponse verifyVpaResponse, Head head2, ResponseBody responseBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            head2 = verifyVpaResponse.head;
        }
        if ((i2 & 2) != 0) {
            responseBody = verifyVpaResponse.body;
        }
        return verifyVpaResponse.copy(head2, responseBody);
    }

    public final Head component1() {
        return this.head;
    }

    public final ResponseBody component2() {
        return this.body;
    }

    public final VerifyVpaResponse copy(Head head2, ResponseBody responseBody) {
        return new VerifyVpaResponse(head2, responseBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerifyVpaResponse)) {
            return false;
        }
        VerifyVpaResponse verifyVpaResponse = (VerifyVpaResponse) obj;
        return k.a((Object) this.head, (Object) verifyVpaResponse.head) && k.a((Object) this.body, (Object) verifyVpaResponse.body);
    }

    public final int hashCode() {
        Head head2 = this.head;
        int i2 = 0;
        int hashCode = (head2 != null ? head2.hashCode() : 0) * 31;
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            i2 = responseBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "VerifyVpaResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public VerifyVpaResponse(Head head2, ResponseBody responseBody) {
        this.head = head2;
        this.body = responseBody;
    }

    public final Head getHead() {
        return this.head;
    }

    public final void setHead(Head head2) {
        this.head = head2;
    }

    public final ResponseBody getBody() {
        return this.body;
    }

    public final void setBody(ResponseBody responseBody) {
        this.body = responseBody;
    }
}
