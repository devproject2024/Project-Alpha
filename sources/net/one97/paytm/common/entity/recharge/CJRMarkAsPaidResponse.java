package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMarkAsPaidResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "status")
    private int status;

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
