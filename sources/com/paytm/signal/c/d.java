package com.paytm.signal.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private long f43631a;

    /* renamed from: b  reason: collision with root package name */
    private long f43632b;

    /* renamed from: c  reason: collision with root package name */
    private long f43633c;

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0119 A[SYNTHETIC, Splitter:B:51:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121 A[SYNTHETIC, Splitter:B:57:0x0121] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = 0
            r3 = 0
            java.net.DatagramSocket r4 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            r4.<init>()     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            r0 = 6000(0x1770, float:8.408E-42)
            r4.setSoTimeout(r0)     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r21)     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            r3 = 48
            byte[] r5 = new byte[r3]     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            r7 = 123(0x7b, float:1.72E-43)
            r6.<init>(r5, r3, r0, r7)     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            r0 = 27
            r5[r2] = r0     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00fa, all -> 0x00f3 }
            r11 = 1000(0x3e8, double:4.94E-321)
            long r13 = r7 / r11
            java.lang.Long.signum(r13)
            long r15 = r13 * r11
            long r15 = r7 - r15
            r17 = 2208988800(0x83aa7e80, double:1.091385478E-314)
            long r13 = r13 + r17
            r0 = 24
            r17 = r4
            long r3 = r13 >> r0
            int r4 = (int) r3
            byte r3 = (byte) r4
            r4 = 40
            r5[r4] = r3     // Catch:{ Exception -> 0x00ee, all -> 0x00e9 }
            r3 = 41
            r18 = 16
            long r0 = r13 >> r18
            int r1 = (int) r0
            byte r0 = (byte) r1
            r5[r3] = r0     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r0 = 42
            r1 = 8
            long r11 = r13 >> r1
            int r3 = (int) r11     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r5[r0] = r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r0 = 43
            long r11 = r13 >> r2
            int r3 = (int) r11     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r5[r0] = r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r11 = 4294967296(0x100000000, double:2.121995791E-314)
            long r15 = r15 * r11
            r11 = 1000(0x3e8, double:4.94E-321)
            long r15 = r15 / r11
            r0 = 44
            r3 = 24
            long r11 = r15 >> r3
            int r3 = (int) r11     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r5[r0] = r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r0 = 45
            long r11 = r15 >> r18
            int r3 = (int) r11     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r5[r0] = r3     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r0 = 46
            long r11 = r15 >> r1
            int r1 = (int) r11     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r0 = 47
            double r11 = java.lang.Math.random()     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r13 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r11 = r11 * r13
            int r1 = (int) r11     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e5, all -> 0x00e1 }
            r1 = r17
            r1.send(r6)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r3 = 48
            r0.<init>(r5, r3)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r1.receive(r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            long r9 = r11 - r9
            long r7 = r7 + r9
            r0 = 24
            long r13 = b(r5, r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r0 = 32
            long r15 = b(r5, r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            long r3 = b(r5, r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            long r5 = r3 - r15
            long r9 = r9 - r5
            long r15 = r15 - r13
            long r3 = r3 - r7
            long r15 = r15 + r3
            r3 = 2
            long r15 = r15 / r3
            long r7 = r7 + r15
            r4 = r20
            r4.f43631a = r7     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            r4.f43632b = r11     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            r4.f43633c = r9     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            r1.close()     // Catch:{ Exception -> 0x00d3 }
        L_0x00d3:
            r0 = 1
            return r0
        L_0x00d5:
            r0 = move-exception
            goto L_0x011f
        L_0x00d7:
            r0 = move-exception
            goto L_0x0100
        L_0x00d9:
            r0 = move-exception
            r4 = r20
            goto L_0x011f
        L_0x00dd:
            r0 = move-exception
            r4 = r20
            goto L_0x0100
        L_0x00e1:
            r0 = move-exception
            r4 = r20
            goto L_0x00eb
        L_0x00e5:
            r0 = move-exception
            r4 = r20
            goto L_0x00f0
        L_0x00e9:
            r0 = move-exception
            r4 = r1
        L_0x00eb:
            r1 = r17
            goto L_0x011f
        L_0x00ee:
            r0 = move-exception
            r4 = r1
        L_0x00f0:
            r1 = r17
            goto L_0x0100
        L_0x00f3:
            r0 = move-exception
            r19 = r4
            r4 = r1
            r1 = r19
            goto L_0x011f
        L_0x00fa:
            r0 = move-exception
            r19 = r4
            r4 = r1
            r1 = r19
        L_0x0100:
            r3 = r1
            goto L_0x0108
        L_0x0102:
            r0 = move-exception
            r4 = r1
        L_0x0104:
            r1 = r3
            goto L_0x011f
        L_0x0106:
            r0 = move-exception
            r4 = r1
        L_0x0108:
            java.lang.String r1 = "request time failed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x011d }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x011d }
            com.paytm.notification.b.e.a(r0, r1)     // Catch:{ all -> 0x011d }
            if (r3 == 0) goto L_0x011c
            r3.close()     // Catch:{ Exception -> 0x011c }
        L_0x011c:
            return r2
        L_0x011d:
            r0 = move-exception
            goto L_0x0104
        L_0x011f:
            if (r1 == 0) goto L_0x0124
            r1.close()     // Catch:{ Exception -> 0x0124 }
        L_0x0124:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.c.d.a(java.lang.String):boolean");
    }

    public final long a() {
        return this.f43631a;
    }

    private static long a(byte[] bArr, int i2) {
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        byte b4 = bArr[i2 + 2];
        byte b5 = bArr[i2 + 3];
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + 128;
        }
        byte b9 = b5 & true;
        int i6 = b5;
        if (b9 == true) {
            i6 = (b5 & Byte.MAX_VALUE) + 128;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }

    private static long b(byte[] bArr, int i2) {
        return ((a(bArr, i2) - 2208988800L) * 1000) + ((a(bArr, i2 + 4) * 1000) / 4294967296L);
    }
}
