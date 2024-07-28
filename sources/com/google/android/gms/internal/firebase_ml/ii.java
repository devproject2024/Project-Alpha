package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class ii {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9994a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final ix<?, ?> f9995b = a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final ix<?, ?> f9996c = a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final ix<?, ?> f9997d = new iz();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!gg.class.isAssignableFrom(cls) && (cls2 = f9994a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i2, List<Double> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.g(i2, list, z);
        }
    }

    public static void b(int i2, List<Float> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.f(i2, list, z);
        }
    }

    public static void c(int i2, List<Long> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.c(i2, list, z);
        }
    }

    public static void d(int i2, List<Long> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.d(i2, list, z);
        }
    }

    public static void e(int i2, List<Long> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.n(i2, list, z);
        }
    }

    public static void f(int i2, List<Long> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.e(i2, list, z);
        }
    }

    public static void g(int i2, List<Long> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.l(i2, list, z);
        }
    }

    public static void h(int i2, List<Integer> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.a(i2, list, z);
        }
    }

    public static void i(int i2, List<Integer> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.j(i2, list, z);
        }
    }

    public static void j(int i2, List<Integer> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.m(i2, list, z);
        }
    }

    public static void k(int i2, List<Integer> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.b(i2, list, z);
        }
    }

    public static void l(int i2, List<Integer> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.k(i2, list, z);
        }
    }

    public static void m(int i2, List<Integer> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.h(i2, list, z);
        }
    }

    public static void n(int i2, List<Boolean> list, s sVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.i(i2, list, z);
        }
    }

    public static void a(int i2, List<String> list, s sVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.a(i2, list);
        }
    }

    public static void b(int i2, List<fh> list, s sVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.b(i2, list);
        }
    }

    public static void a(int i2, List<?> list, s sVar, ig igVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.a(i2, list, igVar);
        }
    }

    public static void b(int i2, List<?> list, s sVar, ig igVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            sVar.b(i2, list, igVar);
        }
    }

    static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hb) {
            hb hbVar = (hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.d(hbVar.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int a(int i2, List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * ft.l(i2));
    }

    static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hb) {
            hb hbVar = (hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.e(hbVar.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.e(list.get(i3).longValue());
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
        return b(list) + (size * ft.l(i2));
    }

    static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hb) {
            hb hbVar = (hb) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.f(hbVar.a(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.f(list.get(i3).longValue());
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
        return c(list) + (size * ft.l(i2));
    }

    static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gi) {
            gi giVar = (gi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.p(giVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.p(list.get(i3).intValue());
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
        return d(list) + (size * ft.l(i2));
    }

    static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gi) {
            gi giVar = (gi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.m(giVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.m(list.get(i3).intValue());
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
        return e(list) + (size * ft.l(i2));
    }

    static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gi) {
            gi giVar = (gi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.n(giVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.n(list.get(i3).intValue());
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
        return f(list) + (size * ft.l(i2));
    }

    static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gi) {
            gi giVar = (gi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += ft.o(giVar.b(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + ft.o(list.get(i3).intValue());
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
        return g(list) + (size * ft.l(i2));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * ft.e(i2);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * ft.g(i2);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * ft.k(i2);
    }

    static int k(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int l = ft.l(i2) * size;
        if (list instanceof gz) {
            gz gzVar = (gz) list;
            while (i5 < size) {
                Object a2 = gzVar.a(i5);
                if (a2 instanceof fh) {
                    i4 = ft.b((fh) a2);
                } else {
                    i4 = ft.b((String) a2);
                }
                l += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof fh) {
                    i3 = ft.b((fh) obj);
                } else {
                    i3 = ft.b((String) obj);
                }
                l += i3;
                i5++;
            }
        }
        return l;
    }

    static int a(int i2, Object obj, ig igVar) {
        if (obj instanceof gx) {
            return ft.a(i2, (gx) obj);
        }
        return ft.b(i2, (hn) obj, igVar);
    }

    static int a(int i2, List<?> list, ig igVar) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = ft.l(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof gx) {
                i3 = ft.a((gx) obj);
            } else {
                i3 = ft.a((hn) obj, igVar);
            }
            l += i3;
        }
        return l;
    }

    static int l(int i2, List<fh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = size * ft.l(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            l += ft.b(list.get(i3));
        }
        return l;
    }

    static int b(int i2, List<hn> list, ig igVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += ft.c(i2, list.get(i4), igVar);
        }
        return i3;
    }

    public static ix<?, ?> a() {
        return f9995b;
    }

    public static ix<?, ?> b() {
        return f9996c;
    }

    public static ix<?, ?> c() {
        return f9997d;
    }

    private static ix<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (ix) e2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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

    static <T> void a(hk hkVar, T t, T t2, long j) {
        d.a((Object) t, j, hkVar.a(d.f(t, j), d.f(t2, j)));
    }

    static <T, FT extends gb<FT>> void a(fy<FT> fyVar, T t, T t2) {
        fz<FT> a2 = fyVar.a((Object) t2);
        if (!a2.f9908a.isEmpty()) {
            fz<FT> b2 = fyVar.b((Object) t);
            for (int i2 = 0; i2 < a2.f9908a.b(); i2++) {
                b2.a((Map.Entry<FT, Object>) a2.f9908a.b(i2));
            }
            for (Map.Entry<T, Object> a3 : a2.f9908a.c()) {
                b2.a((Map.Entry<FT, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(ix<UT, UB> ixVar, T t, T t2) {
        ixVar.a((Object) t, ixVar.b(ixVar.a(t), ixVar.a(t2)));
    }
}
