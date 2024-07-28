package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class m extends v.d.C0634d.a.b.C0636a {

    /* renamed from: a  reason: collision with root package name */
    private final long f38508a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38509b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38510c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38511d;

    /* synthetic */ m(long j, long j2, String str, String str2, byte b2) {
        this(j, j2, str, str2);
    }

    private m(long j, long j2, String str, String str2) {
        this.f38508a = j;
        this.f38509b = j2;
        this.f38510c = str;
        this.f38511d = str2;
    }

    public final long a() {
        return this.f38508a;
    }

    public final long b() {
        return this.f38509b;
    }

    public final String c() {
        return this.f38510c;
    }

    public final String d() {
        return this.f38511d;
    }

    public final String toString() {
        return "BinaryImage{baseAddress=" + this.f38508a + ", size=" + this.f38509b + ", name=" + this.f38510c + ", uuid=" + this.f38511d + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        r1 = r7.f38511d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.C0636a
            r2 = 0
            if (r1 == 0) goto L_0x0041
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$a r8 = (com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.C0636a) r8
            long r3 = r7.f38508a
            long r5 = r8.a()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0041
            long r3 = r7.f38509b
            long r5 = r8.b()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = r7.f38510c
            java.lang.String r3 = r8.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r7.f38511d
            if (r1 != 0) goto L_0x0036
            java.lang.String r8 = r8.d()
            if (r8 != 0) goto L_0x0041
            goto L_0x0040
        L_0x0036:
            java.lang.String r8 = r8.d()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0041
        L_0x0040:
            return r0
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.m.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long j = this.f38508a;
        long j2 = this.f38509b;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f38510c.hashCode()) * 1000003;
        String str = this.f38511d;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    static final class a extends v.d.C0634d.a.b.C0636a.C0637a {

        /* renamed from: a  reason: collision with root package name */
        private Long f38512a;

        /* renamed from: b  reason: collision with root package name */
        private Long f38513b;

        /* renamed from: c  reason: collision with root package name */
        private String f38514c;

        /* renamed from: d  reason: collision with root package name */
        private String f38515d;

        a() {
        }

        public final v.d.C0634d.a.b.C0636a.C0637a a(long j) {
            this.f38512a = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.a.b.C0636a.C0637a b(long j) {
            this.f38513b = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.a.b.C0636a.C0637a a(String str) {
            if (str != null) {
                this.f38514c = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public final v.d.C0634d.a.b.C0636a.C0637a b(String str) {
            this.f38515d = str;
            return this;
        }

        public final v.d.C0634d.a.b.C0636a a() {
            String str = "";
            if (this.f38512a == null) {
                str = str + " baseAddress";
            }
            if (this.f38513b == null) {
                str = str + " size";
            }
            if (this.f38514c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new m(this.f38512a.longValue(), this.f38513b.longValue(), this.f38514c, this.f38515d, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
