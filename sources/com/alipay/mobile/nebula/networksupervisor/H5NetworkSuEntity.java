package com.alipay.mobile.nebula.networksupervisor;

public class H5NetworkSuEntity {
    private byte[] body;
    private String method;
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public byte[] getBody() {
        return this.body;
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public String toString() {
        return "url " + this.url + " method " + this.method;
    }
}
