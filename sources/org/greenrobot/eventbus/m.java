package org.greenrobot.eventbus;

import com.business.merchant_payments.common.utility.AppUtility;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.a.b;

final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, List<l>> f72896a = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final a[] f72897e = new a[4];

    /* renamed from: b  reason: collision with root package name */
    private List<b> f72898b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f72899c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f72900d;

    m(List<b> list, boolean z, boolean z2) {
        this.f72898b = list;
        this.f72899c = z;
        this.f72900d = z2;
    }

    /* access modifiers changed from: package-private */
    public final List<l> a(Class<?> cls) {
        List<l> list;
        List<l> list2 = f72896a.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.f72900d) {
            list = c(cls);
        } else {
            list = b(cls);
        }
        if (!list.isEmpty()) {
            f72896a.put(cls, list);
            return list;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    private List<l> b(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f72906f != null) {
            a2.f72908h = b(a2);
            if (a2.f72908h != null) {
                for (l lVar : a2.f72908h.b()) {
                    if (a2.a(lVar.f72890a, lVar.f72892c)) {
                        a2.f72901a.add(lVar);
                    }
                }
            } else {
                c(a2);
            }
            a2.a();
        }
        return a(a2);
    }

    private static List<l> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f72901a);
        aVar.f72901a.clear();
        aVar.f72902b.clear();
        aVar.f72903c.clear();
        int i2 = 0;
        aVar.f72904d.setLength(0);
        aVar.f72905e = null;
        aVar.f72906f = null;
        aVar.f72907g = false;
        aVar.f72908h = null;
        synchronized (f72897e) {
            while (true) {
                if (i2 >= 4) {
                    break;
                } else if (f72897e[i2] == null) {
                    f72897e[i2] = aVar;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return arrayList;
    }

    private static a a() {
        synchronized (f72897e) {
            for (int i2 = 0; i2 < 4; i2++) {
                a aVar = f72897e[i2];
                if (aVar != null) {
                    f72897e[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private org.greenrobot.eventbus.a.a b(a aVar) {
        if (!(aVar.f72908h == null || aVar.f72908h.c() == null)) {
            org.greenrobot.eventbus.a.a c2 = aVar.f72908h.c();
            if (aVar.f72906f == c2.a()) {
                return c2;
            }
        }
        List<b> list = this.f72898b;
        if (list == null) {
            return null;
        }
        for (b a2 : list) {
            org.greenrobot.eventbus.a.a a3 = a2.a();
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    private List<l> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f72906f != null) {
            c(a2);
            a2.a();
        }
        return a(a2);
    }

    private void c(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f72906f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f72906f.getMethods();
            aVar.f72907g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    j jVar = (j) method.getAnnotation(j.class);
                    if (jVar != null) {
                        Class cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f72901a.add(new l(method, cls, jVar.a(), jVar.c(), jVar.b()));
                        }
                    }
                } else if (this.f72899c && method.isAnnotationPresent(j.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + AppUtility.CENTER_DOT + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f72899c && method.isAnnotationPresent(j.class)) {
                throw new e((method.getDeclaringClass().getName() + AppUtility.CENTER_DOT + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<l> f72901a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f72902b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f72903c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f72904d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        Class<?> f72905e;

        /* renamed from: f  reason: collision with root package name */
        Class<?> f72906f;

        /* renamed from: g  reason: collision with root package name */
        boolean f72907g;

        /* renamed from: h  reason: collision with root package name */
        org.greenrobot.eventbus.a.a f72908h;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a(Class<?> cls) {
            this.f72906f = cls;
            this.f72905e = cls;
            this.f72907g = false;
            this.f72908h = null;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(Method method, Class<?> cls) {
            Object put = this.f72902b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f72902b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.f72904d.setLength(0);
            this.f72904d.append(method.getName());
            StringBuilder sb = this.f72904d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f72904d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f72903c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f72903c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (!this.f72907g) {
                this.f72906f = this.f72906f.getSuperclass();
                String name = this.f72906f.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.")) {
                    return;
                }
            }
            this.f72906f = null;
        }
    }
}
