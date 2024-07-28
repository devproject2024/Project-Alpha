package net.one97.paytm.wallet.common.entity.offline_pg.paymethodresponse;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entitiy.offline_pg.paymethodresponse.CJRPayMethods;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.network.c;
import net.one97.paytm.wallet.communicator.b;

public class CJPayMethodResponse extends CJRWalletDataModel implements IJRDataModel, c {
    @com.google.gson.a.c(a = "body")
    private CJRPayMethods cjrPayMethods;
    @com.google.gson.a.c(a = "head")
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public CJRPayMethods getCjrPayMethods() {
        return this.cjrPayMethods;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return (CJPayMethodResponse) b.a().jsonToModel(str);
    }
}
