package com.google.firebase.installations.a;

import com.google.firebase.installations.a.c;
import com.google.firebase.installations.a.d;

final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private final String f38919b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f38920c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38921d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38922e;

    /* renamed from: f  reason: collision with root package name */
    private final long f38923f;

    /* renamed from: g  reason: collision with root package name */
    private final long f38924g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38925h;

    /* synthetic */ a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4, byte b2) {
        this(str, aVar, str2, str3, j, j2, str4);
    }

    private a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4) {
        this.f38919b = str;
        this.f38920c = aVar;
        this.f38921d = str2;
        this.f38922e = str3;
        this.f38923f = j;
        this.f38924g = j2;
        this.f38925h = str4;
    }

    public final String a() {
        return this.f38919b;
    }

    public final c.a b() {
        return this.f38920c;
    }

    public final String c() {
        return this.f38921d;
    }

    public final String d() {
        return this.f38922e;
    }

    public final long e() {
        return this.f38923f;
    }

    public final long f() {
        return this.f38924g;
    }

    public final String g() {
        return this.f38925h;
    }

    public final String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f38919b + ", registrationStatus=" + this.f38920c + ", authToken=" + this.f38921d + ", refreshToken=" + this.f38922e + ", expiresInSecs=" + this.f38923f + ", tokenCreationEpochInSecs=" + this.f38924g + ", fisError=" + this.f38925h + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r7.f38921d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r1 = r7.f38922e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        r1 = r7.f38925h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.installations.a.d
            r2 = 0
            if (r1 == 0) goto L_0x0080
            com.google.firebase.installations.a.d r8 = (com.google.firebase.installations.a.d) r8
            java.lang.String r1 = r7.f38919b
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = r8.a()
            if (r1 != 0) goto L_0x0080
            goto L_0x0020
        L_0x0016:
            java.lang.String r3 = r8.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0080
        L_0x0020:
            com.google.firebase.installations.a.c$a r1 = r7.f38920c
            com.google.firebase.installations.a.c$a r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0080
            java.lang.String r1 = r7.f38921d
            if (r1 != 0) goto L_0x0037
            java.lang.String r1 = r8.c()
            if (r1 != 0) goto L_0x0080
            goto L_0x0041
        L_0x0037:
            java.lang.String r3 = r8.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0080
        L_0x0041:
            java.lang.String r1 = r7.f38922e
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = r8.d()
            if (r1 != 0) goto L_0x0080
            goto L_0x0056
        L_0x004c:
            java.lang.String r3 = r8.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0080
        L_0x0056:
            long r3 = r7.f38923f
            long r5 = r8.e()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0080
            long r3 = r7.f38924g
            long r5 = r8.f()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0080
            java.lang.String r1 = r7.f38925h
            if (r1 != 0) goto L_0x0075
            java.lang.String r8 = r8.g()
            if (r8 != 0) goto L_0x0080
            goto L_0x007f
        L_0x0075:
            java.lang.String r8 = r8.g()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0080
        L_0x007f:
            return r0
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.a.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        String str = this.f38919b;
        int i2 = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f38920c.hashCode()) * 1000003;
        String str2 = this.f38921d;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f38922e;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.f38923f;
        long j2 = this.f38924g;
        int i3 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f38925h;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return i3 ^ i2;
    }

    public final d.a h() {
        return new C0649a(this, (byte) 0);
    }

    /* renamed from: com.google.firebase.installations.a.a$a  reason: collision with other inner class name */
    static final class C0649a extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38926a;

        /* renamed from: b  reason: collision with root package name */
        private c.a f38927b;

        /* renamed from: c  reason: collision with root package name */
        private String f38928c;

        /* renamed from: d  reason: collision with root package name */
        private String f38929d;

        /* renamed from: e  reason: collision with root package name */
        private Long f38930e;

        /* renamed from: f  reason: collision with root package name */
        private Long f38931f;

        /* renamed from: g  reason: collision with root package name */
        private String f38932g;

        /* synthetic */ C0649a(d dVar, byte b2) {
            this(dVar);
        }

        C0649a() {
        }

        private C0649a(d dVar) {
            this.f38926a = dVar.a();
            this.f38927b = dVar.b();
            this.f38928c = dVar.c();
            this.f38929d = dVar.d();
            this.f38930e = Long.valueOf(dVar.e());
            this.f38931f = Long.valueOf(dVar.f());
            this.f38932g = dVar.g();
        }

        public final d.a a(String str) {
            this.f38926a = str;
            return this;
        }

        public final d.a a(c.a aVar) {
            if (aVar != null) {
                this.f38927b = aVar;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public final d.a b(String str) {
            this.f38928c = str;
            return this;
        }

        public final d.a c(String str) {
            this.f38929d = str;
            return this;
        }

        public final d.a a(long j) {
            this.f38930e = Long.valueOf(j);
            return this;
        }

        public final d.a b(long j) {
            this.f38931f = Long.valueOf(j);
            return this;
        }

        public final d.a d(String str) {
            this.f38932g = str;
            return this;
        }

        public final d a() {
            String str = "";
            if (this.f38927b == null) {
                str = str + " registrationStatus";
            }
            if (this.f38930e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f38931f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f38926a, this.f38927b, this.f38928c, this.f38929d, this.f38930e.longValue(), this.f38931f.longValue(), this.f38932g, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
