package com.google.android.gms.internal.measurement;

public class ek {

    /* renamed from: d  reason: collision with root package name */
    private static final dh f10617d = dh.a();

    /* renamed from: a  reason: collision with root package name */
    cm f10618a;

    /* renamed from: b  reason: collision with root package name */
    volatile ff f10619b;

    /* renamed from: c  reason: collision with root package name */
    volatile cm f10620c;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ek)) {
            return false;
        }
        ek ekVar = (ek) obj;
        ff ffVar = this.f10619b;
        ff ffVar2 = ekVar.f10619b;
        if (ffVar == null && ffVar2 == null) {
            return c().equals(ekVar.c());
        }
        if (ffVar != null && ffVar2 != null) {
            return ffVar.equals(ffVar2);
        }
        if (ffVar != null) {
            return ffVar.equals(ekVar.a(ffVar.q()));
        }
        return a(ffVar2.q()).equals(ffVar2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.ff a(com.google.android.gms.internal.measurement.ff r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.ff r0 = r1.f10619b
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.ff r0 = r1.f10619b     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f10619b = r2     // Catch:{ eg -> 0x0012 }
            com.google.android.gms.internal.measurement.cm r0 = com.google.android.gms.internal.measurement.cm.zza     // Catch:{ eg -> 0x0012 }
            r1.f10620c = r0     // Catch:{ eg -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f10619b = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.cm r2 = com.google.android.gms.internal.measurement.cm.zza     // Catch:{ all -> 0x001a }
            r1.f10620c = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.ff r2 = r1.f10619b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ek.a(com.google.android.gms.internal.measurement.ff):com.google.android.gms.internal.measurement.ff");
    }

    public final int b() {
        if (this.f10620c != null) {
            return this.f10620c.zza();
        }
        if (this.f10619b != null) {
            return this.f10619b.n();
        }
        return 0;
    }

    public final cm c() {
        if (this.f10620c != null) {
            return this.f10620c;
        }
        synchronized (this) {
            if (this.f10620c != null) {
                cm cmVar = this.f10620c;
                return cmVar;
            }
            if (this.f10619b == null) {
                this.f10620c = cm.zza;
            } else {
                this.f10620c = this.f10619b.h();
            }
            cm cmVar2 = this.f10620c;
            return cmVar2;
        }
    }
}
