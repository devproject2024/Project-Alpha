package com.google.zxing.b;

import com.google.zxing.b;
import com.google.zxing.m;
import java.lang.reflect.Array;

public final class j extends h {

    /* renamed from: b  reason: collision with root package name */
    private b f39925b;

    private static int a(int i2, int i3) {
        if (i2 < 2) {
            return 2;
        }
        return i2 > i3 ? i3 : i2;
    }

    public j(com.google.zxing.j jVar) {
        super(jVar);
    }

    public final b a() throws m {
        j jVar;
        b bVar = this.f39925b;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.j jVar2 = this.f39879a;
        int i2 = jVar2.f40562a;
        int i3 = jVar2.f40563b;
        if (i2 < 40 || i3 < 40) {
            jVar = this;
            jVar.f39925b = super.a();
        } else {
            byte[] a2 = jVar2.a();
            int i4 = i2 >> 3;
            if ((i2 & 7) != 0) {
                i4++;
            }
            int i5 = i3 >> 3;
            if ((i3 & 7) != 0) {
                i5++;
            }
            int i6 = i3 - 8;
            int i7 = i2 - 8;
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i5, i4});
            int i8 = 0;
            while (true) {
                int i9 = 8;
                if (i8 >= i5) {
                    break;
                }
                int i10 = i8 << 3;
                if (i10 > i6) {
                    i10 = i6;
                }
                int i11 = 0;
                while (i11 < i4) {
                    int i12 = i11 << 3;
                    if (i12 > i7) {
                        i12 = i7;
                    }
                    int i13 = (i10 * i2) + i12;
                    int i14 = 0;
                    byte b2 = 255;
                    int i15 = 0;
                    byte b3 = 0;
                    while (i14 < i9) {
                        int i16 = i10;
                        byte b4 = b3;
                        byte b5 = b2;
                        int i17 = 0;
                        while (i17 < i9) {
                            byte b6 = a2[i13 + i17] & 255;
                            i15 += b6;
                            if (b6 < b5) {
                                b5 = b6;
                            }
                            if (b6 > b4) {
                                b4 = b6;
                            }
                            i17++;
                            i9 = 8;
                        }
                        if (b4 - b5 <= 24) {
                            i14++;
                            i13 += i2;
                            i9 = 8;
                            b3 = b4;
                            b2 = b5;
                            i10 = i16;
                        }
                        while (true) {
                            i14++;
                            i13 += i2;
                            if (i14 >= 8) {
                                break;
                            }
                            int i18 = 0;
                            for (int i19 = 8; i18 < i19; i19 = 8) {
                                i15 += a2[i13 + i18] & 255;
                                i18++;
                            }
                        }
                        i14++;
                        i13 += i2;
                        i9 = 8;
                        b3 = b4;
                        b2 = b5;
                        i10 = i16;
                    }
                    int i20 = i10;
                    int i21 = i15 >> 6;
                    if (b3 - b2 <= 24) {
                        i21 = b2 / 2;
                        if (i8 > 0 && i11 > 0) {
                            int i22 = i8 - 1;
                            int i23 = i11 - 1;
                            int i24 = ((iArr[i22][i11] + (iArr[i8][i23] * 2)) + iArr[i22][i23]) / 4;
                            if (b2 < i24) {
                                i21 = i24;
                            }
                        }
                    }
                    iArr[i8][i11] = i21;
                    i11++;
                    i9 = 8;
                    i10 = i20;
                }
                i8++;
            }
            b bVar2 = new b(i2, i3);
            for (int i25 = 0; i25 < i5; i25++) {
                int i26 = i25 << 3;
                if (i26 > i6) {
                    i26 = i6;
                }
                int a3 = a(i25, i5 - 3);
                int i27 = 0;
                while (i27 < i4) {
                    int i28 = i27 << 3;
                    if (i28 > i7) {
                        i28 = i7;
                    }
                    int a4 = a(i27, i4 - 3);
                    int i29 = -2;
                    int i30 = i4;
                    int i31 = 0;
                    for (int i32 = 2; i29 <= i32; i32 = 2) {
                        int[] iArr2 = iArr[a3 + i29];
                        i31 += iArr2[a4 - 2] + iArr2[a4 - 1] + iArr2[a4] + iArr2[a4 + 1] + iArr2[a4 + 2];
                        i29++;
                    }
                    int i33 = i31 / 25;
                    int i34 = (i26 * i2) + i28;
                    int i35 = 0;
                    while (true) {
                        if (i35 >= 8) {
                            break;
                        }
                        int i36 = i5;
                        int i37 = 0;
                        for (int i38 = 8; i37 < i38; i38 = 8) {
                            byte[] bArr = a2;
                            if ((a2[i34 + i37] & 255) <= i33) {
                                bVar2.b(i28 + i37, i26 + i35);
                            }
                            i37++;
                            a2 = bArr;
                        }
                        byte[] bArr2 = a2;
                        i35++;
                        i34 += i2;
                        i5 = i36;
                    }
                    byte[] bArr3 = a2;
                    int i39 = i5;
                    i27++;
                    i4 = i30;
                }
                byte[] bArr4 = a2;
                int i40 = i4;
                int i41 = i5;
            }
            jVar = this;
            jVar.f39925b = bVar2;
        }
        return jVar.f39925b;
    }

    public final b a(com.google.zxing.j jVar) {
        return new j(jVar);
    }
}
