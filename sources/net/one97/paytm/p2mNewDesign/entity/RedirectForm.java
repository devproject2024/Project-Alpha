package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class RedirectForm extends CJRWalletDataModel implements IJRDataModel {
    private String actionUrl;
    private Object content;
    private Object headers;
    private String method;
    private String type;

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setContent(Object obj) {
        this.content = obj;
    }

    public void setHeaders(Object obj) {
        this.headers = obj;
    }

    public Object getContent() {
        return this.content;
    }

    public Object getHeaders() {
        return this.headers;
    }
}
