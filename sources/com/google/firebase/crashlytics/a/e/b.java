package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class b extends v {

    /* renamed from: a  reason: collision with root package name */
    private final String f38407a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38408b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38409c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38410d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38411e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38412f;

    /* renamed from: g  reason: collision with root package name */
    private final v.d f38413g;

    /* renamed from: h  reason: collision with root package name */
    private final v.c f38414h;

    /* synthetic */ b(String str, String str2, int i2, String str3, String str4, String str5, v.d dVar, v.c cVar, byte b2) {
        this(str, str2, i2, str3, str4, str5, dVar, cVar);
    }

    private b(String str, String str2, int i2, String str3, String str4, String str5, v.d dVar, v.c cVar) {
        this.f38407a = str;
        this.f38408b = str2;
        this.f38409c = i2;
        this.f38410d = str3;
        this.f38411e = str4;
        this.f38412f = str5;
        this.f38413g = dVar;
        this.f38414h = cVar;
    }

    public final String a() {
        return this.f38407a;
    }

    public final String b() {
        return this.f38408b;
    }

    public final int c() {
        return this.f38409c;
    }

    public final String d() {
        return this.f38410d;
    }

    public final String e() {
        return this.f38411e;
    }

    public final String f() {
        return this.f38412f;
    }

    public final v.d g() {
        return this.f38413g;
    }

    public final v.c h() {
        return this.f38414h;
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f38407a + ", gmpAppId=" + this.f38408b + ", platform=" + this.f38409c + ", installationUuid=" + this.f38410d + ", buildVersion=" + this.f38411e + ", displayVersion=" + this.f38412f + ", session=" + this.f38413g + ", ndkPayload=" + this.f38414h + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        r1 = r4.f38413g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        r1 = r4.f38414h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.a.e.v
            r2 = 0
            if (r1 == 0) goto L_0x007a
            com.google.firebase.crashlytics.a.e.v r5 = (com.google.firebase.crashlytics.a.e.v) r5
            java.lang.String r1 = r4.f38407a
            java.lang.String r3 = r5.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = r4.f38408b
            java.lang.String r3 = r5.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
            int r1 = r4.f38409c
            int r3 = r5.c()
            if (r1 != r3) goto L_0x007a
            java.lang.String r1 = r4.f38410d
            java.lang.String r3 = r5.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = r4.f38411e
            java.lang.String r3 = r5.e()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = r4.f38412f
            java.lang.String r3 = r5.f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
            com.google.firebase.crashlytics.a.e.v$d r1 = r4.f38413g
            if (r1 != 0) goto L_0x005a
            com.google.firebase.crashlytics.a.e.v$d r1 = r5.g()
            if (r1 != 0) goto L_0x007a
            goto L_0x0064
        L_0x005a:
            com.google.firebase.crashlytics.a.e.v$d r3 = r5.g()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007a
        L_0x0064:
            com.google.firebase.crashlytics.a.e.v$c r1 = r4.f38414h
            if (r1 != 0) goto L_0x006f
            com.google.firebase.crashlytics.a.e.v$c r5 = r5.h()
            if (r5 != 0) goto L_0x007a
            goto L_0x0079
        L_0x006f:
            com.google.firebase.crashlytics.a.e.v$c r5 = r5.h()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x007a
        L_0x0079:
            return r0
        L_0x007a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (((((((((((this.f38407a.hashCode() ^ 1000003) * 1000003) ^ this.f38408b.hashCode()) * 1000003) ^ this.f38409c) * 1000003) ^ this.f38410d.hashCode()) * 1000003) ^ this.f38411e.hashCode()) * 1000003) ^ this.f38412f.hashCode()) * 1000003;
        v.d dVar = this.f38413g;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        v.c cVar = this.f38414h;
        if (cVar != null) {
            i2 = cVar.hashCode();
        }
        return hashCode2 ^ i2;
    }

    /* access modifiers changed from: protected */
    public final v.a i() {
        return new a(this, (byte) 0);
    }

    static final class a extends v.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38415a;

        /* renamed from: b  reason: collision with root package name */
        private String f38416b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f38417c;

        /* renamed from: d  reason: collision with root package name */
        private String f38418d;

        /* renamed from: e  reason: collision with root package name */
        private String f38419e;

        /* renamed from: f  reason: collision with root package name */
        private String f38420f;

        /* renamed from: g  reason: collision with root package name */
        private v.d f38421g;

        /* renamed from: h  reason: collision with root package name */
        private v.c f38422h;

        /* synthetic */ a(v vVar, byte b2) {
            this(vVar);
        }

        a() {
        }

        private a(v vVar) {
            this.f38415a = vVar.a();
            this.f38416b = vVar.b();
            this.f38417c = Integer.valueOf(vVar.c());
            this.f38418d = vVar.d();
            this.f38419e = vVar.e();
            this.f38420f = vVar.f();
            this.f38421g = vVar.g();
            this.f38422h = vVar.h();
        }

        public final v.a a(String str) {
            if (str != null) {
                this.f38415a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public final v.a b(String str) {
            if (str != null) {
                this.f38416b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public final v.a a(int i2) {
            this.f38417c = Integer.valueOf(i2);
            return this;
        }

        public final v.a c(String str) {
            if (str != null) {
                this.f38418d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public final v.a d(String str) {
            if (str != null) {
                this.f38419e = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public final v.a e(String str) {
            if (str != null) {
                this.f38420f = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public final v.a a(v.d dVar) {
            this.f38421g = dVar;
            return this;
        }

        public final v.a a(v.c cVar) {
            this.f38422h = cVar;
            return this;
        }

        public final v a() {
            String str = "";
            if (this.f38415a == null) {
                str = str + " sdkVersion";
            }
            if (this.f38416b == null) {
                str = str + " gmpAppId";
            }
            if (this.f38417c == null) {
                str = str + " platform";
            }
            if (this.f38418d == null) {
                str = str + " installationUuid";
            }
            if (this.f38419e == null) {
                str = str + " buildVersion";
            }
            if (this.f38420f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.f38415a, this.f38416b, this.f38417c.intValue(), this.f38418d, this.f38419e, this.f38420f, this.f38421g, this.f38422h, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
