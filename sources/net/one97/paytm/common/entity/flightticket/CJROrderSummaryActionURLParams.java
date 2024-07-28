package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryActionURLParams implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private transient o mBody;
    @b(a = "method")
    private String mMethod;
    @b(a = "url")
    private String mUrl;
    @b(a = "newURL")
    private String newUrl;

    public String getUrl() {
        return this.mUrl;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public o getBody() {
        return this.mBody;
    }

    public String getnewUrl() {
        return this.newUrl;
    }
}
