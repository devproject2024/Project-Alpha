package com.google.zxing.f;

import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.e;
import com.google.zxing.f.a.j;
import com.google.zxing.f.b.a;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.ArrayList;
import java.util.Map;

public final class b implements p {
    public final void a() {
    }

    public final r a(c cVar, Map<e, ?> map) throws m, h, d {
        ArrayList arrayList = new ArrayList();
        com.google.zxing.f.b.b a2 = a.a(cVar);
        for (t[] next : a2.f40462b) {
            com.google.zxing.b.e a3 = j.a(a2.f40461a, next[4], next[5], next[6], next[7], Math.min(Math.min(b(next[0], next[4]), (b(next[6], next[2]) * 17) / 18), Math.min(b(next[1], next[5]), (b(next[7], next[3]) * 17) / 18)), Math.max(Math.max(a(next[0], next[4]), (a(next[6], next[2]) * 17) / 18), Math.max(a(next[1], next[5]), (a(next[7], next[3]) * 17) / 18)));
            r rVar = new r(a3.f39912c, a3.f39910a, next, com.google.zxing.a.PDF_417);
            rVar.a(s.ERROR_CORRECTION_LEVEL, a3.f39914e);
            c cVar2 = (c) a3.f39917h;
            if (cVar2 != null) {
                rVar.a(s.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(rVar);
        }
        r[] rVarArr = (r[]) arrayList.toArray(new r[arrayList.size()]);
        if (rVarArr != null && rVarArr.length != 0 && rVarArr[0] != null) {
            return rVarArr[0];
        }
        throw m.getNotFoundInstance();
    }

    private static int a(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return 0;
        }
        return (int) Math.abs(tVar.f40584a - tVar2.f40584a);
    }

    private static int b(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(tVar.f40584a - tVar2.f40584a);
    }
}
