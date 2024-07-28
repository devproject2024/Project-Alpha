package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRPGInstrumentBalance extends CJRWalletDataModel implements IJRDataModel {
    private PostpaidAccountDetails body;
    private Head head;
    private String payMode;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public PostpaidAccountDetails getBody() {
        return this.body;
    }

    public String getPayMode() {
        return this.payMode;
    }

    public void setPayMode(String str) {
        this.payMode = str;
    }
}
