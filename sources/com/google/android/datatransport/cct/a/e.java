package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.k;

final class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final k.b f7670a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7671b;

    static final class a extends k.a {

        /* renamed from: a  reason: collision with root package name */
        private k.b f7672a;

        /* renamed from: b  reason: collision with root package name */
        private a f7673b;

        a() {
        }

        public final k.a a(k.b bVar) {
            this.f7672a = bVar;
            return this;
        }

        public final k.a a(a aVar) {
            this.f7673b = aVar;
            return this;
        }

        public final k a() {
            return new e(this.f7672a, this.f7673b);
        }
    }

    /* synthetic */ e(k.b bVar, a aVar) {
        this.f7670a = bVar;
        this.f7671b = aVar;
    }

    public final k.b a() {
        return this.f7670a;
    }

    public final a b() {
        return this.f7671b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r1 = r4.f7671b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r1 = r4.f7670a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.datatransport.cct.a.k
            r2 = 0
            if (r1 == 0) goto L_0x0036
            com.google.android.datatransport.cct.a.k$b r1 = r4.f7670a
            if (r1 != 0) goto L_0x0015
            r1 = r5
            com.google.android.datatransport.cct.a.e r1 = (com.google.android.datatransport.cct.a.e) r1
            com.google.android.datatransport.cct.a.k$b r1 = r1.f7670a
            if (r1 != 0) goto L_0x0036
            goto L_0x0020
        L_0x0015:
            r3 = r5
            com.google.android.datatransport.cct.a.e r3 = (com.google.android.datatransport.cct.a.e) r3
            com.google.android.datatransport.cct.a.k$b r3 = r3.f7670a
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0036
        L_0x0020:
            com.google.android.datatransport.cct.a.a r1 = r4.f7671b
            if (r1 != 0) goto L_0x002b
            com.google.android.datatransport.cct.a.e r5 = (com.google.android.datatransport.cct.a.e) r5
            com.google.android.datatransport.cct.a.a r5 = r5.f7671b
            if (r5 != 0) goto L_0x0036
            goto L_0x0035
        L_0x002b:
            com.google.android.datatransport.cct.a.e r5 = (com.google.android.datatransport.cct.a.e) r5
            com.google.android.datatransport.cct.a.a r5 = r5.f7671b
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0036
        L_0x0035:
            return r0
        L_0x0036:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.a.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        k.b bVar = this.f7670a;
        int i2 = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.f7671b;
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.f7670a + ", androidClientInfo=" + this.f7671b + "}";
    }
}
