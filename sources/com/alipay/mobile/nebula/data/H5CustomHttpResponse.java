package com.alipay.mobile.nebula.data;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class H5CustomHttpResponse {
    private Map<String, List<String>> headers;
    private InputStream inputStream;
    private byte[] resData;
    private int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public void setResData(byte[] bArr) {
        this.resData = bArr;
    }

    public InputStream getResStream() {
        return this.inputStream;
    }

    public void setResStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }
}
