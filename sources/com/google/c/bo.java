package com.google.c;

import com.google.c.ac;
import com.google.c.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

final class bo {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f37773a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final bt<?, ?> f37774b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final bt<?, ?> f37775c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final bt<?, ?> f37776d = new bv();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!aa.class.isAssignableFrom(cls) && (cls2 = f37773a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i2, List<Double> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.g(i2, list, z);
        }
    }

    public static void b(int i2, List<Float> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.f(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.c(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.d(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.n(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.e(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.l(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.a(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.j(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.m(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.b(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, ca caVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.i(i2, list, z);
        }
    }

    public static void a(int i2, List<String> list, ca caVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.a(i2, list);
        }
    }

    public static void b(int i2, List<j> list, ca caVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.b(i2, list);
        }
    }

    public static void a(int i2, List<?> list, ca caVar, bm bmVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.a(i2, list, bmVar);
        }
    }

    public static void b(int i2, List<?> list, ca caVar, bm bmVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            caVar.b(i2, list, bmVar);
        }
    }

    static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ak) {
            ak akVar = (ak) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.d(akVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * m.l(i2));
    }

    static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ak) {
            ak akVar = (ak) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.e(akVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.e(list.get(i3).longValue());
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
        return b(list) + (size * m.l(i2));
    }

    static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ak) {
            ak akVar = (ak) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.f(akVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.f(list.get(i3).longValue());
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
        return c(list) + (size * m.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ab) {
            ab abVar = (ab) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.p(abVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.p(list.get(i3).intValue());
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
        return d(list) + (size * m.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ab) {
            ab abVar = (ab) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.m(abVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.m(list.get(i3).intValue());
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
        return e(list) + (size * m.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ab) {
            ab abVar = (ab) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.n(abVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.n(list.get(i3).intValue());
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
        return f(list) + (size * m.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ab) {
            ab abVar = (ab) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.o(abVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + m.o(list.get(i3).intValue());
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
        return g(list) + (size * m.l(i2));
    }

    static int h(List<?> list) {
        return list.size() * 4;
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * m.e(i2);
    }

    static int i(List<?> list) {
        return list.size() * 8;
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * m.g(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * m.k(i2);
    }

    static int k(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int l = m.l(i2) * size;
        if (list instanceof ai) {
            ai aiVar = (ai) list;
            while (i5 < size) {
                Object b2 = aiVar.b(i5);
                if (b2 instanceof j) {
                    i4 = m.b((j) b2);
                } else {
                    i4 = m.b((String) b2);
                }
                l += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof j) {
                    i3 = m.b((j) obj);
                } else {
                    i3 = m.b((String) obj);
                }
                l += i3;
                i5++;
            }
        }
        return l;
    }

    static int a(int i2, Object obj, bm bmVar) {
        if (obj instanceof ag) {
            return m.a(i2, (ag) obj);
        }
        return m.b(i2, (at) obj, bmVar);
    }

    static int a(int i2, List<?> list, bm bmVar) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = m.l(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof ag) {
                i3 = m.a((ag) obj);
            } else {
                i3 = m.a((at) obj, bmVar);
            }
            l += i3;
        }
        return l;
    }

    static int l(int i2, List<j> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * m.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += m.b(list.get(i3));
        }
        return l;
    }

    static int b(int i2, List<at> list, bm bmVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += m.c(i2, list.get(i4), bmVar);
        }
        return i3;
    }

    public static bt<?, ?> a() {
        return f37774b;
    }

    public static bt<?, ?> b() {
        return f37775c;
    }

    public static bt<?, ?> c() {
        return f37776d;
    }

    private static bt<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (bt) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
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

    static <T> void a(ao aoVar, T t, T t2, long j) {
        bx.a((Object) t, j, aoVar.a(bx.f(t, j), bx.f(t2, j)));
    }

    static <T, FT extends w.a<FT>> void a(s<FT> sVar, T t, T t2) {
        w<FT> a2 = sVar.a((Object) t2);
        if (!a2.f37925a.isEmpty()) {
            w<FT> b2 = sVar.b(t);
            for (int i2 = 0; i2 < a2.f37925a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f37925a.b(i2));
            }
            for (Map.Entry<T, Object> a3 : a2.f37925a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(bt<UT, UB> btVar, T t, T t2) {
        btVar.a((Object) t, btVar.c(btVar.b(t), btVar.b(t2)));
    }

    static <UT, UB> UB a(int i2, List<Integer> list, ac.d<?> dVar, UB ub, bt<UT, UB> btVar) {
        UB ub2;
        if (dVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it2 = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (dVar.a() == null) {
                        ub = a(i2, intValue, ub2, btVar);
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
                if (dVar.a() != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, btVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i2, List<Integer> list, ac.e eVar, UB ub, bt<UT, UB> btVar) {
        UB ub2;
        if (eVar == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it2 = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (!eVar.a()) {
                        ub = a(i2, intValue, ub2, btVar);
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
                if (eVar.a()) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue2));
                    }
                    i3++;
                } else {
                    ub2 = a(i2, intValue2, ub2, btVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i2, int i3, UB ub, bt<UT, UB> btVar) {
        if (ub == null) {
            ub = btVar.a();
        }
        btVar.a(ub, i2, (long) i3);
        return ub;
    }
}
