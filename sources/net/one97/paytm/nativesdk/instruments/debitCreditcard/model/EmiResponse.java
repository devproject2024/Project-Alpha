package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.Head;

public class EmiResponse {
    @c(a = "body")
    @a
    private Body body;
    @c(a = "head")
    @a
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }
}
