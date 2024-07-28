package com.alipay.imobile.network.quake.e;

import java.util.Date;

public abstract class a<T> implements b<T> {
    private static long a(String str) {
        Date a2 = com.alipay.imobile.network.quake.h.a.a(str);
        if (a2 == null) {
            return 0;
        }
        return a2.getTime();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v2, types: [int] */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.alipay.imobile.network.quake.b.a.C0201a a(com.alipay.imobile.network.quake.b r21) {
        /*
            r0 = r21
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.extData
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = "Date"
            java.lang.Object r5 = r1.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x001b
            long r8 = a((java.lang.String) r5)
            goto L_0x001d
        L_0x001b:
            r8 = 0
        L_0x001d:
            java.lang.String r5 = "Cache-Control"
            java.lang.Object r5 = r1.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r10 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = "headers.get(\"Cache-Control\")="
            r11.concat(r10)
            com.alipay.iap.android.common.b.c.e()
            java.lang.String r10 = "max-age="
            r12 = 0
            if (r5 == 0) goto L_0x00a6
            java.lang.String r13 = ","
            java.lang.String[] r5 = r5.split(r13)
            int r13 = r5.length
            r14 = 0
            r16 = 0
            r17 = 0
        L_0x0045:
            if (r12 >= r13) goto L_0x009f
            r19 = r5[r12]
            java.lang.String r11 = r19.trim()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r6 = "no-cache"
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0097 }
            if (r6 != 0) goto L_0x0096
            java.lang.String r6 = "no-store"
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0097 }
            if (r6 == 0) goto L_0x005e
            goto L_0x0096
        L_0x005e:
            boolean r6 = r11.startsWith(r10)     // Catch:{ Exception -> 0x0097 }
            if (r6 == 0) goto L_0x006f
            r6 = 8
            java.lang.String r6 = r11.substring(r6)     // Catch:{ Exception -> 0x0097 }
            long r14 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0097 }
            goto L_0x009c
        L_0x006f:
            java.lang.String r6 = "stale-while-revalidate="
            boolean r6 = r11.startsWith(r6)     // Catch:{ Exception -> 0x0097 }
            if (r6 == 0) goto L_0x0083
            r6 = 23
            java.lang.String r6 = r11.substring(r6)     // Catch:{ Exception -> 0x0097 }
            long r17 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0097 }
            goto L_0x009c
        L_0x0083:
            java.lang.String r6 = "must-revalidate"
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0097 }
            if (r6 != 0) goto L_0x0093
            java.lang.String r6 = "proxy-revalidate"
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0097 }
            if (r6 == 0) goto L_0x009c
        L_0x0093:
            r16 = 1
            goto L_0x009c
        L_0x0096:
            return r2
        L_0x0097:
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.j()
        L_0x009c:
            int r12 = r12 + 1
            goto L_0x0045
        L_0x009f:
            r12 = r16
            r5 = r17
            r20 = 1
            goto L_0x00ac
        L_0x00a6:
            r5 = 0
            r14 = 0
            r20 = 0
        L_0x00ac:
            java.lang.String r2 = "Expires"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00bb
            long r16 = a((java.lang.String) r2)
            goto L_0x00bd
        L_0x00bb:
            r16 = 0
        L_0x00bd:
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00cf
            long r18 = a((java.lang.String) r2)
            r2 = r10
            r10 = r18
            goto L_0x00d2
        L_0x00cf:
            r2 = r10
            r10 = 0
        L_0x00d2:
            java.lang.String r7 = "ETag"
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r20 == 0) goto L_0x00ec
            r8 = 1000(0x3e8, double:4.94E-321)
            long r16 = r14 * r8
            long r3 = r3 + r16
            if (r12 == 0) goto L_0x00e5
            goto L_0x00fd
        L_0x00e5:
            java.lang.Long.signum(r5)
            long r8 = r8 * r5
            long r8 = r8 + r3
            goto L_0x00fe
        L_0x00ec:
            r18 = 0
            int r13 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r13 <= 0) goto L_0x00fb
            int r13 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r13 < 0) goto L_0x00fb
            long r16 = r16 - r8
            long r3 = r3 + r16
            goto L_0x00fd
        L_0x00fb:
            r3 = r18
        L_0x00fd:
            r8 = r3
        L_0x00fe:
            com.alipay.imobile.network.quake.b.a$a r13 = new com.alipay.imobile.network.quake.b.a$a
            r13.<init>()
            byte[] r0 = r0.data
            r13.f14718a = r0
            r13.f14719b = r7
            r13.f14722e = r3
            r13.f14721d = r8
            r13.f14720c = r10
            r13.f14723f = r1
            boolean r0 = com.alipay.iap.android.common.b.c.a()
            if (r0 == 0) goto L_0x0150
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r14)
            java.lang.String r1 = ", stale-while-revalidate="
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ", must-revalidate="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = ", softExpireTime="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = ", finalExpireTime="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = ", current="
            r0.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            r0.append(r1)
            com.alipay.iap.android.common.b.c.c()
        L_0x0150:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.e.a.a(com.alipay.imobile.network.quake.b):com.alipay.imobile.network.quake.b.a$a");
    }
}
