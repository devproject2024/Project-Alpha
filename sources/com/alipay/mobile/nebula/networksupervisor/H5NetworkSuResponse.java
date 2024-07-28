package com.alipay.mobile.nebula.networksupervisor;

import java.util.List;
import java.util.Map;

public class H5NetworkSuResponse extends H5NetworkSuEntity {
    private Map<String, List<String>> headers;
    private boolean isChunked;
    private boolean isGzip;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }

    public boolean isGzip() {
        return this.isGzip;
    }

    public void setGzip(boolean z) {
        this.isGzip = z;
    }

    public boolean isChunked() {
        return this.isChunked;
    }

    public void setChunked(boolean z) {
        this.isChunked = z;
    }

    public String toString() {
        return "H5NetworkSuResponse " + super.toString();
    }
}
