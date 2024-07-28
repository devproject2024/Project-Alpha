package com.google.firebase.installations;

import com.google.firebase.e;

public final class h extends e {
    private final a status;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE
    }

    public h(a aVar) {
        this.status = aVar;
    }

    public h(String str, a aVar) {
        super(str);
        this.status = aVar;
    }

    public h(String str, a aVar, Throwable th) {
        super(str, th);
        this.status = aVar;
    }

    public final a getStatus() {
        return this.status;
    }
}
