package net.one97.paytm.nativesdk.transcation.model;

import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.Head;

public final class OtpApiResponse implements Serializable {
    private Body body;
    private Head head;

    public static /* synthetic */ OtpApiResponse copy$default(OtpApiResponse otpApiResponse, Head head2, Body body2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            head2 = otpApiResponse.head;
        }
        if ((i2 & 2) != 0) {
            body2 = otpApiResponse.body;
        }
        return otpApiResponse.copy(head2, body2);
    }

    public final Head component1() {
        return this.head;
    }

    public final Body component2() {
        return this.body;
    }

    public final OtpApiResponse copy(Head head2, Body body2) {
        return new OtpApiResponse(head2, body2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtpApiResponse)) {
            return false;
        }
        OtpApiResponse otpApiResponse = (OtpApiResponse) obj;
        return k.a((Object) this.head, (Object) otpApiResponse.head) && k.a((Object) this.body, (Object) otpApiResponse.body);
    }

    public final int hashCode() {
        Head head2 = this.head;
        int i2 = 0;
        int hashCode = (head2 != null ? head2.hashCode() : 0) * 31;
        Body body2 = this.body;
        if (body2 != null) {
            i2 = body2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "OtpApiResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public OtpApiResponse(Head head2, Body body2) {
        this.head = head2;
        this.body = body2;
    }

    public final Head getHead() {
        return this.head;
    }

    public final void setHead(Head head2) {
        this.head = head2;
    }

    public final Body getBody() {
        return this.body;
    }

    public final void setBody(Body body2) {
        this.body = body2;
    }
}
