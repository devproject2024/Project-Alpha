package com.google.zxing.f.b;

import com.google.zxing.b.b;
import com.google.zxing.c;
import com.google.zxing.m;
import com.google.zxing.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f40457a = {0, 4, 1, 5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f40458b = {6, 2, 7, 3};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f40459c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f40460d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static b a(c cVar) throws m {
        b b2 = cVar.b();
        List<t[]> a2 = a(b2);
        if (a2.isEmpty()) {
            b2 = b2.clone();
            int i2 = b2.f39889a;
            int i3 = b2.f39890b;
            com.google.zxing.b.a aVar = new com.google.zxing.b.a(i2);
            com.google.zxing.b.a aVar2 = new com.google.zxing.b.a(i2);
            for (int i4 = 0; i4 < (i3 + 1) / 2; i4++) {
                aVar = b2.a(i4, aVar);
                int i5 = (i3 - 1) - i4;
                aVar2 = b2.a(i5, aVar2);
                aVar.c();
                aVar2.c();
                b2.b(i4, aVar2);
                b2.b(i5, aVar);
            }
            a2 = a(b2);
        }
        return new b(b2, a2);
    }

    private static List<t[]> a(b bVar) {
        ArrayList arrayList = new ArrayList();
        if (bVar.f39890b > 0) {
            t[] a2 = a(bVar, 0, 0);
            if (!(a2[0] == null && a2[3] == null)) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private static void a(t[] tVarArr, t[] tVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            tVarArr[iArr[i2]] = tVarArr2[i2];
        }
    }

    private static t[] a(b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        int[] iArr2;
        int i7 = i2;
        t[] tVarArr = new t[4];
        int[] iArr3 = new int[iArr.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i7) {
                z = false;
                break;
            }
            int[] a2 = a(bVar, i5, i8, i3, iArr, iArr3);
            if (a2 != null) {
                while (true) {
                    iArr2 = a2;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    a2 = a(bVar, i5, i8, i3, iArr, iArr3);
                    if (a2 == null) {
                        i8++;
                        break;
                    }
                }
                float f2 = (float) i8;
                tVarArr[0] = new t((float) iArr2[0], f2);
                tVarArr[1] = new t((float) iArr2[1], f2);
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) tVarArr[0].f40584a, (int) tVarArr[1].f40584a};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i7) {
                    i6 = i11;
                    break;
                }
                i6 = i11;
                int[] a3 = a(bVar, iArr4[0], i10, i3, iArr, iArr3);
                if (a3 == null || Math.abs(iArr4[0] - a3[0]) >= 5 || Math.abs(iArr4[1] - a3[1]) >= 5) {
                    if (i6 > 25) {
                        break;
                    }
                    i11 = i6 + 1;
                } else {
                    iArr4 = a3;
                    i11 = 0;
                }
                i10++;
            }
            i9 = i10 - (i6 + 1);
            float f3 = (float) i9;
            tVarArr[2] = new t((float) iArr4[0], f3);
            tVarArr[3] = new t((float) iArr4[1], f3);
        }
        if (i9 - i8 < 10) {
            Arrays.fill(tVarArr, (Object) null);
        }
        return tVarArr;
    }

    private static int[] a(b bVar, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.a(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        int i7 = i2;
        int i8 = 0;
        boolean z = false;
        while (i2 < i4) {
            if (bVar.a(i2, i3) != z) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                if (i8 != length - 1) {
                    i8++;
                } else if (a(iArr2, iArr) < 0.42f) {
                    return new int[]{i7, i2};
                } else {
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = i8 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z = !z;
            }
            i2++;
        }
        if (i8 != length - 1 || a(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i2 - 1};
    }

    private static float a(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i2;
        float f3 = f2 / ((float) i3);
        float f4 = 0.8f * f3;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            float f6 = ((float) iArr2[i5]) * f3;
            float f7 = (float) i6;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    private static t[] a(b bVar, int i2, int i3) {
        int i4 = bVar.f39890b;
        int i5 = bVar.f39889a;
        t[] tVarArr = new t[8];
        a(tVarArr, a(bVar, i4, i5, 0, 0, f40459c), f40457a);
        if (tVarArr[4] != null) {
            i3 = (int) tVarArr[4].f40584a;
            i2 = (int) tVarArr[4].f40585b;
        }
        a(tVarArr, a(bVar, i4, i5, i2, i3, f40460d), f40458b);
        return tVarArr;
    }
}
