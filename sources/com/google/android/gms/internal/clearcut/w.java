package com.google.android.gms.internal.clearcut;

import java.io.IOException;

final class w {
    static int a(int i2, byte[] bArr, int i3, int i4, bm<?> bmVar, x xVar) {
        bg bgVar = (bg) bmVar;
        int a2 = a(bArr, i3, xVar);
        while (true) {
            bgVar.c(xVar.f9432a);
            if (a2 >= i4) {
                break;
            }
            int a3 = a(bArr, a2, xVar);
            if (i2 != xVar.f9432a) {
                break;
            }
            a2 = a(bArr, a3, xVar);
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, dw dwVar, x xVar) throws IOException {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int b2 = b(bArr, i3, xVar);
                dwVar.a(i2, (Object) Long.valueOf(xVar.f9433b));
                return b2;
            } else if (i5 == 1) {
                dwVar.a(i2, (Object) Long.valueOf(b(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int a2 = a(bArr, i3, xVar);
                int i6 = xVar.f9432a;
                dwVar.a(i2, (Object) i6 == 0 ? ab.zzfi : ab.zzb(bArr, a2, i6));
                return a2 + i6;
            } else if (i5 == 3) {
                dw b3 = dw.b();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int a3 = a(bArr, i3, xVar);
                    int i9 = xVar.f9432a;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = a3;
                        break;
                    }
                    int a4 = a(i8, bArr, a3, i4, b3, xVar);
                    i8 = i9;
                    i3 = a4;
                }
                if (i3 > i4 || i8 != i7) {
                    throw bn.zzbo();
                }
                dwVar.a(i2, (Object) b3);
                return i3;
            } else if (i5 == 5) {
                dwVar.a(i2, (Object) Integer.valueOf(a(bArr, i3)));
                return i3 + 4;
            } else {
                throw bn.zzbm();
            }
        } else {
            throw bn.zzbm();
        }
    }

    static int a(int i2, byte[] bArr, int i3, int i4, x xVar) throws bn {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return b(bArr, i3, xVar);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return a(bArr, i3, xVar) + xVar.f9432a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = a(bArr, i3, xVar);
                    i7 = xVar.f9432a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = a(i7, bArr, i3, i4, xVar);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw bn.zzbo();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw bn.zzbm();
            }
        } else {
            throw bn.zzbm();
        }
    }

    static int a(int i2, byte[] bArr, int i3, x xVar) {
        int i4;
        int i5;
        int i6 = i2 & 127;
        int i7 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            i5 = b2 << 7;
        } else {
            int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i9 = i7 + 1;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i6 = i8 | ((b3 & Byte.MAX_VALUE) << 14);
                i7 = i9 + 1;
                byte b4 = bArr[i9];
                if (b4 >= 0) {
                    i5 = b4 << 21;
                } else {
                    i8 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i9 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i11 = i9 + 1;
                            if (bArr[i9] >= 0) {
                                xVar.f9432a = i10;
                                return i11;
                            }
                            i9 = i11;
                        }
                    }
                }
            }
            xVar.f9432a = i8 | i4;
            return i9;
        }
        xVar.f9432a = i6 | i5;
        return i7;
    }

    static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static int a(byte[] bArr, int i2, bm<?> bmVar, x xVar) throws IOException {
        bg bgVar = (bg) bmVar;
        int a2 = a(bArr, i2, xVar);
        int i3 = xVar.f9432a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, xVar);
            bgVar.c(xVar.f9432a);
        }
        if (a2 == i3) {
            return a2;
        }
        throw bn.zzbl();
    }

    static int a(byte[] bArr, int i2, x xVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return a((int) b2, bArr, i3, xVar);
        }
        xVar.f9432a = b2;
        return i3;
    }

    static int b(byte[] bArr, int i2, x xVar) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            xVar.f9433b = j;
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
        xVar.f9433b = j2;
        return i4;
    }

    static long b(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    static double c(byte[] bArr, int i2) {
        return Double.longBitsToDouble(b(bArr, i2));
    }

    static int c(byte[] bArr, int i2, x xVar) {
        int a2 = a(bArr, i2, xVar);
        int i3 = xVar.f9432a;
        if (i3 == 0) {
            xVar.f9434c = "";
            return a2;
        }
        xVar.f9434c = new String(bArr, a2, i3, bh.f9208a);
        return a2 + i3;
    }

    static float d(byte[] bArr, int i2) {
        return Float.intBitsToFloat(a(bArr, i2));
    }

    static int d(byte[] bArr, int i2, x xVar) throws IOException {
        int a2 = a(bArr, i2, xVar);
        int i3 = xVar.f9432a;
        if (i3 == 0) {
            xVar.f9434c = "";
            return a2;
        }
        int i4 = a2 + i3;
        if (ed.a(bArr, a2, i4)) {
            xVar.f9434c = new String(bArr, a2, i3, bh.f9208a);
            return i4;
        }
        throw bn.zzbp();
    }

    static int e(byte[] bArr, int i2, x xVar) {
        int a2 = a(bArr, i2, xVar);
        int i3 = xVar.f9432a;
        if (i3 == 0) {
            xVar.f9434c = ab.zzfi;
            return a2;
        }
        xVar.f9434c = ab.zzb(bArr, a2, i3);
        return a2 + i3;
    }
}
