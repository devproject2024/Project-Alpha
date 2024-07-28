package net.one97.paytm.common.entity.impsdatamodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAddRefundAmount extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRAccountBodyResponse body;

    public CJRAccountBodyResponse getBody() {
        return this.body;
    }

    public void setBody(CJRAccountBodyResponse cJRAccountBodyResponse) {
        this.body = cJRAccountBodyResponse;
    }
}
