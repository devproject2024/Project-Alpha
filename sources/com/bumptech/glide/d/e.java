package com.bumptech.glide.d;

import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f6497a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f6498b = new HashMap();

    public final synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f6497a);
        this.f6497a.clear();
        for (String add : list) {
            this.f6497a.add(add);
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f6497a.add(str);
            }
        }
    }

    public final synchronized <T, R> List<k<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6497a) {
            List<a> list = this.f6498b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f6500b);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6497a) {
            List<a> list = this.f6498b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f6499a)) {
                        arrayList.add(aVar.f6499a);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> void a(String str, k<T, R> kVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a(cls, cls2, kVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f6497a.contains(str)) {
            this.f6497a.add(str);
        }
        list = this.f6498b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f6498b.put(str, list);
        }
        return list;
    }

    static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f6499a;

        /* renamed from: b  reason: collision with root package name */
        final k<T, R> f6500b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f6501c;

        public a(Class<T> cls, Class<R> cls2, k<T, R> kVar) {
            this.f6501c = cls;
            this.f6499a = cls2;
            this.f6500b = kVar;
        }

        public final boolean a(Class<?> cls, Class<?> cls2) {
            return this.f6501c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6499a);
        }
    }
}
