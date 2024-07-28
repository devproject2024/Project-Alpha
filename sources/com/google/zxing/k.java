package com.google.zxing;

import com.google.zxing.a.b;
import com.google.zxing.e.p;
import com.google.zxing.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class k implements p {

    /* renamed from: a  reason: collision with root package name */
    private Map<e, ?> f40564a;

    /* renamed from: b  reason: collision with root package name */
    private p[] f40565b;

    public final r a(c cVar, Map<e, ?> map) throws m {
        a(map);
        return b(cVar);
    }

    public final r a(c cVar) throws m {
        if (this.f40565b == null) {
            a((Map<e, ?>) null);
        }
        return b(cVar);
    }

    public final void a(Map<e, ?> map) {
        Collection collection;
        this.f40564a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(e.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new p(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new com.google.zxing.c.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new com.google.zxing.f.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new com.google.zxing.d.a());
            }
            if (z && z2) {
                arrayList.add(new p(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new p(map));
            }
            arrayList.add(new a());
            arrayList.add(new com.google.zxing.c.a());
            arrayList.add(new b());
            arrayList.add(new com.google.zxing.f.b());
            arrayList.add(new com.google.zxing.d.a());
            if (z2) {
                arrayList.add(new p(map));
            }
        }
        this.f40565b = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    public final void a() {
        p[] pVarArr = this.f40565b;
        if (pVarArr != null) {
            for (p a2 : pVarArr) {
                a2.a();
            }
        }
    }

    private r b(c cVar) throws m {
        p[] pVarArr = this.f40565b;
        if (pVarArr != null) {
            int length = pVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    return pVarArr[i2].a(cVar, this.f40564a);
                } catch (q unused) {
                    i2++;
                }
            }
        }
        throw m.getNotFoundInstance();
    }
}
