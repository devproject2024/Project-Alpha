package net.one97.paytm.o2o.events.common;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventPreClaimInsuranceResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }
}
