package com.bumptech.glide.load.c;

import androidx.core.g.e;
import com.bumptech.glide.g;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f7069a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f7070b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final List<b<?, ?>> f7071c;

    /* renamed from: d  reason: collision with root package name */
    private final c f7072d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<b<?, ?>> f7073e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a<List<Throwable>> f7074f;

    public r(e.a<List<Throwable>> aVar) {
        this(aVar, f7069a);
    }

    private r(e.a<List<Throwable>> aVar, c cVar) {
        this.f7071c = new ArrayList();
        this.f7073e = new HashSet();
        this.f7074f = aVar;
        this.f7072d = cVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized <Model> List<n<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f7071c) {
                if (!this.f7073e.contains(next) && next.a(cls)) {
                    this.f7073e.add(next);
                    arrayList.add(a((b<?, ?>) next));
                    this.f7073e.remove(next);
                }
            }
        } catch (Throwable th) {
            this.f7073e.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f7071c) {
            if (!arrayList.contains(next.f7075a) && next.a(cls)) {
                arrayList.add(next.f7075a);
            }
        }
        return arrayList;
    }

    public final synchronized <Model, Data> n<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b next : this.f7071c) {
                if (this.f7073e.contains(next)) {
                    z = true;
                } else {
                    if (next.a(cls) && next.f7075a.isAssignableFrom(cls2)) {
                        this.f7073e.add(next);
                        arrayList.add(a((b<?, ?>) next));
                        this.f7073e.remove(next);
                    }
                }
            }
            if (arrayList.size() > 1) {
                return new q(arrayList, this.f7074f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f7070b;
            } else {
                throw new g.c((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f7073e.clear();
            throw th;
        }
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        return (n) j.a(bVar.f7076b.a(this), "Argument must not be null");
    }

    static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f7075a;

        /* renamed from: b  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f7076b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<Model> f7077c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f7077c = cls;
            this.f7075a = cls2;
            this.f7076b = oVar;
        }

        public final boolean a(Class<?> cls) {
            return this.f7077c.isAssignableFrom(cls);
        }
    }

    static class c {
        c() {
        }
    }

    static class a implements n<Object, Object> {
        public final n.a<Object> a(Object obj, int i2, int i3, i iVar) {
            return null;
        }

        public final boolean a(Object obj) {
            return false;
        }

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f7071c.add(this.f7071c.size(), new b(cls, cls2, oVar));
    }
}
