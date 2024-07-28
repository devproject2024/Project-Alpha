package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class g extends v.d.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f38453a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38454b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38455c;

    /* renamed from: d  reason: collision with root package name */
    private final v.d.a.b f38456d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38457e;

    /* synthetic */ g(String str, String str2, String str3, v.d.a.b bVar, String str4, byte b2) {
        this(str, str2, str3, bVar, str4);
    }

    private g(String str, String str2, String str3, v.d.a.b bVar, String str4) {
        this.f38453a = str;
        this.f38454b = str2;
        this.f38455c = str3;
        this.f38456d = bVar;
        this.f38457e = str4;
    }

    public final String a() {
        return this.f38453a;
    }

    public final String b() {
        return this.f38454b;
    }

    public final String c() {
        return this.f38455c;
    }

    public final v.d.a.b d() {
        return this.f38456d;
    }

    public final String e() {
        return this.f38457e;
    }

    public final String toString() {
        return "Application{identifier=" + this.f38453a + ", version=" + this.f38454b + ", displayVersion=" + this.f38455c + ", organization=" + this.f38456d + ", installationUuid=" + this.f38457e + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = r4.f38456d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r1 = r4.f38457e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r1 = r4.f38455c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.a.e.v.d.a
            r2 = 0
            if (r1 == 0) goto L_0x0063
            com.google.firebase.crashlytics.a.e.v$d$a r5 = (com.google.firebase.crashlytics.a.e.v.d.a) r5
            java.lang.String r1 = r4.f38453a
            java.lang.String r3 = r5.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
            java.lang.String r1 = r4.f38454b
            java.lang.String r3 = r5.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
            java.lang.String r1 = r4.f38455c
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = r5.c()
            if (r1 != 0) goto L_0x0063
            goto L_0x0038
        L_0x002e:
            java.lang.String r3 = r5.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x0038:
            com.google.firebase.crashlytics.a.e.v$d$a$b r1 = r4.f38456d
            if (r1 != 0) goto L_0x0043
            com.google.firebase.crashlytics.a.e.v$d$a$b r1 = r5.d()
            if (r1 != 0) goto L_0x0063
            goto L_0x004d
        L_0x0043:
            com.google.firebase.crashlytics.a.e.v$d$a$b r3 = r5.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x004d:
            java.lang.String r1 = r4.f38457e
            if (r1 != 0) goto L_0x0058
            java.lang.String r5 = r5.e()
            if (r5 != 0) goto L_0x0063
            goto L_0x0062
        L_0x0058:
            java.lang.String r5 = r5.e()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0063
        L_0x0062:
            return r0
        L_0x0063:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (((this.f38453a.hashCode() ^ 1000003) * 1000003) ^ this.f38454b.hashCode()) * 1000003;
        String str = this.f38455c;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        v.d.a.b bVar = this.f38456d;
        int hashCode3 = (hashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f38457e;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode3 ^ i2;
    }

    static final class a extends v.d.a.C0633a {

        /* renamed from: a  reason: collision with root package name */
        private String f38458a;

        /* renamed from: b  reason: collision with root package name */
        private String f38459b;

        /* renamed from: c  reason: collision with root package name */
        private String f38460c;

        /* renamed from: d  reason: collision with root package name */
        private v.d.a.b f38461d;

        /* renamed from: e  reason: collision with root package name */
        private String f38462e;

        a() {
        }

        public final v.d.a.C0633a a(String str) {
            if (str != null) {
                this.f38458a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public final v.d.a.C0633a b(String str) {
            if (str != null) {
                this.f38459b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        public final v.d.a.C0633a c(String str) {
            this.f38460c = str;
            return this;
        }

        public final v.d.a.C0633a d(String str) {
            this.f38462e = str;
            return this;
        }

        public final v.d.a a() {
            String str = "";
            if (this.f38458a == null) {
                str = str + " identifier";
            }
            if (this.f38459b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new g(this.f38458a, this.f38459b, this.f38460c, this.f38461d, this.f38462e, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
