package net.one97.paytm.common.entity.offline_pg.binResponse;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodrequest.Head;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRBinResponse extends CJRWalletDataModel implements IJRDataModel {
    @c(a = "body")
    CJRBinResponseBody body;
    @c(a = "head")
    Head head;

    public Head getHead() {
        return this.head;
    }

    public CJRBinResponseBody getBody() {
        return this.body;
    }
}
