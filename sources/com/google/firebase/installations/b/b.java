package com.google.firebase.installations.b;

import com.google.firebase.installations.b.e;

final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private final String f38951a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38952b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b f38953c;

    /* synthetic */ b(String str, long j, e.b bVar, byte b2) {
        this(str, j, bVar);
    }

    private b(String str, long j, e.b bVar) {
        this.f38951a = str;
        this.f38952b = j;
        this.f38953c = bVar;
    }

    public final String a() {
        return this.f38951a;
    }

    public final long b() {
        return this.f38952b;
    }

    public final e.b c() {
        return this.f38953c;
    }

    public final String toString() {
        return "TokenResult{token=" + this.f38951a + ", tokenExpirationTimestamp=" + this.f38952b + ", responseCode=" + this.f38953c + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r1 = r7.f38953c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.installations.b.e
            r2 = 0
            if (r1 == 0) goto L_0x0040
            com.google.firebase.installations.b.e r8 = (com.google.firebase.installations.b.e) r8
            java.lang.String r1 = r7.f38951a
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = r8.a()
            if (r1 != 0) goto L_0x0040
            goto L_0x0020
        L_0x0016:
            java.lang.String r3 = r8.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0040
        L_0x0020:
            long r3 = r7.f38952b
            long r5 = r8.b()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0040
            com.google.firebase.installations.b.e$b r1 = r7.f38953c
            if (r1 != 0) goto L_0x0035
            com.google.firebase.installations.b.e$b r8 = r8.c()
            if (r8 != 0) goto L_0x0040
            goto L_0x003f
        L_0x0035:
            com.google.firebase.installations.b.e$b r8 = r8.c()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0040
        L_0x003f:
            return r0
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.b.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        String str = this.f38951a;
        int i2 = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f38952b;
        int i3 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        e.b bVar = this.f38953c;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return i3 ^ i2;
    }

    static final class a extends e.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38954a;

        /* renamed from: b  reason: collision with root package name */
        private Long f38955b;

        /* renamed from: c  reason: collision with root package name */
        private e.b f38956c;

        a() {
        }

        public final e.a a(String str) {
            this.f38954a = str;
            return this;
        }

        public final e.a a(long j) {
            this.f38955b = Long.valueOf(j);
            return this;
        }

        public final e.a a(e.b bVar) {
            this.f38956c = bVar;
            return this;
        }

        public final e a() {
            String str = "";
            if (this.f38955b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f38954a, this.f38955b.longValue(), this.f38956c, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
