package com.google.zxing.f.a;

class g {

    /* renamed from: a  reason: collision with root package name */
    final c f40452a;

    /* renamed from: b  reason: collision with root package name */
    final d[] f40453b;

    g(c cVar) {
        this.f40452a = new c(cVar);
        this.f40453b = new d[((cVar.f40438i - cVar.f40437h) + 1)];
    }

    /* access modifiers changed from: package-private */
    public final d a(int i2) {
        d dVar;
        d dVar2;
        d c2 = c(i2);
        if (c2 != null) {
            return c2;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int b2 = b(i2) - i3;
            if (b2 >= 0 && (dVar2 = this.f40453b[b2]) != null) {
                return dVar2;
            }
            int b3 = b(i2) + i3;
            d[] dVarArr = this.f40453b;
            if (b3 < dVarArr.length && (dVar = dVarArr[b3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        return i2 - this.f40452a.f40437h;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, d dVar) {
        this.f40453b[b(i2)] = dVar;
    }

    /* access modifiers changed from: package-private */
    public final d c(int i2) {
        return this.f40453b[b(i2)];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r11 = this;
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            com.google.zxing.f.a.d[] r1 = r11.f40453b     // Catch:{ all -> 0x0050 }
            int r2 = r1.length     // Catch:{ all -> 0x0050 }
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000b:
            if (r4 >= r2) goto L_0x0048
            r6 = r1[r4]     // Catch:{ all -> 0x0050 }
            r7 = 1
            if (r6 != 0) goto L_0x0023
            java.lang.String r6 = "%3d:    |   %n"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0050 }
            int r8 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0050 }
            r7[r3] = r5     // Catch:{ all -> 0x0050 }
            r0.format(r6, r7)     // Catch:{ all -> 0x0050 }
            r5 = r8
            goto L_0x0045
        L_0x0023:
            java.lang.String r8 = "%3d: %3d|%3d%n"
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0050 }
            int r10 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0050 }
            r9[r3] = r5     // Catch:{ all -> 0x0050 }
            int r5 = r6.f40443e     // Catch:{ all -> 0x0050 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0050 }
            r9[r7] = r5     // Catch:{ all -> 0x0050 }
            r5 = 2
            int r6 = r6.f40442d     // Catch:{ all -> 0x0050 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0050 }
            r9[r5] = r6     // Catch:{ all -> 0x0050 }
            r0.format(r8, r9)     // Catch:{ all -> 0x0050 }
            r5 = r10
        L_0x0045:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0048:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0050 }
            r0.close()
            return r1
        L_0x0050:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x005b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.g.toString():java.lang.String");
    }
}
