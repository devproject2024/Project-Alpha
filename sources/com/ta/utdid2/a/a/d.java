package com.ta.utdid2.a.a;

import java.util.Random;

public final class d {
    private static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a2 = c.a(currentTimeMillis);
        byte[] a3 = c.a(nanoTime);
        byte[] a4 = c.a(nextInt);
        byte[] a5 = c.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a2, 0, bArr, 0, 4);
        System.arraycopy(a3, 0, bArr, 4, 4);
        System.arraycopy(a4, 0, bArr, 8, 4);
        System.arraycopy(a5, 0, bArr, 12, 4);
        return b.a(bArr, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r1) {
        /*
            if (r1 == 0) goto L_0x0011
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch:{ Exception -> 0x0011 }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x0011 }
            if (r1 == 0) goto L_0x0011
            java.lang.String r1 = r1.getDeviceId()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            boolean r0 = com.ta.utdid2.a.a.e.a(r1)
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = a()
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.d.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r1) {
        /*
            if (r1 == 0) goto L_0x0011
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch:{ Exception -> 0x0011 }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x0011 }
            if (r1 == 0) goto L_0x0011
            java.lang.String r1 = r1.getSubscriberId()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            boolean r0 = com.ta.utdid2.a.a.e.a(r1)
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = a()
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.d.b(android.content.Context):java.lang.String");
    }
}
