package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class u extends v.d.f {

    /* renamed from: a  reason: collision with root package name */
    private final String f38570a;

    /* synthetic */ u(String str, byte b2) {
        this(str);
    }

    private u(String str) {
        this.f38570a = str;
    }

    public final String a() {
        return this.f38570a;
    }

    public final String toString() {
        return "User{identifier=" + this.f38570a + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.f) {
            return this.f38570a.equals(((v.d.f) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f38570a.hashCode() ^ 1000003;
    }

    static final class a extends v.d.f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38571a;

        a() {
        }

        public final v.d.f.a a(String str) {
            if (str != null) {
                this.f38571a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public final v.d.f a() {
            String str = "";
            if (this.f38571a == null) {
                str = str + " identifier";
            }
            if (str.isEmpty()) {
                return new u(this.f38571a, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
