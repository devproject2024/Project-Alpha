package net.one97.paytm.common.entitiy.offline_pg.paymethodresponse;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head;

public class CJPayMethodResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRPayMethods cjrPayMethods;
    @b(a = "head")
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public CJRPayMethods getCjrPayMethods() {
        return this.cjrPayMethods;
    }
}
