package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRFetchBinDetailsV2 extends CJRWalletDataModel implements IJRDataModel {
    private CJRFetchBinDetailsBody body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public CJRFetchBinDetailsBody getBody() {
        return this.body;
    }

    public void setBody(CJRFetchBinDetailsBody cJRFetchBinDetailsBody) {
        this.body = cJRFetchBinDetailsBody;
    }

    public String toString() {
        return "ClassPojo [head = " + this.head + ", body = " + this.body + "]";
    }
}
