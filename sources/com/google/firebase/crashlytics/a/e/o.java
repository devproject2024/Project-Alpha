package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class o extends v.d.C0634d.a.b.C0640d {

    /* renamed from: a  reason: collision with root package name */
    private final String f38526a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38527b;

    /* renamed from: c  reason: collision with root package name */
    private final long f38528c;

    /* synthetic */ o(String str, String str2, long j, byte b2) {
        this(str, str2, j);
    }

    private o(String str, String str2, long j) {
        this.f38526a = str;
        this.f38527b = str2;
        this.f38528c = j;
    }

    public final String a() {
        return this.f38526a;
    }

    public final String b() {
        return this.f38527b;
    }

    public final long c() {
        return this.f38528c;
    }

    public final String toString() {
        return "Signal{name=" + this.f38526a + ", code=" + this.f38527b + ", address=" + this.f38528c + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.C0634d.a.b.C0640d) {
            v.d.C0634d.a.b.C0640d dVar = (v.d.C0634d.a.b.C0640d) obj;
            return this.f38526a.equals(dVar.a()) && this.f38527b.equals(dVar.b()) && this.f38528c == dVar.c();
        }
    }

    public final int hashCode() {
        long j = this.f38528c;
        return ((((this.f38526a.hashCode() ^ 1000003) * 1000003) ^ this.f38527b.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    static final class a extends v.d.C0634d.a.b.C0640d.C0641a {

        /* renamed from: a  reason: collision with root package name */
        private String f38529a;

        /* renamed from: b  reason: collision with root package name */
        private String f38530b;

        /* renamed from: c  reason: collision with root package name */
        private Long f38531c;

        a() {
        }

        public final v.d.C0634d.a.b.C0640d.C0641a a(String str) {
            if (str != null) {
                this.f38529a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public final v.d.C0634d.a.b.C0640d.C0641a b(String str) {
            if (str != null) {
                this.f38530b = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public final v.d.C0634d.a.b.C0640d.C0641a a(long j) {
            this.f38531c = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.a.b.C0640d a() {
            String str = "";
            if (this.f38529a == null) {
                str = str + " name";
            }
            if (this.f38530b == null) {
                str = str + " code";
            }
            if (this.f38531c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new o(this.f38529a, this.f38530b, this.f38531c.longValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
