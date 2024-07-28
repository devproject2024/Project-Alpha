package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

final class gk {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f11179a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final ha<?, ?> f11180b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final ha<?, ?> f11181c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final ha<?, ?> f11182d = new hc();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!ej.class.isAssignableFrom(cls) && (cls2 = f11179a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i2, List<Double> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.g(i2, list, z);
        }
    }

    public static void b(int i2, List<Float> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.f(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.c(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.d(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.n(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.e(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.l(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.a(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.j(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.m(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.b(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, hx hxVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.i(i2, list, z);
        }
    }

    public static void a(int i2, List<String> list, hx hxVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.a(i2, list);
        }
    }

    public static void b(int i2, List<cz> list, hx hxVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.b(i2, list);
        }
    }

    public static void a(int i2, List<?> list, hx hxVar, gi giVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.a(i2, list, giVar);
        }
    }

    public static void b(int i2, List<?> list, hx hxVar, gi giVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            hxVar.b(i2, list, giVar);
        }
    }

    static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.d(fgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * dr.l(i2));
    }

    static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.e(fgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.e(list.get(i3).longValue());
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
        return b(list) + (size * dr.l(i2));
    }

    static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.f(fgVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.f(list.get(i3).longValue());
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
        return c(list) + (size * dr.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof el) {
            el elVar = (el) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.p(elVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.p(list.get(i3).intValue());
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
        return d(list) + (size * dr.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof el) {
            el elVar = (el) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.m(elVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.m(list.get(i3).intValue());
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
        return e(list) + (size * dr.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof el) {
            el elVar = (el) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.n(elVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.n(list.get(i3).intValue());
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
        return f(list) + (size * dr.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof el) {
            el elVar = (el) list;
            i2 = 0;
            while (i3 < size) {
                i2 += dr.o(elVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + dr.o(list.get(i3).intValue());
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
        return g(list) + (size * dr.l(i2));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * dr.e(i2);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * dr.g(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * dr.k(i2);
    }

    static int k(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int l = dr.l(i2) * size;
        if (list instanceof fa) {
            fa faVar = (fa) list;
            while (i5 < size) {
                Object b2 = faVar.b(i5);
                if (b2 instanceof cz) {
                    i4 = dr.b((cz) b2);
                } else {
                    i4 = dr.b((String) b2);
                }
                l += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof cz) {
                    i3 = dr.b((cz) obj);
                } else {
                    i3 = dr.b((String) obj);
                }
                l += i3;
                i5++;
            }
        }
        return l;
    }

    static int a(int i2, Object obj, gi giVar) {
        if (obj instanceof ey) {
            return dr.a(i2, (ey) obj);
        }
        return dr.b(i2, (ft) obj, giVar);
    }

    static int a(int i2, List<?> list, gi giVar) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = dr.l(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof ey) {
                i3 = dr.a((ey) obj);
            } else {
                i3 = dr.a((ft) obj, giVar);
            }
            l += i3;
        }
        return l;
    }

    static int l(int i2, List<cz> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * dr.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += dr.b(list.get(i3));
        }
        return l;
    }

    static int b(int i2, List<ft> list, gi giVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += dr.c(i2, list.get(i4), giVar);
        }
        return i3;
    }

    public static ha<?, ?> a() {
        return f11180b;
    }

    public static ha<?, ?> b() {
        return f11181c;
    }

    public static ha<?, ?> c() {
        return f11182d;
    }

    private static ha<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (ha) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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

    static <T> void a(fl flVar, T t, T t2, long j) {
        hg.a((Object) t, j, flVar.a(hg.f(t, j), hg.f(t2, j)));
    }

    static <T, FT extends eb<FT>> void a(dw<FT> dwVar, T t, T t2) {
        dz<FT> a2 = dwVar.a((Object) t2);
        if (!a2.f11075a.isEmpty()) {
            dz<FT> b2 = dwVar.b(t);
            for (int i2 = 0; i2 < a2.f11075a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f11075a.b(i2));
            }
            for (Map.Entry<T, Object> a3 : a2.f11075a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(ha<UT, UB> haVar, T t, T t2) {
        haVar.a((Object) t, haVar.c(haVar.b(t), haVar.b(t2)));
    }

    static <UT, UB> UB a(int i2, List<Integer> list, em<?> emVar, UB ub, ha<UT, UB> haVar) {
        UB ub2;
        if (emVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it2 = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (emVar.a(intValue) == null) {
                        ub = a(i2, intValue, ub2, haVar);
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
                if (emVar.a(intValue2) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, haVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i2, List<Integer> list, ep epVar, UB ub, ha<UT, UB> haVar) {
        UB ub2;
        if (epVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it2 = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (!epVar.a(intValue)) {
                        ub = a(i2, intValue, ub2, haVar);
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
                if (epVar.a(intValue2)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, haVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i2, int i3, UB ub, ha<UT, UB> haVar) {
        if (ub == null) {
            ub = haVar.a();
        }
        haVar.a(ub, i2, (long) i3);
        return ub;
    }
}
