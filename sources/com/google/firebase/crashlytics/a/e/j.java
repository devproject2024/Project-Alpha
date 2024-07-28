package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class j extends v.d.C0634d {

    /* renamed from: a  reason: collision with root package name */
    private final long f38482a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38483b;

    /* renamed from: c  reason: collision with root package name */
    private final v.d.C0634d.a f38484c;

    /* renamed from: d  reason: collision with root package name */
    private final v.d.C0634d.c f38485d;

    /* renamed from: e  reason: collision with root package name */
    private final v.d.C0634d.C0645d f38486e;

    /* synthetic */ j(long j, String str, v.d.C0634d.a aVar, v.d.C0634d.c cVar, v.d.C0634d.C0645d dVar, byte b2) {
        this(j, str, aVar, cVar, dVar);
    }

    private j(long j, String str, v.d.C0634d.a aVar, v.d.C0634d.c cVar, v.d.C0634d.C0645d dVar) {
        this.f38482a = j;
        this.f38483b = str;
        this.f38484c = aVar;
        this.f38485d = cVar;
        this.f38486e = dVar;
    }

    public final long a() {
        return this.f38482a;
    }

    public final String b() {
        return this.f38483b;
    }

    public final v.d.C0634d.a c() {
        return this.f38484c;
    }

    public final v.d.C0634d.c d() {
        return this.f38485d;
    }

    public final v.d.C0634d.C0645d e() {
        return this.f38486e;
    }

    public final String toString() {
        return "Event{timestamp=" + this.f38482a + ", type=" + this.f38483b + ", app=" + this.f38484c + ", device=" + this.f38485d + ", log=" + this.f38486e + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r1 = r7.f38486e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.a.e.v.d.C0634d
            r2 = 0
            if (r1 == 0) goto L_0x004f
            com.google.firebase.crashlytics.a.e.v$d$d r8 = (com.google.firebase.crashlytics.a.e.v.d.C0634d) r8
            long r3 = r7.f38482a
            long r5 = r8.a()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x004f
            java.lang.String r1 = r7.f38483b
            java.lang.String r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004f
            com.google.firebase.crashlytics.a.e.v$d$d$a r1 = r7.f38484c
            com.google.firebase.crashlytics.a.e.v$d$d$a r3 = r8.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004f
            com.google.firebase.crashlytics.a.e.v$d$d$c r1 = r7.f38485d
            com.google.firebase.crashlytics.a.e.v$d$d$c r3 = r8.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004f
            com.google.firebase.crashlytics.a.e.v$d$d$d r1 = r7.f38486e
            if (r1 != 0) goto L_0x0044
            com.google.firebase.crashlytics.a.e.v$d$d$d r8 = r8.e()
            if (r8 != 0) goto L_0x004f
            goto L_0x004e
        L_0x0044:
            com.google.firebase.crashlytics.a.e.v$d$d$d r8 = r8.e()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x004f
        L_0x004e:
            return r0
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.j.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long j = this.f38482a;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f38483b.hashCode()) * 1000003) ^ this.f38484c.hashCode()) * 1000003) ^ this.f38485d.hashCode()) * 1000003;
        v.d.C0634d.C0645d dVar = this.f38486e;
        return (dVar == null ? 0 : dVar.hashCode()) ^ hashCode;
    }

    public final v.d.C0634d.b f() {
        return new a(this, (byte) 0);
    }

    static final class a extends v.d.C0634d.b {

        /* renamed from: a  reason: collision with root package name */
        private Long f38487a;

        /* renamed from: b  reason: collision with root package name */
        private String f38488b;

        /* renamed from: c  reason: collision with root package name */
        private v.d.C0634d.a f38489c;

        /* renamed from: d  reason: collision with root package name */
        private v.d.C0634d.c f38490d;

        /* renamed from: e  reason: collision with root package name */
        private v.d.C0634d.C0645d f38491e;

        /* synthetic */ a(v.d.C0634d dVar, byte b2) {
            this(dVar);
        }

        a() {
        }

        private a(v.d.C0634d dVar) {
            this.f38487a = Long.valueOf(dVar.a());
            this.f38488b = dVar.b();
            this.f38489c = dVar.c();
            this.f38490d = dVar.d();
            this.f38491e = dVar.e();
        }

        public final v.d.C0634d.b a(long j) {
            this.f38487a = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.b a(String str) {
            if (str != null) {
                this.f38488b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        public final v.d.C0634d.b a(v.d.C0634d.a aVar) {
            if (aVar != null) {
                this.f38489c = aVar;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public final v.d.C0634d.b a(v.d.C0634d.c cVar) {
            if (cVar != null) {
                this.f38490d = cVar;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public final v.d.C0634d.b a(v.d.C0634d.C0645d dVar) {
            this.f38491e = dVar;
            return this;
        }

        public final v.d.C0634d a() {
            String str = "";
            if (this.f38487a == null) {
                str = str + " timestamp";
            }
            if (this.f38488b == null) {
                str = str + " type";
            }
            if (this.f38489c == null) {
                str = str + " app";
            }
            if (this.f38490d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new j(this.f38487a.longValue(), this.f38488b, this.f38489c, this.f38490d, this.f38491e, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
