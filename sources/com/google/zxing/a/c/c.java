package com.google.zxing.a.c;

import com.google.zxing.b.a;
import com.google.zxing.b.b;
import com.google.zxing.b.b.d;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f39863a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public static a a(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        a aVar;
        a aVar2;
        int i11;
        int i12;
        d dVar = new d(bArr);
        Collection<f> singletonList = Collections.singletonList(f.f39872a);
        int i13 = 0;
        while (true) {
            i4 = 5;
            i5 = 3;
            int i14 = 4;
            i6 = 32;
            i7 = 2;
            if (i13 >= dVar.f39868d.length) {
                break;
            }
            int i15 = i13 + 1;
            byte b2 = i15 < dVar.f39868d.length ? dVar.f39868d[i15] : 0;
            byte b3 = dVar.f39868d[i13];
            if (b3 == 13) {
                if (b2 != 10) {
                    i7 = 0;
                }
                i4 = i7;
            } else if (b3 == 44) {
                if (b2 != 32) {
                    i14 = 0;
                }
                i4 = i14;
            } else if (b3 == 46) {
                if (b2 != 32) {
                    i5 = 0;
                }
                i4 = i5;
            } else if (!(b3 == 58 && b2 == 32)) {
                i4 = 0;
            }
            if (i4 > 0) {
                singletonList = d.a((Iterable<f>) singletonList, i13, i4);
                i13 = i15;
            } else {
                LinkedList linkedList = new LinkedList();
                for (f a2 : singletonList) {
                    dVar.a(a2, i13, (Collection<f>) linkedList);
                }
                singletonList = d.a(linkedList);
            }
            i13++;
        }
        a a3 = ((f) Collections.min(singletonList, new Comparator<f>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((f) obj).f39875d - ((f) obj2).f39875d;
            }
        })).a(dVar.f39868d);
        int i16 = 11;
        int i17 = ((a3.f39881b * i2) / 100) + 11;
        int i18 = a3.f39881b + i17;
        if (i3 != 0) {
            boolean z2 = i3 < 0;
            int abs = Math.abs(i3);
            if (z2) {
                i6 = 4;
            }
            if (abs <= i6) {
                int a4 = a(abs, z2);
                int i19 = f39863a[abs];
                int i20 = a4 - (a4 % i19);
                aVar = a(a3, i19);
                if (aVar.f39881b + i17 > i20) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (!z2 || aVar.f39881b <= (i19 << 6)) {
                    z = z2;
                    i8 = abs;
                    i10 = a4;
                    i9 = i19;
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i3)}));
            }
        } else {
            a aVar3 = null;
            int i21 = 0;
            i9 = 0;
            while (i21 <= i6) {
                z = i21 <= i5;
                i8 = z ? i21 + 1 : i21;
                i10 = a(i8, z);
                if (i18 <= i10) {
                    if (aVar3 == null || i9 != f39863a[i8]) {
                        int i22 = f39863a[i8];
                        aVar3 = a(a3, i22);
                        i9 = i22;
                    }
                    int i23 = i10 - (i10 % i9);
                    if ((!z || aVar3.f39881b <= (i9 << 6)) && aVar3.f39881b + i17 <= i23) {
                        aVar = aVar3;
                    }
                }
                i21++;
                i4 = 5;
                i5 = 3;
                i6 = 32;
                i7 = 2;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        a a5 = a(aVar, i10, i9);
        int i24 = aVar.f39881b / i9;
        a aVar4 = new a();
        if (z) {
            aVar4.b(i8 - 1, i7);
            aVar4.b(i24 - 1, 6);
            aVar2 = a(aVar4, 28, 4);
        } else {
            aVar4.b(i8 - 1, i4);
            aVar4.b(i24 - 1, 11);
            aVar2 = a(aVar4, 40, 4);
        }
        if (!z) {
            i16 = 14;
        }
        int i25 = i16 + (i8 << 2);
        int[] iArr = new int[i25];
        if (z) {
            for (int i26 = 0; i26 < iArr.length; i26++) {
                iArr[i26] = i26;
            }
            i11 = i25;
        } else {
            int i27 = i25 / 2;
            i11 = i25 + 1 + (((i27 - 1) / 15) * 2);
            int i28 = i11 / 2;
            for (int i29 = 0; i29 < i27; i29++) {
                int i30 = (i29 / 15) + i29;
                iArr[(i27 - i29) - 1] = (i28 - i30) - 1;
                iArr[i27 + i29] = i30 + i28 + 1;
            }
        }
        b bVar = new b(i11);
        int i31 = 0;
        int i32 = 0;
        while (i31 < i8) {
            int i33 = ((i8 - i31) << i7) + (z ? 9 : 12);
            int i34 = 0;
            while (i34 < i33) {
                int i35 = i34 << 1;
                int i36 = 0;
                while (i36 < i7) {
                    if (a5.a(i32 + i35 + i36)) {
                        int i37 = i31 << 1;
                        i12 = i24;
                        bVar.b(iArr[i37 + i36], iArr[i37 + i34]);
                    } else {
                        i12 = i24;
                    }
                    if (a5.a((i33 << 1) + i32 + i35 + i36)) {
                        int i38 = i31 << 1;
                        bVar.b(iArr[i38 + i34], iArr[((i25 - 1) - i38) - i36]);
                    }
                    if (a5.a((i33 << 2) + i32 + i35 + i36)) {
                        int i39 = (i25 - 1) - (i31 << 1);
                        bVar.b(iArr[i39 - i36], iArr[i39 - i34]);
                    }
                    if (a5.a((i33 * 6) + i32 + i35 + i36)) {
                        int i40 = i31 << 1;
                        bVar.b(iArr[((i25 - 1) - i40) - i34], iArr[i40 + i36]);
                    }
                    i36++;
                    i24 = i12;
                    i7 = 2;
                }
                int i41 = i24;
                i34++;
                i7 = 2;
            }
            i32 += i33 << 3;
            i31++;
            i24 = i24;
            i7 = 2;
        }
        int i42 = i24;
        a(bVar, z, i11, aVar2);
        if (z) {
            a(bVar, i11 / 2, 5);
        } else {
            int i43 = i11 / 2;
            a(bVar, i43, 7);
            int i44 = 0;
            int i45 = 0;
            while (i44 < (i25 / 2) - 1) {
                for (int i46 = i43 & 1; i46 < i11; i46 += 2) {
                    int i47 = i43 - i45;
                    bVar.b(i47, i46);
                    int i48 = i43 + i45;
                    bVar.b(i48, i46);
                    bVar.b(i46, i47);
                    bVar.b(i46, i48);
                }
                i44 += 15;
                i45 += 16;
            }
        }
        a aVar5 = new a();
        aVar5.f39856a = z;
        aVar5.f39857b = i11;
        aVar5.f39858c = i8;
        aVar5.f39859d = i42;
        aVar5.f39860e = bVar;
        return aVar5;
    }

    private static void a(b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 > i7) {
                    break;
                }
                bVar.b(i6, i5);
                bVar.b(i6, i7);
                bVar.b(i5, i6);
                bVar.b(i7, i6);
                i6++;
            }
        }
        int i8 = i2 - i3;
        bVar.b(i8, i8);
        int i9 = i8 + 1;
        bVar.b(i9, i8);
        bVar.b(i8, i9);
        int i10 = i2 + i3;
        bVar.b(i10, i8);
        bVar.b(i10, i9);
        bVar.b(i10, i10 - 1);
    }

    private static void a(b bVar, boolean z, int i2, a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.a(i4)) {
                    bVar.b(i5, i3 - 5);
                }
                if (aVar.a(i4 + 7)) {
                    bVar.b(i3 + 5, i5);
                }
                if (aVar.a(20 - i4)) {
                    bVar.b(i5, i3 + 5);
                }
                if (aVar.a(27 - i4)) {
                    bVar.b(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.a(i4)) {
                bVar.b(i6, i3 - 7);
            }
            if (aVar.a(i4 + 10)) {
                bVar.b(i3 + 7, i6);
            }
            if (aVar.a(29 - i4)) {
                bVar.b(i6, i3 + 7);
            }
            if (aVar.a(39 - i4)) {
                bVar.b(i3 - 7, i6);
            }
            i4++;
        }
    }

    private static int[] b(a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int i4 = aVar.f39881b / i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 |= aVar.a((i5 * i2) + i7) ? 1 << ((i2 - i7) - 1) : 0;
            }
            iArr[i5] = i6;
        }
        return iArr;
    }

    private static a a(a aVar, int i2) {
        a aVar2 = new a();
        int i3 = aVar.f39881b;
        int i4 = (1 << i2) - 2;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i5 + i7;
                if (i8 >= i3 || aVar.a(i8)) {
                    i6 |= 1 << ((i2 - 1) - i7);
                }
            }
            int i9 = i6 & i4;
            if (i9 == i4) {
                aVar2.b(i9, i2);
            } else if (i9 == 0) {
                aVar2.b(i6 | 1, i2);
            } else {
                aVar2.b(i6, i2);
                i5 += i2;
            }
            i5--;
            i5 += i2;
        }
        return aVar2;
    }

    private static a a(a aVar, int i2, int i3) {
        com.google.zxing.b.b.a aVar2;
        int i4 = aVar.f39881b / i3;
        if (i3 == 4) {
            aVar2 = com.google.zxing.b.b.a.f39896d;
        } else if (i3 == 6) {
            aVar2 = com.google.zxing.b.b.a.f39895c;
        } else if (i3 == 8) {
            aVar2 = com.google.zxing.b.b.a.f39899g;
        } else if (i3 == 10) {
            aVar2 = com.google.zxing.b.b.a.f39894b;
        } else if (i3 == 12) {
            aVar2 = com.google.zxing.b.b.a.f39893a;
        } else {
            throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i3)));
        }
        d dVar = new d(aVar2);
        int i5 = i2 / i3;
        int[] b2 = b(aVar, i3, i5);
        dVar.a(b2, i5 - i4);
        a aVar3 = new a();
        aVar3.b(0, i2 % i3);
        for (int b3 : b2) {
            aVar3.b(b3, i3);
        }
        return aVar3;
    }
}
