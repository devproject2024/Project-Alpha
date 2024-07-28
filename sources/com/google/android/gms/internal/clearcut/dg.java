package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

final class dg {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9282a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final dv<?, ?> f9283b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final dv<?, ?> f9284c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final dv<?, ?> f9285d = new dx();

    static int a(int i2, Object obj, de deVar) {
        return obj instanceof bt ? am.a(i2, (bt) obj) : am.b(i2, (cm) obj, deVar);
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * am.l(i2));
    }

    static int a(int i2, List<?> list, de deVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = am.l(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            l += obj instanceof bt ? am.a((bt) obj) : am.b((cm) obj, deVar);
        }
        return l;
    }

    static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ca) {
            ca caVar = (ca) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.d(caVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static dv<?, ?> a() {
        return f9283b;
    }

    private static dv<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (dv) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <UT, UB> UB a(int i2, int i3, UB ub, dv<UT, UB> dvVar) {
        if (ub == null) {
            ub = dvVar.a();
        }
        dvVar.a(ub, i2, (long) i3);
        return ub;
    }

    static <UT, UB> UB a(int i2, List<Integer> list, bj<?> bjVar, UB ub, dv<UT, UB> dvVar) {
        UB ub2;
        if (bjVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it2 = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (bjVar.a(intValue) == null) {
                        ub = a(i2, intValue, ub2, dvVar);
                        it2.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue2 = list.get(i4).intValue();
                if (bjVar.a(intValue2) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, dvVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    public static void a(int i2, List<String> list, ep epVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.a(i2, list);
        }
    }

    public static void a(int i2, List<?> list, ep epVar, de deVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.a(i2, list, deVar);
        }
    }

    public static void a(int i2, List<Double> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.g(i2, list, z);
        }
    }

    static <T> void a(ch chVar, T t, T t2, long j) {
        eb.a((Object) t, j, chVar.a(eb.f(t, j), eb.f(t2, j)));
    }

    static <T, UT, UB> void a(dv<UT, UB> dvVar, T t, T t2) {
        dvVar.a((Object) t, dvVar.c(dvVar.a(t), dvVar.a(t2)));
    }

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!bf.class.isAssignableFrom(cls) && (cls2 = f9282a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean a(int i2, int i3, int i4) {
        if (i3 < 40) {
            return true;
        }
        long j = (long) i4;
        return ((((long) i3) - ((long) i2)) + 1) + 9 <= ((2 * j) + 3) + ((j + 3) * 3);
    }

    static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int b(int i2, List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * am.l(i2));
    }

    static int b(int i2, List<cm> list, de deVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += am.c(i2, list.get(i4), deVar);
        }
        return i3;
    }

    static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ca) {
            ca caVar = (ca) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.e(caVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.e(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static dv<?, ?> b() {
        return f9284c;
    }

    public static void b(int i2, List<ab> list, ep epVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.b(i2, list);
        }
    }

    public static void b(int i2, List<?> list, ep epVar, de deVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.b(i2, list, deVar);
        }
    }

    public static void b(int i2, List<Float> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.f(i2, list, z);
        }
    }

    static int c(int i2, List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * am.l(i2));
    }

    static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ca) {
            ca caVar = (ca) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.f(caVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.f(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static dv<?, ?> c() {
        return f9285d;
    }

    public static void c(int i2, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.c(i2, list, z);
        }
    }

    static int d(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * am.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bg) {
            bg bgVar = (bg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.p(bgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.p(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(int i2, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.d(i2, list, z);
        }
    }

    static int e(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * am.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bg) {
            bg bgVar = (bg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.m(bgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.m(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(int i2, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.n(i2, list, z);
        }
    }

    static int f(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * am.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bg) {
            bg bgVar = (bg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.n(bgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.n(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void f(int i2, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.e(i2, list, z);
        }
    }

    static int g(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * am.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bg) {
            bg bgVar = (bg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += am.o(bgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + am.o(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void g(int i2, List<Long> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.l(i2, list, z);
        }
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * am.e(i2);
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    public static void h(int i2, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.a(i2, list, z);
        }
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * am.g(i2);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    public static void i(int i2, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.j(i2, list, z);
        }
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * am.k(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    public static void j(int i2, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.m(i2, list, z);
        }
    }

    static int k(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int l = am.l(i2) * size;
        if (list instanceof bv) {
            bv bvVar = (bv) list;
            while (i3 < size) {
                Object b2 = bvVar.b(i3);
                l += b2 instanceof ab ? am.b((ab) b2) : am.b((String) b2);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                l += obj instanceof ab ? am.b((ab) obj) : am.b((String) obj);
                i3++;
            }
        }
        return l;
    }

    public static void k(int i2, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.b(i2, list, z);
        }
    }

    static int l(int i2, List<ab> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * am.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += am.b(list.get(i3));
        }
        return l;
    }

    public static void l(int i2, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, ep epVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            epVar.i(i2, list, z);
        }
    }

    static <T, FT extends az<FT>> void a(as<FT> asVar, T t, T t2) {
        aw<FT> a2 = asVar.a((Object) t2);
        if (!a2.f9169a.isEmpty()) {
            aw<FT> b2 = asVar.b(t);
            for (int i2 = 0; i2 < a2.f9169a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f9169a.b(i2));
            }
            for (Map.Entry<FieldDescriptorType, Object> a3 : a2.f9169a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }
}
