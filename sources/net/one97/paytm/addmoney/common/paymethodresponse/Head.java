package net.one97.paytm.addmoney.common.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class Head implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String clientId;
    private String mid;
    private String requestId;
    private String responseTimestamp;
    private String version;

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public void setResponseTimestamp(String str) {
        this.responseTimestamp = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
