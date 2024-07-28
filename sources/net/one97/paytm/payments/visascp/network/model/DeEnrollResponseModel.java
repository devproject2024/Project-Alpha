package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class DeEnrollResponseModel extends BaseModel {
    @c(a = "body")
    private BodyModel mBody;
    @c(a = "head")
    private HeadModel mHead;

    public HeadModel getHead() {
        return this.mHead;
    }

    public BodyModel getBody() {
        return this.mBody;
    }
}
