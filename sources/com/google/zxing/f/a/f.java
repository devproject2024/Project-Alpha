package com.google.zxing.f.a;

import com.google.zxing.t;

final class f {

    /* renamed from: a  reason: collision with root package name */
    final a f40448a;

    /* renamed from: b  reason: collision with root package name */
    final g[] f40449b = new g[(this.f40451d + 2)];

    /* renamed from: c  reason: collision with root package name */
    c f40450c;

    /* renamed from: d  reason: collision with root package name */
    final int f40451d;

    f(a aVar, c cVar) {
        this.f40448a = aVar;
        this.f40451d = aVar.f40415a;
        this.f40450c = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar) {
        t tVar;
        t tVar2;
        if (gVar != null) {
            h hVar = (h) gVar;
            a aVar = this.f40448a;
            d[] dVarArr = hVar.f40453b;
            for (d dVar : hVar.f40453b) {
                if (dVar != null) {
                    dVar.b();
                }
            }
            hVar.a(dVarArr, aVar);
            c cVar = hVar.f40452a;
            if (hVar.f40454c) {
                tVar = cVar.f40431b;
            } else {
                tVar = cVar.f40433d;
            }
            if (hVar.f40454c) {
                tVar2 = cVar.f40432c;
            } else {
                tVar2 = cVar.f40434e;
            }
            int b2 = hVar.b((int) tVar.f40585b);
            int b3 = hVar.b((int) tVar2.f40585b);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (b2 < b3) {
                if (dVarArr[b2] != null) {
                    d dVar2 = dVarArr[b2];
                    int i5 = dVar2.f40443e - i2;
                    if (i5 == 0) {
                        i3++;
                    } else {
                        if (i5 == 1) {
                            i4 = Math.max(i4, i3);
                            i2 = dVar2.f40443e;
                        } else if (i5 < 0 || dVar2.f40443e >= aVar.f40419e || i5 > b2) {
                            dVarArr[b2] = null;
                        } else {
                            if (i4 > 2) {
                                i5 *= i4 - 2;
                            }
                            boolean z = i5 >= b2;
                            for (int i6 = 1; i6 <= i5 && !z; i6++) {
                                z = dVarArr[b2 - i6] != null;
                            }
                            if (z) {
                                dVarArr[b2] = null;
                            } else {
                                i2 = dVar2.f40443e;
                            }
                        }
                        i3 = 1;
                    }
                }
                b2++;
            }
        }
    }

    static int a(int i2, int i3, d dVar) {
        if (dVar == null || dVar.a()) {
            return i3;
        }
        if (!dVar.a(i2)) {
            return i3 + 1;
        }
        dVar.f40443e = i2;
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r10 = this;
            com.google.zxing.f.a.g[] r0 = r10.f40449b
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            if (r2 != 0) goto L_0x000d
            int r2 = r10.f40451d
            int r2 = r2 + r3
            r2 = r0[r2]
        L_0x000d:
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r4 = 0
        L_0x0013:
            com.google.zxing.f.a.d[] r5 = r2.f40453b     // Catch:{ all -> 0x0076 }
            int r5 = r5.length     // Catch:{ all -> 0x0076 }
            if (r4 >= r5) goto L_0x006e
            java.lang.String r5 = "CW %3d:"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x0076 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0076 }
            r6[r1] = r7     // Catch:{ all -> 0x0076 }
            r0.format(r5, r6)     // Catch:{ all -> 0x0076 }
            r5 = 0
        L_0x0026:
            int r6 = r10.f40451d     // Catch:{ all -> 0x0076 }
            r7 = 2
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x0064
            com.google.zxing.f.a.g[] r6 = r10.f40449b     // Catch:{ all -> 0x0076 }
            r6 = r6[r5]     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "    |   "
            if (r6 != 0) goto L_0x003a
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0076 }
            r0.format(r8, r6)     // Catch:{ all -> 0x0076 }
            goto L_0x0061
        L_0x003a:
            com.google.zxing.f.a.g[] r6 = r10.f40449b     // Catch:{ all -> 0x0076 }
            r6 = r6[r5]     // Catch:{ all -> 0x0076 }
            com.google.zxing.f.a.d[] r6 = r6.f40453b     // Catch:{ all -> 0x0076 }
            r6 = r6[r4]     // Catch:{ all -> 0x0076 }
            if (r6 != 0) goto L_0x004a
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0076 }
            r0.format(r8, r6)     // Catch:{ all -> 0x0076 }
            goto L_0x0061
        L_0x004a:
            java.lang.String r8 = " %3d|%3d"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0076 }
            int r9 = r6.f40443e     // Catch:{ all -> 0x0076 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0076 }
            r7[r1] = r9     // Catch:{ all -> 0x0076 }
            int r6 = r6.f40442d     // Catch:{ all -> 0x0076 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0076 }
            r7[r3] = r6     // Catch:{ all -> 0x0076 }
            r0.format(r8, r7)     // Catch:{ all -> 0x0076 }
        L_0x0061:
            int r5 = r5 + 1
            goto L_0x0026
        L_0x0064:
            java.lang.String r5 = "%n"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0076 }
            r0.format(r5, r6)     // Catch:{ all -> 0x0076 }
            int r4 = r4 + 1
            goto L_0x0013
        L_0x006e:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0076 }
            r0.close()
            return r1
        L_0x0076:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0081:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.f.toString():java.lang.String");
    }
}
