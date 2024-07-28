package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f7558a = a.a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Field, a> f7559b = a.a();

    /* renamed from: c  reason: collision with root package name */
    private final Object f7560c;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Class<?> f7561a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<Object> f7562b = new ArrayList<>();

        a(Class<?> cls) {
            this.f7561a = cls;
        }

        /* access modifiers changed from: package-private */
        public final Object a() {
            return v.a((Collection<?>) this.f7562b, this.f7561a);
        }

        /* access modifiers changed from: package-private */
        public final void a(Class<?> cls, Object obj) {
            c.a(cls == this.f7561a);
            this.f7562b.add(obj);
        }
    }

    public b(Object obj) {
        this.f7560c = obj;
    }

    public final void a() {
        for (Map.Entry next : this.f7558a.entrySet()) {
            ((Map) this.f7560c).put(next.getKey(), ((a) next.getValue()).a());
        }
        for (Map.Entry next2 : this.f7559b.entrySet()) {
            j.a((Field) next2.getKey(), this.f7560c, ((a) next2.getValue()).a());
        }
    }

    public final void a(Field field, Class<?> cls, Object obj) {
        a aVar = this.f7559b.get(field);
        if (aVar == null) {
            aVar = new a(cls);
            this.f7559b.put(field, aVar);
        }
        aVar.a(cls, obj);
    }
}
