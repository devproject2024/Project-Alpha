package net.one97.paytm.p2mNewDesign.entity.nativeOTP;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.entity.Head;

public class DirectFormsResponse extends CJRWalletDataModel implements IJRDataModel {
    private DirectFormsBody body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public DirectFormsBody getBody() {
        return this.body;
    }

    public void setBody(DirectFormsBody directFormsBody) {
        this.body = directFormsBody;
    }
}
