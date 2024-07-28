package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class d extends v.c {

    /* renamed from: a  reason: collision with root package name */
    private final w<v.c.b> f38427a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38428b;

    /* synthetic */ d(w wVar, String str, byte b2) {
        this(wVar, str);
    }

    private d(w<v.c.b> wVar, String str) {
        this.f38427a = wVar;
        this.f38428b = str;
    }

    public final w<v.c.b> a() {
        return this.f38427a;
    }

    public final String b() {
        return this.f38428b;
    }

    public final String toString() {
        return "FilesPayload{files=" + this.f38427a + ", orgId=" + this.f38428b + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f38428b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.a.e.v.c
            r2 = 0
            if (r1 == 0) goto L_0x002d
            com.google.firebase.crashlytics.a.e.v$c r5 = (com.google.firebase.crashlytics.a.e.v.c) r5
            com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v$c$b> r1 = r4.f38427a
            com.google.firebase.crashlytics.a.e.w r3 = r5.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r4.f38428b
            if (r1 != 0) goto L_0x0022
            java.lang.String r5 = r5.b()
            if (r5 != 0) goto L_0x002d
            goto L_0x002c
        L_0x0022:
            java.lang.String r5 = r5.b()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.f38427a.hashCode() ^ 1000003) * 1000003;
        String str = this.f38428b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class a extends v.c.a {

        /* renamed from: a  reason: collision with root package name */
        private w<v.c.b> f38429a;

        /* renamed from: b  reason: collision with root package name */
        private String f38430b;

        a() {
        }

        public final v.c.a a(w<v.c.b> wVar) {
            if (wVar != null) {
                this.f38429a = wVar;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public final v.c.a a(String str) {
            this.f38430b = str;
            return this;
        }

        public final v.c a() {
            String str = "";
            if (this.f38429a == null) {
                str = str + " files";
            }
            if (str.isEmpty()) {
                return new d(this.f38429a, this.f38430b, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
