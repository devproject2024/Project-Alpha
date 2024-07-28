package com.google.zxing.f.a;

import com.google.zxing.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Integer> f40429a = new HashMap();

    b() {
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        Integer num = this.f40429a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.f40429a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }

    /* access modifiers changed from: package-private */
    public final int[] a() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry next : this.f40429a.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i2) {
                i2 = ((Integer) next.getValue()).intValue();
                arrayList.clear();
                arrayList.add(next.getKey());
            } else if (((Integer) next.getValue()).intValue() == i2) {
                arrayList.add(next.getKey());
            }
        }
        return a.a((Collection<Integer>) arrayList);
    }
}
