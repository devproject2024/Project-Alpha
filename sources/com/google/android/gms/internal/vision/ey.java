package com.google.android.gms.internal.vision;

public class ey {

    /* renamed from: d  reason: collision with root package name */
    private static final du f11121d = du.a();

    /* renamed from: a  reason: collision with root package name */
    cz f11122a;

    /* renamed from: b  reason: collision with root package name */
    volatile ft f11123b;

    /* renamed from: c  reason: collision with root package name */
    volatile cz f11124c;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ey)) {
            return false;
        }
        ey eyVar = (ey) obj;
        ft ftVar = this.f11123b;
        ft ftVar2 = eyVar.f11123b;
        if (ftVar == null && ftVar2 == null) {
            return c().equals(eyVar.c());
        }
        if (ftVar != null && ftVar2 != null) {
            return ftVar.equals(ftVar2);
        }
        if (ftVar != null) {
            return ftVar.equals(eyVar.a(ftVar.k()));
        }
        return a(ftVar2.k()).equals(ftVar2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.vision.ft a(com.google.android.gms.internal.vision.ft r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.vision.ft r0 = r1.f11123b
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.vision.ft r0 = r1.f11123b     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f11123b = r2     // Catch:{ eu -> 0x0012 }
            com.google.android.gms.internal.vision.cz r0 = com.google.android.gms.internal.vision.cz.zzsd     // Catch:{ eu -> 0x0012 }
            r1.f11124c = r0     // Catch:{ eu -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f11123b = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.vision.cz r2 = com.google.android.gms.internal.vision.cz.zzsd     // Catch:{ all -> 0x001a }
            r1.f11124c = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.vision.ft r2 = r1.f11123b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.ey.a(com.google.android.gms.internal.vision.ft):com.google.android.gms.internal.vision.ft");
    }

    public final int b() {
        if (this.f11124c != null) {
            return this.f11124c.size();
        }
        if (this.f11123b != null) {
            return this.f11123b.h();
        }
        return 0;
    }

    public final cz c() {
        if (this.f11124c != null) {
            return this.f11124c;
        }
        synchronized (this) {
            if (this.f11124c != null) {
                cz czVar = this.f11124c;
                return czVar;
            }
            if (this.f11123b == null) {
                this.f11124c = cz.zzsd;
            } else {
                this.f11124c = this.f11123b.c();
            }
            cz czVar2 = this.f11124c;
            return czVar2;
        }
    }
}
