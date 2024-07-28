package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class q extends v.d.C0634d.a.b.e.C0643b {

    /* renamed from: a  reason: collision with root package name */
    private final long f38538a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38539b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38540c;

    /* renamed from: d  reason: collision with root package name */
    private final long f38541d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38542e;

    /* synthetic */ q(long j, String str, String str2, long j2, int i2, byte b2) {
        this(j, str, str2, j2, i2);
    }

    private q(long j, String str, String str2, long j2, int i2) {
        this.f38538a = j;
        this.f38539b = str;
        this.f38540c = str2;
        this.f38541d = j2;
        this.f38542e = i2;
    }

    public final long a() {
        return this.f38538a;
    }

    public final String b() {
        return this.f38539b;
    }

    public final String c() {
        return this.f38540c;
    }

    public final long d() {
        return this.f38541d;
    }

    public final int e() {
        return this.f38542e;
    }

    public final String toString() {
        return "Frame{pc=" + this.f38538a + ", symbol=" + this.f38539b + ", file=" + this.f38540c + ", offset=" + this.f38541d + ", importance=" + this.f38542e + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = r7.f38540c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.e.C0643b
            r2 = 0
            if (r1 == 0) goto L_0x0049
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$e$b r8 = (com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.e.C0643b) r8
            long r3 = r7.f38538a
            long r5 = r8.a()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0049
            java.lang.String r1 = r7.f38539b
            java.lang.String r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = r7.f38540c
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = r8.c()
            if (r1 != 0) goto L_0x0049
            goto L_0x0036
        L_0x002c:
            java.lang.String r3 = r8.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0049
        L_0x0036:
            long r3 = r7.f38541d
            long r5 = r8.d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0049
            int r1 = r7.f38542e
            int r8 = r8.e()
            if (r1 != r8) goto L_0x0049
            return r0
        L_0x0049:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long j = this.f38538a;
        int hashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f38539b.hashCode()) * 1000003;
        String str = this.f38540c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j2 = this.f38541d;
        return this.f38542e ^ ((((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    static final class a extends v.d.C0634d.a.b.e.C0643b.C0644a {

        /* renamed from: a  reason: collision with root package name */
        private Long f38543a;

        /* renamed from: b  reason: collision with root package name */
        private String f38544b;

        /* renamed from: c  reason: collision with root package name */
        private String f38545c;

        /* renamed from: d  reason: collision with root package name */
        private Long f38546d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f38547e;

        a() {
        }

        public final v.d.C0634d.a.b.e.C0643b.C0644a a(long j) {
            this.f38543a = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.a.b.e.C0643b.C0644a a(String str) {
            if (str != null) {
                this.f38544b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }

        public final v.d.C0634d.a.b.e.C0643b.C0644a b(String str) {
            this.f38545c = str;
            return this;
        }

        public final v.d.C0634d.a.b.e.C0643b.C0644a b(long j) {
            this.f38546d = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.a.b.e.C0643b.C0644a a(int i2) {
            this.f38547e = Integer.valueOf(i2);
            return this;
        }

        public final v.d.C0634d.a.b.e.C0643b a() {
            String str = "";
            if (this.f38543a == null) {
                str = str + " pc";
            }
            if (this.f38544b == null) {
                str = str + " symbol";
            }
            if (this.f38546d == null) {
                str = str + " offset";
            }
            if (this.f38547e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new q(this.f38543a.longValue(), this.f38544b, this.f38545c, this.f38546d.longValue(), this.f38547e.intValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
