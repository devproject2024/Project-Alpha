package net.one97.paytm.common.entity.offline_pg.paymethodresponse;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRFastForwardResponse extends CJRWalletDataModel implements IJRDataModel {
    CJRFastForwardResponseDetail body;
    Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public CJRFastForwardResponseDetail getFastForwardResponseDetail() {
        return this.body;
    }

    public void setFastForwardResponseDetail(CJRFastForwardResponseDetail cJRFastForwardResponseDetail) {
        this.body = cJRFastForwardResponseDetail;
    }
}
