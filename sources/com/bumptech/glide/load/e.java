package com.bumptech.glide.load;

import java.io.IOException;

public final class e extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public e(int i2) {
        this("Http request failed with status code: ".concat(String.valueOf(i2)), i2);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i2) {
        this(str, i2, (Throwable) null);
    }

    public e(String str, int i2, Throwable th) {
        super(str, th);
        this.statusCode = i2;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
