package com.google.zxing.c;

import com.google.zxing.b.b;
import com.google.zxing.b.g;
import com.google.zxing.c;
import com.google.zxing.c.a.d;
import com.google.zxing.c.b.a;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final t[] f39939a = new t[0];

    /* renamed from: b  reason: collision with root package name */
    private final d f39940b = new d();

    public final void a() {
    }

    public final r a(c cVar, Map<e, ?> map) throws m, com.google.zxing.d, h {
        t[] tVarArr;
        com.google.zxing.b.e eVar;
        t tVar;
        b bVar;
        Map<e, ?> map2 = map;
        if (map2 == null || !map2.containsKey(e.PURE_BARCODE)) {
            com.google.zxing.c.b.a aVar = new com.google.zxing.c.b.a(cVar.b());
            t[] a2 = aVar.f39966b.a();
            t tVar2 = a2[0];
            t tVar3 = a2[1];
            t tVar4 = a2[2];
            t tVar5 = a2[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(aVar.b(tVar2, tVar3));
            arrayList.add(aVar.b(tVar2, tVar4));
            arrayList.add(aVar.b(tVar3, tVar5));
            arrayList.add(aVar.b(tVar4, tVar5));
            Collections.sort(arrayList, new a.b());
            a.C0672a aVar2 = (a.C0672a) arrayList.get(0);
            a.C0672a aVar3 = (a.C0672a) arrayList.get(1);
            HashMap hashMap = new HashMap();
            com.google.zxing.c.b.a.a((Map<t, Integer>) hashMap, aVar2.f39967a);
            com.google.zxing.c.b.a.a((Map<t, Integer>) hashMap, aVar2.f39968b);
            com.google.zxing.c.b.a.a((Map<t, Integer>) hashMap, aVar3.f39967a);
            com.google.zxing.c.b.a.a((Map<t, Integer>) hashMap, aVar3.f39968b);
            t tVar6 = null;
            t tVar7 = null;
            t tVar8 = null;
            for (Map.Entry entry : hashMap.entrySet()) {
                t tVar9 = (t) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    tVar7 = tVar9;
                } else if (tVar6 == null) {
                    tVar6 = tVar9;
                } else {
                    tVar8 = tVar9;
                }
            }
            if (tVar6 == null || tVar7 == null || tVar8 == null) {
                throw m.getNotFoundInstance();
            }
            t[] tVarArr2 = {tVar6, tVar7, tVar8};
            t.a(tVarArr2);
            t tVar10 = tVarArr2[0];
            t tVar11 = tVarArr2[1];
            t tVar12 = tVarArr2[2];
            if (!hashMap.containsKey(tVar2)) {
                tVar5 = tVar2;
            } else if (!hashMap.containsKey(tVar3)) {
                tVar5 = tVar3;
            } else if (!hashMap.containsKey(tVar4)) {
                tVar5 = tVar4;
            }
            int i2 = aVar.b(tVar12, tVar5).f39969c;
            int i3 = aVar.b(tVar10, tVar5).f39969c;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if ((i3 & 1) == 1) {
                i3++;
            }
            int i5 = i3 + 2;
            if (i4 * 4 >= i5 * 7 || i5 * 4 >= i4 * 7) {
                float a3 = ((float) com.google.zxing.c.b.a.a(tVar11, tVar10)) / ((float) i4);
                float a4 = (float) com.google.zxing.c.b.a.a(tVar12, tVar5);
                t tVar13 = new t(tVar5.f40584a + (((tVar5.f40584a - tVar12.f40584a) / a4) * a3), tVar5.f40585b + (a3 * ((tVar5.f40585b - tVar12.f40585b) / a4)));
                float a5 = ((float) com.google.zxing.c.b.a.a(tVar11, tVar12)) / ((float) i5);
                float a6 = (float) com.google.zxing.c.b.a.a(tVar10, tVar5);
                tVar = new t(tVar5.f40584a + (((tVar5.f40584a - tVar10.f40584a) / a6) * a5), tVar5.f40585b + (a5 * ((tVar5.f40585b - tVar10.f40585b) / a6)));
                if (!aVar.a(tVar13)) {
                    if (!aVar.a(tVar)) {
                        tVar = null;
                    }
                } else if (!aVar.a(tVar) || Math.abs(i4 - aVar.b(tVar12, tVar13).f39969c) + Math.abs(i5 - aVar.b(tVar10, tVar13).f39969c) <= Math.abs(i4 - aVar.b(tVar12, tVar).f39969c) + Math.abs(i5 - aVar.b(tVar10, tVar).f39969c)) {
                    tVar = tVar13;
                }
                if (tVar == null) {
                    tVar = tVar5;
                }
                int i6 = aVar.b(tVar12, tVar).f39969c;
                int i7 = aVar.b(tVar10, tVar).f39969c;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                int i8 = i6;
                if ((i7 & 1) == 1) {
                    i7++;
                }
                bVar = com.google.zxing.c.b.a.a(aVar.f39965a, tVar12, tVar11, tVar10, tVar, i8, i7);
            } else {
                float min = (float) Math.min(i5, i4);
                float a7 = ((float) com.google.zxing.c.b.a.a(tVar11, tVar10)) / min;
                float a8 = (float) com.google.zxing.c.b.a.a(tVar12, tVar5);
                t tVar14 = new t(tVar5.f40584a + (((tVar5.f40584a - tVar12.f40584a) / a8) * a7), tVar5.f40585b + (a7 * ((tVar5.f40585b - tVar12.f40585b) / a8)));
                float a9 = ((float) com.google.zxing.c.b.a.a(tVar11, tVar12)) / min;
                float a10 = (float) com.google.zxing.c.b.a.a(tVar10, tVar5);
                t tVar15 = new t(tVar5.f40584a + (((tVar5.f40584a - tVar10.f40584a) / a10) * a9), tVar5.f40585b + (a9 * ((tVar5.f40585b - tVar10.f40585b) / a10)));
                if (!aVar.a(tVar14)) {
                    if (!aVar.a(tVar15)) {
                        tVar15 = null;
                    }
                } else if (!aVar.a(tVar15) || Math.abs(aVar.b(tVar12, tVar14).f39969c - aVar.b(tVar10, tVar14).f39969c) <= Math.abs(aVar.b(tVar12, tVar15).f39969c - aVar.b(tVar10, tVar15).f39969c)) {
                    tVar15 = tVar14;
                }
                if (tVar15 != null) {
                    tVar5 = tVar15;
                }
                int max = Math.max(aVar.b(tVar12, tVar5).f39969c, aVar.b(tVar10, tVar5).f39969c) + 1;
                if ((max & 1) == 1) {
                    max++;
                }
                int i9 = max;
                bVar = com.google.zxing.c.b.a.a(aVar.f39965a, tVar12, tVar11, tVar10, tVar5, i9, i9);
                tVar = tVar5;
            }
            g gVar = new g(bVar, new t[]{tVar12, tVar11, tVar10, tVar});
            eVar = this.f39940b.a(gVar.f39919d);
            tVarArr = gVar.f39920e;
        } else {
            b b2 = cVar.b();
            int[] b3 = b2.b();
            int[] c2 = b2.c();
            if (b3 == null || c2 == null) {
                throw m.getNotFoundInstance();
            }
            int i10 = b2.f39889a;
            int i11 = b3[0];
            int i12 = b3[1];
            while (i11 < i10 && b2.a(i11, i12)) {
                i11++;
            }
            if (i11 != i10) {
                int i13 = i11 - b3[0];
                if (i13 != 0) {
                    int i14 = b3[1];
                    int i15 = c2[1];
                    int i16 = b3[0];
                    int i17 = ((c2[0] - i16) + 1) / i13;
                    int i18 = ((i15 - i14) + 1) / i13;
                    if (i17 <= 0 || i18 <= 0) {
                        throw m.getNotFoundInstance();
                    }
                    int i19 = i13 / 2;
                    int i20 = i14 + i19;
                    int i21 = i16 + i19;
                    b bVar2 = new b(i17, i18);
                    for (int i22 = 0; i22 < i18; i22++) {
                        int i23 = (i22 * i13) + i20;
                        for (int i24 = 0; i24 < i17; i24++) {
                            if (b2.a((i24 * i13) + i21, i23)) {
                                bVar2.b(i24, i22);
                            }
                        }
                    }
                    eVar = this.f39940b.a(bVar2);
                    tVarArr = f39939a;
                } else {
                    throw m.getNotFoundInstance();
                }
            } else {
                throw m.getNotFoundInstance();
            }
        }
        r rVar = new r(eVar.f39912c, eVar.f39910a, tVarArr, com.google.zxing.a.DATA_MATRIX);
        List<byte[]> list = eVar.f39913d;
        if (list != null) {
            rVar.a(s.BYTE_SEGMENTS, list);
        }
        String str = eVar.f39914e;
        if (str != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, str);
        }
        return rVar;
    }
}
