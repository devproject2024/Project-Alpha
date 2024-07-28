package com.alipay.iap.android.webapp.sdk.network.toolbox;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HttpResponse {
    public final byte[] data;
    public final Map<String, List<String>> headers;
    public final int statusCode;
    public final String statusMessage;

    public HttpResponse(int i2, String str, byte[] bArr, Map<String, List<String>> map) {
        this.statusCode = i2;
        this.statusMessage = str;
        this.data = bArr;
        this.headers = map;
    }

    public String toString() {
        return "HttpResponse{statusCode=" + this.statusCode + ", statusMessage='" + this.statusMessage + '\'' + ", data=" + Arrays.toString(this.data) + ", headers=" + this.headers + '}';
    }
}
