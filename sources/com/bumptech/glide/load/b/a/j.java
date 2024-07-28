package com.bumptech.glide.load.b.a;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f6744a;

    /* renamed from: b  reason: collision with root package name */
    private final b f6745b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f6746c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f6747d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6748e;

    /* renamed from: f  reason: collision with root package name */
    private int f6749f;

    public j() {
        this.f6744a = new h<>();
        this.f6745b = new b();
        this.f6746c = new HashMap();
        this.f6747d = new HashMap();
        this.f6748e = 4194304;
    }

    public j(int i2) {
        this.f6744a = new h<>();
        this.f6745b = new b();
        this.f6746c = new HashMap();
        this.f6747d = new HashMap();
        this.f6748e = i2;
    }

    public final synchronized <T> void a(T t) {
        Class<?> cls = t.getClass();
        a<?> c2 = c(cls);
        int a2 = c2.a(t);
        int b2 = c2.b() * a2;
        int i2 = 1;
        if (b2 <= this.f6748e / 2) {
            a a3 = this.f6745b.a(a2, cls);
            this.f6744a.a(a3, t);
            NavigableMap<Integer, Integer> b3 = b(cls);
            Integer num = (Integer) b3.get(Integer.valueOf(a3.f6750a));
            Integer valueOf = Integer.valueOf(a3.f6750a);
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            b3.put(valueOf, Integer.valueOf(i2));
            this.f6749f += b2;
            b(this.f6748e);
        }
    }

    public final synchronized <T> T a(Class<T> cls) {
        return a(this.f6745b.a(8, cls), cls);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized <T> T a(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.b((java.lang.Class<?>) r7)     // Catch:{ all -> 0x0048 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch:{ all -> 0x0048 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0048 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002e
            int r3 = r5.f6749f     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0022
            int r3 = r5.f6748e     // Catch:{ all -> 0x0048 }
            int r4 = r5.f6749f     // Catch:{ all -> 0x0048 }
            int r3 = r3 / r4
            r4 = 2
            if (r3 < r4) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            if (r3 != 0) goto L_0x002f
            int r3 = r0.intValue()     // Catch:{ all -> 0x0048 }
            int r4 = r6 * 8
            if (r3 > r4) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x003c
            com.bumptech.glide.load.b.a.j$b r6 = r5.f6745b     // Catch:{ all -> 0x0048 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0048 }
            com.bumptech.glide.load.b.a.j$a r6 = r6.a(r0, r7)     // Catch:{ all -> 0x0048 }
            goto L_0x0042
        L_0x003c:
            com.bumptech.glide.load.b.a.j$b r0 = r5.f6745b     // Catch:{ all -> 0x0048 }
            com.bumptech.glide.load.b.a.j$a r6 = r0.a(r6, r7)     // Catch:{ all -> 0x0048 }
        L_0x0042:
            java.lang.Object r6 = r5.a((com.bumptech.glide.load.b.a.j.a) r6, r7)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)
            return r6
        L_0x0048:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.j.a(int, java.lang.Class):java.lang.Object");
    }

    private <T> T a(a aVar, Class<T> cls) {
        a<T> c2 = c(cls);
        T a2 = a(aVar);
        if (a2 != null) {
            this.f6749f -= c2.a(a2) * c2.b();
            b(c2.a(a2), cls);
        }
        if (a2 != null) {
            return a2;
        }
        if (Log.isLoggable(c2.a(), 2)) {
            c2.a();
            StringBuilder sb = new StringBuilder("Allocated ");
            sb.append(aVar.f6750a);
            sb.append(" bytes");
        }
        return c2.a(aVar.f6750a);
    }

    private <T> T a(a aVar) {
        return this.f6744a.a(aVar);
    }

    public final synchronized void a() {
        b(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = 40
            if (r2 < r0) goto L_0x000c
            r1.a()     // Catch:{ all -> 0x000a }
            monitor-exit(r1)
            return
        L_0x000a:
            r2 = move-exception
            goto L_0x001d
        L_0x000c:
            r0 = 20
            if (r2 >= r0) goto L_0x0014
            r0 = 15
            if (r2 != r0) goto L_0x001b
        L_0x0014:
            int r2 = r1.f6748e     // Catch:{ all -> 0x000a }
            int r2 = r2 / 2
            r1.b((int) r2)     // Catch:{ all -> 0x000a }
        L_0x001b:
            monitor-exit(r1)
            return
        L_0x001d:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.j.a(int):void");
    }

    private void b(int i2) {
        while (this.f6749f > i2) {
            Object a2 = this.f6744a.a();
            com.bumptech.glide.g.j.a(a2, "Argument must not be null");
            a b2 = b(a2);
            this.f6749f -= b2.a(a2) * b2.b();
            b(b2.a(a2), a2.getClass());
            if (Log.isLoggable(b2.a(), 2)) {
                b2.a();
                new StringBuilder("evicted: ").append(b2.a(a2));
            }
        }
    }

    private void b(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> b2 = b(cls);
        Integer num = (Integer) b2.get(Integer.valueOf(i2));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        } else if (num.intValue() == 1) {
            b2.remove(Integer.valueOf(i2));
        } else {
            b2.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f6746c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f6746c.put(cls, treeMap);
        return treeMap;
    }

    private <T> a<T> b(T t) {
        return c(t.getClass());
    }

    private <T> a<T> c(Class<T> cls) {
        a<T> aVar = this.f6747d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f6747d.put(cls, aVar);
        }
        return aVar;
    }

    static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public final a a(int i2, Class<?> cls) {
            a aVar = (a) b();
            aVar.a(i2, cls);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ m a() {
            return new a(this);
        }
    }

    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f6750a;

        /* renamed from: b  reason: collision with root package name */
        private final b f6751b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f6752c;

        a(b bVar) {
            this.f6751b = bVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Class<?> cls) {
            this.f6750a = i2;
            this.f6752c = cls;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f6750a == aVar.f6750a && this.f6752c == aVar.f6752c) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final String toString() {
            return "Key{size=" + this.f6750a + "array=" + this.f6752c + '}';
        }

        public final void a() {
            this.f6751b.a(this);
        }

        public final int hashCode() {
            int i2 = this.f6750a * 31;
            Class<?> cls = this.f6752c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }
    }
}
