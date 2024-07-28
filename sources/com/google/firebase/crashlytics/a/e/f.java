package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class f extends v.d {

    /* renamed from: a  reason: collision with root package name */
    private final String f38435a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38436b;

    /* renamed from: c  reason: collision with root package name */
    private final long f38437c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f38438d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f38439e;

    /* renamed from: f  reason: collision with root package name */
    private final v.d.a f38440f;

    /* renamed from: g  reason: collision with root package name */
    private final v.d.f f38441g;

    /* renamed from: h  reason: collision with root package name */
    private final v.d.e f38442h;

    /* renamed from: i  reason: collision with root package name */
    private final v.d.c f38443i;
    private final w<v.d.C0634d> j;
    private final int k;

    /* synthetic */ f(String str, String str2, long j2, Long l, boolean z, v.d.a aVar, v.d.f fVar, v.d.e eVar, v.d.c cVar, w wVar, int i2, byte b2) {
        this(str, str2, j2, l, z, aVar, fVar, eVar, cVar, wVar, i2);
    }

    private f(String str, String str2, long j2, Long l, boolean z, v.d.a aVar, v.d.f fVar, v.d.e eVar, v.d.c cVar, w<v.d.C0634d> wVar, int i2) {
        this.f38435a = str;
        this.f38436b = str2;
        this.f38437c = j2;
        this.f38438d = l;
        this.f38439e = z;
        this.f38440f = aVar;
        this.f38441g = fVar;
        this.f38442h = eVar;
        this.f38443i = cVar;
        this.j = wVar;
        this.k = i2;
    }

    public final String a() {
        return this.f38435a;
    }

    public final String b() {
        return this.f38436b;
    }

    public final long c() {
        return this.f38437c;
    }

    public final Long d() {
        return this.f38438d;
    }

    public final boolean e() {
        return this.f38439e;
    }

    public final v.d.a f() {
        return this.f38440f;
    }

    public final v.d.f g() {
        return this.f38441g;
    }

    public final v.d.e h() {
        return this.f38442h;
    }

    public final v.d.c i() {
        return this.f38443i;
    }

    public final w<v.d.C0634d> j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final String toString() {
        return "Session{generator=" + this.f38435a + ", identifier=" + this.f38436b + ", startedAt=" + this.f38437c + ", endedAt=" + this.f38438d + ", crashed=" + this.f38439e + ", app=" + this.f38440f + ", user=" + this.f38441g + ", os=" + this.f38442h + ", device=" + this.f38443i + ", events=" + this.j + ", generatorType=" + this.k + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r1 = r7.f38438d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r7.f38441g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        r1 = r7.f38442h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        r1 = r7.f38443i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r1 = r7.j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.a.e.v.d
            r2 = 0
            if (r1 == 0) goto L_0x00b3
            com.google.firebase.crashlytics.a.e.v$d r8 = (com.google.firebase.crashlytics.a.e.v.d) r8
            java.lang.String r1 = r7.f38435a
            java.lang.String r3 = r8.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            java.lang.String r1 = r7.f38436b
            java.lang.String r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            long r3 = r7.f38437c
            long r5 = r8.c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00b3
            java.lang.Long r1 = r7.f38438d
            if (r1 != 0) goto L_0x0038
            java.lang.Long r1 = r8.d()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0042
        L_0x0038:
            java.lang.Long r3 = r8.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0042:
            boolean r1 = r7.f38439e
            boolean r3 = r8.e()
            if (r1 != r3) goto L_0x00b3
            com.google.firebase.crashlytics.a.e.v$d$a r1 = r7.f38440f
            com.google.firebase.crashlytics.a.e.v$d$a r3 = r8.f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            com.google.firebase.crashlytics.a.e.v$d$f r1 = r7.f38441g
            if (r1 != 0) goto L_0x0061
            com.google.firebase.crashlytics.a.e.v$d$f r1 = r8.g()
            if (r1 != 0) goto L_0x00b3
            goto L_0x006b
        L_0x0061:
            com.google.firebase.crashlytics.a.e.v$d$f r3 = r8.g()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x006b:
            com.google.firebase.crashlytics.a.e.v$d$e r1 = r7.f38442h
            if (r1 != 0) goto L_0x0076
            com.google.firebase.crashlytics.a.e.v$d$e r1 = r8.h()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0080
        L_0x0076:
            com.google.firebase.crashlytics.a.e.v$d$e r3 = r8.h()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0080:
            com.google.firebase.crashlytics.a.e.v$d$c r1 = r7.f38443i
            if (r1 != 0) goto L_0x008b
            com.google.firebase.crashlytics.a.e.v$d$c r1 = r8.i()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0095
        L_0x008b:
            com.google.firebase.crashlytics.a.e.v$d$c r3 = r8.i()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0095:
            com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v$d$d> r1 = r7.j
            if (r1 != 0) goto L_0x00a0
            com.google.firebase.crashlytics.a.e.w r1 = r8.j()
            if (r1 != 0) goto L_0x00b3
            goto L_0x00aa
        L_0x00a0:
            com.google.firebase.crashlytics.a.e.w r3 = r8.j()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x00aa:
            int r1 = r7.k
            int r8 = r8.k()
            if (r1 != r8) goto L_0x00b3
            return r0
        L_0x00b3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long j2 = this.f38437c;
        int hashCode = (((((this.f38435a.hashCode() ^ 1000003) * 1000003) ^ this.f38436b.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        Long l = this.f38438d;
        int i2 = 0;
        int hashCode2 = (((((hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.f38439e ? 1231 : 1237)) * 1000003) ^ this.f38440f.hashCode()) * 1000003;
        v.d.f fVar = this.f38441g;
        int hashCode3 = (hashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        v.d.e eVar = this.f38442h;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        v.d.c cVar = this.f38443i;
        int hashCode5 = (hashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        w<v.d.C0634d> wVar = this.j;
        if (wVar != null) {
            i2 = wVar.hashCode();
        }
        return ((hashCode5 ^ i2) * 1000003) ^ this.k;
    }

    public final v.d.b l() {
        return new a(this, (byte) 0);
    }

    static final class a extends v.d.b {

        /* renamed from: a  reason: collision with root package name */
        private String f38444a;

        /* renamed from: b  reason: collision with root package name */
        private String f38445b;

        /* renamed from: c  reason: collision with root package name */
        private Long f38446c;

        /* renamed from: d  reason: collision with root package name */
        private Long f38447d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f38448e;

        /* renamed from: f  reason: collision with root package name */
        private v.d.a f38449f;

        /* renamed from: g  reason: collision with root package name */
        private v.d.f f38450g;

        /* renamed from: h  reason: collision with root package name */
        private v.d.e f38451h;

        /* renamed from: i  reason: collision with root package name */
        private v.d.c f38452i;
        private w<v.d.C0634d> j;
        private Integer k;

        /* synthetic */ a(v.d dVar, byte b2) {
            this(dVar);
        }

        a() {
        }

        private a(v.d dVar) {
            this.f38444a = dVar.a();
            this.f38445b = dVar.b();
            this.f38446c = Long.valueOf(dVar.c());
            this.f38447d = dVar.d();
            this.f38448e = Boolean.valueOf(dVar.e());
            this.f38449f = dVar.f();
            this.f38450g = dVar.g();
            this.f38451h = dVar.h();
            this.f38452i = dVar.i();
            this.j = dVar.j();
            this.k = Integer.valueOf(dVar.k());
        }

        public final v.d.b a(String str) {
            if (str != null) {
                this.f38444a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public final v.d.b b(String str) {
            if (str != null) {
                this.f38445b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public final v.d.b a(long j2) {
            this.f38446c = Long.valueOf(j2);
            return this;
        }

        public final v.d.b a(Long l) {
            this.f38447d = l;
            return this;
        }

        public final v.d.b a(boolean z) {
            this.f38448e = Boolean.valueOf(z);
            return this;
        }

        public final v.d.b a(v.d.a aVar) {
            if (aVar != null) {
                this.f38449f = aVar;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public final v.d.b a(v.d.f fVar) {
            this.f38450g = fVar;
            return this;
        }

        public final v.d.b a(v.d.e eVar) {
            this.f38451h = eVar;
            return this;
        }

        public final v.d.b a(v.d.c cVar) {
            this.f38452i = cVar;
            return this;
        }

        public final v.d.b a(w<v.d.C0634d> wVar) {
            this.j = wVar;
            return this;
        }

        public final v.d.b a(int i2) {
            this.k = Integer.valueOf(i2);
            return this;
        }

        public final v.d a() {
            String str = "";
            if (this.f38444a == null) {
                str = str + " generator";
            }
            if (this.f38445b == null) {
                str = str + " identifier";
            }
            if (this.f38446c == null) {
                str = str + " startedAt";
            }
            if (this.f38448e == null) {
                str = str + " crashed";
            }
            if (this.f38449f == null) {
                str = str + " app";
            }
            if (this.k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new f(this.f38444a, this.f38445b, this.f38446c.longValue(), this.f38447d, this.f38448e.booleanValue(), this.f38449f, this.f38450g, this.f38451h, this.f38452i, this.j, this.k.intValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
