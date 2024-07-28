package com.google.c;

import com.google.c.ac;
import java.io.IOException;

final class e {

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37836a;

        /* renamed from: b  reason: collision with root package name */
        public long f37837b;

        /* renamed from: c  reason: collision with root package name */
        public Object f37838c;

        /* renamed from: d  reason: collision with root package name */
        public final r f37839d;

        a() {
            this.f37839d = r.a();
        }

        a(r rVar) {
            if (rVar != null) {
                this.f37839d = rVar;
                return;
            }
            throw new NullPointerException();
        }
    }

    static int a(byte[] bArr, int i2, a aVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return a((int) b2, bArr, i3, aVar);
        }
        aVar.f37836a = b2;
        return i3;
    }

    static int a(int i2, byte[] bArr, int i3, a aVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            aVar.f37836a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            aVar.f37836a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            aVar.f37836a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            aVar.f37836a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                aVar.f37836a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    static int b(byte[] bArr, int i2, a aVar) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            aVar.f37837b = j;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            int i7 = i6;
            b2 = b3;
            i4 = i7;
        }
        aVar.f37837b = j2;
        return i4;
    }

    static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static long b(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    static double c(byte[] bArr, int i2) {
        return Double.longBitsToDouble(b(bArr, i2));
    }

    static float d(byte[] bArr, int i2) {
        return Float.intBitsToFloat(a(bArr, i2));
    }

    static int c(byte[] bArr, int i2, a aVar) throws ad {
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a;
        if (i3 < 0) {
            throw ad.negativeSize();
        } else if (i3 == 0) {
            aVar.f37838c = "";
            return a2;
        } else {
            aVar.f37838c = new String(bArr, a2, i3, ac.f37697a);
            return a2 + i3;
        }
    }

    static int d(byte[] bArr, int i2, a aVar) throws ad {
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a;
        if (i3 < 0) {
            throw ad.negativeSize();
        } else if (i3 == 0) {
            aVar.f37838c = "";
            return a2;
        } else {
            aVar.f37838c = by.b(bArr, a2, i3);
            return a2 + i3;
        }
    }

    static int e(byte[] bArr, int i2, a aVar) throws ad {
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a;
        if (i3 < 0) {
            throw ad.negativeSize();
        } else if (i3 > bArr.length - a2) {
            throw ad.truncatedMessage();
        } else if (i3 == 0) {
            aVar.f37838c = j.EMPTY;
            return a2;
        } else {
            aVar.f37838c = j.copyFrom(bArr, a2, i3);
            return a2 + i3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(com.google.c.bm r6, byte[] r7, int r8, int r9, com.google.c.e.a r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = a((int) r8, (byte[]) r7, (int) r0, (com.google.c.e.a) r10)
            int r8 = r10.f37836a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.a()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.a(r1, r2, r3, r4, r5)
            r6.d(r9)
            r10.f37838c = r9
            return r8
        L_0x0025:
            com.google.c.ad r6 = com.google.c.ad.truncatedMessage()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.e.a(com.google.c.bm, byte[], int, int, com.google.c.e$a):int");
    }

    static int a(bm bmVar, byte[] bArr, int i2, int i3, int i4, a aVar) throws IOException {
        aw awVar = (aw) bmVar;
        Object a2 = awVar.a();
        int a3 = awVar.a(a2, bArr, i2, i3, i4, aVar);
        awVar.d(a2);
        aVar.f37838c = a2;
        return a3;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, ac.i<?> iVar, a aVar) {
        ab abVar = (ab) iVar;
        int a2 = a(bArr, i3, aVar);
        abVar.c(aVar.f37836a);
        while (a2 < i4) {
            int a3 = a(bArr, a2, aVar);
            if (i2 != aVar.f37836a) {
                break;
            }
            a2 = a(bArr, a3, aVar);
            abVar.c(aVar.f37836a);
        }
        return a2;
    }

    static int b(int i2, byte[] bArr, int i3, int i4, ac.i<?> iVar, a aVar) {
        ab abVar = (ab) iVar;
        int a2 = a(bArr, i3, aVar);
        abVar.c(k.e(aVar.f37836a));
        while (a2 < i4) {
            int a3 = a(bArr, a2, aVar);
            if (i2 != aVar.f37836a) {
                break;
            }
            a2 = a(bArr, a3, aVar);
            abVar.c(k.e(aVar.f37836a));
        }
        return a2;
    }

    static int c(int i2, byte[] bArr, int i3, int i4, ac.i<?> iVar, a aVar) {
        ak akVar = (ak) iVar;
        int b2 = b(bArr, i3, aVar);
        akVar.a(k.a(aVar.f37837b));
        while (b2 < i4) {
            int a2 = a(bArr, b2, aVar);
            if (i2 != aVar.f37836a) {
                break;
            }
            b2 = b(bArr, a2, aVar);
            akVar.a(k.a(aVar.f37837b));
        }
        return b2;
    }

    static int a(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        ab abVar = (ab) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, aVar);
            abVar.c(aVar.f37836a);
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int b(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        ak akVar = (ak) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            a2 = b(bArr, a2, aVar);
            akVar.a(aVar.f37837b);
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int c(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        ab abVar = (ab) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            abVar.c(a(bArr, a2));
            a2 += 4;
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int d(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        ak akVar = (ak) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            akVar.a(b(bArr, a2));
            a2 += 8;
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int e(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        y yVar = (y) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            yVar.a(d(bArr, a2));
            a2 += 4;
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int f(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        o oVar = (o) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            oVar.a(c(bArr, a2));
            a2 += 8;
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int g(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        g gVar = (g) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            a2 = b(bArr, a2, aVar);
            gVar.a(aVar.f37837b != 0);
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int h(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        ab abVar = (ab) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, aVar);
            abVar.c(k.e(aVar.f37836a));
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    static int i(byte[] bArr, int i2, ac.i<?> iVar, a aVar) throws IOException {
        ak akVar = (ak) iVar;
        int a2 = a(bArr, i2, aVar);
        int i3 = aVar.f37836a + a2;
        while (a2 < i3) {
            a2 = b(bArr, a2, aVar);
            akVar.a(k.a(aVar.f37837b));
        }
        if (a2 == i3) {
            return a2;
        }
        throw ad.truncatedMessage();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (com.google.c.by.a(r6, r7, r2) == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r9.add(new java.lang.String(r6, r7, r0, com.google.c.ac.f37697a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        throw com.google.c.ad.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[EDGE_INSN: B:28:0x0058->B:23:0x0058 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int d(int r5, byte[] r6, int r7, int r8, com.google.c.ac.i<?> r9, com.google.c.e.a r10) throws com.google.c.ad {
        /*
            int r7 = a(r6, r7, r10)
            int r0 = r10.f37836a
            if (r0 < 0) goto L_0x005e
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = com.google.c.by.a((byte[]) r6, (int) r7, (int) r2)
            if (r3 == 0) goto L_0x0059
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.c.ac.f37697a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0058
            int r0 = a(r6, r7, r10)
            int r2 = r10.f37836a
            if (r5 != r2) goto L_0x0058
            int r7 = a(r6, r0, r10)
            int r0 = r10.f37836a
            if (r0 < 0) goto L_0x0053
            if (r0 != 0) goto L_0x003b
            r9.add(r1)
            goto L_0x0023
        L_0x003b:
            int r2 = r7 + r0
            boolean r3 = com.google.c.by.a((byte[]) r6, (int) r7, (int) r2)
            if (r3 == 0) goto L_0x004e
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.c.ac.f37697a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004e:
            com.google.c.ad r5 = com.google.c.ad.invalidUtf8()
            throw r5
        L_0x0053:
            com.google.c.ad r5 = com.google.c.ad.negativeSize()
            throw r5
        L_0x0058:
            return r7
        L_0x0059:
            com.google.c.ad r5 = com.google.c.ad.invalidUtf8()
            throw r5
        L_0x005e:
            com.google.c.ad r5 = com.google.c.ad.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.e.d(int, byte[], int, int, com.google.c.ac$i, com.google.c.e$a):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[EDGE_INSN: B:30:0x004c->B:22:0x004c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int e(int r2, byte[] r3, int r4, int r5, com.google.c.ac.i<?> r6, com.google.c.e.a r7) throws com.google.c.ad {
        /*
            int r4 = a(r3, r4, r7)
            int r0 = r7.f37836a
            if (r0 < 0) goto L_0x0052
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004d
            if (r0 != 0) goto L_0x0014
            com.google.c.j r0 = com.google.c.j.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            com.google.c.j r1 = com.google.c.j.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004c
            int r0 = a(r3, r4, r7)
            int r1 = r7.f37836a
            if (r2 != r1) goto L_0x004c
            int r4 = a(r3, r0, r7)
            int r0 = r7.f37836a
            if (r0 < 0) goto L_0x0047
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0042
            if (r0 != 0) goto L_0x003a
            com.google.c.j r0 = com.google.c.j.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003a:
            com.google.c.j r1 = com.google.c.j.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0042:
            com.google.c.ad r2 = com.google.c.ad.truncatedMessage()
            throw r2
        L_0x0047:
            com.google.c.ad r2 = com.google.c.ad.negativeSize()
            throw r2
        L_0x004c:
            return r4
        L_0x004d:
            com.google.c.ad r2 = com.google.c.ad.truncatedMessage()
            throw r2
        L_0x0052:
            com.google.c.ad r2 = com.google.c.ad.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.e.e(int, byte[], int, int, com.google.c.ac$i, com.google.c.e$a):int");
    }

    static int a(bm<?> bmVar, int i2, byte[] bArr, int i3, int i4, ac.i<?> iVar, a aVar) throws IOException {
        int a2 = a((bm) bmVar, bArr, i3, i4, aVar);
        iVar.add(aVar.f37838c);
        while (a2 < i4) {
            int a3 = a(bArr, a2, aVar);
            if (i2 != aVar.f37836a) {
                break;
            }
            a2 = a((bm) bmVar, bArr, a3, i4, aVar);
            iVar.add(aVar.f37838c);
        }
        return a2;
    }

    static int b(bm bmVar, int i2, byte[] bArr, int i3, int i4, ac.i<?> iVar, a aVar) throws IOException {
        int i5 = (i2 & -8) | 4;
        int a2 = a(bmVar, bArr, i3, i4, i5, aVar);
        iVar.add(aVar.f37838c);
        while (a2 < i4) {
            int a3 = a(bArr, a2, aVar);
            if (i2 != aVar.f37836a) {
                break;
            }
            a2 = a(bmVar, bArr, a3, i4, i5, aVar);
            iVar.add(aVar.f37838c);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01cf, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01db, code lost:
        r9 = r9 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01fd, code lost:
        if (r9 != 18) goto L_0x020c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(int r7, byte[] r8, int r9, int r10, java.lang.Object r11, com.google.c.at r12, com.google.c.bt<com.google.c.bu, com.google.c.bu> r13, com.google.c.e.a r14) throws java.io.IOException {
        /*
            int r0 = r7 >>> 3
            com.google.c.r r1 = r14.f37839d
            com.google.c.aa$f r12 = r1.a(r12, r0)
            if (r12 != 0) goto L_0x0018
            com.google.c.bu r5 = com.google.c.aw.c((java.lang.Object) r11)
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r7 = a((int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.c.bu) r5, (com.google.c.e.a) r6)
            return r7
        L_0x0018:
            com.google.c.aa$c r11 = (com.google.c.aa.c) r11
            r11.a()
            com.google.c.w<com.google.c.aa$e> r7 = r11.f37686a
            com.google.c.aa$e r1 = r12.f37693b
            boolean r1 = r1.f37690d
            r2 = 0
            if (r1 == 0) goto L_0x00dd
            com.google.c.aa$e r1 = r12.f37693b
            boolean r1 = r1.f37691e
            if (r1 == 0) goto L_0x00dd
            int[] r10 = com.google.c.e.AnonymousClass1.f37835a
            com.google.c.aa$e r1 = r12.f37693b
            com.google.c.bz$a r1 = r1.f37689c
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00d2;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00bc;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00b1;
                case 6: goto L_0x00b1;
                case 7: goto L_0x00a6;
                case 8: goto L_0x00a6;
                case 9: goto L_0x009b;
                case 10: goto L_0x009b;
                case 11: goto L_0x0090;
                case 12: goto L_0x0085;
                case 13: goto L_0x007a;
                case 14: goto L_0x0053;
                default: goto L_0x003b;
            }
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Type cannot be packed: "
            r8.<init>(r9)
            com.google.c.aa$e r9 = r12.f37693b
            com.google.c.bz$a r9 = r9.f37689c
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0053:
            com.google.c.ab r10 = new com.google.c.ab
            r10.<init>()
            int r8 = a((byte[]) r8, (int) r9, (com.google.c.ac.i<?>) r10, (com.google.c.e.a) r14)
            com.google.c.bu r9 = r11.f37680e
            com.google.c.bu r14 = com.google.c.bu.a()
            if (r9 != r14) goto L_0x0065
            r9 = r2
        L_0x0065:
            com.google.c.aa$e r14 = r12.f37693b
            com.google.c.ac$d<?> r14 = r14.f37687a
            java.lang.Object r9 = com.google.c.bo.a((int) r0, (java.util.List<java.lang.Integer>) r10, (com.google.c.ac.d<?>) r14, r9, r13)
            com.google.c.bu r9 = (com.google.c.bu) r9
            if (r9 == 0) goto L_0x0073
            r11.f37680e = r9
        L_0x0073:
            com.google.c.aa$e r9 = r12.f37693b
            r7.a(r9, (java.lang.Object) r10)
            goto L_0x0211
        L_0x007a:
            com.google.c.ak r10 = new com.google.c.ak
            r10.<init>()
            int r8 = i(r8, r9, r10, r14)
            goto L_0x020c
        L_0x0085:
            com.google.c.ab r10 = new com.google.c.ab
            r10.<init>()
            int r8 = h(r8, r9, r10, r14)
            goto L_0x020c
        L_0x0090:
            com.google.c.g r10 = new com.google.c.g
            r10.<init>()
            int r8 = g(r8, r9, r10, r14)
            goto L_0x020c
        L_0x009b:
            com.google.c.ab r10 = new com.google.c.ab
            r10.<init>()
            int r8 = c(r8, r9, r10, r14)
            goto L_0x020c
        L_0x00a6:
            com.google.c.ak r10 = new com.google.c.ak
            r10.<init>()
            int r8 = d(r8, r9, r10, r14)
            goto L_0x020c
        L_0x00b1:
            com.google.c.ab r10 = new com.google.c.ab
            r10.<init>()
            int r8 = a((byte[]) r8, (int) r9, (com.google.c.ac.i<?>) r10, (com.google.c.e.a) r14)
            goto L_0x020c
        L_0x00bc:
            com.google.c.ak r10 = new com.google.c.ak
            r10.<init>()
            int r8 = b(r8, r9, r10, r14)
            goto L_0x020c
        L_0x00c7:
            com.google.c.y r10 = new com.google.c.y
            r10.<init>()
            int r8 = e(r8, r9, r10, r14)
            goto L_0x020c
        L_0x00d2:
            com.google.c.o r10 = new com.google.c.o
            r10.<init>()
            int r8 = f(r8, r9, r10, r14)
            goto L_0x020c
        L_0x00dd:
            com.google.c.aa$e r1 = r12.f37693b
            com.google.c.bz$a r1 = r1.f37689c
            com.google.c.bz$a r3 = com.google.c.bz.a.ENUM
            if (r1 != r3) goto L_0x0110
            int r9 = a(r8, r9, r14)
            com.google.c.aa$e r8 = r12.f37693b
            com.google.c.ac$d<?> r8 = r8.f37687a
            com.google.c.ac$c r8 = r8.a()
            if (r8 != 0) goto L_0x0109
            com.google.c.bu r7 = r11.f37680e
            com.google.c.bu r8 = com.google.c.bu.a()
            if (r7 != r8) goto L_0x0101
            com.google.c.bu r7 = com.google.c.bu.b()
            r11.f37680e = r7
        L_0x0101:
            int r8 = r14.f37836a
            com.google.c.bo.a((int) r0, (int) r8, r7, r13)
            r8 = r9
            goto L_0x0211
        L_0x0109:
            int r8 = r14.f37836a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x011f
        L_0x0110:
            int[] r11 = com.google.c.e.AnonymousClass1.f37835a
            com.google.c.aa$e r13 = r12.f37693b
            com.google.c.bz$a r13 = r13.f37689c
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01d3;
                case 2: goto L_0x01c7;
                case 3: goto L_0x01bb;
                case 4: goto L_0x01bb;
                case 5: goto L_0x01af;
                case 6: goto L_0x01af;
                case 7: goto L_0x01a6;
                case 8: goto L_0x01a6;
                case 9: goto L_0x019d;
                case 10: goto L_0x019d;
                case 11: goto L_0x0189;
                case 12: goto L_0x017a;
                case 13: goto L_0x016b;
                case 14: goto L_0x0163;
                case 15: goto L_0x015c;
                case 16: goto L_0x0155;
                case 17: goto L_0x0138;
                case 18: goto L_0x0123;
                default: goto L_0x011f;
            }
        L_0x011f:
            r8 = r9
            r10 = r2
            goto L_0x01df
        L_0x0123:
            com.google.c.bg r11 = com.google.c.bg.a()
            com.google.c.at r13 = r12.f37692a
            java.lang.Class r13 = r13.getClass()
            com.google.c.bm r11 = r11.a(r13)
            int r9 = a((com.google.c.bm) r11, (byte[]) r8, (int) r9, (int) r10, (com.google.c.e.a) r14)
            java.lang.Object r2 = r14.f37838c
            goto L_0x011f
        L_0x0138:
            int r11 = r0 << 3
            r4 = r11 | 4
            com.google.c.bg r11 = com.google.c.bg.a()
            com.google.c.at r13 = r12.f37692a
            java.lang.Class r13 = r13.getClass()
            com.google.c.bm r0 = r11.a(r13)
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r14
            int r9 = a((com.google.c.bm) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.c.e.a) r5)
            java.lang.Object r2 = r14.f37838c
            goto L_0x011f
        L_0x0155:
            int r9 = c(r8, r9, r14)
            java.lang.Object r2 = r14.f37838c
            goto L_0x011f
        L_0x015c:
            int r9 = e(r8, r9, r14)
            java.lang.Object r2 = r14.f37838c
            goto L_0x011f
        L_0x0163:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x016b:
            int r9 = b(r8, r9, r14)
            long r10 = r14.f37837b
            long r10 = com.google.c.k.a((long) r10)
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            goto L_0x011f
        L_0x017a:
            int r9 = a(r8, r9, r14)
            int r8 = r14.f37836a
            int r8 = com.google.c.k.e(r8)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x011f
        L_0x0189:
            int r9 = b(r8, r9, r14)
            long r10 = r14.f37837b
            r13 = 0
            int r8 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x0197
            r8 = 1
            goto L_0x0198
        L_0x0197:
            r8 = 0
        L_0x0198:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            goto L_0x011f
        L_0x019d:
            int r8 = a(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x01cf
        L_0x01a6:
            long r10 = b(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            goto L_0x01db
        L_0x01af:
            int r9 = a(r8, r9, r14)
            int r8 = r14.f37836a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x011f
        L_0x01bb:
            int r9 = b(r8, r9, r14)
            long r10 = r14.f37837b
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            goto L_0x011f
        L_0x01c7:
            float r8 = d(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r8)
        L_0x01cf:
            int r9 = r9 + 4
            goto L_0x011f
        L_0x01d3:
            double r10 = c(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r10)
        L_0x01db:
            int r9 = r9 + 8
            goto L_0x011f
        L_0x01df:
            com.google.c.aa$e r9 = r12.f37693b
            boolean r9 = r9.f37690d
            if (r9 == 0) goto L_0x01eb
            com.google.c.aa$e r9 = r12.f37693b
            r7.b(r9, (java.lang.Object) r10)
            goto L_0x0211
        L_0x01eb:
            int[] r9 = com.google.c.e.AnonymousClass1.f37835a
            com.google.c.aa$e r11 = r12.f37693b
            com.google.c.bz$a r11 = r11.f37689c
            int r11 = r11.ordinal()
            r9 = r9[r11]
            r11 = 17
            if (r9 == r11) goto L_0x0200
            r11 = 18
            if (r9 == r11) goto L_0x0200
            goto L_0x020c
        L_0x0200:
            com.google.c.aa$e r9 = r12.f37693b
            java.lang.Object r9 = r7.a(r9)
            if (r9 == 0) goto L_0x020c
            java.lang.Object r10 = com.google.c.ac.a((java.lang.Object) r9, (java.lang.Object) r10)
        L_0x020c:
            com.google.c.aa$e r9 = r12.f37693b
            r7.a(r9, (java.lang.Object) r10)
        L_0x0211:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.e.a(int, byte[], int, int, java.lang.Object, com.google.c.at, com.google.c.bt, com.google.c.e$a):int");
    }

    static int a(int i2, byte[] bArr, int i3, int i4, bu buVar, a aVar) throws ad {
        if (bz.b(i2) != 0) {
            int a2 = bz.a(i2);
            if (a2 == 0) {
                int b2 = b(bArr, i3, aVar);
                buVar.a(i2, (Object) Long.valueOf(aVar.f37837b));
                return b2;
            } else if (a2 == 1) {
                buVar.a(i2, (Object) Long.valueOf(b(bArr, i3)));
                return i3 + 8;
            } else if (a2 == 2) {
                int a3 = a(bArr, i3, aVar);
                int i5 = aVar.f37836a;
                if (i5 < 0) {
                    throw ad.negativeSize();
                } else if (i5 <= bArr.length - a3) {
                    if (i5 == 0) {
                        buVar.a(i2, (Object) j.EMPTY);
                    } else {
                        buVar.a(i2, (Object) j.copyFrom(bArr, a3, i5));
                    }
                    return a3 + i5;
                } else {
                    throw ad.truncatedMessage();
                }
            } else if (a2 == 3) {
                bu b3 = bu.b();
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int a4 = a(bArr, i3, aVar);
                    int i8 = aVar.f37836a;
                    i7 = i8;
                    if (i8 == i6) {
                        i3 = a4;
                        break;
                    }
                    int a5 = a(i7, bArr, a4, i4, b3, aVar);
                    i7 = i8;
                    i3 = a5;
                }
                if (i3 > i4 || i7 != i6) {
                    throw ad.parseFailure();
                }
                buVar.a(i2, (Object) b3);
                return i3;
            } else if (a2 == 5) {
                buVar.a(i2, (Object) Integer.valueOf(a(bArr, i3)));
                return i3 + 4;
            } else {
                throw ad.invalidTag();
            }
        } else {
            throw ad.invalidTag();
        }
    }

    static int a(int i2, byte[] bArr, int i3, int i4, a aVar) throws ad {
        if (bz.b(i2) != 0) {
            int a2 = bz.a(i2);
            if (a2 == 0) {
                return b(bArr, i3, aVar);
            }
            if (a2 == 1) {
                return i3 + 8;
            }
            if (a2 == 2) {
                return a(bArr, i3, aVar) + aVar.f37836a;
            }
            if (a2 == 3) {
                int i5 = (i2 & -8) | 4;
                int i6 = 0;
                while (i3 < i4) {
                    i3 = a(bArr, i3, aVar);
                    i6 = aVar.f37836a;
                    if (i6 == i5) {
                        break;
                    }
                    i3 = a(i6, bArr, i3, i4, aVar);
                }
                if (i3 <= i4 && i6 == i5) {
                    return i3;
                }
                throw ad.parseFailure();
            } else if (a2 == 5) {
                return i3 + 4;
            } else {
                throw ad.invalidTag();
            }
        } else {
            throw ad.invalidTag();
        }
    }
}
