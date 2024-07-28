package com.google.firebase.remoteconfig;

public final class m extends i {
    private final int httpStatusCode;

    public m(int i2, String str) {
        super(str);
        this.httpStatusCode = i2;
    }

    public m(int i2, String str, Throwable th) {
        super(str, th);
        this.httpStatusCode = i2;
    }

    public final int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
