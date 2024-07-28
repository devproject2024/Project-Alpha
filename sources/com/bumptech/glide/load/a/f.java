package com.bumptech.glide.load.a;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f6695b = new e.a<Object>() {
        public final e<Object> a(Object obj) {
            return new a(obj);
        }

        public final Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f6696a = new HashMap();

    public final synchronized void a(e.a<?> aVar) {
        this.f6696a.put(aVar.a(), aVar);
    }

    static final class a implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f6697a;

        public final void b() {
        }

        a(Object obj) {
            this.f6697a = obj;
        }

        public final Object a() {
            return this.f6697a;
        }
    }

    public final synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        j.a(t, "Argument must not be null");
        aVar = this.f6696a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it2 = this.f6696a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                e.a<?> next = it2.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f6695b;
        }
        return aVar.a(t);
    }
}
