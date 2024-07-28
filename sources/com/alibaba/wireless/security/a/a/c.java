package com.alibaba.wireless.security.a.a;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033 A[SYNTHETIC, Splitter:B:19:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A[SYNTHETIC, Splitter:B:26:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x003d
            boolean r1 = r3.exists()
            if (r1 != 0) goto L_0x000a
            goto L_0x003d
        L_0x000a:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r3.<init>()     // Catch:{ Exception -> 0x002e, all -> 0x002b }
        L_0x0019:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            if (r2 == 0) goto L_0x0023
            r3.append(r2)     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            goto L_0x0019
        L_0x0023:
            r1.close()     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
            goto L_0x003d
        L_0x002b:
            r3 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x002e:
            goto L_0x0038
        L_0x0030:
            r3 = move-exception
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            throw r3
        L_0x0037:
            r1 = r0
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.a.c.a(java.io.File):java.lang.String");
    }
}
