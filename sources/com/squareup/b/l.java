package com.squareup.b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

abstract class l<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<? super Map.Entry<Integer, ?>> f16076b = new Comparator<Map.Entry<Integer, ?>>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Integer) ((Map.Entry) obj).getKey()).compareTo((Integer) ((Map.Entry) obj2).getKey());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    List<T> f16077a;

    public abstract T a(int i2);

    public abstract boolean b(int i2);

    private static <T> List<T> b(Map<Integer, T> map) {
        TreeSet treeSet = new TreeSet(f16076b);
        treeSet.addAll(map.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(((Map.Entry) it2.next()).getValue());
        }
        return arrayList;
    }

    protected l(Map<Integer, T> map) {
        this.f16077a = b(map);
    }

    static final class a<T> extends l<T> {

        /* renamed from: b  reason: collision with root package name */
        Object[] f16078b;

        /* renamed from: c  reason: collision with root package name */
        int f16079c = -1;

        a(Map<Integer, T> map, int i2) {
            super(map);
            this.f16079c = i2;
            this.f16078b = new Object[(i2 + 1)];
            for (Map.Entry next : map.entrySet()) {
                Integer num = (Integer) next.getKey();
                if (num.intValue() > 0) {
                    this.f16078b[num.intValue()] = next.getValue();
                } else {
                    throw new IllegalArgumentException("Input map key is negative or zero");
                }
            }
        }

        public final T a(int i2) {
            if (i2 > this.f16079c) {
                return null;
            }
            return this.f16078b[i2];
        }

        public final boolean b(int i2) {
            if (i2 <= this.f16079c && this.f16078b[i2] != null) {
                return true;
            }
            return false;
        }
    }

    static final class b<T> extends l<T> {

        /* renamed from: b  reason: collision with root package name */
        Map<Integer, T> f16080b;

        b(Map<Integer, T> map) {
            super(map);
            this.f16080b = map;
        }

        public final T a(int i2) {
            return this.f16080b.get(Integer.valueOf(i2));
        }

        public final boolean b(int i2) {
            return this.f16080b.containsKey(Integer.valueOf(i2));
        }
    }

    public static <T> l<T> a(Map<Integer, T> map) {
        int i2 = -1;
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            if (intValue2 > i2) {
                i2 = intValue2;
            }
        }
        return i2 <= 64 || ((((float) map.size()) / ((float) i2)) > 0.75f ? 1 : ((((float) map.size()) / ((float) i2)) == 0.75f ? 0 : -1)) > 0 ? new a(map, i2) : new b(map);
    }
}
