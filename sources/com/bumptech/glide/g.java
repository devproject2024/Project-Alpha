package com.bumptech.glide;

import androidx.core.g.e;
import com.bumptech.glide.d.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.p;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final com.bumptech.glide.d.a f6586a = new com.bumptech.glide.d.a();

    /* renamed from: b  reason: collision with root package name */
    public final f f6587b = new f();

    /* renamed from: c  reason: collision with root package name */
    public final com.bumptech.glide.load.a.f f6588c = new com.bumptech.glide.load.a.f();

    /* renamed from: d  reason: collision with root package name */
    private final p f6589d = new p(this.j);

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.d.e f6590e = new com.bumptech.glide.d.e();

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.d.f.f f6591f = new com.bumptech.glide.load.d.f.f();

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.d.b f6592g = new com.bumptech.glide.d.b();

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.d.d f6593h = new com.bumptech.glide.d.d();

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.d.c f6594i = new com.bumptech.glide.d.c();
    private final e.a<List<Throwable>> j = com.bumptech.glide.g.a.a.a();

    public g() {
        List asList = Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"});
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.addAll(asList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f6590e.a((List<String>) arrayList);
    }

    public final <Data> g a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        this.f6586a.a(cls, dVar);
        return this;
    }

    public final <Data, TResource> g a(Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        a("legacy_append", cls, cls2, kVar);
        return this;
    }

    public final <Data, TResource> g a(String str, Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        this.f6590e.a(str, kVar, cls, cls2);
        return this;
    }

    public final <TResource> g a(Class<TResource> cls, l<TResource> lVar) {
        this.f6587b.a(cls, lVar);
        return this;
    }

    public final g a(e.a<?> aVar) {
        this.f6588c.a(aVar);
        return this;
    }

    public final <TResource, Transcode> g a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.d.f.e<TResource, Transcode> eVar) {
        this.f6591f.a(cls, cls2, eVar);
        return this;
    }

    public final g a(ImageHeaderParser imageHeaderParser) {
        this.f6592g.a(imageHeaderParser);
        return this;
    }

    public final <Model, Data> g a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f6589d.a(cls, cls2, oVar);
        return this;
    }

    public final <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<?, ?, ?> tVar;
        Class<Data> cls4 = cls;
        Class<TResource> cls5 = cls2;
        Class<Transcode> cls6 = cls3;
        t<Data, TResource, Transcode> a2 = this.f6594i.a(cls4, cls5, cls6);
        if (com.bumptech.glide.d.c.a(a2)) {
            return null;
        }
        if (a2 == null) {
            ArrayList arrayList = new ArrayList();
            for (Class next : this.f6590e.b(cls4, cls5)) {
                for (Class next2 : this.f6591f.b(next, cls6)) {
                    i iVar = r2;
                    i iVar2 = new i(cls, next, next2, this.f6590e.a(cls4, next), this.f6591f.a(next, next2), this.j);
                    arrayList.add(iVar);
                }
            }
            if (arrayList.isEmpty()) {
                a2 = null;
            } else {
                a2 = new t<>(cls, cls2, cls3, arrayList, this.j);
            }
            com.bumptech.glide.d.c cVar = this.f6594i;
            synchronized (cVar.f6493b) {
                androidx.a.a<com.bumptech.glide.g.i, t<?, ?, ?>> aVar = cVar.f6493b;
                com.bumptech.glide.g.i iVar3 = new com.bumptech.glide.g.i(cls4, cls5, cls6);
                if (a2 != null) {
                    tVar = a2;
                } else {
                    tVar = com.bumptech.glide.d.c.f6492a;
                }
                aVar.put(iVar3, tVar);
            }
        }
        return a2;
    }

    public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f6593h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> b2 : this.f6589d.a(cls)) {
                for (Class next : this.f6590e.b(b2, cls2)) {
                    if (!this.f6591f.b(next, cls3).isEmpty() && !a2.contains(next)) {
                        a2.add(next);
                    }
                }
            }
            com.bumptech.glide.d.d dVar = this.f6593h;
            List<T> unmodifiableList = Collections.unmodifiableList(a2);
            synchronized (dVar.f6495a) {
                dVar.f6495a.put(new com.bumptech.glide.g.i(cls, cls2, cls3), unmodifiableList);
            }
        }
        return a2;
    }

    public final <Model> List<n<Model, ?>> a(Model model) {
        List<n<A, ?>> b2 = this.f6589d.b(model.getClass());
        if (!b2.isEmpty()) {
            int size = b2.size();
            List<n<Model, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                n nVar = b2.get(i2);
                if (nVar.a(model)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new c(model, b2);
        }
        throw new c(model);
    }

    public final List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.f6592g.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new b();
    }

    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(M m, List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: ".concat(String.valueOf(cls)));
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }
}
