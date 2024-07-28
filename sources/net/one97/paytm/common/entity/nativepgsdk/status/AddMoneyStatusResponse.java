package net.one97.paytm.common.entity.nativepgsdk.status;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head;

public class AddMoneyStatusResponse implements IJRDataModel {
    Head head;
    @c(a = "body")
    AddMoneyStatusResponseBody mResponse;

    public AddMoneyStatusResponseBody getResponse() {
        return this.mResponse;
    }
}
