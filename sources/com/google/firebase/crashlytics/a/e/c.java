package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class c extends v.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f38423a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38424b;

    /* synthetic */ c(String str, String str2, byte b2) {
        this(str, str2);
    }

    private c(String str, String str2) {
        this.f38423a = str;
        this.f38424b = str2;
    }

    public final String a() {
        return this.f38423a;
    }

    public final String b() {
        return this.f38424b;
    }

    public final String toString() {
        return "CustomAttribute{key=" + this.f38423a + ", value=" + this.f38424b + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.b) {
            v.b bVar = (v.b) obj;
            return this.f38423a.equals(bVar.a()) && this.f38424b.equals(bVar.b());
        }
    }

    public final int hashCode() {
        return ((this.f38423a.hashCode() ^ 1000003) * 1000003) ^ this.f38424b.hashCode();
    }

    static final class a extends v.b.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38425a;

        /* renamed from: b  reason: collision with root package name */
        private String f38426b;

        a() {
        }

        public final v.b.a a(String str) {
            if (str != null) {
                this.f38425a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        public final v.b.a b(String str) {
            if (str != null) {
                this.f38426b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }

        public final v.b a() {
            String str = "";
            if (this.f38425a == null) {
                str = str + " key";
            }
            if (this.f38426b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new c(this.f38425a, this.f38426b, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
