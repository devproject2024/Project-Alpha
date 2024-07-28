package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class n extends v.d.C0634d.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f38516a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38517b;

    /* renamed from: c  reason: collision with root package name */
    private final w<v.d.C0634d.a.b.e.C0643b> f38518c;

    /* renamed from: d  reason: collision with root package name */
    private final v.d.C0634d.a.b.c f38519d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38520e;

    /* synthetic */ n(String str, String str2, w wVar, v.d.C0634d.a.b.c cVar, int i2, byte b2) {
        this(str, str2, wVar, cVar, i2);
    }

    private n(String str, String str2, w<v.d.C0634d.a.b.e.C0643b> wVar, v.d.C0634d.a.b.c cVar, int i2) {
        this.f38516a = str;
        this.f38517b = str2;
        this.f38518c = wVar;
        this.f38519d = cVar;
        this.f38520e = i2;
    }

    public final String a() {
        return this.f38516a;
    }

    public final String b() {
        return this.f38517b;
    }

    public final w<v.d.C0634d.a.b.e.C0643b> c() {
        return this.f38518c;
    }

    public final v.d.C0634d.a.b.c d() {
        return this.f38519d;
    }

    public final int e() {
        return this.f38520e;
    }

    public final String toString() {
        return "Exception{type=" + this.f38516a + ", reason=" + this.f38517b + ", frames=" + this.f38518c + ", causedBy=" + this.f38519d + ", overflowCount=" + this.f38520e + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = r4.f38519d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f38517b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.c
            r2 = 0
            if (r1 == 0) goto L_0x0056
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$c r5 = (com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.c) r5
            java.lang.String r1 = r4.f38516a
            java.lang.String r3 = r5.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = r4.f38517b
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = r5.b()
            if (r1 != 0) goto L_0x0056
            goto L_0x002c
        L_0x0022:
            java.lang.String r3 = r5.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x002c:
            com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v$d$d$a$b$e$b> r1 = r4.f38518c
            com.google.firebase.crashlytics.a.e.w r3 = r5.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$c r1 = r4.f38519d
            if (r1 != 0) goto L_0x0043
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$c r1 = r5.d()
            if (r1 != 0) goto L_0x0056
            goto L_0x004d
        L_0x0043:
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$c r3 = r5.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x004d:
            int r1 = r4.f38520e
            int r5 = r5.e()
            if (r1 != r5) goto L_0x0056
            return r0
        L_0x0056:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.n.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.f38516a.hashCode() ^ 1000003) * 1000003;
        String str = this.f38517b;
        int i2 = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f38518c.hashCode()) * 1000003;
        v.d.C0634d.a.b.c cVar = this.f38519d;
        if (cVar != null) {
            i2 = cVar.hashCode();
        }
        return ((hashCode2 ^ i2) * 1000003) ^ this.f38520e;
    }

    static final class a extends v.d.C0634d.a.b.c.C0639a {

        /* renamed from: a  reason: collision with root package name */
        private String f38521a;

        /* renamed from: b  reason: collision with root package name */
        private String f38522b;

        /* renamed from: c  reason: collision with root package name */
        private w<v.d.C0634d.a.b.e.C0643b> f38523c;

        /* renamed from: d  reason: collision with root package name */
        private v.d.C0634d.a.b.c f38524d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f38525e;

        a() {
        }

        public final v.d.C0634d.a.b.c.C0639a a(String str) {
            if (str != null) {
                this.f38521a = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        public final v.d.C0634d.a.b.c.C0639a b(String str) {
            this.f38522b = str;
            return this;
        }

        public final v.d.C0634d.a.b.c.C0639a a(w<v.d.C0634d.a.b.e.C0643b> wVar) {
            if (wVar != null) {
                this.f38523c = wVar;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public final v.d.C0634d.a.b.c.C0639a a(v.d.C0634d.a.b.c cVar) {
            this.f38524d = cVar;
            return this;
        }

        public final v.d.C0634d.a.b.c.C0639a a(int i2) {
            this.f38525e = Integer.valueOf(i2);
            return this;
        }

        public final v.d.C0634d.a.b.c a() {
            String str = "";
            if (this.f38521a == null) {
                str = str + " type";
            }
            if (this.f38523c == null) {
                str = str + " frames";
            }
            if (this.f38525e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new n(this.f38521a, this.f38522b, this.f38523c, this.f38524d, this.f38525e.intValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
