package net.one97.paytm.addmoney.common.paymethodresponse;

import com.google.gson.a.c;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.helper.a;

public class CJPayMethodResponse extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "body")
    private CJRPayMethods cjrPayMethods;
    @c(a = "head")
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public String toString() {
        return super.toString();
    }

    public CJRPayMethods getCjrPayMethods() {
        return this.cjrPayMethods;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return (CJPayMethodResponse) a.b().a(str);
    }
}
