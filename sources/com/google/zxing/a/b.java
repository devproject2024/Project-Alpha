package com.google.zxing.a;

import com.google.zxing.p;

public final class b implements p {
    public final void a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a A[LOOP:0: B:29:0x0058->B:30:0x005a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.r a(com.google.zxing.c r13, java.util.Map<com.google.zxing.e, ?> r14) throws com.google.zxing.m, com.google.zxing.h {
        /*
            r12 = this;
            com.google.zxing.a.b.a r0 = new com.google.zxing.a.b.a
            com.google.zxing.b.b r13 = r13.b()
            r0.<init>(r13)
            r13 = 0
            r1 = 0
            com.google.zxing.a.a r2 = r0.a((boolean) r13)     // Catch:{ m -> 0x0029, h -> 0x0023 }
            com.google.zxing.t[] r3 = r2.f39920e     // Catch:{ m -> 0x0029, h -> 0x0023 }
            com.google.zxing.a.a.a r4 = new com.google.zxing.a.a.a     // Catch:{ m -> 0x0021, h -> 0x001f }
            r4.<init>()     // Catch:{ m -> 0x0021, h -> 0x001f }
            com.google.zxing.b.e r2 = r4.a((com.google.zxing.a.a) r2)     // Catch:{ m -> 0x0021, h -> 0x001f }
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x002d
        L_0x001f:
            r2 = move-exception
            goto L_0x0025
        L_0x0021:
            r2 = move-exception
            goto L_0x002b
        L_0x0023:
            r2 = move-exception
            r3 = r1
        L_0x0025:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x002d
        L_0x0029:
            r2 = move-exception
            r3 = r1
        L_0x002b:
            r4 = r3
            r3 = r1
        L_0x002d:
            if (r1 != 0) goto L_0x004a
            r1 = 1
            com.google.zxing.a.a r0 = r0.a((boolean) r1)     // Catch:{ m -> 0x0042, h -> 0x0040 }
            com.google.zxing.t[] r4 = r0.f39920e     // Catch:{ m -> 0x0042, h -> 0x0040 }
            com.google.zxing.a.a.a r1 = new com.google.zxing.a.a.a     // Catch:{ m -> 0x0042, h -> 0x0040 }
            r1.<init>()     // Catch:{ m -> 0x0042, h -> 0x0040 }
            com.google.zxing.b.e r1 = r1.a((com.google.zxing.a.a) r0)     // Catch:{ m -> 0x0042, h -> 0x0040 }
            goto L_0x004a
        L_0x0040:
            r13 = move-exception
            goto L_0x0043
        L_0x0042:
            r13 = move-exception
        L_0x0043:
            if (r2 != 0) goto L_0x0049
            if (r3 == 0) goto L_0x0048
            throw r3
        L_0x0048:
            throw r13
        L_0x0049:
            throw r2
        L_0x004a:
            r8 = r4
            if (r14 == 0) goto L_0x0062
            com.google.zxing.e r0 = com.google.zxing.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r14 = r14.get(r0)
            com.google.zxing.u r14 = (com.google.zxing.u) r14
            if (r14 == 0) goto L_0x0062
            int r0 = r8.length
        L_0x0058:
            if (r13 >= r0) goto L_0x0062
            r2 = r8[r13]
            r14.a(r2)
            int r13 = r13 + 1
            goto L_0x0058
        L_0x0062:
            com.google.zxing.r r13 = new com.google.zxing.r
            java.lang.String r5 = r1.f39912c
            byte[] r6 = r1.f39910a
            int r7 = r1.f39911b
            com.google.zxing.a r9 = com.google.zxing.a.AZTEC
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            java.util.List<byte[]> r14 = r1.f39913d
            if (r14 == 0) goto L_0x007d
            com.google.zxing.s r0 = com.google.zxing.s.BYTE_SEGMENTS
            r13.a(r0, r14)
        L_0x007d:
            java.lang.String r14 = r1.f39914e
            if (r14 == 0) goto L_0x0086
            com.google.zxing.s r0 = com.google.zxing.s.ERROR_CORRECTION_LEVEL
            r13.a(r0, r14)
        L_0x0086:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.a.b.a(com.google.zxing.c, java.util.Map):com.google.zxing.r");
    }
}
