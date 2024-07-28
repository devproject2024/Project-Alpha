package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUrlParams implements IJRDataModel {
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
