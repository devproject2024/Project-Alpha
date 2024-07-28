package com.google.android.gms.internal.firebase_ml;

public class gx {

    /* renamed from: d  reason: collision with root package name */
    private static final fw f9945d = fw.a();

    /* renamed from: a  reason: collision with root package name */
    fh f9946a;

    /* renamed from: b  reason: collision with root package name */
    volatile hn f9947b;

    /* renamed from: c  reason: collision with root package name */
    volatile fh f9948c;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gx)) {
            return false;
        }
        gx gxVar = (gx) obj;
        hn hnVar = this.f9947b;
        hn hnVar2 = gxVar.f9947b;
        if (hnVar == null && hnVar2 == null) {
            return c().equals(gxVar.c());
        }
        if (hnVar != null && hnVar2 != null) {
            return hnVar.equals(hnVar2);
        }
        if (hnVar != null) {
            return hnVar.equals(gxVar.a(hnVar.k()));
        }
        return a(hnVar2.k()).equals(hnVar2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_ml.hn a(com.google.android.gms.internal.firebase_ml.hn r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase_ml.hn r0 = r1.f9947b
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase_ml.hn r0 = r1.f9947b     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f9947b = r2     // Catch:{ gp -> 0x0012 }
            com.google.android.gms.internal.firebase_ml.fh r0 = com.google.android.gms.internal.firebase_ml.fh.zzchp     // Catch:{ gp -> 0x0012 }
            r1.f9948c = r0     // Catch:{ gp -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f9947b = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase_ml.fh r2 = com.google.android.gms.internal.firebase_ml.fh.zzchp     // Catch:{ all -> 0x001a }
            r1.f9948c = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase_ml.hn r2 = r1.f9947b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.gx.a(com.google.android.gms.internal.firebase_ml.hn):com.google.android.gms.internal.firebase_ml.hn");
    }

    public final int b() {
        if (this.f9948c != null) {
            return this.f9948c.size();
        }
        if (this.f9947b != null) {
            return this.f9947b.i();
        }
        return 0;
    }

    public final fh c() {
        if (this.f9948c != null) {
            return this.f9948c;
        }
        synchronized (this) {
            if (this.f9948c != null) {
                fh fhVar = this.f9948c;
                return fhVar;
            }
            if (this.f9947b == null) {
                this.f9948c = fh.zzchp;
            } else {
                this.f9948c = this.f9947b.d();
            }
            fh fhVar2 = this.f9948c;
            return fhVar2;
        }
    }
}
