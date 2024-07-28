package com.google.android.datatransport.runtime.e;

import android.util.SparseArray;
import com.google.android.datatransport.d;
import java.util.EnumMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<d> f7784a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static EnumMap<d, Integer> f7785b;

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>(d.class);
        f7785b = enumMap;
        enumMap.put(d.DEFAULT, 0);
        f7785b.put(d.VERY_LOW, 1);
        f7785b.put(d.HIGHEST, 2);
        for (d next : f7785b.keySet()) {
            f7784a.append(f7785b.get(next).intValue(), next);
        }
    }

    public static d a(int i2) {
        d dVar = f7784a.get(i2);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value ".concat(String.valueOf(i2)));
    }

    public static int a(d dVar) {
        Integer num = f7785b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value ".concat(String.valueOf(dVar)));
    }
}
