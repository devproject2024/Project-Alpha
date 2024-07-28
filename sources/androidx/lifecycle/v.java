package androidx.lifecycle;

import com.business.merchant_payments.common.utility.AppUtility;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Integer> f3686a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends h>>> f3687b = new HashMap();

    static o a(Object obj) {
        boolean z = obj instanceof o;
        boolean z2 = obj instanceof g;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((g) obj, (o) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((g) obj, (o) null);
        }
        if (z) {
            return (o) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f3687b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        h[] hVarArr = new h[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            hVarArr[i2] = a((Constructor) list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(hVarArr);
    }

    private static h a(Constructor<? extends h> constructor, Object obj) {
        try {
            return (h) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends h> a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str = canonicalName.replace(AppUtility.CENTER_DOT, "_") + "_LifecycleAdapter";
            if (!name.isEmpty()) {
                str = name + AppUtility.CENTER_DOT + str;
            }
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int b(Class<?> cls) {
        Integer num = f3686a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int c2 = c(cls);
        f3686a.put(cls, Integer.valueOf(c2));
        return c2;
    }

    private static int c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends h> a2 = a(cls);
        if (a2 != null) {
            f3687b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (b.f3648a.a(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (d(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f3687b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (d(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f3687b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3687b.put(cls, arrayList);
            return 2;
        }
    }

    private static boolean d(Class<?> cls) {
        return cls != null && p.class.isAssignableFrom(cls);
    }
}
