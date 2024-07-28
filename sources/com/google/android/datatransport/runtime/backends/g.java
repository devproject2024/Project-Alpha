package com.google.android.datatransport.runtime.backends;

public abstract class g {

    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public abstract a a();

    public abstract long b();

    public static g c() {
        return new b(a.TRANSIENT_ERROR, -1);
    }

    public static g d() {
        return new b(a.FATAL_ERROR, -1);
    }
}
