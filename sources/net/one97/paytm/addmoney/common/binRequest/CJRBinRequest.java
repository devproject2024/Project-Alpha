package net.one97.paytm.addmoney.common.binRequest;

import net.one97.paytm.addmoney.common.model.Head;

public class CJRBinRequest {
    CJRBinRequestBody body;
    Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public CJRBinRequestBody getBody() {
        return this.body;
    }

    public void setBody(CJRBinRequestBody cJRBinRequestBody) {
        this.body = cJRBinRequestBody;
    }
}
