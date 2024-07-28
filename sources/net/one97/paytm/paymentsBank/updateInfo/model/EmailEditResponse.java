package net.one97.paytm.paymentsBank.updateInfo.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class EmailEditResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    public String message;
    @b(a = "responseCode")
    public String responseCode;
    @b(a = "state")
    public String state;
    @b(a = "status")
    public String status;
}
