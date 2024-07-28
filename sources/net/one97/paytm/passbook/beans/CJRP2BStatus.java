package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRP2BStatus extends IJRDataModel {
    @b(a = "response")
    private CJRP2BStatusResponse mResponse;
    @b(a = "statusCode")
    private String mStatusCode;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public CJRP2BStatusResponse getResponse() {
        return this.mResponse;
    }
}
