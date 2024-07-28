package net.one97.paytm.nativesdk.instruments.upicollect.models;

import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class UpiDeeplinkRequestModel implements BaseDataModel {
    private Body body;
    private Header head;

    public Header getHeader() {
        return this.head;
    }

    public void setHeader(Header header) {
        this.head = header;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }
}
