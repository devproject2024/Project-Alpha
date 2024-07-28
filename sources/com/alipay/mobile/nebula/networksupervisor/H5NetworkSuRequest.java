package com.alipay.mobile.nebula.networksupervisor;

import java.util.Map;

public class H5NetworkSuRequest extends H5NetworkSuEntity {
    private Map<String, String> headers;

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public String toString() {
        return "H5NetworkSuRequest " + super.toString();
    }
}
