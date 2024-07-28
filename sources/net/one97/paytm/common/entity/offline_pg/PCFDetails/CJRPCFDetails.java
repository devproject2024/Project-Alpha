package net.one97.paytm.common.entity.offline_pg.PCFDetails;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.entity.Head;
import net.one97.paytm.p2mNewDesign.models.BodyV2;

public class CJRPCFDetails extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    private BodyV2 body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public BodyV2 getBody() {
        return this.body;
    }

    public void setBody(BodyV2 bodyV2) {
        this.body = bodyV2;
    }
}
