package com.google.firebase.installations;

import com.google.firebase.installations.l;

final class a extends l {

    /* renamed from: a  reason: collision with root package name */
    private final String f38913a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38914b;

    /* renamed from: c  reason: collision with root package name */
    private final long f38915c;

    /* synthetic */ a(String str, long j, long j2, byte b2) {
        this(str, j, j2);
    }

    private a(String str, long j, long j2) {
        this.f38913a = str;
        this.f38914b = j;
        this.f38915c = j2;
    }

    public final String a() {
        return this.f38913a;
    }

    public final long b() {
        return this.f38914b;
    }

    public final long c() {
        return this.f38915c;
    }

    public final String toString() {
        return "InstallationTokenResult{token=" + this.f38913a + ", tokenExpirationTimestamp=" + this.f38914b + ", tokenCreationTimestamp=" + this.f38915c + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.f38913a.equals(lVar.a()) && this.f38914b == lVar.b() && this.f38915c == lVar.c();
        }
    }

    public final int hashCode() {
        long j = this.f38914b;
        long j2 = this.f38915c;
        return ((((this.f38913a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    /* renamed from: com.google.firebase.installations.a$a  reason: collision with other inner class name */
    static final class C0648a extends l.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38916a;

        /* renamed from: b  reason: collision with root package name */
        private Long f38917b;

        /* renamed from: c  reason: collision with root package name */
        private Long f38918c;

        C0648a() {
        }

        public final l.a a(String str) {
            if (str != null) {
                this.f38916a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        public final l.a a(long j) {
            this.f38917b = Long.valueOf(j);
            return this;
        }

        public final l.a b(long j) {
            this.f38918c = Long.valueOf(j);
            return this;
        }

        public final l a() {
            String str = "";
            if (this.f38916a == null) {
                str = str + " token";
            }
            if (this.f38917b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f38918c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f38916a, this.f38917b.longValue(), this.f38918c.longValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
