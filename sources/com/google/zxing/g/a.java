package com.google.zxing.g;

import com.google.zxing.b.b;
import com.google.zxing.b.g;
import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.g.a.e;
import com.google.zxing.g.a.i;
import com.google.zxing.g.b.e;
import com.google.zxing.g.b.f;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import com.google.zxing.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final t[] f40498a = new t[0];

    /* renamed from: b  reason: collision with root package name */
    private final e f40499b = new e();

    public final void a() {
    }

    public final r a(c cVar, Map<com.google.zxing.e, ?> map) throws m, d, h {
        t[] tVarArr;
        com.google.zxing.b.e eVar;
        boolean z;
        u uVar;
        int i2;
        int i3;
        int i4;
        Map<com.google.zxing.e, ?> map2 = map;
        if (map2 == null || !map2.containsKey(com.google.zxing.e.PURE_BARCODE)) {
            com.google.zxing.g.b.c cVar2 = new com.google.zxing.g.b.c(cVar.b());
            if (map2 == null) {
                uVar = null;
            } else {
                uVar = (u) map2.get(com.google.zxing.e.NEED_RESULT_POINT_CALLBACK);
            }
            cVar2.f40534b = uVar;
            com.google.zxing.g.b.e eVar2 = new com.google.zxing.g.b.e(cVar2.f40533a, cVar2.f40534b);
            boolean z2 = map2 != null && map2.containsKey(com.google.zxing.e.TRY_HARDER);
            int i5 = eVar2.f40537a.f39890b;
            int i6 = eVar2.f40537a.f39889a;
            int i7 = (i5 * 3) / 388;
            if (i7 < 3 || z2) {
                i7 = 3;
            }
            int[] iArr = new int[5];
            int i8 = i7 - 1;
            int i9 = i7;
            boolean z3 = false;
            while (i8 < i5 && !z3) {
                com.google.zxing.g.b.e.b(iArr);
                boolean z4 = z3;
                int i10 = i9;
                int i11 = 0;
                int i12 = i8;
                int i13 = 0;
                while (i13 < i6) {
                    if (eVar2.f40537a.a(i13, i12)) {
                        if ((i11 & 1) == 1) {
                            i11++;
                        }
                        iArr[i11] = iArr[i11] + 1;
                    } else if ((i11 & 1) != 0) {
                        iArr[i11] = iArr[i11] + 1;
                    } else if (i11 == 4) {
                        if (!com.google.zxing.g.b.e.a(iArr)) {
                            com.google.zxing.g.b.e.c(iArr);
                        } else if (eVar2.a(iArr, i12, i13)) {
                            if (eVar2.f40539c) {
                                z4 = eVar2.a();
                            } else {
                                if (eVar2.f40538b.size() > 1) {
                                    Iterator<com.google.zxing.g.b.d> it2 = eVar2.f40538b.iterator();
                                    com.google.zxing.g.b.d dVar = null;
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        com.google.zxing.g.b.d next = it2.next();
                                        if (next.f40536d >= 2) {
                                            if (dVar != null) {
                                                eVar2.f40539c = true;
                                                i3 = 2;
                                                i4 = ((int) (Math.abs(dVar.f40584a - next.f40584a) - Math.abs(dVar.f40585b - next.f40585b))) / 2;
                                                break;
                                            }
                                            dVar = next;
                                        }
                                    }
                                }
                                i3 = 2;
                                i4 = 0;
                                if (i4 > iArr[i3]) {
                                    i12 += (i4 - iArr[i3]) - i3;
                                    i13 = i6 - 1;
                                }
                            }
                            com.google.zxing.g.b.e.b(iArr);
                            i11 = 0;
                            i10 = 2;
                        } else {
                            com.google.zxing.g.b.e.c(iArr);
                        }
                        i11 = 3;
                    } else {
                        int i14 = i11 + 1;
                        iArr[i14] = iArr[i14] + 1;
                        i11 = i14;
                    }
                    i13++;
                }
                if (!com.google.zxing.g.b.e.a(iArr) || !eVar2.a(iArr, i12, i6)) {
                    i9 = i10;
                } else {
                    int i15 = iArr[0];
                    if (eVar2.f40539c) {
                        z4 = eVar2.a();
                    }
                    i9 = i15;
                }
                i8 = i12 + i9;
                z3 = z4;
            }
            int size = eVar2.f40538b.size();
            if (size >= 3) {
                float f2 = 0.0f;
                if (size > 3) {
                    float f3 = 0.0f;
                    float f4 = 0.0f;
                    for (com.google.zxing.g.b.d dVar2 : eVar2.f40538b) {
                        float f5 = dVar2.f40535c;
                        f3 += f5;
                        f4 += f5 * f5;
                    }
                    float f6 = (float) size;
                    float f7 = f3 / f6;
                    float sqrt = (float) Math.sqrt((double) ((f4 / f6) - (f7 * f7)));
                    Collections.sort(eVar2.f40538b, new e.b(f7));
                    float max = Math.max(0.2f * f7, sqrt);
                    int i16 = 0;
                    while (i16 < eVar2.f40538b.size() && eVar2.f40538b.size() > 3) {
                        if (Math.abs(eVar2.f40538b.get(i16).f40535c - f7) > max) {
                            eVar2.f40538b.remove(i16);
                            i16--;
                        }
                        i16++;
                    }
                }
                if (eVar2.f40538b.size() > 3) {
                    for (com.google.zxing.g.b.d dVar3 : eVar2.f40538b) {
                        f2 += dVar3.f40535c;
                    }
                    Collections.sort(eVar2.f40538b, new e.a(f2 / ((float) eVar2.f40538b.size())));
                    i2 = 3;
                    eVar2.f40538b.subList(3, eVar2.f40538b.size()).clear();
                } else {
                    i2 = 3;
                }
                com.google.zxing.g.b.d[] dVarArr = new com.google.zxing.g.b.d[i2];
                dVarArr[0] = eVar2.f40538b.get(0);
                dVarArr[1] = eVar2.f40538b.get(1);
                dVarArr[2] = eVar2.f40538b.get(2);
                t.a(dVarArr);
                g a2 = cVar2.a(new f(dVarArr));
                eVar = this.f40499b.a(a2.f39919d, map2);
                tVarArr = a2.f39920e;
            } else {
                throw m.getNotFoundInstance();
            }
        } else {
            b b2 = cVar.b();
            int[] b3 = b2.b();
            int[] c2 = b2.c();
            if (b3 == null || c2 == null) {
                throw m.getNotFoundInstance();
            }
            int i17 = b2.f39890b;
            int i18 = b2.f39889a;
            int i19 = b3[0];
            int i20 = b3[1];
            boolean z5 = true;
            int i21 = 0;
            while (i19 < i18 && i20 < i17) {
                if (z5 != b2.a(i19, i20)) {
                    i21++;
                    if (i21 == 5) {
                        break;
                    }
                    z5 = !z5;
                }
                i19++;
                i20++;
            }
            if (i19 == i18 || i20 == i17) {
                throw m.getNotFoundInstance();
            }
            float f8 = ((float) (i19 - b3[0])) / 7.0f;
            int i22 = b3[1];
            int i23 = c2[1];
            int i24 = b3[0];
            int i25 = c2[0];
            if (i24 >= i25 || i22 >= i23) {
                throw m.getNotFoundInstance();
            }
            int i26 = i23 - i22;
            if (i26 == i25 - i24 || (i25 = i24 + i26) < b2.f39889a) {
                int round = Math.round(((float) ((i25 - i24) + 1)) / f8);
                int round2 = Math.round(((float) (i26 + 1)) / f8);
                if (round <= 0 || round2 <= 0) {
                    throw m.getNotFoundInstance();
                } else if (round2 == round) {
                    int i27 = (int) (f8 / 2.0f);
                    int i28 = i22 + i27;
                    int i29 = i24 + i27;
                    int i30 = (((int) (((float) (round - 1)) * f8)) + i29) - i25;
                    if (i30 > 0) {
                        if (i30 <= i27) {
                            i29 -= i30;
                        } else {
                            throw m.getNotFoundInstance();
                        }
                    }
                    int i31 = (((int) (((float) (round2 - 1)) * f8)) + i28) - i23;
                    if (i31 > 0) {
                        if (i31 <= i27) {
                            i28 -= i31;
                        } else {
                            throw m.getNotFoundInstance();
                        }
                    }
                    b bVar = new b(round, round2);
                    for (int i32 = 0; i32 < round2; i32++) {
                        int i33 = ((int) (((float) i32) * f8)) + i28;
                        for (int i34 = 0; i34 < round; i34++) {
                            if (b2.a(((int) (((float) i34) * f8)) + i29, i33)) {
                                bVar.b(i34, i32);
                            }
                        }
                    }
                    eVar = this.f40499b.a(bVar, map2);
                    tVarArr = f40498a;
                } else {
                    throw m.getNotFoundInstance();
                }
            } else {
                throw m.getNotFoundInstance();
            }
        }
        if (!(eVar.f39917h instanceof i) || !((i) eVar.f39917h).f40512a || tVarArr == null || tVarArr.length < 3) {
            z = false;
        } else {
            z = false;
            t tVar = tVarArr[0];
            tVarArr[0] = tVarArr[2];
            tVarArr[2] = tVar;
        }
        r rVar = new r(eVar.f39912c, eVar.f39910a, tVarArr, com.google.zxing.a.QR_CODE);
        List<byte[]> list = eVar.f39913d;
        if (list != null) {
            rVar.a(s.BYTE_SEGMENTS, list);
        }
        String str = eVar.f39914e;
        if (str != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, str);
        }
        if (eVar.f39918i >= 0 && eVar.j >= 0) {
            z = true;
        }
        if (z) {
            rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.j));
            rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.f39918i));
        }
        return rVar;
    }
}
