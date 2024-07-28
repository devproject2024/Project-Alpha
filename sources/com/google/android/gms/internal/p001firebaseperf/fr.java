package com.google.android.gms.internal.p001firebaseperf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.fr  reason: invalid package */
final class fr {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9644a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final gg<?, ?> f9645b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final gg<?, ?> f9646c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final gg<?, ?> f9647d = new gi();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!dq.class.isAssignableFrom(cls) && (cls2 = f9644a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i2, List<Double> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.g(i2, list, z);
        }
    }

    public static void b(int i2, List<Float> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.f(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.c(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.d(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.n(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.e(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.l(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.a(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.j(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.m(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.b(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, ha haVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.i(i2, list, z);
        }
    }

    public static void a(int i2, List<String> list, ha haVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.a(i2, list);
        }
    }

    public static void b(int i2, List<co> list, ha haVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.b(i2, list);
        }
    }

    public static void a(int i2, List<?> list, ha haVar, fp fpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.a(i2, list, fpVar);
        }
    }

    public static void b(int i2, List<?> list, ha haVar, fp fpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            haVar.b(i2, list, fpVar);
        }
    }

    static int a(List<Long> list) {
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
                i2 += da.d(elVar.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * da.l(i2));
    }

    static int b(List<Long> list) {
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
                i2 += da.e(elVar.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.e(list.get(i3).longValue());
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
        return b(list) + (size * da.l(i2));
    }

    static int c(List<Long> list) {
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
                i2 += da.f(elVar.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.f(list.get(i3).longValue());
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
        return c(list) + (size * da.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dr) {
            dr drVar = (dr) list;
            i2 = 0;
            while (i3 < size) {
                i2 += da.p(drVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.p(list.get(i3).intValue());
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
        return d(list) + (size * da.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dr) {
            dr drVar = (dr) list;
            i2 = 0;
            while (i3 < size) {
                i2 += da.m(drVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.m(list.get(i3).intValue());
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
        return e(list) + (size * da.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dr) {
            dr drVar = (dr) list;
            i2 = 0;
            while (i3 < size) {
                i2 += da.n(drVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.n(list.get(i3).intValue());
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
        return f(list) + (size * da.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof dr) {
            dr drVar = (dr) list;
            i2 = 0;
            while (i3 < size) {
                i2 += da.o(drVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + da.o(list.get(i3).intValue());
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
        return g(list) + (size * da.l(i2));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * da.e(i2);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * da.g(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * da.k(i2);
    }

    static int k(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int l = da.l(i2) * size;
        if (list instanceof ej) {
            ej ejVar = (ej) list;
            while (i5 < size) {
                Object a2 = ejVar.a(i5);
                if (a2 instanceof co) {
                    i4 = da.b((co) a2);
                } else {
                    i4 = da.b((String) a2);
                }
                l += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof co) {
                    i3 = da.b((co) obj);
                } else {
                    i3 = da.b((String) obj);
                }
                l += i3;
                i5++;
            }
        }
        return l;
    }

    static int a(int i2, Object obj, fp fpVar) {
        if (obj instanceof eh) {
            return da.a(i2, (eh) obj);
        }
        return da.b(i2, (ex) obj, fpVar);
    }

    static int a(int i2, List<?> list, fp fpVar) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = da.l(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof eh) {
                i3 = da.a((eh) obj);
            } else {
                i3 = da.a((ex) obj, fpVar);
            }
            l += i3;
        }
        return l;
    }

    static int l(int i2, List<co> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * da.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += da.b(list.get(i3));
        }
        return l;
    }

    static int b(int i2, List<ex> list, fp fpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += da.c(i2, list.get(i4), fpVar);
        }
        return i3;
    }

    public static gg<?, ?> a() {
        return f9645b;
    }

    public static gg<?, ?> b() {
        return f9646c;
    }

    public static gg<?, ?> c() {
        return f9647d;
    }

    private static gg<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (gg) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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

    static <T> void a(eu euVar, T t, T t2, long j) {
        gm.a((Object) t, j, euVar.a(gm.f(t, j), gm.f(t2, j)));
    }

    static <T, FT extends dk<FT>> void a(dh<FT> dhVar, T t, T t2) {
        di<FT> a2 = dhVar.a((Object) t2);
        if (!a2.f9555a.isEmpty()) {
            di<FT> b2 = dhVar.b((Object) t);
            for (int i2 = 0; i2 < a2.f9555a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f9555a.b(i2));
            }
            for (Map.Entry<FieldDescriptorType, Object> a3 : a2.f9555a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(gg<UT, UB> ggVar, T t, T t2) {
        ggVar.a((Object) t, ggVar.b(ggVar.a(t), ggVar.a(t2)));
    }
}
