package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import org.json.JSONObject;

public class CreateOrderModel implements BaseDataModel {
    private JSONObject body = new JSONObject();
    private HashMap<String, String> headers = new HashMap<>();
    private String methodType;
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(HashMap<String, String> hashMap) {
        this.headers = hashMap;
    }

    public String getMethodType() {
        return this.methodType;
    }

    public void setMethodType(String str) {
        this.methodType = str;
    }

    public JSONObject getBody() {
        return this.body;
    }

    public void setBody(JSONObject jSONObject) {
        this.body = jSONObject;
    }
}
