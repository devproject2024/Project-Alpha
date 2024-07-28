package net.one97.paytm.utils;

public final class al {
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r3, java.lang.String r4) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "dd/MM/yyyy"
            r0.<init>(r2, r1)
            r1 = 0
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x0015 }
            java.util.Date r1 = r0.parse(r4)     // Catch:{ ParseException -> 0x0013 }
            goto L_0x001a
        L_0x0013:
            r4 = move-exception
            goto L_0x0017
        L_0x0015:
            r4 = move-exception
            r3 = r1
        L_0x0017:
            r4.printStackTrace()
        L_0x001a:
            if (r3 == 0) goto L_0x0026
            if (r1 == 0) goto L_0x0026
            boolean r3 = r3.after(r1)
            if (r3 == 0) goto L_0x0026
            r3 = 1
            return r3
        L_0x0026:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.al.a(java.lang.String, java.lang.String):boolean");
    }
}
