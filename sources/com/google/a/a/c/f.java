package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class f {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, f> f7566d = new WeakHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Class<?>, f> f7567e = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    final Class<?> f7568a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f7569b;

    /* renamed from: c  reason: collision with root package name */
    final List<String> f7570c;

    /* renamed from: f  reason: collision with root package name */
    private final IdentityHashMap<String, j> f7571f = new IdentityHashMap<>();

    public static f a(Class<?> cls) {
        return a(cls, false);
    }

    public static f a(Class<?> cls, boolean z) {
        f fVar;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, f> map = z ? f7567e : f7566d;
        synchronized (map) {
            fVar = map.get(cls);
            if (fVar == null) {
                fVar = new f(cls, z);
                map.put(cls, fVar);
            }
        }
        return fVar;
    }

    public final j a(String str) {
        if (str != null) {
            if (this.f7569b) {
                str = str.toLowerCase();
            }
            str = str.intern();
        }
        return this.f7571f.get(str);
    }

    private f(Class<?> cls, boolean z) {
        this.f7568a = cls;
        this.f7569b = z;
        c.a(!z || !cls.isEnum(), (Object) "cannot ignore case on an enum: ".concat(String.valueOf(cls)));
        TreeSet treeSet = new TreeSet(new Comparator<String>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            }
        });
        for (Field field : cls.getDeclaredFields()) {
            j a2 = j.a(field);
            if (a2 != null) {
                String str = a2.f7598c;
                str = z ? str.toLowerCase().intern() : str;
                j jVar = this.f7571f.get(str);
                boolean z2 = jVar == null;
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : "";
                objArr[1] = str;
                objArr[2] = field;
                objArr[3] = jVar == null ? null : jVar.f7597b;
                c.a(z2, "two fields have the same %sname <%s>: %s and %s", objArr);
                this.f7571f.put(str, a2);
                treeSet.add(str);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            f a3 = a(superclass, z);
            treeSet.addAll(a3.f7570c);
            for (Map.Entry next : a3.f7571f.entrySet()) {
                String str2 = (String) next.getKey();
                if (!this.f7571f.containsKey(str2)) {
                    this.f7571f.put(str2, next.getValue());
                }
            }
        }
        this.f7570c = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }
}
