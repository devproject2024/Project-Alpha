package com.alipay.iap.android.webapp.sdk.network.toolbox;

import com.alibaba.a.b;
import com.alibaba.a.e;
import java.util.Map;

public class HttpRequest {
    public String data;
    public e headerJsonOb;
    public b headersArray;
    public Map<String, String> headersMap;
    public String method;
    public boolean notFollowRedirects;
    public int retry;
    public int timeoutMs;
    public String url;

    public HttpRequest(String str, int i2, Map<String, String> map, String str2, String str3) {
        this.url = str;
        this.timeoutMs = i2;
        this.headersMap = map;
        this.method = str2;
        this.data = str3;
    }

    public HttpRequest(String str, int i2, b bVar, e eVar, Map<String, String> map, String str2, String str3) {
        this.url = str;
        this.timeoutMs = i2;
        this.headersArray = bVar;
        this.headerJsonOb = eVar;
        this.headersMap = map;
        this.method = str2;
        this.data = str3;
    }

    public String toString() {
        return "HttpRequest{url='" + this.url + '\'' + ", timeoutMs=" + this.timeoutMs + ", headersArray=" + this.headersArray + ", headerJsonOb=" + this.headerJsonOb + ", headersMap=" + this.headersMap + ", method='" + this.method + '\'' + ", data='" + this.data + '\'' + '}';
    }
}
