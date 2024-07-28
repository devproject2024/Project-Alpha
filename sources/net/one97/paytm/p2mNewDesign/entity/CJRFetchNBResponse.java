package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRFetchNBResponse extends CJRWalletDataModel implements IJRDataModel {
    private CJRNBBody body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public CJRNBBody getBody() {
        return this.body;
    }

    public void setBody(CJRNBBody cJRNBBody) {
        this.body = cJRNBBody;
    }

    public String toString() {
        return "ClassPojo [head = " + this.head + ", body = " + this.body + "]";
    }
}
