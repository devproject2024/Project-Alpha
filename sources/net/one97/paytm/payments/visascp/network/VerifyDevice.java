package net.one97.paytm.payments.visascp.network;

public class VerifyDevice {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f604 = 1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f605;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        if ((android.text.TextUtils.isEmpty(r18) ? 'L' : 'J') != 'L') goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if ((r6) != true) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void callDeviceVerificationApi(android.content.Context r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.android.volley.Response.Listener<net.one97.paytm.payments.visascp.network.model.BaseModel> r22, com.android.volley.Response.ErrorListener r23) {
        /*
            r0 = r23
            int r1 = f604
            r2 = r1 ^ 42
            r1 = r1 & 42
            r3 = 1
            int r1 = r1 << r3
            int r2 = r2 + r1
            r1 = 0
            int r2 = r2 - r1
            int r2 = r2 - r3
            int r4 = r2 % 128
            f605 = r4
            r4 = 2
            int r2 = r2 % r4
            if (r2 != 0) goto L_0x0018
            r2 = 0
            goto L_0x0019
        L_0x0018:
            r2 = 1
        L_0x0019:
            r5 = 0
            if (r2 == r3) goto L_0x0030
            net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager r2 = net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager.getsInstance()
            boolean r6 = android.text.TextUtils.isEmpty(r18)
            r7 = 76
            if (r6 == 0) goto L_0x002b
            r6 = 76
            goto L_0x002d
        L_0x002b:
            r6 = 74
        L_0x002d:
            if (r6 == r7) goto L_0x00fb
            goto L_0x0042
        L_0x0030:
            net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager r2 = net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager.getsInstance()
            boolean r6 = android.text.TextUtils.isEmpty(r18)
            super.hashCode()     // Catch:{ all -> 0x010e }
            if (r6 == 0) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r6 == r3) goto L_0x00fb
        L_0x0042:
            int r6 = f605
            r7 = r6 & 34
            r6 = r6 | 34
            int r7 = r7 + r6
            r6 = r7 & -1
            r7 = r7 | -1
            int r6 = r6 + r7
            int r7 = r6 % 128
            f604 = r7
            int r6 = r6 % r4
            boolean r6 = android.text.TextUtils.isEmpty(r20)
            if (r6 == 0) goto L_0x005b
            r6 = 0
            goto L_0x005c
        L_0x005b:
            r6 = 1
        L_0x005c:
            if (r6 == r3) goto L_0x0060
            goto L_0x00fb
        L_0x0060:
            int r6 = f605
            int r6 = r6 + 96
            int r6 = r6 - r1
            int r6 = r6 - r3
            int r7 = r6 % 128
            f604 = r7
            int r6 = r6 % r4
            boolean r6 = android.text.TextUtils.isEmpty(r19)
            if (r6 == 0) goto L_0x0073
            goto L_0x00fb
        L_0x0073:
            java.util.concurrent.ExecutorService r6 = r2.getExecutorService()
            r7 = 9
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x00f2 }
            r9 = 8
            r8[r9] = r22     // Catch:{ all -> 0x00f2 }
            r10 = 7
            r8[r10] = r21     // Catch:{ all -> 0x00f2 }
            r11 = 6
            r8[r11] = r20     // Catch:{ all -> 0x00f2 }
            r12 = 5
            r8[r12] = r0     // Catch:{ all -> 0x00f2 }
            r0 = 4
            r8[r0] = r2     // Catch:{ all -> 0x00f2 }
            r2 = 3
            r8[r2] = r19     // Catch:{ all -> 0x00f2 }
            r8[r4] = r18     // Catch:{ all -> 0x00f2 }
            r8[r3] = r17     // Catch:{ all -> 0x00f2 }
            r8[r1] = r16     // Catch:{ all -> 0x00f2 }
            r13 = 21900(0x558c, float:3.0688E-41)
            r14 = 55
            r15 = 396(0x18c, float:5.55E-43)
            java.lang.Object r13 = net.one97.paytm.payments.visascp.network.If.m692(r13, r14, r15)     // Catch:{ all -> 0x00f2 }
            java.lang.Class r13 = (java.lang.Class) r13     // Catch:{ all -> 0x00f2 }
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ all -> 0x00f2 }
            java.lang.Class<android.content.Context> r14 = android.content.Context.class
            r7[r1] = r14     // Catch:{ all -> 0x00f2 }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r7[r3] = r1     // Catch:{ all -> 0x00f2 }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r7[r4] = r1     // Catch:{ all -> 0x00f2 }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r7[r2] = r1     // Catch:{ all -> 0x00f2 }
            java.lang.Class<net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager> r1 = net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager.class
            r7[r0] = r1     // Catch:{ all -> 0x00f2 }
            java.lang.Class<com.android.volley.Response$ErrorListener> r0 = com.android.volley.Response.ErrorListener.class
            r7[r12] = r0     // Catch:{ all -> 0x00f2 }
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r7[r11] = r0     // Catch:{ all -> 0x00f2 }
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r7[r10] = r0     // Catch:{ all -> 0x00f2 }
            java.lang.Class<com.android.volley.Response$Listener> r0 = com.android.volley.Response.Listener.class
            r7[r9] = r0     // Catch:{ all -> 0x00f2 }
            java.lang.reflect.Constructor r0 = r13.getDeclaredConstructor(r7)     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r0.newInstance(r8)     // Catch:{ all -> 0x00f2 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x00f2 }
            r6.submit(r0)
            int r0 = f604
            r1 = r0 & 21
            r0 = r0 | 21
            int r1 = r1 + r0
            int r0 = r1 % 128
            f605 = r0
            int r1 = r1 % r4
            if (r1 != 0) goto L_0x00e4
            r0 = 70
            goto L_0x00e6
        L_0x00e4:
            r0 = 30
        L_0x00e6:
            r1 = 70
            if (r0 == r1) goto L_0x00f1
            super.hashCode()     // Catch:{ all -> 0x00ee }
            return
        L_0x00ee:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x00f1:
            return
        L_0x00f2:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto L_0x00fa
            throw r1
        L_0x00fa:
            throw r0
        L_0x00fb:
            com.android.volley.VolleyError r1 = new com.android.volley.VolleyError
            r1.<init>()
            r2.onErrorResponse(r0, r1)
            int r0 = f605
            int r0 = r0 + 24
            int r0 = r0 - r3
            int r1 = r0 % 128
            f604 = r1
            int r0 = r0 % r4
            return
        L_0x010e:
            r0 = move-exception
            r1 = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.VerifyDevice.callDeviceVerificationApi(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
    }
}
