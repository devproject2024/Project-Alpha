package net.one97.paytm.recharge;

import java.io.Serializable;

public final class d implements Serializable {
    private String id;
    private String param;
    private String url;

    public final String getParam() {
        return this.param;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setParam(String str) {
        this.param = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }
}
