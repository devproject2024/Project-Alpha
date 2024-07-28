package net.one97.paytm.nativesdk.common.model;

public class CJPayMethodResponse implements BaseDataModel {
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

    public String toString() {
        return "ClassPojo [body = " + this.body + ", head = " + this.head + "]";
    }
}
