package com.google.zxing.c.a;

import com.google.zxing.b.b;
import com.google.zxing.h;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final e f39941a;

    /* renamed from: b  reason: collision with root package name */
    private final b f39942b;

    /* renamed from: c  reason: collision with root package name */
    private final b f39943c;

    a(b bVar) throws h {
        int i2 = bVar.f39890b;
        if (i2 < 8 || i2 > 144 || (i2 & 1) != 0) {
            throw h.getFormatInstance();
        }
        this.f39941a = e.a(bVar.f39890b, bVar.f39889a);
        this.f39942b = a(bVar);
        this.f39943c = new b(this.f39942b.f39889a, this.f39942b.f39890b);
    }

    /* access modifiers changed from: package-private */
    public final byte[] a() throws h {
        byte[] bArr = new byte[this.f39941a.f39960g];
        int i2 = this.f39942b.f39890b;
        int i3 = this.f39942b.f39889a;
        int i4 = 4;
        int i5 = 0;
        boolean z = false;
        int i6 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i4 == i2 && i5 == 0 && !z) {
                int i7 = i6 + 1;
                int i8 = i2 - 1;
                int i9 = (a(i8, 0, i2, i3) ? 1 : 0) << true;
                if (a(i8, 1, i2, i3)) {
                    i9 |= 1;
                }
                int i10 = i9 << 1;
                if (a(i8, 2, i2, i3)) {
                    i10 |= 1;
                }
                int i11 = i10 << 1;
                if (a(0, i3 - 2, i2, i3)) {
                    i11 |= 1;
                }
                int i12 = i11 << 1;
                int i13 = i3 - 1;
                if (a(0, i13, i2, i3)) {
                    i12 |= 1;
                }
                int i14 = i12 << 1;
                if (a(1, i13, i2, i3)) {
                    i14 |= 1;
                }
                int i15 = i14 << 1;
                if (a(2, i13, i2, i3)) {
                    i15 |= 1;
                }
                int i16 = i15 << 1;
                if (a(3, i13, i2, i3)) {
                    i16 |= 1;
                }
                bArr[i6] = (byte) i16;
                i4 -= 2;
                i5 += 2;
                i6 = i7;
                z = true;
            } else {
                int i17 = i2 - 2;
                if (i4 == i17 && i5 == 0 && (i3 & 3) != 0 && !z2) {
                    int i18 = i6 + 1;
                    int i19 = (a(i2 + -3, 0, i2, i3) ? 1 : 0) << true;
                    if (a(i17, 0, i2, i3)) {
                        i19 |= 1;
                    }
                    int i20 = i19 << 1;
                    if (a(i2 - 1, 0, i2, i3)) {
                        i20 |= 1;
                    }
                    int i21 = i20 << 1;
                    if (a(0, i3 - 4, i2, i3)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (a(0, i3 - 3, i2, i3)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    if (a(0, i3 - 2, i2, i3)) {
                        i23 |= 1;
                    }
                    int i24 = i23 << 1;
                    int i25 = i3 - 1;
                    if (a(0, i25, i2, i3)) {
                        i24 |= 1;
                    }
                    int i26 = i24 << 1;
                    if (a(1, i25, i2, i3)) {
                        i26 |= 1;
                    }
                    bArr[i6] = (byte) i26;
                    i4 -= 2;
                    i5 += 2;
                    i6 = i18;
                    z2 = true;
                } else if (i4 == i2 + 4 && i5 == 2 && (i3 & 7) == 0 && !z3) {
                    int i27 = i6 + 1;
                    int i28 = i2 - 1;
                    int i29 = (a(i28, 0, i2, i3) ? 1 : 0) << true;
                    int i30 = i3 - 1;
                    if (a(i28, i30, i2, i3)) {
                        i29 |= 1;
                    }
                    int i31 = i29 << 1;
                    int i32 = i3 - 3;
                    if (a(0, i32, i2, i3)) {
                        i31 |= 1;
                    }
                    int i33 = i31 << 1;
                    int i34 = i3 - 2;
                    if (a(0, i34, i2, i3)) {
                        i33 |= 1;
                    }
                    int i35 = i27;
                    int i36 = i33 << 1;
                    if (a(0, i30, i2, i3)) {
                        i36 |= 1;
                    }
                    int i37 = i36 << 1;
                    if (a(1, i32, i2, i3)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (a(1, i34, i2, i3)) {
                        i38 |= 1;
                    }
                    int i39 = i38 << 1;
                    if (a(1, i30, i2, i3)) {
                        i39 |= 1;
                    }
                    bArr[i6] = (byte) i39;
                    i4 -= 2;
                    i5 += 2;
                    i6 = i35;
                    z3 = true;
                } else if (i4 == i17 && i5 == 0 && (i3 & 7) == 4 && !z4) {
                    int i40 = i6 + 1;
                    int i41 = (a(i2 + -3, 0, i2, i3) ? 1 : 0) << true;
                    if (a(i17, 0, i2, i3)) {
                        i41 |= 1;
                    }
                    int i42 = i41 << 1;
                    if (a(i2 - 1, 0, i2, i3)) {
                        i42 |= 1;
                    }
                    int i43 = i42 << 1;
                    if (a(0, i3 - 2, i2, i3)) {
                        i43 |= 1;
                    }
                    int i44 = i43 << 1;
                    int i45 = i3 - 1;
                    if (a(0, i45, i2, i3)) {
                        i44 |= 1;
                    }
                    int i46 = i44 << 1;
                    if (a(1, i45, i2, i3)) {
                        i46 |= 1;
                    }
                    int i47 = i46 << 1;
                    if (a(2, i45, i2, i3)) {
                        i47 |= 1;
                    }
                    int i48 = i47 << 1;
                    if (a(3, i45, i2, i3)) {
                        i48 |= 1;
                    }
                    bArr[i6] = (byte) i48;
                    i4 -= 2;
                    i5 += 2;
                    i6 = i40;
                    z4 = true;
                } else {
                    do {
                        if (i4 < i2 && i5 >= 0 && !this.f39943c.a(i5, i4)) {
                            bArr[i6] = (byte) b(i4, i5, i2, i3);
                            i6++;
                        }
                        i4 -= 2;
                        i5 += 2;
                        if (i4 < 0) {
                            break;
                        }
                    } while (i5 < i3);
                    int i49 = i4 + 1;
                    int i50 = i5 + 3;
                    do {
                        if (i49 >= 0 && i50 < i3 && !this.f39943c.a(i50, i49)) {
                            bArr[i6] = (byte) b(i49, i50, i2, i3);
                            i6++;
                        }
                        i49 += 2;
                        i50 -= 2;
                        if (i49 >= i2) {
                            break;
                        }
                    } while (i50 >= 0);
                    i4 = i49 + 3;
                    i5 = i50 + 1;
                }
            }
            if (i4 >= i2 && i5 >= i3) {
                break;
            }
        }
        if (i6 == this.f39941a.f39960g) {
            return bArr;
        }
        throw h.getFormatInstance();
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f39943c.b(i3, i2);
        return this.f39942b.a(i3, i2);
    }

    private int b(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (a(i6, i7, i4, i5) ? 1 : 0) << true;
        int i9 = i3 - 1;
        if (a(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (a(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (a(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return a(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    private b a(b bVar) {
        b bVar2 = bVar;
        int i2 = this.f39941a.f39955b;
        int i3 = this.f39941a.f39956c;
        if (bVar2.f39890b == i2) {
            int i4 = this.f39941a.f39957d;
            int i5 = this.f39941a.f39958e;
            int i6 = i2 / i4;
            int i7 = i3 / i5;
            b bVar3 = new b(i7 * i5, i6 * i4);
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i8 * i4;
                for (int i10 = 0; i10 < i7; i10++) {
                    int i11 = i10 * i5;
                    for (int i12 = 0; i12 < i4; i12++) {
                        int i13 = ((i4 + 2) * i8) + 1 + i12;
                        int i14 = i9 + i12;
                        for (int i15 = 0; i15 < i5; i15++) {
                            if (bVar2.a(((i5 + 2) * i10) + 1 + i15, i13)) {
                                bVar3.b(i11 + i15, i14);
                            }
                        }
                    }
                }
            }
            return bVar3;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }
}
