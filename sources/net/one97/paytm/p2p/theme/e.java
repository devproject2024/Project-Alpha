package net.one97.paytm.p2p.theme;

public final class e {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[SYNTHETIC, Splitter:B:19:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0042 A[SYNTHETIC, Splitter:B:30:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0033=Splitter:B:23:0x0033, B:16:0x0025=Splitter:B:16:0x0025} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2, java.lang.Object r3, java.lang.String r4) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = r2.openFileOutput(r4, r0)     // Catch:{ IOException -> 0x0032, OutOfMemoryError -> 0x0024 }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0032, OutOfMemoryError -> 0x0024 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x0032, OutOfMemoryError -> 0x0024 }
            r4.writeObject(r3)     // Catch:{ IOException -> 0x001f, OutOfMemoryError -> 0x001c, all -> 0x0019 }
            java.io.FileDescriptor r2 = r2.getFD()     // Catch:{ IOException -> 0x001f, OutOfMemoryError -> 0x001c, all -> 0x0019 }
            r2.sync()     // Catch:{ IOException -> 0x001f, OutOfMemoryError -> 0x001c, all -> 0x0019 }
            r4.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return
        L_0x0019:
            r2 = move-exception
            r1 = r4
            goto L_0x0040
        L_0x001c:
            r2 = move-exception
            r1 = r4
            goto L_0x0025
        L_0x001f:
            r2 = move-exception
            r1 = r4
            goto L_0x0033
        L_0x0022:
            r2 = move-exception
            goto L_0x0040
        L_0x0024:
            r2 = move-exception
        L_0x0025:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0022 }
            com.paytm.utility.q.d(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return
        L_0x0032:
            r2 = move-exception
        L_0x0033:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0022 }
            com.paytm.utility.q.d(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            return
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2p.theme.e.a(android.content.Context, java.lang.Object, java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.ObjectInputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r3 != null) goto L_0x0026;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[SYNTHETIC, Splitter:B:20:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r2.getSystemService(r0)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            android.app.ActivityManager$MemoryInfo r1 = new android.app.ActivityManager$MemoryInfo
            r1.<init>()
            r0.getMemoryInfo(r1)
            boolean r0 = r1.lowMemory
            r1 = 0
            if (r0 != 0) goto L_0x0043
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            java.lang.Object r1 = r3.readObject()     // Catch:{ Exception -> 0x002a }
        L_0x0026:
            r3.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003a
        L_0x002a:
            r2 = move-exception
            goto L_0x0030
        L_0x002c:
            r2 = move-exception
            goto L_0x003d
        L_0x002e:
            r2 = move-exception
            r3 = r1
        L_0x0030:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x003b }
            com.paytm.utility.q.d(r2)     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x003a
            goto L_0x0026
        L_0x003a:
            return r1
        L_0x003b:
            r2 = move-exception
            r1 = r3
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            throw r2
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2p.theme.e.a(android.content.Context, java.lang.String):java.lang.Object");
    }
}
