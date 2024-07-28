package org.parceler;

public final class f extends RuntimeException {
    public f(String str) {
        super(str);
    }

    public f(String str, Exception exc) {
        super(str, exc);
    }

    public f(String str, Throwable th) {
        super(str, th);
    }
}
