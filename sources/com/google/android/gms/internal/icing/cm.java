package com.google.android.gms.internal.icing;

public class cm {

    /* renamed from: d  reason: collision with root package name */
    private static final bm f10132d = bm.a();

    /* renamed from: a  reason: collision with root package name */
    at f10133a;

    /* renamed from: b  reason: collision with root package name */
    volatile dd f10134b;

    /* renamed from: c  reason: collision with root package name */
    volatile at f10135c;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cm)) {
            return false;
        }
        cm cmVar = (cm) obj;
        dd ddVar = this.f10134b;
        dd ddVar2 = cmVar.f10134b;
        if (ddVar == null && ddVar2 == null) {
            return c().equals(cmVar.c());
        }
        if (ddVar != null && ddVar2 != null) {
            return ddVar.equals(ddVar2);
        }
        if (ddVar != null) {
            return ddVar.equals(cmVar.a(ddVar.f()));
        }
        return a(ddVar2.f()).equals(ddVar2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.icing.dd a(com.google.android.gms.internal.icing.dd r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.icing.dd r0 = r1.f10134b
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.icing.dd r0 = r1.f10134b     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f10134b = r2     // Catch:{ cd -> 0x0012 }
            com.google.android.gms.internal.icing.at r0 = com.google.android.gms.internal.icing.at.zzfy     // Catch:{ cd -> 0x0012 }
            r1.f10135c = r0     // Catch:{ cd -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f10134b = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.icing.at r2 = com.google.android.gms.internal.icing.at.zzfy     // Catch:{ all -> 0x001a }
            r1.f10135c = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.icing.dd r2 = r1.f10134b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.cm.a(com.google.android.gms.internal.icing.dd):com.google.android.gms.internal.icing.dd");
    }

    public final int b() {
        if (this.f10135c != null) {
            return this.f10135c.size();
        }
        if (this.f10134b != null) {
            return this.f10134b.d();
        }
        return 0;
    }

    public final at c() {
        if (this.f10135c != null) {
            return this.f10135c;
        }
        synchronized (this) {
            if (this.f10135c != null) {
                at atVar = this.f10135c;
                return atVar;
            }
            if (this.f10134b == null) {
                this.f10135c = at.zzfy;
            } else {
                this.f10135c = this.f10134b.a();
            }
            at atVar2 = this.f10135c;
            return atVar2;
        }
    }
}
