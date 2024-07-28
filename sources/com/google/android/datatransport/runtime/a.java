package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.h;
import java.util.Map;

final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private final String f7721a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f7722b;

    /* renamed from: c  reason: collision with root package name */
    private final g f7723c;

    /* renamed from: d  reason: collision with root package name */
    private final long f7724d;

    /* renamed from: e  reason: collision with root package name */
    private final long f7725e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f7726f;

    /* synthetic */ a(String str, Integer num, g gVar, long j, long j2, Map map, byte b2) {
        this(str, num, gVar, j, j2, map);
    }

    private a(String str, Integer num, g gVar, long j, long j2, Map<String, String> map) {
        this.f7721a = str;
        this.f7722b = num;
        this.f7723c = gVar;
        this.f7724d = j;
        this.f7725e = j2;
        this.f7726f = map;
    }

    public final String a() {
        return this.f7721a;
    }

    public final Integer b() {
        return this.f7722b;
    }

    public final g c() {
        return this.f7723c;
    }

    public final long d() {
        return this.f7724d;
    }

    public final long e() {
        return this.f7725e;
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> f() {
        return this.f7726f;
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f7721a + ", code=" + this.f7722b + ", encodedPayload=" + this.f7723c + ", eventMillis=" + this.f7724d + ", uptimeMillis=" + this.f7725e + ", autoMetadata=" + this.f7726f + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r7.f7722b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.datatransport.runtime.h
            r2 = 0
            if (r1 == 0) goto L_0x0059
            com.google.android.datatransport.runtime.h r8 = (com.google.android.datatransport.runtime.h) r8
            java.lang.String r1 = r7.f7721a
            java.lang.String r3 = r8.a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
            java.lang.Integer r1 = r7.f7722b
            if (r1 != 0) goto L_0x0022
            java.lang.Integer r1 = r8.b()
            if (r1 != 0) goto L_0x0059
            goto L_0x002c
        L_0x0022:
            java.lang.Integer r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
        L_0x002c:
            com.google.android.datatransport.runtime.g r1 = r7.f7723c
            com.google.android.datatransport.runtime.g r3 = r8.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
            long r3 = r7.f7724d
            long r5 = r8.d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0059
            long r3 = r7.f7725e
            long r5 = r8.e()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0059
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.f7726f
            java.util.Map r8 = r8.f()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0059
            return r0
        L_0x0059:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.f7721a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f7722b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.f7724d;
        long j2 = this.f7725e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f7723c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f7726f.hashCode();
    }

    /* renamed from: com.google.android.datatransport.runtime.a$a  reason: collision with other inner class name */
    static final class C0114a extends h.a {

        /* renamed from: a  reason: collision with root package name */
        Map<String, String> f7727a;

        /* renamed from: b  reason: collision with root package name */
        private String f7728b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f7729c;

        /* renamed from: d  reason: collision with root package name */
        private g f7730d;

        /* renamed from: e  reason: collision with root package name */
        private Long f7731e;

        /* renamed from: f  reason: collision with root package name */
        private Long f7732f;

        C0114a() {
        }

        public final h.a a(String str) {
            if (str != null) {
                this.f7728b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public final h.a a(Integer num) {
            this.f7729c = num;
            return this;
        }

        public final h.a a(g gVar) {
            if (gVar != null) {
                this.f7730d = gVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public final h.a a(long j) {
            this.f7731e = Long.valueOf(j);
            return this;
        }

        public final h.a b(long j) {
            this.f7732f = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: protected */
        public final h.a a(Map<String, String> map) {
            this.f7727a = map;
            return this;
        }

        /* access modifiers changed from: protected */
        public final Map<String, String> a() {
            Map<String, String> map = this.f7727a;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public final h b() {
            String str = "";
            if (this.f7728b == null) {
                str = str + " transportName";
            }
            if (this.f7730d == null) {
                str = str + " encodedPayload";
            }
            if (this.f7731e == null) {
                str = str + " eventMillis";
            }
            if (this.f7732f == null) {
                str = str + " uptimeMillis";
            }
            if (this.f7727a == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.f7728b, this.f7729c, this.f7730d, this.f7731e.longValue(), this.f7732f.longValue(), this.f7727a, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
