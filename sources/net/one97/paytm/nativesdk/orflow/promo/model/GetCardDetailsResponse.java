package net.one97.paytm.nativesdk.orflow.promo.model;

import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class GetCardDetailsResponse implements Serializable, BaseDataModel {
    private Body body;
    private Head head;

    public GetCardDetailsResponse() {
        this((Head) null, (Body) null, 3, (g) null);
    }

    public static /* synthetic */ GetCardDetailsResponse copy$default(GetCardDetailsResponse getCardDetailsResponse, Head head2, Body body2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            head2 = getCardDetailsResponse.head;
        }
        if ((i2 & 2) != 0) {
            body2 = getCardDetailsResponse.body;
        }
        return getCardDetailsResponse.copy(head2, body2);
    }

    public final Head component1() {
        return this.head;
    }

    public final Body component2() {
        return this.body;
    }

    public final GetCardDetailsResponse copy(Head head2, Body body2) {
        return new GetCardDetailsResponse(head2, body2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetCardDetailsResponse)) {
            return false;
        }
        GetCardDetailsResponse getCardDetailsResponse = (GetCardDetailsResponse) obj;
        return k.a((Object) this.head, (Object) getCardDetailsResponse.head) && k.a((Object) this.body, (Object) getCardDetailsResponse.body);
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
        return "GetCardDetailsResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public GetCardDetailsResponse(Head head2, Body body2) {
        this.head = head2;
        this.body = body2;
    }

    public final Head getHead() {
        return this.head;
    }

    public final void setHead(Head head2) {
        this.head = head2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCardDetailsResponse(Head head2, Body body2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : head2, (i2 & 2) != 0 ? null : body2);
    }

    public final Body getBody() {
        return this.body;
    }

    public final void setBody(Body body2) {
        this.body = body2;
    }
}
