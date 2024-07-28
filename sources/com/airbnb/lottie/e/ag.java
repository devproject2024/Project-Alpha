package com.airbnb.lottie.e;

import com.airbnb.lottie.e.a.c;

final class ag {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f6022a = c.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6023b = c.a.a("n", "v");

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.c.b.p a(com.airbnb.lottie.e.a.c r18, com.airbnb.lottie.d r19) throws java.io.IOException {
        /*
            r0 = r18
            r1 = r19
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r5 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0013:
            boolean r14 = r18.e()
            if (r14 == 0) goto L_0x0104
            com.airbnb.lottie.e.a.c$a r14 = f6022a
            int r14 = r0.a((com.airbnb.lottie.e.a.c.a) r14)
            r15 = 1
            switch(r14) {
                case 0: goto L_0x00fd;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00ee;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00d8;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00c1;
                case 7: goto L_0x00ba;
                case 8: goto L_0x0028;
                default: goto L_0x0023;
            }
        L_0x0023:
            r2 = 0
            r18.m()
            goto L_0x0013
        L_0x0028:
            r18.a()
        L_0x002b:
            boolean r14 = r18.e()
            if (r14 == 0) goto L_0x00a0
            r18.c()
            r4 = 0
            r14 = 0
        L_0x0036:
            boolean r16 = r18.e()
            if (r16 == 0) goto L_0x0057
            com.airbnb.lottie.e.a.c$a r2 = f6023b
            int r2 = r0.a((com.airbnb.lottie.e.a.c.a) r2)
            if (r2 == 0) goto L_0x0052
            if (r2 == r15) goto L_0x004d
            r18.h()
            r18.m()
            goto L_0x0036
        L_0x004d:
            com.airbnb.lottie.c.a.b r4 = com.airbnb.lottie.e.d.a((com.airbnb.lottie.e.a.c) r0, (com.airbnb.lottie.d) r1, (boolean) r15)
            goto L_0x0036
        L_0x0052:
            java.lang.String r14 = r18.i()
            goto L_0x0036
        L_0x0057:
            r18.d()
            int r2 = r14.hashCode()
            r15 = 100
            r17 = r6
            r6 = 2
            if (r2 == r15) goto L_0x0082
            r15 = 103(0x67, float:1.44E-43)
            if (r2 == r15) goto L_0x0078
            r15 = 111(0x6f, float:1.56E-43)
            if (r2 == r15) goto L_0x006e
            goto L_0x008c
        L_0x006e:
            java.lang.String r2 = "o"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x008c
            r2 = 0
            goto L_0x008d
        L_0x0078:
            java.lang.String r2 = "g"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x008c
            r2 = 2
            goto L_0x008d
        L_0x0082:
            java.lang.String r2 = "d"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x008c
            r2 = 1
            goto L_0x008d
        L_0x008c:
            r2 = -1
        L_0x008d:
            if (r2 == 0) goto L_0x009e
            r14 = 1
            if (r2 == r14) goto L_0x0095
            if (r2 == r6) goto L_0x0095
            goto L_0x009a
        L_0x0095:
            r1.m = r14
            r3.add(r4)
        L_0x009a:
            r6 = r17
        L_0x009c:
            r15 = 1
            goto L_0x002b
        L_0x009e:
            r6 = r4
            goto L_0x009c
        L_0x00a0:
            r17 = r6
            r14 = 1
            r18.b()
            int r2 = r3.size()
            if (r2 != r14) goto L_0x00b5
            r2 = 0
            java.lang.Object r4 = r3.get(r2)
            r3.add(r4)
            goto L_0x00b6
        L_0x00b5:
            r2 = 0
        L_0x00b6:
            r6 = r17
            goto L_0x0013
        L_0x00ba:
            r2 = 0
            boolean r13 = r18.j()
            goto L_0x0013
        L_0x00c1:
            r2 = 0
            double r14 = r18.k()
            float r12 = (float) r14
            goto L_0x0013
        L_0x00c9:
            r2 = 0
            com.airbnb.lottie.c.b.p$b[] r4 = com.airbnb.lottie.c.b.p.b.values()
            int r11 = r18.l()
            r14 = 1
            int r11 = r11 - r14
            r11 = r4[r11]
            goto L_0x0013
        L_0x00d8:
            r2 = 0
            r14 = 1
            com.airbnb.lottie.c.b.p$a[] r4 = com.airbnb.lottie.c.b.p.a.values()
            int r10 = r18.l()
            int r10 = r10 - r14
            r10 = r4[r10]
            goto L_0x0013
        L_0x00e7:
            r2 = 0
            com.airbnb.lottie.c.a.d r8 = com.airbnb.lottie.e.d.a(r18, r19)
            goto L_0x0013
        L_0x00ee:
            r2 = 0
            r14 = 1
            com.airbnb.lottie.c.a.b r9 = com.airbnb.lottie.e.d.a((com.airbnb.lottie.e.a.c) r0, (com.airbnb.lottie.d) r1, (boolean) r14)
            goto L_0x0013
        L_0x00f6:
            r2 = 0
            com.airbnb.lottie.c.a.a r7 = com.airbnb.lottie.e.d.d(r18, r19)
            goto L_0x0013
        L_0x00fd:
            r2 = 0
            java.lang.String r5 = r18.i()
            goto L_0x0013
        L_0x0104:
            com.airbnb.lottie.c.b.p r14 = new com.airbnb.lottie.c.b.p
            r0 = r14
            r1 = r5
            r2 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.ag.a(com.airbnb.lottie.e.a.c, com.airbnb.lottie.d):com.airbnb.lottie.c.b.p");
    }
}
