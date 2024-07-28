package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.e;
import com.google.zxing.m;
import com.google.zxing.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class q extends r {

    /* renamed from: a  reason: collision with root package name */
    private final y[] f40391a;

    public q(Map<e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(e.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13)) {
                arrayList.add(new i());
            } else if (collection.contains(a.UPC_A)) {
                arrayList.add(new t());
            }
            if (collection.contains(a.EAN_8)) {
                arrayList.add(new k());
            }
            if (collection.contains(a.UPC_E)) {
                arrayList.add(new aa());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new i());
            arrayList.add(new k());
            arrayList.add(new aa());
        }
        this.f40391a = (y[]) arrayList.toArray(new y[arrayList.size()]);
    }

    public final r a(int i2, com.google.zxing.b.a aVar, Map<e, ?> map) throws m {
        Collection collection;
        boolean z;
        int[] a2 = y.a(aVar);
        y[] yVarArr = this.f40391a;
        int i3 = 0;
        while (i3 < yVarArr.length) {
            try {
                r a3 = yVarArr[i3].a(i2, aVar, a2, map);
                boolean z2 = a3.f40580d == a.EAN_13 && a3.f40577a.charAt(0) == '0';
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(e.POSSIBLE_FORMATS);
                }
                if (collection != null) {
                    if (!collection.contains(a.UPC_A)) {
                        z = false;
                        if (z2 || !z) {
                            return a3;
                        }
                        r rVar = new r(a3.f40577a.substring(1), a3.f40578b, a3.f40579c, a.UPC_A);
                        rVar.a(a3.f40581e);
                        return rVar;
                    }
                }
                z = true;
                if (z2) {
                }
                return a3;
            } catch (com.google.zxing.q unused) {
                i3++;
            }
        }
        throw m.getNotFoundInstance();
    }

    public final void a() {
        for (y a2 : this.f40391a) {
            a2.a();
        }
    }
}
