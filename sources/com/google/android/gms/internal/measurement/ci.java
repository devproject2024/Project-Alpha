package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class ci {
    static int a(byte[] bArr, int i2, cl clVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return a((int) b2, bArr, i3, clVar);
        }
        clVar.f10529a = b2;
        return i3;
    }

    static int a(int i2, byte[] bArr, int i3, cl clVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            clVar.f10529a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            clVar.f10529a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            clVar.f10529a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            clVar.f10529a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                clVar.f10529a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    static int b(byte[] bArr, int i2, cl clVar) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            clVar.f10530b = j;
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
        clVar.f10530b = j2;
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

    static int c(byte[] bArr, int i2, cl clVar) throws eg {
        int a2 = a(bArr, i2, clVar);
        int i3 = clVar.f10529a;
        if (i3 < 0) {
            throw eg.zzb();
        } else if (i3 == 0) {
            clVar.f10531c = "";
            return a2;
        } else {
            clVar.f10531c = new String(bArr, a2, i3, dx.f10606a);
            return a2 + i3;
        }
    }

    static int d(byte[] bArr, int i2, cl clVar) throws eg {
        int a2 = a(bArr, i2, clVar);
        int i3 = clVar.f10529a;
        if (i3 < 0) {
            throw eg.zzb();
        } else if (i3 == 0) {
            clVar.f10531c = "";
            return a2;
        } else {
            clVar.f10531c = gw.b(bArr, a2, i3);
            return a2 + i3;
        }
    }

    static int e(byte[] bArr, int i2, cl clVar) throws eg {
        int a2 = a(bArr, i2, clVar);
        int i3 = clVar.f10529a;
        if (i3 < 0) {
            throw eg.zzb();
        } else if (i3 > bArr.length - a2) {
            throw eg.zza();
        } else if (i3 == 0) {
            clVar.f10531c = cm.zza;
            return a2;
        } else {
            clVar.f10531c = cm.zza(bArr, a2, i3);
            return a2 + i3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(com.google.android.gms.internal.measurement.fv r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.cl r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = a((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.measurement.cl) r10)
            int r8 = r10.f10529a
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
            r10.f10531c = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.eg r6 = com.google.android.gms.internal.measurement.eg.zza()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ci.a(com.google.android.gms.internal.measurement.fv, byte[], int, int, com.google.android.gms.internal.measurement.cl):int");
    }

    static int a(fv fvVar, byte[] bArr, int i2, int i3, int i4, cl clVar) throws IOException {
        fj fjVar = (fj) fvVar;
        Object a2 = fjVar.a();
        int a3 = fjVar.a(a2, bArr, i2, i3, i4, clVar);
        fjVar.c(a2);
        clVar.f10531c = a2;
        return a3;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, ed<?> edVar, cl clVar) {
        dy dyVar = (dy) edVar;
        int a2 = a(bArr, i3, clVar);
        dyVar.d(clVar.f10529a);
        while (a2 < i4) {
            int a3 = a(bArr, a2, clVar);
            if (i2 != clVar.f10529a) {
                break;
            }
            a2 = a(bArr, a3, clVar);
            dyVar.d(clVar.f10529a);
        }
        return a2;
    }

    static int a(byte[] bArr, int i2, ed<?> edVar, cl clVar) throws IOException {
        dy dyVar = (dy) edVar;
        int a2 = a(bArr, i2, clVar);
        int i3 = clVar.f10529a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, clVar);
            dyVar.d(clVar.f10529a);
        }
        if (a2 == i3) {
            return a2;
        }
        throw eg.zza();
    }

    static int a(fv<?> fvVar, int i2, byte[] bArr, int i3, int i4, ed<?> edVar, cl clVar) throws IOException {
        int a2 = a((fv) fvVar, bArr, i3, i4, clVar);
        edVar.add(clVar.f10531c);
        while (a2 < i4) {
            int a3 = a(bArr, a2, clVar);
            if (i2 != clVar.f10529a) {
                break;
            }
            a2 = a((fv) fvVar, bArr, a3, i4, clVar);
            edVar.add(clVar.f10531c);
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, gp gpVar, cl clVar) throws eg {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int b2 = b(bArr, i3, clVar);
                gpVar.a(i2, (Object) Long.valueOf(clVar.f10530b));
                return b2;
            } else if (i5 == 1) {
                gpVar.a(i2, (Object) Long.valueOf(b(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int a2 = a(bArr, i3, clVar);
                int i6 = clVar.f10529a;
                if (i6 < 0) {
                    throw eg.zzb();
                } else if (i6 <= bArr.length - a2) {
                    if (i6 == 0) {
                        gpVar.a(i2, (Object) cm.zza);
                    } else {
                        gpVar.a(i2, (Object) cm.zza(bArr, a2, i6));
                    }
                    return a2 + i6;
                } else {
                    throw eg.zza();
                }
            } else if (i5 == 3) {
                gp b3 = gp.b();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int a3 = a(bArr, i3, clVar);
                    int i9 = clVar.f10529a;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = a3;
                        break;
                    }
                    int a4 = a(i8, bArr, a3, i4, b3, clVar);
                    i8 = i9;
                    i3 = a4;
                }
                if (i3 > i4 || i8 != i7) {
                    throw eg.zzg();
                }
                gpVar.a(i2, (Object) b3);
                return i3;
            } else if (i5 == 5) {
                gpVar.a(i2, (Object) Integer.valueOf(a(bArr, i3)));
                return i3 + 4;
            } else {
                throw eg.zzd();
            }
        } else {
            throw eg.zzd();
        }
    }

    static int a(int i2, byte[] bArr, int i3, int i4, cl clVar) throws eg {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return b(bArr, i3, clVar);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return a(bArr, i3, clVar) + clVar.f10529a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = a(bArr, i3, clVar);
                    i7 = clVar.f10529a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = a(i7, bArr, i3, i4, clVar);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw eg.zzg();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw eg.zzd();
            }
        } else {
            throw eg.zzd();
        }
    }
}
