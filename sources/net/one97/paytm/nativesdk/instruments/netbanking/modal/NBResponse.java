package net.one97.paytm.nativesdk.instruments.netbanking.modal;

public class NBResponse {
    private Body body;
    private Head head;

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }
}
