package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.eh  reason: invalid package */
public class eh {

    /* renamed from: d  reason: collision with root package name */
    private static final de f9591d = de.a();

    /* renamed from: a  reason: collision with root package name */
    co f9592a;

    /* renamed from: b  reason: collision with root package name */
    volatile ex f9593b;

    /* renamed from: c  reason: collision with root package name */
    volatile co f9594c;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eh)) {
            return false;
        }
        eh ehVar = (eh) obj;
        ex exVar = this.f9593b;
        ex exVar2 = ehVar.f9593b;
        if (exVar == null && exVar2 == null) {
            return c().equals(ehVar.c());
        }
        if (exVar != null && exVar2 != null) {
            return exVar.equals(exVar2);
        }
        if (exVar != null) {
            return exVar.equals(ehVar.a(exVar.q()));
        }
        return a(exVar2.q()).equals(exVar2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.p001firebaseperf.ex a(com.google.android.gms.internal.p001firebaseperf.ex r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-perf.ex r0 = r1.f9593b
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-perf.ex r0 = r1.f9593b     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f9593b = r2     // Catch:{ dy -> 0x0012 }
            com.google.android.gms.internal.firebase-perf.co r0 = com.google.android.gms.internal.p001firebaseperf.co.zznb     // Catch:{ dy -> 0x0012 }
            r1.f9594c = r0     // Catch:{ dy -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f9593b = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase-perf.co r2 = com.google.android.gms.internal.p001firebaseperf.co.zznb     // Catch:{ all -> 0x001a }
            r1.f9594c = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase-perf.ex r2 = r1.f9593b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseperf.eh.a(com.google.android.gms.internal.firebase-perf.ex):com.google.android.gms.internal.firebase-perf.ex");
    }

    public final int b() {
        if (this.f9594c != null) {
            return this.f9594c.size();
        }
        if (this.f9593b != null) {
            return this.f9593b.o();
        }
        return 0;
    }

    public final co c() {
        if (this.f9594c != null) {
            return this.f9594c;
        }
        synchronized (this) {
            if (this.f9594c != null) {
                co coVar = this.f9594c;
                return coVar;
            }
            if (this.f9593b == null) {
                this.f9594c = co.zznb;
            } else {
                this.f9594c = this.f9593b.i();
            }
            co coVar2 = this.f9594c;
            return coVar2;
        }
    }
}
