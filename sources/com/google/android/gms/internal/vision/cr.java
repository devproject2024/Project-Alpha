package com.google.android.gms.internal.vision;

import java.io.IOException;

final class cr {
    static int a(byte[] bArr, int i2, ct ctVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return a((int) b2, bArr, i3, ctVar);
        }
        ctVar.f11017a = b2;
        return i3;
    }

    static int a(int i2, byte[] bArr, int i3, ct ctVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            ctVar.f11017a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            ctVar.f11017a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            ctVar.f11017a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            ctVar.f11017a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                ctVar.f11017a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    static int b(byte[] bArr, int i2, ct ctVar) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            ctVar.f11018b = j;
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
        ctVar.f11018b = j2;
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

    static int c(byte[] bArr, int i2, ct ctVar) throws eu {
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a;
        if (i3 < 0) {
            throw eu.zzgn();
        } else if (i3 == 0) {
            ctVar.f11019c = "";
            return a2;
        } else {
            ctVar.f11019c = new String(bArr, a2, i3, ek.f11111a);
            return a2 + i3;
        }
    }

    static int d(byte[] bArr, int i2, ct ctVar) throws eu {
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a;
        if (i3 < 0) {
            throw eu.zzgn();
        } else if (i3 == 0) {
            ctVar.f11019c = "";
            return a2;
        } else {
            ctVar.f11019c = hj.b(bArr, a2, i3);
            return a2 + i3;
        }
    }

    static int e(byte[] bArr, int i2, ct ctVar) throws eu {
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a;
        if (i3 < 0) {
            throw eu.zzgn();
        } else if (i3 > bArr.length - a2) {
            throw eu.zzgm();
        } else if (i3 == 0) {
            ctVar.f11019c = cz.zzsd;
            return a2;
        } else {
            ctVar.f11019c = cz.zza(bArr, a2, i3);
            return a2 + i3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(com.google.android.gms.internal.vision.gi r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.vision.ct r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = a((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.vision.ct) r10)
            int r8 = r10.f11017a
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
            r6.c(r9)
            r10.f11019c = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.vision.eu r6 = com.google.android.gms.internal.vision.eu.zzgm()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.cr.a(com.google.android.gms.internal.vision.gi, byte[], int, int, com.google.android.gms.internal.vision.ct):int");
    }

    static int a(gi giVar, byte[] bArr, int i2, int i3, int i4, ct ctVar) throws IOException {
        fx fxVar = (fx) giVar;
        Object a2 = fxVar.a();
        int a3 = fxVar.a(a2, bArr, i2, i3, i4, ctVar);
        fxVar.c(a2);
        ctVar.f11019c = a2;
        return a3;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, eq<?> eqVar, ct ctVar) {
        el elVar = (el) eqVar;
        int a2 = a(bArr, i3, ctVar);
        elVar.c(ctVar.f11017a);
        while (a2 < i4) {
            int a3 = a(bArr, a2, ctVar);
            if (i2 != ctVar.f11017a) {
                break;
            }
            a2 = a(bArr, a3, ctVar);
            elVar.c(ctVar.f11017a);
        }
        return a2;
    }

    static int a(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        el elVar = (el) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, ctVar);
            elVar.c(ctVar.f11017a);
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int b(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        fg fgVar = (fg) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            a2 = b(bArr, a2, ctVar);
            fgVar.a(ctVar.f11018b);
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int c(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        el elVar = (el) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            elVar.c(a(bArr, a2));
            a2 += 4;
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int d(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        fg fgVar = (fg) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            fgVar.a(b(bArr, a2));
            a2 += 8;
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int e(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        ef efVar = (ef) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            efVar.a(d(bArr, a2));
            a2 += 4;
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int f(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        ds dsVar = (ds) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            dsVar.a(c(bArr, a2));
            a2 += 8;
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int g(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        cx cxVar = (cx) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            a2 = b(bArr, a2, ctVar);
            cxVar.a(ctVar.f11018b != 0);
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int h(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        el elVar = (el) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, ctVar);
            elVar.c(dl.e(ctVar.f11017a));
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int i(byte[] bArr, int i2, eq<?> eqVar, ct ctVar) throws IOException {
        fg fgVar = (fg) eqVar;
        int a2 = a(bArr, i2, ctVar);
        int i3 = ctVar.f11017a + a2;
        while (a2 < i3) {
            a2 = b(bArr, a2, ctVar);
            fgVar.a(dl.a(ctVar.f11018b));
        }
        if (a2 == i3) {
            return a2;
        }
        throw eu.zzgm();
    }

    static int a(gi<?> giVar, int i2, byte[] bArr, int i3, int i4, eq<?> eqVar, ct ctVar) throws IOException {
        int a2 = a((gi) giVar, bArr, i3, i4, ctVar);
        eqVar.add(ctVar.f11019c);
        while (a2 < i4) {
            int a3 = a(bArr, a2, ctVar);
            if (i2 != ctVar.f11017a) {
                break;
            }
            a2 = a((gi) giVar, bArr, a3, i4, ctVar);
            eqVar.add(ctVar.f11019c);
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, hd hdVar, ct ctVar) throws eu {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int b2 = b(bArr, i3, ctVar);
                hdVar.a(i2, (Object) Long.valueOf(ctVar.f11018b));
                return b2;
            } else if (i5 == 1) {
                hdVar.a(i2, (Object) Long.valueOf(b(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int a2 = a(bArr, i3, ctVar);
                int i6 = ctVar.f11017a;
                if (i6 < 0) {
                    throw eu.zzgn();
                } else if (i6 <= bArr.length - a2) {
                    if (i6 == 0) {
                        hdVar.a(i2, (Object) cz.zzsd);
                    } else {
                        hdVar.a(i2, (Object) cz.zza(bArr, a2, i6));
                    }
                    return a2 + i6;
                } else {
                    throw eu.zzgm();
                }
            } else if (i5 == 3) {
                hd b3 = hd.b();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int a3 = a(bArr, i3, ctVar);
                    int i9 = ctVar.f11017a;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = a3;
                        break;
                    }
                    int a4 = a(i8, bArr, a3, i4, b3, ctVar);
                    i8 = i9;
                    i3 = a4;
                }
                if (i3 > i4 || i8 != i7) {
                    throw eu.zzgs();
                }
                hdVar.a(i2, (Object) b3);
                return i3;
            } else if (i5 == 5) {
                hdVar.a(i2, (Object) Integer.valueOf(a(bArr, i3)));
                return i3 + 4;
            } else {
                throw eu.zzgp();
            }
        } else {
            throw eu.zzgp();
        }
    }

    static int a(int i2, byte[] bArr, int i3, int i4, ct ctVar) throws eu {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return b(bArr, i3, ctVar);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return a(bArr, i3, ctVar) + ctVar.f11017a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = a(bArr, i3, ctVar);
                    i7 = ctVar.f11017a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = a(i7, bArr, i3, i4, ctVar);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw eu.zzgs();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw eu.zzgp();
            }
        } else {
            throw eu.zzgp();
        }
    }
}
