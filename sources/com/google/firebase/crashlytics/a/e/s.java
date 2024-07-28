package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class s extends v.d.C0634d.C0645d {

    /* renamed from: a  reason: collision with root package name */
    private final String f38560a;

    /* synthetic */ s(String str, byte b2) {
        this(str);
    }

    private s(String str) {
        this.f38560a = str;
    }

    public final String a() {
        return this.f38560a;
    }

    public final String toString() {
        return "Log{content=" + this.f38560a + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.C0634d.C0645d) {
            return this.f38560a.equals(((v.d.C0634d.C0645d) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f38560a.hashCode() ^ 1000003;
    }

    static final class a extends v.d.C0634d.C0645d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38561a;

        a() {
        }

        public final v.d.C0634d.C0645d.a a(String str) {
            if (str != null) {
                this.f38561a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }

        public final v.d.C0634d.C0645d a() {
            String str = "";
            if (this.f38561a == null) {
                str = str + " content";
            }
            if (str.isEmpty()) {
                return new s(this.f38561a, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
