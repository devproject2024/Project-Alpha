package net.one97.paytm.paymentsBank.si.g;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062 A[Catch:{ Exception -> 0x00cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00cf }
            if (r1 != 0) goto L_0x00cf
            java.lang.String r1 = " "
            java.lang.String[] r1 = r5.split(r1)     // Catch:{ Exception -> 0x00cf }
            r2 = 1
            if (r1 == 0) goto L_0x0023
            int r3 = r1.length     // Catch:{ Exception -> 0x00cf }
            if (r3 <= r2) goto L_0x001e
            int r3 = r1.length     // Catch:{ Exception -> 0x00cf }
            int r3 = r3 - r2
            r1 = r1[r3]     // Catch:{ Exception -> 0x00cf }
            java.lang.String r3 = ""
            java.lang.String r5 = r5.replace(r1, r3)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0025
        L_0x001e:
            int r1 = r1.length     // Catch:{ Exception -> 0x00cf }
            if (r1 != r2) goto L_0x0023
            r1 = r0
            goto L_0x0025
        L_0x0023:
            r5 = r0
            r1 = r5
        L_0x0025:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00cf }
            if (r3 != 0) goto L_0x002f
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x00cf }
        L_0x002f:
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00cf }
            if (r3 != 0) goto L_0x0039
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x00cf }
        L_0x0039:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00cf }
            r4 = 0
            if (r3 != 0) goto L_0x0062
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00cf }
            if (r3 != 0) goto L_0x0062
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cf }
            r2.<init>()     // Catch:{ Exception -> 0x00cf }
            char r5 = r5.charAt(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00cf }
            r2.append(r5)     // Catch:{ Exception -> 0x00cf }
            char r5 = r1.charAt(r4)     // Catch:{ Exception -> 0x00cf }
            r2.append(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00cf
        L_0x0062:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00cf }
            if (r3 != 0) goto L_0x008a
            int r3 = r5.length()     // Catch:{ Exception -> 0x00cf }
            if (r3 <= r2) goto L_0x008a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cf }
            r1.<init>()     // Catch:{ Exception -> 0x00cf }
            char r3 = r5.charAt(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00cf }
            r1.append(r3)     // Catch:{ Exception -> 0x00cf }
            char r5 = r5.charAt(r2)     // Catch:{ Exception -> 0x00cf }
            r1.append(r5)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00cf
        L_0x008a:
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00cf }
            if (r3 != 0) goto L_0x00b2
            int r3 = r1.length()     // Catch:{ Exception -> 0x00cf }
            if (r3 <= r2) goto L_0x00b2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cf }
            r5.<init>()     // Catch:{ Exception -> 0x00cf }
            char r3 = r1.charAt(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00cf }
            r5.append(r3)     // Catch:{ Exception -> 0x00cf }
            char r1 = r1.charAt(r2)     // Catch:{ Exception -> 0x00cf }
            r5.append(r1)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00cf
        L_0x00b2:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00cf }
            if (r2 != 0) goto L_0x00c1
            char r5 = r5.charAt(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00cf
        L_0x00c1:
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00cf }
            if (r5 != 0) goto L_0x00cf
            char r5 = r1.charAt(r4)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.si.g.b.a(java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() <= 4) {
            return sb.toString();
        }
        for (int i2 = 0; i2 < str.length() - 4; i2++) {
            sb.append("X");
        }
        return sb.toString() + str.substring(str.length() - 4);
    }
}
