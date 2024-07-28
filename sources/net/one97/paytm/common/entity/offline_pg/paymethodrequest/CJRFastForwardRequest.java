package net.one97.paytm.common.entity.offline_pg.paymethodrequest;

import com.google.gson.a.c;

public class CJRFastForwardRequest {
    @c(a = "body")
    CJRFastForwardRequestDetail fastForwardDetail;
    Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public CJRFastForwardRequestDetail getFastForwardDetail() {
        return this.fastForwardDetail;
    }

    public void setFastForwardDetail(CJRFastForwardRequestDetail cJRFastForwardRequestDetail) {
        this.fastForwardDetail = cJRFastForwardRequestDetail;
    }
}
