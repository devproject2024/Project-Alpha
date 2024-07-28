package kotlin.g.b;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.a.a;
import kotlin.g.b.a.b;
import kotlin.g.b.a.c;
import kotlin.g.b.a.d;
import kotlin.g.b.a.e;
import kotlin.g.b.a.f;

public class ab {
    private static <T extends Throwable> T a(T t) {
        return k.a(t, ab.class.getName());
    }

    private static void a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        throw ((ClassCastException) a(new ClassCastException(name + " cannot be cast to " + str)));
    }

    public static Iterable a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof c)) {
            a(obj, "kotlin.collections.MutableIterable");
        }
        return f(obj);
    }

    private static Iterable f(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw ((ClassCastException) a(e2));
        }
    }

    public static Collection b(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            a(obj, "kotlin.collections.MutableCollection");
        }
        return g(obj);
    }

    private static Collection g(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw ((ClassCastException) a(e2));
        }
    }

    public static List c(Object obj) {
        if ((obj instanceof a) && !(obj instanceof d)) {
            a(obj, "kotlin.collections.MutableList");
        }
        return h(obj);
    }

    private static List h(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw ((ClassCastException) a(e2));
        }
    }

    public static boolean d(Object obj) {
        if (obj instanceof Set) {
            return !(obj instanceof a) || (obj instanceof f);
        }
        return false;
    }

    public static Map e(Object obj) {
        if ((obj instanceof a) && !(obj instanceof e)) {
            a(obj, "kotlin.collections.MutableMap");
        }
        return i(obj);
    }

    private static Map i(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw ((ClassCastException) a(e2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00b9, code lost:
        if (r0 == r4) goto L_0x00bd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r3, int r4) {
        /*
            if (r3 == 0) goto L_0x00cc
            boolean r0 = r3 instanceof kotlin.c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00bc
            boolean r0 = r3 instanceof kotlin.g.b.h
            if (r0 == 0) goto L_0x0015
            r0 = r3
            kotlin.g.b.h r0 = (kotlin.g.b.h) r0
            int r0 = r0.getArity()
            goto L_0x00b9
        L_0x0015:
            boolean r0 = r3 instanceof kotlin.g.a.a
            if (r0 == 0) goto L_0x001c
            r0 = 0
            goto L_0x00b9
        L_0x001c:
            boolean r0 = r3 instanceof kotlin.g.a.b
            if (r0 == 0) goto L_0x0023
            r0 = 1
            goto L_0x00b9
        L_0x0023:
            boolean r0 = r3 instanceof kotlin.g.a.m
            if (r0 == 0) goto L_0x002a
            r0 = 2
            goto L_0x00b9
        L_0x002a:
            boolean r0 = r3 instanceof kotlin.g.a.q
            if (r0 == 0) goto L_0x0031
            r0 = 3
            goto L_0x00b9
        L_0x0031:
            boolean r0 = r3 instanceof kotlin.g.a.r
            if (r0 == 0) goto L_0x0038
            r0 = 4
            goto L_0x00b9
        L_0x0038:
            boolean r0 = r3 instanceof kotlin.g.a.s
            if (r0 == 0) goto L_0x003f
            r0 = 5
            goto L_0x00b9
        L_0x003f:
            boolean r0 = r3 instanceof kotlin.g.a.t
            if (r0 == 0) goto L_0x0046
            r0 = 6
            goto L_0x00b9
        L_0x0046:
            boolean r0 = r3 instanceof kotlin.g.a.u
            if (r0 == 0) goto L_0x004d
            r0 = 7
            goto L_0x00b9
        L_0x004d:
            boolean r0 = r3 instanceof kotlin.g.a.v
            if (r0 == 0) goto L_0x0055
            r0 = 8
            goto L_0x00b9
        L_0x0055:
            boolean r0 = r3 instanceof kotlin.g.a.w
            if (r0 == 0) goto L_0x005d
            r0 = 9
            goto L_0x00b9
        L_0x005d:
            boolean r0 = r3 instanceof kotlin.g.a.c
            if (r0 == 0) goto L_0x0064
            r0 = 10
            goto L_0x00b9
        L_0x0064:
            boolean r0 = r3 instanceof kotlin.g.a.d
            if (r0 == 0) goto L_0x006b
            r0 = 11
            goto L_0x00b9
        L_0x006b:
            boolean r0 = r3 instanceof kotlin.g.a.e
            if (r0 == 0) goto L_0x0072
            r0 = 12
            goto L_0x00b9
        L_0x0072:
            boolean r0 = r3 instanceof kotlin.g.a.f
            if (r0 == 0) goto L_0x0079
            r0 = 13
            goto L_0x00b9
        L_0x0079:
            boolean r0 = r3 instanceof kotlin.g.a.g
            if (r0 == 0) goto L_0x0080
            r0 = 14
            goto L_0x00b9
        L_0x0080:
            boolean r0 = r3 instanceof kotlin.g.a.h
            if (r0 == 0) goto L_0x0087
            r0 = 15
            goto L_0x00b9
        L_0x0087:
            boolean r0 = r3 instanceof kotlin.g.a.i
            if (r0 == 0) goto L_0x008e
            r0 = 16
            goto L_0x00b9
        L_0x008e:
            boolean r0 = r3 instanceof kotlin.g.a.j
            if (r0 == 0) goto L_0x0095
            r0 = 17
            goto L_0x00b9
        L_0x0095:
            boolean r0 = r3 instanceof kotlin.g.a.k
            if (r0 == 0) goto L_0x009c
            r0 = 18
            goto L_0x00b9
        L_0x009c:
            boolean r0 = r3 instanceof kotlin.g.a.l
            if (r0 == 0) goto L_0x00a3
            r0 = 19
            goto L_0x00b9
        L_0x00a3:
            boolean r0 = r3 instanceof kotlin.g.a.n
            if (r0 == 0) goto L_0x00aa
            r0 = 20
            goto L_0x00b9
        L_0x00aa:
            boolean r0 = r3 instanceof kotlin.g.a.o
            if (r0 == 0) goto L_0x00b1
            r0 = 21
            goto L_0x00b9
        L_0x00b1:
            boolean r0 = r3 instanceof kotlin.g.a.p
            if (r0 == 0) goto L_0x00b8
            r0 = 22
            goto L_0x00b9
        L_0x00b8:
            r0 = -1
        L_0x00b9:
            if (r0 != r4) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r1 = 0
        L_0x00bd:
            if (r1 != 0) goto L_0x00cc
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = "kotlin.jvm.functions.Function"
            java.lang.String r4 = r0.concat(r4)
            a((java.lang.Object) r3, (java.lang.String) r4)
        L_0x00cc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.g.b.ab.a(java.lang.Object, int):java.lang.Object");
    }
}
