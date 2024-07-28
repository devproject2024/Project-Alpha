package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class dt {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f10177a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final ei<?, ?> f10178b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final ei<?, ?> f10179c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final ei<?, ?> f10180d = new ek();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!bv.class.isAssignableFrom(cls) && (cls2 = f10177a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i2, List<Double> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.g(i2, list, z);
        }
    }

    public static void b(int i2, List<Float> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.f(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.c(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.d(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.n(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.e(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.l(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.a(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.j(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.m(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.b(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, fc fcVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.i(i2, list, z);
        }
    }

    public static void a(int i2, List<String> list, fc fcVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.a(i2, list);
        }
    }

    public static void b(int i2, List<at> list, fc fcVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.b(i2, list);
        }
    }

    public static void a(int i2, List<?> list, fc fcVar, dr drVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.a(i2, list, drVar);
        }
    }

    public static void b(int i2, List<?> list, fc fcVar, dr drVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            fcVar.b(i2, list, drVar);
        }
    }

    static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cq) {
            cq cqVar = (cq) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.d(cqVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * bf.l(i2));
    }

    static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cq) {
            cq cqVar = (cq) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.e(cqVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.e(list.get(i3).longValue());
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
        return b(list) + (size * bf.l(i2));
    }

    static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof cq) {
            cq cqVar = (cq) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.f(cqVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.f(list.get(i3).longValue());
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
        return c(list) + (size * bf.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.p(byVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.p(list.get(i3).intValue());
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
        return d(list) + (size * bf.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.m(byVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.m(list.get(i3).intValue());
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
        return e(list) + (size * bf.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.n(byVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.n(list.get(i3).intValue());
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
        return f(list) + (size * bf.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof by) {
            by byVar = (by) list;
            i2 = 0;
            while (i3 < size) {
                i2 += bf.o(byVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + bf.o(list.get(i3).intValue());
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
        return g(list) + (size * bf.l(i2));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bf.e(i2);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bf.g(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bf.k(i2);
    }

    static int k(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int l = bf.l(i2) * size;
        if (list instanceof co) {
            co coVar = (co) list;
            while (i5 < size) {
                Object b2 = coVar.b(i5);
                if (b2 instanceof at) {
                    i4 = bf.b((at) b2);
                } else {
                    i4 = bf.b((String) b2);
                }
                l += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof at) {
                    i3 = bf.b((at) obj);
                } else {
                    i3 = bf.b((String) obj);
                }
                l += i3;
                i5++;
            }
        }
        return l;
    }

    static int a(int i2, Object obj, dr drVar) {
        if (obj instanceof cm) {
            return bf.a(i2, (cm) obj);
        }
        return bf.b(i2, (dd) obj, drVar);
    }

    static int a(int i2, List<?> list, dr drVar) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = bf.l(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof cm) {
                i3 = bf.a((cm) obj);
            } else {
                i3 = bf.a((dd) obj, drVar);
            }
            l += i3;
        }
        return l;
    }

    static int l(int i2, List<at> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * bf.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += bf.b(list.get(i3));
        }
        return l;
    }

    static int b(int i2, List<dd> list, dr drVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += bf.c(i2, list.get(i4), drVar);
        }
        return i3;
    }

    public static ei<?, ?> a() {
        return f10178b;
    }

    public static ei<?, ?> b() {
        return f10179c;
    }

    public static ei<?, ?> c() {
        return f10180d;
    }

    private static ei<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (ei) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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

    static <T> void a(cw cwVar, T t, T t2, long j) {
        eo.a((Object) t, j, cwVar.a(eo.f(t, j), eo.f(t2, j)));
    }

    static <T, FT extends bs<FT>> void a(bl<FT> blVar, T t, T t2) {
        bq<FT> a2 = blVar.a((Object) t2);
        if (!a2.f10100a.isEmpty()) {
            bq<FT> b2 = blVar.b((Object) t);
            for (int i2 = 0; i2 < a2.f10100a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f10100a.b(i2));
            }
            for (Map.Entry<FieldDescriptorType, Object> a3 : a2.f10100a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(ei<UT, UB> eiVar, T t, T t2) {
        eiVar.a((Object) t, eiVar.b(eiVar.a(t), eiVar.a(t2)));
    }
}
