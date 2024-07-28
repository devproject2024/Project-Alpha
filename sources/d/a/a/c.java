package d.a.a;

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
    public static String f45942a = "Event";

    /* renamed from: b  reason: collision with root package name */
    static volatile c f45943b;

    /* renamed from: d  reason: collision with root package name */
    private static final d f45944d = new d();

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f45945e = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f45946c;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<m>> f45947f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f45948g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, Object> f45949h;

    /* renamed from: i  reason: collision with root package name */
    private final ThreadLocal<a> f45950i;
    private final f j;
    private final b k;
    private final a l;
    private final l m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;

    public static c a() {
        if (f45943b == null) {
            synchronized (c.class) {
                if (f45943b == null) {
                    f45943b = new c();
                }
            }
        }
        return f45943b;
    }

    public c() {
        this(f45944d);
    }

    private c(d dVar) {
        this.f45950i = new ThreadLocal<a>() {
            /* access modifiers changed from: protected */
            public final /* synthetic */ Object initialValue() {
                return new a();
            }
        };
        this.f45947f = new HashMap();
        this.f45948g = new HashMap();
        this.f45949h = new ConcurrentHashMap();
        this.j = new f(this, Looper.getMainLooper());
        this.k = new b(this);
        this.l = new a(this);
        this.m = new l(dVar.f45967h);
        this.o = dVar.f45960a;
        this.p = dVar.f45961b;
        this.q = dVar.f45962c;
        this.r = dVar.f45963d;
        this.n = dVar.f45964e;
        this.s = dVar.f45965f;
        this.f45946c = dVar.f45966g;
    }

    public final synchronized void a(Object obj, boolean z) {
        Object obj2;
        for (k next : this.m.a(obj.getClass())) {
            Class<?> cls = next.f45986c;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f45947f.get(cls);
            m mVar = new m(obj, next);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.f45947f.put(cls, copyOnWriteArrayList);
            } else if (copyOnWriteArrayList.contains(mVar)) {
                throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
            }
            int size = copyOnWriteArrayList.size();
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 > size) {
                    break;
                } else if (i2 == size) {
                    break;
                } else if (mVar.f45992c > ((m) copyOnWriteArrayList.get(i2)).f45992c) {
                    break;
                } else {
                    i2++;
                }
            }
            copyOnWriteArrayList.add(i2, mVar);
            List list = this.f45948g.get(obj);
            if (list == null) {
                list = new ArrayList();
                this.f45948g.put(obj, list);
            }
            list.add(cls);
            if (z) {
                synchronized (this.f45949h) {
                    obj2 = this.f45949h.get(cls);
                }
                if (obj2 != null) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        z2 = true;
                    }
                    a(mVar, obj2, z2);
                } else {
                    continue;
                }
            }
        }
    }

    public final synchronized boolean a(Object obj) {
        return this.f45948g.containsKey(obj);
    }

    public final synchronized void b(Object obj) {
        List<Class> list = this.f45948g.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = this.f45947f.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        m mVar = (m) list2.get(i2);
                        if (mVar.f45990a == obj) {
                            mVar.f45993d = false;
                            list2.remove(i2);
                            i2--;
                            size--;
                        }
                        i2++;
                    }
                }
            }
            this.f45948g.remove(obj);
            return;
        }
        new StringBuilder("Subscriber to unregister was not registered before: ").append(obj.getClass());
    }

    public final void c(Object obj) {
        a aVar = this.f45950i.get();
        List<Object> list = aVar.f45953a;
        list.add(obj);
        if (!aVar.f45954b) {
            aVar.f45955c = Looper.getMainLooper() == Looper.myLooper();
            aVar.f45954b = true;
            if (!aVar.f45958f) {
                while (!list.isEmpty()) {
                    try {
                        a(list.remove(0), aVar);
                    } finally {
                        aVar.f45954b = false;
                        aVar.f45955c = false;
                    }
                }
                return;
            }
            throw new e("Internal error. Abort state was not reset");
        }
    }

    public final void d(Object obj) {
        synchronized (this.f45949h) {
            this.f45949h.put(obj.getClass(), obj);
        }
        c(obj);
    }

    public final boolean e(Object obj) {
        synchronized (this.f45949h) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f45949h.get(cls))) {
                return false;
            }
            this.f45949h.remove(cls);
            return true;
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
            if (this.r && cls != g.class && cls != j.class) {
                c(new g(this, obj));
            }
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f45947f.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            m mVar = (m) it2.next();
            aVar.f45957e = obj;
            aVar.f45956d = mVar;
            try {
                a(mVar, obj, aVar.f45955c);
                if (aVar.f45958f) {
                    return true;
                }
            } finally {
                aVar.f45957e = null;
                aVar.f45956d = null;
                aVar.f45958f = false;
            }
        }
        return true;
    }

    /* renamed from: d.a.a.c$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45952a = new int[n.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                d.a.a.n[] r0 = d.a.a.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45952a = r0
                int[] r0 = f45952a     // Catch:{ NoSuchFieldError -> 0x0014 }
                d.a.a.n r1 = d.a.a.n.PostThread     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f45952a     // Catch:{ NoSuchFieldError -> 0x001f }
                d.a.a.n r1 = d.a.a.n.MainThread     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f45952a     // Catch:{ NoSuchFieldError -> 0x002a }
                d.a.a.n r1 = d.a.a.n.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f45952a     // Catch:{ NoSuchFieldError -> 0x0035 }
                d.a.a.n r1 = d.a.a.n.Async     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.a.a.c.AnonymousClass2.<clinit>():void");
        }
    }

    private void a(m mVar, Object obj, boolean z) {
        int i2 = AnonymousClass2.f45952a[mVar.f45991b.f45985b.ordinal()];
        if (i2 == 1) {
            a(mVar, obj);
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    this.l.a(mVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + mVar.f45991b.f45985b);
            } else if (z) {
                this.k.a(mVar, obj);
            } else {
                a(mVar, obj);
            }
        } else if (z) {
            a(mVar, obj);
        } else {
            this.j.a(mVar, obj);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f45945e) {
            list = f45945e.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f45945e.put(cls, list);
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
        Object obj = hVar.f45975a;
        m mVar = hVar.f45976b;
        h.a(hVar);
        if (mVar.f45993d) {
            a(mVar, obj);
        }
    }

    private void a(m mVar, Object obj) {
        try {
            mVar.f45991b.f45984a.invoke(mVar.f45990a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            a(mVar, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    private void a(m mVar, Object obj, Throwable th) {
        if (obj instanceof j) {
            if (this.o) {
                StringBuilder sb = new StringBuilder("SubscriberExceptionEvent subscriber ");
                sb.append(mVar.f45990a.getClass());
                sb.append(" threw an exception");
                j jVar = (j) obj;
                StringBuilder sb2 = new StringBuilder("Initial event ");
                sb2.append(jVar.f45982c);
                sb2.append(" caused exception in ");
                sb2.append(jVar.f45983d);
            }
        } else if (!this.n) {
            if (this.o) {
                StringBuilder sb3 = new StringBuilder("Could not dispatch event: ");
                sb3.append(obj.getClass());
                sb3.append(" to subscribing class ");
                sb3.append(mVar.f45990a.getClass());
            }
            if (this.q) {
                c(new j(this, th, obj, mVar.f45990a));
            }
        } else {
            throw new e("Invoking subscriber failed", th);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f45953a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f45954b;

        /* renamed from: c  reason: collision with root package name */
        boolean f45955c;

        /* renamed from: d  reason: collision with root package name */
        m f45956d;

        /* renamed from: e  reason: collision with root package name */
        Object f45957e;

        /* renamed from: f  reason: collision with root package name */
        boolean f45958f;

        a() {
        }
    }
}
