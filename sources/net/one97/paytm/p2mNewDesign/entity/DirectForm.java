package net.one97.paytm.p2mNewDesign.entity;

import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class DirectForm extends CJRWalletDataModel implements IJRDataModel {
    private String actionUrl;
    private HashMap<String, String> content;
    private HashMap<String, String> headers;
    private String method;
    private String type;

    public String getActionUrl() {
        return this.actionUrl;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(HashMap hashMap) {
        this.headers = hashMap;
    }

    public HashMap<String, String> getContent() {
        return this.content;
    }

    public void setContent(HashMap hashMap) {
        this.content = hashMap;
    }
}
