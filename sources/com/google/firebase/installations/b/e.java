package com.google.firebase.installations.b;

import com.google.firebase.installations.b.b;

public abstract class e {

    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(b bVar);

        public abstract a a(String str);

        public abstract e a();
    }

    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public abstract String a();

    public abstract long b();

    public abstract b c();

    public static a d() {
        return new b.a().a(0);
    }
}
