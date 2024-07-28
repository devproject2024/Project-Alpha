package net.one97.paytm.p2mNewDesign.entity;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.network.c;

public class CJRProcessTranscationResponse extends CJRWalletDataModel implements IJRDataModel, c {
    private CJRProcessTranscationBody body;
    private Head head;
    private String result;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public CJRProcessTranscationBody getBody() {
        return this.body;
    }

    public void setBody(CJRProcessTranscationBody cJRProcessTranscationBody) {
        this.body = cJRProcessTranscationBody;
    }

    public String toString() {
        return "ClassPojo [head = " + this.head + ", body = " + this.body + "]";
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        this.result = str;
        return super.parseResponse(str, fVar);
    }

    public String getResult() {
        return this.result;
    }
}
