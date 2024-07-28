package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.q;
import com.google.zxing.s;
import com.google.zxing.t;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class r implements p {
    public abstract com.google.zxing.r a(int i2, a aVar, Map<e, ?> map) throws m, d, h;

    public void a() {
    }

    public com.google.zxing.r a(c cVar, Map<e, ?> map) throws m, h {
        try {
            return b(cVar, map);
        } catch (m e2) {
            if (!(map != null && map.containsKey(e.TRY_HARDER)) || !cVar.f39937a.f39879a.b()) {
                throw e2;
            }
            c cVar2 = new c(cVar.f39937a.a(cVar.f39937a.f39879a.d()));
            com.google.zxing.r b2 = b(cVar2, map);
            Map<s, Object> map2 = b2.f40581e;
            int i2 = 270;
            if (map2 != null && map2.containsKey(s.ORIENTATION)) {
                i2 = (((Integer) map2.get(s.ORIENTATION)).intValue() + 270) % 360;
            }
            b2.a(s.ORIENTATION, Integer.valueOf(i2));
            t[] tVarArr = b2.f40579c;
            if (tVarArr != null) {
                int a2 = cVar2.a();
                for (int i3 = 0; i3 < tVarArr.length; i3++) {
                    tVarArr[i3] = new t((((float) a2) - tVarArr[i3].f40585b) - 1.0f, tVarArr[i3].f40584a);
                }
            }
            return b2;
        }
    }

    protected static void a(a aVar, int i2, int[] iArr) throws m {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i4 = aVar.f39881b;
        if (i2 < i4) {
            boolean z = !aVar.a(i2);
            while (i2 < i4) {
                if (aVar.a(i2) == z) {
                    i3++;
                    if (i3 == length) {
                        break;
                    }
                    iArr[i3] = 1;
                    z = !z;
                } else {
                    iArr[i3] = iArr[i3] + 1;
                }
                i2++;
            }
            if (i3 == length) {
                return;
            }
            if (i3 != length - 1 || i2 != i4) {
                throw m.getNotFoundInstance();
            }
            return;
        }
        throw m.getNotFoundInstance();
    }

    protected static void b(a aVar, int i2, int[] iArr) throws m {
        int length = iArr.length;
        boolean a2 = aVar.a(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.a(i2) != a2) {
                length--;
                a2 = !a2;
            }
        }
        if (length < 0) {
            a(aVar, i2 + 1, iArr);
            return;
        }
        throw m.getNotFoundInstance();
    }

    public static float a(int[] iArr, int[] iArr2, float f2) {
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
        float f3 = (float) i2;
        float f4 = f3 / ((float) i3);
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            float f7 = ((float) iArr2[i5]) * f4;
            float f8 = (float) i6;
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    private com.google.zxing.r b(c cVar, Map<e, ?> map) throws m {
        int i2;
        a aVar;
        int i3;
        c cVar2 = cVar;
        Map<e, ?> map2 = map;
        int i4 = cVar2.f39937a.f39879a.f40562a;
        int a2 = cVar.a();
        a aVar2 = new a(i4);
        int i5 = 1;
        boolean z = map2 != null && map2.containsKey(e.TRY_HARDER);
        int max = Math.max(1, a2 >> (z ? 8 : 5));
        int i6 = z ? a2 : 15;
        int i7 = a2 / 2;
        EnumMap enumMap = map2;
        int i8 = 0;
        while (i8 < i6) {
            int i9 = i8 + 1;
            int i10 = i9 / 2;
            if (!((i8 & 1) == 0)) {
                i10 = -i10;
            }
            int i11 = (i10 * max) + i7;
            if (i11 < 0 || i11 >= a2) {
                break;
            }
            try {
                a a3 = cVar2.f39937a.a(i11, aVar2);
                int i12 = 0;
                while (i12 < 2) {
                    if (i12 == i5) {
                        a3.c();
                        if (enumMap != null && enumMap.containsKey(e.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(e.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(e.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        com.google.zxing.r a4 = a(i11, a3, enumMap);
                        if (i12 == i5) {
                            a4.a(s.ORIENTATION, Integer.valueOf(AppConstants.READ_TIME_OUT));
                            t[] tVarArr = a4.f40579c;
                            if (tVarArr != null) {
                                float f2 = (float) i4;
                                aVar = a3;
                                try {
                                    i3 = i4;
                                } catch (q unused) {
                                    i3 = i4;
                                    i12++;
                                    c cVar3 = cVar;
                                    a3 = aVar;
                                    i4 = i3;
                                    i5 = 1;
                                }
                                try {
                                    tVarArr[0] = new t((f2 - tVarArr[0].f40584a) - 1.0f, tVarArr[0].f40585b);
                                    try {
                                        tVarArr[1] = new t((f2 - tVarArr[1].f40584a) - 1.0f, tVarArr[1].f40585b);
                                    } catch (q unused2) {
                                        continue;
                                    }
                                } catch (q unused3) {
                                    i12++;
                                    c cVar32 = cVar;
                                    a3 = aVar;
                                    i4 = i3;
                                    i5 = 1;
                                }
                            }
                        }
                        return a4;
                    } catch (q unused4) {
                        aVar = a3;
                        i3 = i4;
                        i12++;
                        c cVar322 = cVar;
                        a3 = aVar;
                        i4 = i3;
                        i5 = 1;
                    }
                }
                i2 = i4;
                aVar2 = a3;
            } catch (m unused5) {
                i2 = i4;
            }
            cVar2 = cVar;
            i8 = i9;
            i4 = i2;
            i5 = 1;
        }
        throw m.getNotFoundInstance();
    }
}
