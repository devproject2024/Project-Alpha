package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.Head;

public class PromoCodeResponse {
    @c(a = "body")
    private Body body;
    @c(a = "head")
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }
}
