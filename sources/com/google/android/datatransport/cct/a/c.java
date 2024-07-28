package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.a;

final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f7653a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7654b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7655c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7656d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7657e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7658f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7659g;

    /* renamed from: h  reason: collision with root package name */
    private final String f7660h;

    static final class a extends a.C0112a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f7661a;

        /* renamed from: b  reason: collision with root package name */
        private String f7662b;

        /* renamed from: c  reason: collision with root package name */
        private String f7663c;

        /* renamed from: d  reason: collision with root package name */
        private String f7664d;

        /* renamed from: e  reason: collision with root package name */
        private String f7665e;

        /* renamed from: f  reason: collision with root package name */
        private String f7666f;

        /* renamed from: g  reason: collision with root package name */
        private String f7667g;

        /* renamed from: h  reason: collision with root package name */
        private String f7668h;

        a() {
        }

        public final a.C0112a a(Integer num) {
            this.f7661a = num;
            return this;
        }

        public final a.C0112a a(String str) {
            this.f7662b = str;
            return this;
        }

        public final a.C0112a b(String str) {
            this.f7663c = str;
            return this;
        }

        public final a.C0112a d(String str) {
            this.f7665e = str;
            return this;
        }

        public final a.C0112a e(String str) {
            this.f7666f = str;
            return this;
        }

        public final a.C0112a f(String str) {
            this.f7667g = str;
            return this;
        }

        public final a.C0112a g(String str) {
            this.f7668h = str;
            return this;
        }

        public final a.C0112a c(String str) {
            this.f7664d = str;
            return this;
        }

        public final a a() {
            return new c(this.f7661a, this.f7662b, this.f7663c, this.f7664d, this.f7665e, this.f7666f, this.f7667g, this.f7668h);
        }
    }

    /* synthetic */ c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f7653a = num;
        this.f7654b = str;
        this.f7655c = str2;
        this.f7656d = str3;
        this.f7657e = str4;
        this.f7658f = str5;
        this.f7659g = str6;
        this.f7660h = str7;
    }

    public final Integer b() {
        return this.f7653a;
    }

    public final String c() {
        return this.f7654b;
    }

    public final String d() {
        return this.f7655c;
    }

    public final String e() {
        return this.f7656d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r1 = r4.f7654b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r1 = r4.f7655c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r1 = r4.f7656d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        r1 = r4.f7657e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
        r1 = r4.f7658f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0093, code lost:
        r1 = r4.f7659g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
        r1 = r4.f7660h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r1 = r4.f7653a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.datatransport.cct.a.a
            r2 = 0
            if (r1 == 0) goto L_0x00c0
            java.lang.Integer r1 = r4.f7653a
            if (r1 != 0) goto L_0x0015
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.Integer r1 = r1.f7653a
            if (r1 != 0) goto L_0x00c0
            goto L_0x0020
        L_0x0015:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.Integer r3 = r3.f7653a
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x0020:
            java.lang.String r1 = r4.f7654b
            if (r1 != 0) goto L_0x002c
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.String r1 = r1.f7654b
            if (r1 != 0) goto L_0x00c0
            goto L_0x0037
        L_0x002c:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.String r3 = r3.f7654b
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x0037:
            java.lang.String r1 = r4.f7655c
            if (r1 != 0) goto L_0x0043
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.String r1 = r1.f7655c
            if (r1 != 0) goto L_0x00c0
            goto L_0x004e
        L_0x0043:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.String r3 = r3.f7655c
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x004e:
            java.lang.String r1 = r4.f7656d
            if (r1 != 0) goto L_0x005a
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.String r1 = r1.f7656d
            if (r1 != 0) goto L_0x00c0
            goto L_0x0065
        L_0x005a:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.String r3 = r3.f7656d
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x0065:
            java.lang.String r1 = r4.f7657e
            if (r1 != 0) goto L_0x0071
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.String r1 = r1.f7657e
            if (r1 != 0) goto L_0x00c0
            goto L_0x007c
        L_0x0071:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.String r3 = r3.f7657e
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x007c:
            java.lang.String r1 = r4.f7658f
            if (r1 != 0) goto L_0x0088
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.String r1 = r1.f7658f
            if (r1 != 0) goto L_0x00c0
            goto L_0x0093
        L_0x0088:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.String r3 = r3.f7658f
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x0093:
            java.lang.String r1 = r4.f7659g
            if (r1 != 0) goto L_0x009f
            r1 = r5
            com.google.android.datatransport.cct.a.c r1 = (com.google.android.datatransport.cct.a.c) r1
            java.lang.String r1 = r1.f7659g
            if (r1 != 0) goto L_0x00c0
            goto L_0x00aa
        L_0x009f:
            r3 = r5
            com.google.android.datatransport.cct.a.c r3 = (com.google.android.datatransport.cct.a.c) r3
            java.lang.String r3 = r3.f7659g
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c0
        L_0x00aa:
            java.lang.String r1 = r4.f7660h
            if (r1 != 0) goto L_0x00b5
            com.google.android.datatransport.cct.a.c r5 = (com.google.android.datatransport.cct.a.c) r5
            java.lang.String r5 = r5.f7660h
            if (r5 != 0) goto L_0x00c0
            goto L_0x00bf
        L_0x00b5:
            com.google.android.datatransport.cct.a.c r5 = (com.google.android.datatransport.cct.a.c) r5
            java.lang.String r5 = r5.f7660h
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00c0
        L_0x00bf:
            return r0
        L_0x00c0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.a.c.equals(java.lang.Object):boolean");
    }

    public final String f() {
        return this.f7657e;
    }

    public final String g() {
        return this.f7658f;
    }

    public final String h() {
        return this.f7659g;
    }

    public final int hashCode() {
        Integer num = this.f7653a;
        int i2 = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f7654b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f7655c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f7656d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f7657e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f7658f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f7659g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f7660h;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode7 ^ i2;
    }

    public final String i() {
        return this.f7660h;
    }

    public final String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f7653a + ", model=" + this.f7654b + ", hardware=" + this.f7655c + ", device=" + this.f7656d + ", product=" + this.f7657e + ", osBuild=" + this.f7658f + ", manufacturer=" + this.f7659g + ", fingerprint=" + this.f7660h + "}";
    }
}
