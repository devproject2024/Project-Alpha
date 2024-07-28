package org.greenrobot.eventbus;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f72848a = "EventBus";

    /* renamed from: b  reason: collision with root package name */
    static volatile c f72849b;

    /* renamed from: d  reason: collision with root package name */
    private static final d f72850d = new d();

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f72851e = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f72852c;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<n>> f72853f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f72854g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, Object> f72855h;

    /* renamed from: i  reason: collision with root package name */
    private final ThreadLocal<a> f72856i;
    private final f j;
    private final b k;
    private final a l;
    private final m m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;

    public static c a() {
        if (f72849b == null) {
            synchronized (c.class) {
                if (f72849b == null) {
                    f72849b = new c();
                }
            }
        }
        return f72849b;
    }

    public c() {
        this(f72850d);
    }

    private c(d dVar) {
        this.f72856i = new ThreadLocal<a>() {
            /* access modifiers changed from: protected */
            public final /* synthetic */ Object initialValue() {
                return new a();
            }
        };
        this.f72853f = new HashMap();
        this.f72854g = new HashMap();
        this.f72855h = new ConcurrentHashMap();
        this.j = new f(this, Looper.getMainLooper());
        this.k = new b(this);
        this.l = new a(this);
        this.t = dVar.j != null ? dVar.j.size() : 0;
        this.m = new m(dVar.j, dVar.f72872h, dVar.f72871g);
        this.o = dVar.f72865a;
        this.p = dVar.f72866b;
        this.q = dVar.f72867c;
        this.r = dVar.f72868d;
        this.n = dVar.f72869e;
        this.s = dVar.f72870f;
        this.f72852c = dVar.f72873i;
    }

    public final void a(Object obj) {
        List<l> a2 = this.m.a(obj.getClass());
        synchronized (this) {
            for (l a3 : a2) {
                a(obj, a3);
            }
        }
    }

    private void a(Object obj, l lVar) {
        Class<?> cls = lVar.f72892c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f72853f.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f72853f.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || lVar.f72893d > ((n) copyOnWriteArrayList.get(i2)).f72910b.f72893d) {
                copyOnWriteArrayList.add(i2, nVar);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, nVar);
        List list = this.f72854g.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f72854g.put(obj, list);
        }
        list.add(cls);
        if (!lVar.f72894e) {
            return;
        }
        if (this.s) {
            for (Map.Entry next : this.f72855h.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    a(nVar, next.getValue());
                }
            }
            return;
        }
        a(nVar, this.f72855h.get(cls));
    }

    private void a(n nVar, Object obj) {
        if (obj != null) {
            a(nVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public final synchronized void b(Object obj) {
        List<Class> list = this.f72854g.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = this.f72853f.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        n nVar = (n) list2.get(i2);
                        if (nVar.f72909a == obj) {
                            nVar.f72911c = false;
                            list2.remove(i2);
                            i2--;
                            size--;
                        }
                        i2++;
                    }
                }
            }
            this.f72854g.remove(obj);
            return;
        }
        new StringBuilder("Subscriber to unregister was not registered before: ").append(obj.getClass());
    }

    public final void c(Object obj) {
        a aVar = this.f72856i.get();
        List<Object> list = aVar.f72859a;
        list.add(obj);
        if (!aVar.f72860b) {
            aVar.f72861c = Looper.getMainLooper() == Looper.myLooper();
            aVar.f72860b = true;
            if (!aVar.f72864f) {
                while (!list.isEmpty()) {
                    try {
                        a(list.remove(0), aVar);
                    } finally {
                        aVar.f72860b = false;
                        aVar.f72861c = false;
                    }
                }
                return;
            }
            throw new e("Internal error. Abort state was not reset");
        }
    }

    public final void d(Object obj) {
        synchronized (this.f72855h) {
            this.f72855h.put(obj.getClass(), obj);
        }
        c(obj);
    }

    public final boolean e(Object obj) {
        synchronized (this.f72855h) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f72855h.get(cls))) {
                return false;
            }
            this.f72855h.remove(cls);
            return true;
        }
    }

    public final void b() {
        synchronized (this.f72855h) {
            this.f72855h.clear();
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> a2 = a(cls);
            int size = a2.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= a(obj, aVar, a2.get(i2));
            }
        } else {
            z = a(obj, aVar, cls);
        }
        if (!z) {
            if (this.p) {
                new StringBuilder("No subscribers registered for event ").append(cls);
            }
            if (this.r && cls != g.class && cls != k.class) {
                c(new g(this, obj));
            }
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f72853f.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            n nVar = (n) it2.next();
            aVar.f72863e = obj;
            aVar.f72862d = nVar;
            try {
                a(nVar, obj, aVar.f72861c);
                if (aVar.f72864f) {
                    return true;
                }
            } finally {
                aVar.f72863e = null;
                aVar.f72862d = null;
                aVar.f72864f = false;
            }
        }
        return true;
    }

    /* renamed from: org.greenrobot.eventbus.c$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f72858a = new int[ThreadMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f72858a = r0
                int[] r0 = f72858a     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f72858a     // Catch:{ NoSuchFieldError -> 0x001f }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f72858a     // Catch:{ NoSuchFieldError -> 0x002a }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f72858a     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.c.AnonymousClass2.<clinit>():void");
        }
    }

    private void a(n nVar, Object obj, boolean z) {
        int i2 = AnonymousClass2.f72858a[nVar.f72910b.f72891b.ordinal()];
        if (i2 == 1) {
            b(nVar, obj);
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    this.l.a(nVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + nVar.f72910b.f72891b);
            } else if (z) {
                this.k.a(nVar, obj);
            } else {
                b(nVar, obj);
            }
        } else if (z) {
            b(nVar, obj);
        } else {
            this.j.a(nVar, obj);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f72851e) {
            list = f72851e.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f72851e.put(cls, list);
            }
        }
        return list;
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar) {
        Object obj = hVar.f72881a;
        n nVar = hVar.f72882b;
        h.a(hVar);
        if (nVar.f72911c) {
            b(nVar, obj);
        }
    }

    private void b(n nVar, Object obj) {
        try {
            nVar.f72910b.f72890a.invoke(nVar.f72909a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            a(nVar, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    private void a(n nVar, Object obj, Throwable th) {
        if (obj instanceof k) {
            if (this.o) {
                StringBuilder sb = new StringBuilder("SubscriberExceptionEvent subscriber ");
                sb.append(nVar.f72909a.getClass());
                sb.append(" threw an exception");
                k kVar = (k) obj;
                StringBuilder sb2 = new StringBuilder("Initial event ");
                sb2.append(kVar.f72888c);
                sb2.append(" caused exception in ");
                sb2.append(kVar.f72889d);
            }
        } else if (!this.n) {
            if (this.o) {
                StringBuilder sb3 = new StringBuilder("Could not dispatch event: ");
                sb3.append(obj.getClass());
                sb3.append(" to subscribing class ");
                sb3.append(nVar.f72909a.getClass());
            }
            if (this.q) {
                c(new k(this, th, obj, nVar.f72909a));
            }
        } else {
            throw new e("Invoking subscriber failed", th);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f72859a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f72860b;

        /* renamed from: c  reason: collision with root package name */
        boolean f72861c;

        /* renamed from: d  reason: collision with root package name */
        n f72862d;

        /* renamed from: e  reason: collision with root package name */
        Object f72863e;

        /* renamed from: f  reason: collision with root package name */
        boolean f72864f;

        a() {
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }
}
