package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.m;
import java.util.List;

final class g extends m {

    /* renamed from: a  reason: collision with root package name */
    private final long f7688a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7689b;

    /* renamed from: c  reason: collision with root package name */
    private final k f7690c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f7691d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7692e;

    /* renamed from: f  reason: collision with root package name */
    private final List<l> f7693f;

    /* renamed from: g  reason: collision with root package name */
    private final p f7694g;

    static final class a extends m.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f7695a;

        /* renamed from: b  reason: collision with root package name */
        private Long f7696b;

        /* renamed from: c  reason: collision with root package name */
        private k f7697c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f7698d;

        /* renamed from: e  reason: collision with root package name */
        private String f7699e;

        /* renamed from: f  reason: collision with root package name */
        private List<l> f7700f;

        /* renamed from: g  reason: collision with root package name */
        private p f7701g;

        a() {
        }

        public final m.a a(long j) {
            this.f7695a = Long.valueOf(j);
            return this;
        }

        public final m.a b(long j) {
            this.f7696b = Long.valueOf(j);
            return this;
        }

        public final m.a a(k kVar) {
            this.f7697c = kVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final m.a a(Integer num) {
            this.f7698d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final m.a a(String str) {
            this.f7699e = str;
            return this;
        }

        public final m.a a(List<l> list) {
            this.f7700f = list;
            return this;
        }

        public final m.a a(p pVar) {
            this.f7701g = pVar;
            return this;
        }

        public final m a() {
            String str = "";
            if (this.f7695a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f7696b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f7695a.longValue(), this.f7696b.longValue(), this.f7697c, this.f7698d, this.f7699e, this.f7700f, this.f7701g);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }

    /* synthetic */ g(long j, long j2, k kVar, Integer num, String str, List list, p pVar) {
        this.f7688a = j;
        this.f7689b = j2;
        this.f7690c = kVar;
        this.f7691d = num;
        this.f7692e = str;
        this.f7693f = list;
        this.f7694g = pVar;
    }

    public final long a() {
        return this.f7688a;
    }

    public final long b() {
        return this.f7689b;
    }

    public final k c() {
        return this.f7690c;
    }

    public final Integer d() {
        return this.f7691d;
    }

    public final String e() {
        return this.f7692e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r1 = r7.f7691d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r1 = r7.f7692e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        r1 = r7.f7693f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
        r1 = r7.f7694g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r1 = r7.f7690c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.datatransport.cct.a.m
            r2 = 0
            if (r1 == 0) goto L_0x0091
            com.google.android.datatransport.cct.a.m r8 = (com.google.android.datatransport.cct.a.m) r8
            long r3 = r7.f7688a
            long r5 = r8.a()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0091
            long r3 = r7.f7689b
            long r5 = r8.b()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0091
            com.google.android.datatransport.cct.a.k r1 = r7.f7690c
            if (r1 != 0) goto L_0x002b
            r1 = r8
            com.google.android.datatransport.cct.a.g r1 = (com.google.android.datatransport.cct.a.g) r1
            com.google.android.datatransport.cct.a.k r1 = r1.f7690c
            if (r1 != 0) goto L_0x0091
            goto L_0x0036
        L_0x002b:
            r3 = r8
            com.google.android.datatransport.cct.a.g r3 = (com.google.android.datatransport.cct.a.g) r3
            com.google.android.datatransport.cct.a.k r3 = r3.f7690c
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0091
        L_0x0036:
            java.lang.Integer r1 = r7.f7691d
            if (r1 != 0) goto L_0x0042
            r1 = r8
            com.google.android.datatransport.cct.a.g r1 = (com.google.android.datatransport.cct.a.g) r1
            java.lang.Integer r1 = r1.f7691d
            if (r1 != 0) goto L_0x0091
            goto L_0x004d
        L_0x0042:
            r3 = r8
            com.google.android.datatransport.cct.a.g r3 = (com.google.android.datatransport.cct.a.g) r3
            java.lang.Integer r3 = r3.f7691d
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0091
        L_0x004d:
            java.lang.String r1 = r7.f7692e
            if (r1 != 0) goto L_0x0059
            r1 = r8
            com.google.android.datatransport.cct.a.g r1 = (com.google.android.datatransport.cct.a.g) r1
            java.lang.String r1 = r1.f7692e
            if (r1 != 0) goto L_0x0091
            goto L_0x0064
        L_0x0059:
            r3 = r8
            com.google.android.datatransport.cct.a.g r3 = (com.google.android.datatransport.cct.a.g) r3
            java.lang.String r3 = r3.f7692e
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0091
        L_0x0064:
            java.util.List<com.google.android.datatransport.cct.a.l> r1 = r7.f7693f
            if (r1 != 0) goto L_0x0070
            r1 = r8
            com.google.android.datatransport.cct.a.g r1 = (com.google.android.datatransport.cct.a.g) r1
            java.util.List<com.google.android.datatransport.cct.a.l> r1 = r1.f7693f
            if (r1 != 0) goto L_0x0091
            goto L_0x007b
        L_0x0070:
            r3 = r8
            com.google.android.datatransport.cct.a.g r3 = (com.google.android.datatransport.cct.a.g) r3
            java.util.List<com.google.android.datatransport.cct.a.l> r3 = r3.f7693f
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0091
        L_0x007b:
            com.google.android.datatransport.cct.a.p r1 = r7.f7694g
            if (r1 != 0) goto L_0x0086
            com.google.android.datatransport.cct.a.g r8 = (com.google.android.datatransport.cct.a.g) r8
            com.google.android.datatransport.cct.a.p r8 = r8.f7694g
            if (r8 != 0) goto L_0x0091
            goto L_0x0090
        L_0x0086:
            com.google.android.datatransport.cct.a.g r8 = (com.google.android.datatransport.cct.a.g) r8
            com.google.android.datatransport.cct.a.p r8 = r8.f7694g
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0091
        L_0x0090:
            return r0
        L_0x0091:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.a.g.equals(java.lang.Object):boolean");
    }

    public final List<l> f() {
        return this.f7693f;
    }

    public final p g() {
        return this.f7694g;
    }

    public final int hashCode() {
        long j = this.f7688a;
        long j2 = this.f7689b;
        int i2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        k kVar = this.f7690c;
        int i3 = 0;
        int hashCode = (i2 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f7691d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f7692e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f7693f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f7694g;
        if (pVar != null) {
            i3 = pVar.hashCode();
        }
        return hashCode4 ^ i3;
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f7688a + ", requestUptimeMs=" + this.f7689b + ", clientInfo=" + this.f7690c + ", logSource=" + this.f7691d + ", logSourceName=" + this.f7692e + ", logEvents=" + this.f7693f + ", qosTier=" + this.f7694g + "}";
    }
}
