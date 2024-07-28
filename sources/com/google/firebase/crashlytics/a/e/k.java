package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class k extends v.d.C0634d.a {

    /* renamed from: a  reason: collision with root package name */
    private final v.d.C0634d.a.b f38492a;

    /* renamed from: b  reason: collision with root package name */
    private final w<v.b> f38493b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f38494c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38495d;

    /* synthetic */ k(v.d.C0634d.a.b bVar, w wVar, Boolean bool, int i2, byte b2) {
        this(bVar, wVar, bool, i2);
    }

    private k(v.d.C0634d.a.b bVar, w<v.b> wVar, Boolean bool, int i2) {
        this.f38492a = bVar;
        this.f38493b = wVar;
        this.f38494c = bool;
        this.f38495d = i2;
    }

    public final v.d.C0634d.a.b a() {
        return this.f38492a;
    }

    public final w<v.b> b() {
        return this.f38493b;
    }

    public final Boolean c() {
        return this.f38494c;
    }

    public final int d() {
        return this.f38495d;
    }

    public final String toString() {
        return "Application{execution=" + this.f38492a + ", customAttributes=" + this.f38493b + ", background=" + this.f38494c + ", uiOrientation=" + this.f38495d + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r4.f38494c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f38493b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.a.e.v.d.C0634d.a
            r2 = 0
            if (r1 == 0) goto L_0x004a
            com.google.firebase.crashlytics.a.e.v$d$d$a r5 = (com.google.firebase.crashlytics.a.e.v.d.C0634d.a) r5
            com.google.firebase.crashlytics.a.e.v$d$d$a$b r1 = r4.f38492a
            com.google.firebase.crashlytics.a.e.v$d$d$a$b r3 = r5.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004a
            com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v$b> r1 = r4.f38493b
            if (r1 != 0) goto L_0x0022
            com.google.firebase.crashlytics.a.e.w r1 = r5.b()
            if (r1 != 0) goto L_0x004a
            goto L_0x002c
        L_0x0022:
            com.google.firebase.crashlytics.a.e.w r3 = r5.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004a
        L_0x002c:
            java.lang.Boolean r1 = r4.f38494c
            if (r1 != 0) goto L_0x0037
            java.lang.Boolean r1 = r5.c()
            if (r1 != 0) goto L_0x004a
            goto L_0x0041
        L_0x0037:
            java.lang.Boolean r3 = r5.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004a
        L_0x0041:
            int r1 = r4.f38495d
            int r5 = r5.d()
            if (r1 != r5) goto L_0x004a
            return r0
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.f38492a.hashCode() ^ 1000003) * 1000003;
        w<v.b> wVar = this.f38493b;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        Boolean bool = this.f38494c;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return ((hashCode2 ^ i2) * 1000003) ^ this.f38495d;
    }

    public final v.d.C0634d.a.C0635a e() {
        return new a(this, (byte) 0);
    }

    static final class a extends v.d.C0634d.a.C0635a {

        /* renamed from: a  reason: collision with root package name */
        private v.d.C0634d.a.b f38496a;

        /* renamed from: b  reason: collision with root package name */
        private w<v.b> f38497b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f38498c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f38499d;

        /* synthetic */ a(v.d.C0634d.a aVar, byte b2) {
            this(aVar);
        }

        a() {
        }

        private a(v.d.C0634d.a aVar) {
            this.f38496a = aVar.a();
            this.f38497b = aVar.b();
            this.f38498c = aVar.c();
            this.f38499d = Integer.valueOf(aVar.d());
        }

        public final v.d.C0634d.a.C0635a a(v.d.C0634d.a.b bVar) {
            if (bVar != null) {
                this.f38496a = bVar;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public final v.d.C0634d.a.C0635a a(w<v.b> wVar) {
            this.f38497b = wVar;
            return this;
        }

        public final v.d.C0634d.a.C0635a a(Boolean bool) {
            this.f38498c = bool;
            return this;
        }

        public final v.d.C0634d.a.C0635a a(int i2) {
            this.f38499d = Integer.valueOf(i2);
            return this;
        }

        public final v.d.C0634d.a a() {
            String str = "";
            if (this.f38496a == null) {
                str = str + " execution";
            }
            if (this.f38499d == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new k(this.f38496a, this.f38497b, this.f38498c, this.f38499d.intValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
