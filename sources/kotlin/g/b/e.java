package kotlin.g.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.k;
import kotlin.g.a.b;
import kotlin.g.a.d;
import kotlin.g.a.f;
import kotlin.g.a.g;
import kotlin.g.a.h;
import kotlin.g.a.i;
import kotlin.g.a.j;
import kotlin.g.a.l;
import kotlin.g.a.m;
import kotlin.g.a.n;
import kotlin.g.a.o;
import kotlin.g.a.p;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.s;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.v;
import kotlin.g.a.w;
import kotlin.k.c;

public final class e implements d, c<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f47922a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f47923c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f47924d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f47925e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f47926f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, String> f47927g;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f47928b;

    public e(Class<?> cls) {
        k.d(cls, "jClass");
        this.f47928b = cls;
    }

    public final Class<?> a() {
        return this.f47928b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && k.a((Object) kotlin.g.a.b(this), (Object) kotlin.g.a.b((c) obj));
    }

    public final int hashCode() {
        return kotlin.g.a.b(this).hashCode();
    }

    public final String toString() {
        return this.f47928b.toString() + " (Kotlin reflection is not available)";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        int i2 = 0;
        Iterable b2 = k.b((T[]) new Class[]{kotlin.g.a.a.class, b.class, m.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, kotlin.g.a.c.class, d.class, kotlin.g.a.e.class, f.class, g.class, h.class, i.class, j.class, kotlin.g.a.k.class, l.class, n.class, o.class, p.class});
        Collection arrayList = new ArrayList(k.a(b2));
        for (Object next : b2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                k.a();
            }
            arrayList.add(kotlin.t.a((Class) next, Integer.valueOf(i2)));
            i2 = i3;
        }
        f47923c = ae.a((List) arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f47924d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f47925e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f47924d);
        hashMap3.putAll(f47925e);
        Collection<String> values = f47924d.values();
        k.b(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            k.b(str, "kotlinName");
            sb.append(kotlin.m.p.b(str, str));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            kotlin.o a2 = kotlin.t.a(sb2, str + ".Companion");
            hashMap3.put(a2.getFirst(), a2.getSecond());
        }
        for (Map.Entry next2 : f47923c.entrySet()) {
            hashMap3.put(((Class) next2.getKey()).getName(), "kotlin.Function".concat(String.valueOf(((Number) next2.getValue()).intValue())));
        }
        f47926f = hashMap3;
        Map map = hashMap3;
        Map<String, String> linkedHashMap = new LinkedHashMap<>(ae.a(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(key, kotlin.m.p.b(str2, str2));
        }
        f47927g = linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b() {
        /*
            r7 = this;
            java.lang.Class<?> r0 = r7.f47928b
            java.lang.String r1 = "jClass"
            kotlin.g.b.k.d(r0, r1)
            boolean r1 = r0.isAnonymousClass()
            r2 = 0
            if (r1 == 0) goto L_0x000f
            return r2
        L_0x000f:
            boolean r1 = r0.isLocalClass()
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = r0.getSimpleName()
            java.lang.reflect.Method r3 = r0.getEnclosingMethod()
            java.lang.String r4 = "$"
            java.lang.String r5 = "name"
            if (r3 == 0) goto L_0x0042
            kotlin.g.b.k.b(r1, r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r3 = r3.getName()
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            java.lang.String r3 = kotlin.m.p.c(r1, r3, r1)
            if (r3 != 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r2 = r3
            goto L_0x0062
        L_0x0042:
            java.lang.reflect.Constructor r0 = r0.getEnclosingConstructor()
            if (r0 == 0) goto L_0x0062
            kotlin.g.b.k.b(r1, r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = r0.getName()
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = kotlin.m.p.c(r1, r0, r1)
        L_0x0062:
            if (r2 != 0) goto L_0x00d5
            kotlin.g.b.k.b(r1, r5)
            java.lang.String r0 = "$this$substringAfter"
            kotlin.g.b.k.d(r1, r0)
            java.lang.String r0 = "missingDelimiterValue"
            kotlin.g.b.k.d(r1, r0)
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2 = 36
            r3 = 6
            r4 = 0
            int r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (char) r2, (int) r4, (boolean) r4, (int) r3)
            r2 = -1
            if (r0 != r2) goto L_0x0080
            return r1
        L_0x0080:
            int r0 = r0 + 1
            int r2 = r1.length()
            java.lang.String r0 = r1.substring(r0, r2)
            java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.b(r0, r1)
            return r0
        L_0x0090:
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x00c2
            java.lang.Class r0 = r0.getComponentType()
            boolean r1 = r0.isPrimitive()
            java.lang.String r3 = "Array"
            if (r1 == 0) goto L_0x00bf
            java.util.Map<java.lang.String, java.lang.String> r1 = f47927g
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00bf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r3)
            java.lang.String r2 = r1.toString()
        L_0x00bf:
            if (r2 != 0) goto L_0x00d5
            return r3
        L_0x00c2:
            java.util.Map<java.lang.String, java.lang.String> r1 = f47927g
            java.lang.String r2 = r0.getName()
            java.lang.Object r1 = r1.get(r2)
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x00d5
            java.lang.String r2 = r0.getSimpleName()
        L_0x00d5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.g.b.e.b():java.lang.String");
    }

    public final List<Annotation> getAnnotations() {
        throw new kotlin.g.b();
    }
}
