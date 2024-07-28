package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.o;

final class i extends o {

    /* renamed from: a  reason: collision with root package name */
    private final o.c f7703a;

    /* renamed from: b  reason: collision with root package name */
    private final o.b f7704b;

    static final class a extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private o.c f7705a;

        /* renamed from: b  reason: collision with root package name */
        private o.b f7706b;

        a() {
        }

        public final o.a a(o.c cVar) {
            this.f7705a = cVar;
            return this;
        }

        public final o.a a(o.b bVar) {
            this.f7706b = bVar;
            return this;
        }

        public final o a() {
            return new i(this.f7705a, this.f7706b);
        }
    }

    /* synthetic */ i(o.c cVar, o.b bVar) {
        this.f7703a = cVar;
        this.f7704b = bVar;
    }

    public final o.c a() {
        return this.f7703a;
    }

    public final o.b b() {
        return this.f7704b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r1 = r4.f7704b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r1 = r4.f7703a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.datatransport.cct.a.o
            r2 = 0
            if (r1 == 0) goto L_0x0036
            com.google.android.datatransport.cct.a.o$c r1 = r4.f7703a
            if (r1 != 0) goto L_0x0015
            r1 = r5
            com.google.android.datatransport.cct.a.i r1 = (com.google.android.datatransport.cct.a.i) r1
            com.google.android.datatransport.cct.a.o$c r1 = r1.f7703a
            if (r1 != 0) goto L_0x0036
            goto L_0x0020
        L_0x0015:
            r3 = r5
            com.google.android.datatransport.cct.a.i r3 = (com.google.android.datatransport.cct.a.i) r3
            com.google.android.datatransport.cct.a.o$c r3 = r3.f7703a
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0036
        L_0x0020:
            com.google.android.datatransport.cct.a.o$b r1 = r4.f7704b
            if (r1 != 0) goto L_0x002b
            com.google.android.datatransport.cct.a.i r5 = (com.google.android.datatransport.cct.a.i) r5
            com.google.android.datatransport.cct.a.o$b r5 = r5.f7704b
            if (r5 != 0) goto L_0x0036
            goto L_0x0035
        L_0x002b:
            com.google.android.datatransport.cct.a.i r5 = (com.google.android.datatransport.cct.a.i) r5
            com.google.android.datatransport.cct.a.o$b r5 = r5.f7704b
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0036
        L_0x0035:
            return r0
        L_0x0036:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.a.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        o.c cVar = this.f7703a;
        int i2 = 0;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f7704b;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f7703a + ", mobileSubtype=" + this.f7704b + "}";
    }
}
