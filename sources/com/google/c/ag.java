package com.google.c;

public class ag {

    /* renamed from: b  reason: collision with root package name */
    private static final r f37705b = r.a();

    /* renamed from: a  reason: collision with root package name */
    protected volatile at f37706a;

    /* renamed from: c  reason: collision with root package name */
    private j f37707c;

    /* renamed from: d  reason: collision with root package name */
    private r f37708d;

    /* renamed from: e  reason: collision with root package name */
    private volatile j f37709e;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ag)) {
            return false;
        }
        ag agVar = (ag) obj;
        at atVar = this.f37706a;
        at atVar2 = agVar.f37706a;
        if (atVar == null && atVar2 == null) {
            return c().equals(agVar.c());
        }
        if (atVar != null && atVar2 != null) {
            return atVar.equals(atVar2);
        }
        if (atVar != null) {
            return atVar.equals(agVar.a(atVar.o()));
        }
        return a(atVar2.o()).equals(atVar2);
    }

    public final at a(at atVar) {
        c(atVar);
        return this.f37706a;
    }

    public final at b(at atVar) {
        at atVar2 = this.f37706a;
        this.f37707c = null;
        this.f37709e = null;
        this.f37706a = atVar;
        return atVar2;
    }

    public final int b() {
        if (this.f37709e != null) {
            return this.f37709e.size();
        }
        j jVar = this.f37707c;
        if (jVar != null) {
            return jVar.size();
        }
        if (this.f37706a != null) {
            return this.f37706a.j();
        }
        return 0;
    }

    public final j c() {
        if (this.f37709e != null) {
            return this.f37709e;
        }
        j jVar = this.f37707c;
        if (jVar != null) {
            return jVar;
        }
        synchronized (this) {
            if (this.f37709e != null) {
                j jVar2 = this.f37709e;
                return jVar2;
            }
            if (this.f37706a == null) {
                this.f37709e = j.EMPTY;
            } else {
                this.f37709e = this.f37706a.c();
            }
            j jVar3 = this.f37709e;
            return jVar3;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f37706a = r4;
        r3.f37709e = com.google.c.j.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.google.c.at r4) {
        /*
            r3 = this;
            com.google.c.at r0 = r3.f37706a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.c.at r0 = r3.f37706a     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.c.j r0 = r3.f37707c     // Catch:{ ad -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.c.bd r0 = r4.f()     // Catch:{ ad -> 0x002c }
            com.google.c.j r1 = r3.f37707c     // Catch:{ ad -> 0x002c }
            com.google.c.r r2 = r3.f37708d     // Catch:{ ad -> 0x002c }
            java.lang.Object r0 = r0.a((com.google.c.j) r1, (com.google.c.r) r2)     // Catch:{ ad -> 0x002c }
            com.google.c.at r0 = (com.google.c.at) r0     // Catch:{ ad -> 0x002c }
            r3.f37706a = r0     // Catch:{ ad -> 0x002c }
            com.google.c.j r0 = r3.f37707c     // Catch:{ ad -> 0x002c }
            r3.f37709e = r0     // Catch:{ ad -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f37706a = r4     // Catch:{ ad -> 0x002c }
            com.google.c.j r0 = com.google.c.j.EMPTY     // Catch:{ ad -> 0x002c }
            r3.f37709e = r0     // Catch:{ ad -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f37706a = r4     // Catch:{ all -> 0x0034 }
            com.google.c.j r4 = com.google.c.j.EMPTY     // Catch:{ all -> 0x0034 }
            r3.f37709e = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.ag.c(com.google.c.at):void");
    }
}
