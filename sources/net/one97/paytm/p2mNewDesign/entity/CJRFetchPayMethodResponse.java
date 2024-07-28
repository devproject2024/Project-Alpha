package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.models.BodyV2;
import net.one97.paytm.p2mNewDesign.models.HeadV2;

public class CJRFetchPayMethodResponse extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    public BodyV2 body;
    private HeadV2 head;

    public HeadV2 getHead() {
        return this.head;
    }

    public void setHead(HeadV2 headV2) {
        this.head = headV2;
    }

    public BodyV2 getBody() {
        return this.body;
    }

    public void setBody(BodyV2 bodyV2) {
        this.body = bodyV2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "ClassPojo [head = " + this.head + ", body = " + this.body + "]";
    }
}
