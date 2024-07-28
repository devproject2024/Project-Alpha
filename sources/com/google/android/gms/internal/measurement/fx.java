package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

final class fx {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f10671a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final gm<?, ?> f10672b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final gm<?, ?> f10673c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final gm<?, ?> f10674d = new go();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!dv.class.isAssignableFrom(cls) && (cls2 = f10671a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i2, List<Double> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.g(i2, list, z);
        }
    }

    public static void b(int i2, List<Float> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.f(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.c(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.d(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.n(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.e(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.l(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.a(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.j(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.m(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.b(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, hk hkVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.i(i2, list, z);
        }
    }

    public static void a(int i2, List<String> list, hk hkVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.a(i2, list);
        }
    }

    public static void b(int i2, List<cm> list, hk hkVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.b(i2, list);
        }
    }

    public static void a(int i2, List<?> list, hk hkVar, fv fvVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.a(i2, list, fvVar);
        }
    }

    public static void b(int i2, List<?> list, hk hkVar, fv fvVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hkVar.b(i2, list, fvVar);
        }
    }

    static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof et) {
            et etVar = (et) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.d(etVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * de.l(i2));
    }

    static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof et) {
            et etVar = (et) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.e(etVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.e(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int b(int i2, List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * de.l(i2));
    }

    static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof et) {
            et etVar = (et) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.f(etVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.f(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int c(int i2, List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * de.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.p(dyVar.c(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.p(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int d(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * de.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.m(dyVar.c(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.m(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int e(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * de.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.n(dyVar.c(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.n(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int f(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * de.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            i2 = 0;
            while (i3 < size) {
                i2 += de.o(dyVar.c(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + de.o(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int g(int i2, List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * de.l(i2));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * de.e(i2);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * de.g(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * de.k(i2);
    }

    static int k(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int l = de.l(i2) * size;
        if (list instanceof em) {
            em emVar = (em) list;
            while (i5 < size) {
                Object b2 = emVar.b(i5);
                if (b2 instanceof cm) {
                    i4 = de.b((cm) b2);
                } else {
                    i4 = de.b((String) b2);
                }
                l += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof cm) {
                    i3 = de.b((cm) obj);
                } else {
                    i3 = de.b((String) obj);
                }
                l += i3;
                i5++;
            }
        }
        return l;
    }

    static int a(int i2, Object obj, fv fvVar) {
        if (obj instanceof ek) {
            return de.a(i2, (ek) obj);
        }
        return de.b(i2, (ff) obj, fvVar);
    }

    static int a(int i2, List<?> list, fv fvVar) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = de.l(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof ek) {
                i3 = de.a((ek) obj);
            } else {
                i3 = de.a((ff) obj, fvVar);
            }
            l += i3;
        }
        return l;
    }

    static int l(int i2, List<cm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * de.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += de.b(list.get(i3));
        }
        return l;
    }

    static int b(int i2, List<ff> list, fv fvVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += de.c(i2, list.get(i4), fvVar);
        }
        return i3;
    }

    public static gm<?, ?> a() {
        return f10672b;
    }

    public static gm<?, ?> b() {
        return f10673c;
    }

    public static gm<?, ?> c() {
        return f10674d;
    }

    private static gm<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (gm) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void a(ey eyVar, T t, T t2, long j) {
        gt.a((Object) t, j, eyVar.a(gt.f(t, j), gt.f(t2, j)));
    }

    static <T, FT extends dp<FT>> void a(dj<FT> djVar, T t, T t2) {
        dn<FT> a2 = djVar.a((Object) t2);
        if (!a2.f10582a.isEmpty()) {
            dn<FT> b2 = djVar.b((Object) t);
            for (int i2 = 0; i2 < a2.f10582a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f10582a.b(i2));
            }
            for (Map.Entry<T, Object> a3 : a2.f10582a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(gm<UT, UB> gmVar, T t, T t2) {
        gmVar.a((Object) t, gmVar.c(gmVar.b(t), gmVar.b(t2)));
    }

    static <UT, UB> UB a(int i2, List<Integer> list, ec ecVar, UB ub, gm<UT, UB> gmVar) {
        UB ub2;
        if (ecVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it2 = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (!ecVar.a(intValue)) {
                        ub = a(i2, intValue, ub2, gmVar);
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
                if (ecVar.a(intValue2)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, gmVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i2, int i3, UB ub, gm<UT, UB> gmVar) {
        if (ub == null) {
            ub = gmVar.a();
        }
        gmVar.a(ub, i2, (long) i3);
        return ub;
    }
}
