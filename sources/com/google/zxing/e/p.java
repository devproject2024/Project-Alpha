package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.e;
import com.google.zxing.e.a.a.d;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class p extends r {

    /* renamed from: a  reason: collision with root package name */
    private final r[] f40390a;

    public p(Map<e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(e.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13) || collection.contains(a.UPC_A) || collection.contains(a.EAN_8) || collection.contains(a.UPC_E)) {
                arrayList.add(new q(map));
            }
            if (collection.contains(a.CODE_39)) {
                arrayList.add(new e(z));
            }
            if (collection.contains(a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(a.ITF)) {
                arrayList.add(new n());
            }
            if (collection.contains(a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.RSS_14)) {
                arrayList.add(new com.google.zxing.e.a.e());
            }
            if (collection.contains(a.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new q(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new n());
            arrayList.add(new com.google.zxing.e.a.e());
            arrayList.add(new d());
        }
        this.f40390a = (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    public final r a(int i2, com.google.zxing.b.a aVar, Map<e, ?> map) throws m {
        r[] rVarArr = this.f40390a;
        int i3 = 0;
        while (i3 < rVarArr.length) {
            try {
                return rVarArr[i3].a(i2, aVar, map);
            } catch (q unused) {
                i3++;
            }
        }
        throw m.getNotFoundInstance();
    }

    public final void a() {
        for (r a2 : this.f40390a) {
            a2.a();
        }
    }
}
