package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRUrlParams extends IJRPaytmDataModel {
    @b(a = "body")
    private transient o mBody;
    @b(a = "method")
    private String method;
    @b(a = "url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }

    public o getBody() {
        return this.mBody;
    }
}
