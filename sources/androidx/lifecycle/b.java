package androidx.lifecycle;

import androidx.lifecycle.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static b f3648a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, a> f3649b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3650c = new HashMap();

    b() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Class<?> cls) {
        Boolean bool = this.f3650c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method annotation : c2) {
            if (((aa) annotation.getAnnotation(aa.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f3650c.put(cls, Boolean.FALSE);
        return false;
    }

    private static Method[] c(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final a b(Class<?> cls) {
        a aVar = this.f3649b.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    private static void a(Map<C0055b, k.a> map, C0055b bVar, k.a aVar, Class<?> cls) {
        k.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f3654b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i2;
        a b2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (b2 = b(superclass)) == null)) {
            hashMap.putAll(b2.f3652b);
        }
        for (Class b3 : cls.getInterfaces()) {
            for (Map.Entry next : b(b3).f3652b.entrySet()) {
                a(hashMap, (C0055b) next.getKey(), (k.a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            aa aaVar = (aa) method.getAnnotation(aa.class);
            if (aaVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(q.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                k.a a2 = aaVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(k.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a2 == k.a.ON_ANY) {
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new C0055b(i2, method), a2, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f3649b.put(cls, aVar);
        this.f3650c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<k.a, List<C0055b>> f3651a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0055b, k.a> f3652b;

        a(Map<C0055b, k.a> map) {
            this.f3652b = map;
            for (Map.Entry next : map.entrySet()) {
                k.a aVar = (k.a) next.getValue();
                List list = this.f3651a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f3651a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }

        static void a(List<C0055b> list, q qVar, k.a aVar, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    C0055b bVar = list.get(size);
                    try {
                        int i2 = bVar.f3653a;
                        if (i2 == 0) {
                            bVar.f3654b.invoke(obj, new Object[0]);
                        } else if (i2 == 1) {
                            bVar.f3654b.invoke(obj, new Object[]{qVar});
                        } else if (i2 == 2) {
                            bVar.f3654b.invoke(obj, new Object[]{qVar, aVar});
                        }
                        size--;
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    } catch (IllegalAccessException e3) {
                        throw new RuntimeException(e3);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    static class C0055b {

        /* renamed from: a  reason: collision with root package name */
        final int f3653a;

        /* renamed from: b  reason: collision with root package name */
        final Method f3654b;

        C0055b(int i2, Method method) {
            this.f3653a = i2;
            this.f3654b = method;
            this.f3654b.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                C0055b bVar = (C0055b) obj;
                return this.f3653a == bVar.f3653a && this.f3654b.getName().equals(bVar.f3654b.getName());
            }
        }

        public final int hashCode() {
            return (this.f3653a * 31) + this.f3654b.getName().hashCode();
        }
    }
}
