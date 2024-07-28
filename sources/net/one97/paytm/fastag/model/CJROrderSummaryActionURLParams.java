package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryActionURLParams extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private transient o mBody;
    @b(a = "method")
    private String mMethod;
    @b(a = "url")
    private String mUrl;

    public String getUrl() {
        return this.mUrl;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public o getBody() {
        return this.mBody;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }
}
