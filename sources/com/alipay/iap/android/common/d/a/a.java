package com.alipay.iap.android.common.d.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class a implements Serializable {
    public String appId;
    public String appKey;
    public String authCode;
    public String environment;
    public Map<String, String> extras;
    public String gatewayUrl;
    public Map<String, String> headers;
    public String productId;

    public final void addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.put(str, str2);
    }

    public final void addHeaders(Map<String, String> map) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.putAll(map);
    }
}
