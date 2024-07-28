package com.google.android.gms.internal.clearcut;

public class bt {

    /* renamed from: d  reason: collision with root package name */
    private static final ar f9215d = ar.a();

    /* renamed from: a  reason: collision with root package name */
    ab f9216a;

    /* renamed from: b  reason: collision with root package name */
    volatile cm f9217b;

    /* renamed from: c  reason: collision with root package name */
    volatile ab f9218c;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.clearcut.cm a(com.google.android.gms.internal.clearcut.cm r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.clearcut.cm r0 = r1.f9217b
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.clearcut.cm r0 = r1.f9217b     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.f9217b = r2     // Catch:{ bn -> 0x0012 }
            com.google.android.gms.internal.clearcut.ab r0 = com.google.android.gms.internal.clearcut.ab.zzfi     // Catch:{ bn -> 0x0012 }
            r1.f9218c = r0     // Catch:{ bn -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.f9217b = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.clearcut.ab r2 = com.google.android.gms.internal.clearcut.ab.zzfi     // Catch:{ all -> 0x0019 }
            r1.f9218c = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.clearcut.cm r2 = r1.f9217b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.bt.a(com.google.android.gms.internal.clearcut.cm):com.google.android.gms.internal.clearcut.cm");
    }

    public final int b() {
        if (this.f9218c != null) {
            return this.f9218c.size();
        }
        if (this.f9217b != null) {
            return this.f9217b.e();
        }
        return 0;
    }

    public final ab c() {
        if (this.f9218c != null) {
            return this.f9218c;
        }
        synchronized (this) {
            if (this.f9218c != null) {
                ab abVar = this.f9218c;
                return abVar;
            }
            this.f9218c = this.f9217b == null ? ab.zzfi : this.f9217b.b();
            ab abVar2 = this.f9218c;
            return abVar2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bt)) {
            return false;
        }
        bt btVar = (bt) obj;
        cm cmVar = this.f9217b;
        cm cmVar2 = btVar.f9217b;
        return (cmVar == null && cmVar2 == null) ? c().equals(btVar.c()) : (cmVar == null || cmVar2 == null) ? cmVar != null ? cmVar.equals(btVar.a(cmVar.h())) : a(cmVar2.h()).equals(cmVar2) : cmVar.equals(cmVar2);
    }

    public int hashCode() {
        return 1;
    }
}
